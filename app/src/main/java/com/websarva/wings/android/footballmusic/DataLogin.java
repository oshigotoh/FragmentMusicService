package com.websarva.wings.android.footballmusic;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by swift_k6uons1 on 2018/03/26.
 */

public final class DataLogin extends AsyncTask<String,Void,String> {

    LoginActivity loginActivity;

    StringBuilder result;

    public DataLogin(LoginActivity loginActivity) {
        this.loginActivity =  loginActivity;
    }

    @Override
    protected String doInBackground(String... urls) {
        // 取得したテキストを格納する変数
        result = new StringBuilder();
        // アクセス先URL
        String urlstr = urls[0];

        //コネクションの準備
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            URL url = new URL(urlstr);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            is = con.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            result = sb;



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // エラーが出ようと何であろうとコネクションを閉じる作業をする。
            if (con != null) {
                con.disconnect(); // コネクションが生きていたら、ディスコネクト。
            }
            if (is != null) {
                try {
                    is.close(); // 文字列読み込み機能が生きていたら（接続したままなら）閉じる。
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
/*


        HttpURLConnection con = null;
        try {

            URL url = new URL(urlstr);
            // ローカル処理
            // コネクション取得
            con = (HttpURLConnection) url.openConnection();
            con.connect();

            // HTTPレスポンスコード
            final int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                // 通信に成功した
                // テキストを取得する
                final InputStream in = con.getInputStream();
                System.out.println(in+"ふふふふふふふふふふふふふ");
                final String encoding = con.getContentEncoding();
                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);
                String line = null;
                // 1行ずつテキストを読み込む
                while((line = bufReader.readLine()) != null) {
                    result.append(line);
                    System.out.println(result);
                }
                bufReader.close();
                inReader.close();
                in.close();
            } else{
                System.out.println("コネクション失敗しました。");
            }

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (ProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (con != null) {
                // コネクションを切断
                con.disconnect();
            }
        }
        System.out.println(result);
        */

        System.out.println(result);
        return result.toString();

    }

    @Override
    protected void onPostExecute(String s) {
        System.out.print(s+"ああああああああああああ");
        if (s.equals("OK")) {

            loginActivity.ok();
        }else {
            Toast toast = Toast.makeText(loginActivity, "NG", Toast.LENGTH_LONG);
            toast.show();
        }


        super.onPostExecute(s);
    }
}



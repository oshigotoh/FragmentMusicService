package com.websarva.wings.android.footballmusic;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckActivity extends AppCompatActivity {
    //コンストラクタ
    String USERID;
    String PASSWORD;

    //必須URL String urlStr = "192.168.1.200:8080/MSF_handa/footmusic?userid="+ USERID +"&password="+ PASSWORD;
//192.168.1.200/MSF_handa/footmusic?userid=****&password=**** http://192.168.1.200:8080/MSF_handa/footmusic?userid=" + USERID + "&password=" + PASSWORD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        Intent intent = getIntent();
        //インスタンス化
        USERID = intent.getStringExtra("USER_ID");
        PASSWORD = intent.getStringExtra("PASS_WORD");
        System.out.println(USERID + "：" + PASSWORD);

    /*    try {
            new DataLogin().execute(new URL("http://192.168.1.200:8080/MSF_handa/footmusic?userid=aaa&password=aaa"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
   */ }
}
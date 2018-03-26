package com.websarva.wings.android.footballmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;


public class LoginActivity extends AppCompatActivity {

    LoginActivity loginActivity = this;

    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText = findViewById(R.id.UserID);
        editText2 = findViewById(R.id.Password);
        Button button = findViewById(R.id.Login);
        Button button2 = findViewById(R.id.NewID);

        button.setOnClickListener(new View.OnClickListener(){
            //ここではデータをCheckを送る
            @Override
            public void onClick(View v){
                String UserIdtext = editText.getText().toString();
                String Passwordtext = editText2.getText().toString();


                    new DataLogin(loginActivity).execute("http://192.168.1.200:8080/MSF_handa/footmusic?userid="+UserIdtext+"&password="+Passwordtext);




                /*
                Intent intent = new Intent(LoginActivity.this, CheckActivity.class);
                intent.putExtra("USER_ID",editText.getText().toString());
                intent.putExtra("PASS_WORD",editText2.getText().toString());
                startActivity(intent);
*/

            }
        });



    }

    public void ok (){

        Intent intent = new Intent(LoginActivity.this, CheckActivity.class);
        intent.putExtra("USER_ID",editText.getText().toString());
        intent.putExtra("PASS_WORD",editText2.getText().toString());
        startActivity(intent);
    }
    public void ng (){

        System.out.println("ログイン失敗しました。");
    }



}

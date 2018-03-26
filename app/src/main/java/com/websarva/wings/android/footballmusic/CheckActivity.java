package com.websarva.wings.android.footballmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckActivity extends AppCompatActivity {
//192.168.1.200/MSF_handa/footmusic?userid=****&password=****
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        Intent intent = getIntent();
        String USERID = intent.getStringExtra("USER_ID");
        String PASSWORD = intent.getStringExtra("PASS_WORD");
        System.out.println(USERID+"："+PASSWORD);

    }
}

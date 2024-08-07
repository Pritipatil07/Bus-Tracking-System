package com.example.aditya.bustrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class InitialScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td=new Thread(){
          public void run(){
              try {
                  sleep(5000);
              }
              catch (Exception e){
                  e.printStackTrace();
              }
              finally {
                  Intent intent=new Intent(InitialScreen.this,MainActivity.class);
                  startActivity(intent);
                  finish();
              }
          }
        };td.start();
    }
}
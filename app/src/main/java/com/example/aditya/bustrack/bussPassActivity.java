package com.example.aditya.bustrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class bussPassActivity extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buss_pass);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callstudent();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callsenior();
            }
        });

    }

    private void callsenior() {
        Intent i = new Intent(this,SeniorPassActivity.class);
        startActivity(i);
    }

    private void callstudent() {
        Intent i1=new Intent(this,StudentPassActivity.class);
        startActivity(i1);
    }
}
package com.example.aditya.bustrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboard extends AppCompatActivity {

    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               }
            });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callHelpdesk();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callFeedback();
            }
        });
    }

    private void callFeedback() {
        Intent i=new Intent(AdminDashboard.this,ShowFeedback.class);
        startActivity(i);
    }

    private void callHelpdesk() {
        Intent i = new Intent(AdminDashboard.this,ShowHelpdesk.class);
        startActivity(i);
    }
}
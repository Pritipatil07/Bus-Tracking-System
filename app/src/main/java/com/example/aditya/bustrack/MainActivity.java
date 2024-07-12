package com.example.aditya.bustrack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calladmin();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calldashboard();
            }
        });
    }

    private void calldashboard() {
        Intent i=new Intent(MainActivity.this,Dashboard.class);
        startActivity(i);
    }

    private void calladmin() {
        Intent i=new Intent(MainActivity.this,Admin.class);
        startActivity(i);
    }
}

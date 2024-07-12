package com.example.aditya.bustrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {

    EditText em,ps;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        em=findViewById(R.id.inputEm);
        ps=findViewById(R.id.inputPswd);
        log=findViewById(R.id.btnlogin);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pswd;
                email=em.getText().toString();
                pswd=ps.getText().toString();

                if((email.equals("admin")) && (pswd.equals("admin123")))
                {
                    Toast.makeText(Admin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    callDashboard();
                }
                else {
                    Toast.makeText(Admin.this, "Failed to login", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void callDashboard() {
        Intent i=new Intent(Admin.this,AdminDashboard.class);
        startActivity(i);
        finish();
    }
}
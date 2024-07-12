package com.example.aditya.bustrack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Register extends AppCompatActivity {
    private final static int RC_SIGN_IN =123 ;
    Button btn2_signup,google;
    EditText user_name, pass_word, cpswd;
    FirebaseAuth mAuth;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        pd = new ProgressDialog(this);
        TextView btn = findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLogin();
            }
        });

        user_name = findViewById(R.id.inputEm);
        pass_word = findViewById(R.id.inputUnm);
        cpswd = findViewById(R.id.inputPswd);
        btn2_signup = findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();
        btn2_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Registering user...");
                pd.show();
                String email = user_name.getText().toString().trim();
                String password = pass_word.getText().toString().trim();
                if (email.isEmpty()) {
                    pd.dismiss();
                    user_name.setError("Email is empty");
                    user_name.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    pd.dismiss();
                    user_name.setError("Enter the valid email address");
                    user_name.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    pd.dismiss();
                    pass_word.setError("Enter the password");
                    pass_word.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    pd.dismiss();
                    pass_word.setError("Length of the password should be more than 6");
                    pass_word.requestFocus();
                    return;
                }
                String pswd1 = pass_word.getText().toString();
                String pswd2 = cpswd.getText().toString();
                if (!pswd1.equals(pswd2)) {
                    pd.dismiss();
                    pass_word.setError("Passwords doesnt match!");
                }
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            pd.dismiss();
                            Toast.makeText(Register.this, "You are successfully Registered", Toast.LENGTH_SHORT).show();
                            callLogin();
                        } else {
                            pd.dismiss();
                            Toast.makeText(Register.this, "You are not Registered! Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
    private void callLogin() {
        startActivity(new Intent(Register.this,MainActivity.class));
    }
}
package com.example.aditya.bustrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class Helpdesk extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5,t6;
    Button b;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpdesk);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        b=findViewById(R.id.button);

        db=FirebaseFirestore.getInstance();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = t1.getText().toString();
                String s2 = t2.getText().toString();
                String s3 = t3.getText().toString();
                String s4 = t4.getText().toString();
                String s5 = t5.getText().toString();
                String s6 = t6.getText().toString();
                String id= UUID.randomUUID().toString();

                saveToFireStore(id,s1,s2,s3,s4,s5,s6);

            }
        });

    }

    private void saveToFireStore(String id,String s1, String s2, String s3, String s4, String s5, String s6) {
        if(!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty() && !s4.isEmpty() && !s5.isEmpty() && !s6.isEmpty()){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",id);
            map.put("name",s1);
            map.put("email",s2);
            map.put("mobile",s3);
            map.put("address",s4);
            map.put("subject",s5);
            map.put("complain",s6);

            db.collection("Helpdesk").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Helpdesk.this, "Data saved!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"Insertion failed!",Toast.LENGTH_LONG);
                }
            });
        }else{
            Toast.makeText(this, "Empty fields not allowed!", Toast.LENGTH_SHORT).show();
        }
    }
}
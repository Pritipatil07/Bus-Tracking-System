package com.example.aditya.bustrack;

import android.content.Intent;
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

public class SeniorPassActivity extends AppCompatActivity {

    EditText nm,ag,mob,ad,rnm;
    Button btnAddData;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_pass);

        nm=findViewById(R.id.t1);
        ag=findViewById(R.id.t2);
        mob=findViewById(R.id.t3);
        ad=findViewById(R.id.t4);
        rnm=findViewById(R.id.t5);
        btnAddData=findViewById(R.id.button);

        db=FirebaseFirestore.getInstance();

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nm.getText().toString();
                String age=ag.getText().toString();
                String mobile=mob.getText().toString();
                String addr=ad.getText().toString();
                String route=rnm.getText().toString();
                String id= UUID.randomUUID().toString();

                saveToFireStore(id,name,age,mobile,addr,route);

                Intent i = new Intent(SeniorPassActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });
    }

    private void saveToFireStore(String id, String name, String age, String mobile, String addr, String route) {
        if(!name.isEmpty() && !age.isEmpty() && !mobile.isEmpty() && !addr.isEmpty() && !route.isEmpty()){
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("id",id);
            map2.put("name",name);
            map2.put("age",age);
            map2.put("mobile",mobile);
            map2.put("address",addr);
            map2.put("route",route);

            db.collection("SeniorPass").document(id).set(map2)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SeniorPassActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"Insertion failed!",Toast.LENGTH_LONG).show();
                }
            });
        }else{
            Toast.makeText(this, "Empty fields not allowed!", Toast.LENGTH_SHORT).show();
        }
    }
}
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

public class StudentPassActivity extends AppCompatActivity {

    EditText nm,ag,mob,ad,cnm,cad,rnm;
    Button btnAddData;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_pass);

        nm=findViewById(R.id.editText1);
        ag=findViewById(R.id.editText2);
        mob=findViewById(R.id.editText3);
        ad=findViewById(R.id.editText4);
        cnm=findViewById(R.id.editText5);
        cad=findViewById(R.id.editText6);
        rnm=findViewById(R.id.editText7);
        btnAddData=findViewById(R.id.button);
        db=FirebaseFirestore.getInstance();

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nm.getText().toString();
                String age=ag.getText().toString();
                String mobile=mob.getText().toString();
                String addr=ad.getText().toString();
                String colnm=cnm.getText().toString();
                String colad=cad.getText().toString();
                String route=rnm.getText().toString();
                String id= UUID.randomUUID().toString();

                saveToFireStore(id,name,age,mobile,addr,colnm,colad,route);

                Intent i = new Intent(StudentPassActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });

    }

    private void saveToFireStore(String id, String name, String age, String mobile, String addr, String colnm, String colad, String route) {
        if(!name.isEmpty() && !age.isEmpty() && !mobile.isEmpty() && !addr.isEmpty() && !colnm.isEmpty() && !colad.isEmpty() && !route.isEmpty()){
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("id",id);
            map2.put("name",name);
            map2.put("age",age);
            map2.put("mobile",mobile);
            map2.put("address",addr);
            map2.put("collegename",colnm);
            map2.put("collegeaddr",colad);
            map2.put("route",route);

            db.collection("StudentPass").document(id).set(map2)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(StudentPassActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();
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
package com.example.aditya.bustrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class Feedback extends AppCompatActivity {

    Button sub;
    RadioGroup rg1,rg2;
    RadioButton b1,b2;
    EditText mob,veh,dt,desc;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        rg1=findViewById(R.id.radioGroup1);
        mob=findViewById(R.id.editTextTextPersonName);
        veh=findViewById(R.id.editTextTextPersonName2);
        dt=findViewById(R.id.editTextDate);
        desc=findViewById(R.id.editTextTextMultiLine);
        rg2=findViewById(R.id.radioGroup);
        sub=findViewById(R.id.button6);

        db=FirebaseFirestore.getInstance();

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mb=mob.getText().toString();
                String v=veh.getText().toString();
                String d=dt.getText().toString();
                String de=desc.getText().toString();
                int id=rg1.getCheckedRadioButtonId();
                b1=findViewById(id);
                String type=b1.getText().toString();

                int id2=rg2.getCheckedRadioButtonId();
                b2=findViewById(id2);
                String feed=b2.getText().toString();

                String idx= UUID.randomUUID().toString();

                saveToFireStore(idx,type,mb,v,d,feed,de);

                }
        });
    }
    private void saveToFireStore(String id,String type, String mob,String veh,String date, String feed, String desc) {
        if(!type.isEmpty() && !mob.isEmpty() && !veh.isEmpty() && !date.isEmpty() && !feed.isEmpty() && !desc.isEmpty()){
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("id",id);
            map1.put("type",type);
            map1.put("mobile",mob);
            map1.put("Vehicleno",veh);
            map1.put("date",date);
            map1.put("feedback",feed);
            map1.put("description",desc);

            db.collection("Feedback").document(id).set(map1)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Feedback.this, "Data saved!", Toast.LENGTH_SHORT).show();
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
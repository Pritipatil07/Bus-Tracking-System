package com.example.aditya.bustrack;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowHelpdesk extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private MyAdapter adapter;
    private List<Model1> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_helpdesk);

        recyclerView=findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db=FirebaseFirestore.getInstance();

        list=new ArrayList<>();
        adapter=new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        showData();

    }

    private void showData() {
        db.collection("Helpdesk").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()){
                            Model1 model=new Model1(snapshot.getString("id"),snapshot.getString("name"),snapshot.getString("email"),snapshot.getString("mobile"),snapshot.getString("address"),snapshot.getString("subject"),snapshot.getString("complain"));
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShowHelpdesk.this, "Oops.. Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
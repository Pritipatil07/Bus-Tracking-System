package com.example.aditya.bustrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowFeedback extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private MyAdapter2 adapter2;
    private List<Model2> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_feedback);

        recyclerView=findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db=FirebaseFirestore.getInstance();
        list2 = new ArrayList<>();
        adapter2 = new MyAdapter2(this,list2);
        recyclerView.setAdapter(adapter2);

        ShowFeed();
    }

    private void ShowFeed() {
        db.collection("Feedback").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list2.clear();
                        for (DocumentSnapshot snapshot : task.getResult()){
                           Model2 model2 = new Model2(snapshot.getString("id"), snapshot.getString("type"),snapshot.getString("mobile"),snapshot.getString("Vehicleno"),snapshot.getString("date"),snapshot.getString("feedback"),snapshot.getString("description"));
                           list2.add(model2);
                        }
                        adapter2.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShowFeedback.this, "Oops.. Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
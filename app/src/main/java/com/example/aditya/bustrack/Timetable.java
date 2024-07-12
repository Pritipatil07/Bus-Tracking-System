package com.example.aditya.bustrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Timetable extends AppCompatActivity {

    ListView lv;
    String routes[]={"100 - Hinjewadi to Manapa","353 - Bhosari to Shikrapur phata","298 - Chinchwadgaon to katraj",
            "348 - Nigdi to Pune station","322 - Manapa to Akurdi Railway Station","35 - Manapa to Mukai chowk",
            "36 - Chinchwadgaon to Manapa","42 - Nigdi to Katraj","43 - Nigdi to Katraj Bypass"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        lv=findViewById(R.id.listview);
        ArrayAdapter<String> ap=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,routes);
        lv.setAdapter(ap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected=routes[i];
                Intent i1=new Intent(Timetable.this,DisplayTime.class);
                i1.putExtra("route",routes[i]);
                startActivity(i1);
            }
        });

    }
}
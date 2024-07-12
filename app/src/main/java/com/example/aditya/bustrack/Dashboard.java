package com.example.aditya.bustrack;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    SupportMapFragment smf;
    FusedLocationProviderClient client;
    Button button5,button4,pass,button3,button1;
    Toolbar toolbar;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calltrack();
            }
        });


        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calltimetable();
            }
        });

        button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callHelp();
            }
        });

        toolbar=findViewById(R.id.toollbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        pass=findViewById(R.id.button2);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callpass();
            }
        });

        button5 = (Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFeedback();
            }
        });
    }

    private void calltrack() {
        Intent i=new Intent(Dashboard.this,LoginActivity.class);
        startActivity(i);
    }

    private void calltimetable() {
        Intent i=new Intent(Dashboard.this,Timetable.class);
        startActivity(i);
    }

    private void callpass() {
        Intent i=new Intent(Dashboard.this,bussPassActivity.class);
        startActivity(i);
    }
    private void callLogout() {
        Toast.makeText(this, "Logging out!", Toast.LENGTH_SHORT).show();
        mFirebaseAuth.signOut();
    }

    private void callHelp() {
        Intent i =new Intent(Dashboard.this, Helpdesk.class);
        startActivity(i);
    }

    private void getFeedback() {
        Intent i = new Intent(Dashboard.this, Feedback.class);
        startActivity(i);
    }

    public void getmylocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = client.getLastLocation();
        /*task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(final Location location) {
                smf.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());
                        MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("You are here...!!");

                        googleMap.addMarker(markerOptions);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));
                    }
                });
            }
        });*/
    }
}
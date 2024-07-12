package com.example.aditya.bustrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fevziomurtekin.payview.Payview;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on below line we are creating a variable
        // for our pay view and initializing it.
        Payview payview = findViewById(R.id.payview);

        // on below line we are setting pay on listener for our card.
        payview.setPayOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // after clicking on pay we are displaying toast message as card added.
                Toast.makeText(PaymentActivity.this, "Card Added. ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

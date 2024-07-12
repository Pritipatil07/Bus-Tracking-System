package com.example.aditya.bustrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayTime extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    TextView s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;

    String[] arr1 ={"6.40","8.15","9.45","11.00","12.30","1.45","3.00","4.50","5.30","6.45","8.00","9.30"};
    String[] stop1={"1      Hinjewadi         6.40","2      Infosys             6.51","3      Siemens           7.01","4      Wakad               7.14","5      Rakshak           7.29"
        ,"6      Aundh               7.37","7      Bremen             7.39","8      Vidyapeeth        7.48","9      COEP                  7.58","10     Manapa             8.02"};
    String[] arr2 ={"6.00","8.00","11.00","1.00","3.00","5.00","7.00","9.00","9.30","10.00","11.00","11.30"};
    String[] arr3 ={"9.00","10.00","11.00","12.00","3.00","5.00","7.00","9.00","9.30","10.00","11.00","11.30"};
    String[] arr4 ={"8.00","9.40","11.00","1.30","2.50","4.00","6.30","8.00","9.30","10.45","11.15","11.50"};
    String[] arr5 ={"7.30","8.45","11.45","1.30","3.45","5.30","6.45","8.30","9.30","10.00","11.00","11.30"};
    String[] arr6 ={"7.00","8.15","9.45","11.00","12.30","1.45","3.00","4.50","5.30","6.45","8.00","9.30"};
    String[] arr7 ={"6.00","8.00","11.00","1.00","3.00","5.00","7.00","9.00","9.30","10.00","11.00","11.30"};
    String[] arr8 ={"9.00","10.00","11.00","12.00","3.00","5.00","7.00","9.00","9.30","10.00","11.00","11.30"};
    String[] arr9 ={"7.30","8.45","11.45","1.30","3.45","5.30","6.45","8.30","9.30","10.00","11.00","11.30"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_time);

        t1=findViewById(R.id.time1);
        t2=findViewById(R.id.time2);
        t3=findViewById(R.id.time3);
        t4=findViewById(R.id.time4);
        t5=findViewById(R.id.time5);
        t6=findViewById(R.id.time6);
        t7=findViewById(R.id.time7);
        t8=findViewById(R.id.time8);
        t9=findViewById(R.id.time9);
        t10=findViewById(R.id.time10);
        t11=findViewById(R.id.time11);
        t12=findViewById(R.id.time12);

        s1=findViewById(R.id.textView14);
        s2=findViewById(R.id.textView15);
        s3=findViewById(R.id.textView16);
        s4=findViewById(R.id.textView17);
        s5=findViewById(R.id.textView18);
        s6=findViewById(R.id.textView19);
        s7=findViewById(R.id.textView20);
        s8=findViewById(R.id.textView21);
        s9=findViewById(R.id.textView22);
        s10=findViewById(R.id.textView23);

        Intent i=getIntent();
        String sel=i.getStringExtra("route");


        if(sel.equals("100 - Hinjewadi to Manapa")){
            t1.setText(arr1[0]);
            t2.setText(arr1[1]);
            t3.setText(arr1[2]);
            t4.setText(arr1[3]);
            t5.setText(arr1[4]);
            t6.setText(arr1[5]);
            t7.setText(arr1[6]);
            t8.setText(arr1[7]);
            t9.setText(arr1[8]);
            t10.setText(arr1[9]);
            t11.setText(arr1[10]);
            t12.setText(arr1[11]);

            s1.setText(stop1[0]);
            s2.setText(stop1[1]);
            s3.setText(stop1[2]);
            s4.setText(stop1[3]);
            s5.setText(stop1[4]);
            s6.setText(stop1[5]);
            s7.setText(stop1[6]);
            s8.setText(stop1[7]);
            s9.setText(stop1[8]);
            s10.setText(stop1[9]);

        }
        if(sel.equals("353 - Bhosari to Shikrapur phata")){
            t1.setText(arr2[0]);
            t2.setText(arr2[1]);
            t3.setText(arr2[2]);
            t4.setText(arr2[3]);
            t5.setText(arr2[4]);
            t6.setText(arr2[5]);
            t7.setText(arr2[6]);
            t8.setText(arr2[7]);
            t9.setText(arr2[8]);
            t10.setText(arr2[9]);
            t11.setText(arr2[10]);
            t12.setText(arr2[11]);
        }
        if(sel.equals("298 - Chinchwadgaon to katraj")){
            t1.setText(arr3[0]);
            t2.setText(arr3[1]);
            t3.setText(arr3[2]);
            t4.setText(arr3[3]);
            t5.setText(arr3[4]);
            t6.setText(arr3[5]);
            t7.setText(arr3[6]);
            t8.setText(arr3[7]);
            t9.setText(arr3[8]);
            t10.setText(arr3[9]);
            t11.setText(arr3[10]);
            t12.setText(arr3[11]);
        }
        if(sel.equals("348 - Nigdi to Pune station")){
            t1.setText(arr4[0]);
            t2.setText(arr4[1]);
            t3.setText(arr4[2]);
            t4.setText(arr4[3]);
            t5.setText(arr4[4]);
            t6.setText(arr4[5]);
            t7.setText(arr4[6]);
            t8.setText(arr4[7]);
            t9.setText(arr4[8]);
            t10.setText(arr4[9]);
            t11.setText(arr4[10]);
            t12.setText(arr4[11]);
        }
        if(sel.equals("322 - Manapa to Akurdi Railway Station")){
            t1.setText(arr5[0]);
            t2.setText(arr5[1]);
            t3.setText(arr5[2]);
            t4.setText(arr5[3]);
            t5.setText(arr5[4]);
            t6.setText(arr5[5]);
            t7.setText(arr5[6]);
            t8.setText(arr5[7]);
            t9.setText(arr5[8]);
            t10.setText(arr5[9]);
            t11.setText(arr5[10]);
            t12.setText(arr5[11]);
        }
        if(sel.equals("35 - Manapa to Mukai chowk")){
            t1.setText(arr6[0]);
            t2.setText(arr6[1]);
            t3.setText(arr6[2]);
            t4.setText(arr6[3]);
            t5.setText(arr6[4]);
            t6.setText(arr6[5]);
            t7.setText(arr6[6]);
            t8.setText(arr6[7]);
            t9.setText(arr6[8]);
            t10.setText(arr6[9]);
            t11.setText(arr6[10]);
            t12.setText(arr6[11]);
        }
        if(sel.equals("36 - Chinchwadgaon to Manapa")){
            t1.setText(arr7[0]);
            t2.setText(arr7[1]);
            t3.setText(arr7[2]);
            t4.setText(arr7[3]);
            t5.setText(arr7[4]);
            t6.setText(arr7[5]);
            t7.setText(arr7[6]);
            t8.setText(arr7[7]);
            t9.setText(arr7[8]);
            t10.setText(arr7[9]);
            t11.setText(arr7[10]);
            t12.setText(arr7[11]);
        }
        if(sel.equals("42 - Nigdi to Katraj")){
            t1.setText(arr8[0]);
            t2.setText(arr8[1]);
            t3.setText(arr8[2]);
            t4.setText(arr8[3]);
            t5.setText(arr8[4]);
            t6.setText(arr8[5]);
            t7.setText(arr8[6]);
            t8.setText(arr8[7]);
            t9.setText(arr8[8]);
            t10.setText(arr8[9]);
            t11.setText(arr8[10]);
            t12.setText(arr8[11]);
        }
        if(sel.equals("43 - Nigdi to Katraj Bypass")){
            t1.setText(arr9[0]);
            t2.setText(arr9[1]);
            t3.setText(arr9[2]);
            t4.setText(arr9[3]);
            t5.setText(arr9[4]);
            t6.setText(arr9[5]);
            t7.setText(arr9[6]);
            t8.setText(arr9[7]);
            t9.setText(arr9[8]);
            t10.setText(arr9[9]);
            t11.setText(arr9[10]);
            t12.setText(arr9[11]);
        }

    }
}

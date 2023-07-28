package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DonateditemsDisplay extends AppCompatActivity {

    private TextView textView,t1,t2;
    private Button requestbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donateditems_display);
       // requestbtn = findViewById(R.id.reqestbtn1);
       // requestbtn.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
           //     opennnnactivity();
         //   }
       // });

        textView = findViewById(R.id.tt1);
        t1 = findViewById(R.id.tt2);
        t2 = findViewById(R.id.tt3);

        textView.setText(getIntent().getStringExtra("bookname"));
        t1.setText(getIntent().getStringExtra("Authorname"));
        t2.setText(getIntent().getStringExtra("Edition"));


    }

}
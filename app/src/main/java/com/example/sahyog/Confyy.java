package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Confyy extends AppCompatActivity {

    private TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confyy);
        t1 = findViewById(R.id.textView199);
        t2 = findViewById(R.id.textView30);
        t3 = findViewById(R.id.textView32);

        t1.setText(getIntent().getStringExtra("itemname"));
        t2.setText(getIntent().getStringExtra("phoneno"));
        t3.setText(getIntent().getStringExtra("address"));
    }
}
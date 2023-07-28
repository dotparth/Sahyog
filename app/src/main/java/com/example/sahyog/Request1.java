package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Request1 extends AppCompatActivity {


    private Button buttony;
    private Button buttonz;
    private Button buttonx;
    private Button buttonp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request1);

        buttony = (Button) findViewById(R.id.bookbtn);
        buttonz = (Button) findViewById(R.id.clothbtn);
        buttonx = (Button) findViewById(R.id.foodbtn);
        buttonp = (Button) findViewById(R.id.elecbtn);
        buttonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElecreq();
            }
        });
        buttonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfoodreq();
            }
        });
        buttonz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openclothreq();
            }
        });
        buttony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbookreq();
            }
        });
    }

    public void openbookreq()
    {
        Intent intent = new Intent(Request1.this, Request2.class);
        startActivity(intent);
    }

    public void openclothreq()
    {
        Intent intent = new Intent (Request1.this, Request3.class);
        startActivity(intent);
    }
    public void openfoodreq()
    {
        Intent intent = new Intent (Request1.this, Request4.class);
        startActivity(intent);

    }
    public void openElecreq()
    {
        Intent intent = new Intent (Request1.this, Request5.class);
        startActivity(intent);
    }
}
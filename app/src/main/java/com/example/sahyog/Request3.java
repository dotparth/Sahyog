package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Request3 extends AppCompatActivity {
    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request3);
        btn = (Button) findViewById(R.id.MenButton1);
        btn1 = (Button) findViewById(R.id.WomenButton1);
        btn2 = (Button) findViewById(R.id.KidsButton1);
        btn3 = (Button) findViewById(R.id.AllButton1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openclothall();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkidreq();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwomenreq();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmenreq();
            }
        });
    }

    public void openmenreq() {
        Intent intent = new Intent(Request3.this, Reqmen.class);
        startActivity(intent);

    }

    public void openwomenreq() {
        Intent intent = new Intent (Request3.this, Reqwomen.class);
        startActivity(intent);
    }
    public void openkidreq() {
        Intent intent = new Intent (Request3.this, Reqkids.class);
        startActivity(intent);
    }
    public void openclothall() {
        Intent intent = new Intent (Request3.this, Reqclothall.class);
        startActivity(intent);
    }


}
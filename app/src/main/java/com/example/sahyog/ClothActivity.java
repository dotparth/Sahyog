package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClothActivity extends AppCompatActivity {
    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);
        btn = findViewById(R.id.MenButton);
        btn1 = findViewById(R.id.WomenButton);
        btn2 = findViewById(R.id.KidsButton);
        btn3 = findViewById(R.id.AllButton);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivitydonateall();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivitykids();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivitywomen();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivitymen();
            }
        });
    }

    public  void openMainActivitymen()
    {
        Intent intent = new Intent(ClothActivity.this, Clothmen.class);
        startActivity(intent);
    }
    public  void openMainActivitywomen()
    {
        Intent intent = new Intent (ClothActivity.this, Clothwomen.class);
        startActivity(intent);
    }

    public void openMainActivitykids()
    {
        Intent intent = new Intent(ClothActivity.this, Clothkids.class);
        startActivity(intent);
    }
    public void openMainActivitydonateall()
    {
        Intent intent = new Intent(ClothActivity.this, Clothsall.class);
        startActivity(intent);
    }
}
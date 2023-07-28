package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DonateAll extends AppCompatActivity {

    private Button buttony;
    private Button buttonz;
    private Button buttonx;
    private Button buttonp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_all2);
        buttony = (Button) findViewById(R.id.button15);
        buttonz = (Button) findViewById(R.id.button14);
        buttonx = (Button) findViewById(R.id.button16);
        buttonp = (Button) findViewById(R.id.button17);
        buttonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElectronicsActivity();
            }
        });
        buttonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfoodActivity();
            }
        });
        buttonz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity8();
            }
        });
        buttony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity7();
            }
        });
    }

    public void openMainActivity7()
    {
        Intent intent = new Intent(this, BookActivity1.class);
        startActivity(intent);
    }

    public void openMainActivity8()
    {
        Intent intent = new Intent (this, ClothActivity.class);
        startActivity(intent);
    }
    public void openfoodActivity()
    {
        Intent intent = new Intent (DonateAll.this, FoodActivity.class);
        startActivity(intent);

    }
    public void openElectronicsActivity()
    {
        Intent intent = new Intent (DonateAll.this, ElectronicsActivity.class);
        startActivity(intent);
    }
}
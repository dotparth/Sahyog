package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UltraMain extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra_main);

        btn = findViewById(R.id.ultrabutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainact();
            }
        });
    }

    public void openmainact() {

        Intent intent = new Intent(UltraMain.this, MainActivity.class);
        startActivity(intent);
    }
}
package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Clothkids extends AppCompatActivity {
    Spinner spincat;
    EditText size, quantity, condition, phone, add;
    Button btn;

    DatabaseReference kidsdata;
    FirebaseDatabase rootnode2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothkids);
        spincat = findViewById(R.id.category4);
        size = findViewById(R.id.size2);
        quantity = findViewById(R.id.quant2);
        condition = findViewById(R.id.condi2);
        phone = findViewById(R.id.ph2);
        add = findViewById(R.id.add2);
        btn = findViewById(R.id.DON3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootnode2 = FirebaseDatabase.getInstance();
                kidsdata = rootnode2.getReference("clothkids");

                String categorystr = spincat.getSelectedItem().toString();
                String sizestr = size.getText().toString();
                String quantitystr = quantity.getText().toString();
                String conditionstr = condition.getText().toString();
                String adstr = add.getText().toString();
                String phonestr = phone.getText().toString();

                Kids clothss = new Kids(categorystr,sizestr,quantitystr,conditionstr,adstr,phonestr);
                kidsdata.child(phonestr).setValue(clothss);

                Toast.makeText(Clothkids.this, "Donation Added", Toast.LENGTH_SHORT).show();

                //    clothsdata.setValue("Cloths Data");




            }
        });
    }
}




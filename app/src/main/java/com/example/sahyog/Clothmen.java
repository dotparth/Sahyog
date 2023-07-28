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

public class Clothmen extends AppCompatActivity {
    Spinner spincat;
    EditText size, quantity, condition, phone, add;
    Button btn;


    DatabaseReference clothsdata;
    FirebaseDatabase rootnode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothmen);
        spincat = findViewById(R.id.category2);
        size = findViewById(R.id.size);
        quantity = findViewById(R.id.quant);
        condition = findViewById(R.id.condi);
        phone = findViewById(R.id.ph);
        add = findViewById(R.id.add);
        btn = findViewById(R.id.DON);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootnode = FirebaseDatabase.getInstance();
                clothsdata = rootnode.getReference("clothsmen");

                String categorystr = spincat.getSelectedItem().toString();
                String sizestr = size.getText().toString();
                String quantitystr = quantity.getText().toString();
                String conditionstr = condition.getText().toString();
                String adstr = add.getText().toString();
                String phonestr = phone.getText().toString();

                Cloths clothss = new Cloths(categorystr,sizestr,quantitystr,conditionstr,adstr,phonestr);
                clothsdata.child(phonestr).setValue(clothss);

                Toast.makeText(Clothmen.this, "Donation Added", Toast.LENGTH_SHORT).show();

            //    clothsdata.setValue("Cloths Data");




            }
        });
    }
}


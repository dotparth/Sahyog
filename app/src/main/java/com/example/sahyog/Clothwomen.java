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

public class Clothwomen extends AppCompatActivity {
    Spinner spincat;
    EditText size, quantity, condition, phone, add;
    Button btn;

    DatabaseReference clothswomendata;
    FirebaseDatabase rootnode1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothwomen);
        spincat = findViewById(R.id.category3);
        size = findViewById(R.id.size1);
        quantity = findViewById(R.id.quant1);
        condition = findViewById(R.id.condi1);
        phone = findViewById(R.id.ph1);
        add = findViewById(R.id.add1);
        btn = findViewById(R.id.DON1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootnode1 = FirebaseDatabase.getInstance();
                clothswomendata = rootnode1.getReference("clothwomen");

                String categorystr = spincat.getSelectedItem().toString();
                String sizestr = size.getText().toString();
                String quantitystr = quantity.getText().toString();
                String conditionstr = condition.getText().toString();
                String adstr = add.getText().toString();
                String phonestr = phone.getText().toString();

                Clothswomen clothss = new Clothswomen(categorystr,sizestr,quantitystr,conditionstr,adstr,phonestr);
                clothswomendata.child(phonestr).setValue(clothss);

                Toast.makeText(Clothwomen.this, "Donation Added", Toast.LENGTH_SHORT).show();

                //    clothsdata.setValue("Cloths Data");




            }
        });
    }
}

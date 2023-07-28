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

public class ElectronicsActivity extends AppCompatActivity {
    Spinner spincat;
    EditText type, quantity, phone, add;
    Button btn;

    DatabaseReference elecdata;
    FirebaseDatabase rootnode9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        spincat = findViewById(R.id.category8);
        type = findViewById(R.id.type8);
        quantity = findViewById(R.id.quant8);
        phone = findViewById(R.id.ph8);
        add = findViewById(R.id.add8);
        btn = findViewById(R.id.DON8);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootnode9 = FirebaseDatabase.getInstance();
                elecdata = rootnode9.getReference("Electronics");

                String categorystr = spincat.getSelectedItem().toString();
                String typestr = type.getText().toString();
                String quantitystr = quantity.getText().toString();
                String adstr = add.getText().toString();
                String phonestr = phone.getText().toString();

                Electronics elec = new Electronics(categorystr,typestr,quantitystr,adstr,phonestr);
                elecdata.child(phonestr).setValue(elec);

                Toast.makeText(ElectronicsActivity.this, "Donation Added", Toast.LENGTH_SHORT).show();


                //    clothsdata.setValue("Cloths Data");




            }
        });
    }
}

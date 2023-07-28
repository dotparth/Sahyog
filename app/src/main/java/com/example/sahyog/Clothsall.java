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

public class Clothsall extends AppCompatActivity {

    Spinner spincat;
    EditText size, quantity, condition, phone, add, type;
    Button btn;

    DatabaseReference calldata;
    FirebaseDatabase rootnode3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothsall);

        spincat = findViewById(R.id.category5);
        type = findViewById(R.id.editTextTextPersonName3);
        size = findViewById(R.id.size5);
        quantity = findViewById(R.id.quant5);
        condition = findViewById(R.id.condi5);
        phone = findViewById(R.id.ph5);
        add = findViewById(R.id.add5);
        btn = findViewById(R.id.DON5);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  rootnode3 = FirebaseDatabase.getInstance();
                //
                // calldata = rootnode3.getReference("clothsall");
                calldata = FirebaseDatabase.getInstance().getReference().child("sbkecloths");
                String categorystr = spincat.getSelectedItem().toString();
                String typestr = type.getText().toString();
                String sizestr = size.getText().toString();
                String quantitystr = quantity.getText().toString();
                String conditionstr = condition.getText().toString();
                String adstr = add.getText().toString();
                String phonestr = phone.getText().toString();

                Allcloths clothss = new Allcloths(categorystr,typestr,sizestr,quantitystr,conditionstr,adstr,phonestr);
              //
             //   calldata.child(postID).setValue(clothss);
               calldata.push().setValue(clothss);

                Toast.makeText(Clothsall.this, "Donation Added", Toast.LENGTH_SHORT).show();

                //    clothsdata.setValue("Cloths Data");




            }
        });
    }
}

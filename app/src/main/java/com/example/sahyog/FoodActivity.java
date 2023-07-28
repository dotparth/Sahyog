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

public class FoodActivity extends AppCompatActivity {
    Spinner spincat;
    EditText type, quantity, phone, add;
    Button btn;

    DatabaseReference fooddata;
    FirebaseDatabase rootnode6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        spincat = findViewById(R.id.category6);
        type = findViewById(R.id.type6);
        quantity = findViewById(R.id.quant6);
        phone = findViewById(R.id.ph6);
        add = findViewById(R.id.add6);
        btn = findViewById(R.id.DON6);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootnode6 = FirebaseDatabase.getInstance();
                fooddata = rootnode6.getReference("food");

                String categorystr = spincat.getSelectedItem().toString();
                String typestr = type.getText().toString();
                String quantitystr = quantity.getText().toString();
                String adstr = add.getText().toString();
                String phonestr = phone.getText().toString();

                food foodss = new food(categorystr,typestr,quantitystr,adstr,phonestr);
                fooddata.child(phonestr).setValue(foodss);

                Toast.makeText(FoodActivity.this, "Donation Added", Toast.LENGTH_SHORT).show();


                //    clothsdata.setValue("Cloths Data");




            }
        });
    }
}

package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookActivity1 extends AppCompatActivity {
    EditText  name, author, edition, quantity, Address;
    TextView Phone;
    Spinner Category;
    Button button;
    DatabaseReference bookdata;
    FirebaseDatabase rootnode7;
    Books books;

    FirebaseUser currentuser2;
    FirebaseAuth mAuth2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);

        mAuth2 = FirebaseAuth.getInstance(); //zzzzzzzzzz
        currentuser2 = mAuth2.getCurrentUser();  //zzzzzzzzz

        Category = findViewById(R.id.Category);
        name = findViewById(R.id.Bookname);
        edition = findViewById(R.id.Edition);
        author = findViewById(R.id.Auth_name);
        quantity = findViewById(R.id.Quantity);
        Phone = findViewById(R.id.Phone);
        Phone.setText(currentuser2.getEmail()); //zzzzzzzzzzzzzz
        Address = findViewById(R.id.Address);
        button = findViewById(R.id.Save);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             //   rootnode7 = FirebaseDatabase.getInstance();
              //  bookdata = rootnode7.getReference("Book");
                bookdata = FirebaseDatabase.getInstance().getReference().child("Book");


               String categorystr = Category.getSelectedItem().toString();
                String namestr = name.getText().toString();
                String editionstr = edition.getText().toString();
                String authorstr = author.getText().toString();
                String quantitystr = quantity.getText().toString();
                String phonestr = Phone.getText().toString();
                String addstr = Address.getText().toString();

                if (TextUtils.isEmpty(namestr)) {
                    Toast.makeText(BookActivity1.this, "Please Enter Bookname", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(editionstr)) {
                    Toast.makeText(BookActivity1.this, "Please Enter Book Edition", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (TextUtils.isEmpty(authorstr)) {
                    Toast.makeText(BookActivity1.this, "Please Enter Book's Author", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (TextUtils.isEmpty(quantitystr)) {
                    Toast.makeText(BookActivity1.this, "Please Enter Book quantity", Toast.LENGTH_SHORT).show();
                    return;

                }




                Books clothss = new Books(categorystr,namestr,editionstr,quantitystr,authorstr,addstr,phonestr);
                // bookdata.child(phonestr).setValue(clothss);
                bookdata.push().setValue(clothss);

                Toast.makeText(BookActivity1.this, "Donation Added", Toast.LENGTH_SHORT).show();

                //    clothsdata.setValue("Cloths Data");




            }
        });
    }
}

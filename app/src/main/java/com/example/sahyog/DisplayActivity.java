package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayActivity extends AppCompatActivity {

    private TextView textView,t1,t2,t3, t4,t5;
    private Button requestbtn;

    DatabaseReference display;
    //newwbelow

    FirebaseUser currentuser3;
    FirebaseAuth mAuth3;
  


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        requestbtn = findViewById(R.id.reqestbtn);

        mAuth3 = FirebaseAuth.getInstance();
        currentuser3 = mAuth3.getCurrentUser();

        textView = findViewById(R.id.textView5);
        t1 = findViewById(R.id.textView6);
        t2 = findViewById(R.id.textView7);
        t3 = findViewById(R.id.textView11);
        //2,6
        t4 = findViewById(R.id.ph666);
        t4.setText(currentuser3.getEmail());

        t5 = findViewById(R.id.donorophono);

        //zzzzzz

       // emaill = findViewById(R.id.emailview);

        textView.setText(getIntent().getStringExtra("bookname"));
        t1.setText(getIntent().getStringExtra("Authorname"));
        t2.setText(getIntent().getStringExtra("Edition"));
        t3.setText(getIntent().getStringExtra("Author"));
        t5.setText(getIntent().getStringExtra("Donorphone"));


        requestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                display = FirebaseDatabase.getInstance().getReference().child("Donorreq");

                String bookoo = textView.getText().toString();
                String eddo = t1.getText().toString();
                String authho = t2.getText().toString();
                String reqpho = t4.getText().toString();
                String donpho = t5.getText().toString();

                Display1 display1 = new Display1(bookoo,eddo,authho,reqpho,donpho);
                display.push().setValue(display1);

             //   openrequestingbookact();

                Toast.makeText(DisplayActivity.this, "Book requested!", Toast.LENGTH_SHORT).show();







            }
        });



    }

   // public void openrequestingbookact()
  //  {
   //     Intent intent = new Intent(DisplayActivity.this, Requestbooks.class);
  //      startActivity(intent);
  //  }
}

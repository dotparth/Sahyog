package com.example.sahyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

//import kotlinx.coroutines.scheduling.Task;

public class Dissplayy extends AppCompatActivity {
    TextView x1,x2,x3,x4;
    Button bttn1, bttn2;
    DatabaseReference acdata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dissplayy);

        x1 = findViewById(R.id.textView17);
        x2 = findViewById(R.id.textView18);
        x3  = findViewById(R.id.editTextPhone);
        x4 = findViewById(R.id.editTextTextMultiLine);
        bttn1 = findViewById(R.id.button2);
        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acdata = FirebaseDatabase.getInstance().getReference().child("Accept");
                String Itemname = x1.getText().toString();
                String  Requester = x2.getText().toString();
                String Phoneno = x3.getText().toString();
                String Address = x4.getText().toString();

                if (TextUtils.isEmpty(Phoneno)) {
                    Toast.makeText(Dissplayy.this, "Please Enter Your Phone", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (TextUtils.isEmpty(Address)) {
                    Toast.makeText(Dissplayy.this, "Please Enter Your Address", Toast.LENGTH_SHORT).show();
                    return;

                }


                Display2 display2 = new Display2(Itemname,Requester,Phoneno,Address);
              //  acdata.push().setValue(display2);

                Toast.makeText(Dissplayy.this, "Request Approved!", Toast.LENGTH_SHORT).show();
                //newwwwbelooo

                acdata.push().setValue(display2).addOnCompleteListener(Dissplayy.this, task ->

                        {

                            if(task.isSuccessful())  {



                               // FirebaseDatabase.getInstance().getReference("Donorreq").removeValue();
                                DatabaseReference reference1 =  (DatabaseReference) FirebaseDatabase.getInstance().getReference("Donorreq");

                                Query query1 = reference1.orderByChild("bookoo").equalTo(Itemname);
                                query1.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        for(DataSnapshot childsnapshot: snapshot.getChildren())
                                        {
                                            String clubkey1 = childsnapshot.getKey();
                                            DatabaseReference refff = FirebaseDatabase.getInstance().getReference("Donorreq").child(clubkey1);
                                            Task<Void> ctask = refff.removeValue();

                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });




                            }

                        }




                        );
                

            }
        });
        bttn2 = findViewById(R.id.buttton2);
        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acdata = FirebaseDatabase.getInstance().getReference().child("Decline");
                String Itemname = x1.getText().toString();
                String Requester = x2.getText().toString();

                Display4 display4 = new Display4(Itemname, Requester);
              //  acdata.push().setValue(display4);

                Toast.makeText(Dissplayy.this, "Request Declined!", Toast.LENGTH_SHORT).show();

                //ultranewbelow

              acdata.push().setValue(display4).addOnCompleteListener(Dissplayy.this, task -> {
                  if(task.isSuccessful())  {



                    //
                      //  FirebaseDatabase.getInstance().getReference("Donorreq").removeValue();
                     DatabaseReference reference = (DatabaseReference) FirebaseDatabase.getInstance().getReference("Donorreq");






                     Query query = reference.orderByChild("bookoo").equalTo(Itemname);
                     query.addListenerForSingleValueEvent(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                             for(DataSnapshot childsnapshot: snapshot.getChildren())
                             {
                                 String clubkey = childsnapshot.getKey();
                             //    Toast.makeText(Dissplayy.this, clubkey, Toast.LENGTH_SHORT).show();
                                 DatabaseReference reff = FirebaseDatabase.getInstance().getReference("Donorreq").child(clubkey);
                                 Task<Void> ntask = reff.removeValue();


                             }
                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {

                         }
                     });













                  }
                      }

                      );

            }
        });

        x1.setText(getIntent().getStringExtra("Itemname"));
        x2.setText(getIntent().getStringExtra("reqemail"));



    }


}
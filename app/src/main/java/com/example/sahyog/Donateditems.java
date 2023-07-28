package com.example.sahyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Donateditems extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Donateditemadapter adapter;
    ArrayList<Donateditemdata> list;
    TextView ttt;


    FirebaseUser currentuser4;
    FirebaseAuth mAuth4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donateditems);

        mAuth4 = FirebaseAuth.getInstance();
        currentuser4 = mAuth4.getCurrentUser();

        ttt = findViewById(R.id.textView13);
        ttt.setText(currentuser4.getEmail());


        recyclerView = findViewById(R.id.rv3);
        database = FirebaseDatabase.getInstance().getReference("Book");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance().getReference("Book")
                .orderByChild("addstr")
                .equalTo(currentuser4.getEmail());

        list = new ArrayList<>();
        adapter = new Donateditemadapter(this,list); //zuuu
        recyclerView.setAdapter(adapter);
        query.addValueEventListener(new ValueEventListener() {



       // database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Donateditemdata reqq = dataSnapshot.getValue(Donateditemdata.class);
                    list.add(reqq);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }







    }




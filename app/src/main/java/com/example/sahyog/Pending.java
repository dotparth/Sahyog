package com.example.sahyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pending extends AppCompatActivity {

    RecyclerView pendingrecycle;
    DatabaseReference pendingdatabase;
    Pendingadapter adapter;
    ArrayList<Pendingdata> list;
    TextView ttt;

    FirebaseUser currentuser9;
    FirebaseAuth mAuth9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        mAuth9 = FirebaseAuth.getInstance();
        currentuser9 = mAuth9.getCurrentUser();

        pendingrecycle = findViewById(R.id.pendingrecycler);
        pendingdatabase = FirebaseDatabase.getInstance().getReference("Donorreq");
        pendingrecycle.setHasFixedSize(true);
        pendingrecycle.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance().getReference("Donorreq")
                .orderByChild("reqpho")
                .equalTo(currentuser9.getEmail());


        list = new ArrayList<>();
        adapter = new Pendingadapter(this,list); //zuuu
        pendingrecycle.setAdapter(adapter);
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Pendingdata reqq = dataSnapshot.getValue(Pendingdata.class);
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


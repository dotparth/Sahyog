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

public class Openconfreq extends AppCompatActivity {

    RecyclerView recyclerView5;
    DatabaseReference database5;
    Confreqqadapter adapter;
    ArrayList<Confreqqdata> list;
    TextView ttt;

    FirebaseUser currentuser5;
    FirebaseAuth mAuth5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openconfreq);

        mAuth5 = FirebaseAuth.getInstance();
        currentuser5 = mAuth5.getCurrentUser();

        recyclerView5 = findViewById(R.id.rv6);
        database5 = FirebaseDatabase.getInstance().getReference("Accept");
        recyclerView5.setHasFixedSize(true);
        recyclerView5.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance().getReference("Accept")
                .orderByChild("requester")
                .equalTo(currentuser5.getEmail());

        list = new ArrayList<>();
        adapter = new Confreqqadapter(this,list); //zuuu
        recyclerView5.setAdapter(adapter);
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Confreqqdata reqq = dataSnapshot.getValue(Confreqqdata.class);
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


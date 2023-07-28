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

public class ConfirmedDonation extends AppCompatActivity {

    RecyclerView recyclerView7;
    DatabaseReference database7;
    Declineadapter adapter;
    ArrayList<Declinedata> list;
    TextView ttt;

    FirebaseUser currentuser6;
    FirebaseAuth mAuth6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmed_donation);

        mAuth6 = FirebaseAuth.getInstance();
        currentuser6 = mAuth6.getCurrentUser();

        recyclerView7 = findViewById(R.id.rv8);
        database7 = FirebaseDatabase.getInstance().getReference("Decline");
        recyclerView7.setHasFixedSize(true);
        recyclerView7.setLayoutManager(new LinearLayoutManager(this));


        Query query = FirebaseDatabase.getInstance().getReference("Decline")
                .orderByChild("requester")
                .equalTo(currentuser6.getEmail());


        list = new ArrayList<>();
        adapter = new Declineadapter(this,list); //zuuu
        recyclerView7.setAdapter(adapter);
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Declinedata reqq = dataSnapshot.getValue(Declinedata.class);
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







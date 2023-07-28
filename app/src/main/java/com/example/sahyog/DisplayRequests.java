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

public class DisplayRequests extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database1;
    DisplayRequestadapter adapter;
    ArrayList<DisplayRequestData> list;
    TextView ttt;


    FirebaseUser currentuser5;
    FirebaseAuth mAuth5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_requests);
        ttt = findViewById(R.id.textView14);
        ttt.setText(getIntent().getStringExtra("bookname"));

        mAuth5 = FirebaseAuth.getInstance();
        currentuser5 = mAuth5.getCurrentUser();


        recyclerView = findViewById(R.id.rv4);
        database1 = FirebaseDatabase.getInstance().getReference("Donorreq");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance().getReference("Donorreq")
               .orderByChild("donpho")
                .equalTo(currentuser5.getEmail());
               //FirebaseDatabase.getInstance().getReference("Donorreq")
                 //       .orderByChild("bookoo")
                   //     .equalTo(ttt.getText().toString());


        list = new ArrayList<>();
        adapter = new DisplayRequestadapter(this, list); //zuuu
        recyclerView.setAdapter(adapter);
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DisplayRequestData reqq = dataSnapshot.getValue(DisplayRequestData.class);
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
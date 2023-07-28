package com.example.sahyog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Pendingadapter  extends RecyclerView.Adapter<Pendingadapter.MyViewHolder> {

    Context context;


    ArrayList<Pendingdata> list;

    public Pendingadapter(Context context, ArrayList<Pendingdata> list) {
        this.context = context;
        this.list = list;

    }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){

            View v = LayoutInflater.from(context).inflate(R.layout.item5, parent, false);
            return new MyViewHolder(v);

        }


        @Override
        public void onBindViewHolder (@NonNull Pendingadapter.MyViewHolder holder,int position){


            final Pendingdata user = list.get(position);
            holder.bookoo.setText(user.getBookoo());
            // holder.phoneno.setText(user.getPhoneno());
            //  holder.address.setText(user.getAddress());

            //  holder.itemname.setOnClickListener(new View.OnClickListener() {
            //   @Override
            //    public void onClick(View v) {
            //        Intent intent = new Intent(context,Confyy.class);
            //       intent.putExtra("itemname",user.getItemname());
            //    intent.putExtra("phoneno",user.getPhoneno());
            //    intent.putExtra("address", user.getAddress());
            //   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //    context.startActivity(intent);
            //   }
            //  });


        }


        @Override
        public int getItemCount () {
            return list.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView bookoo, authho, eddo;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                bookoo = itemView.findViewById(R.id.thirdd);


            }


        }

    }







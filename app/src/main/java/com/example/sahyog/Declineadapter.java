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

public class Declineadapter  extends RecyclerView.Adapter<Declineadapter.MyViewHolder>{

    Context context;


    ArrayList<Declinedata> list;


    public Declineadapter (Context context, ArrayList<Declinedata> list) {
        this.context = context;
        this.list = list;





    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item4, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {













        final  Declinedata user = list.get(position);
        holder.itemname.setText(user.getItemname());
        // holder.phoneno.setText(user.getPhoneno());
        //  holder.address.setText(user.getAddress());




    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemname, phoneno, address;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemname = itemView.findViewById(R.id.third);






        }


    }

}




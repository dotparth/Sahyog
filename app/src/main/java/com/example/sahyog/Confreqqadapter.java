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

public class Confreqqadapter   extends RecyclerView.Adapter<Confreqqadapter.MyViewHolder>{

    Context context;


    ArrayList<Confreqqdata> list;


    public Confreqqadapter ( Context context, ArrayList<Confreqqdata> list) {
        this.context = context;
        this.list = list;





}


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
        return new MyViewHolder(v);

    }


    @Override
    public void onBindViewHolder(@NonNull Confreqqadapter.MyViewHolder holder, int position) {








        final  Confreqqdata user = list.get(position);
        holder.itemname.setText(user.getItemname());
       // holder.phoneno.setText(user.getPhoneno());
      //  holder.address.setText(user.getAddress());

        holder.itemname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Confyy.class);
                intent.putExtra("itemname",user.getItemname());
                intent.putExtra("phoneno",user.getPhoneno());
                intent.putExtra("address", user.getAddress());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });



    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemname, phoneno, address;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemname = itemView.findViewById(R.id.firsssttttt);






        }


    }

}


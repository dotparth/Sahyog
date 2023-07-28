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

public class Donateditemadapter  extends RecyclerView.Adapter<Donateditemadapter.MyViewHolder> {

    Context context;


    ArrayList<Donateditemdata> list;




    public Donateditemadapter ( Context context, ArrayList<Donateditemdata> list) {
        this.context = context;
        this.list = list;


}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {








        final  Donateditemdata user = list.get(position);
        holder.namestr.setText(user.getNamestr());
        holder.quantitystr.setText(user.getQuantitystr());
        holder.editionstr.setText(user.getEditionstr());
        // holder.authorstr.setText(user.getAuthorstr());
        // holder.Categorystr.setText(user.getCategorystr());


        holder.namestr.setOnClickListener(new View.OnClickListener() { //zuu
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DonateditemsDisplay.class);
                intent.putExtra("bookname",user.getNamestr());
                intent.putExtra("Authorname",user.getEditionstr());
                intent.putExtra("Edition", user.getQuantitystr());
                intent.putExtra("Author", user.getAuthorstr());
                intent.putExtra("Donorphone", user.getAddstr());
                //    intent.putExtra("Quantity", user.getCategorystr());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {  //zneww static htaya tha

        TextView namestr, quantitystr, editionstr, Categorystr, authorstr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            namestr = itemView.findViewById(R.id.tvfirstName);
            quantitystr = itemView.findViewById(R.id.tvlastName);
            editionstr = itemView.findViewById(R.id.tvage);
            //  Categorystr = itemView.findViewById(R.id.textView13);

            //   itemView.setOnClickListener(this);




        }

        // @Override  //zneww
        // public void onClick(View v) {   //zneww
        //   Intent intent = new Intent (context, DisplayActivity.class);
        //  intent.putExtra("namestr", ""+ getAdapterPosition());
        //  context.startActivity(intent);

        //}
    }

}


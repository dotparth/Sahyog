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

public class DisplayRequestadapter  extends RecyclerView.Adapter<DisplayRequestadapter.MyViewHolder> {

    Context context;


    ArrayList<DisplayRequestData> list;

    public DisplayRequestadapter(Context context, ArrayList<DisplayRequestData> list) {
        this.context = context;
        this.list = list;




    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final DisplayRequestData user = list.get(position);
        holder.reqpho.setText(user.getReqpho());
        holder.bookoo.setText(user.getBookoo());

        holder.bookoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Dissplayy.class);
                intent.putExtra("Itemname",user.getBookoo());
                intent.putExtra("reqemail", user.getReqpho());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

     //   holder.reqpho.setOnClickListener(new View.OnClickListener() { //zuu
       //     @Override
         //   public void onClick(View v) {
         //       Intent intent = new Intent(context, DonateditemsDisplay.class);
          //      intent.putExtra("bookname", user.getReqpho());
           //     //    intent.putExtra("Quantity", user.getCategorystr());
           //     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          //      context.startActivity(intent);
       //     }
      //  });



    }

    @Override
    public int getItemCount() {


        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView reqpho, bookoo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            reqpho = itemView.findViewById(R.id.firsssttt);
            bookoo = itemView.findViewById(R.id.seccondd);


        }
    }
}








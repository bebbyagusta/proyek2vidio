package com.example.asus.proyeklagi;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 11/15/2017.
 */

public class AdapterVidio extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final Context context;
    String [] name={"Vidio 1","Vidio 2 ","Vidio 3","Vidio 4",
            "Vidio 5","Vidio 6","Vidio 7","Vidio 8"};

    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    public AdapterVidio(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();

            if(position==0&&position<getItemCount()){
                Intent intent=new Intent(context, Main2Activity.class);
                context.startActivity(intent);}

            if(position==1&&position<getItemCount()){
                Intent intent1=new Intent(context, Main2Activity.class);
                context.startActivity(intent1);}

            if (position==2&&position<getItemCount()){
                Intent intent2=new Intent(context, Main2Activity.class);
                context.startActivity(intent2);}

            if (position==3&&position<getItemCount()){
                Intent intent2=new Intent(context, Main2Activity.class);
                context.startActivity(intent2);}

            if (position==4&&position<getItemCount()){
                Intent intent2=new Intent(context, Main2Activity.class);
                context.startActivity(intent2);}

            if (position==5&&position<getItemCount()){
                Intent intent2=new Intent(context, Main2Activity.class);
                context.startActivity(intent2);}

            if (position==6&&position<getItemCount()){
                Intent intent2=new Intent(context, Main2Activity.class);
                context.startActivity(intent2);}

            if (position==7&&position<getItemCount()){
                Intent intent2=new Intent(context, Main2Activity.class);
                context.startActivity(intent2);}
        }
    };



    @Override
    public int getItemCount() {
        return name.length;
    }
}



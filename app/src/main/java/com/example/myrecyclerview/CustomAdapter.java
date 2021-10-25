package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.LayoutInflater;
import com.example.myrecyclerview.models.*;
import java.util.ArrayList;

import android.os.Bundle;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;
        public MyViewHolder(View itemView){
             super(itemView);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data){
          this.dataSet=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout,parent,false);
      // view.setOnClickListener();
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int listPosition){
        TextView textViewName=holder.textViewName;
        TextView textViewVersion=holder.textViewVersion;
        ImageView imageView=holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount(){
        return dataSet.size();
    }
}
package com.example.recyclerviewapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    dp_helper_class db;

    String[] title_array;
    String[] des_array;
    TypedArray profile_array;
    public RecyclerViewAdapter(Context context){
        db=new dp_helper_class(context);
      Resources data=context.getResources();
      title_array=data.getStringArray(R.array.title);
      des_array=data.getStringArray(R.array.description);
      profile_array=data.obtainTypedArray(R.array.profile_pic);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new RecyclerViewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
          holder.profile_img.setImageDrawable(profile_array.getDrawable(position));
        ArrayList<Students_data_model> st= db.getAllData("");
        holder.title_.setText(st.get(position).getName());
        holder.desrciption_.setText("My id is "+st.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return (int)db.getTaskCount();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView profile_img;
        TextView title_,desrciption_;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           profile_img= itemView.findViewById(R.id.profile_pic);
           title_=itemView.findViewById(R.id.text_title);
           desrciption_=itemView.findViewById(R.id.description);
        }
    }

}

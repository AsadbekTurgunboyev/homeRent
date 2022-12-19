package com.example.renthome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.renthome.HomeModel;
import com.example.renthome.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    Context context;
    List<HomeModel> list;

    public MainAdapter(Context context, List<HomeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec_item,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {


        holder.title.setText(list.get(position).getName());
        holder.location.setText(list.get(position).getLocation());
        holder.room_number.setText(list.get(position).getRoom_number());
        holder.square.setText(list.get(position).getSpace_room()+"");
        holder.price.setText(list.get(position).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView title, location,room_number,square,price;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView8);
            location = itemView.findViewById(R.id.textView9);
            room_number = itemView.findViewById(R.id.textView11);
            square = itemView.findViewById(R.id.square);
            price = itemView.findViewById(R.id.textView12);


        }
    }
}

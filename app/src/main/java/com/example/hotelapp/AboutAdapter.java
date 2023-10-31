package com.example.hotelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AboutAdapter extends RecyclerView.Adapter<ServicesViewHolder> {

    Context context;
    List<HotelServices> items;

    public AboutAdapter(Context context, List<HotelServices> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ServicesViewHolder(LayoutInflater.from(context).inflate(R.layout.services_type_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesViewHolder holder, int position) {
        holder.Name.setText(items.get(position).getName());
        holder.Description.setText(items.get(position).getDescription());
        holder.Image.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

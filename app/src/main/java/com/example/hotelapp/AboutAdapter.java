package com.example.hotelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.model.HotelServices;

import java.util.List;

public class AboutAdapter extends RecyclerView.Adapter<ServicesViewHolder> {

    private Context context;
    private List<HotelServices> items;

    // Constructor to initialize the adapter with context and list of items
    public AboutAdapter(Context context, List<HotelServices> items) {
        this.context = context;
        this.items = items;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view holder by inflating the layout
        return new ServicesViewHolder(LayoutInflater.from(context).inflate(R.layout.services_type_item, parent, false));
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ServicesViewHolder holder, int position) {
        // Set the data for each view holder based on the item at the given position
        holder.name.setText(items.get(position).getName());
        holder.description.setText(items.get(position).getDescription());
        holder.image.setImageResource(items.get(position).getImage());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}

package com.example.hotelapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ServicesViewHolder extends RecyclerView.ViewHolder {

    ImageView image;  // Renamed to follow Java naming conventions
    TextView name;
    TextView description;

    public ServicesViewHolder(@NonNull View itemView) {
        super(itemView);

        // Initialize UI elements
        image = itemView.findViewById(R.id.services_imageview);
        name = itemView.findViewById(R.id.services_name);
        description = itemView.findViewById(R.id.services_description);
    }
}

package com.example.hotelapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ServicesViewHolder extends RecyclerView.ViewHolder {

    ImageView Image;
    TextView Name;
    TextView Description;

    public ServicesViewHolder(@NonNull View itemView) {
        super(itemView);

        Image = itemView.findViewById(R.id.services_imageview);
        Name = itemView.findViewById(R.id.services_name);
        Description = itemView.findViewById(R.id.services_description);


    }
}

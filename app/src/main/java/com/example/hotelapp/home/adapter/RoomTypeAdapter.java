package com.example.hotelapp.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.R;
import com.example.hotelapp.model.RoomType;

import java.util.List;

public class RoomTypeAdapter extends RecyclerView.Adapter<RoomTypeAdapter.RoomTypeViewHolder> {

    private final List<RoomType> roomTypes;
    private final Context context;
    private final OnBookClickListener onBookClickListener;

    // Constructor for the RoomTypeAdapter
    public RoomTypeAdapter(Context context, List<RoomType> roomTypes, OnBookClickListener onBookClickListener) {
        this.context = context;
        this.roomTypes = roomTypes;
        this.onBookClickListener = onBookClickListener;
    }

    // Create a new view holder when needed
    @NonNull
    @Override
    public RoomTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_type_item, parent, false);
        return new RoomTypeViewHolder(view);
    }

    // Bind the data to the view holder
    @Override
    public void onBindViewHolder(RoomTypeViewHolder holder, int position) {
        RoomType roomType = roomTypes.get(position);

        // Set the data to the views in the view holder
        holder.roomName.setText(roomType.getName());
        holder.roomPrice.setText(roomType.getPrice());
        // You would typically use a library like Picasso or Glide to load images from URLs.
        // For simplicity, we'll just set a placeholder image.
        holder.roomImage.setImageResource(roomType.getImg());
        holder.availableRooms.setText("Available Rooms : " + roomType.getAvailableRooms());
    }

    // Return the number of items in the data set
    @Override
    public int getItemCount() {
        return roomTypes.size();
    }

    // View holder class to hold the views
    public class RoomTypeViewHolder extends RecyclerView.ViewHolder {
        public ImageView roomImage;
        public TextView roomName;
        public TextView roomPrice;
        public TextView availableRooms;

        // Constructor for the RoomTypeViewHolder
        public RoomTypeViewHolder(View itemView) {
            super(itemView);
            roomImage = itemView.findViewById(R.id.room_image);
            roomName = itemView.findViewById(R.id.room_name);
            roomPrice = itemView.findViewById(R.id.room_price);
            Button bookButton = itemView.findViewById(R.id.book_button);
            availableRooms = itemView.findViewById(R.id.available_rooms);

            // Set up click listener for the book button
            bookButton.setOnClickListener(view -> {
                if (onBookClickListener != null) {
                    onBookClickListener.onBookClick(getAdapterPosition());
                }
            });
        }
    }

    // Interface for the book button click listener
    public interface OnBookClickListener {
        void onBookClick(int position);
    }
}

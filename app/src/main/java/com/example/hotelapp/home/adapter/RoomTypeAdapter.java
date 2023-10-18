package com.example.hotelapp.home.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.R;
import com.example.hotelapp.model.RoomType;

import java.util.List;

public class RoomTypeAdapter extends RecyclerView.Adapter<RoomTypeAdapter.RoomTypeViewHolder> {

    private List<RoomType> roomTypes;
    private Context context;
    private OnBookClickListener onBookClickListener;


    public RoomTypeAdapter(Context context, List<RoomType> roomTypes, OnBookClickListener onBookClickListener) {
        this.context = context;
        this.roomTypes = roomTypes;
        this.onBookClickListener = onBookClickListener;
    }

    @Override
    public RoomTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_type_item, parent, false);
        return new RoomTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomTypeViewHolder holder, int position) {
        RoomType roomType = roomTypes.get(position);

        holder.roomName.setText(roomType.getName());
        holder.roomPrice.setText(roomType.getPrice());
        // You would typically use a library like Picasso or Glide to load images from URLs.
        // For simplicity, we'll just set a placeholder image.
        holder.roomImage.setImageResource(R.color.brown);

    }

    @Override
    public int getItemCount() {
        return roomTypes.size();
    }

    public class RoomTypeViewHolder extends RecyclerView.ViewHolder {
        public ImageView roomImage;
        public TextView roomName;
        public TextView roomPrice;

        public RoomTypeViewHolder(View itemView) {
            super(itemView);
            roomImage = itemView.findViewById(R.id.room_image);
            roomName = itemView.findViewById(R.id.room_name);
            roomPrice = itemView.findViewById(R.id.room_price);
            Button bookButton = itemView.findViewById(R.id.book_button);
            bookButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onBookClickListener != null) {
                        onBookClickListener.onBookClick(getAdapterPosition());
                    }
                }
            });
        }
    }
    public interface OnBookClickListener {
        void onBookClick(int position);
    }

}

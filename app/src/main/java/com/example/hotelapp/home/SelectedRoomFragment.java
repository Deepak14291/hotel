package com.example.hotelapp.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelapp.R;


public class SelectedRoomFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selected_room, container, false);

        // Get references to the ImageView and TextView elements
        ImageView selectedRoomImage = view.findViewById(R.id.selected_room_image);
        TextView selectedRoomName = view.findViewById(R.id.selected_room_name);
        TextView selectedRoomPrice = view.findViewById(R.id.selected_room_price);

        // Set static data
        selectedRoomImage.setImageResource(R.color.brown); // Replace with your room's image resource
        selectedRoomName.setText("Luxury Suite"); // Replace with the room name
        selectedRoomPrice.setText("$250"); // Replace with the room price

        return view;
    }
}
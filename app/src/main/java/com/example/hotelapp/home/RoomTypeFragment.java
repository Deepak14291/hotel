package com.example.hotelapp.home;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.model.Constants;
import com.example.hotelapp.R;
import com.example.hotelapp.home.adapter.RoomTypeAdapter;
import com.example.hotelapp.model.RoomType;

import java.util.ArrayList;
import java.util.List;

public class RoomTypeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_type, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        // Create a list to hold RoomType objects
        List<RoomType> dataList = new ArrayList<>();

        // Retrieve available room counts from SharedPreferences
        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("message_prefs", MODE_PRIVATE);
        int availDeluxeRooms = sharedPrefs.getInt(Constants.DELUXE_ROOM, 0);
        int availExecutiveRooms = sharedPrefs.getInt(Constants.EXECUTIVE, 0);
        int availGrandRooms = sharedPrefs.getInt(Constants.GRAND_DELUXE, 0);

        // Set data for different RoomTypes
        dataList.add(new RoomType(R.drawable.roomimage1, "Deluxe Room", "$100", "", availDeluxeRooms));
        dataList.add(new RoomType(R.drawable.roomimage3, "Grand Deluxe Room", "$150", "", availGrandRooms));
        dataList.add(new RoomType(R.drawable.roomimage2, "Executive", "$250", "", availExecutiveRooms));

        // Create an adapter and set it to the RecyclerView
        RoomTypeAdapter adapter = new RoomTypeAdapter(requireContext(), dataList, position -> {

            if(position==0 &&availDeluxeRooms<=0||position==1 && availGrandRooms<=0 || position==2 && availExecutiveRooms<=0){
                Toast.makeText(requireContext(), "Room not available", Toast.LENGTH_SHORT).show();
            }
            else{
                // Handle the button click for the item at the given position
                // Implement your logic for booking the room here
                ((HomeActivity) getActivity()).switchToSelectedRoomFragment(dataList.get(position));
            }
        });
        recyclerView.setAdapter(adapter);

        // Set the layout manager for the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }
}

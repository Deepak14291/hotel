package com.example.hotelapp.home;

import static android.content.Context.MODE_PRIVATE;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hotelapp.Constants;
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

        List<RoomType> dataList = new ArrayList<>();
        SharedPreferences sharedPrefs = getActivity().getSharedPreferences("message_prefs", MODE_PRIVATE);
        int availDeluxeRooms = sharedPrefs.getInt(Constants.DELUXE_ROOM, 0);
        int availExecutiveRooms = sharedPrefs.getInt(Constants.EXECUTIVE, 0);
        int availGrandRooms = sharedPrefs.getInt(Constants.GRAND_DELUXE, 0);


        //setting data
        dataList.add(new RoomType(R.drawable.roomimage1, "Deluxe Room", "$100", "", availDeluxeRooms));
        dataList.add(new RoomType(R.drawable.roomimage3, "Grand Deluxe Room", "$150", "", availGrandRooms));
        dataList.add(new RoomType(R.drawable.roomimage2, "Executive", "$250", "", availExecutiveRooms));

        RoomTypeAdapter adapter = new RoomTypeAdapter(requireContext(), dataList, new RoomTypeAdapter.OnBookClickListener() {
            @Override
            public void onBookClick(int position) {
                // Handle the button click for the item at the given position
                // Implement your logic for booking the room here
                ((HomeActivity) getActivity()).switchToSelectedRoomFragment(dataList.get(position));
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }

}
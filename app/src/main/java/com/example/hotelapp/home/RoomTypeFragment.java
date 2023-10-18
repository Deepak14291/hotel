package com.example.hotelapp.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotelapp.R;
import com.example.hotelapp.home.adapter.RoomTypeAdapter;

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
        View view= inflater.inflate(R.layout.fragment_room_type, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        List<String> dataList = new ArrayList<>(); // Replace with your data source

        RoomTypeAdapter adapter = new RoomTypeAdapter(requireContext(), dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }
}
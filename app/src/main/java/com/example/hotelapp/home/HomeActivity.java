package com.example.hotelapp.home;

import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;


import com.example.hotelapp.R;
import com.example.hotelapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RoomTypeFragment fragment = new RoomTypeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();





    }


}
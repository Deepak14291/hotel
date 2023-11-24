package com.example.hotelapp.home;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;


import com.example.hotelapp.R;
import com.example.hotelapp.databinding.ActivityHomeBinding;
import com.example.hotelapp.model.RoomType;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
private RoomType roomType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RoomTypeFragment fragment = new RoomTypeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


    public void switchToSelectedRoomFragment(RoomType roomType) {
        setRoomType(roomType);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new SelectedRoomFragment());
        transaction.addToBackStack(null); // Add the transaction to the back stack
        transaction.commit();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            // The back stack is empty, so finish the activity
            finish();
            return true;
        } else {
            super.onBackPressed();
            return true;
        }


    }
}
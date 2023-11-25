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

        // Set up the activity layout using view binding
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize and display the RoomTypeFragment
        RoomTypeFragment fragment = new RoomTypeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

        // Enable the "Up" button in the action bar for navigation
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    // Getter method for the current RoomType
    public RoomType getRoomType() {
        return roomType;
    }

    // Setter method to update the current RoomType
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    // Switch to the SelectedRoomFragment and add the transaction to the back stack
    public void switchToSelectedRoomFragment(RoomType roomType) {
        setRoomType(roomType);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new SelectedRoomFragment());
        transaction.addToBackStack(null); // Add the transaction to the back stack
        transaction.commit();
    }

    // Handle the "Up" button in the action bar
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

package com.example.hotelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hotelapp.model.HotelServices;

import java.util.ArrayList;
import java.util.List;

public class AboutHotelServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_hotel_services);

        // Set up the action bar with the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize RecyclerView and populate it with hotel services data
        RecyclerView recyclerView = findViewById(R.id.recyclerview_hotel);
        List<HotelServices> servicesOffered = getHotelServicesData();

        // Set up the RecyclerView with a LinearLayoutManager and the custom adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AboutAdapter(getApplicationContext(), servicesOffered));
    }

    // Handle the back button click in the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Navigate back when the back button is clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Method to get a list of hotel services data
    private List<HotelServices> getHotelServicesData() {
        List<HotelServices> servicesOffered = new ArrayList<>();

        // Add hotel services data to the list
        servicesOffered.add(new HotelServices(R.drawable.foodimage2, "", ""));
        servicesOffered.add(new HotelServices(R.drawable.foodimage, "Food", "GrandView Hotel's premier Michelin-starred dining destination serves Modern European cuisine paired with breathtaking views..."));

        // Add more hotel services data...

        return servicesOffered;
    }
}

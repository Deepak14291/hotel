package com.example.hotelapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelapp.model.Constants;
import com.example.hotelapp.model.RoomType;

public class ReviewReservation extends AppCompatActivity {

    private Button bookRoomButton;
    private TextView textViewName, textViewDate, textViewPrice, textViewTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_reservation);

        // Initialize UI elements
        bookRoomButton = findViewById(R.id.button_book_room);
        textViewName = findViewById(R.id.textViewName);
        textViewDate = findViewById(R.id.textViewDate);
        textViewPrice = findViewById(R.id.tvPriceValue);
        textViewTax = findViewById(R.id.tvTaxesPrice);

        // Set up ActionBar with back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Retrieve RoomType object from Intent
        RoomType roomType = getIntent().getParcelableExtra(Constants.SELECTED_ROOM_KEY);

        if (roomType != null) {
            // Update available room count and display reservation details
            updateAvailableRoomCount(roomType.getName());
            displayReservationDetails(roomType);
        }

        // Set click listener for the Book Room button
        bookRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Proceed to BookingSuccessful activity
                Intent intent = new Intent(ReviewReservation.this, BookingSuccessful.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Method to update the available room count in SharedPreferences
    private void updateAvailableRoomCount(String roomType) {
        SharedPreferences sharedPrefs = getApplicationContext().getSharedPreferences("message_prefs", MODE_PRIVATE);
        int totalAvailable = sharedPrefs.getInt(roomType, 0); // Retrieve the updated value

        if (totalAvailable > 0) {
            totalAvailable--; // Decrease the available value
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putInt(roomType, totalAvailable); // Store the updated value
            editor.apply(); // Apply the changes to SharedPreferences
        }
    }

    // Method to display reservation details in TextViews
    private void displayReservationDetails(RoomType roomType) {
        textViewDate.setText(roomType.getDate() + " (1 Night)");
        textViewName.setText(roomType.getName());
        textViewPrice.setText(roomType.getPrice());
        textViewTax.setText(roomType.getPrice());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the back button click
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

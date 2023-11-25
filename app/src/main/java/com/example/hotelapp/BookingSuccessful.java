package com.example.hotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookingSuccessful extends AppCompatActivity {

    private Button homeButton;
    private TextView textViewBookingID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_successful);

        // Initialize views
        homeButton = findViewById(R.id.button_home);
        textViewBookingID = findViewById(R.id.textView15);
        textViewBookingID.setText("Congratulations!! Your Booking ID is #7997878");

        // Set up click listener for the home button
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the UserLandingPage
                Intent intent = new Intent(BookingSuccessful.this, UserLandingPage.class);
                startActivity(intent);
                finish(); // Close the current activity to prevent navigating back to it from UserLandingPage
            }
        });
    }
}

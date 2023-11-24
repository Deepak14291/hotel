package com.example.hotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookingSuccessful extends AppCompatActivity {

    private Button Home;
    private TextView textViewBookingID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_successful);

        Home = (Button) findViewById(R.id.button_home);
        textViewBookingID = findViewById(R.id.textView15);
        textViewBookingID.setText("Congratulations !! Your Booking ID is #7997878");


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingSuccessful.this, UserLandingPage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
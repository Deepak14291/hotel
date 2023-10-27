package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookingSuccessful extends AppCompatActivity {

    private Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_successful);

    Home = (Button) findViewById(R.id.button_home);

    Home.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(BookingSuccessful.this,UserLandingPage.class);
            startActivity(intent);
            finish();
        }
    });

    }
}
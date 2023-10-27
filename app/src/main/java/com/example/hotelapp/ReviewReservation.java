package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hotelapp.R;

public class ReviewReservation extends AppCompatActivity {

    private Button BookRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_reservation);

        BookRoom = (Button) findViewById(R.id.button_book_room);

        BookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewReservation.this,BookingSuccessful.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
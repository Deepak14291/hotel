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

import com.example.hotelapp.model.RoomType;

public class ReviewReservation extends AppCompatActivity {

    private Button BookRoom;
    private TextView textViewName, textViewDate, textViewPrice, textViewTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_reservation);

        BookRoom = (Button) findViewById(R.id.button_book_room);
        textViewName = findViewById(R.id.textViewName);
        textViewDate = findViewById(R.id.textViewDate);
        textViewPrice = findViewById(R.id.tvPriceValue);
        textViewTax = findViewById(R.id.tvTaxesPrice);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        RoomType roomType = getIntent().getParcelableExtra(Constants.SELECTED_ROOM_KEY);


        if (roomType != null) {
            SharedPreferences sharedPrefs = getApplicationContext().getSharedPreferences("message_prefs", MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPrefs.edit();
            switch (roomType.getName()) {
                case Constants.DELUXE_ROOM: {
                    updateAvailableRoomCount(Constants.DELUXE_ROOM, sharedPrefs, editor);
                    break;
                }

                case Constants.GRAND_DELUXE: {
                    updateAvailableRoomCount(Constants.GRAND_DELUXE, sharedPrefs, editor);
                    break;
                }
                case Constants.EXECUTIVE: {
                    updateAvailableRoomCount(Constants.EXECUTIVE, sharedPrefs, editor);
                    break;

                }
            }


            textViewDate.setText(roomType.getDate() + " (1 Night)");
            textViewName.setText(roomType.getName());
            textViewPrice.setText(roomType.getPrice());
            textViewTax.setText(roomType.getPrice());
        }


        BookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewReservation.this, BookingSuccessful.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void updateAvailableRoomCount(String roomType, SharedPreferences sharedPrefs, SharedPreferences.Editor editor) {
        int totalAvailable = sharedPrefs.getInt(roomType, 0); // Retrieve the updated value

        totalAvailable = totalAvailable - 1; // Decrease the available value
        editor.putInt(roomType, totalAvailable); // Store the updated value
        editor.apply(); // Apply the changes to SharedPreferences

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the back button click here
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
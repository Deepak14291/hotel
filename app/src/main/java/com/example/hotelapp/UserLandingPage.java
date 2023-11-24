package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hotelapp.home.HomeActivity;
import com.example.hotelapp.model.RoomType;

public class UserLandingPage extends AppCompatActivity {

    private Button AboutHotel;
    private Button MemberDetails;
    private Button BookRoom;
    private TextView Name;

    private Button Media;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing_page);

        AboutHotel = (Button) findViewById(R.id.about_hotel);
        BookRoom = (Button) findViewById(R.id.button_book_room);
        MemberDetails = (Button) findViewById(R.id.button_member_details);
        Name = (TextView) findViewById(R.id.user_landing_name);
        Media = (Button) findViewById(R.id.media);

        AboutHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLandingPage.this, AboutHotelServices.class);
                startActivity(intent);
                finish();
            }
        });

        BookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLandingPage.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        MemberDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLandingPage.this, MemberDetails.class);
                startActivity(intent);
                finish();
            }
        });

        Media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLandingPage.this, Media.class);
                startActivity(intent);
                finish();
            }
        });

        SharedPreferences getSharedPrefs = getApplicationContext().getSharedPreferences("message_prefs",MODE_PRIVATE);

        String value = getSharedPrefs.getString("fullname", "nothing yet");
        Name.setText("Hi, "+value.toUpperCase());


    }
}
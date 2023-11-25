package com.example.hotelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberDetails extends AppCompatActivity {

    private TextView Fullname;
    private TextView Username;
    private TextView Email;
    private TextView PhoneNumber;

    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);

        // Set up action bar with back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize UI elements
        Fullname = findViewById(R.id.memberdetails_fullname);
        Username = findViewById(R.id.memberdetails_username);
        Email = findViewById(R.id.memberdetails_email);
        PhoneNumber = findViewById(R.id.memberdetails_phone);
        Back = findViewById(R.id.button_back);

        // Retrieve member details from SharedPreferences
        SharedPreferences getSharedPrefs = getApplicationContext().getSharedPreferences("message_prefs", MODE_PRIVATE);
        String fullname = getSharedPrefs.getString("fullname", "nothing yet");
        String username = getSharedPrefs.getString("username", "nothing yet");
        String email = getSharedPrefs.getString("email", "nothing yet");
        String phone = getSharedPrefs.getString("phone", "nothing yet");

        // Display member details on the UI
        Fullname.setText(fullname);
        Username.setText(username);
        Email.setText(email);
        PhoneNumber.setText(phone);

        // Set listener for the back button
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to UserLandingPage
                Intent intent = new Intent(MemberDetails.this, UserLandingPage.class);
                startActivity(intent);
                finish();
            }
        });
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

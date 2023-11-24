package com.example.hotelapp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Fullname = (TextView) findViewById(R.id.memberdetails_fullname);
        Username = (TextView) findViewById(R.id.memberdetails_username);
        Email = (TextView) findViewById(R.id.memberdetails_email);
        PhoneNumber = (TextView) findViewById(R.id.memberdetails_phone);
        Back = (Button) findViewById(R.id.button_back);

        SharedPreferences getSharedPrefs = getApplicationContext().getSharedPreferences("message_prefs",MODE_PRIVATE);

        String fullname = getSharedPrefs.getString("fullname", "nothing yet");
        String username = getSharedPrefs.getString("username", "nothing yet");
        String email = getSharedPrefs.getString("email", "nothing yet");
        String phone = getSharedPrefs.getString("phone", "nothing yet");


        Fullname.setText(fullname);
        Username.setText(username);
        Email.setText(email);
        PhoneNumber.setText(phone);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberDetails.this,UserLandingPage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
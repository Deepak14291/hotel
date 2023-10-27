package com.example.hotelapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MemberDetails extends AppCompatActivity {

    private TextView Fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);

        Fullname = (TextView) findViewById(R.id.textview_memberdetails_fullname);

        SharedPreferences getSharedPrefs = getApplicationContext().getSharedPreferences("message_prefs",MODE_PRIVATE);

        String value = getSharedPrefs.getString("fullname", "nothing yet");
        Fullname.setText(value);


    }
}
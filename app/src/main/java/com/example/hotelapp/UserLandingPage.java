package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hotelapp.home.HomeActivity;
import com.example.hotelapp.location.TrackGPS;
import com.example.hotelapp.model.RoomType;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class UserLandingPage extends AppCompatActivity {
    private static final int REQUEST_CODE_PERMISSION = 1;
    private Button AboutHotel;
    private Button MemberDetails;
    private Button BookRoom;
    private TextView Name,Place;
    String[] mPermission = {Manifest.permission.ACCESS_FINE_LOCATION};
    private Button Media;
    private TrackGPS gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing_page);

        AboutHotel = (Button) findViewById(R.id.about_hotel);
        BookRoom = (Button) findViewById(R.id.button_book_room);
        MemberDetails = (Button) findViewById(R.id.button_member_details);
        Name = (TextView) findViewById(R.id.user_landing_name);
        Place=(TextView) findViewById(R.id.textView4);
        Media = (Button) findViewById(R.id.media);
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(mPermission[0]) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(UserLandingPage.this, mPermission, REQUEST_CODE_PERMISSION);
                return;
            }
        }
        gps = new TrackGPS(UserLandingPage.this);
        if (gps.canGetLocation()) {

            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            try {
                List<Address> listAddresses = geocoder.getFromLocation(gps.getLatitude(), gps.getLongitude(), 1);
                if(null!=listAddresses&&listAddresses.size()>0){
                    String _Location = listAddresses.get(0).getAddressLine(0);
                    Place.setText(_Location+"");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


//            editText = (EditText) findViewById(R.id.editTextLatitude);
//            editText.setText("Latitude: " + gps.getLatitude());
//            editText = (EditText) findViewById(R.id.editTextLongitude);
//            editText.setText("Longitude: " + gps.getLongitude());
//            editText = (EditText) findViewById(R.id.editTextAltitude);
//            editText.setText("Altitude: "  +gps.getAltitude());

        } else {
            gps.showAlert();
        }


        AboutHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLandingPage.this,AboutHotel.class);
                startActivity(intent);
                finish();
            }
        });

        BookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLandingPage.this, HomeActivity.class);
                startActivity(intent);

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
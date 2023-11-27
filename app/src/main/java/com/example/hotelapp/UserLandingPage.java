package com.example.hotelapp;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.example.hotelapp.home.HomeActivity;
import com.example.hotelapp.location.TrackGPS;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class UserLandingPage extends AppCompatActivity {
    private static final int REQUEST_CODE_PERMISSION = 1;
    private TextView Place;
    String[] mPermission = {Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing_page);

        Button aboutHotel = (Button) findViewById(R.id.about_hotel);
        Button bookRoom = (Button) findViewById(R.id.button_book_room);
        Button memberDetails = (Button) findViewById(R.id.button_member_details);
        TextView name = (TextView) findViewById(R.id.user_landing_name);
        Place = (TextView) findViewById(R.id.textView4);
        Button media = (Button) findViewById(R.id.media);

        SharedPreferences getSharedPrefs = getApplicationContext().getSharedPreferences("message_prefs", MODE_PRIVATE);

        String value = getSharedPrefs.getString("fullname", "nothing yet");
        name.setText("Hello " + value.toUpperCase() + ",");
        aboutHotel.setOnClickListener(v -> {
            Intent intent = new Intent(UserLandingPage.this, AboutHotelServices.class);
            startActivity(intent);

        });

        bookRoom.setOnClickListener(v -> {
            Intent intent = new Intent(UserLandingPage.this, HomeActivity.class);
            startActivity(intent);
           
        });

        memberDetails.setOnClickListener(v -> {
            Intent intent = new Intent(UserLandingPage.this, MemberDetails.class);
            startActivity(intent);

        });

        media.setOnClickListener(v -> {
            Intent intent = new Intent(UserLandingPage.this, Media.class);
            startActivity(intent);

        });
        if (checkSelfPermission(mPermission[0]) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(UserLandingPage.this, mPermission, REQUEST_CODE_PERMISSION);
            return;
        } else {
            getLocation();
        }



    }

    private void getLocation() {
        TrackGPS gps = new TrackGPS(UserLandingPage.this);
        if (gps.canGetLocation()) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    List<Address> listAddresses = geocoder.getFromLocation(gps.getLatitude(), gps.getLongitude(), 1);
                    if (null != listAddresses && listAddresses.size() > 0) {
                        String _Location = listAddresses.get(0).getAddressLine(0);
                        Place.setText(_Location + "");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Request location permission here
                ActivityCompat.requestPermissions(UserLandingPage.this, mPermission, REQUEST_CODE_PERMISSION);
            }
        } else {
            gps.showAlert();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, handle location retrieval here
                getLocation();
            } else {
                // Permission denied, show a user-friendly message
                showPermissionDeniedMessage();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    private void showPermissionDeniedMessage() {
        // Display a message to the user explaining why the location permission is essential
        // and guide them on how to grant the permission.

        // Example:
        Toast.makeText(this, "Location permission is required to provide personalized services. Please grant the permission in the app settings.", Toast.LENGTH_LONG).show();
    }
}
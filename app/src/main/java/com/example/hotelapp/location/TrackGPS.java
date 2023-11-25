package com.example.hotelapp.location;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TrackGPS extends Service implements LocationListener {

    private final Context context; // Reference to the current context
    private boolean isGPSEnabled = false; // Flag to check if GPS is available
    private Location myLocation; // Variable to store the current location
    private LocationManager locationManager;
    private double latitude;
    private double longitude;

    private static final long MIN_DELAY = 1000 * 60; // Minimum time between updates
    private static final long MIN_DISTANCE = 10; // Minimum distance between updates

    public TrackGPS(Context context) {
        this.context = context;
        getLocation();
    }

    public double getLatitude() {
        return (myLocation != null) ? myLocation.getLatitude() : latitude;
    }

    public double getLongitude() {
        return (myLocation != null) ? myLocation.getLongitude() : longitude;
    }

    private Location getLocation() {
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            // Get GPS status
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (isGPSEnabled) {
                try {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_DELAY, MIN_DISTANCE, this);
                    if (locationManager != null) {
                        myLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (myLocation != null) {
                            latitude = myLocation.getLatitude();
                            longitude = myLocation.getLongitude();
                        }
                    }
                } catch (SecurityException e) {
                    Toast.makeText(context, "No permission to access GPS", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "No service provider available", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myLocation;
    }

    public boolean canGetLocation() {
        return isGPSEnabled;
    }

    public void showAlert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("GPS disabled");
        dialog.setMessage("Do you want to turn on GPS?");
        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });
        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    // Stops the use of GPS
    public void stopGPS() {
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(TrackGPS.this);
            } catch (SecurityException e) {
                Toast.makeText(context, "No permission to access GPS", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        // Handle location changes if needed
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Handle status changes if needed
    }
}

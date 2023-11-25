package com.example.hotelapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterLoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);

        // Initialize UI elements
        Button signInButton = findViewById(R.id.button_sign_in2);
        Button signUpButton = findViewById(R.id.button_sign_up);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.loginpassword);

        // Set click listener for sign-in button
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get entered username and password
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Retrieve stored username and password from SharedPreferences
                SharedPreferences sharedPrefs = getApplicationContext().getSharedPreferences("message_prefs", MODE_PRIVATE);
                String storedUsername = sharedPrefs.getString("username", "nothing yet");
                String storedPassword = sharedPrefs.getString("password", "nothing yet");

                // Check if username and password are empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterLoginActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if entered username and password match the stored values
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        // Proceed to user landing page
                        Intent intent = new Intent(RegisterLoginActivity.this, UserLandingPage.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Display a toast message for incorrect credentials
                        Toast.makeText(RegisterLoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set click listener for sign-up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to user signup page
                Intent intent = new Intent(RegisterLoginActivity.this, UserSignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

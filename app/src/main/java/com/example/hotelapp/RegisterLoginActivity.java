package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterLoginActivity extends AppCompatActivity {

    private Button SignIn;
    private Button SignUp;

    private EditText Username;
    private EditText Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);

        SignIn = (Button) findViewById(R.id.button_sign_in2);
        SignUp = (Button) findViewById(R.id.button_sign_up);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.loginpassword);



        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();

                SharedPreferences getSharedPrefs = getApplicationContext().getSharedPreferences("message_prefs",MODE_PRIVATE);
                String username_saved = getSharedPrefs.getString("username", "nothing yet");
                String password_saved = getSharedPrefs.getString("password", "nothing yet");

                // if username and password is empty, display a toast notification to request user input.
                if(username.isEmpty()){
                    Toast.makeText(RegisterLoginActivity.this, "please enter username", Toast.LENGTH_SHORT)
                            .show();
                } else if (password.isEmpty()) {
                    Toast.makeText(RegisterLoginActivity.this, "please enter password", Toast.LENGTH_SHORT)
                            .show();

                }else {
                    // if username and password is provided by the user, check against the stored shared preference.
                    // If it matches navigate to user landing page, if not, display a toast message saying incorrect credentials entered.
                    if( (username.matches(username_saved)) && (password.matches(password_saved))){
                        //Proceed to user landing page
                        Intent intent = new Intent(RegisterLoginActivity.this,UserLandingPage.class);
                        startActivity(intent);
                        finish();
                    }else{
                        // toast message informing using that the entered username and password is incorrect
                        Toast.makeText(RegisterLoginActivity.this, "entered username and password is incorrect", Toast.LENGTH_SHORT)
                                .show();
                    }
                }

            }
        });
        // Navigate to usersignup page on click of sign-up button.
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterLoginActivity.this,UserSignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserSignUp extends AppCompatActivity {


    private Button SignUp, SignIn;
    private EditText Fullname;
    private EditText Username;
    private EditText Password;
    private EditText Emailaddress;
    private EditText Phonenumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        SignUp = (Button) findViewById(R.id.button_sign_up);
        SignIn = (Button) findViewById(R.id.button_sign_in);

        Fullname = (EditText) findViewById(R.id.edittext_full_name);
        Username = (EditText) findViewById(R.id.edittext_username);
        Password = (EditText) findViewById(R.id.edittext_password);
        Emailaddress = (EditText) findViewById(R.id.edittext_email_address);
        Phonenumber = (EditText) findViewById(R.id.edittext_phonenumber);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = Fullname.getText().toString().trim();
                String username = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String email = Emailaddress.getText().toString().trim();
                String phone = Phonenumber.getText().toString().trim();


                if(fullname.isEmpty()){
                    Toast.makeText(UserSignUp.this, "enter fullname", Toast.LENGTH_SHORT)
                            .show();

                } else if (username.isEmpty()) {

                    Toast.makeText(UserSignUp.this, "enter username", Toast.LENGTH_SHORT)
                            .show();
                } else if (password.isEmpty()) {

                    Toast.makeText(UserSignUp.this, "enter password", Toast.LENGTH_SHORT)
                            .show();
                }
                else if (email.isEmpty()) {

                    Toast.makeText(UserSignUp.this, "enter email", Toast.LENGTH_SHORT)
                            .show();
                }
                else if (phone.isEmpty()) {

                    Toast.makeText(UserSignUp.this, "enter phonenumber", Toast.LENGTH_SHORT)
                            .show();
                }

                else{
                    SharedPreferences sharedPreferences = getSharedPreferences(Constants.MESSAGE_ID,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Constants.FULLNAME, fullname);
                    editor.putString(Constants.USERNAME, username);
                    editor.putString(Constants.PASSWORD, password);
                    editor.putString(Constants.EMAIL, email);
                    editor.putString(Constants.PHONE, phone);
                    editor.putInt(Constants.DELUXE_ROOM, 4);
                    editor.putInt(Constants.GRAND_DELUXE,4);
                    editor.putInt(Constants.EXECUTIVE, 4);
                    editor.commit(); // saving to disk.
                    Toast.makeText(UserSignUp.this,"Congratulations!!! Sign-up success", Toast.LENGTH_SHORT)
                            .show();
                    Toast.makeText(UserSignUp.this,"Click on Sign-in now", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserSignUp.this, RegisterLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
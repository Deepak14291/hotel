package com.example.hotelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Media extends AppCompatActivity {

    private Button playVideo;
    private MediaPlayer mediaPlayer;

    private Button playMusic;

    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        // Initialize video view and set its path
        VideoView videoView = findViewById(R.id.videoView);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.mariottcommercial;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoPath(uri.toString());

        // Set up action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set media controller for video view
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Initialize media player for music
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aboutfood);

        // Initialize UI elements
        playMusic = findViewById(R.id.button_food);
        Back = findViewById(R.id.media_button_back);

        // Set listeners for buttons
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    // Stop and give option to start again
                    pauseMusic();
                } else {
                    // Start and give option to pause again
                    startMusic();
                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to UserLandingPage
                Intent intent = new Intent(Media.this, UserLandingPage.class);
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

    // Pause the music playback
    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playMusic.setText("Play");
        }
    }

    // Start or resume the music playback
    public void startMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            playMusic.setText("Pause");
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playMusic.setText("Play");
            }
        });
    }
}

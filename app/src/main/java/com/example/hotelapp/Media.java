package com.example.hotelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
    private int currentSongIndex = 0;
    private int[] songs = {R.raw.aboutfood, R.raw.music1, R.raw.music2, R.raw.music4, R.raw.music5};
    private boolean isFirstVideoCompleted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        VideoView videoView = findViewById(R.id.videoView);
        String mariottPath = "android.resource://" + getPackageName() + "/" + R.raw.mariottcommercial;
        String video2Path = "android.resource://" + getPackageName() + "/" + R.raw.video2;

        Uri mariottUri = Uri.parse(mariottPath);
        Uri video2Uri = Uri.parse(video2Path);

        videoView.setVideoURI(mariottUri);
        videoView.start();

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!isFirstVideoCompleted) {
                    videoView.setVideoURI(video2Uri);
                    videoView.start();
                    isFirstVideoCompleted = true;
                }
            }
        });

        // Playing music.
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), songs[currentSongIndex]);

        playMusic = findViewById(R.id.button_food);

        playMusic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()){

                    //stop and give option to start again
                    pauseMusic();
                }else {

                    //Start and give option to pause again
                    startMusic();
                }
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


    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playMusic.setText("Play");
        }
    }

    public void startMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            playMusic.setText("Pause");

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    playMusic.setText("Play");
                    playNextSong();
                }
            });
        }
    }

    private void playNextSong() {
        currentSongIndex = (currentSongIndex + 1) % songs.length;
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), songs[currentSongIndex]);
    }
}

package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class Media extends AppCompatActivity {

    private Button playVideo;
    private MediaPlayer mediaPlayer;

    private Button playMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        VideoView videoView = findViewById(R.id.videoView);
        String videopath = "android.resource://"+getPackageName()+"/"+R.raw.mariottcommercial;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoPath(uri.toString());

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        //playing music.

        mediaPlayer = new MediaPlayer();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aboutfood);

        playMusic = (Button) findViewById(R.id.button_food);

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



    public void pauseMusic(){

        if (mediaPlayer != null){
            mediaPlayer.pause();
            playMusic.setText("Play");
        }
    }

    public void startMusic(){
        if (mediaPlayer != null){
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


package com.example.bookingapptim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //getSupportActionBar().hide();
        int SPLASH_TIME_OUT = 5000;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, LoginScreen.class);

                startActivity(intent);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;

import java.util.Timer;
import java.util.TimerTask;

public class Welcome extends AppCompatActivity {

    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run(){
                Intent intent = new Intent(Welcome.this, SignInActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }
}
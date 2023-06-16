package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddelivery.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }
}
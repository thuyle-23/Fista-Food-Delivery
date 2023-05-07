package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddressBookActivity extends AppCompatActivity {
    private ImageView imgBack;
    private TextView txtviewAddNewLocation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_address_book);

        imgBack = findViewById(R.id.imgBack);
        txtviewAddNewLocation = findViewById(R.id.txtviewAddNewLocation);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAccountPage();
            }
        });
        txtviewAddNewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewLocationPage();
            }
        });
    }

    public void backToAccountPage() {
        Intent intent = new Intent(AddressBookActivity.this, Account.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void openAddNewLocationPage(){
        Intent intent = new Intent(AddressBookActivity.this, AddLocationnActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
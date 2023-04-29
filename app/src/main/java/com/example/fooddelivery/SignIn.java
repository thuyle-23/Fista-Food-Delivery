package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
    private TextView txtPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sign_in);

        txtPhoneNumber = (TextView) findViewById(R.id.txtPhoneNumber);
        txtPhoneNumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openLoginPage();
            }
        });
    }
    public void openLoginPage(){
        Intent intent = new Intent(SignIn.this, Login.class);
        startActivity(intent);
    }
}
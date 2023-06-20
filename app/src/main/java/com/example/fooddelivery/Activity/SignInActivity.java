package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fooddelivery.R;

public class SignInActivity extends AppCompatActivity {
    private TextView txtPhoneNumber, txtPhoneNumber1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sign_in);

        txtPhoneNumber = (TextView) findViewById(R.id.txtPhoneNumber);
        txtPhoneNumber1 = (TextView) findViewById(R.id.txtPhoneNumber1);
        txtPhoneNumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openLoginPage();
            }
        });
        txtPhoneNumber1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEnterPasswordPage();
            }
        });
    }
    public void openLoginPage(){
        Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openEnterPasswordPage(){
        Intent intent = new Intent(SignInActivity.this, EnterPasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
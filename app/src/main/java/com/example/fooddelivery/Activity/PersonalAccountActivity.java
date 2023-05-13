package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.R;

public class PersonalAccountActivity extends AppCompatActivity {
    private ImageView imgBack;
    private TextView txtInputPassword, txtLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_personal_account);

        txtInputPassword = findViewById(R.id.txtInputPassword);
        txtLogOut = findViewById(R.id.txtLogOut);
        imgBack = findViewById(R.id.imgBack);
        txtInputPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openChangePasswordPage();
            }
        });
        txtLogOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SignOut();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backToAccountPage();
            }
        });
    }
    public void openChangePasswordPage(){
        Intent intent = new Intent(PersonalAccountActivity.this, ChangePasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void backToAccountPage(){
        Intent intent = new Intent(PersonalAccountActivity.this, AccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void SignOut(){
        Intent intent = new Intent(PersonalAccountActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
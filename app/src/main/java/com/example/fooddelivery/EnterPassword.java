package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EnterPassword extends AppCompatActivity {

    private Button btnSignIn;
    private ImageView imgBack;
    private TextView txtForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_enter_password);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);

        btnSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDashboardPage();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backToLoginPage();
            }
        });
        txtForgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openForgetPasswordPage();
            }
        });
    }
    public void openDashboardPage(){
        Intent intent = new Intent(EnterPassword.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void backToLoginPage(){
        Intent intent = new Intent(EnterPassword.this, Login.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void openForgetPasswordPage(){
        Intent intent = new Intent(EnterPassword.this, ForgetPasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
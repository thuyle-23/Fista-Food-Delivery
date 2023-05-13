package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.R;

public class EnterPasswordActivity extends AppCompatActivity {

    private Button btnSignIn;
    private ImageView imgBack;
    private TextView txtForgotPassword;
    private EditText txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_enter_password);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);
        txtPassword = findViewById(R.id.txtPassword);

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
        txtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });
    }
    public void openDashboardPage(){
        Intent intent = new Intent(EnterPasswordActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void backToLoginPage(){
        Intent intent = new Intent(EnterPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void openForgetPasswordPage(){
        Intent intent = new Intent(EnterPasswordActivity.this, ForgetPasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
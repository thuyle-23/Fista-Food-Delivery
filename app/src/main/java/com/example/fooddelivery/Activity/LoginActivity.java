package com.example.fooddelivery.Activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fooddelivery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button btnGetOTP;
    private ImageView imgBack;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnGetOTP = findViewById(R.id.btnGetOTP);
        imgBack = findViewById(R.id.imgBack);
        mAuth = FirebaseAuth.getInstance();

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToSignInPage();
            }
        });
        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGetOTP.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        String email, password;
                        email=String.valueOf(txtEmail.getText());
                        password=String.valueOf(txtPassword.getText());

                        if(TextUtils.isEmpty(email)){
                            Toast.makeText(LoginActivity.this, "Vui lòng nhập địa chỉ email",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(TextUtils.isEmpty(password)){
                            Toast.makeText(LoginActivity.this, "Vui lòng nhập mật khẩu",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    }
                });

            }
        });
//        txtphoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v, boolean hasFocus){
//                if(!hasFocus){
//                    hideKeyboard(v);
//                }
//            }
//        });

    }


    public void backToSignInPage() {
        Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
//    public void hideKeyboard(View view){
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }
    public void openConfirmOTPPage(){
        Intent intent = new Intent(LoginActivity.this, EnterPasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
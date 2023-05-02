package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;

import java.util.concurrent.TimeUnit;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


public class Login extends AppCompatActivity {

    private EditText txtphoneNumber;
    private Button btnGetOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        txtphoneNumber = findViewById(R.id.txtphoneNumber);
        btnGetOTP = findViewById(R.id.btnGetOTP);

        final ProgressBar progressBar = findViewById(R.id.progressBar);


        txtphoneNumber.addTextChangedListener(loginTextWatcher);
        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtphoneNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, "Enter mobile", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btnGetOTP.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber("+84" + txtphoneNumber.getText().toString(), 60, TimeUnit.SECONDS,
                        Login.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential){
                                progressBar.setVisibility(View.GONE);
                                btnGetOTP.setVisibility(View.VISIBLE);
                            }
                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e){
                                progressBar.setVisibility(View.GONE);
                                btnGetOTP.setVisibility(View.VISIBLE);
                                Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                btnGetOTP.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), ConfirmOTP.class);
                                intent.putExtra("mobile", txtphoneNumber.getText().toString());
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);
                            }
                        }
);
            }
        });
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String phoneNumber = txtphoneNumber.getText().toString().trim();

            btnGetOTP.setEnabled(!phoneNumber.isEmpty() && phoneNumber.length() == 9);
        }
        @Override public void afterTextChanged(Editable s) {

        }
    };
}
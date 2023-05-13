package com.example.fooddelivery.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooddelivery.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ConfirmOTPActivity extends AppCompatActivity {

    private EditText txtinputCode1, txtinputCode2, txtinputCode3, txtinputCode4, txtinputCode5, txtinputCode6;
    private String verificationId;
    private TextView txtphoneNumber;
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_confirmotp);

        imgBack = findViewById(R.id.imgBack);

        txtphoneNumber = findViewById(R.id.txtphoneNumber);
        txtphoneNumber.setText(String.format("+84%s", getIntent().getStringExtra("mobile")));

        txtinputCode1 = findViewById(R.id.txtinputCode1);
        txtinputCode2 = findViewById(R.id.txtinputCode2);
        txtinputCode3 = findViewById(R.id.txtinputCode3);
        txtinputCode4 = findViewById(R.id.txtinputCode4);
        txtinputCode5 = findViewById(R.id.txtinputCode5);
        txtinputCode6 = findViewById(R.id.txtinputCode6);

        setupOTPInputs();

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        final Button btnGetOTP = findViewById(R.id.btnGetOTP);
        verificationId = getIntent().getStringExtra("verificationId");

        btnGetOTP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openEnterPasswordPage();
            }

//            @Override
//            public void onClick(View v){
//                if(txtinputCode1.getText().toString().trim().isEmpty()
//                        || txtinputCode2.getText().toString().trim().isEmpty()
//                        || txtinputCode3.getText().toString().trim().isEmpty()
//                        || txtinputCode4.getText().toString().trim().isEmpty()
//                        || txtinputCode5.getText().toString().trim().isEmpty()
//                        || txtinputCode6.getText().toString().trim().isEmpty()){
//                    Toast.makeText(ConfirmOTPActivity.this,"Hãy nhập mã xác nhận OTP", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                String code = txtinputCode1.getText().toString() +
//                        txtinputCode2.getText().toString() +
//                        txtinputCode3.getText().toString() +
//                        txtinputCode4.getText().toString() +
//                        txtinputCode5.getText().toString() +
//                        txtinputCode6.getText().toString();
//
//                if(verificationId != null){
//                    progressBar.setVisibility(View.VISIBLE);
//                    btnGetOTP.setVisibility(View.INVISIBLE);
//                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, code);
//                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task){
//                            progressBar.setVisibility(View.GONE);
//                            btnGetOTP.setVisibility(View.VISIBLE);
//                            if(task.isSuccessful()){
//                                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                startActivity(intent);
//                            } else {
//                                Toast.makeText(ConfirmOTPActivity.this,"Mã xác nhận OTP không hợp lệ", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//            }
        });
        findViewById(R.id.txtResendOTP).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PhoneAuthProvider.getInstance().verifyPhoneNumber("+84" + getIntent().getStringExtra("mobile"), 60, TimeUnit.SECONDS,
                        ConfirmOTPActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential){}
                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e){
                                Toast.makeText(ConfirmOTPActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newVerificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                verificationId = newVerificationId;
                                Toast.makeText(ConfirmOTPActivity.this, "Mã xác nhận OTP được gửi thành công", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backToLoginPage();
            }
        });
    }

    private void setupOTPInputs() {
        txtinputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    txtinputCode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtinputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    txtinputCode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtinputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    txtinputCode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtinputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    txtinputCode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtinputCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    txtinputCode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    public void backToLoginPage(){
        Intent intent = new Intent(ConfirmOTPActivity.this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void openEnterPasswordPage(){
        Intent intent = new Intent(ConfirmOTPActivity.this, EnterPasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText txtphoneNumber;
    private Button btnGetOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        txtphoneNumber = findViewById(R.id.txtphoneNumber);
        btnGetOTP = findViewById(R.id.btnGetOTP);

        txtphoneNumber.addTextChangedListener(loginTextWatcher);

        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtphoneNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, "Enter mobile", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), ConfirmOTP.class);
                intent.putExtra("mobile", txtphoneNumber.getText().toString());
                startActivity(intent);
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
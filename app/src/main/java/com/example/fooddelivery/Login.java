package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        final EditText txtphoneNumber = findViewById(R.id.txtphoneNumber);
        Button btnGetOTP = findViewById(R.id.btnGetOTP);

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
}
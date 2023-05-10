package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PaymentMethodsActivity extends AppCompatActivity {
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_payment_methods);

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backToAccountPage();
            }
        });
    }
    public void backToAccountPage(){
        Intent intent = new Intent(PaymentMethodsActivity.this, Account.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
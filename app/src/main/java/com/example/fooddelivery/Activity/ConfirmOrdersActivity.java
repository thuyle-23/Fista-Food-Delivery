package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fooddelivery.R;

public class ConfirmOrdersActivity extends AppCompatActivity {
    private ImageView imgBack;
    private Button btnConfirmOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_confirm_orders);

        imgBack = findViewById(R.id.imgBack);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToDashboardPage();
            }
        });
        btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrderDetailPage();
            }
        });
    }
    public void backToDashboardPage() {
        Intent intent = new Intent(ConfirmOrdersActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void openOrderDetailPage(){
        Intent intent = new Intent(ConfirmOrdersActivity.this, OrderDetailsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
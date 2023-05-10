package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderDetailsActivity extends AppCompatActivity {
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_order_details);

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backConfirmOrderPage();
            }
        });
    }
    public void backConfirmOrderPage() {
        Intent intent = new Intent(OrderDetailsActivity.this, ConfirmOrdersActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
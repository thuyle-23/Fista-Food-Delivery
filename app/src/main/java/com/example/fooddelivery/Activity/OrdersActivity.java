package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fooddelivery.R;

public class OrdersActivity extends AppCompatActivity {

    private Button btnOrders;
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_orders);

        btnOrders = (Button) findViewById(R.id.btnOrders);
        imgBack = findViewById(R.id.imgBack);
        btnOrders.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSearchPage();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backToAccountPage();
            }
        });
    }
    public void openSearchPage(){
        Intent intent = new Intent(OrdersActivity.this, AccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void backToAccountPage(){
        Intent intent = new Intent(OrdersActivity.this, AccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
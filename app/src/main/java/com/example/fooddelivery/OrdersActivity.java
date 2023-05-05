package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrdersActivity extends AppCompatActivity {

    private Button btnOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_orders);

        btnOrders = (Button) findViewById(R.id.btnOrders);
        btnOrders.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSearchPage();
            }
        });
    }
    public void openSearchPage(){
        Intent intent = new Intent(OrdersActivity.this, Login.class);
        startActivity(intent);
    }
}
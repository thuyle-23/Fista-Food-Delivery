package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.example.fooddelivery.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AddToCartActivity extends AppCompatActivity {
    private AppCompatButton btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_to_cart);

        btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openConfirmOrdersPage();
            }
        });
    }
    public void openConfirmOrdersPage(){
        Intent intent = new Intent(AddToCartActivity.this, ConfirmOrdersActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class StoreInformationActivity extends AppCompatActivity {
    private ImageView imgBack;
    private TextView iv_view_rate, tv_change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_store_information);

        imgBack = findViewById(R.id.imgBack);
        iv_view_rate = findViewById(R.id.iv_view_rate);
        tv_change = findViewById(R.id.tv_change);

        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backtoSearchPage();
            }
        });
        tv_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                showBottomSheetDialog();
            }
        });
        iv_view_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRatingRestaurant();
            }
        });
    }
    public void backtoSearchPage(){
        Intent intent = new Intent(StoreInformationActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
    public void openRatingRestaurant(){
        Intent intent = new Intent(StoreInformationActivity.this, RatingRestaurantActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    private void showBottomSheetDialog(){
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.layout_bts_delivery_type);

        bottomSheetDialog.show();
    }
}
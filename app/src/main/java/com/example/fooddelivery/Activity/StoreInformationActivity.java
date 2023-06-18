package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.Model.StoreModel;
import com.example.fooddelivery.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreInformationActivity extends AppCompatActivity {
    private ImageView imgBack;
    private TextView iv_view_rate, tv_change;
    private TextView tvName, tvDistance, tvTimeMinus, tv_star_count, tv_comment_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_store_information);

        List<String> listVoucher = Arrays.asList("Giảm 50,000đ", "Giảm 30,000đ");

        StoreModel storeModel = new StoreModel("TocoToco - Tân Lập", "2km", "50 phút", listVoucher, 4.5, 18);

        imgBack = findViewById(R.id.imgBack);
        iv_view_rate = findViewById(R.id.iv_view_rate);
        tv_change = findViewById(R.id.tv_change);
        tvName = findViewById(R.id.tv_store_name);
        tvDistance = findViewById(R.id.tv_distance);
        tvTimeMinus = findViewById(R.id.tv_time_minus);
        tv_star_count = findViewById(R.id.tv_star_count);
        tv_comment_count = findViewById(R.id.tv_comment_count);

        tvName.setText(storeModel.getStoreName());
        tvDistance.setText(storeModel.getDistance());
        tvTimeMinus.setText(storeModel.getTime());
        tv_star_count.setText(String.format("%s", storeModel.getRating()));
        tv_comment_count.setText(String.format("%d đánh giá", storeModel.getNumberOfComment()));

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
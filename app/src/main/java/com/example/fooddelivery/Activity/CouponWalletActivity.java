package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fooddelivery.Adapter.ViewPagerAdapter;
import com.example.fooddelivery.R;
import com.google.android.material.tabs.TabLayout;

public class CouponWalletActivity extends AppCompatActivity {
    private TabLayout tab_layout;
    private ViewPager view_pager;
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_coupon_wallet);
        imgBack = findViewById(R.id.imgBack);

        tab_layout = findViewById(R.id.tab_layout);
        view_pager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        view_pager.setAdapter(viewPagerAdapter);
        tab_layout.setupWithViewPager(view_pager);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAccountPage();
            }
        });
    }
    public void backToAccountPage() {
        Intent intent = new Intent(CouponWalletActivity.this, AccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fooddelivery.R;

public class AccountActivity extends AppCompatActivity {
    private ImageView imgBack;
    private ConstraintLayout groupAddress, groupPersonalAccount,
            groupOrders, groupRating, groupLikeRestaurant, groupCouponWallet,
            groupPayment, groupSupport, groupNotify, groupPolicies;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_account);

        groupAddress = findViewById(R.id.groupAddress);
        groupPersonalAccount = findViewById(R.id.groupPersonalAccount);
        groupOrders = findViewById(R.id.groupOrders);
        groupRating = findViewById(R.id.groupRating);
        groupLikeRestaurant = findViewById(R.id.groupLikeRestaurant);
        groupCouponWallet = findViewById(R.id.groupCouponWallet);
        groupPayment = findViewById(R.id.groupPayment);
        groupSupport = findViewById(R.id.groupSupport);
        groupNotify = findViewById(R.id.groupNotify);
        groupPolicies = findViewById(R.id.groupPolicies);

        imgBack = findViewById(R.id.imgBack);
        groupAddress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAddressBookPage();
            }
        });
        groupPersonalAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPersonalAccountPage();
            }
        });
        groupOrders.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openOrdersPage();
            }
        });
        groupRating.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openRatingPage();
            }
        });
        groupLikeRestaurant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openLikeRestaurantPage();
            }
        });
        groupCouponWallet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCouponWalletPage();
            }
        });
        groupSupport.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSupportPage();
            }
        });
        groupNotify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openNotificationPage();
            }
        });
        groupPolicies.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPoliciesPage();
            }
        });
        groupPayment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPaymentMethodPage();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                backToDashboardPage();
            }
        });
    }
    public void openAddressBookPage(){
        Intent intent = new Intent(AccountActivity.this, AddressBookActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openPersonalAccountPage(){
        Intent intent = new Intent(AccountActivity.this, PersonalAccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openOrdersPage(){
        Intent intent = new Intent(AccountActivity.this, OrdersActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openRatingPage(){
        Intent intent = new Intent(AccountActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openLikeRestaurantPage(){
        Intent intent = new Intent(AccountActivity.this, LikeRestaurantActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openCouponWalletPage(){
        Intent intent = new Intent(AccountActivity.this, CouponWalletActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openSupportPage(){
        Intent intent = new Intent(AccountActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openNotificationPage(){
        Intent intent = new Intent(AccountActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openPoliciesPage(){
        Intent intent = new Intent(AccountActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openPaymentMethodPage(){
        Intent intent = new Intent(AccountActivity.this, PaymentMethodsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void backToDashboardPage(){
        Intent intent = new Intent(AccountActivity.this, DashboardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
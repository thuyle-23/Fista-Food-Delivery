package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Add_To_Cart_Activity extends AppCompatActivity {
    private AppCompatButton btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_to_cart);

        btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                showBottomSheetDialog();
            }
        });
//        btnConfirm.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                openConfirmOrdersPage();
//            }
//        });
    }
    public void openConfirmOrdersPage(){
        Intent intent = new Intent(Add_To_Cart_Activity.this, ConfirmOrdersActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    private void showBottomSheetDialog(){
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.layout_confirm_orders);

        bottomSheetDialog.show();
    }
}
package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fooddelivery.R;

public class AddNewOrderActivity extends AppCompatActivity {

    private ImageView iv_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_new_order);

        iv_edit = (ImageView) findViewById(R.id.iv_edit);

        iv_edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AddNewOrderActivity.this.finish();
            }
        });

    }
}
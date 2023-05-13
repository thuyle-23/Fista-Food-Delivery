package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddelivery.R;

public class SearchPageActivity extends AppCompatActivity {

    private ConstraintLayout ltRice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search_page);

        ltRice = findViewById(R.id.ltRice);
        ltRice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSearchFoodPage();
            }
        });
    }
    public void openSearchFoodPage(){
        Intent intent = new Intent(SearchPageActivity.this, SearchFoodActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
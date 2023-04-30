package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends AppCompatActivity {
    private ViewPager2 sliderScreen;
    private List<Image> imageList;
    private ImageAdapter adapter;
    private Handler sliderHandler = new Handler();
    private ListView listItemFood;
    private ImageView imageView;
    private ArrayList<FoodItem> foodItemArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dashboard);

        CreateSlider();
        AssignFoodFist();

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAccountPage();
            }
        });
    }
    public void openAccountPage(){
        Intent intent = new Intent(DashboardActivity.this, Account.class);
        startActivity(intent);
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            sliderScreen.setCurrentItem(sliderScreen.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable,2000);
    }

    public void AssignFoodFist() {
        foodItemArrayList = new ArrayList<FoodItem>();
        AdapterFoodItem adapterFoodItem;
        listItemFood = findViewById(R.id.list_item_food);

        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));

        adapterFoodItem = new AdapterFoodItem(DashboardActivity.this,R.layout.item_foods, foodItemArrayList);
        listItemFood.setAdapter(adapterFoodItem);
        setListViewHeightBasedOnChildren(listItemFood);
    }

    public void CreateSlider() {
        sliderScreen = findViewById(R.id.viewPager2);

        imageList = new ArrayList<>();
        imageList.add(new Image(R.drawable.test2));
        imageList.add(new Image(R.drawable.test2));
        imageList.add(new Image(R.drawable.test2));

        adapter = new ImageAdapter(imageList, sliderScreen);
        sliderScreen.setAdapter(adapter);

        sliderScreen.setOffscreenPageLimit(3);
        sliderScreen.setClipChildren(false);
        sliderScreen.setClipToPadding(false);

        sliderScreen.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(12));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1 - Math.abs(position);
                page.setScaleY(0.85f + r + 0.14f);
            }
        });

        sliderScreen.setPageTransformer(transformer);

        sliderScreen.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,2000);
            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
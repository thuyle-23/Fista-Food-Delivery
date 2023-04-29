package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private List<Image> imageList;
    private ImageAdapter adapter;
    private Handler sliderHandler = new Handler();
    private ListView list_item_food;

    private ArrayList<FoodItem> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dashboard);

        arr = new ArrayList<FoodItem>();
        AdapterFoodItem adapterFoodItem;
        list_item_food = findViewById(R.id.list_item_food);
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        arr.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));


        adapterFoodItem = new AdapterFoodItem(DashboardActivity.this,R.layout.item_foods,arr);
        list_item_food.setAdapter(adapterFoodItem);
        setListViewHeightBasedOnChildren(list_item_food);

        viewPager2 = findViewById(R.id.viewPager2);

        imageList = new ArrayList<>();
        imageList.add(new Image(R.drawable.test2));
        imageList.add(new Image(R.drawable.test2));
        imageList.add(new Image(R.drawable.test2));

        adapter = new ImageAdapter(imageList,viewPager2);
        viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(12));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1 - Math.abs(position);
                page.setScaleY(0.85f + r + 0.14f);
            }
        });

        viewPager2.setPageTransformer(transformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,2000);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
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
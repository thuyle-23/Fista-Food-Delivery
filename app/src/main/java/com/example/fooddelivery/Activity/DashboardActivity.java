package com.example.fooddelivery.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fooddelivery.Adapter.AdapterFoodItem;
import com.example.fooddelivery.Model.FoodItem;
import com.example.fooddelivery.Model.Image;
import com.example.fooddelivery.Adapter.ImageAdapter;
import com.example.fooddelivery.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends AppCompatActivity {
    private ViewPager2 sliderScreen;
    private List<Image> imageList;
    private ImageAdapter adapter;
    private Handler sliderHandler = new Handler();
    private ListView listItemFood;
    private ImageView imgMenuAccount, imageView26;
    private TextView textView18;
    private ArrayList<FoodItem> foodItemArrayList;
    private EditText txtFindFood;
    private TextView textView13;
    private ConstraintLayout groupSearchPage;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dashboard);

        CreateSlider();
        AssignFoodFist();

        imgMenuAccount = (ImageView) findViewById(R.id.imgMenuAccount);
        groupSearchPage = findViewById(R.id.groupSearchPage);
        imageView26 = findViewById(R.id.imageView26);
        textView18 = findViewById(R.id.textView18);
        textView13 = findViewById(R.id.textView13);
        listItemFood = findViewById(R.id.list_item_food);

        textView18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAddNewOrderPage();
            }
    });
        textView13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openConfirmOrderPage();
            }
        });
        imgMenuAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAccountPage();
            }
        });
        groupSearchPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSearchPage();
            }
        });
        imageView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                showBottomSheetDialog();
            }
        });
    }
    public void openAccountPage(){
        Intent intent = new Intent(DashboardActivity.this, AccountActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void openSearchPage(){
        Intent intent = new Intent(DashboardActivity.this, SearchPageActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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

        listItemFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(DashboardActivity.this, StoreInformationActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });
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
    private void showBottomSheetDialog(){
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.layout_add_to_cart);

        bottomSheetDialog.show();
    }
    public void openAddNewOrderPage(){
        Intent intent = new Intent(DashboardActivity.this, AddNewOrderActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openConfirmOrderPage(){
        Intent intent = new Intent(DashboardActivity.this, ConfirmOrdersActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
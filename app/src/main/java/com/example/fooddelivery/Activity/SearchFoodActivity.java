package com.example.fooddelivery.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fooddelivery.Adapter.AdapterFoodItem;
import com.example.fooddelivery.Adapter.CategoryAdapterSpinner;
import com.example.fooddelivery.Model.CategorySpinner;
import com.example.fooddelivery.Model.FoodItem;
import com.example.fooddelivery.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFoodActivity extends AppCompatActivity {
    private Spinner spnDanhMuc;
    private Spinner spnSapXep;

    private CategoryAdapterSpinner categoryAdapterSpinnerDanhMuc;
    private CategoryAdapterSpinner categoryAdapterSpinnerSapXep;

    private ArrayList<FoodItem> foodItemArrayList;
    private ListView listItemFood;

    private Handler sliderHandler = new Handler();
    private ImageView imgBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search_food);

        AssignFoodFist();

        spnDanhMuc = findViewById(R.id.spn_danhmuc);
        imgBack = findViewById(R.id.imgBack);
        categoryAdapterSpinnerDanhMuc = new CategoryAdapterSpinner(this,R.layout.item_selected_spinner,getListCategorySpinnerDanhMuc());
        spnDanhMuc.setAdapter(categoryAdapterSpinnerDanhMuc);
        spnDanhMuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SearchFoodActivity.this, categoryAdapterSpinnerDanhMuc.getItem(i).getName() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnSapXep = findViewById(R.id.spn_sapxep);
        categoryAdapterSpinnerSapXep = new CategoryAdapterSpinner(this,R.layout.item_selected_spinner,getListcategoryAdapterSpinnerSapXep());
        spnSapXep.setAdapter(categoryAdapterSpinnerSapXep);
        spnSapXep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SearchFoodActivity.this, categoryAdapterSpinnerSapXep.getItem(i).getName() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToSearchPage();
            }
        });
    }

    private List<CategorySpinner> getListCategorySpinnerDanhMuc(){
        List<CategorySpinner> list = new ArrayList<>();
        list.add(new CategorySpinner("Danh mục"));
        list.add(new CategorySpinner("data 2"));
        list.add(new CategorySpinner("data 3"));

        return list;
    }

    private List<CategorySpinner> getListcategoryAdapterSpinnerSapXep(){
        List<CategorySpinner> list = new ArrayList<>();
        list.add(new CategorySpinner("Sắp xếp"));
        list.add(new CategorySpinner("data 2"));
        list.add(new CategorySpinner("data 3"));

        return list;
    }

    public void AssignFoodFist() {
        foodItemArrayList = new ArrayList<FoodItem>();
        AdapterFoodItem adapterFoodItem;
        listItemFood = findViewById(R.id.list_food_search);

        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));
        foodItemArrayList.add(new FoodItem(R.drawable.food_test,"Quán Ông Tám - Lẩu Nướng Bình Dân","Cà phê sữa","5.0","(15+)","1.2 km"));


        adapterFoodItem = new AdapterFoodItem(SearchFoodActivity.this,R.layout.item_foods, foodItemArrayList);
        listItemFood.setAdapter(adapterFoodItem);
        setListViewHeightBasedOnChildren(listItemFood);
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
    public void backToSearchPage() {
        Intent intent = new Intent(SearchFoodActivity.this, SearchPageActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}

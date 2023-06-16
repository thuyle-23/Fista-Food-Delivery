package com.example.fooddelivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.fooddelivery.Adapter.AdapterRatingItem;
import com.example.fooddelivery.Model.RatingItem;
import com.example.fooddelivery.R;

import java.util.ArrayList;

public class RatingRestaurantActivity extends AppCompatActivity {
    private ListView listRating;
    private ImageView imgBack;
    private ArrayList ratingItemArrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rating_restaurant);

        listRating = findViewById(R.id.listRating);
        AssignRating();

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToStoreInformationPage();
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

            if (listItem != null) {
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

    public void AssignRating() {
        ratingItemArrayList = new ArrayList<RatingItem>();
        AdapterRatingItem adapterRatingItem;
        listRating = findViewById(R.id.listRating);

        ratingItemArrayList.add(new RatingItem(R.drawable.profile, R.drawable.food_test, "Nguyễn Văn A", "09/04/2023", "Trà sữa ngon lắm. Quán hỗ trợ " +
                "nhiệt tình. Cảm ơn quán.", "Trà sữa gạo rang", "Yakult trái cây"));
        ratingItemArrayList.add(new RatingItem(R.drawable.profile, R.drawable.food_test, "Nguyễn Văn A", "09/04/2023", "Trà sữa ngon lắm. Quán hỗ trợ " +
                "nhiệt tình. Cảm ơn quán.", "Trà sữa gạo rang", "Yakult trái cây"));
        ratingItemArrayList.add(new RatingItem(R.drawable.profile, R.drawable.food_test, "Nguyễn Văn A", "09/04/2023", "Trà sữa ngon lắm. Quán hỗ trợ " +
                "nhiệt tình. Cảm ơn quán.", "Trà sữa gạo rang", "Yakult trái cây"));
        ratingItemArrayList.add(new RatingItem(R.drawable.profile, R.drawable.food_test, "Nguyễn Văn A", "09/04/2023", "Trà sữa ngon lắm. Quán hỗ trợ " +
                "nhiệt tình. Cảm ơn quán.", "Trà sữa gạo rang", "Yakult trái cây"));
        ratingItemArrayList.add(new RatingItem(R.drawable.profile, R.drawable.food_test, "Nguyễn Văn A", "09/04/2023", "Trà sữa ngon lắm. Quán hỗ trợ " +
                "nhiệt tình. Cảm ơn quán.", "Trà sữa gạo rang", "Yakult trái cây"));
        adapterRatingItem = new AdapterRatingItem(RatingRestaurantActivity.this, R.layout.item_rating, ratingItemArrayList);
        listRating.setAdapter(adapterRatingItem);
        setListViewHeightBasedOnChildren(listRating);
    }

    public void backToStoreInformationPage() {
        Intent intent = new Intent(RatingRestaurantActivity.this, StoreInformationActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }

}
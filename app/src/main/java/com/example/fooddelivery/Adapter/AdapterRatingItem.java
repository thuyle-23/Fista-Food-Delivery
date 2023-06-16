package com.example.fooddelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.Model.RatingItem;
import com.example.fooddelivery.R;

import java.util.List;

public class AdapterRatingItem extends BaseAdapter {

    private Context context;
    private int layout;
    private List<RatingItem> arrList;

    public AdapterRatingItem(Context context, int layout, List<RatingItem> arrList) {
        this.context = context;
        this.layout = layout;
        this.arrList = arrList;
    }

    @Override
    public int getCount() {
        return arrList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout,null);

        RatingItem ratingItem = arrList.get(i);

        ImageView imageAccount = view.findViewById(R.id.imgAccount);
        ImageView imageFood = view.findViewById(R.id.imgFood);
        TextView nameCustomer = view.findViewById(R.id.txtCustomer);
        TextView dateRating = view.findViewById(R.id.date);
        TextView ratingInformation = view.findViewById(R.id.txtreview);
        TextView tagFood1 = view.findViewById(R.id.imgTag1);
        TextView tagFood2 = view.findViewById(R.id.imgTag2);

        imageAccount.setImageResource(ratingItem.getImageAccount());
        imageFood.setImageResource(ratingItem.getImageFood());
        nameCustomer.setText(ratingItem.getNameCustomer());
        dateRating.setText(ratingItem.getDateRating());
        ratingInformation.setText(ratingItem.getRatingInformation());
        tagFood1.setText(ratingItem.getTagFood1());
        tagFood2.setText(ratingItem.getTagFood2());
        return view;
    }
}

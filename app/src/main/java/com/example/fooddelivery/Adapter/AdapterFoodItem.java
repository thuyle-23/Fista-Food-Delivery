package com.example.fooddelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fooddelivery.Model.FoodItem;
import com.example.fooddelivery.R;

import java.util.List;

public class AdapterFoodItem extends BaseAdapter {

    private Context context;
    private int layout;
    private List<FoodItem> arrList;

    public AdapterFoodItem(Context context, int layout, List<FoodItem> arrList) {
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

        FoodItem foodItem = arrList.get(i);

        ImageView image_food_item = view.findViewById(R.id.image_item_food);
        TextView name_shop = view.findViewById(R.id.name_shop);
        TextView type_of_food = view.findViewById(R.id.type_of_food);
        TextView num_star = view.findViewById(R.id.num_star);
        TextView quantity_food = view.findViewById(R.id.quantity_food);
        TextView distance_shop = view.findViewById(R.id.distance_shop);

        image_food_item.setImageResource(foodItem.getImageItemShop());
        name_shop.setText(foodItem.getNameShop());
        type_of_food.setText(foodItem.getTypeOfFood());
        num_star.setText(foodItem.getNumStar());
        quantity_food.setText(foodItem.getQuantityFood());
        distance_shop.setText(foodItem.getDistanceShop());
        return view;
    }
}

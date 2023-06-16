package com.example.fooddelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fooddelivery.Model.CategorySpinner;
import com.example.fooddelivery.R;

import java.util.List;

public class CategoryAdapterSpinner extends ArrayAdapter <CategorySpinner>{

    public CategoryAdapterSpinner(@NonNull Context context, int resource, @NonNull List<CategorySpinner> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_spinner,parent,false);
        TextView tvSelected = convertView.findViewById(R.id.tv_selected);

        CategorySpinner categorySpinner = this.getItem(position);
        if(categorySpinner != null){
            tvSelected.setText(categorySpinner.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_spinner,parent,false);
        TextView tvCategory = convertView.findViewById(R.id.tv_category);

        CategorySpinner categorySpinner = this.getItem(position);
        if(categorySpinner != null){
            tvCategory.setText(categorySpinner.getName());
        }
        return convertView;
    }
}

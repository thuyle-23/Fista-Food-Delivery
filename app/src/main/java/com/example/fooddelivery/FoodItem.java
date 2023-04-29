package com.example.fooddelivery;

import android.widget.ImageView;

public class FoodItem {
    private int image_item_shop;
    private String name_shop;
    private String type_of_food;
    private String num_star;
    private String quantity_food;
    private String distance_shop;

    public FoodItem(int image_item_shop, String name_shop, String type_of_food, String num_star, String quantity_food, String distance_shop) {
        this.image_item_shop = image_item_shop;
        this.name_shop = name_shop;
        this.type_of_food = type_of_food;
        this.num_star = num_star;
        this.quantity_food = quantity_food;
        this.distance_shop = distance_shop;
    }

    public int getImage_item_shop() {
        return image_item_shop;
    }

    public void setImage_item_shop(int image_item_shop) {
        this.image_item_shop = image_item_shop;
    }

    public String getName_shop() {
        return name_shop;
    }

    public void setName_shop(String name_shop) {
        this.name_shop = name_shop;
    }

    public String getType_of_food() {
        return type_of_food;
    }

    public void setType_of_food(String type_of_food) {
        this.type_of_food = type_of_food;
    }

    public String getNum_star() {
        return num_star;
    }

    public void setNum_star(String num_star) {
        this.num_star = num_star;
    }

    public String getQuantity_food() {
        return quantity_food;
    }

    public void setQuantity_food(String quantity_food) {
        this.quantity_food = quantity_food;
    }

    public String getDistance_shop() {
        return distance_shop;
    }

    public void setDistance_shop(String distance_shop) {
        this.distance_shop = distance_shop;
    }
}

package com.example.fooddelivery.Model;

public class FoodItem {
    private int imageItemShop;
    private String nameShop;
    private String typeOfFood;
    private String numStar;
    private String quantityFood;
    private String distanceShop;

    public FoodItem(int imageItemShop, String nameShop, String typeOfFood, String numStar, String quantityFood, String distanceShop) {
        this.imageItemShop = imageItemShop;
        this.nameShop = nameShop;
        this.typeOfFood = typeOfFood;
        this.numStar = numStar;
        this.quantityFood = quantityFood;
        this.distanceShop = distanceShop;
    }

    public int getImageItemShop() {
        return imageItemShop;
    }

    public void setImageItemShop(int imageItemShop) {
        this.imageItemShop = imageItemShop;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getNumStar() {
        return numStar;
    }

    public void setNumStar(String numStar) {
        this.numStar = numStar;
    }

    public String getQuantityFood() {
        return quantityFood;
    }

    public void setQuantityFood(String quantityFood) {
        this.quantityFood = quantityFood;
    }

    public String getDistanceShop() {
        return distanceShop;
    }

    public void setDistanceShop(String distanceShop) {
        this.distanceShop = distanceShop;
    }
}

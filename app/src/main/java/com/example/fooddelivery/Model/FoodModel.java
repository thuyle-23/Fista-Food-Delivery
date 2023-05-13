package com.example.fooddelivery.Model;

public class FoodModel {
    private String resName;
    private String resID;
    private String foodName;
    private String srcPicture;
    private long unitPrice;

    public FoodModel() {
    }

    public FoodModel(String resName, String resID, String foodName, String srcPicture, long unitPrice) {
        this.resName = resName;
        this.resID = resID;
        this.foodName = foodName;
        this.srcPicture = srcPicture;
        this.unitPrice = unitPrice;
    }

    public String getResName() {
        return resName;
    }

    public String getResID() {
        return resID;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getSrcPicture() {
        return srcPicture;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setSrcPicture(String srcPicture) {
        this.srcPicture = srcPicture;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }
}

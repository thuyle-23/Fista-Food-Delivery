package com.example.fooddelivery.Model;

public class RestaurantModel {
    private String resName;
    private String resLocation;
    private String resPhoneNumber;
    private String resTypeDelivery;

    public RestaurantModel() {
    }

    public RestaurantModel(String resName, String resLocation, String resPhoneNumber, String resTypeDelivery) {
        this.resName = resName;
        this.resLocation = resLocation;
        this.resPhoneNumber = resPhoneNumber;
        this.resTypeDelivery = resTypeDelivery;
    }

    public String getResName() {
        return resName;
    }

    public String getResLocation() {
        return resLocation;
    }

    public String getResPhoneNumber() {
        return resPhoneNumber;
    }

    public String getResTypeDelivery() {
        return resTypeDelivery;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public void setResLocation(String resLocation) {
        this.resLocation = resLocation;
    }

    public void setResPhoneNumber(String resPhoneNumber) {
        this.resPhoneNumber = resPhoneNumber;
    }

    public void setResTypeDelivery(String resTypeDelivery) {
        this.resTypeDelivery = resTypeDelivery;
    }
}

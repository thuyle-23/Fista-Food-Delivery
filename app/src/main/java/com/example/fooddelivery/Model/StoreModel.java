package com.example.fooddelivery.Model;

import java.io.Serializable;
import java.util.List;

public class StoreModel implements Serializable {

    private String storeName;

    private String distance;

    private String time;

    private List<String> listVoucher;

    private double rating;

    private int numberOfComment;

    public StoreModel(String storeName, String distance, String time, List<String> listVoucher, double rating, int numberOfComment) {
        this.storeName = storeName;
        this.distance = distance;
        this.time = time;
        this.listVoucher = listVoucher;
        this.rating = rating;
        this.numberOfComment = numberOfComment;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getListVoucher() {
        return listVoucher;
    }

    public void setListVoucher(List<String> listVoucher) {
        this.listVoucher = listVoucher;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfComment() {
        return numberOfComment;
    }

    public void setNumberOfComment(int numberOfComment) {
        this.numberOfComment = numberOfComment;
    }
}

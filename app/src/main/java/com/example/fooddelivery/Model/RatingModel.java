package com.example.fooddelivery.Model;

public class RatingModel {
    private String fullName;
    private String emailAddress;
    private String resID;
    private String foodID;
    private String rateValue;
    private String comment;
    private String dateRating;

    public RatingModel() {
    }

    public RatingModel(String fullName, String emailAddress, String resID, String foodID, String rateValue, String comment, String dateRating) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.resID = resID;
        this.foodID = foodID;
        this.rateValue = rateValue;
        this.comment = comment;
        this.dateRating = dateRating;
    }

    public RatingModel(String fullName, String resID, String foodID, String rateValue, String comment, String dateRating) {
        this.fullName = fullName;
        this.resID = resID;
        this.foodID = foodID;
        this.rateValue = rateValue;
        this.comment = comment;
        this.dateRating = dateRating;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getResID() {
        return resID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getRateValue() {
        return rateValue;
    }

    public void setRateValue(String rateValue) {
        this.rateValue = rateValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDateRating() {
        return dateRating;
    }

    public void setDateRating(String dateRating) {
        this.dateRating = dateRating;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

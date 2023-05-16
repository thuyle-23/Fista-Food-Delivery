package com.example.fooddelivery.Model;

public class RatingItem {
    private int imageAccount;
    private int imageFood;
    private String nameCustomer;
    private String dateRating;
    private String ratingInformation;
    private String tagFood1;
    private String tagFood2;

    public RatingItem(int imageAccount, int imageFood, String nameCustomer, String dateRating, String ratingInformation, String tagFood1, String tagFood2) {
        this.imageAccount = imageAccount;
        this.imageFood = imageFood;
        this.nameCustomer = nameCustomer;
        this.dateRating = dateRating;
        this.ratingInformation = ratingInformation;
        this.tagFood1 = tagFood1;
        this.tagFood2 = tagFood2;
    }

    public RatingItem() {
    }

    public int getImageAccount() {
        return imageAccount;
    }

    public void setImageAccount(int imageAccount) {
        this.imageAccount = imageAccount;
    }

    public int getImageFood() {
        return imageFood;
    }

    public void setImageFood(int imageFood) {
        this.imageFood = imageFood;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateRating() {
        return dateRating;
    }

    public void setDateRating(String dateRating) {
        this.dateRating = dateRating;
    }

    public String getRatingInformation() {
        return ratingInformation;
    }

    public void setRatingInformation(String ratingInformation) {
        this.ratingInformation = ratingInformation;
    }

    public String getTagFood1() {
        return tagFood1;
    }

    public void setTagFood1(String tagFood1) {
        this.tagFood1 = tagFood1;
    }

    public String getTagFood2() {
        return tagFood2;
    }

    public void setTagFood2(String tagFood2) {
        this.tagFood2 = tagFood2;
    }
}

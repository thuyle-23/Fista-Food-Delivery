package com.example.fooddelivery.Model;

public class CartModel {
    private String userAddress;
    private String timeDelivery;
    private String foodName;
    private String resName;
    private String srcPicture;
    private long unitPrice;
    private int quantity;
    private long totalPrice;
    private String paymentMethod;
    private String voucherName;
    private long shippingCharge;
    private String note;

    public CartModel() {
    }

    public CartModel(String userAddress, String timeDelivery, String foodName, String resName, String srcPicture, long unitPrice, int quantity, long totalPrice, String paymentMethod, String voucherName, long shippingCharge, String note) {
        this.userAddress = userAddress;
        this.timeDelivery = timeDelivery;
        this.foodName = foodName;
        this.resName = resName;
        this.srcPicture = srcPicture;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.voucherName = voucherName;
        this.shippingCharge = shippingCharge;
        this.note = note;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getTimeDelivery() {
        return timeDelivery;
    }

    public void setTimeDelivery(String timeDelivery) {
        this.timeDelivery = timeDelivery;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getSrcPicture() {
        return srcPicture;
    }

    public void setSrcPicture(String srcPicture) {
        this.srcPicture = srcPicture;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public long getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(long shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

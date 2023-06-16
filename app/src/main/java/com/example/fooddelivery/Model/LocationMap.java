package com.example.fooddelivery.Model;

public class LocationMap {
    private String CityName;
    private String Note;
    private String NameAddress;
    private String NameStreet;
    private String SuburName;


    public LocationMap(String cityName, String note, String nameAddress, String nameStreet, String suburName) {
        CityName = cityName;
        Note = note;
        NameAddress = nameAddress;
        NameStreet = nameStreet;
        SuburName = suburName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getNameAddress() {
        return NameAddress;
    }

    public void setNameAddress(String nameAddress) {
        NameAddress = nameAddress;
    }

    public String getNameStreet() {
        return NameStreet;
    }

    public void setNameStreet(String nameStreet) {
        NameStreet = nameStreet;
    }

    public String getSuburName() {
        return SuburName;
    }

    public void setSuburName(String suburName) {
        SuburName = suburName;
    }
}

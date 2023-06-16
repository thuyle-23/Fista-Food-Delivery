package com.example.fooddelivery.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Address implements Parcelable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address(String id, String cityname, String note, String nameAddress, String nameStreet, String suburName) {
        this.id = id;
        Cityname = cityname;
        Note = note;
        this.nameAddress = nameAddress;
        this.nameStreet = nameStreet;
        this.suburName = suburName;
    }

    String id ;
    String Cityname ;
    String Note ;
    String nameAddress ;
    String nameStreet ;
    String suburName ;

    public Address() {
    }

    public Address(String cityname, String note, String nameAddress, String nameStreet, String suburName) {
        Cityname = cityname;
        Note = note;
        this.nameAddress = nameAddress;
        this.nameStreet = nameStreet;
        this.suburName = suburName;
    }


    protected Address(Parcel in) {
        id = in.readString();
        Cityname = in.readString();
        Note = in.readString();
        nameAddress = in.readString();
        nameStreet = in.readString();
        suburName = in.readString();
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    public String getCityname() {
        return Cityname;
    }

    public void setCityname(String cityname) {
        Cityname = cityname;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public String getSuburName() {
        return suburName;
    }

    public void setSuburName(String suburName) {
        this.suburName = suburName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Cityname='" + Cityname + '\'' +
                ", Note='" + Note + '\'' +
                ", nameAddress='" + nameAddress + '\'' +
                ", nameStreet='" + nameStreet + '\'' +
                ", suburName='" + suburName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(Cityname);
        parcel.writeString(Note);
        parcel.writeString(nameAddress);
        parcel.writeString(nameStreet);
        parcel.writeString(suburName);
    }
}

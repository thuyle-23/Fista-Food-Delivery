package com.example.fooddelivery.Model;

public class UserModel {
    private String fullName;
    private String phoneNumber;
    private String password;
    private String emailAddress;
    private String gender;
    private String dateOfBirth;
    private  String jobOccupation;

    public UserModel(String fullName, String phoneNumber, String password, String emailAddress, String gender, String dateOfBirth, String jobOccupation) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.emailAddress = emailAddress;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.jobOccupation = jobOccupation;
    }

    public UserModel() {
    }

    public UserModel(String fullName, String phoneNumber, String password, String gender, String dateOfBirth, String jobOccupation) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.jobOccupation = jobOccupation;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getJobOccupation() {
        return jobOccupation;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setJobOccupation(String jobOccupation) {
        this.jobOccupation = jobOccupation;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}





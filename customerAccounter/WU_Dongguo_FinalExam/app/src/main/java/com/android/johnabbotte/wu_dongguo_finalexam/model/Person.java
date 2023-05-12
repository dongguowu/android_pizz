package com.android.johnabbotte.wu_dongguo_finalexam.model;

import java.io.Serializable;

public class Person implements Serializable {

    private int id;
    private String lName;
    private String fName;
    private String phoneNumber;
    private String numberOfSIN;

    public Person(int id, String lName, String fName, String phoneNumber, String numberOfSIN) {
        this.id = id;
        this.lName = lName;
        this.fName = fName;
        this.phoneNumber = phoneNumber;
        this.numberOfSIN = numberOfSIN;
    }

    @Override
    public String toString() {
        return  lName + '\'' +
                "; " + fName + '\'' +
                "; " + phoneNumber + '\'' +
                "; " + numberOfSIN + '\'';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumberOfSIN() {
        return numberOfSIN;
    }

    public void setNumberOfSIN(String numberOfSIN) {
        this.numberOfSIN = numberOfSIN;
    }
}

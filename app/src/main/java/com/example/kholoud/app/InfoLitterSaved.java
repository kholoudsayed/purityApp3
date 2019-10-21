package com.example.kholoud.app;

/**
 * Created by kholoud on 10/21/2019.
 */

public class InfoLitterSaved {


    private  String type;
    private  String phone;
    private  String  numbags;
    private  String litterType;

    public InfoLitterSaved(String type, String phone, String numbags, String litterType) {
        this.type = type;
        this.phone = phone;
        this.numbags = numbags;
        this.litterType = litterType;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumbags() {
        return numbags;
    }

    public void setNumbags(String numbags) {
        this.numbags = numbags;
    }

    public String getLitterType() {
        return litterType;
    }

    public void setLitterType(String litterType) {
        this.litterType = litterType;
    }
}

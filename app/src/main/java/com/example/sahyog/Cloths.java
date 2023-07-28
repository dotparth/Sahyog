package com.example.sahyog;

public class Cloths {

    String categorystr,
            sizestr,
            quantitystr,
            conditionstr,
            phonestr,
            adstr;

    public Cloths() {
    }

    public Cloths(String categorystr, String sizestr, String quantitystr, String conditionstr, String phonestr, String adstr) {
        this.categorystr = categorystr;
        this.sizestr = sizestr;
        this.quantitystr = quantitystr;
        this.conditionstr = conditionstr;
        this.phonestr = phonestr;
        this.adstr = adstr;
    }

    public String getCategorystr() {
        return categorystr;
    }

    public void setCategorystr(String categorystr) {
        this.categorystr = categorystr;
    }

    public String getSizestr() {
        return sizestr;
    }

    public void setSizestr(String sizestr) {
        this.sizestr = sizestr;
    }

    public String getQuantitystr() {
        return quantitystr;
    }

    public void setQuantitystr(String quantitystr) {
        this.quantitystr = quantitystr;
    }

    public String getConditionstr() {
        return conditionstr;
    }

    public void setConditionstr(String conditionstr) {
        this.conditionstr = conditionstr;
    }

    public String getPhonestr() {
        return phonestr;
    }

    public void setPhonestr(String phonestr) {
        this.phonestr = phonestr;
    }

    public String getAdstr() {
        return adstr;
    }

    public void setAdstr(String adstr) {
        this.adstr = adstr;
    }
}

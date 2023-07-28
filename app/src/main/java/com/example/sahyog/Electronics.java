package com.example.sahyog;

public class Electronics {
    String categorystr, quantitystr, phonestr, adstr,typestr;

    public Electronics() {
    }

    public Electronics(String categorystr, String quantitystr, String phonestr, String adstr, String typestr) {
        this.categorystr = categorystr;
        this.quantitystr = quantitystr;
        this.phonestr = phonestr;
        this.adstr = adstr;
        this.typestr = typestr;
    }


    public String getCategorystr() {
        return categorystr;
    }

    public void setCategorystr(String categorystr) {
        this.categorystr = categorystr;
    }

    public String getQuantitystr() {
        return quantitystr;
    }

    public void setQuantitystr(String quantitystr) {
        this.quantitystr = quantitystr;
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

    public String getTypestr() {
        return typestr;
    }

    public void setTypestr(String typestr) {
        this.typestr = typestr;
    }
}

package com.example.sahyog;

public class Allcloths {
    String categorystr,
            sizestr,
            typestr,
            quantitystr,
            conditionstr,
            phonestr,
            adstr;



    public Allcloths(String categorystr, String sizestr, String typestr, String quantitystr, String conditionstr, String phonestr, String adstr) {
        this.categorystr = categorystr;
        this.sizestr = sizestr;
        this.typestr = typestr;
        this.quantitystr = quantitystr;
        this.conditionstr = conditionstr;
        this.phonestr = phonestr;
        this.adstr = adstr;
    }

    public String getCategorystr() {
        return categorystr;
    }

    public String getSizestr() {
        return sizestr;
    }

    public String getTypestr() {
        return typestr;
    }

    public String getQuantitystr() {
        return quantitystr;
    }

    public String getConditionstr() {
        return conditionstr;
    }

    public String getPhonestr() {
        return phonestr;
    }

    public String getAdstr() {
        return adstr;
    }
}

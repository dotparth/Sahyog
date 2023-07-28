package com.example.sahyog;

import android.widget.EditText;

public class Books {

    String categorystr, namestr,editionstr,authorstr,quantitystr,phonestr,addstr;



    public Books(String categorystr, String namestr, String editionstr, String authorstr, String quantitystr, String phonestr, String addstr) {
        this.categorystr = categorystr;
        this.namestr = namestr;
        this.editionstr = editionstr;
        this.authorstr = authorstr;
        this.quantitystr = quantitystr;
        this.phonestr = phonestr;
        this.addstr = addstr;
    }

    public String getCategorystr() {
        return categorystr;
    }

    public String getNamestr() {
        return namestr;
    }

    public String getEditionstr() {
        return editionstr;
    }

    public String getAuthorstr() {
        return authorstr;
    }

    public String getQuantitystr() {
        return quantitystr;
    }

    public String getPhonestr() {
        return phonestr;
    }

    public String getAddstr() {
        return addstr;
    }
}
package com.example.sahyog;

public class Display2 {

    String Itemname,Requester,Phoneno,Address;

    public Display2(String itemname, String requester, String phoneno, String address) {
        Itemname = itemname;
        Requester = requester;
        Phoneno = phoneno;
        Address = address;
    }

    public String getItemname() {
        return Itemname;
    }

    public String getRequester() {
        return Requester;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public String getAddress() {
        return Address;
    }
}

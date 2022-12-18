package com.example.mobiledevproj;

public class writtenmeds {
    public String id;
    public String name;
    //public double price;

    public writtenmeds() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public writtenmeds(String id, String name) {
        this.id = id;
        this.name = name;
        //this.price = price;
    }

    public String getMedId(){
        return id;
    }
    public String getMedName(){
        return name;
    }

    //public Double getMedPrice(){
     //   return price;
    //}


}

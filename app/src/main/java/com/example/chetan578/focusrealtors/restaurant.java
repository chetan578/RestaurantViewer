package com.example.chetan578.RestaurantViewer;

public class restaurant {
    private  String name;
    private  String location;
    private  String image;
    private  String expense;
    private String timing;
    public  restaurant (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getImage() {
        return image;

    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public restaurant(String name, String location, String image, String expense,String timing) {
        this.name = name;
        this.location = location;
        this.image = image;
        this.expense = expense;
        this.timing=timing;

    }
}

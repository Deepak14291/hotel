package com.example.hotelapp.model;

public class RoomType {
    // Fields
    private int img;
    private String name;
    private String price;

    // Getter and Setter methods for 'img'
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    // Getter and Setter methods for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for 'price'
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public RoomType(int img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }
}

package com.example.hotelapp.model;

public class RoomType {
    // Fields
    private String img;
    private String name;
    private String price;

    // Getter and Setter methods for 'img'
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
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
    public RoomType(String img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }
}

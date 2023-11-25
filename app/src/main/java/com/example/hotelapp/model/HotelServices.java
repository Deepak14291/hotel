package com.example.hotelapp.model;

public class HotelServices {

    // Fields
    private int image;
    private String name;
    private String description;

    // Constructor
    public HotelServices(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    // Getter and Setter methods for 'image'
    public int getImage() {
        return image;
    }


    // Getter and Setter methods for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for 'description'
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

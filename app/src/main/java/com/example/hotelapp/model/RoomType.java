package com.example.hotelapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class RoomType implements Parcelable {
    private final int img; // Image resource ID for the room
    private String name; // Room type name
    private final String price; // Room price
    private String date; // Selected date for booking
    private final int availableRooms; // Number of available rooms

    // Parcelable creator
    public static final Creator<RoomType> CREATOR = new Creator<RoomType>() {
        @Override
        public RoomType createFromParcel(Parcel in) {
            return new RoomType(in);
        }

        @Override
        public RoomType[] newArray(int size) {
            return new RoomType[size];
        }
    };

    // Constructor
    public RoomType(int img, String name, String price, String date, int availableRooms) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.date = date;
        this.availableRooms = availableRooms;
    }

    // Parcelable constructor
    protected RoomType(Parcel in) {
        img = in.readInt();
        name = in.readString();
        price = in.readString();
        date = in.readString();
        availableRooms = in.readInt();
    }

    // Getter and Setter methods for 'availableRooms'
    public int getAvailableRooms() {
        return availableRooms;
    }

    // Getter and Setter methods for 'img'
    public int getImg() {
        return img;
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

    // Getter and Setter methods for 'date'
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Parcelable methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(img);
        parcel.writeString(name);
        parcel.writeString(price);
        parcel.writeString(date);
        parcel.writeInt(availableRooms);
    }
}

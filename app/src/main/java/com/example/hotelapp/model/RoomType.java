package com.example.hotelapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class RoomType implements Parcelable {
    // Fields
    private int img;
    private String name;
    private String price;
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
    private String date = "";
    private int availableRooms = 0;

    public RoomType(int img, String name, String price, String date, int availableRooms) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.date = date;
        this.availableRooms = availableRooms;
    }

    protected RoomType(Parcel in) {
        img = in.readInt();
        name = in.readString();
        price = in.readString();
        date = in.readString();
        availableRooms = in.readInt();
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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
    }
}

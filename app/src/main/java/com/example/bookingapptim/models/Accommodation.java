package com.example.bookingapptim.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Accommodation implements Parcelable {

    private String Name;
    private String Description;
    private String Address;

    private int Price;

    public Accommodation(String name, String description, String address, int price) {
        Name = name;
        Description = description;
        Address = address;
        Price = price;
    }

    protected Accommodation(Parcel in) {
        Name = in.readString();
        Description = in.readString();
        Address = in.readString();
        Price = in.readInt();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public static final Creator<Accommodation> CREATOR = new Creator<Accommodation>() {
        @Override
        public Accommodation createFromParcel(Parcel in) {
            return new Accommodation(in);
        }

        @Override
        public Accommodation[] newArray(int size) {
            return new Accommodation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Description);
        dest.writeString(Address);
        dest.writeInt(Price);
    }
}

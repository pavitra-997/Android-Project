package com.example.project;

import android.os.Parcel;
import android.os.Parcelable;

public class MyData implements Parcelable {
    private String name;

    public MyData(String name, String price, String description,int Image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.Image=Image;
    }

    protected MyData(Parcel in) {
        name = in.readString();
        price = in.readString();
        description = in.readString();
        Image = in.readInt();
    }

    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String price;
    private String description;
    private int Image;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(price);
        parcel.writeString(description);
        parcel.writeInt(Image);
    }
}

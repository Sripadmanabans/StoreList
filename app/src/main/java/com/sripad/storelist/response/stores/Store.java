package com.sripad.storelist.response.stores;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that holds the stores data.
 * Created by Sripad on 1/23/2016.
 */
public class Store implements Parcelable {

    @SerializedName("storeID")
    private int storeID;

    @SerializedName("name")
    private String name;

    @SerializedName("storeLogoURL")
    private String storeLogoUrl;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;

    @SerializedName("zipcode")
    private int zipCode;

    @SerializedName("phone")
    private String phone;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    protected Store(Parcel in) {
        storeID = in.readInt();
        name = in.readString();
        storeLogoUrl = in.readString();
        address = in.readString();
        city = in.readString();
        state = in.readString();
        zipCode = in.readInt();
        phone = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getStoreLogoUrl() {
        return storeLogoUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(storeID);
        dest.writeString(name);
        dest.writeString(storeLogoUrl);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeInt(zipCode);
        dest.writeString(phone);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}
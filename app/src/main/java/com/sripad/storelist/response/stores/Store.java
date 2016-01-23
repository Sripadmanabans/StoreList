package com.sripad.storelist.response.stores;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that holds the stores data.
 * Created by Sripad on 1/23/2016.
 */
public class Store {

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

}
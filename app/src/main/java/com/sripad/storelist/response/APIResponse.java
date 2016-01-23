package com.sripad.storelist.response;

import com.google.gson.annotations.SerializedName;
import com.sripad.storelist.response.stores.Store;

import java.util.List;

/**
 * This is the response that is got when making the api call.
 * Created by Sripad on 1/23/2016.
 */
public class APIResponse {

    @SerializedName("stores")
    private List<Store> stores;

}

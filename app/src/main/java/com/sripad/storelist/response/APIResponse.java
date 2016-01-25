package com.sripad.storelist.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.sripad.storelist.response.stores.Store;

import java.util.List;

/**
 * This is the response that is got when making the api call.
 * Created by Sripad on 1/23/2016.
 */
public class APIResponse implements Parcelable {

    @SerializedName("stores")
    private List<Store> stores;

    protected APIResponse(Parcel in) {
        stores = in.createTypedArrayList(Store.CREATOR);
    }

    public static final Creator<APIResponse> CREATOR = new Creator<APIResponse>() {
        @Override
        public APIResponse createFromParcel(Parcel in) {
            return new APIResponse(in);
        }

        @Override
        public APIResponse[] newArray(int size) {
            return new APIResponse[size];
        }
    };

    public List<Store> getStores() {
        return stores;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(stores);
    }
}

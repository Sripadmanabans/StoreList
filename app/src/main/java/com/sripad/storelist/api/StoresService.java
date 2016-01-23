package com.sripad.storelist.api;

import com.sripad.storelist.response.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This is the interface used by retrofit to make calls to get store related data.
 * Created by Sripad on 1/23/2016.
 */
public interface StoresService {

    @GET("BR_Android_CodingExam_2015_Server/stores.json")
    Call<APIResponse> getStores();

}

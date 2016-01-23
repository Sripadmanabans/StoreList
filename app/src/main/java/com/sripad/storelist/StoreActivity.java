package com.sripad.storelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sripad.storelist.api.StoresService;
import com.sripad.storelist.response.APIResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StoresService storesService = retrofit.create(StoresService.class);

        Call<APIResponse> call = storesService.getStores();
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Response<APIResponse> response) {
                Log.d("TAG", response.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("TAG", "OOPS");
            }
        });
    }
}

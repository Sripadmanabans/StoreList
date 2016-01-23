package com.sripad.storelist;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.sripad.storelist.adapter.StoreAdapter;
import com.sripad.storelist.api.StoresService;
import com.sripad.storelist.response.APIResponse;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StoreActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.store_list)
    RecyclerView storeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        storeList.setLayoutManager(new LinearLayoutManager(this));
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
                storeList.setAdapter(new StoreAdapter(response.body()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("TAG", "OOPS");
            }
        });
    }
}

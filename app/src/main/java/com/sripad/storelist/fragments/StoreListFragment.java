package com.sripad.storelist.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sripad.storelist.R;
import com.sripad.storelist.activities.DetailsActivity;
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

/**
 * This is the fragment that is used to list the details of the store.
 * Created by Sripad on 1/25/2016.
 */
public class StoreListFragment extends Fragment {

    private StoreAdapter storeAdapter;

    @Bind(R.id.store_list)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_list, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StoresService storesService = retrofit.create(StoresService.class);

        Call<APIResponse> call = storesService.getStores();
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(final Response<APIResponse> response) {
                Log.d("TAG", response.toString());
                storeAdapter = new StoreAdapter(response.body());
                storeAdapter.setOnRecycleItemClickListener(new StoreAdapter.OnRecycleItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), DetailsActivity.class);
                        intent.putExtra("List", response.body());
                        intent.putExtra("Position", position);
                        startActivity(intent);
                    }
                });
                recyclerView.setAdapter(new StoreAdapter(response.body()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("TAG", "OOPS");
            }
        });
    }
}

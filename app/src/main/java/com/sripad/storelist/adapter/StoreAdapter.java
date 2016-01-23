package com.sripad.storelist.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sripad.storelist.R;
import com.sripad.storelist.response.APIResponse;
import com.sripad.storelist.response.stores.Store;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * This is the class responsible for populating the recycler view.
 * Created by Sripad on 1/23/2016.
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    private APIResponse response;

    public StoreAdapter(APIResponse response) {
        this.response = response;
    }

    @Override
    public StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_list_item, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoreViewHolder holder, int position) {
        final Store store = response.getStores().get(position);
        holder.storeNameTextView.setText(store.getName());
        holder.storeAddressTextView.setText(store.getAddress());
        holder.storeAddressRestTextView.setText(getRestOfAddress(store));
        holder.storePhoneTextView.setText(store.getPhone());
        Picasso.with(holder.storeLogoImageView.getContext())
                .load(store.getStoreLogoUrl())
                .into(holder.storeLogoImageView);
    }

    @Override
    public int getItemCount() {
        return response.getStores().size();
    }

    /**
     * This is a function that is used to get the rest of the address
     *
     * @param store An object of the store who's address is required.
     * @return A string that is formatted with the city, state and the zip code.
     */
    private String getRestOfAddress(Store store) {
        return store.getCity() + ", " + store.getState() + " - " + store.getZipCode();
    }

    protected static class StoreViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.store_logo)
        ImageView storeLogoImageView;

        @Bind(R.id.store_name)
        TextView storeNameTextView;

        @Bind(R.id.store_address)
        TextView storeAddressTextView;

        @Bind(R.id.store_city_state_zipCode)
        TextView storeAddressRestTextView;

        @Bind(R.id.store_phone)
        TextView storePhoneTextView;

        public StoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

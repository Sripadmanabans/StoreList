package com.sripad.storelist.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sripad.storelist.R;
import com.sripad.storelist.response.stores.Store;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * This is the adapter that is used to show the details.
 * Created by Sripad on 1/25/2016.
 */
public class DetailsPagerAdapter extends PagerAdapter {

    private List<Store> stores;
    private ViewHolder viewHolder;

    public DetailsPagerAdapter(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public int getCount() {
        return stores.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.view_pager_item, container, false);
        viewHolder = new ViewHolder(view);

        Store store = stores.get(position);

        Picasso.with(viewHolder.storeLogoImageView.getContext())
                .load(store.getStoreLogoUrl())
                .into(viewHolder.storeLogoImageView);

        viewHolder.storeNameTextView.setText(store.getName());
        viewHolder.storeAddressTextView.setText(store.getAddress());
        viewHolder.storeRestAddressTextView.setText(getRestOfAddress(store));
        viewHolder.storePhoneTextView.setText(store.getPhone());

        container.addView(view);

        return view;
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

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    static class ViewHolder {

        @Bind(R.id.store_logo)
        ImageView storeLogoImageView;

        @Bind(R.id.store_name)
        TextView storeNameTextView;

        @Bind(R.id.store_address)
        TextView storeAddressTextView;

        @Bind(R.id.store_city_state_zipCode)
        TextView storeRestAddressTextView;

        @Bind(R.id.store_phone)
        TextView storePhoneTextView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

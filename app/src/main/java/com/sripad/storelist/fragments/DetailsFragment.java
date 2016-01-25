package com.sripad.storelist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sripad.storelist.R;
import com.sripad.storelist.adapter.DetailsPagerAdapter;
import com.sripad.storelist.response.APIResponse;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * This is the fragment that shows the details of the stores.
 * Created by Sripad on 1/25/2016.
 */
public class DetailsFragment extends Fragment {

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detials, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null) {
            final APIResponse response = bundle.getParcelable("Response");
            final int position = bundle.getInt("Position");
            if(response != null) {
                DetailsPagerAdapter pagerAdapter = new DetailsPagerAdapter(response.getStores());
                viewPager.setAdapter(pagerAdapter);
                viewPager.setCurrentItem(position);
                ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
                if(actionBar != null) {
                    actionBar.setTitle(response.getStores().get(position).getName());
                }
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
                        if(actionBar != null) {
                            actionBar.setTitle(response.getStores().get(position).getName());
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        }
        return view;
    }
}

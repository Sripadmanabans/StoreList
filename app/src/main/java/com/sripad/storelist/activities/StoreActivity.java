package com.sripad.storelist.activities;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sripad.storelist.R;
import com.sripad.storelist.fragments.StoreListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, new StoreListFragment(),
                StoreListFragment.class.getSimpleName());
        transaction.commit();
    }
}

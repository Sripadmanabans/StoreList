package com.sripad.storelist.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sripad.storelist.R;
import com.sripad.storelist.fragments.DetailsFragment;
import com.sripad.storelist.fragments.StoreListFragment;
import com.sripad.storelist.response.APIResponse;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * This is the activity that acts as the holder for the details fragment.
 * Created by Sripad on 1/25/2016.
 */
public class DetailsActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        APIResponse response = getIntent().getParcelableExtra("List");
        Bundle bundle = new Bundle();
        bundle.putParcelable("Response", response);
        bundle.putInt("Position", getIntent().getIntExtra("Position", 0));
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, detailsFragment,
                DetailsFragment.class.getSimpleName());
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

package com.example.prakhar1001.database123;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial button fragment to be inserted
        ButtonFragment buttonFragment = new ButtonFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if (savedInstanceState == null) {
            fragmentTransaction.replace(R.id.activityfrag, buttonFragment, null);
        } else {
            if (savedInstanceState.getInt("AddFragment") == 2) {
                fragmentTransaction.replace(R.id.activityfrag, new AddFragment(), null);
            }
            if (savedInstanceState.getInt("SearchFragment") == 3) {
                fragmentTransaction.replace(R.id.activityfrag, new SearchFragment(), null);
            }
            if (savedInstanceState.getInt("BrowseFragment") == 4) {
                fragmentTransaction.replace(R.id.activityfrag, new BrowseFragment(), null);
            }

        }
        fragmentTransaction.commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}

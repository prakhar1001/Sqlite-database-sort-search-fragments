package com.example.prakhar1001.database123;

/**
 * Created by Prakhar1001 on 10/9/2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment implements View.OnClickListener {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.buttonfrag, container, false);

        //Buttons declaration
        Button add = (Button) view.findViewById(R.id.addbutton);
        Button search = (Button) view.findViewById(R.id.searchbutton);
        Button browse = (Button) view.findViewById(R.id.browsebutton);

        //Listeners
        add.setOnClickListener(this);
        search.setOnClickListener(this);
        browse.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        android.support.v4.app.FragmentManager fm = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.addbutton:
                AddFragment addFragment = new AddFragment();
                fragmentTransaction.replace(R.id.activityfrag, addFragment).addToBackStack("addfragment").commit();
                break;
            case R.id.searchbutton:
                SearchFragment searchFragment = new SearchFragment();
                fragmentTransaction.replace(R.id.activityfrag, searchFragment).addToBackStack("searchfragment").commit();
                break;
            case R.id.browsebutton:
                BrowseFragment browseFragment = new BrowseFragment();
                fragmentTransaction.replace(R.id.activityfrag, browseFragment).addToBackStack("browsefragment").commit();
                break;

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //Buttons declaration
        Button add = (Button) view.findViewById(R.id.addbutton);
        Button search = (Button) view.findViewById(R.id.searchbutton);
        Button browse = (Button) view.findViewById(R.id.browsebutton);

        //Listeners
        add.setOnClickListener(null);
        search.setOnClickListener(null);
        browse.setOnClickListener(null);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("ButtonFragment", 1);
        super.onSaveInstanceState(outState);
    }
}

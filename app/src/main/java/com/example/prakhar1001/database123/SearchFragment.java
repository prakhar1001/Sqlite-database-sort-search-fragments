package com.example.prakhar1001.database123;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Prakhar1001 on 10/6/2015.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {

    ListView lv;
    EditText searchText;
    ImageButton searchButton;
    DatabaseHandler databaseHandler;
    DatabaseAdapter dataadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchfragment, container, false);
        databaseHandler = new DatabaseHandler(getActivity());
        lv = (ListView) view.findViewById(R.id.listView);
        searchText = (EditText) view.findViewById(R.id.searchTextView);
        searchText.setMaxWidth(searchText.getWidth());


        searchButton = (ImageButton) view.findViewById(R.id.imageSearchButton);
        searchButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageSearchButton) {
            String Name = searchText.getText().toString();
            ArrayList<EmployeeInfo> arrayList = new ArrayList<EmployeeInfo>();
            arrayList = (ArrayList<EmployeeInfo>) databaseHandler.queryName(Name);
            dataadapter = new DatabaseAdapter(getActivity(), R.layout.listlayout, arrayList);
            lv.setAdapter(dataadapter);
        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        searchButton.setOnClickListener(null);

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("SearchFragment", 3);
        super.onSaveInstanceState(outState);
    }

}

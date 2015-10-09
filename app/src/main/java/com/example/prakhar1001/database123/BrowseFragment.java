package com.example.prakhar1001.database123;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

/**
 * Created by Prakhar1001 on 10/6/2015.
 */
public class BrowseFragment extends Fragment implements View.OnClickListener {

    ArrayList<EmployeeInfo> arrayList = new ArrayList<EmployeeInfo>();
    ListView lv;
    RadioButton r1, r2;
    Cursor c;
    DatabaseHandler databaseHandler;
    private DatabaseAdapter dataadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.browsefragment, container, false);
        databaseHandler = new DatabaseHandler(getActivity());
        lv = (ListView) view.findViewById(R.id.browselist);
        r1 = (RadioButton) view.findViewById(R.id.emp_code_radioButton);
        r2 = (RadioButton) view.findViewById(R.id.name_radioButton);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.name_radioButton:
                if (checked) {
                    arrayList = (ArrayList<EmployeeInfo>) databaseHandler.SortByName();
                    break;
                }
            case R.id.emp_code_radioButton:
                if (checked) {
                    arrayList = (ArrayList<EmployeeInfo>) databaseHandler.SortByEmployeeID();
                    break;
                }
        }
        dataadapter = new DatabaseAdapter(getActivity(), R.layout.listlayout, arrayList);
        lv.setAdapter(dataadapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        r1.setOnClickListener(null);
        r2.setOnClickListener(null);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("BrowseFragment", 4);
        super.onSaveInstanceState(outState);
    }

}
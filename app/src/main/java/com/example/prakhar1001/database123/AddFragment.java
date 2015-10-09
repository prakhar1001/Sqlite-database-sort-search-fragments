package com.example.prakhar1001.database123;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Prakhar1001 on 10/6/2015.
 */
public class AddFragment extends Fragment implements View.OnClickListener {

    View view;
    private DatabaseHandler databaseHandler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.addfragment, container, false);
        databaseHandler = new DatabaseHandler(getActivity());
        Button Save = (Button) view.findViewById(R.id.save_user);
        Save.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_user:
                saveuser();
                break;
        }

    }

    public void saveuser() {
        EditText empID = (EditText) view.findViewById(R.id.emp_code);
        EditText Full_Name = (EditText) view.findViewById(R.id.full_name);
        EditText Designation = (EditText) view.findViewById(R.id.designation);
        EditText tagLine = (EditText) view.findViewById(R.id.tagline);
        EditText deptt = (EditText) view.findViewById(R.id.deptt);

        String employeeID = empID.getText().toString();
        String Name = Full_Name.getText().toString();
        String designation = Designation.getText().toString();
        String TagLine = tagLine.getText().toString();
        String Department = deptt.getText().toString();

        if (((employeeID) != null) && ((Name) != null) && ((designation) != null) && ((TagLine) != null) && ((Department) != null)) {
            long id = databaseHandler.InsertData(employeeID, Name, designation, TagLine, Department);
            if (id < 0) {
                Message.message(getContext(), "Unsuccessful attempt");
            } else {
                Message.message(getContext(), "successful attempt");
            }
        } else
            Message.message(getContext(), "Null Elements are not allowed");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("AddFragment", 2);
        super.onSaveInstanceState(outState);
    }
}

package com.example.prakhar1001.database123;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Prakhar1001 on 10/9/2015.
 */
public class DatabaseAdapter extends ArrayAdapter<EmployeeInfo> {

    Context context;
    ArrayList<EmployeeInfo> data = null;
    int layoutResourceId;

    public DatabaseAdapter(Context context, int layoutResourceId, ArrayList<EmployeeInfo> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.EmployeeId = (TextView) row.findViewById(R.id._emp_code_ll);
            holder.Name = (TextView) row.findViewById(R.id.name_ll);
            holder.Designation = (TextView) row.findViewById(R.id.department_ll);
            holder.Tagline = (TextView) row.findViewById(R.id.tagline_ll);
            holder.Department = (TextView) row.findViewById(R.id.designation_ll);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        EmployeeInfo employeeInfo = data.get(position);
        holder.EmployeeId.setText(employeeInfo.getID());
        holder.Name.setText(employeeInfo.getName());
        holder.Designation.setText(employeeInfo.getDesignation());
        holder.Tagline.setText(employeeInfo.getTagline());
        holder.Designation.setText(employeeInfo.getDepartment());


        return row;
    }


    class ViewHolder {
        TextView EmployeeId;
        TextView Name;
        TextView Designation;
        TextView Tagline;
        TextView Department;
    }

}

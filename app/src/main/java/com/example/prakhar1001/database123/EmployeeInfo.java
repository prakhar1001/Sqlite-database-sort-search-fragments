package com.example.prakhar1001.database123;

/**
 * Created by Prakhar1001 on 10/6/2015.
 */
public class EmployeeInfo {


    String Name;
    String Designation;
    String _Emp_Code;
    String Tagline;
    String Department;

    // Empty constructor
    public EmployeeInfo() {

    }

    // constructor
    public EmployeeInfo(String id, String name, String Designation, String Tagline, String Department) {
        this._Emp_Code = id;
        this.Name = name;
        this.Designation = Designation;
        this.Tagline = Tagline;
        this.Department = Department;
    }

    // constructor
    public EmployeeInfo(String name, String Designation, String Tagline, String Department) {
        this.Name = name;
        this.Designation = Designation;
        this.Tagline = Tagline;
        this.Department = Department;

    }

    // setting id
    public void setID(String id) {
        this._Emp_Code = id;
    }

    // setting name
    public void setName(String name) {
        this.Name = name;
    }

    // setting Tagline
    public void setTagline(String tagline) {
        this.Tagline = tagline;
    }

    // setting Department
    public void setDepartment(String Department) {
        this.Department = Department;
    }

    // setting Designation
    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }


    // getting ID
    public String getID() {
        return this._Emp_Code;
    }

    // getting name
    public String getName() {
        return this.Name;
    }

    // getting Tagline
    public String getTagline() {
        return this.Tagline;
    }

    // getting Department
    public String getDepartment() {
        return this.Department;
    }

    // getting Designation
    public String getDesignation() {
        return this.Designation;
    }


}

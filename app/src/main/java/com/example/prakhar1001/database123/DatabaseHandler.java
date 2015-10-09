package com.example.prakhar1001.database123;

/**
 * Created by Prakhar1001 on 10/9/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DataBase_Name = "Database1.db";
    public static final String Table_Name = "Employee_Info";
    public static final String Name = "Name";
    public static final String Designation = "Designation";
    public static final String _Emp_Code = "_id";
    public static final String Tagline = "Tag_Line";
    public static final String Department = "Department";
    public static final int DataBase_Version = 17;
    private final Context context;
    SQLiteDatabase database_ob;
    String[] cols = {_Emp_Code, Name, Designation, Tagline, Department};
    List<EmployeeInfo> arraylist = new ArrayList<EmployeeInfo>();

    DatabaseHandler(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table Employee_Info " +
                "(_id text primary key, Name text,Designation text,Tag_Line text, Department text)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS Employee_Info");
        // Create tables again
        onCreate(db);
    }


    public void Close() {
        database_ob.close();
    }

    public long InsertData(String employeeID, String Name1, String designation, String TagLine, String Department1) {

        database_ob = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(_Emp_Code, employeeID);
        contentValues.put(Name, Name1);
        contentValues.put(Designation, designation);
        contentValues.put(Tagline, TagLine);
        contentValues.put(Department, Department1);

        long id = database_ob.insert(Table_Name, null, contentValues);
        Close();
        return id;
    }


    public List<EmployeeInfo> queryName(String inputText) throws SQLException {

        database_ob = this.getWritableDatabase();
        Cursor mCursor = null;
        if (inputText == null || inputText.length() == 0) {
            mCursor = null;
        } else {
            mCursor = database_ob.query(Table_Name, cols, Name
                            + " like '%" + inputText + "%'", null, null,
                    null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
            arraylist = populateArrayList(mCursor);
        } else if (mCursor == null)
            Message.message(context, "No Elements are found related to typed query");

        Close();
        return arraylist;
    }


    public List<EmployeeInfo> SortByName() throws SQLException {
        database_ob = this.getReadableDatabase();
        Cursor mCursor = null;

        mCursor = database_ob.query(Table_Name, cols,
                null, null, null, null, Name + " ASC");

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        arraylist = populateArrayList(mCursor);

        Close();
        return arraylist;
    }


    public List<EmployeeInfo> SortByEmployeeID() throws SQLException {
        database_ob = this.getReadableDatabase();

        Cursor mCursor = null;

        mCursor = database_ob.query(Table_Name, cols,
                null, null, null, null, _Emp_Code + " ASC");

        if (mCursor != null) {
            mCursor.moveToFirst();
        }

        arraylist = populateArrayList(mCursor);

        Close();
        return arraylist;
    }

    private List<EmployeeInfo> populateArrayList(Cursor mCursor) {
        if (mCursor.moveToFirst()) {
            do {
                EmployeeInfo employeeInfo = new EmployeeInfo();
                employeeInfo.setID(mCursor.getString(0));
                employeeInfo.setName(mCursor.getString(1));
                employeeInfo.setDesignation(mCursor.getString(2));
                employeeInfo.setTagline(mCursor.getString(3));
                employeeInfo.setDepartment(mCursor.getString(4));

                // Adding contact to list
                arraylist.add(employeeInfo);
            } while (mCursor.moveToNext());
        }
        return arraylist;
    }


}









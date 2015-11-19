package com.example.pascal.salaryapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pascal on 19.11.2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    private static final String DATABASE_NAME= "salary";
    private static final int DATABASE_VERSION = 1;
    private static SQLiteHelper instance;

    private SQLiteHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    public static SQLiteHelper getInstance(Context context){
        if(instance==null)
            instance = new SQLiteHelper (context.getApplicationContext());
        return instance;
    }

    public void onCreate (SQLiteDatabase db){
        db.execSQL (SalaryContract.PersonalData.CREATE_TABLE_PERSONALDATA);
        db.execSQL (SalaryContract.ProfessionnalData.CREATE_TABLE_PROFESSIONNAL_DATA);
        db.execSQL (SalaryContract.SalaryData.CREATE_TABLE_SALARY_DATA);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL ("DROP TABLE IF EXISTS " + SalaryContract.PersonalData.TABLE_PERSONALDATA);
        db.execSQL ("DROP TABLE IF EXISTS " + SalaryContract.ProfessionnalData.TABLE_PROFESSIONNALDATA);
        db.execSQL ("DROP TABLE IF EXISTS " + SalaryContract.SalaryData.TABLE_SalaryDATA);

        onCreate(db);
    }
}

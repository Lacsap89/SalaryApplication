package com.example.pascal.salaryapplication.db.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pascal.salaryapplication.db.SQLiteHelper;
import com.example.pascal.salaryapplication.db.SalaryContract;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;

/**
 * Created by Pascal on 28.11.2015.
 */
public class ProfessionalDataSource {

    private SQLiteDatabase db;
    private Context context;

    public ProfessionalDataSource (Context context){
        SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context=context;
    }

    /**
     *Insert new ProfessionalData
     */

    public long createProfessionalData(ProfessionalData professionalData){
        long id;

        ContentValues values = new ContentValues();
        values.put(SalaryContract.ProfessionnalData.KEY_POST, professionalData.getPost());
        values.put(SalaryContract.ProfessionnalData.KEY_SALARY_CLASS, professionalData.getSalaryClass());
        values.put(SalaryContract.ProfessionnalData.KEY_BOSS, professionalData.getBoss());
        values.put(SalaryContract.ProfessionnalData.KEY_SALARYID, professionalData.getSalaryId());

        id = this.db.insert(SalaryContract.ProfessionnalData.TABLE_PROFESSIONNALDATA, null, values);

        return id;
    }

    /**
     *Find professionalData by Id
     */

    public ProfessionalData getProfessionalDataById(long id){
        String sql = "SELECT * FROM " + SalaryContract.ProfessionnalData.TABLE_PROFESSIONNALDATA +
                " WHERE " + SalaryContract.ProfessionnalData.KEY_POSTID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        ProfessionalData professionalData = new ProfessionalData();
        professionalData.setId(cursor.getInt(cursor.getColumnIndex(SalaryContract.ProfessionnalData.KEY_POSTID)));
        professionalData.setPost(cursor.getString(cursor.getColumnIndex(SalaryContract.ProfessionnalData.KEY_POST)));
        professionalData.setSalaryClass(cursor.getInt(cursor.getColumnIndex(SalaryContract.ProfessionnalData.KEY_SALARY_CLASS)));
        professionalData.setBoss(cursor.getString(cursor.getColumnIndex(SalaryContract.ProfessionnalData.KEY_BOSS)));
        professionalData.setSalaryId(cursor.getInt(cursor.getColumnIndex(SalaryContract.ProfessionnalData.KEY_SALARYID)));

        return professionalData;
    }


    /**
     * Update professionalData
     */

    public int updateProfessionalData (ProfessionalData professionalData){
        ContentValues values = new ContentValues();
        values.put(SalaryContract.ProfessionnalData.KEY_POST, professionalData.getPost());
        values.put(SalaryContract.ProfessionnalData.KEY_SALARY_CLASS, professionalData.getSalaryClass());
        values.put(SalaryContract.ProfessionnalData.KEY_BOSS, professionalData.getBoss());
        values.put(SalaryContract.ProfessionnalData.KEY_SALARYID, professionalData.getSalaryId());

    return this.db.update(SalaryContract.ProfessionnalData.TABLE_PROFESSIONNALDATA, values, SalaryContract.ProfessionnalData.KEY_POSTID + " = ?",
            new String[] {String.valueOf(professionalData.getId())});
    }

    /**
     * Delete a professionalData
     */

    public void deleteProfessionalData(long id){
        this.db.delete(SalaryContract.ProfessionnalData.TABLE_PROFESSIONNALDATA, SalaryContract.ProfessionnalData.KEY_POSTID + " = ?",
                new String[] {String.valueOf(id)});
    }
}

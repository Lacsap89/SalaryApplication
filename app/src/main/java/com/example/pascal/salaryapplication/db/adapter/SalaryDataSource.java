package com.example.pascal.salaryapplication.db.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pascal.salaryapplication.db.SQLiteHelper;
import com.example.pascal.salaryapplication.db.SalaryContract;
import com.example.pascal.salaryapplication.db.object.SalaryData;

/**
 * Created by Pascal on 28.11.2015.
 */
public class SalaryDataSource {

    private SQLiteDatabase db;
    private Context context;

    public SalaryDataSource(Context context){
        SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;
    }

    /**
     * Insert new SalaryData
     */

    public long createSalaryData(SalaryData salaryData){
        long id;
        ContentValues values = new ContentValues();
        values.put(SalaryContract.SalaryData.KEY_BRUTSALARY, salaryData.getBrutSalary());
        values.put(SalaryContract.SalaryData.KEY_AVSAIAPGAC, salaryData.getAvsaiapgac());
        values.put(SalaryContract.SalaryData.KEY_LPP, salaryData.getLpp());
        values.put(SalaryContract.SalaryData.KEY_LAA, salaryData.getLaa());
        values.put(SalaryContract.SalaryData.KEY_ALFA, salaryData.getFamilyTaxes());
        values.put(SalaryContract.SalaryData.KEY_NETSALARY, salaryData.getNetSalary());
        values.put(SalaryContract.SalaryData.KEY_ADVANCE, salaryData.getAdvance());
        values.put(SalaryContract.SalaryData.KEY_EXTERNALTAXES, salaryData.getWithholdingTaxes());
        values.put(SalaryContract.SalaryData.KEY_OTHER, salaryData.getOther());
        values.put(SalaryContract.SalaryData.KEY_FINALSALARY, salaryData.getFinalSalary());

        id = this.db.insert(SalaryContract.SalaryData.TABLE_SalaryDATA, null, values);

        return id;
    }

    /**
     * Find salaryData by Id
      */
    public SalaryData getSalaryDataById(long id){
        String sql = "SELECT * FROM " + SalaryContract.SalaryData.TABLE_SalaryDATA +
                " WHERE " + SalaryContract.SalaryData.KEY_SALARYID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        SalaryData salaryData = new SalaryData();
        salaryData.setId(cursor.getInt(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_SALARYID)));
        salaryData.setBrutSalary(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_BRUTSALARY)));
        salaryData.setAvsaiapgac(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_AVSAIAPGAC)));
        salaryData.setLpp(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_LPP)));
        salaryData.setLaa(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_LAA)));
        salaryData.setFamilyTaxes(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_ALFA)));
        salaryData.setNetSalary(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_NETSALARY)));
        salaryData.setAdvance(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_ADVANCE)));
        salaryData.setWithholdingTaxes(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_EXTERNALTAXES)));
        salaryData.setOther(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_OTHER)));
        salaryData.setFinalSalary(cursor.getDouble(cursor.getColumnIndex(SalaryContract.SalaryData.KEY_FINALSALARY)));

        return salaryData;
    }

    /**
     * Update salaryData
     */

    public int updateSalaryData(SalaryData salaryData){
        ContentValues values = new ContentValues();
        values.put(SalaryContract.SalaryData.KEY_BRUTSALARY, salaryData.getBrutSalary());
        values.put(SalaryContract.SalaryData.KEY_AVSAIAPGAC, salaryData.getAvsaiapgac());
        values.put(SalaryContract.SalaryData.KEY_LPP, salaryData.getLpp());
        values.put(SalaryContract.SalaryData.KEY_LAA, salaryData.getLaa());
        values.put(SalaryContract.SalaryData.KEY_ALFA, salaryData.getFamilyTaxes());
        values.put(SalaryContract.SalaryData.KEY_NETSALARY, salaryData.getNetSalary());
        values.put(SalaryContract.SalaryData.KEY_ADVANCE, salaryData.getAdvance());
        values.put(SalaryContract.SalaryData.KEY_EXTERNALTAXES, salaryData.getWithholdingTaxes());
        values.put(SalaryContract.SalaryData.KEY_OTHER, salaryData.getOther());
        values.put(SalaryContract.SalaryData.KEY_FINALSALARY, salaryData.getFinalSalary());

        return this.db.update(SalaryContract.SalaryData.TABLE_SalaryDATA, values, SalaryContract.SalaryData.KEY_SALARYID + " = ?",
                new String[] {String.valueOf(salaryData.getId())});
    }

    /**
     *Delete a salaryData
     */

    public void deleteSalaryData(long id){
        this.db.delete(SalaryContract.SalaryData.TABLE_SalaryDATA, SalaryContract.SalaryData.KEY_SALARYID + " =?",
                new String[] {String.valueOf(id)});
    }

}

package com.example.pascal.salaryapplication.db.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pascal.salaryapplication.App.Salary;
import com.example.pascal.salaryapplication.db.SQLiteHelper;
import com.example.pascal.salaryapplication.db.SalaryContract;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.google.android.gms.plus.model.people.Person;

/**
 * Created by Pascal on 26.11.2015.
 */
public class PersonalDataSource {

    private SQLiteDatabase db;
    private Context context;

    public PersonalDataSource (Context context){
        SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context=context;
    }

    /**
     * insert new personal data
     */

    public long createPersonalData (com.example.pascal.salaryapplication.db.object.PersonalData personalData){
        long id;
        ContentValues values = new ContentValues();
        values.put(SalaryContract.PersonalData.KEY_NAME, personalData.getName());
        values.put(SalaryContract.PersonalData.KEY_LASTNAME, personalData.getLastname());
        values.put(SalaryContract.PersonalData.KEY_ADDRESS, personalData.getAddress());
        values.put(SalaryContract.PersonalData.KEY_BIRTHDATE, personalData.getBirthdate());
        values.put(SalaryContract.PersonalData.KEY_CIVILSTATUS, personalData.getCivilStatus());
        values.put(SalaryContract.PersonalData.KEY_NBCHILDREN, personalData.getNbChildren());
        values.put(SalaryContract.PersonalData.KEY_NATIONALITY, personalData.getNationality());
        values.put(SalaryContract.PersonalData.KEY_PERMIT, personalData.getPermit());
        values.put(SalaryContract.PersonalData.KEY_BANK, personalData.getBank());
        values.put(SalaryContract.PersonalData.KEY_LOGIN, personalData.getLogin());
        values.put(SalaryContract.PersonalData.KEY_CONTRACT_BEGIN, personalData.getContractBegin());
        values.put(SalaryContract.PersonalData.KEY_PERCENTAGE, personalData.getPercentage());
        values.put(SalaryContract.PersonalData.KEY_HOLLIDAY_LEFT, personalData.getHollidayLeft());
        values.put(SalaryContract.PersonalData.KEY_PASSWORD, personalData.getPassword());
        values.put(SalaryContract.PersonalData.KEY_POSTID, personalData.getPostId());

        id = this.db.insert(SalaryContract.PersonalData.TABLE_PERSONALDATA, null, values);

        return id;
    }

    /**
     * Find one Person by Id
     */
    public PersonalData getPersonById(long id){
        String sql = "SELECT * FROM " + SalaryContract.PersonalData.TABLE_PERSONALDATA +
                " WHERE " + SalaryContract.PersonalData.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null)
            cursor.moveToFirst();

        PersonalData personalData = new PersonalData();
        personalData.setName(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_NAME)));
        personalData.setLastname(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_LASTNAME)));
        personalData.setAddress(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_ADDRESS)));
        personalData.setBirthdate(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_BIRTHDATE)));
        personalData.setCivilStatus(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_CIVILSTATUS)));
        personalData.setNbChildren(cursor.getInt(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_NBCHILDREN)));
        personalData.setNationality(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_NATIONALITY)));
        personalData.setPermit(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_PERMIT)));
        personalData.setBank(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_BANK)));
        personalData.setLogin(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_LOGIN)));
        personalData.setContractBegin(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_CONTRACT_BEGIN)));
        personalData.setPercentage(cursor.getInt(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_PERCENTAGE)));
        personalData.setHollidayLeft(cursor.getInt(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_HOLLIDAY_LEFT)));
        personalData.setPassword(cursor.getString(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_PASSWORD)));
        personalData.setPostId(cursor.getInt(cursor.getColumnIndex(SalaryContract.PersonalData.KEY_POSTID)));

        return personalData;
    }

    /**
     *update personal data
     */

    public int updatePersonalData(PersonalData personalData){
        ContentValues values = new ContentValues();
        values.put(SalaryContract.PersonalData.KEY_NAME, personalData.getName());
        values.put(SalaryContract.PersonalData.KEY_LASTNAME, personalData.getLastname());
        values.put(SalaryContract.PersonalData.KEY_ADDRESS, personalData.getAddress());
        values.put(SalaryContract.PersonalData.KEY_BIRTHDATE, personalData.getBirthdate());
        values.put(SalaryContract.PersonalData.KEY_CIVILSTATUS, personalData.getCivilStatus());
        values.put(SalaryContract.PersonalData.KEY_NBCHILDREN, personalData.getNbChildren());
        values.put(SalaryContract.PersonalData.KEY_NATIONALITY, personalData.getNationality());
        values.put(SalaryContract.PersonalData.KEY_PERMIT, personalData.getPermit());
        values.put(SalaryContract.PersonalData.KEY_BANK, personalData.getBank());
        values.put(SalaryContract.PersonalData.KEY_LOGIN, personalData.getLogin());
        values.put(SalaryContract.PersonalData.KEY_CONTRACT_BEGIN, personalData.getContractBegin());
        values.put(SalaryContract.PersonalData.KEY_PERCENTAGE, personalData.getPercentage());
        values.put(SalaryContract.PersonalData.KEY_HOLLIDAY_LEFT, personalData.getHollidayLeft());
        values.put(SalaryContract.PersonalData.KEY_PASSWORD, personalData.getPassword());
        values.put(SalaryContract.PersonalData.KEY_POSTID, personalData.getPostId());

        return this.db.update(SalaryContract.PersonalData.TABLE_PERSONALDATA, values, SalaryContract.PersonalData.KEY_ID + " = ?",
                new String[] {String.valueOf(personalData.getId())});
    }




}

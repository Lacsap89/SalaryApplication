package com.example.pascal.salaryapplication.db;

import android.provider.BaseColumns;

/**
 * Created by Pascal on 07.11.2015.
 */
public final class SalaryContract {


    private SalaryContract(){
        //empty constructor
    }

    public static abstract class PersonalData implements BaseColumns {
        //Table name
        public static final String TABLE_PERSONALDATA ="Personal data";

        //Column names
        public static final String KEY_ID = "Id";
        public static final String KEY_NAME = "Name";
        public static final String KEY_LASTNAME = "Lastname";
        public static final String KEY_ADDRESS = "Address";
        public static final String KEY_BIRTHDATE = "Birthdate";
        public static final String KEY_CIVILSTATUS = "Civil status";
        public static final String KEY_NBCHILDREN = "Number of children";
        public static final String KEY_NATIONALITY = "Nationality";
        public static final String KEY_PERMIT = "Permit";
        public static final String KEY_BANK = " Bank";
        public static final String KEY_LOGIN = "Login";
        public static final String KEY_CONTRACT_BEGIN = "Contract begin";
        public static final String KEY_PERCENTAGE = "Percentage";
        public static final String KEY_HOLLIDAY_LEFT = "Hollidays left";
        public static final String KEY_PASSWORD = "Password";
        public static final String KEY_POSTID = "Post Id";

        //Table create statement
        public static final String CREATE_TABLE_PERSONALDATA = "CREATE TABLE"
                + TABLE_PERSONALDATA + " ("
                + PersonalData.KEY_ID + "INTEGER PRIMARY KEY, "
                + PersonalData.KEY_NAME + " TEXT, "
                + PersonalData.KEY_LASTNAME + " TEXT, "
                + PersonalData.KEY_ADDRESS + " TEXT, "
                + PersonalData.KEY_BIRTHDATE + " TEXT, "
                + PersonalData.KEY_CIVILSTATUS + " TEXT, "
                + PersonalData.KEY_NBCHILDREN + " TEXT, "
                + PersonalData.KEY_NATIONALITY + " TEXT, "
                + PersonalData.KEY_PERMIT + " TEXT, "
                + PersonalData.KEY_BANK + " TEXT, "
                + PersonalData.KEY_CONTRACT_BEGIN + " DATETIME, "
                + PersonalData.KEY_PERCENTAGE + " INTEGER, "
                + PersonalData.KEY_HOLLIDAY_LEFT + " INTEGER, "
                + PersonalData.KEY_LOGIN + " TEXT, "
                + PersonalData.KEY_PASSWORD + " TEXT, "
                + PersonalData.KEY_POSTID + " INTEGER"
                + ");";
    }


    public abstract class ProfessionnalData implements BaseColumns{

        //Table name
        public static final String TABLE_PROFESSIONNALDATA = "Professionnal data";

        //Column names
        public static final String KEY_POSTID = "Id";
        public static final String KEY_POST = "Post";
        public static final String KEY_SALARY_CLASS = "Salary class";
        public static final String KEY_BOSS = "Boss";
        public static final String KEY_SALARYID = "Salary Id";


        //Table create statement
        public static final String CREATE_TABLE_PROFESSIONNAL_DATA = "CREATE TABLE "
                + TABLE_PROFESSIONNALDATA + "("
                + ProfessionnalData.KEY_POSTID + " INTEGER PRIMARY KEY, "
                + ProfessionnalData.KEY_POST + " TEXT, "
                + ProfessionnalData.KEY_SALARY_CLASS + " INTEGER, "
                + ProfessionnalData.KEY_BOSS + " TEXT, "
                + ProfessionnalData.KEY_SALARYID + " INTEGER, "
                + "FOREIGN KEY (" + KEY_POSTID + ") REFERENCES " + PersonalData.TABLE_PERSONALDATA + " (" +KEY_POSTID + "), "
                + ");";
    }

    public abstract class SalaryData implements BaseColumns{

        //Table name
        public static final String TABLE_SalaryDATA = "Professionnal data";

        //Column names

        public static final String KEY_SALARYID = "Id";
        public static final String KEY_AVSAIAPGAC = "AVS/AI/APG/AC";
        public static final String KEY_LPP = "LPP";
        public static final String KEY_LAA = "LAA";
        public static final String KEY_ALFA = "Family Taxes";
        public static final String KEY_NETSALARY = "Net salary";
        public static final String KEY_ADVANCE = "Advance";
        public static final String KEY_EXTERNALTAXES = "Withholding taxes";
        public static final String KEY_OTHER = "Other";
        public static final String KEY_FINALSALARY = "Final salary";

        //Table create statement
        public static final String CREATE_TABLE_SALARY_DATA = "CREATE TABLE"
                + TABLE_SalaryDATA + "("
                + SalaryData.KEY_SALARYID + "INTEGER PRIMARY KEY, "
                + SalaryData.KEY_AVSAIAPGAC + "DOUBLE, "
                + SalaryData.KEY_LPP + "DOUBLE, "
                + SalaryData.KEY_LAA + "DOUBLE, "
                + SalaryData.KEY_ALFA + "DOUBLE, "
                + SalaryData.KEY_NETSALARY + "DOUBLE, "
                + SalaryData.KEY_ADVANCE + "DOUBLE, "
                + SalaryData.KEY_EXTERNALTAXES + "DOUBLE, "
                + SalaryData.KEY_OTHER + "DOUBLE, "
                + SalaryData.KEY_FINALSALARY + "DOUBLE, ";

    }
}

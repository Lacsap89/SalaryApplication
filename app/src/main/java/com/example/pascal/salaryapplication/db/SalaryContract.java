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
        public static final String TABLE_PERSONALDATA ="Personal_data";

        //Column names
        public static final String KEY_ID = "Id";
        public static final String KEY_NAME = "Name";
        public static final String KEY_LASTNAME = "Lastname";
        public static final String KEY_ADDRESS = "Address";
        public static final String KEY_CITY = "City";
        public static final String KEY_BIRTHDATE = "Birthdate";
        public static final String KEY_CIVILSTATUS = "Civil_status";
        public static final String KEY_NBCHILDREN = "Number_of_children";
        public static final String KEY_NATIONALITY = "Nationality";
        public static final String KEY_PERMIT = "Permit";
        public static final String KEY_BANK = "Bank";
        public static final String KEY_CONTRACT_BEGIN = "Contract_begin";
        public static final String KEY_PERCENTAGE = "Percentage";
        public static final String KEY_HOLLIDAY_LEFT = "Hollidays_left";
        public static final String KEY_PASSWORD = "Password";
        public static final String KEY_POSTID = "Post_Id";

        //Table create statement
        public static final String CREATE_TABLE_PERSONALDATA = "CREATE TABLE "
                + TABLE_PERSONALDATA + " ("
                + PersonalData.KEY_ID + " INTEGER PRIMARY KEY, "
                + PersonalData.KEY_NAME + " TEXT, "
                + PersonalData.KEY_LASTNAME + " TEXT, "
                + PersonalData.KEY_ADDRESS + " TEXT, "
                + PersonalData.KEY_CITY + " TEXT, "
                + PersonalData.KEY_BIRTHDATE + " TEXT, "
                + PersonalData.KEY_CIVILSTATUS + " TEXT, "
                + PersonalData.KEY_NBCHILDREN + " TEXT, "
                + PersonalData.KEY_NATIONALITY + " TEXT, "
                + PersonalData.KEY_PERMIT + " TEXT, "
                + PersonalData.KEY_BANK + " TEXT, "
                + PersonalData.KEY_CONTRACT_BEGIN + " DATETIME, "
                + PersonalData.KEY_PERCENTAGE + " INTEGER, "
                + PersonalData.KEY_HOLLIDAY_LEFT + " INTEGER, "
                + PersonalData.KEY_PASSWORD + " TEXT, "
                + PersonalData.KEY_POSTID + " INTEGER"
                + ");";
    }


    public abstract class ProfessionnalData implements BaseColumns{

        //Table name
        public static final String TABLE_PROFESSIONNALDATA = "Professionnal_data";

        //Column names
        public static final String KEY_POSTID = "Id";
        public static final String KEY_POST = "Post";
        public static final String KEY_SALARY_CLASS = "Salary_class";
        public static final String KEY_BOSS = "Boss";
        public static final String KEY_SALARYID = "Salary_Id";


        //Table create statement
        public static final String CREATE_TABLE_PROFESSIONNAL_DATA = "CREATE TABLE "
                + TABLE_PROFESSIONNALDATA + "("
                + ProfessionnalData.KEY_POSTID + " INTEGER PRIMARY KEY, "
                + ProfessionnalData.KEY_POST + " TEXT, "
                + ProfessionnalData.KEY_SALARY_CLASS + " INTEGER, "
                + ProfessionnalData.KEY_BOSS + " TEXT, "
                + ProfessionnalData.KEY_SALARYID + " INTEGER, "
                + ");";
    }

    public abstract class SalaryData implements BaseColumns{

        //Table name
        public static final String TABLE_SalaryDATA = "Salary_data";

        //Column names

        public static final String KEY_SALARYID = "Id";
        public static final String KEY_BRUTSALARY = "Brut_salary";
        public static final String KEY_AVSAIAPGAC = "AVS_AI_APG_AC";
        public static final String KEY_LPP = "LPP";
        public static final String KEY_LAA = "LAA";
        public static final String KEY_ALFA = "Family_Taxes";
        public static final String KEY_NETSALARY = "Net_salary";
        public static final String KEY_ADVANCE = "Advance";
        public static final String KEY_EXTERNALTAXES = "Withholding_taxes";
        public static final String KEY_OTHER = "Other";
        public static final String KEY_FINALSALARY = "Final_salary";

        //Table create statement
        public static final String CREATE_TABLE_SALARY_DATA = "CREATE TABLE "
                + TABLE_SalaryDATA + "("
                + SalaryData.KEY_SALARYID + " INTEGER PRIMARY KEY, "
                + SalaryData.KEY_BRUTSALARY + " DOUBLE, "
                + SalaryData.KEY_AVSAIAPGAC + " DOUBLE, "
                + SalaryData.KEY_LPP + " DOUBLE, "
                + SalaryData.KEY_LAA + " DOUBLE, "
                + SalaryData.KEY_ALFA + " DOUBLE, "
                + SalaryData.KEY_NETSALARY + " DOUBLE, "
                + SalaryData.KEY_ADVANCE + " DOUBLE, "
                + SalaryData.KEY_EXTERNALTAXES + " DOUBLE, "
                + SalaryData.KEY_OTHER + " DOUBLE, "
                + SalaryData.KEY_FINALSALARY + " DOUBLE"
                + ");";

    }
}

package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pascal.salaryapplication.App.PersonnalDataActivity;
import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SQLiteHelper;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.ProfessionalDataSource;
import com.example.pascal.salaryapplication.db.adapter.SalaryDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;
import com.example.pascal.salaryapplication.db.object.SalaryData;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PersonalData personalData = new PersonalData();
        ProfessionalData professionalData = new ProfessionalData();
        SalaryData salaryData = new SalaryData();

        PersonalDataSource pds = new PersonalDataSource(this);
        ProfessionalDataSource prds = new ProfessionalDataSource(this);
        SalaryDataSource sds = new SalaryDataSource(this);

        personalData.setName("Yannick");
        personalData.setLastname("Da Silva");
        personalData.setAddress("Rue du test 42");
        personalData.setBirthdate("09.08.1988");
        personalData.setCivilStatus("Single");
        personalData.setNbChildren(0);
        personalData.setNationality("CH");
        personalData.setPermit("-");
        personalData.setBank("CH000000000000000");
        personalData.setContractBegin("01.01.2014");
        personalData.setPercentage(60);
        personalData.setHollidayLeft(0);
        personalData.setPassword("Test");
        personalData.setPostId(1);

        personalData.setId((int) pds.createPersonalData(personalData));

        SQLiteHelper sqlHelper = SQLiteHelper.getInstance(this);
        sqlHelper.getWritableDatabase().close();


    }

    public void gotoHome(View view) {
        Intent intent = new Intent(this,PersonnalDataActivity.class);
        startActivity(intent);
    }
}

package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.pascal.salaryapplication.App.PersonnalDataActivity;
import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SQLiteHelper;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.ProfessionalDataSource;
import com.example.pascal.salaryapplication.db.adapter.SalaryDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;
import com.example.pascal.salaryapplication.db.object.SalaryData;

import java.util.Locale;

import static com.example.pascal.salaryapplication.R.id.switch1;

public class Login extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText id;
    EditText password;
    PersonalData personalData = new PersonalData();
    ProfessionalData professionalData = new ProfessionalData();
    SalaryData salaryData = new SalaryData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Switch t = (Switch) findViewById(R.id.switch1);
        t.setOnCheckedChangeListener(this);
        setSupportActionBar(toolbar);




        /*personalData.setName("Pascal");
        personalData.setLastname("Délèze");
        personalData.setAddress("Chemin du Catogne 13");
        personalData.setBirthdate("10.05.1989");
        personalData.setCivilStatus("Married");
        personalData.setNbChildren(0);
        personalData.setNationality("CH");
        personalData.setPermit("-");
        personalData.setBank("CH0000000000011100");
        personalData.setContractBegin("01.10.2014");
        personalData.setPercentage(60);
        personalData.setHollidayLeft(3);
        personalData.setPassword("Test1");
        personalData.setPostId(2);

        personalData.setId(( pds.updatePersonalData(personalData)));
        */
        SQLiteHelper sqlHelper = SQLiteHelper.getInstance(this);
        sqlHelper.getWritableDatabase().close();
        id = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);


    }

// Change of activity

    public void gotoHome(View view) {


        Intent intent = new Intent(this,MainActivity.class);
        Intent intent2 = new Intent(this,Login.class);
        PersonalDataSource pds = new PersonalDataSource(this);
        ProfessionalDataSource prds = new ProfessionalDataSource(this);
        SalaryDataSource sds = new SalaryDataSource(this);
        personalData.setId(Integer.parseInt(id.getText().toString()));
        personalData = pds.getPersonById(personalData.getId());
        if(personalData.getPassword().equals(password.getText().toString()))
            startActivity(intent);
        else {
            startActivity(intent2);
        }
    }
// Language Switch
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if (isChecked) {
            // The toggle is enabled
            Toast.makeText(Login.this.getApplicationContext(),"Checked",Toast.LENGTH_LONG)
                    .show();
            Locale myLocale = new Locale("fr");
            Locale.setDefault(myLocale);
            android.content.res.Configuration config = new android.content.res.Configuration();
            config.locale = myLocale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

            TextView eid = (TextView) findViewById(R.id.EmplidTview);
            eid.setText(R.string.emplidTview);
            TextView pwd = (TextView) findViewById(R.id.passwordTView);
            pwd.setText(R.string.lginPasswrdTview);
            Button btn = (Button) findViewById(R.id.button);
            btn.setText(R.string.lginBttnEnter);

        } else {
            // The toggle is disabled
            Toast.makeText(Login.this.getApplicationContext(),"Not Checked",Toast.LENGTH_LONG)
                    .show();

            Locale myLocale = new Locale("en_US");
            Locale.setDefault(myLocale);
            android.content.res.Configuration config = new android.content.res.Configuration();
            config.locale = myLocale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

            TextView eid = (TextView) findViewById(R.id.EmplidTview);
            eid.setText(R.string.emplidTview);
            TextView pwd = (TextView) findViewById(R.id.passwordTView);
            pwd.setText(R.string.lginPasswrdTview);
            Button btn = (Button) findViewById(R.id.button);
            btn.setText(R.string.lginBttnEnter);
        }
    }
}

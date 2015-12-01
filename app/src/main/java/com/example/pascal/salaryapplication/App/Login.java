package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SQLiteHelper;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.ProfessionalDataSource;
import com.example.pascal.salaryapplication.db.adapter.SalaryDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;
import com.example.pascal.salaryapplication.db.object.SalaryData;
import java.util.Locale;



public class Login extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText id;
    EditText password;

    PersonalData personalData = new PersonalData();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Switch t = (Switch) findViewById(R.id.switch1);
        t.setOnCheckedChangeListener(this);









        id = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);



    }

// Change of activity

    public void gotoHome(View view) {


        Intent intent = new Intent(this,MainActivity.class);
        Intent intent2 = new Intent(this,Login.class);
        PersonalDataSource pds = new PersonalDataSource(this);
        ProfessionalDataSource prds = new ProfessionalDataSource(this);
        personalData.setId(Integer.parseInt(id.getText().toString()));
        personalData = pds.getPersonById(personalData.getId());
        if(personalData.getPassword().equals(password.getText().toString())) {

            intent.putExtra("id", id.getText().toString());
            startActivity(intent);
        }
        else {
//
            startActivity(intent2);
        }
    }
// Language Switch
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if (isChecked) {
            // The toggle is enabled

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


            Locale myLocale = new Locale("en");
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

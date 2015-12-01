package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SQLiteHelper;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.ProfessionalDataSource;
import com.example.pascal.salaryapplication.db.adapter.SalaryDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;
import com.example.pascal.salaryapplication.db.object.SalaryData;

public class Salary extends AppCompatActivity {

    TextView showBrut;
    TextView showAVS;
    TextView showLPP;
    TextView showLAA;
    TextView showALFA;
    TextView showNetSalary;
    TextView showAdvance;
    TextView showTaxes;
    TextView showOther;
    TextView showFinalSalary;
    int id;
    PersonalData personalData;
    ProfessionalData professionalData;
    SalaryData salaryData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);
        SQLiteHelper sqlHelper = SQLiteHelper.getInstance(this);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        Intent intent = getIntent();

        id= Integer.parseInt(getIntent().getStringExtra("id"));
        personalData= new PersonalData();
        PersonalDataSource pds = new PersonalDataSource(this);

        personalData = pds.getPersonById(id);

       professionalData = new ProfessionalData();
        ProfessionalDataSource prds = new ProfessionalDataSource(this);

        professionalData = prds.getProfessionalDataById(personalData.getPostId());

       salaryData = new SalaryData();
        SalaryDataSource sds = new SalaryDataSource(this);

        salaryData = sds.getSalaryDataById(professionalData.getSalaryId());

        showBrut = (TextView) findViewById(R.id.showbrut);
        showAVS = (TextView) findViewById(R.id.showAVS);
        showLPP = (TextView) findViewById(R.id.showLPP);
        showALFA = (TextView) findViewById(R.id.showAlfa);
        showLAA = (TextView) findViewById(R.id.showLAA);
        showNetSalary = (TextView) findViewById(R.id.showNetSalary);
        showAdvance = (TextView) findViewById(R.id.showAdvance);
        showTaxes = (TextView) findViewById(R.id.showTaxes);
        showOther = (TextView) findViewById(R.id.showOther);
        showFinalSalary = (TextView) findViewById(R.id.showFinalSalary);




        showBrut.setText(String.valueOf(salaryData.getBrutSalary()));
        showAVS.setText(String.valueOf(salaryData.getAvsaiapgac()));
        showLPP.setText(String.valueOf(salaryData.getLpp()));
        showALFA.setText(String.valueOf(salaryData.getFamilyTaxes()));
        showLAA.setText(String.valueOf(salaryData.getLaa()));
        showNetSalary.setText(String.valueOf(salaryData.getNetSalary()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_salary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

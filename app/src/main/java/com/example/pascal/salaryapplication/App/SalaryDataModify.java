package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.ProfessionalDataSource;
import com.example.pascal.salaryapplication.db.adapter.SalaryDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;
import com.example.pascal.salaryapplication.db.object.SalaryData;

public class SalaryDataModify extends AppCompatActivity {

    private EditText brutSalary;
    private EditText advance;
    private EditText withholdingTaxes;
    private EditText other;
    private PersonalData personalData = new PersonalData();
    private ProfessionalData professionalData = new ProfessionalData();
    private SalaryDataSource sds = new SalaryDataSource(this);

    private Button save;

    String id;
    SalaryData salaryData = new SalaryData();

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_modify);


        Intent intent = getIntent();


        id = getIntent().getStringExtra("id");

        personalData= new PersonalData();
        PersonalDataSource pds = new PersonalDataSource(this);

        personalData = pds.getPersonById(Integer.parseInt(id));

        professionalData = new ProfessionalData();
        ProfessionalDataSource prds = new ProfessionalDataSource(this);

        professionalData = prds.getProfessionalDataById(personalData.getPostId());

        salaryData = new SalaryData();


        salaryData = sds.getSalaryDataById(professionalData.getSalaryId());


        save = (Button) findViewById(R.id.save);
        brutSalary = (EditText) findViewById(R.id.editBrutSalary);
        advance = (EditText) findViewById(R.id.editAdvance);
        withholdingTaxes = (EditText) findViewById(R.id.editTaxes);
        other = (EditText) findViewById(R.id.editOther);



        brutSalary.setText(String.valueOf(salaryData.getBrutSalary()));
        advance.setText(String.valueOf(salaryData.getAdvance()));
        withholdingTaxes.setText(String.valueOf(salaryData.getWithholdingTaxes()));
        other.setText(String.valueOf(salaryData.getOther()));


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SalaryDataModify.this, Salary.class);
                salaryData = new SalaryData(Double.parseDouble(brutSalary.getText().toString()));
                salaryData.setId(professionalData.getSalaryId());
                salaryData.setAdvance(Double.parseDouble(advance.getText().toString()));
                salaryData.setWithholdingTaxes(Double.parseDouble(withholdingTaxes.getText().toString()));
                salaryData.setOther(Double.parseDouble(other.getText().toString()));
                sds.updateSalaryData(salaryData);




                intent.putExtra("id", id);
                startActivity(intent);

            }
        });

    }
}

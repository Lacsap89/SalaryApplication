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
import com.example.pascal.salaryapplication.db.adapter.SalaryDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.SalaryData;

public class SalaryDataAdd extends AppCompatActivity {

    private EditText brutSalary;
    private EditText advance;
    private EditText withholdingTaxes;
    private EditText other;

    private Button save;

    String id;
    SalaryData salaryData = new SalaryData();
    SalaryDataSource sds = new SalaryDataSource(this);

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_add);


        Intent intent = getIntent();


        id = getIntent().getStringExtra("id");

        salaryData = sds.getSalaryDataById(1);
        save = (Button) findViewById(R.id.save);
        brutSalary = (EditText) findViewById(R.id.editBrutSalary);
        advance = (EditText) findViewById(R.id.editAdvance);
        withholdingTaxes = (EditText) findViewById(R.id.editTaxes);
        other = (EditText) findViewById(R.id.editOther);



        brutSalary.setText(intent.getStringExtra("brutSalary"));
        advance.setText(intent.getStringExtra("advance"));
        withholdingTaxes.setText(intent.getStringExtra("taxes"));
        other.setText(intent.getStringExtra("other"));


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SalaryDataAdd.this, Salary.class);
                salaryData = new SalaryData(Double.parseDouble(brutSalary.getText().toString()));
                salaryData.setAdvance(Double.parseDouble(advance.getText().toString()));
                salaryData.setWithholdingTaxes(Double.parseDouble(withholdingTaxes.getText().toString()));
                salaryData.setOther(Double.parseDouble(other.getText().toString()));
               sds.createSalaryData(salaryData);




                intent.putExtra("id", id);
                startActivity(intent);

            }
        });

    }
}

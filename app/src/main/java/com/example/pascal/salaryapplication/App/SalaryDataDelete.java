package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.SalaryDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.SalaryData;

/**
 * Created by Pascal on 01.12.2015.
 */
public class SalaryDataDelete extends AppCompatActivity{

    private EditText deleteid;
    private String id;
    Button delete;
    private SalaryData salaryData = new SalaryData();
    private SalaryDataSource sds = new SalaryDataSource(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_delete);

        deleteid = (EditText) findViewById(R.id.deleteEdit);
        delete = (Button) findViewById(R.id.deletebutton);

        deleteid.setText("0");

        Intent intent = getIntent();

        id = getIntent().getStringExtra("id");

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SalaryDataDelete.this, Salary.class);
                salaryData.setId(Integer.parseInt(deleteid.getText().toString()));
                sds.deleteSalaryData(salaryData.getId());

                intent.putExtra("id", id);
                startActivity(intent);

            }

        });
    }


}

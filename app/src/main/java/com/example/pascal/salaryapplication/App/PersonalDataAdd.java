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
import com.example.pascal.salaryapplication.db.object.PersonalData;

public class PersonalDataAdd extends AppCompatActivity {

    private EditText address;
    private EditText birthdate;
    private EditText bank;
    private EditText civilStatus;
    private EditText nbChildren;
    private EditText nationality;
    private EditText workPermit;
    private EditText contractBegin;
    private EditText percentage;
    private EditText hollidayLeft;
    private Button save;

    String id;
    PersonalData personalData = new PersonalData();
    PersonalDataSource pds = new PersonalDataSource(this);

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data_add);


        Intent intent = getIntent();


        id = getIntent().getStringExtra("id");

        personalData = pds.getPersonById(Integer.parseInt(id));
        save = (Button) findViewById(R.id.save);
        address = (EditText) findViewById(R.id.editText1);
        birthdate = (EditText) findViewById(R.id.editText2);
        bank = (EditText) findViewById(R.id.showBank);
        civilStatus = (EditText) findViewById(R.id.showCivilStatus);
        nbChildren = (EditText) findViewById(R.id.editText);
        nationality = (EditText) findViewById(R.id.showNationality);
        workPermit = (EditText) findViewById(R.id.showWorkPermit);
        contractBegin = (EditText) findViewById(R.id.showContractBegin);
        percentage = (EditText) findViewById(R.id.editPercentage);
        hollidayLeft = (EditText) findViewById(R.id.showHollidayLeft);


        address.setText(intent.getStringExtra("address"));
        birthdate.setText(intent.getStringExtra("birthdate"));
        bank.setText(intent.getStringExtra("bank"));
        civilStatus.setText(intent.getStringExtra("civilStatus"));
        nbChildren.setText(intent.getStringExtra("nbChildren"));
        nationality.setText(intent.getStringExtra("nationality"));
        workPermit.setText(intent.getStringExtra("workPermit"));


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalDataAdd.this, PersonnalDataActivity.class);
                personalData.setAddress(address.getText().toString());
                personalData.setBirthdate(birthdate.getText().toString());
                personalData.setBank(bank.getText().toString());
                personalData.setCivilStatus(civilStatus.getText().toString());
                personalData.setNbChildren(Integer.parseInt(nbChildren.getText().toString()));
                personalData.setNationality(nationality.getText().toString());
                personalData.setPermit(workPermit.getText().toString());
                personalData.setContractBegin(contractBegin.getText().toString());
                personalData.setPercentage(Integer.parseInt(percentage.getText().toString()));
                personalData.setHollidayLeft(Integer.parseInt(hollidayLeft.getText().toString()));



                pds.createPersonalData(personalData);
                intent.putExtra("id", id);
                startActivity(intent);

            }
        });

    }
}

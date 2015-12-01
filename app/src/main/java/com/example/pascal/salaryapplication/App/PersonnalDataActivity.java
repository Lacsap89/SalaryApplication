package com.example.pascal.salaryapplication.App;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;

public class PersonnalDataActivity extends AppCompatActivity  {

    TextView id;
    TextView street;
    TextView birthdate;
    TextView civilStatus;
    TextView children;
    TextView nationality;
    TextView workPermit;
    TextView bank;
    PersonalData personalData = new PersonalData();

    PersonalDataSource pds = new PersonalDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnal_data);

        Intent intent = getIntent();


        id = (TextView) findViewById(R.id.showId);
        street = (TextView) findViewById(R.id.showStreet);
        birthdate = (TextView) findViewById(R.id.showBirthdate);
        civilStatus = (TextView) findViewById(R.id.showCivilStatus);
        children = (TextView) findViewById(R.id.showNbChildren);
        nationality = (TextView) findViewById(R.id.showNationality);
        workPermit = (TextView) findViewById(R.id.showWorkPermit);
        bank = (TextView) findViewById(R.id.showBank);

        id.setText(getIntent().getStringExtra("id"));
        personalData = pds.getPersonById(Integer.parseInt(id.getText().toString()));
        personalData.setId(Integer.parseInt(id.getText().toString()));

        street.setText(personalData.getAddress());
        birthdate.setText(personalData.getBirthdate());
        civilStatus.setText(personalData.getCivilStatus());
        children.setText(String.valueOf((personalData.getNbChildren())));
        nationality.setText(personalData.getNationality());
        workPermit.setText(personalData.getPermit());
        bank.setText(personalData.getBank());


    }
    // MODIFY BUTTON

    public void gotoModify(View view) {

        Intent intent = new Intent(this,PersonnalDataModify.class);
        intent.putExtra("address", personalData.getAddress());
        intent.putExtra("birthdate", personalData.getBirthdate());
        intent.putExtra("bank", personalData.getBank());
        intent.putExtra("civilStatus", personalData.getCivilStatus());
        intent.putExtra("nbChildren", personalData.getNbChildren());
        intent.putExtra("nationality", personalData.getNationality());
        intent.putExtra("workPermit", personalData.getPermit());
        intent.putExtra("id", id.getText().toString());
        startActivity(intent);
    }

    public void gotoDelete(View view){
        Intent intent = new Intent(this, PersonalDataDelete.class);
        intent.putExtra("id", id.getText().toString());
        startActivity(intent);
    }

    public void gotoAdd(View view){
        Intent intent = new Intent(this, PersonalDataAdd.class);
        intent.putExtra("id", id.getText().toString());
        startActivity(intent);
    }


    // SETTINGS
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personnal_data, menu);
        return super.onCreateOptionsMenu(menu);
    }

}

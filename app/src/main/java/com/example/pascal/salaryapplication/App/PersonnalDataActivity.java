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
import android.widget.Toast;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;

public class PersonnalDataActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnal_data);

        PersonalData personalData = new PersonalData();

        PersonalDataSource pds = new PersonalDataSource(this);

// SETTINGS
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personnal_data, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

       

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

//SETTINGS DISPLAY
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.dialog_settings)
                    .create()
                    .show();
            RadioButton frRb = (RadioButton)findViewById(R.id.diagRbFr);
            RadioButton enRb = (RadioButton)findViewById(R.id.diagRbEn);
        }

        return super.onOptionsItemSelected(item);
    }

// BUTTON

    public void gotoModify(View view) {

        Intent intent = new Intent(this,PersonnalDataModify.class);
        startActivity(intent);
    }









}

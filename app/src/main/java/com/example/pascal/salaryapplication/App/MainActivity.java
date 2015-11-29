package com.example.pascal.salaryapplication.App;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SalaryContract;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personnal_data, menu);
        return super.onCreateOptionsMenu(menu);
    }
// BUTTONS CLICK
    public void gotoperso(View view) {
        Intent intent = new Intent(this,PersonnalDataActivity.class);
        startActivity(intent);
    }
    public void gotopro(View view) {
        Intent intent = new Intent(this,ProfessionnalDataActivity.class);
        startActivity(intent);
    }
    public void gotosal(View view) {
        Intent intent = new Intent(this,Salary.class);
        startActivity(intent);
    }
// CLEAN DISCONNECT (TODO)
// SETTINGS


    // RADIO BUTTONS
    public void onRadioButtonClicked(View view) {

        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.diagRbFr:
                if (checked)
                    // FRENCH
                {
                    Locale myLocale = new Locale("fr");
                    Locale.setDefault(myLocale);
                    android.content.res.Configuration config = new android.content.res.Configuration();
                    config.locale = myLocale;
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                }
                break;
            case R.id.diagRbEn:
                if (checked)
                    // ENGLISH
                {
                    Locale myLocale = new Locale("en_US");
                    Locale.setDefault(myLocale);
                    android.content.res.Configuration config = new android.content.res.Configuration();
                    config.locale = myLocale;
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                }
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.dialog_settings);
            //OK AND CANCEL BUTTONS
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });

            builder.create()
                    .show();

        }

        return super.onOptionsItemSelected(item);
    }

}

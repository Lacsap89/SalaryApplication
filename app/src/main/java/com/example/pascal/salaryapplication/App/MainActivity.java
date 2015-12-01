package com.example.pascal.salaryapplication.App;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SalaryContract;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = getIntent().getStringExtra("id");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personnal_data, menu);
        return super.onCreateOptionsMenu(menu);
    }
// MAIN ACTIVITY BUTTONS CLICK
    public void gotoperso(View view) {
        Intent intent = new Intent(this,PersonnalDataActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
    public void gotopro(View view) {
        Intent intent = new Intent(this,ProfessionnalDataActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
    public void gotosal(View view) {
        Intent intent = new Intent(this,Salary.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
// CLEAN DISCONNECT (TODO)
// SETTINGS
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {

            final CharSequence[]items ={"Français","English"};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // settings.RADIO BUTTONS
            builder.setTitle("Settings").setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
                TextView tVwelcome = (TextView) findViewById(R.id.welcomTview);
                Button btnPerso = (Button)findViewById(R.id.persoBtn);
                Button btnPro = (Button)findViewById(R.id.proBtn);
                Button btnSal = (Button)findViewById(R.id.salaryBtn);
                Button btnLeave = (Button)findViewById(R.id.leaveBtn);
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch(which) {

                        case 0:
                            Toast.makeText(MainActivity.this.getApplicationContext(),"Français",Toast.LENGTH_LONG).show();
                            Locale myLocale = new Locale("fr");
                            Locale.setDefault(myLocale);
                            android.content.res.Configuration config = new android.content.res.Configuration();
                            config.locale = myLocale;
                            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());


                            tVwelcome.setText(R.string.welcomeTview);
                            btnPerso.setText(R.string.persoBtn);
                            btnPro.setText(R.string.proBtn);
                            btnSal.setText(R.string.salBtn);
                            btnLeave.setText(R.string.leavBtn);


                                break;
                        case 1:
                            Toast.makeText(MainActivity.this.getApplicationContext(),"English",Toast.LENGTH_LONG).show();
                            myLocale = new Locale("en");
                            Locale.setDefault(myLocale);
                            config = new android.content.res.Configuration();
                            config.locale = myLocale;
                            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                            tVwelcome.setText(R.string.welcomeTview);
                            btnPerso.setText(R.string.persoBtn);
                            btnPro.setText(R.string.proBtn);
                            btnSal.setText(R.string.salBtn);
                            btnLeave.setText(R.string.leavBtn);
                                break;
                    }

                }
            });
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

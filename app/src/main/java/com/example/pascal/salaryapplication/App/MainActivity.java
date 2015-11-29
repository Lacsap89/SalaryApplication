package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SalaryContract;

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

}

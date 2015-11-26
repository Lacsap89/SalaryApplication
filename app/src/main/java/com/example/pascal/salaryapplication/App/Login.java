package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pascal.salaryapplication.App.PersonnalDataActivity;
import com.example.pascal.salaryapplication.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void gotoHome(View view) {
        Intent intent = new Intent(this,PersonnalDataActivity.class);
        startActivity(intent);
    }
}

package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.SalaryContract;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.ProfessionalDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;

public class ProfessionnalDataModify extends AppCompatActivity {
    EditText editPost;
    EditText editContractBegin;
    EditText editSalaryClass;
    EditText editPercentage;
    EditText editHollidayLeft;
    EditText editBoss;
    Button save;
    String id;
    ProfessionalData professionalData = new ProfessionalData();
    ProfessionalDataSource pds = new ProfessionalDataSource(this);
    PersonalData personalData = new PersonalData();
    PersonalDataSource peds = new PersonalDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionnal_data_modify);

        Intent intent = getIntent();


        save = (Button) findViewById(R.id.save);
        editPost = (EditText) findViewById(R.id.editpost);
        editContractBegin = (EditText) findViewById(R.id.editContractBegin);
        editSalaryClass = (EditText) findViewById(R.id.editSalaryClass);
        editPercentage = (EditText) findViewById(R.id.editPercentage);
        editHollidayLeft = (EditText) findViewById(R.id.editHollidayLeft);
        editBoss = (EditText) findViewById(R.id.editBoss);

        id=intent.getStringExtra("id");
        editPost.setText(intent.getStringExtra("post"));
        editContractBegin.setText(intent.getStringExtra("contractBegin"));
        editSalaryClass.setText(intent.getStringExtra("salaryClass"));
        editPercentage.setText(intent.getStringExtra("percentage"));
        editHollidayLeft.setText(intent.getStringExtra("hollidayLeft"));
        editBoss.setText(intent.getStringExtra("boss"));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfessionnalDataModify.this, ProfessionnalDataActivity.class);
                personalData.setId(Integer.parseInt(id));
                personalData = peds.getPersonById(personalData.getId());
                professionalData.setPostId(personalData.getPostId());
                professionalData = pds.getProfessionalDataById(professionalData.getPostId());

                professionalData.setPost(editPost.getText().toString());
                professionalData.setSalaryClass(Integer.parseInt(editSalaryClass.getText().toString()));
                professionalData.setBoss(editBoss.getText().toString());
                personalData.setContractBegin(editContractBegin.getText().toString());
                personalData.setPercentage(Integer.parseInt(editPercentage.getText().toString()));
                personalData.setHollidayLeft(Integer.parseInt(editHollidayLeft.getText().toString()));



                pds.updateProfessionalData(professionalData);
                peds.updatePersonalData(personalData);
                intent.putExtra("id", id);

                ProfessionnalDataModify.this.startActivity(intent);

            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_professionnal_data_modify, menu);
        return true;
    }


}

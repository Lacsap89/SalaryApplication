package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.adapter.ProfessionalDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;
import com.example.pascal.salaryapplication.db.object.ProfessionalData;

public class ProfessionnalDataActivity extends AppCompatActivity {

    private TextView showPost;
    private TextView showContractBegin;
    private TextView showSalaryClass;
    private TextView showPercentage;
    private TextView showHollidayLeft;
    private TextView showBoss;
    private TextView id;

    private PersonalData personalData = new PersonalData();
    private ProfessionalData professionalData = new ProfessionalData();

    private PersonalDataSource pds = new PersonalDataSource(this);
    private ProfessionalDataSource prds = new ProfessionalDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionnal_data);


        Intent intent=getIntent();

        id = (TextView) findViewById(R.id.showId);
        showPost= (TextView) findViewById(R.id.showpost);
        showContractBegin = (TextView) findViewById(R.id.showContractBegin);
        showSalaryClass = (TextView) findViewById(R.id.showSalaryClass);
        showPercentage = (TextView) findViewById(R.id.showPercentage);
        showHollidayLeft = (TextView) findViewById(R.id.showHollidayLeft);
        showBoss = (TextView) findViewById(R.id.showBoss);

        id.setText(getIntent().getStringExtra("id"));
        personalData = pds.getPersonById(Integer.parseInt(id.getText().toString()));

        professionalData.setPostId(personalData.getPostId());
        professionalData = prds.getProfessionalDataById(professionalData.getPostId());

        showPost.setText(professionalData.getPost());
        showContractBegin.setText(personalData.getContractBegin());
        showSalaryClass.setText(String.valueOf(professionalData.getSalaryClass()));
        showPercentage.setText(String.valueOf(personalData.getPercentage()));
        showHollidayLeft.setText(String.valueOf(personalData.getHollidayLeft()));
        showBoss.setText(professionalData.getBoss());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_professionnal_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void gotoModifyPro(View view) {
        Intent intent = new Intent(this,ProfessionnalDataModify.class);

        intent.putExtra("post", professionalData.getPost());
        intent.putExtra("contractBegin", personalData.getContractBegin());
        intent.putExtra("salaryClass", professionalData.getSalaryClass());
        intent.putExtra("percentage", personalData.getPercentage());
        intent.putExtra("hollidayLeft", personalData.getHollidayLeft());
        intent.putExtra("boss", professionalData.getBoss());
        intent.putExtra("id", id.getText().toString());
        intent.putExtra("professionalId", professionalData.getPostId());
        professionalData.setSalaryId(1);




        startActivity(intent);
    }
}

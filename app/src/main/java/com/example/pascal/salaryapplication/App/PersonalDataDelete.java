package com.example.pascal.salaryapplication.App;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pascal.salaryapplication.R;
import com.example.pascal.salaryapplication.db.adapter.PersonalDataSource;
import com.example.pascal.salaryapplication.db.object.PersonalData;

/**
 * Created by Pascal on 01.12.2015.
 */
public class PersonalDataDelete extends AppCompatActivity{

    private EditText deleteid;
    private String id;
    Button delete;
    private PersonalData personalData = new PersonalData();
    private PersonalDataSource pds = new PersonalDataSource(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data_delete);

        deleteid = (EditText) findViewById(R.id.deleteEdit);
        delete = (Button) findViewById(R.id.deletebutton);

        deleteid.setText("0");

        Intent intent = getIntent();

        id = getIntent().getStringExtra("id");

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalDataDelete.this, PersonnalDataActivity.class);
                personalData.setId(Integer.parseInt(deleteid.getText().toString()));
                pds.deletePersonalData(personalData.getId());

                intent.putExtra("id", id);
                startActivity(intent);

            }

        });
    }


}

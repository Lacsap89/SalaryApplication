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
    TextView city;
    TextView birthdate;
    TextView civilStatus;
    TextView children;
    TextView nationality;
    TextView workPermit;
    TextView bank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnal_data);

        PersonalData personalData = new PersonalData();

        PersonalDataSource pds = new PersonalDataSource(this);




    }
    // MODIFY BUTTON

    public void gotoModify(View view) {

        Intent intent = new Intent(this,PersonnalDataModify.class);
        startActivity(intent);
    }



// SETTINGS
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personnal_data, menu);
        return super.onCreateOptionsMenu(menu);


    }
   // RADIO BUTTONS
    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.diagRbFr:
                if (checked)
                    // FRENCH
                    break;
            case R.id.diagRbEn:
                if (checked)
                    // ENGLISH
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

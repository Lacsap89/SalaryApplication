package com.example.pascal.salaryapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ProfessionnalDataModify extends AppCompatActivity {
    EditText editPost;
    Spinner spinner= (Spinner) findViewById(R.id.editSalaryClass);

    ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.editSalaryClass, android.R.layout.simple_spinner_item);

    //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    //spinner.setAdapter(adapter);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionnal_data_modify);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_professionnal_data_modify, menu);
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

    public void saveChange(View view){
        Intent intent= new Intent(this, ProfessionnalDataActivity.class);
        intent.putExtra("editPost",editPost.getText().toString());

        ProfessionnalDataModify.this.startActivity(intent);

    }
}

package com.example.samad786.cyclonedriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DriverPersonalDetails extends AppCompatActivity {

    EditText address,city,postcode,province,countty,dob,nationality,lisence_n,issue,issuedate,expiredate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_personal_details);
        address=(EditText)findViewById(R.id.address);
        city =(EditText)findViewById(R.id.city);
        postcode=(EditText)findViewById(R.id.postalcode);
        province=(EditText)findViewById(R.id.province);
        countty=(EditText)findViewById(R.id.country);
        dob=(EditText)findViewById(R.id.dateofbirth);
        nationality=(EditText)findViewById(R.id.nationality);
        lisence_n=(EditText)findViewById(R.id.lisence_n);
        issue=(EditText)findViewById(R.id.issue);
        issuedate=(EditText)findViewById(R.id.issuedate);
        expiredate=(EditText)findViewById(R.id.expiredate);
    }
    public void con(View view)
    {
        if (address.getText().length()>0
                && city.getText().length()>0
                && postcode.getText().length()>0
                && province.getText().length()>0
                && countty.getText().length()>0
                && dob.getText().length()>0
                && nationality.getText().length()>0
                && lisence_n.getText().length()>0
                && issue.getText().length()>0
                && issuedate.getText().length()>0
                && expiredate.getText().length()>0
                ) {
            finish();
            startActivity(new Intent(this, BankingDetails.class));
        }else {
            Toast.makeText(this, "Please provide complete information to continue....", Toast.LENGTH_SHORT).show();
        }
    }
}

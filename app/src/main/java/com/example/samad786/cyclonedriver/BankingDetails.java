package com.example.samad786.cyclonedriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class BankingDetails extends AppCompatActivity {

    EditText nameoncard,accoutnumber,branchcode,branchaddress,accountholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking_details);
        nameoncard=(EditText)findViewById(R.id.nameoncard);
        accoutnumber=(EditText)findViewById(R.id.accountnumber);
        branchcode=(EditText)findViewById(R.id.branchcode);
        branchaddress=(EditText)findViewById(R.id.branchaddress);
        accountholder=(EditText)findViewById(R.id.accountholder);
    }
    public void con(View view)
    {
        if (nameoncard.getText().length()>0
                && accountholder.getText().length()>0
                && accoutnumber.getText().length()>0
                && branchaddress.getText().length()>0
                && branchcode.getText().length()>0
                ) {
            finish();
            startActivity(new Intent(this, Images.class));
        }else
        {
            Toast.makeText(this, "Please Provide Valid/Complete Information", Toast.LENGTH_LONG).show();
        }

    }
}

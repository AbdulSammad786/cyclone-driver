package com.example.samad786.cyclonedriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivationCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_code);
    }
    public void activation(View view)
    {
        finish();
        startActivity(new Intent(this,VehicleDetails.class));
    }
}

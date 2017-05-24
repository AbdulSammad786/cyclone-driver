package com.example.samad786.cyclonedriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VehicleDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);
    }
    public void con(View view)
    {
        finish();
        startActivity(new Intent(this,DriverPersonalDetails.class));
    }
}

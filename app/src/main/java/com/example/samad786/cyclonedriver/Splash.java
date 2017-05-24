package com.example.samad786.cyclonedriver;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.logging.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new android.os.Handler().postDelayed(new Runnable() {
            public void run() {
                finish();
                startActivity(new Intent(Splash.this,Login.class));
            }
        }, 3000);
    }
}

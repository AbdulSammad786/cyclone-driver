package com.example.samad786.cyclonedriver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.LinkAddress;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UploadDocuments extends AppCompatActivity {

    LinearLayout passport,proff,driverlisence,cardlisence;
    TextView passportchoose,driverchoose,cardchoose,proffchoose;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_documents);
        preferences=getSharedPreferences("image", Context.MODE_PRIVATE);
        passport=(LinearLayout)findViewById(R.id.selectpassword);
        cardlisence=(LinearLayout)findViewById(R.id.selectcardlisence);
        driverlisence=(LinearLayout)findViewById(R.id.selectdriverlisence);
        proff=(LinearLayout)findViewById(R.id.selectproffofaddress);
        passportchoose=(TextView)findViewById(R.id.passportchoose);
        if (preferences.getString("passport","").equalsIgnoreCase(""))
        {
            passportchoose.setText("no file chosen");
        }else {
            passportchoose.setText(preferences.getString("passport", ""));
        }proffchoose=(TextView)findViewById(R.id.proffchoose);
        if (preferences.getString("proof","").equalsIgnoreCase(""))
        {
            proffchoose.setText("no file chosen");
        }else {
            proffchoose.setText(preferences.getString("proof", ""));
        }
        driverchoose=(TextView)findViewById(R.id.driverlisencechoose);
        if (preferences.getString("driver","").equalsIgnoreCase(""))
        {
            driverchoose.setText("no file chosen");
        }else {
            driverchoose.setText(preferences.getString("driver", ""));
        }
        cardchoose=(TextView)findViewById(R.id.cardlisencechoose);
        if (preferences.getString("card","").equalsIgnoreCase(""))
        {
            cardchoose.setText("no file chosen");
        }else {
            cardchoose.setText(preferences.getString("card", ""));
        }
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(1);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("passport","File Selected");
                editor.apply();
            }
        });

        cardlisence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(2);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("card","File Selected");
                editor.apply();
            }
        });
        proff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(3);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("proof","File Selected");
                editor.apply();
            }
        });
        driverlisence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(4);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("driver","File Selected");
                editor.apply();
            }
        });
    }
    private void openGallery(int n)
    {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");
        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");
        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
        startActivityForResult(chooserIntent,n);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1)
        {
            passportchoose.setText(preferences.getString("passport",""));
        }else if (requestCode==2)
        {
            cardchoose.setText(preferences.getString("card",""));
        }else if (requestCode==3)
        {
            proffchoose.setText(preferences.getString("proof",""));
        }else if (requestCode==4)
        {
            driverchoose.setText(preferences.getString("driver",""));
        }
    }
    public void con(View view)
    {
        finish();
        startActivity(new Intent(this,Home.class));
    }
}

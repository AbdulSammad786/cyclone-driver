package com.example.samad786.cyclonedriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;

public class Registration extends AppCompatActivity {

    EditText fullname,email,phone,password;
    Dialogs myDialogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fullname=(EditText)findViewById(R.id.fullname);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        phone=(EditText)findViewById(R.id.phone);
        myDialogs=new Dialogs(this);
    }
    public void register(View view)
    {
        if (fullname.getText().length()>0 &&email.getText().length()>0 &&phone.getText().length()>0 &&password.getText().length()>0)
        {
            requestRegistration("http://www.cyclonedelivery.com/cyclone_app/registration.php");
        }else
        {
            Toast.makeText(this, "Please Provide valid info and try again", Toast.LENGTH_SHORT).show();
        }
        finish();
        startActivity(new Intent(this,ActivationCode.class));
    }
    public void login(View view)
    {
        finish();
        startActivity(new Intent(this,Login.class));
    }
    private void parseJson(String json)
    {
        try{
            JSONObject obj=new JSONObject(json);
            if (obj.getString("success").equalsIgnoreCase("true"))
            {
                Toast.makeText(this, "Registration success", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(this,Home.class));
            }else
            {
                myDialogs.showDialog("Error","Pleae try again later");
            }
        }catch (Exception ex)
        {
            Log.d("error", "parseJson: ");
        }
    }
    public void requestRegistration(final String url) {

        myDialogs.showProgress();
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("onResponse:", response);
                        parseJson(response);
                        myDialogs.hideProgress();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error",error.toString());
                        myDialogs.hideProgress();
                        myDialogs.showDialog("Error","Internal Problem occurred ! Pleae try again later");
                    }
                }) {
            @Override
            protected java.util.Map<String, String> getParams() {
                java.util.Map<String, String> params = new HashMap<String, String>();
                params.put("fullname",fullname.getText().toString());
                params.put("password", password.getText().toString());
                params.put("email",email.getText().toString());
                params.put("phone", phone.getText().toString());
                params.put("category","driver");
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(request, "srarequest");
    }
}
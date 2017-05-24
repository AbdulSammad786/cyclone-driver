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

public class Login extends AppCompatActivity {

    EditText username,password;
    Dialogs myDialogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        myDialogs=new Dialogs(this);
        password=(EditText)findViewById(R.id.password);
    }
    public void login(View view)
    {
       if (username.getText().length()>0&&password.getText().length()>0) {
           requestLogin("http://www.cyclonedelivery.com/cyclone_app/login.php");
       }
    }
    public void register(View view)
    {
        finish();
        startActivity(new Intent(this,Registration.class));
    }
    private void parseJson(String json)
    {
        try{
            JSONObject obj=new JSONObject(json);
            if (obj.getString("success").equalsIgnoreCase("true"))
            {
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(this,Home.class));
            }else
            {
                myDialogs.showDialog("Error","Invalid Username or Password ! Pleae try again later");
            }
        }catch (Exception ex)
        {
            Log.d("error", "parseJson: ");
        }
    }
    public void requestLogin(final String url) {

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
                params.put("username",username.getText().toString() );
                params.put("password", password.getText().toString());
                params.put("category", "driver");
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

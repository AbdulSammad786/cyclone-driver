package com.example.samad786.cyclonedriver.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.samad786.cyclonedriver.R;

/**
 * Created by samad786 on 4/20/2017.
 */

public class DrinkFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment, null, false);
        showMessage("Account Successfully Activated !");
        return view;
    }
    private  void showMessage(String title)
    {
        // custom dialog
        final Dialog dialog = new android.app.Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);

        //dialog.setTitle("Title...");

        // set the custom dialog components - text, image and button
        TextView t=(TextView)dialog.findViewById(R.id.title);
        t.setText(title);
        Button dialogButton = (Button) dialog.findViewById(R.id.ok);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}

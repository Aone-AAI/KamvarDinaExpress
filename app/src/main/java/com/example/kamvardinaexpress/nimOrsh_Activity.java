package com.example.kamvardinaexpress;

import android.content.Context;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class nimOrsh_Activity extends AppCompatActivity {

    EditText adadNimOrsh;
    Button mohasebeh;
    TextView adNa;
    Double adad;
    double nahaei;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nim_orsh_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);

        relativeLayout = findViewById(R.id.nimOrsh_layout);
        adadNimOrsh =findViewById(R.id.adadNimOrsh);
        mohasebeh = findViewById(R.id.mohasebeh);
        adNa = findViewById(R.id.adadNahaei);

        mohasebeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if( TextUtils.isEmpty(adadNimOrsh.getText())){
                    /**
                     *   You can Toast a message here that the Username is Empty
                     **/

                    adadNimOrsh.setError( "مبلغ را وارد کنید" );

                }else{
                    adad = (Double.parseDouble(adadNimOrsh.getText().toString()))/1000000;
                    nahaei = mohasebeh(adad);
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    adNa.setText((formatter.format(nahaei)));
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(relativeLayout.getWindowToken(), 0);
                }


            }
        });
    }

    public double mohasebeh(Double adad) {
        if (adad != null) {
            double nahaei = adad * 0.05;
            return nahaei;
        }
        else{
            return 0;
        }
    }
}

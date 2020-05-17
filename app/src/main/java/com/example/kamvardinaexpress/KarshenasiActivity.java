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

public class KarshenasiActivity extends AppCompatActivity {

    EditText adadNimOrsh;
    Button mohasebeh;
    TextView adNa;
    Double adad;
    double nahaei;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karshenasi);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);


        relativeLayout = findViewById(R.id.karshenasi_layout);
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
            if(adad <50 && adad>150){
                double nahaei = adad * 0.5;
                return nahaei*1000000;
            }
            if(adad <150 && adad>250){
                double nahaei = adad * 0.4;
                return nahaei*1000000;
            }
            if(adad <250 && adad>1000){
                double nahaei = adad * 0.3;
                return nahaei*1000000;
            }
            if(adad <1000 && adad>10000){
                double nahaei = adad * 0.125;
                return nahaei*1000000;
            }
            if(adad <10000 && adad>150000){
                double nahaei = adad * 0.06;
                return nahaei*1000000;
            }
            if(adad <150000 && adad>500000){
                double nahaei = adad * 0.03;
                return nahaei*1000000;
            }

            if(adad <6500000 && adad>10000000){
                double nahaei = adad * 0.015;
                return nahaei*1000000;
            }
            if(adad <10000000){
                double nahaei = adad * 0.01;
                return nahaei*1000000;
            }else{
                return 0;
            }


        }
        else{
            return 0;
        }
    }
}

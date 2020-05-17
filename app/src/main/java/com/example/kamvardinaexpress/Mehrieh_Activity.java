package com.example.kamvardinaexpress;

import android.content.Context;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Mehrieh_Activity extends AppCompatActivity {
    EditText adadNimOrsh;
    Button mohasebeh;
    TextView adNa;
    Double adad;
    double nahaei;

    double[] shakhes = new double[]{ 0.01, 0.01 , 0.01,0.01,0.02,0.03,0.07,0.07,0.06,0.05,0.06,0.06,0.07,0.05,0.06,0.06,
    0.07,0.08,0.08,0.09,0.09,0.09,0.11,0.12,0.12,0.12,0.12,0.13,0.13,0.13,0.13,0.13,0.13,0.14,0.14,0.15,0.17,0.19,0.21,0.25,0.31,0.34,0.38,0.47,
    0.58,0.69,0.79,0.88,0.94,1.16,1.48,1.91,2.24,2.44,2.95,3.67,4.50,6.09,9.09,11.21,13.14,15.52,18.64,20.99,23.38,27.07,31.31,
    36.07,39.80,44.53,52.74,66.12,73.23,82.31,100.00,130.54,175.88,203.24,227.46,248.01};

//    double[] tavarom = new double[] {21.2,8.8,8.0,13.8,49.5,96.2,110.5,2.7,-14.4,-11.5,6.6,11.1,2.3,-17.2,8.3,7.2,9.2,15.9,1.7,8.8,
//    4.4,1.0,13.0,7.9,1.6,0.9,1.0,4.5,0.3,0.8,0.8,1.5,3.6,1.5,5.5,6.3,11.2,15.5,9.9,16.6,25.1,10.0,11.4,23.5,22.8,19.2,
//    14.8,10.4,6.9,23.7,27.7,28.9,17.4,9.0,20.7,24.4,22.9,35.2,49.4,23.2,17.3,18.1,20.1,12.6,11.4,15.8,15.6,15.2,10.4,11.9,18.4,
//    25.4,10.8,12.4,21.5,30.5,34.7,15.6,11.9,9.0};
    int size = shakhes.length;
//    int size1 = tavarom.length;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mehrieh_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);


        final int[] indexSpinner = new int[1];
        relativeLayout =findViewById(R.id.mehrieh_layout);
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1316; i <= 1395; i++) {
            years.add(Integer.toString(i));
        }
   //     this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        adadNimOrsh =findViewById(R.id.adadNimOrsh);
        mohasebeh = findViewById(R.id.mohasebeh);
        adNa = findViewById(R.id.adadNahaei);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

        final Spinner spinYear = (Spinner)findViewById(R.id.spinner);
//

        mohasebeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if( TextUtils.isEmpty(adadNimOrsh.getText())){
                    /**
                     *   You can Toast a message here that the Username is Empty
                     **/

                    adadNimOrsh.setError( "مبلغ را وارد کنید" );

                }else{
                    adad = (Double.parseDouble(adadNimOrsh.getText().toString()));
                    indexSpinner[0] =  spinYear.getSelectedItemPosition();
                    nahaei = (double) mohasebeh(adad, indexSpinner );
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    adNa.setText((formatter.format(nahaei)));

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(relativeLayout.getWindowToken(), 0);

                }

               // String spinner_data = spinYear.getSelectedItem().toString();
                //  System.out.println(formatter.format(nahaei));
                //  adNa.setText(Double.toString(nahaei));
//                Log.d(String.valueOf(size),"سلام");
//                Log.d(String.valueOf(size1),"سلام");
//                Log.d(String.valueOf(indexSpinner),"سلام");





            }
        });
        spinYear.setAdapter(adapter);
    }
    public double mohasebeh(Double adad , int[] indexSpinner ) {
        if (adad != null) {

            double nahaei = (227.46/shakhes[indexSpinner[0]])*adad;
            return nahaei;
        }
        else{
            return 0;
        }
    }
//    public static void hideSoftKeyboard(Activity activity) {
//        InputMethodManager inputMethodManager =
//                (InputMethodManager) activity.getSystemService(
//                        Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(
//                activity.getCurrentFocus().getWindowToken(), 0);
//        Log.d("salam","علیک");
//    }
}

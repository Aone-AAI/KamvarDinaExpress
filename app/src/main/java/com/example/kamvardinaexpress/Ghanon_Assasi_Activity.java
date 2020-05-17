package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ghanon_Assasi_Activity extends AppCompatActivity {
    PDFView pdfView;

//    AppCompatTextView aslaval;
//
//    AppCompatTextView asldovom;
   // AppCompatTextView appCompatTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghanon__assasi_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);

        pdfView = findViewById(R.id.ghanonAssasi);
        pdfView.fromAsset("ghanon_assasi.pdf").load();

//        appCompatTextView = findViewById(R.id.assasi_text);

//        try {
//
//            String str = "";
//            InputStream inputStream = getAssets().open("new.txt");
//            int size = inputStream.available();
//            byte[] buffer = new byte[size];
//           // new InputStreamReader(inputStream, "UTF-8");
//            inputStream.read(buffer);
//            str = new String(buffer);
//            appCompatTextView.setText(str);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




//        aslaval = findViewById(R.id.faslAval_ghanonAssasi_aslaval_main);
//
//        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/b_nazanin.TTF");
//
//        aslaval.setTypeface(customFont);
//
//        asldovom = findViewById(R.id.aseldovaom_main);
//
//        Typeface customFontdovom = Typeface.createFromAsset(getAssets(),"fonts/b_nazanin.TTF");
//
//        asldovom.setTypeface(customFontdovom);





    }
}

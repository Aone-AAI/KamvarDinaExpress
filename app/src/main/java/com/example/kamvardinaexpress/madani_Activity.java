package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class madani_Activity extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madani_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);

//        pdfView = findViewById(R.id.madni);
//        pdfView.fromAsset("").load();
    }

    public void moghadame(View view) {
        Intent intent2 = new Intent(this,mohgadameh_madani.class);
        startActivity(intent2);

    }

    public void ashkhas(View view) {

        Intent intent2 = new Intent(this,amvalvaashkhas_madani.class);
        startActivity(intent2);
    }

    public void amval(View view) {

        Intent intent2 = new Intent(this,amvalmadeh_madani.class);
        startActivity(intent2);
    }

    public void ersvavasiat(View view) {

        Intent intent2 = new Intent(this,ersvavasiat_madani.class);
        startActivity(intent2);
    }


    public void OmorHesbi(View view) {
        Intent intent2 = new Intent(this,OmorHesbi.class);
        startActivity(intent2);
    }
}

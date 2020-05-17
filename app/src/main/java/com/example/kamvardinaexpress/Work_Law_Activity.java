package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class Work_Law_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__law_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);


    }

    public void bimehBikari(View view) {
        Intent intent = new Intent(this,BimehBiakri_ghanonOmomi.class);
        startActivity(intent);

    }


    public void dafterAvalghanonkar(View view) {

        Intent intent = new Intent(this,daftarAvalWorkLaw_Omomi.class);
        startActivity(intent);
    }
}

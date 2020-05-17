package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class jaza_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaza_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);


    }

    public void ghanon_mojazat_eslami(View view) {
        Intent intent2 = new Intent(this,ghanonMogazatEslami_keifari.class);
        startActivity(intent2);


    }

    public void aeindadrasikerfari(View view) {
        Intent intent2 = new Intent(this,Aeindadrasikeifari_keifari.class);
        startActivity(intent2);

    }

    public void aslahehva(View view) {
        Intent intent2 = new Intent(this,ghanonMogazatvaaslah_keifari.class);
        startActivity(intent2);

    }
}

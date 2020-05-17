package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class Registry_law_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry_law_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);

    }

    public void daftarAsnadRasmi(View view) {
        Intent intent2 = new Intent(this,daftarAsnadRasmi.class);
        startActivity(intent2);

    }

    public void ekhteraa(View view) {

        Intent intent2 = new Intent(this,Thabtekhteraa.class);
        startActivity(intent2);
    }

    public void sherkatThabt(View view) {

        Intent intent2 = new Intent(this,thabtShekat.class);
        startActivity(intent2);
    }

    public void ahvalThabt(View view) {

        Intent intent2 = new Intent(this,ThatAhval.class);
        startActivity(intent2);
    }

    public void thabtAsnad(View view) {

        Intent intent2 = new Intent(this,thabtAmalakvaAmval.class);
        startActivity(intent2);
    }

    public void shekaiatAzAmaliatEjraei(View view) {

        Intent intent2 = new Intent(this,shekaiatAzAmaliatEjraei.class);
        startActivity(intent2);

    }
}

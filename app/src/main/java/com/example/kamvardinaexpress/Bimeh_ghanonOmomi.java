package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class Bimeh_ghanonOmomi extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bimeh_ghanon_omomi);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);

        pdfView = findViewById(R.id.bimehpdf);

        pdfView.fromAsset("bimeh.pdf").load();
    }
}

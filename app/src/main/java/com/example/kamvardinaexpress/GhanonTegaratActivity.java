package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class GhanonTegaratActivity extends AppCompatActivity {

    PDFView pdfViewTegarat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghanon_tegarat);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);

        pdfViewTegarat = findViewById(R.id.new_pdftegarat);

        pdfViewTegarat.fromAsset("new_tegarat.pdf").load();
    }
}

package com.example.kamvardinaexpress;

import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tegarat_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tegarat_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);

    }

    public void ghanon_check(View view) {

        Intent intent = new Intent(this,GhanonCheck.class);
        startActivity(intent);
    }

    public void tegarat_electronic(View view) {

        Intent intent = new Intent(this,TegaratElectronic.class);
        startActivity(intent);
    }


    public void tegarat(View view) {

        Intent intent = new Intent(this,GhanonTegaratActivity.class);
        startActivity(intent);
    }

    public void varshekastegi(View view) {
        Intent intent = new Intent(this,EdarehVarshekastegi.class);
        startActivity(intent);

    }
}

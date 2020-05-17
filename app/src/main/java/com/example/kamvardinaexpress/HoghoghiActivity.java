package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HoghoghiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoghoghi);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);
    }


    public void madani(View view) {
        Intent intent2 = new Intent(this,madani_Activity.class);
        startActivity(intent2);

    }

    public void dadrasi_madani(View view) {

        Intent intent2 = new Intent(this,AeinDadrasiMadani_madani.class);
        startActivity(intent2);
    }

    public void masoliatmdani(View view) {
        Intent intent2 = new Intent(this,GhanonMasoliatmadani.class);
        startActivity(intent2);

    }

    public void dahhashtad(View view) {
        Intent intent2 = new Intent(this,masoliatmadaniDAHHASHTAD.class);
        startActivity(intent2);

    }

    public void esfesarieh(View view) {
        Intent intent2 = new Intent(this,GhanonEsfesarieh.class);
        startActivity(intent2);
    }
}

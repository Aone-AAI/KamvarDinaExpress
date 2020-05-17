package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class lawyerLawAsli extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_law_asli);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);
    }

    public void karshenasanrasmi(View view) {
        Intent intent2 = new Intent(this,lawyerlawKarshenasan.class);
        startActivity(intent2);

    }

    public void esteghlal(View view) {
        Intent intent2 = new Intent(this,EsteghlalkanonVokala.class);
        startActivity(intent2);


    }

    public void parvaneh(View view) {
        Intent intent2 = new Intent(this,lawyerlawAkhzeparvaneh.class);
        startActivity(intent2);

    }

    public void lawyerlaw(View view) {
        Intent intent2 = new Intent(this,lawyer_law.class);
        startActivity(intent2);

    }

    public void esteghlalKanonMosavab1334(View view) {
        Intent intent2 = new Intent(this,EsteghlalKanonVokalaMosavab1334.class);
        startActivity(intent2);
    }
}

package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Family_law_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_law_);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);


    }

    public void mohasebmehrieh(View view) {

        Intent intent2 = new Intent(this,mohasebehArzeshMehrieh_Activity.class);
        startActivity(intent2);
    }

    public void ehdaeijanin(View view) {

        Intent intent2 = new Intent(this,ehdaiejanin.class);
        startActivity(intent2);
    }

    public void sedghdarmani(View view) {

        Intent intent2 = new Intent(this,sedghdarmani.class);
        startActivity(intent2);
    }

    public void egraeimahkomiat(View view) {

        Intent intent2 = new Intent(this,egraiemahkomiat.class);
        startActivity(intent2);
    }

    public void khiant(View view) {
        Intent intent2 = new Intent(this,khiant.class);
        startActivity(intent2);
    }

    public void roshdemotahlin(View view) {

        Intent intent2 = new Intent(this,roshdeMoteahlin.class);
        startActivity(intent2);
    }

    public void kodakanbisarparast(View view) {

        Intent intent2 = new Intent(this,kodakhaibisarparst.class);
        startActivity(intent2);
    }

    public void ghaimemovaghat(View view) {

        Intent intent2 = new Intent(this,ghaiemiat.class);
        startActivity(intent2);
    }

    public void hemaiatkhanevadeh(View view) {

        Intent intent2 = new Intent(this,hemaiatkhanevadeh.class);
        startActivity(intent2);
    }

    public void ghireshiee(View view) {

        Intent intent2 = new Intent(this,ghireshiaa.class);
        startActivity(intent2);
    }

    public void ezdevajmardanbaAvareha(View view) {
        Intent intent2 = new Intent(this,ezdevahmardanbaavareha.class);
        startActivity(intent2);

    }
}

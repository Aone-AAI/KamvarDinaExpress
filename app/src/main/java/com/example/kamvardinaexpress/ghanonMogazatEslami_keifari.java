package com.example.kamvardinaexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ghanonMogazatEslami_keifari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghanon_mogazat_eslami_keifari);
    }

    public void koliat(View view) {
        Intent intent2 = new Intent(this,koliat_keifari.class);
        startActivity(intent2);


    }

    public void hodad(View view) {
        Intent intent2 = new Intent(this,hodod_keifari.class);
        startActivity(intent2);


    }

    public void ghesas(View view) {
        Intent intent2 = new Intent(this,gheasa_keifari.class);
        startActivity(intent2);


    }

    public void dianat(View view) {

        Intent intent2 = new Intent(this,dianat_keifari.class);
        startActivity(intent2);

    }

    public void bazdarandeh(View view) {

        Intent intent2 = new Intent(this,bazdaradeh_keifari.class);
        startActivity(intent2);

    }
}

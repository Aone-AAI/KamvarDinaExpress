package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GhaonoOmomiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghaono_omomi);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);
    }

    public void kar(View view) {
        Intent intent = new Intent(this,Work_Law_Activity.class);
        startActivity(intent);
    }

    public void estekhdam(View view) {
        Intent intent = new Intent(this,Estekhdam_Activity.class);
        startActivity(intent);
    }

    public void bimeh(View view) {

        Intent intent = new Intent(this,Bimeh_ghanonOmomi.class);
        startActivity(intent);
    }

    public void maliat(View view) {
        Intent intent = new Intent(this,maliat_Activity.class);
        startActivity(intent);
    }
}

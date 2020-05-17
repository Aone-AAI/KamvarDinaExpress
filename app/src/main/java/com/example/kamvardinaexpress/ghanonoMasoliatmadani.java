package com.example.kamvardinaexpress;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ghanonoMasoliatmadani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghanono_masoliatmadani);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);



    }

    public void masoliatmadani(View view) {

        Intent intent2 = new Intent(this,GhanonMasoliatmadani.class);
        startActivity(intent2);
    }

    public void esfesarieh(View view) {
        Intent intent2 = new Intent(this,GhanonEsfesarieh.class);
        startActivity(intent2);
    }

    public void dahhashtad(View view) {

        Intent intent2 = new Intent(this,masoliatmadaniDAHHASHTAD.class);
        startActivity(intent2);
    }
}

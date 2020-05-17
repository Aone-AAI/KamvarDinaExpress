package com.example.kamvardinaexpress;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public AppCompatActivity c;
    public Dialog d;
    public Button yes, no;



    public CustomDialogClass(AppCompatActivity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.customize_alertdialog);
        setCancelable(false);
        no = (Button) findViewById(R.id.btn_no);
        yes = (Button) findViewById(R.id.btn_yes);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:



                final String appName = c.getPackageName();

                                try {
                                   c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://kamvardina.ir/download")));
                                } catch (android.content.ActivityNotFoundException anfe) {
                                    c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://kamvardina.ir/download")));
                                }

                c.finish();


             break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }

        }

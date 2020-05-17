package com.example.kamvardinaexpress;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_sana_Vokala extends AppCompatActivity {

    WebView webViewsite;
    AppCompatActivity activity;
    private ProgressDialog progDailog;


    @Override
    public void onBackPressed() {

        if (webViewsite.canGoBack()) {
            webViewsite.goBack();
        } else {
            super.onBackPressed();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sana__vokala);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_for_site);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);
        ImageView imageView = view.findViewById(R.id.imageviewtomainactivity);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        if (Build.VERSION.SDK_INT >= 19) {


            if (!DetectConnection.checkInternetConnection(this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                webViewsite = findViewById(R.id.Vokala_sana_site);
                CustomWebViewClient c = new CustomWebViewClient();
                webViewsite.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                webViewsite.setWebViewClient(c);
                webViewsite.clearCache(true);
                webViewsite.clearHistory();
                activity = this;
                progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
                progDailog.setCancelable(false);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailog.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);

                webViewsite.getSettings().setJavaScriptEnabled(true);
                webViewsite.getSettings().setLoadWithOverviewMode(true);
                webViewsite.getSettings().setUseWideViewPort(true);
                webViewsite.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailog.show();
                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailog.isShowing()) {
                            progDailog.dismiss();
                        }
                    }
                });

                webViewsite.loadUrl("http://resultcase.adliran.ir/Login/Authenticate?returnUrl=ResultCase/CaseListForLawyer&systemName=ResultCaseService&loginType=3&isSelectNaturalPerson=false&isSelectLegalPerson=false&isSelectJudPerson=false&messageUrl=&loginTitle=%d8%b3%d8%a7%d9%85%d8%a7%d9%86%d9%87%20%d8%a7%d8%b7%d9%84%d8%a7%d8%b9%20%d8%b1%d8%b3%d8%a7%d9%86%db%8c%20%d9%be%d8%b1%d9%88%d9%86%d8%af%d9%87%20%d9%88%da%a9%d9%84%d8%a7");
            }





        }
        else {


            if (!DetectConnection.checkInternetConnection(this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                webViewsite = findViewById(R.id.Vokala_sana_site);
                CustomWebViewClient c = new  CustomWebViewClient();
                webViewsite.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                webViewsite.setWebViewClient(c);
                webViewsite.clearCache(true);
                webViewsite.clearHistory();
                activity = this;
                progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
                progDailog.setCancelable(false);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailog.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);

                webViewsite.getSettings().setJavaScriptEnabled(true);
                webViewsite.getSettings().setLoadWithOverviewMode(true);
                webViewsite.getSettings().setUseWideViewPort(true);
                webViewsite.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailog.show();
                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {


                        if (progDailog.isShowing()) {
                            progDailog.dismiss();
                        }
                    }
                });
                webViewsite.loadUrl("http://resultcase.adliran.ir/Login/Authenticate?returnUrl=ResultCase/CaseListForLawyer&systemName=ResultCaseService&loginType=3&isSelectNaturalPerson=false&isSelectLegalPerson=false&isSelectJudPerson=false&messageUrl=&loginTitle=%d8%b3%d8%a7%d9%85%d8%a7%d9%86%d9%87%20%d8%a7%d8%b7%d9%84%d8%a7%d8%b9%20%d8%b1%d8%b3%d8%a7%d9%86%db%8c%20%d9%be%d8%b1%d9%88%d9%86%d8%af%d9%87%20%d9%88%da%a9%d9%84%d8%a7");

            }
        }
    }
    private class CustomWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!DetectConnection.checkInternetConnection(Activity_sana_Vokala.this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            } else {
                view.loadUrl(url);
            }
            return true;
        }
    }
}

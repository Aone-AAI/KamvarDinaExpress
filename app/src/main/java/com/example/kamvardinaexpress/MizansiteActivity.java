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

public class MizansiteActivity extends AppCompatActivity {
    WebView webViewsitemizan;
    AppCompatActivity activitymizan;
    private ProgressDialog progDailogmizan;

    @Override
    public void onBackPressed() {

            if (webViewsitemizan.canGoBack()) {
                webViewsitemizan.goBack();
            } else {
                super.onBackPressed();
            }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mizansite);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
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

                webViewsitemizan = findViewById(R.id.mizan_site);
                CustomWebViewClientmizan c = new CustomWebViewClientmizan();
                webViewsitemizan.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                webViewsitemizan.setWebViewClient(c);
                webViewsitemizan.clearCache(true);
                webViewsitemizan.clearHistory();
                activitymizan = this;
                progDailogmizan = ProgressDialog.show(activitymizan, "Loading","Please wait...", true);
                progDailogmizan.setCancelable(true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogmizan.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);
                webViewsitemizan.getSettings().setJavaScriptEnabled(true);
                webViewsitemizan.getSettings().setLoadWithOverviewMode(true);
                webViewsitemizan.getSettings().setUseWideViewPort(true);
                webViewsitemizan.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogmizan.show();
                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailogmizan.isShowing()) {
                            progDailogmizan.dismiss();
                        }
                    }
                });

                webViewsitemizan.loadUrl("https://www.mizanonline.com/");
            }




        }
        else {


            if (!DetectConnection.checkInternetConnection(this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                finish();
            } else {

                webViewsitemizan = findViewById(R.id.mizan_site);
                CustomWebViewClientmizan c = new CustomWebViewClientmizan();
                webViewsitemizan.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                webViewsitemizan.setWebViewClient(c);
                webViewsitemizan.clearCache(true);
                webViewsitemizan.clearHistory();
                activitymizan = this;
                progDailogmizan = ProgressDialog.show(activitymizan, "Loading","Please wait...", true);
                progDailogmizan.setCancelable(true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogmizan.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);

                webViewsitemizan.getSettings().setJavaScriptEnabled(true);
                webViewsitemizan.getSettings().setLoadWithOverviewMode(true);
                webViewsitemizan.getSettings().setUseWideViewPort(true);
                webViewsitemizan.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogmizan.show();
                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailogmizan.isShowing()) {
                            progDailogmizan.dismiss();
                        }
                    }
                });

                webViewsitemizan.loadUrl("https://www.mizanonline.com/");
            }



        }



// Function to load all URLs in same webview

    }


    private class CustomWebViewClientmizan extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!DetectConnection.checkInternetConnection(MizansiteActivity.this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            } else {
                view.loadUrl(url);
            }
            return true;
        }
    }
}


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

public class ISNA_Activity extends AppCompatActivity {
    WebView webViewsiteisna;
    AppCompatActivity activityisna;
    private ProgressDialog progDailogisna;

    @Override
    public void onBackPressed() {
        if (webViewsiteisna.canGoBack()) {
            webViewsiteisna.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isna_);

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
                webViewsiteisna = findViewById(R.id.isna_site);
                CustomWebViewClientisna c = new CustomWebViewClientisna();
                webViewsiteisna.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                webViewsiteisna.setWebViewClient(c);
                webViewsiteisna.clearCache(true);
                webViewsiteisna.clearHistory();
                activityisna = this;
                progDailogisna = ProgressDialog.show(activityisna, "Loading", "Please wait...", true);
                progDailogisna.setCancelable(true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogisna.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);

                webViewsiteisna.getSettings().setJavaScriptEnabled(true);
                webViewsiteisna.getSettings().setLoadWithOverviewMode(true);
                webViewsiteisna.getSettings().setUseWideViewPort(true);
                webViewsiteisna.setWebViewClient(new WebViewClient() {

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogisna.show();
                        view.loadUrl(url);
                        return true;
                    }

                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailogisna.isShowing()) {
                            progDailogisna.dismiss();
                        }

                    }
                });

                webViewsiteisna.loadUrl("http://www.isna.ir");
            }



        }
        else {


            if (!DetectConnection.checkInternetConnection(this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                webViewsiteisna = findViewById(R.id.isna_site);
                CustomWebViewClientisna c = new CustomWebViewClientisna();
                webViewsiteisna.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                webViewsiteisna.setWebViewClient(c);
                webViewsiteisna.clearCache(true);
                webViewsiteisna.clearHistory();
                activityisna = this;
                progDailogisna = ProgressDialog.show(activityisna, "Loading", "Please wait...", true);
                progDailogisna.setCancelable(true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogisna.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);


                webViewsiteisna.getSettings().setJavaScriptEnabled(true);
                webViewsiteisna.getSettings().setLoadWithOverviewMode(true);
                webViewsiteisna.getSettings().setUseWideViewPort(true);
                webViewsiteisna.setWebViewClient(new WebViewClient() {

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogisna.show();
                        view.loadUrl(url);

                        return true;
                    }

                    @Override
                    public void onPageFinished(WebView view, final String url) {

                        if (progDailogisna.isShowing()) {
                            progDailogisna.dismiss();
                        }

                    }
                });

                webViewsiteisna.loadUrl("http://www.isna.ir");
            }

        }



// Function to load all URLs in same webview

    }


    private class CustomWebViewClientisna extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!DetectConnection.checkInternetConnection(ISNA_Activity.this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            } else {
                view.loadUrl(url);
            }
            return true;
        }
    }
}
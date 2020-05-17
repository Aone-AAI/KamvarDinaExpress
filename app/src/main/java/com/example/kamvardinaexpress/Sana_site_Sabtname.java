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

public class Sana_site_Sabtname extends AppCompatActivity {

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
        setContentView(R.layout.activity_sana_site__sabtname);

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
                webViewsite = findViewById(R.id.Sana_sabte_name);
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

                webViewsite.loadUrl("https://adliran.ir/Home/SelectLink/1");
            }





        }
        else {


            if (!DetectConnection.checkInternetConnection(this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                webViewsite = findViewById(R.id.Sana_sabte_name);
                CustomWebViewClient c = new CustomWebViewClient();
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
                webViewsite.loadUrl("https://adliran.ir/Home/SelectLink/1");
            }
        }

    }
    private class CustomWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!DetectConnection.checkInternetConnection(Sana_site_Sabtname.this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            } else {
                view.loadUrl(url);
            }
            return true;
        }
    }
}

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

public class Farse_Activity extends AppCompatActivity {
    WebView webViewsitefarse;
    AppCompatActivity activityfarse;
    private ProgressDialog progDailogfarse;


    @Override
    public void onBackPressed() {

            if (webViewsitefarse.canGoBack()) {
                webViewsitefarse.goBack();
            } else {
                super.onBackPressed();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farse_);

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
                webViewsitefarse = findViewById(R.id.farse_site);
                CustomWebViewClientfarse c = new CustomWebViewClientfarse();
                webViewsitefarse.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                webViewsitefarse.setWebViewClient(c);
                webViewsitefarse.clearCache(true);
                webViewsitefarse.clearHistory();
                activityfarse = this;
                progDailogfarse = ProgressDialog.show(activityfarse, "Loading","Please wait...", true);
                progDailogfarse.setCancelable(true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogfarse.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);


                webViewsitefarse.getSettings().setJavaScriptEnabled(true);
                webViewsitefarse.getSettings().setLoadWithOverviewMode(true);
                webViewsitefarse.getSettings().setUseWideViewPort(true);
                webViewsitefarse.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogfarse.show();
                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailogfarse.isShowing()) {
                            progDailogfarse.dismiss();
                        }
                    }
                });

                webViewsitefarse.loadUrl("http://www.farsnews.com");
            }



        }
        else {


            if (!DetectConnection.checkInternetConnection(this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                webViewsitefarse = findViewById(R.id.farse_site);
                CustomWebViewClientfarse c = new CustomWebViewClientfarse();
                webViewsitefarse.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                webViewsitefarse.setWebViewClient(c);
                webViewsitefarse.clearCache(true);
                webViewsitefarse.clearHistory();
                activityfarse = this;
                progDailogfarse = ProgressDialog.show(activityfarse, "Loading","Please wait...", true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogfarse.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);


                progDailogfarse.setCancelable(true);
                webViewsitefarse.getSettings().setJavaScriptEnabled(true);
                webViewsitefarse.getSettings().setLoadWithOverviewMode(true);
                webViewsitefarse.getSettings().setUseWideViewPort(true);
                webViewsitefarse.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogfarse.show();

                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailogfarse.isShowing()) {
                            progDailogfarse.dismiss();
                        }
                    }
                });

                webViewsitefarse.loadUrl("http://www.farsnews.com");
            }



        }




// Function to load all URLs in same webview

    }


    private class CustomWebViewClientfarse extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!DetectConnection.checkInternetConnection(Farse_Activity.this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            } else {
                view.loadUrl(url);
            }
            return true;
        }
    }
}

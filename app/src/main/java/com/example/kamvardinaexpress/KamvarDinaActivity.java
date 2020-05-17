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

public class KamvarDinaActivity extends AppCompatActivity {
    WebView webViewsitekamvardina;
    AppCompatActivity activitykamvardina;
    private ProgressDialog progDailogkamvardina;

    @Override
    public void onBackPressed() {

            if (webViewsitekamvardina.canGoBack()) {
                webViewsitekamvardina.goBack();
            } else {
                super.onBackPressed();
            }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamvar_dina);

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
                webViewsitekamvardina = findViewById(R.id.webViewKamvar);
                CustomWebViewClientkamvardina c = new CustomWebViewClientkamvardina();

                webViewsitekamvardina.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                webViewsitekamvardina.setWebViewClient(c);
                webViewsitekamvardina.clearCache(true);
                webViewsitekamvardina.clearHistory();
                activitykamvardina = this;
                progDailogkamvardina = ProgressDialog.show(activitykamvardina, "Loading","Please wait...", true);
                progDailogkamvardina.setCancelable(true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogkamvardina.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);

                webViewsitekamvardina.getSettings().setJavaScriptEnabled(true);
                webViewsitekamvardina.getSettings().setLoadWithOverviewMode(true);
                webViewsitekamvardina.getSettings().setUseWideViewPort(true);
                webViewsitekamvardina.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogkamvardina.show();
                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailogkamvardina.isShowing()) {
                            progDailogkamvardina.dismiss();
                        }
                    }
                });

                webViewsitekamvardina.loadUrl("http://www.kamvardina.ir/news");
            }
        }
        else {


            if (!DetectConnection.checkInternetConnection(this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                webViewsitekamvardina = findViewById(R.id.webViewKamvar);
                CustomWebViewClientkamvardina c = new CustomWebViewClientkamvardina();

                webViewsitekamvardina.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                webViewsitekamvardina.setWebViewClient(c);
                webViewsitekamvardina.clearCache(true);
                webViewsitekamvardina.clearHistory();
                activitykamvardina = this;
                progDailogkamvardina = ProgressDialog.show(activitykamvardina, "Loading","Please wait...", true);
                progDailogkamvardina.setCancelable(true);

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progDailogkamvardina.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);


                webViewsitekamvardina.getSettings().setJavaScriptEnabled(true);
                webViewsitekamvardina.getSettings().setLoadWithOverviewMode(true);
                webViewsitekamvardina.getSettings().setUseWideViewPort(true);
                webViewsitekamvardina.setWebViewClient(new WebViewClient(){

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        progDailogkamvardina.show();
                        view.loadUrl(url);

                        return true;
                    }
                    @Override
                    public void onPageFinished(WebView view, final String url) {
                        if (progDailogkamvardina.isShowing()) {
                            progDailogkamvardina.dismiss();
                        }
                    }
                });

                webViewsitekamvardina.loadUrl("http://www.kamvardina.ir/news");
            }
        }





// Function to load all URLs in same webview

    }


    private class CustomWebViewClientkamvardina extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!DetectConnection.checkInternetConnection(KamvarDinaActivity.this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            } else {
                view.loadUrl(url);
            }
            return true;
        }
    }
}




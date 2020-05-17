package com.example.kamvardinaexpress;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.TimerTask;




public class CheckConnection extends TimerTask {

    static  int version = -1 ;
    private Context context;
    public static Boolean inter = false;
    public CheckConnection(Context context){
        this.context = context;
    }

    public static class NetworkUtils {
        public static boolean isNetworkAvailable(Context context) {
            try {
                ConnectivityManager connectivityManager
                        = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }catch (Exception e){
                return false;
            }

        }
    }
    public void run() {
        if(NetworkUtils.isNetworkAvailable(context)){
           inter = true;
        }else {
            //DISCONNECTED
        }
    }
}

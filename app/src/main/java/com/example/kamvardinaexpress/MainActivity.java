package com.example.kamvardinaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;

import static com.example.kamvardinaexpress.CheckConnection.inter;

//for back to navigation view UNCONMMENT init , onNavigationItemSelected , onOptionsItemSelected , isValidDestination
public  class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener

    {


        DrawerLayout drawerLayout;
        NavigationView navigationView;

        CoordinatorLayout coordinatorLayout;

        Fragment fragment;


        private static String url = "http://kamvardina.ir/json.json";
        String VersionUpdate;


        private static final String TAG = "سلام فابربیس";

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        //getSupportActionBar().setElevation(0);


//        int positionOfMenuItem = 0; //or any other postion
//        MenuItem item = (MenuItem) drawerLayout.getDrawerTitle(positionOfMenuItem);
//        SpannableString s = new SpannableString();
//        s.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, s.length(), 0);
//        item.setTitle(s);


        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);


        coordinatorLayout = findViewById(R.id.coordinator_layout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // drawerLayout.openDrawer(GravityCompat.END);


        init();


//        name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "You have clicked tittle", Toast.LENGTH_LONG).show();
//            }
//        });


//        if (!DetectConnection.checkInternetConnection(this)) {
//
//
//        }else{
//            new VersionCheck().execute();
//        }

        Timer timer = new Timer();
        final int MILLISECONDS = 3000; //3 seconds
        timer.schedule(new CheckConnection(this), 0, MILLISECONDS);


        if (inter) {
            new VersionCheck().execute();
        }
//        if(CheckConnection.NetworkUtils.isNetworkAvailable(this)){
//            new VersionCheck().execute();
//        }else {
//            //DISCONNECTED
//        }

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
//To do//
                            return;
                        }

// Get the Instance ID token//
                        String token = task.getResult().getToken();
                        String msg = getString(R.string.fcm_token, token);
                        Log.d(TAG, msg);

                    }
                });


    }


        public class VersionCheck extends AsyncTask<Void, Void, Void> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();


            }

            @Override
            protected Void doInBackground(Void... arg0) {
                HttpHandler sh = new HttpHandler();


                String jsonStr = sh.makeServiceCall(url);

                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);
                        JSONArray version = jsonObj.getJSONArray("Version");
                        for (int i = 0; i < version.length(); i++) {

                            JSONObject v = version.getJSONObject(i);

                            VersionUpdate = v.getString("version");
                        }


                    } catch (final JSONException e) {
                        // Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        });

                    }
                } else {
                    //Log.e(TAG, "Couldn't get json from server.");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Couldn't get json from server. Check LogCat for possible errors!",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }


                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);


                String VersionName = BuildConfig.VERSION_NAME;


                if (VersionUpdate.equals(VersionName)) {

                    //Do Nothing
                } else {


                    CustomDialogClass cdd = new CustomDialogClass(MainActivity.this);
                    cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    cdd.show();


//                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setCancelable(false);
//                builder.setTitle("");
//                builder.setMessage("برای دریافت نسخه جدید برنامه کلیک کنید")


//                builder.setView(inflater.inflate(R.layout.customize_alertdialog, null))

//                builder.setView(R.layout.customize_alertdialog)
//
//                        .setNegativeButton("دانلود", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                final String appName = getPackageName();
//
//                                try {
//                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://kamvardina.ir/download")));
//                                } catch (android.content.ActivityNotFoundException anfe) {
//                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://kamvardina.ir/download")));
//                                }
//
//                                finish();
//
//                            }
//                        });
//                builder.setPositiveButton("بعدا", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//
//                    }
//                });
//
//                AlertDialog alert = builder.create();
//                alert.show();


                }


            }

        }

        @Override
        public void onBackPressed () {
        //super.onBackPressed();
//        if ( Navigation.findNavController(this,R.id.nav_host_fragment) ==
//                Navigation.findNavController(this,R.id.main_fragment)){
//            super.onBackPressed();
//        }
        if (Navigation.findNavController(this, R.id.nav_host_fragment).getCurrentDestination()
                .getId() == R.id.main_fragment) {
            super.onBackPressed();
        } else {

        }
    }

        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){


        switch (menuItem.getItemId()) {


            case R.id.login_fragment: {

                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.main, true)
                        .setEnterAnim(R.anim.side_in_right)
                        .setExitAnim(R.anim.nav_default_exit_anim)
                        .setPopEnterAnim(R.anim.side_in_right)
                        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
                        .build();
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.login_fragment
                        , null, navOptions);


            }
            break;

            case R.id.main_fragment: {

                if (isValidDestination(R.id.main_fragment)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.main_fragment);
                    NavOptions navOptionsMain = new NavOptions.Builder()
                            .setPopUpTo(R.id.main, true)
                            .setEnterAnim(R.anim.side_in_right)
                            .setExitAnim(R.anim.nav_default_exit_anim)
                            .setPopEnterAnim(R.anim.side_in_right)
                            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
                            .build();
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.main_fragment
                            , null, navOptionsMain);

                }

            }
            break;
            case R.id.about_us: {


                if (isValidDestination(R.id.about_us_fargment)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.about_us_fargment);
                    NavOptions navOptionsRigister = new NavOptions.Builder()
                            .setPopUpTo(R.id.main, true)
                            .setEnterAnim(R.anim.side_in_right)
                            .setExitAnim(R.anim.nav_default_exit_anim)
                            .setPopEnterAnim(R.anim.side_in_right)
                            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
                            .build();
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.about_us_fargment
                            , null, navOptionsRigister);

                }
                //  coordinatorLayout.setVisibility(View.INVISIBLE);
            }
            break;
            case R.id.sending_fargment: {
                if (isValidDestination(R.id.sending_message_fragment)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.sending_message_fragment);
                    NavOptions navOptionsRigister = new NavOptions.Builder()
                            .setPopUpTo(R.id.main, true)
                            .setEnterAnim(R.anim.side_in_right)
                            .setExitAnim(R.anim.nav_default_exit_anim)
                            .setPopEnterAnim(R.anim.side_in_right)
                            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
                            .build();
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.sending_message_fragment
                            , null, navOptionsRigister);

                }
            }
            break;


        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }

        private void init () {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);

    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){


        switch (item.getItemId()) {
            case android.R.id.home: {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                } else {
                    return false;
                }

            }
            default:
                return super.onOptionsItemSelected(item);
        }

    }

        private boolean isValidDestination ( int destination){
        return destination != Navigation.findNavController(this, R.id.nav_host_fragment).getCurrentDestination()
                .getId();
    }
        @Override
        public boolean onSupportNavigateUp () {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }


    
}

//Uri.parse("market://details?id=" + appName))) line 260
//Uri.parse("http://play.google.com/store/apps/details?id=" + appName))); line262
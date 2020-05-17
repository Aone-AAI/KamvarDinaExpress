package com.example.kamvardinaexpress;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class loginFragment extends Fragment implements View.OnClickListener {

    View rootView;



    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";
    private EditText etUsername;
    private EditText etPassword;
    public static String username;
    private String password;
    private ProgressDialog pDialog;
    String singleParsed = "";
    String data = "";
    private String login_url = "http://kamvardina.ir/login.php";



  //  private String login_url = "http://kamvardina.ir/api/user/login";
    private SessionHandler session;


    UserLocalStore userLocalStore;

    Button buttonLogin;

    TextInputEditText textInputEditTextPasswordLogin;
    TextInputEditText textInputEditTextUsernameLogin;
    Context context;
    Activity activity;

    private final String TAG_pass ="سلام عزیزم";

   @NonNull NavController navController ;

    Context mcontext;



    public loginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


     //   View view = inflater.inflate(R.layout.loginFragment, container, false);

        rootView = inflater.inflate(R.layout.login_fragment, container, false);

        initView();

        session = new SessionHandler(getActivity());
        userLocalStore = new UserLocalStore(getActivity());

        if(session.isLoggedIn()){
            loadDashboard();
        }




        return rootView;
        

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        buttonLogin.setOnClickListener(this);
    }

    private void initView(){
         textInputEditTextUsernameLogin = rootView.findViewById(R.id.username_login);

         textInputEditTextPasswordLogin = rootView.findViewById(R.id.password_login);

         buttonLogin = rootView.findViewById(R.id.button_login);







    }

    /**
     * Launch Dashboard Activity on Successful Login
     */
    private void loadDashboard() {

        navController.navigate(R.id.action_login_fragment_to_dashboard2);
        NavOptions navOptionsRigister = new NavOptions.Builder()
                .setPopUpTo(R.id.main,true)
                .setEnterAnim(R.anim.side_in_right)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.side_in_right)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
                .build();
        Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.dashboard2
                ,null,navOptionsRigister);

    }

    /**
     * Display Progress bar while Logging in
     */

    private void displayLoader() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Logging In.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    private void login() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(KEY_USERNAME, username);
            request.put(KEY_PASSWORD, password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, login_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();

                        try {


                            for(int i = 0 ; i<response.length() ; i++){

                                singleParsed =  "Status:" + response.get("status")+"\n"+
                                        "Message:" + response.get("messege")+"\n";

                                StringBuilder sb = new StringBuilder();
                                sb.append("Status:" + response.get("status"));
                                sb.append("\\n");
                                sb.append("Message:" + response.get("messege"));

                                String[] lines = sb.toString().split("\\n");
                                for(String s: lines){
                                    //System.out.println("Content = " + s);
                                   // System.out.println("Length = " + s.length());
                                    int respo = 0;
                                   // if (respo == 0 && s == "status = 0"){


                                        loadDashboard();
                                        user user = new user(null);
                                        userLocalStore.storeUserData(user);
                                        respo = 1;

                                  //  }else{
                                 //       Toast.makeText(getActivity(),"ورود ناموفق لطفا دوباره تلاش کنید", Toast.LENGTH_SHORT).show();

                               //     }
                                }

                            }



                    }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
//                        Toast.makeText(getActivity(),
//                                error.getMessage(), Toast.LENGTH_SHORT).show();

                        Toast toast= Toast.makeText(getActivity(),"Hello Javatpoint",Toast. LENGTH_SHORT);
                        toast. setMargin(50,50);
                        toast. show();

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsArrayRequest);
    }

    /**
     * Validates inputs and shows error if any
     * @return
     */
    private boolean validateInputs() {
        if(KEY_EMPTY.equals(username)){
            textInputEditTextUsernameLogin.setError("Username cannot be empty");
            textInputEditTextUsernameLogin.requestFocus();
            return false;
        }
        if(KEY_EMPTY.equals(password)){
            textInputEditTextPasswordLogin.setError("Password cannot be empty");
            textInputEditTextPasswordLogin.requestFocus();
            return false;
        }
        return true;
    }

    private boolean isValidDestination(int destination){
        return destination != Navigation.findNavController(getActivity() , R.id.nav_host_fragment).getCurrentDestination()
                .getId();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_login:

                username = textInputEditTextUsernameLogin.getText().toString().toLowerCase().trim();
                password = textInputEditTextPasswordLogin.getText().toString().trim();

                if (validateInputs()) {
                    login();

                    Toast.makeText(getActivity(), "شما عضو باشگاه موکلان کامور دینا نیستید", Toast.LENGTH_LONG).show();

                //    Log.d(TAG_pass,username);
                //    Log.d(TAG_pass,password);
//
//                    navController.navigate(R.id.action_login_fragment_to_dashboard2);
////                Toast.makeText(context,"hello",Toast.LENGTH_LONG).show();
//                    NavOptions navOptionsRigister = new NavOptions.Builder()
//                            .setPopUpTo(R.id.main,true)
//                            .setEnterAnim(R.anim.side_in_right)
//                            .setExitAnim(R.anim.nav_default_exit_anim)
//                            .setPopEnterAnim(R.anim.side_in_right)
//                            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
//                            .build();
//                    Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.dashboard2
//                            ,null,navOptionsRigister);
//                navController.navigate(R.id.action_login_fragment_to_dashboard2,null,navOptionsRigister);

                }



                break;

        }

    }
}

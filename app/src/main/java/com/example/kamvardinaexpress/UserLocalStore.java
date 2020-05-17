package com.example.kamvardinaexpress;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.kamvardinaexpress.user;

public class UserLocalStore {
    public static final String SP_NAME = "userdetail";

    SharedPreferences userLocalDatabse;

    public UserLocalStore(Context context){
        userLocalDatabse = context.getSharedPreferences(SP_NAME,0);
    }
    public void storeUserData(user user){
        SharedPreferences.Editor spEditor = userLocalDatabse.edit();
        spEditor.putString("username",user.getUsername());
        spEditor.commit();
    }
    public user getLoggedInUser(){
        String username = userLocalDatabse.getString("username","");
        user storedUser = new user(username);
        return storedUser;

    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabse.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }
    public boolean getUserLoggedIn(){
        if(userLocalDatabse.getBoolean("loggedIn",false) == true){
            return true;
        }else {
            return false;
        }
    }
    public void ClearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabse.edit();
        spEditor.clear();
        spEditor.commit();
    }
}

package com.example.kamvardinaexpress;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Dashboard extends Fragment {

    View rootView;
    private final String TAG = "داشبورد";

    public Dashboard() {
        // Required empty public constructor


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       Log.d("TAG","سلام kok");

       rootView = inflater.inflate(R.layout.fragment_dashboard,container,false);

       initView();

        return rootView;


    }

    private void initView(){

        TextView textView = rootView.findViewById(R.id.textView_dashborad);

    }


}

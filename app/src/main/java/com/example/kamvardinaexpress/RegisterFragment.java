package com.example.kamvardinaexpress;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    View rootView;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_register_fragment, container, false);
        initView();
        return rootView;
    }

    private void initView (){

        TextInputEditText textInputEditTextUsername = rootView.findViewById(R.id.username);

        TextInputEditText textInputEditTextPassword = rootView.findViewById(R.id.password);

        TextInputEditText textInputEditTextPasswordConfig = rootView.findViewById(R.id.passwordConfirm);


        Button button = rootView.findViewById(R.id.button);


    }


}

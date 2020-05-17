package com.example.kamvardinaexpress;


import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class sending_message_fragment extends Fragment {

    View Rootview;
    Button sendingTextErtebatBama;
    private static final String KEY_EMPTY = "";
    MultiAutoCompleteTextView textForSending;

    String assembledString = "";

    final String TAG = "SALAM MULTIPLE";




    public sending_message_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Rootview = inflater.inflate(R.layout.fragment_sending_message_fragment, container, false);

        init();

        return Rootview;
    }

    private void init(){

        final EditText your_name        = (EditText) Rootview.findViewById(R.id.your_name);
        final EditText your_email       = (EditText) Rootview.findViewById(R.id.your_email);
        final EditText your_subject     = (EditText) Rootview.findViewById(R.id.your_subject);
        final EditText your_message     = (EditText) Rootview.findViewById(R.id.your_message);



        Button email = (Button) Rootview.findViewById(R.id.post_message);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name      = your_name.getText().toString();
                String email     = your_email.getText().toString();
                String subject   = your_subject.getText().toString();
                String message   = your_message.getText().toString();
                if (TextUtils.isEmpty(name)){
                    your_name.setError("Enter Your Name");
                    your_name.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    your_email.setError("Invalid Email");
                    return;
                }

                if (TextUtils.isEmpty(subject)){
                    your_subject.setError("Enter Your Subject");
                    your_subject.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)){
                    your_message.setError("Enter Your Message");
                    your_message.requestFocus();
                    return;
                }

                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

                /* Fill it with Data */
                sendEmail.setType("plain/text");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"info@kamvardina.ir"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:"+name+'\n'+"Email ID:"+email+'\n'+"Message:"+'\n'+message);

                /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Send mail..."));


            }
        });



    }
    private boolean validateInputs () {
        if (KEY_EMPTY.equals(textForSending)) {
            textForSending.setError("متن خود را بنویسید");
            textForSending.requestFocus();
            return false;
        }
        else return true;
    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

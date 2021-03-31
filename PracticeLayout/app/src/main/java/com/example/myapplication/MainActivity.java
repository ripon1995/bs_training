package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText etPassword;
    EditText etRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPassword=findViewById(R.id.etPassword);
        etRePassword=findViewById(R.id.etRePassword);
    }

    private int passwordValidityCheck(String str) {
        int errorCode=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='a'&&str.charAt(i)<='z')
            {
                errorCode+=20;
                break;
            }
        }
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='0' && str.charAt(i)<='9')
            {
                errorCode+=30;
                break;
            }
        }
        return errorCode;
    }

    void checkPass(String str)
    {
        if(str.length()<8)
        {
            TextInputLayout textInputLayout=findViewById(R.id.filledTextFieldPassword);
            textInputLayout.setError("Minimum 8 char");
        }
        else
        {
            if(passwordValidityCheck(str)==20)
            {
                TextInputLayout textInputLayout=findViewById(R.id.filledTextFieldPassword);
                textInputLayout.setError("Number required");
            }
            else if(passwordValidityCheck(str)==30)
            {
                TextInputLayout textInputLayout=findViewById(R.id.filledTextFieldPassword);
                textInputLayout.setError("Char required");
            }
            else if(passwordValidityCheck(str)==50)
            {
                TextInputLayout textInputLayout=findViewById(R.id.filledTextFieldPassword);
                textInputLayout.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);
                textInputLayout.setErrorEnabled(false);
            }
        }

    }

    public void submit(View view) {
        String str=etPassword.getText().toString();
        checkPass(str);
        String strRePass=etRePassword.getText().toString();
        checkRePass(str, strRePass);
    }

    private void checkRePass(String str, String strRePass) {
        if(!str.matches(strRePass))
        {
            TextInputLayout textInputLayout=findViewById(R.id.filledTextFieldRePassword);
            textInputLayout.setError("Password did not matched");
        }
        else
        {
            TextInputLayout textInputLayout=findViewById(R.id.filledTextFieldRePassword);
            textInputLayout.setErrorEnabled(false);
        }
    }
}
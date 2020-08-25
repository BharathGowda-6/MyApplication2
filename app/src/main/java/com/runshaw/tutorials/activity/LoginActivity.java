package com.runshaw.tutorials.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.runshaw.tutorials.R;
import com.runshaw.tutorials.data.SharedPref;

public class LoginActivity extends AppCompatActivity {

    EditText etUserID;
    EditText etPassword;
    SharedPref sharedPref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_linear);

        etUserID=findViewById(R.id.etUserID);
        etPassword=findViewById(R.id.etPassword);
        sharedPref=new SharedPref(this);

    }

    public void goToRegister(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public void submit(View view) {
        String userID=etUserID.getText().toString();
        String password=etPassword.getText().toString();
        if(userID.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"Both feilds are mandotory!!",Toast.LENGTH_LONG).show();
        }
        else {
            String sharedPrefUserID=sharedPref.getUserID();
            String sharedPrefUserPassword=sharedPref.getUserPassword();
            String shardPrefUserName=sharedPref.getUserName();

            if (userID.equals(sharedPrefUserID) && password.equals(sharedPrefUserPassword)){
                Toast.makeText(this,"Login Successfull!!Welcome "+shardPrefUserName,Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this,"Incorrect userID or password!!",Toast.LENGTH_LONG).show();

            }
        }
    }
}
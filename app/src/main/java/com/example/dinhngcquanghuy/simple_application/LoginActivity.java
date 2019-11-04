package com.example.dinhngcquanghuy.simple_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private String email = "admin";
    private String password = "123456789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText input_email = (EditText)findViewById(R.id.input_email);
        EditText input_password = (EditText)findViewById(R.id.input_password);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText input_email = (EditText)findViewById(R.id.input_email);
        EditText input_password = (EditText)findViewById(R.id.input_password);
        String email_input = input_email.getText().toString();
        String password_input = input_password.getText().toString();

        if(email_input.equals(email) && password_input.equals(password)) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
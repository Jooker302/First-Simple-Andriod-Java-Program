package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotosignin(View v){
        Intent i = new Intent(this, Signin.class);
        startActivity(i);

    }

    public void gotoregister(View v){
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }
}
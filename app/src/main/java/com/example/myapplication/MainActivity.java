package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        finishAffinity();
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            finishAffinity();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
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
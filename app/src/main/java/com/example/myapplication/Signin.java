package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void signin(View v){
        EditText name = findViewById(R.id.fieldname);
        EditText password = findViewById(R.id.fieldpassword);
//        Toast.makeText(this,email.getText().toString(),Toast.LENGTH_LONG).show();
        DatabaseHelper db = new DatabaseHelper(Signin.this);
        boolean check = db.checksignin(name.getText().toString(),password.getText().toString());

        if(check == true){
            Toast.makeText(this,"Login In Successful",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Incorrect Email or Password",Toast.LENGTH_LONG).show();
        }

    }
}
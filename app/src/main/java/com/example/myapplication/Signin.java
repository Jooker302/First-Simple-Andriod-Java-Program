package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    public void signin(View v) {
        EditText name = findViewById(R.id.fieldemail);
        EditText password = findViewById(R.id.fieldpassword);
//        Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();
        if (name.getText().toString().matches("admin@mail.com") && password.getText().toString().matches("admin")) {
            Toast.makeText(this, "Admin", Toast.LENGTH_SHORT).show();
            Intent admini = new Intent(this,AdminHome.class);
            startActivity(admini);
        } else {
//        Toast.makeText(this,email.getText().toString(),Toast.LENGTH_LONG).show();
            DatabaseHelper db = new DatabaseHelper(Signin.this);
            boolean check = db.checksignin(name.getText().toString(), password.getText().toString());

            if (check == true) {
                Toast.makeText(this, "Login In Successful", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, Home.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "Incorrect Email or Password", Toast.LENGTH_LONG).show();
            }

        }
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View v){

        EditText name = findViewById(R.id.feildname);
        EditText email = findViewById(R.id.fieldemail);
        EditText password = findViewById(R.id.fieldpassword);

        if(name.getText().toString().matches("") || email.getText().toString().matches("") || password.getText().toString().matches("")){
            Toast.makeText(this,"Empty Fields",Toast.LENGTH_SHORT).show();
        }else {
            if(email.getText().toString().matches("admin@mail.com")){
                Toast.makeText(this, "Email can't be taken", Toast.LENGTH_SHORT).show();
            }else {
                try {
                    UserClass user = new UserClass(name.getText().toString(), email.getText().toString(), password.getText().toString());
//                  Toast.makeText(this,user.toString(),Toast.LENGTH_LONG).show();
                    DatabaseHelper db = new DatabaseHelper(Register.this);
                    boolean check = db.addone(user);
                    if (check == true) {
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(this, Signin.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(this, "Error Creating User", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "Error Creating User", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
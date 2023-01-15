package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

        try {
            UserClass user = new UserClass(name.getText().toString(),email.getText().toString(),password.getText().toString());
//            Toast.makeText(this,user.toString(),Toast.LENGTH_LONG).show();
            DatabaseHelper db = new DatabaseHelper(Register.this);
            boolean check = db.addone(user);
            if(check == true) {
                Toast.makeText(this, "Success = " + check, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Error Creating User",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this,"Error Creating User",Toast.LENGTH_LONG).show();
        }

    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreatePost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
    }

    public void createpost(View v){
        EditText title = findViewById(R.id.posttitlebutton);
        EditText price = findViewById(R.id.postprice);
        EditText contact = findViewById(R.id.postcontact);
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void createpost(View v){
        Intent i = new Intent(this, CreatePost.class);
        startActivity(i);
    }

    public void viewpost(View v){
//        Toast.makeText(this,"allposts".toString(),Toast.LENGTH_LONG).show();
//        DatabaseHelper db = new DatabaseHelper(Home.this);
//        List<PostClass> allposts = db.posts();
//        Toast.makeText(this,allposts.toString(),Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,PostView.class);
        startActivity(i);
    }

}
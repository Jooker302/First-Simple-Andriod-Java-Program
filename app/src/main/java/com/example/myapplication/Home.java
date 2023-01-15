package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class Home extends AppCompatActivity {

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void createpost(View v){
        Intent i = new Intent(this, CreatePost.class);
        startActivity(i);
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
//    }


    public void viewpost(View v){
//        Toast.makeText(this,"allposts".toString(),Toast.LENGTH_LONG).show();
//        DatabaseHelper db = new DatabaseHelper(Home.this);
//        List<PostClass> allposts = db.posts();
//        Toast.makeText(this,allposts.toString(),Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,PostView.class);
        startActivity(i);
    }

    public void logout(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
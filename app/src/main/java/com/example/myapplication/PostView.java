package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PostView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);
        allposts();
    }

    public void allposts(){
        ListView listposts = findViewById(R.id.listpost);
        DatabaseHelper db = new DatabaseHelper(PostView.this);
        List<PostClass> allposts = db.posts();
        ArrayAdapter postarrayadapter = new ArrayAdapter<PostClass>(PostView.this, android.R.layout.simple_list_item_1,allposts);
        listposts.setAdapter(postarrayadapter);
    }
}
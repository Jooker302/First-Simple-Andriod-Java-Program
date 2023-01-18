package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class AdminView extends AppCompatActivity {

    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        list = (ListView) findViewById(R.id.listpost);
        allposts();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PostClass post = (PostClass) adapterView.getItemAtPosition(i);
                DatabaseHelper db = new DatabaseHelper(AdminView.this);
                boolean check = db.deletepost(post);
                if(check == true){
                    Toast.makeText(AdminView.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
//                    allposts();

                    finish();
                    startActivity(getIntent());

//                    Intent re = new Intent(this , AdminHome.class);
                }else{
                    Toast.makeText(AdminView.this, "Error During Delete...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void allposts(){
//        ListView listposts = findViewById(R.id.listpost);
//        listposts = findViewById(R.id.listpost);
        DatabaseHelper db = new DatabaseHelper(AdminView.this);
        List<PostClass> allposts = db.posts();
//        ArrayAdapter postarrayadapter = new ArrayAdapter<PostClass>(PostView.this, android.R.layout.simple_list_item_1,allposts);
        ArrayAdapter postarrayadapter = new ArrayAdapter<PostClass>(AdminView.this, android.R.layout.simple_expandable_list_item_1,allposts);
        list.setAdapter(postarrayadapter);
    }

//    list
//    listposts
}
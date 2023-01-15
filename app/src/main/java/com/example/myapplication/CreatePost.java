package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        if(title.getText().toString().matches("") || price.getText().toString().matches("") || contact.getText().toString().matches("")){
            Toast.makeText(this,"Empty Fields",Toast.LENGTH_LONG).show();
        }else{

            try {
                PostClass post = new PostClass(title.getText().toString(),price.getText().toString(),contact.getText().toString());
//              Toast.makeText(this,post.toString(),Toast.LENGTH_LONG).show();
                DatabaseHelper db = new DatabaseHelper(CreatePost.this);
                boolean check = db.createonepost(post);
                if(check == true){
                    Toast.makeText(this,"Post Created",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Issue in Creating Post...",Toast.LENGTH_LONG).show();
                }

            }catch (Exception e){
                Toast.makeText(this,"Error Creating Post...",Toast.LENGTH_LONG).show();
            }
        }
    }
}
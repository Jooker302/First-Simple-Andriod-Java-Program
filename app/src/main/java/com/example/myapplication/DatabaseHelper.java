package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String USERS = "Users";
    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String POSTSTABLE = "POSTS";
    public static final String TITLEPOST = "title";
    public static final String PRICEPOST = "price";
    public static final String CONTACTPOST = "contact";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CreateStatement = "CREATE TABLE " + USERS + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + EMAIL + " TEXT, " + PASSWORD + " TEXT)";

        String CreatePostTable = "CREATE TABLE " + POSTSTABLE + " (" + ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLEPOST + " TEXT, " + PRICEPOST + " TEXT, " + CONTACTPOST + " TEXT)";


        sqLiteDatabase.execSQL(CreateStatement);
        sqLiteDatabase.execSQL(CreatePostTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addone(UserClass newUser){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME, newUser.getName());
        cv.put(EMAIL,newUser.getEmail());
        cv.put(PASSWORD,newUser.getPassword());

        long check = db.insert(USERS,null,cv);

        if(check == -1){
            return false;
        }else {
            return true;
        }

//        return true;
    }

    public boolean checksignin(String name, String password){

//        String query = "SELECT * FROM " + USERS + " WHERE " + EMAIL + " = " + email + " AND WHERE " + PASSWORD + " = " + password;
        String query = "SELECT * FROM " + USERS + " WHERE " + NAME + " = '" + name + "' AND " + PASSWORD + " = '" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery(query,null);

        if(result.moveToFirst()){
            result.close();
            db.close();
            return true;
        }else{
            result.close();
            db.close();
            return false;
        }

//        return false;
    }

    public boolean createonepost(PostClass post){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TITLEPOST,post.getTitle());
        cv.put(PRICEPOST,post.getPrice());
        cv.put(CONTACTPOST,post.getContact());

        long check = db.insert(POSTSTABLE,null,cv);

        if(check == -1){
            return false;
        }else{
            return true;
        }
    }

    public List<PostClass> posts(){
        List<PostClass> allposts = new ArrayList<>();

        String getpostquery = "SELECT * FROM " + POSTSTABLE ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery(getpostquery,null);

        if (result.moveToFirst()){

            do {
                String title = result.getString(1);
                String price = result.getString(2);
                String contact = result.getString(3);

                PostClass post = new PostClass(title,price,contact);
                allposts.add(post);

            } while(result.moveToNext());

        }else{


        }

        result.close();
        db.close();

        return allposts;
    }
}

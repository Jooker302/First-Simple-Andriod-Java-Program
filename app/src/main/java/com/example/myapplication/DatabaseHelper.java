package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String USERS = "Users";
    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CreateStatement = "CREATE TABLE " + USERS + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + EMAIL + " TEXT, " + PASSWORD + " TEXT)";

        sqLiteDatabase.execSQL(CreateStatement);

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
            return true;
        }else{
            return false;
        }

//        return false;
    }
}

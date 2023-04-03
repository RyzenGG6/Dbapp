package com.example.task;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname = "register.db";

    public database(@Nullable Context context) {
        super(context, dbname, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        String q = "create table users (id integer primary key autoincrement, name text, Email text,phonenumber text,date text)";
        sqliteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, int i, int i1) {

    }
    public boolean insert_data(String s, String name, String email, String phonenumber, String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name", name);
        c.put("Email" ,email);
        c.put("phonenumber", phonenumber);
        c.put("dob", date);
        long r=db.insert("users", null, c);
        if (r==-1) return false;
        else
            return true;
    }
    public boolean updateData(String oldName, String newName, String oldEmail, String newEmail, String oldPhone, String newPhone, String oldStatus, String newStatus, String oldDob, String newDob) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor= database.rawQuery( "select * from users where name=?", new String[]{oldName});
        ContentValues contentValues = new ContentValues();
        if (cursor.getCount() > 0) {
            contentValues.put("name", newName);
            contentValues.put("Email", newEmail);
            contentValues.put("phonenumber", newPhone);
            contentValues.put("dob", newDob);
            long r= database.update ( "users", contentValues,"name=?", new String[]{oldName});
            if (r == -1) return false;
            else
                return true;
        }
        else
            return false;
    }
    public boolean deleteData(String name) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from users where name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long r = database.delete("users", "name=?", new String[]{name});
            if (r == -1) return false;
            else return true;
        } else {
            return false;
        }
    }

    public Cursor getinfo() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users ", null);
        return cursor;
    }
}
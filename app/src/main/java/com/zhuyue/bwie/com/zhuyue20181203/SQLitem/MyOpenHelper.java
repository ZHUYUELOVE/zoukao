package com.zhuyue.bwie.com.zhuyue20181203.SQLitem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper  extends SQLiteOpenHelper {
    public MyOpenHelper( Context context) {
        super(context,"z.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table zhu(id integr primary key autoincrement,name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

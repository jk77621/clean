package com.example.clean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public MyDBHelper(Context context, String dbName){
        //나의 데이터베이스를 생성한것이다. 기존에 내용이 있으면
        // 다시 만들지 않는다.
        super(context, dbName, null, 1);
        this.context = context;
    }

    //테이블을 생성한다.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table myTBL(nickname char(20) primary key, picture char(50), name char(20), gender" +
                " char(20), age char(20));");
        sqLiteDatabase.execSQL("create table toDoListTBL(image BLOB, spaceName char, toDoName char, date char, time char," +
                " mon char, tus char, wen char, tur char, fri char, sat char, sun char, alarm integer, clear integer);");
    }

    //테이블을 삭제한다.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists myTBL;");
        sqLiteDatabase.execSQL("drop table if exists toDoListTBL;");

        onCreate(sqLiteDatabase);
    }

}
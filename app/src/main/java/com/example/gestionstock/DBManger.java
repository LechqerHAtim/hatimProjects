package com.example.gestionstock;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManger extends SQLiteOpenHelper {
    private static final String dbname="stock.db";
    public DBManger( Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table Article (id integer  primary key autoincrement ,name text,date text,qte text)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Article");

        onCreate(sqLiteDatabase);

    }
    public String  addRecord(String p1, String p2, String p3){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",p1);
        cv.put("date",p1);
        cv.put("qte",p1);

    long rs= db.insert("Article",null,cv);

    if(rs==-1) return "Faild";
    else
        return"Success";

    }


}

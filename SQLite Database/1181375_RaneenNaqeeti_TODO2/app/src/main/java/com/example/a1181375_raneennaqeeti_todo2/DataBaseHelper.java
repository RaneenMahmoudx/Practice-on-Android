package com.example.a1181375_raneennaqeeti_todo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE BOAT(ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT, COLOR TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE SAILOR(ID INTEGER PRIMARY KEY AUTOINCREMENT ,BOATID INTEGER,NAME TEXT, NATIONALITY TEXT,FOREIGN KEY(BOATID) REFERENCES BOAT(ID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void insertBoat(boat boat) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", boat.getmName());
        contentValues.put("COLOR", boat.getmColor());

        sqLiteDatabase.insert("BOAT", null, contentValues);
    }

    public Cursor getAllBoats() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM BOAT", null);
    }

    public void insertSailor(sailor sailor) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("BOATID", sailor.getmBoatId());
        contentValues.put("NAME", sailor.getmName());
        contentValues.put("NATIONALITY", sailor.getmNationality());

        sqLiteDatabase.insert("SAILOR", null, contentValues);
    }


    public Cursor getAllSailors() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM SAILOR", null);
    }

    public Cursor getAllSailorsNumbers() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT SUM(CASE WHEN NATIONALITY = 'Palestinian' THEN 1 ELSE 0 END) AS Palestinian, SUM(CASE WHEN NATIONALITY = 'Jordanian' THEN 1 ELSE 0 END) AS Jordanian,SUM(CASE WHEN NATIONALITY = 'Qatari' THEN 1 ELSE 0 END) AS Qatari FROM SAILOR", null);
    }

    public Cursor getRedBoatsName() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT NAME FROM BOAT WHERE COLOR='Red'", null);
    }

    public Cursor getPalestiniansRed() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT S.NAME FROM SAILOR as S  JOIN BOAT as B ON S.BOATID = B.ID WHERE S.NATIONALITY='Palestinian' AND B.COLOR='Red'", null);    }



}


package com.example.masroufi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static com.example.masroufi.sommemasroufi.somme;
import java.util.ArrayList;

public class DBadapter extends SQLiteOpenHelper {
 public DBadapter (Context context){

     super(context,"masroufi",null,1);
 }
 public void onCreate(SQLiteDatabase db)
 {
     String createTable = "CREATE TABLE masroufi(id integer primary key ,thing text , date text ,cost int )";
     db.execSQL(createTable);
 }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP Table  IF EXISTS masrouf;";
        db.execSQL(deleteTable);
        onCreate(db);
    }

    public  void  addmasrouf (masrouf newmasrouf){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("thing", newmasrouf.getThing());
        contentValues.put("date",newmasrouf.getDate());
        contentValues.put("cost",newmasrouf.getCost());
        db.insert("masroufi",null,contentValues) ;
     }

    public ArrayList<masrouf> affichermasrouf() {
        SQLiteDatabase db = getReadableDatabase();
        String selectall = "select * from masroufi";
        Cursor cursor = db.rawQuery(selectall,null);
        ArrayList<masrouf> masarif = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                masrouf newmasrouf = new masrouf();
                newmasrouf.setThing(cursor.getString(1));
                newmasrouf.setDate(cursor.getString(2));
                newmasrouf.setCost(cursor.getInt(3));
                masarif.add(newmasrouf);
            }while(cursor.moveToNext());
        }
        return masarif;

    }

    public int total()
    {
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM masroufi";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<masrouf> masarif=new ArrayList<>();
        int sum=0;
        if (cursor.moveToFirst()){
            do{
                sum+=cursor.getInt(3);
            }
            while(cursor.moveToNext());
        }

        return sum ;}

    public void removemasrouf(String thing){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("masroufi","thing='"+thing+"'",null);}

}

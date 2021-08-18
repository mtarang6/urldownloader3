package com.tara.basicregistrartion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "testing.db";

    public static final String ID = "_id";
    public static final String COL_1 = "name";
    public static final String Col_2 = "age";
   public static final String Ankur = "hh";

   public SqliteHelper(Context context){
       super(context,DATABASE_NAME,null,1);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Ankur+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_1+" VARCHAR(50), "+Col_2+" VARCHAR(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+Ankur);
       onCreate(db);
    }
    public boolean insertData(String name,String age){
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(Col_2,age);
        long result = sqLiteDatabase.insert(Ankur,null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
   }
   public Cursor getName(){
       SQLiteDatabase liteDatabase = this.getWritableDatabase();
       Cursor res = liteDatabase.rawQuery("select " +COL_1+" from "+Ankur,null);
       return res;
   }
}

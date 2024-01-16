package com.example.insertsqlnext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper{
        public static final String DBNAME="mydb";
        public static final String TBLNAME="mytable";
        public static final String ID="id";
        public static final String NAME="username";
        public static final String Address="address";
        public static final int VERSION=1;

        public DBHelper(@Nullable Context context) {
            super(context, DBNAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


//        String sql="create table "+TBLNAME+"("+ID+" integer primary key autoincrement, "+NAME+" text, "+Address+" text)";
              String s1= "create table " + TBLNAME;
              String s2= "(" + ID + " integer primary key autoincrement,";
              String s3=NAME +" text,";
              String s4=Address +" text)";
              String sql=s1+s2+s3+s4;
              db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
  public void dataInsert(User user)
    {
                SQLiteDatabase db=this.getWritableDatabase();
                ContentValues cv=new ContentValues();
                cv.put(NAME,user.getName());
                cv.put(Address,user.getAddress());
                db.insert(TBLNAME,ID,cv);
                db.close();

    }
    public List<User>show()
    {
        ArrayList<User>arrayList=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String column[]={ID,NAME,Address};
        Cursor c=db.query(TBLNAME,column,null,null,null,null,null);
        while (c.moveToNext())
        {
             int id=c.getInt(0);
             String name=c.getString(1);
             String address=c.getString(2);
             User user=new User();
             user.setId(id);
             user.setName(name);
             user.setAddress(address);
             arrayList.add(user);
        }
        return arrayList;
    }
   public void Updatedate(User user)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,user.getName());
        cv.put(Address,user.getAddress());
        String where=ID+"="+user.getId();
        db.update(TBLNAME,cv,where,null);
        db.close();

    }
    public void deletedata(int id)
    {
        SQLiteDatabase db=getWritableDatabase();
        String where=ID+"="+id;
        db.delete(TBLNAME,null,null);
        db.close();
    }


}

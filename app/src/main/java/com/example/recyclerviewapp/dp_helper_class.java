package com.example.recyclerviewapp;

//import android.app.IntentService;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dp_helper_class extends SQLiteOpenHelper {
    private static final String dbName="StudentDatabase";
    private static final int database_version=1;
    //private static final String createdb="create table students ";

    public dp_helper_class(@Nullable Context context) {
        super(context, dbName, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("create table students (id text primary key, name text,age integer,class text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("drop table if exists students");
    onCreate(sqLiteDatabase);
    }
    public void insertData(String id_,String name_,int age_,String class_){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id", id_);
        contentValues.put("name",name_);
        contentValues.put("age",age_);
        contentValues.put("class",class_);
        //db.execSQL("insert into students (id,name,age,class) values ('"+id_+"','"+name_+"','"+age_+"','"+class_+"')");
        db.insert("students",null,contentValues);

    }
    public ArrayList<Students_data_model> getAllData(String clause){
        SQLiteDatabase db=getReadableDatabase();
        db=getReadableDatabase();
        Cursor c = db.rawQuery("select * from students"+clause,null);
        ArrayList<Students_data_model> list=new ArrayList<Students_data_model>();
        while (c.moveToNext()){
            Students_data_model st=new Students_data_model();
            st.setId(c.getString(0));
            st.setName(c.getString(1));
            st.setAge(Integer.parseInt(c.getString(2)));
            st.setClass_(c.getString(3));
            list.add(st);

        }

        return list;
    }

        public long getTaskCount() {
            SQLiteDatabase db=getReadableDatabase();
            db=getReadableDatabase();
            return DatabaseUtils.queryNumEntries(db, "students");
        }

}

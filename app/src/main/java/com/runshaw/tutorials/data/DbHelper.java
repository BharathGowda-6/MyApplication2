package com.runshaw.tutorials.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.runshaw.tutorials.NotesModel;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="todo_db" ;
    private static final int DB_VERSION =1 ;
    private  static  final String TABLE_TODO="table_todo";
    //coloumns
    private  static final String COLUMN_NOTE_ID="note_id";
    private  static final String COLUMN_TITLE="title";
    private  static final String COLUMN_DESC="description";
    private  static final String COLUMN_TIME="time";
    private  static final String COLUMN_DATE="date";
    //create table tablename(note_id integer auto_increment primary key,title text,desc text,date text,time text);
    private static final String CREATE_TABLE_TODO = "CREATE TABLE "+TABLE_TODO+"("+
            COLUMN_NOTE_ID+"INTEGER PRIMARY KEY NOT NULL ,"+
            COLUMN_TITLE+" TEXT,"
            +COLUMN_DESC+"TEXT,"
            +COLUMN_DATE+"TEXT,"
            +COLUMN_TIME+"TEXT)";
    private static final String TAG = "DbHelper";

    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TODO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_TODO);
        onCreate(db);
    }
    public void insertNotes(NotesModel notesModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_TITLE,notesModel.getTitle());
        contentValues.put(COLUMN_DESC,notesModel.getDesc());

        db.insert(TABLE_TODO,null,contentValues);
        Log.d(TAG,"insertNotes: insertion successfull");
    }
    public List<NotesModel> getNotes(){
        List<NotesModel> notesModels=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String selection="SELECT * FROM "+TABLE_TODO;
        Cursor c=db.rawQuery(selection,null);
        if (c.moveToFirst()) {
            do {
                NotesModel notesModel=new NotesModel(
                        c.getString(c.getColumnIndex(COLUMN_TIME)),
                        c.getString(c.getColumnIndex(COLUMN_DESC)),
                        c.getString(c.getColumnIndex(COLUMN_TIME)),
                        c.getString(c.getColumnIndex(COLUMN_DATE))
                );
                Log.d(TAG, "getNotes: title ->"+c.getString(c.getColumnIndex(COLUMN_TIME)));
                notesModels.add(notesModel);
            }while (c.moveToNext());
        }

        return notesModels;
    }


}

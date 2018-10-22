package com.example.ukeje.learnapplication.database.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TutorDatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "tutors_db";


    public TutorDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Tutor.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Tutor.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    private long saveToDB(String data) {
        SQLiteDatabase db =  this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tutor.COLUMN_NAME, data);
        values.put(Tutor.COLUMN_LOCATION, data);
        values.put(Tutor.COLUMN_SUBJECT, data);


        long newRowId = db.insert(Tutor.TABLE_NAME, null, values);

       // Toast.makeText(this, "The new Row Id is " + newRowId, Toast.LENGTH_LONG).show();

        db.close();
        return newRowId;
    }

    public Tutor getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Tutor.TABLE_NAME,
                new String[]{Tutor.COLUMN_ID, Tutor.COLUMN_NAME,
                        Tutor.COLUMN_LOCATION, Tutor.COLUMN_SUBJECT},
                Tutor.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Tutor tutor = new Tutor(
                cursor.getInt(cursor.getColumnIndex(Tutor.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Tutor.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Tutor.COLUMN_LOCATION)),
                cursor.getString(cursor.getColumnIndex(Tutor.COLUMN_SUBJECT)));

        // close the db connection
        cursor.close();

        return tutor;
    }

    public List<Tutor> getAllTutors() {
        List<Tutor> tutors = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Tutor.TABLE_NAME + " ORDER BY " +
                Tutor.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Tutor tutor = new Tutor();
                tutor.setId(cursor.getInt(cursor.getColumnIndex(Tutor.COLUMN_ID)));
                tutor.setName(cursor.getString(cursor.getColumnIndex(Tutor.COLUMN_NAME)));
                tutor.setLocation(cursor.getString(cursor.getColumnIndex(Tutor.COLUMN_LOCATION)));
                tutor.setSubject(cursor.getString(cursor.getColumnIndex(Tutor.COLUMN_SUBJECT)));

                tutors.add(tutor);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return tutors;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Tutor.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateTutor(Tutor tutor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tutor.COLUMN_NAME, tutor.getName());

        // updating row
        return db.update(Tutor.TABLE_NAME, values, Tutor.COLUMN_ID + " = ?",
                new String[]{String.valueOf(tutor.getId())});
    }

    public void deleteTutor(Tutor tutor) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Tutor.TABLE_NAME, Tutor.COLUMN_ID + " = ?",
                new String[]{String.valueOf(tutor.getId())});
        db.close();
    }
}

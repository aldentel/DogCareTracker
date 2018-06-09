package com.example.salome.dogcaretracker.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.salome.dogcaretracker.Data.DogContract.DogEntry;

public class DogDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dogduty.db";

    public DogDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_WALKING_TABLE = "CREATE TABLE " + DogEntry.TABLE_WALKING + " ("
                + DogEntry.WALK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DogEntry.COLUMN_DATE1 + " TEXT NOT NULL, "
                + DogEntry.COLUMN_TIME1 + " TEXT NOT NULL, "
                + DogEntry.COLUMN_LENGTH + " INTEGER NOT NULL, "
                + DogEntry.COLUMN_LOCATION + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_WALKING_TABLE);

        String SQL_CREATE_FEEDING_TABLE = "CREATE TABLE " + DogEntry.TABLE_FEEDING + " ("
                + DogEntry.FEED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DogEntry.COLUMN_DATE2 + " TEXT NOT NULL, "
                + DogEntry.COLUMN_TIME2 + " TEXT NOT NULL, "
                + DogEntry.COLUMN_AMOUNT1 + " INTEGER NOT NULL, "
                + DogEntry.COLUMN_TYPE + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_FEEDING_TABLE);

        String SQL_CREATE_WATER_TABLE = "CREATE TABLE " + DogEntry.TABLE_WATER + " ("
                + DogEntry.WATER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DogEntry.COLUMN_DATE3 + " TEXT NOT NULL, "
                + DogEntry.COLUMN_TIME3 + " TEXT NOT NULL, "
                + DogEntry.COLUMN_AMOUNT2 + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_WATER_TABLE);

        String SQL_CREATE_WASHING_TABLE = "CREATE TABLE " + DogEntry.TABLE_WASH + " ("
                + DogEntry.WASH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DogEntry.COLUMN_DATE4 + " TEXT NOT NULL, "
                + DogEntry.COLUMN_TIME4 + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_WASHING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


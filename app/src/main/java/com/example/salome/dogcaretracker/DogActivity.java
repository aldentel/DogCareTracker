package com.example.salome.dogcaretracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.salome.dogcaretracker.Data.DogContract.DogEntry;
import com.example.salome.dogcaretracker.Data.DogDbHelper;

public class DogActivity extends AppCompatActivity {

    private DogDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
    }

    @Override
    protected void onStart() {
        super.onStart();
        insertDogChore();
        displayDatabaseInfo();
    }


    private void insertDogChore() {
        String date1String = "1/18/18";
        String date2String = "2/20/18";
        String date3String = "3/10/18";
        String date4String = "4/1/18";
        String time1String = "4am";
        String time2String = "5am";
        String time3String = "6am";
        String time4String = "7am";
        String lengthString = "15";
        String locationString = "Sugar Pine Point";
        String amount1String = "5 oz";
        String amount2String = "10 oz";
        String typeString = "dry";

        mDbHelper = new DogDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues valuesWalking = new ContentValues();
        valuesWalking.put(DogEntry.COLUMN_DATE1, date1String);
        valuesWalking.put(DogEntry.COLUMN_TIME1, time1String);
        valuesWalking.put(DogEntry.COLUMN_LENGTH, lengthString);
        valuesWalking.put(DogEntry.COLUMN_LOCATION, locationString);

        long newRowId1 = db.insert(DogEntry.TABLE_WALKING, null, valuesWalking);

        Log.v("DogActivity", "New Row Id 1" + newRowId1);

        ContentValues valuesFeeding = new ContentValues();
        valuesFeeding.put(DogEntry.COLUMN_DATE2, date2String);
        valuesFeeding.put(DogEntry.COLUMN_TIME2, time2String);
        valuesFeeding.put(DogEntry.COLUMN_AMOUNT1, amount1String);
        valuesFeeding.put(DogEntry.COLUMN_TYPE, typeString);

        long newRowId2 = db.insert(DogEntry.TABLE_FEEDING, null, valuesFeeding);

        Log.v("DogActivity", "New Row Id 2" + newRowId2);

        ContentValues valuesWater = new ContentValues();
        valuesWater.put(DogEntry.COLUMN_DATE3, date3String);
        valuesWater.put(DogEntry.COLUMN_TIME3, time3String);
        valuesWater.put(DogEntry.COLUMN_AMOUNT2, amount2String);

        long newRowId3 = db.insert(DogEntry.TABLE_WATER, null, valuesWater);

        Log.v("DogActivity", "New Row Id 3" + newRowId3);

        ContentValues valuesWashing = new ContentValues();
        valuesWashing.put(DogEntry.COLUMN_DATE4, date4String);
        valuesWashing.put(DogEntry.COLUMN_TIME4, time4String);


        long newRowId4 = db.insert(DogEntry.TABLE_WASH, null, valuesWashing);

        Log.v("DogActivity", "New Row Id 4" + newRowId4);
    }

    private void displayDatabaseInfo() {

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                DogEntry.WALK_ID,
                DogEntry.COLUMN_DATE1,
                DogEntry.COLUMN_TIME1,
                DogEntry.COLUMN_LENGTH,
                DogEntry.COLUMN_LOCATION
        };

        Cursor cursor = db.query(
                DogEntry.TABLE_WALKING,
                projection,
                null,
                null,
                null,
                null,
                null);

        try {
            TextView displayView = (TextView) findViewById(R.id.text_view_dogduty);

            displayView.setText("Walking Table" + "\n");
            displayView.append(
                    DogEntry.WALK_ID + "_" +
                            DogEntry.COLUMN_DATE1 + "_" +
                            DogEntry.COLUMN_TIME1 + "_" +
                            DogEntry.COLUMN_LENGTH + "_" +
                            DogEntry.COLUMN_LOCATION + "\n");

            int walkIdColumnIndex = cursor.getColumnIndex(DogEntry.WALK_ID);
            int date1ColumnIndex = cursor.getColumnIndex(DogEntry.COLUMN_DATE1);
            int time1ColumnIndex = cursor.getColumnIndex(DogEntry.COLUMN_TIME1);
            int lengthColumnIndex = cursor.getColumnIndex(DogEntry.COLUMN_LENGTH);
            int locationColumnIndex = cursor.getColumnIndex(DogEntry.COLUMN_LOCATION);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentWalkID = cursor.getInt(walkIdColumnIndex);
                String currentDate1 = cursor.getString(date1ColumnIndex);
                String currentTime1 = cursor.getString(time1ColumnIndex);
                int currentLength = cursor.getInt(lengthColumnIndex);
                String currentLocation = cursor.getString(locationColumnIndex);

                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" +
                        currentWalkID + " - " +
                        currentDate1 + " - " +
                        currentTime1 + " - " +
                        currentLength + " - " +
                        currentLocation));
            }

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
}
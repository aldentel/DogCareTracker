package com.example.salome.dogcaretracker.Data;

import android.provider.BaseColumns;

public class DogContract {
    private DogContract() {
    }

    public static abstract class DogEntry implements BaseColumns {


        public static final String TABLE_WALKING = "walking";
        public static final String WALK_ID = BaseColumns._ID;
        public static final String COLUMN_DATE1 = "date";
        public static final String COLUMN_TIME1 = "time";
        public static final String COLUMN_LENGTH = "length";
        public static final String COLUMN_LOCATION = "location";

        public static final String TABLE_FEEDING = "feeding";
        public static final String FEED_ID = BaseColumns._ID;
        public static final String COLUMN_DATE2 = "date";
        public static final String COLUMN_TIME2 = "time";
        public static final String COLUMN_AMOUNT1 = "amount";
        public static final String COLUMN_TYPE = "type";

        public static final String TABLE_WATER = "watering";
        public static final String WATER_ID = BaseColumns._ID;
        public static final String COLUMN_DATE3 = "date";
        public static final String COLUMN_TIME3 = "time";
        public static final String COLUMN_AMOUNT2 = "amount";

        public static final String TABLE_WASH = "washing";
        public static final String WASH_ID = BaseColumns._ID;
        public static final String COLUMN_DATE4 = "date";
        public static final String COLUMN_TIME4 = "time";

    }
}


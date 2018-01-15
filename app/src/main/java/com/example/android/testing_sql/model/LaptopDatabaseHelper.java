package com.example.android.testing_sql.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;




    public class LaptopDatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "laptop.db";
        private static final String TABLE_NAME = "laptopSightings";
        private static final int SCHEMA_VERSION = 1;

        public LaptopDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE " + TABLE_NAME +
                            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "last_name TEXT, first_name TEXT, hairColor TEXT, Date date, Time time);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        /*  Important for when you update an entire database with a new version.
        *   We won't be exploring that in this lecture's example.
        */
        }

        public void addLaptopSighting(LaptopSighting laptopSighting) {
            Cursor cursor = getReadableDatabase().rawQuery(
                            "SELECT * FROM " + TABLE_NAME + " WHERE first_name = '" + laptopSighting.getFirstName() +
                                    "' AND last_name = '" + laptopSighting.getLastName() + "' hair color is = " +laptopSighting.getHairColor() + "' AND time = '" +
                                    laptopSighting.getTime() + "' AND date = '"
                                   +laptopSighting.getDate() + "';", null);

            if (cursor.getCount() == 0) {
                getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                        "(last_name, first_name, company) VALUES('" +
                        laptopSighting.getLastName() + "', '" +
                        laptopSighting.getFirstName() + "', '" +
                        laptopSighting.getHairColor() + "', '" +
                        laptopSighting.getDate() + "', '" +
                        laptopSighting.getTime() + "');");
            }
            cursor.close();
        }

        public List<LaptopSighting> getlaptopSightingList() {


            List<LaptopSighting> laptopSightingList = new ArrayList<>();

            Cursor cursor = getReadableDatabase().rawQuery(
                    "SELECT * FROM " + TABLE_NAME + ";", null);



            if(cursor != null) {
                if(cursor.moveToFirst()) {
                    do {
                        LaptopSighting laptopSighting = new LaptopSighting(

                                cursor.getString(cursor.getColumnIndex("last_name")),
                                cursor.getString(cursor.getColumnIndex("first_name")),
                                cursor.getString(cursor.getColumnIndex("hairColor")),
                                cursor.getLong(cursor.getColumnIndex("date")),
                                cursor.getLong(cursor.getColumnIndex("time")));
                        laptopSightingList.add(laptopSighting);
                    } while (cursor.moveToNext());
                }
            }
            return laptopSightingList;
        }


    }
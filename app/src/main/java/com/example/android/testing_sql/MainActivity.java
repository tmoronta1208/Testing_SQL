package com.example.android.testing_sql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.testing_sql.model.LaptopSighting;
import com.example.android.testing_sql.model.LaptopDatabaseHelper;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

Cursor cursor;

//        Date c = new Date((((int) System.currentTimeMillis())));
        long c = (((int) System.currentTimeMillis()));

        LaptopDatabaseHelper laptopDatabaseHelper = new LaptopDatabaseHelper(getApplicationContext());
        

       laptopDatabaseHelper.addLaptopSighting("Tatiana", "Moronta", "black", c, c);

        List<LaptopSighting> laptopSightingList = laptopDatabaseHelper.getlaptopSightingList();

        for (LaptopSighting f : laptopSightingList) {

            Log.d("LaptopSighting", f.getLastName() + "," + f.getFirstName() + "-" + f.getHairColor() + " " + f.getTime() + " " + f.getDate());

        }


    }
}

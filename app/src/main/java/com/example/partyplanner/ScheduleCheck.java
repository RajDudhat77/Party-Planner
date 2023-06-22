// FILE         : Explore.java
// PROJECT      : A3PartyPlanner
// PROGRAMMER(s): Beunard Lecaj, Jainish Patel, Raj Dudhat, Yujung Park
// FIRST VERSION: 2023-04-11
// DESCRIPTION  : This is AppCompatActivity class file for Explore activity.
// Explore activity allow user to check the schedule in user's calendar


package com.example.partyplanner;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import java.util.Date;

public class ScheduleCheck extends AppCompatActivity {


    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_check);

        result = findViewById(R.id.tv_result);

        // Marshmallow stype permision
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.READ_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CALENDAR}, 1);
        } else {
            readSchedule();
        }
    }

    public void readSchedule() {

        Uri uri = CalendarContract.Events.CONTENT_URI;
        StringBuffer output = new StringBuffer();

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(uri, null, null,null, null);

        if(cursor.getCount() > 0 && cursor != null) {
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(CalendarContract.Events._ID);
                int ttlIndex = cursor.getColumnIndex(CalendarContract.Events.TITLE);
                int startIndex = cursor.getColumnIndex(CalendarContract.Events.DTSTART);
                
                if (idIndex >= 0 && ttlIndex >= 0 && startIndex >= 0) {
                    // get value from each index
                    String id = cursor.getString(idIndex);
                    String title = cursor.getString(ttlIndex);
                    long startDay = cursor.getLong(startIndex);

                    // display
                    output.append("Date: " + new Date(startDay) + "\n");
                    output.append("Schedule ID: " + id + "\n");
                    output.append("Title: " + title + "\n");
                    output.append("\n");
                } // end if
            } // end while
            cursor.close();
            result.setText(output);
        }
        // when cursor is null do nothing

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readSchedule();
                } else {
                    Log.d("Explore", "permission denied");
                }
                return;
            }
        }
    }



    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuBuilder m = (MenuBuilder)menu;
        m.setOptionalIconsVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        Intent intent = null;
        switch(item.getItemId()) {
            case R.id.menu_activity_main:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                result = true;
                break;
            case R.id.menu_activity_planner:
                intent = new Intent(this, Planner.class);
                startActivity(intent);
                result = true;
                break;

            case R.id.menu_activity_budget:
                intent = new Intent(this, Budget.class);
                startActivity(intent);
                result = true;
                break;
            case R.id.menu_activity_checklist:
                intent = new Intent(this, Checklist.class);
                startActivity(intent);
                result = true;
                break;
            case R.id.menu_activity_food:
                //intent = new Intent(this, Food.class);
                intent = new Intent(this, PartyFood.class);
                startActivity(intent);
                result = true;
                break;

            case R.id.menu_activity_explore:
                intent = new Intent(this, ScheduleCheck.class);
                startActivity(intent);
                result = true;
                break;

            case R.id.menu_activity_partylist:
                intent = new Intent(this, Partylist.class);
                startActivity(intent);
                result = true;
                break;
            default:
                result = super.onOptionsItemSelected(item);
                break;
        }
        return result;
    }


}
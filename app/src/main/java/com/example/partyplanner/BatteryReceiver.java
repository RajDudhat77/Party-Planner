package com.example.partyplanner;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class BatteryReceiver extends BroadcastReceiver {

    private Context context;

    // constructor
    public BatteryReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // battery status braodcast
        if (Intent.ACTION_BATTERY_LOW.equals(intent.getAction())) {
            Snackbar.make(((Activity)this.context).findViewById(android.R.id.content),
                    "Battery is low", Snackbar.LENGTH_LONG).show();
        }


    }
}
package com.example.partyplanner;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationService extends Service {
    NotificationManager notify;
    MediaPlayer mediaPlayer;
    private static final String CHANNEL_ID  = "Demo Channel";
    private static final int NOTIFICATION_ID  = 500;
    public NotificationService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        demoNotification("You Have party Coming up in Few Days..");
        return START_STICKY;
    }

    private void demoNotification(String text)
    {
        CharSequence appName = getText(R.string.app_name);
        notify = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nChannel = new NotificationChannel(CHANNEL_ID, "dm", NotificationManager.IMPORTANCE_HIGH);
            notify.createNotificationChannel(nChannel);

            notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.img)
                    .setContentTitle(appName)
                    .setContentText(text)
                    .setSubText("New Notification")
                    .setChannelId(CHANNEL_ID)
                    .build();
            notify.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "demo", NotificationManager.IMPORTANCE_HIGH));
        }
        else {
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.img)
                    .setContentTitle(appName)
                    .setContentText(text)
                    .setSubText("New Notification")
                    .build();

        }
        notify.notify(NOTIFICATION_ID, notification);
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
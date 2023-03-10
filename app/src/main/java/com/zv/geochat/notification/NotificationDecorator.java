package com.zv.geochat.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

import com.zv.geochat.ChatActivity;

public class NotificationDecorator {

    private static final String TAG = "NotificationDecorator";
    private final Context context;
    private final NotificationManager notificationMgr;
    private final MessageNotifierConfig messageNotifierConfig;

    public NotificationDecorator(Context context, NotificationManager notificationManager) {
        this.context = context;
        this.notificationMgr = notificationManager;
        this.messageNotifierConfig = new MessageNotifierConfig(context);
    }

    public void displaySimpleNotification(String title, String contentText) {
        if (messageNotifierConfig.isPlaySound()) {
            Intent intent = new Intent(context, ChatActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);

            // notification message
            try {


                Notification noti = new Notification.Builder(context)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle(title)
                        .setContentText(contentText)
                        .setContentIntent(contentIntent)
                        .setAutoCancel(true)
                        .setSound(messageNotifierConfig.getSoundUri())
                        .setVibrate(messageNotifierConfig.getVibratePattern())
                        .setLights(Color.BLUE, 1000, 1000)
                        .build();

                noti.flags |= Notification.FLAG_AUTO_CANCEL;
                notificationMgr.notify(0, noti);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

    public void displayExpandableNotification(String title, String contentText) {
        if (messageNotifierConfig.isPlaySound()) {
            Intent intent = new Intent(context, ChatActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);

            // notification message
            try {


                Notification noti = new Notification.Builder(context)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle(title)
                        .setContentText(contentText)
                        .setContentIntent(contentIntent)
                        .setAutoCancel(true)
                        .setSound(messageNotifierConfig.getSoundUri())
                        .setVibrate(messageNotifierConfig.getVibratePattern())
                        .setLights(Color.BLUE, 1000, 1000)
                        .setStyle(new Notification.BigTextStyle().bigText(contentText))
                        .build();

                noti.flags |= Notification.FLAG_AUTO_CANCEL;
                notificationMgr.notify(0, noti);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

}

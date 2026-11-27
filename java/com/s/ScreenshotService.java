package com.s;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import com.frame.i0;
import i.b.i9;

/* loaded from: classes.dex */
public class ScreenshotService extends Service {
    private int c;
    private Intent d;

    private void a() {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        Notification.Builder contentIntent = builder.setContentIntent(i0.f(0, new Intent("ACTION_CLOSE_SCREEN_CAPTURE")));
        Resources resources = getResources();
        int i2 = j.b.d.o0;
        contentIntent.setLargeIcon(BitmapFactory.decodeResource(resources, i2)).setSmallIcon(i2).setContentText("稳定性守护，点击关闭录屏权限").setWhen(System.currentTimeMillis());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            builder.setChannelId("notification_id");
        }
        if (i3 >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
        }
        Notification notificationBuild = builder.build();
        notificationBuild.defaults = 1;
        startForeground(110, notificationBuild);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        a();
        if (intent != null) {
            this.c = intent.getIntExtra("code", -1);
            this.d = (Intent) intent.getParcelableExtra("data");
        }
        i9.v().p0(this.c, this.d);
        return super.onStartCommand(intent, i2, i3);
    }
}

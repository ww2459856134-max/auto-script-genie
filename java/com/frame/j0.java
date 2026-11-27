package com.frame;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public class j0 {
    public void a(Intent intent) {
        ((AlarmManager) v0.g().getSystemService("alarm")).cancel(i0.g(0, intent));
    }

    public void b(long j2, PendingIntent pendingIntent) {
        try {
            AlarmManager alarmManager = (AlarmManager) v0.g().getSystemService("alarm");
            alarmManager.cancel(pendingIntent);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, j2, pendingIntent);
                alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j2, pendingIntent), pendingIntent);
            } else if (i2 >= 19) {
                alarmManager.setExact(0, j2, pendingIntent);
            } else {
                alarmManager.set(0, j2, pendingIntent);
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void c(long j2, Intent intent) {
        b(j2, i0.g(0, intent));
    }
}

package com.s;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.frame.i0;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import com.frame.w0;
import com.frame.y0;
import com.yl.model.AutoNotify;
import com.yl.model.Task;
import i.b.da;
import i.b.l7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"OverrideAbstract"})
/* loaded from: classes.dex */
public class NotifyService extends NotificationListenerService {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(StatusBarNotification statusBarNotification) throws PendingIntent.CanceledException {
        y0.o("触发日历通知栏");
        try {
            i0.g(12312, new Intent(v0.g(), (Class<?>) TaskService.class)).send();
        } catch (PendingIntent.CanceledException e) {
            k0.r(e);
        }
        a(statusBarNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(StatusBarNotification statusBarNotification, String str) {
        try {
            if (w0.d() && da.B().U() && da.B().M().noNotificationWithTaskRun) {
                a(statusBarNotification);
            }
            for (AutoNotify autoNotify : l7.b().c()) {
                if (str.equals(autoNotify.pn)) {
                    ArrayList<String> arrayList = autoNotify.keyword;
                    if (arrayList == null || arrayList.isEmpty()) {
                        a(statusBarNotification);
                        f(statusBarNotification.getNotification(), autoNotify);
                    } else {
                        Notification notification = statusBarNotification.getNotification();
                        if (notification == null) {
                            return;
                        }
                        Bundle bundle = notification.extras;
                        if (bundle != null) {
                            String string = bundle.getCharSequence("android.title", "").toString();
                            String string2 = bundle.getCharSequence("android.text", "").toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = bundle.getString("android.text");
                            }
                            if (TextUtils.isEmpty(string)) {
                                string = bundle.getString("android.title");
                            }
                            Iterator<String> it = autoNotify.keyword.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                if ((string != null && string.contains(next)) || (string2 != null && string2.contains(next))) {
                                    a(statusBarNotification);
                                    da.B().E1("msg-content", string2);
                                    da.B().E1("msg-title", string);
                                    f(notification, autoNotify);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            y0.l(e);
        }
    }

    public void a(StatusBarNotification statusBarNotification) {
        try {
            if (Build.VERSION.SDK_INT > 20) {
                cancelNotification(statusBarNotification.getKey());
            } else {
                cancelNotification(statusBarNotification.getPackageName(), statusBarNotification.getTag(), statusBarNotification.getId());
            }
        } catch (Exception e) {
            y0.l(e);
        }
    }

    public void f(Notification notification, AutoNotify autoNotify) throws IllegalStateException, PendingIntent.CanceledException, IOException, SecurityException, IllegalArgumentException {
        if (autoNotify.clickNotify) {
            try {
                notification.contentIntent.send();
            } catch (Exception e) {
                k0.r(e);
            }
        }
        y0.g("通知栏消息触发任务");
        Task taskL = da.B().L(autoNotify.taskId);
        if (taskL == null) {
            y0.j("未找到通知栏消息触发的任务");
        } else {
            da.B().D1(da.B().M().alarmTaskSoundFile);
            da.B().H1(taskL);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(final StatusBarNotification statusBarNotification, NotificationListenerService.RankingMap rankingMap) {
        super.onNotificationPosted(statusBarNotification, rankingMap);
        final String packageName = statusBarNotification.getPackageName();
        if (packageName.contains("calendar")) {
            l1.g(new Runnable() { // from class: com.s.n
                @Override // java.lang.Runnable
                public final void run() throws PendingIntent.CanceledException {
                    this.c.c(statusBarNotification);
                }
            });
        }
        l1.g(new Runnable() { // from class: com.s.m
            @Override // java.lang.Runnable
            public final void run() {
                this.c.e(statusBarNotification, packageName);
            }
        });
    }
}

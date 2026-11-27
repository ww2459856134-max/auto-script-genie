package com.frame;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public abstract class l1 {
    protected static Handler a;
    protected static Handler b;
    private static ExecutorService c;

    public static void a(Handler handler) {
        a = handler;
        b = new k1();
        c = Executors.newFixedThreadPool(10);
    }

    public static void c(int i2, Runnable runnable, long j2) {
        b.removeMessages(i2);
        Message messageObtainMessage = b.obtainMessage();
        messageObtainMessage.what = i2;
        messageObtainMessage.obj = runnable;
        b.sendMessageDelayed(messageObtainMessage, j2);
    }

    public static void d(Runnable runnable, long j2) {
        b.removeMessages(1999999);
        Message messageObtainMessage = b.obtainMessage();
        messageObtainMessage.what = 1999999;
        messageObtainMessage.obj = runnable;
        b.sendMessageDelayed(messageObtainMessage, j2);
    }

    public static void e(Runnable runnable) {
        a.post(runnable);
    }

    public static void f(Runnable runnable, long j2) {
        a.postDelayed(runnable, j2);
    }

    public static void g(Runnable runnable) {
        c.execute(runnable);
    }

    public static void h(Runnable runnable) {
        a.removeCallbacks(runnable);
    }

    public static void i(int i2) {
        b.removeMessages(i2);
    }

    public static void j(final String str) {
        a.post(new Runnable() { // from class: com.frame.a0
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(v0.g(), str, 0).show();
            }
        });
    }
}

package com.bumptech.glide.b0;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* loaded from: classes.dex */
public abstract class j {
    private static final double a;

    static {
        a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static double a(long j2) {
        return (b() - j2) * a;
    }

    @TargetApi(17)
    public static long b() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }
}

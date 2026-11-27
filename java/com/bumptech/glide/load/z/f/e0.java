package com.bumptech.glide.load.z.f;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public final class e0 {
    private static final File f = new File("/proc/self/fd");
    private static volatile e0 g;
    private final int b;
    private final int c;
    private int d;
    private boolean e = true;
    private final boolean a = d();

    e0() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.c = 0;
        } else {
            this.b = 700;
            this.c = 128;
        }
    }

    public static e0 a() {
        if (g == null) {
            synchronized (e0.class) {
                if (g == null) {
                    g = new e0();
                }
            }
        }
        return g;
    }

    private synchronized boolean b() {
        boolean z = true;
        int i2 = this.d + 1;
        this.d = i2;
        if (i2 >= 50) {
            this.d = 0;
            int length = f.list().length;
            if (length >= this.b) {
                z = false;
            }
            this.e = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.b);
            }
        }
        return this.e;
    }

    private static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String strSubstring = str.substring(0, 7);
        strSubstring.hashCode();
        switch (strSubstring) {
            case "SM-A520":
            case "SM-G930":
            case "SM-G935":
            case "SM-G960":
            case "SM-G965":
            case "SM-J720":
            case "SM-N935":
                return Build.VERSION.SDK_INT != 26;
            default:
                return true;
        }
    }

    public boolean c(int i2, int i3, boolean z, boolean z2) {
        int i4;
        return z && this.a && Build.VERSION.SDK_INT >= 26 && !z2 && i2 >= (i4 = this.c) && i3 >= i4 && b();
    }

    @TargetApi(26)
    boolean e(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zC = c(i2, i3, z, z2);
        if (zC) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zC;
    }
}

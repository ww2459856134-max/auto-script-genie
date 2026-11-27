package com.bumptech.glide.load.x.h1;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.Log;

/* loaded from: classes.dex */
public final class s {
    private final int a;
    private final int b;
    private final Context c;
    private final int d;

    s(p pVar) {
        this.c = pVar.a;
        int i2 = e(pVar.b) ? pVar.f614h / 2 : pVar.f614h;
        this.d = i2;
        int iC = c(pVar.b, pVar.f, pVar.g);
        float fB = pVar.c.b() * pVar.c.a() * 4;
        int iRound = Math.round(pVar.e * fB);
        int iRound2 = Math.round(fB * pVar.d);
        int i3 = iC - i2;
        int i4 = iRound2 + iRound;
        if (i4 <= i3) {
            this.b = iRound2;
            this.a = iRound;
        } else {
            float f = i3;
            float f2 = pVar.e;
            float f3 = pVar.d;
            float f4 = f / (f2 + f3);
            this.b = Math.round(f3 * f4);
            this.a = Math.round(f4 * pVar.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.b));
            sb.append(", pool size: ");
            sb.append(f(this.a));
            sb.append(", byte array size: ");
            sb.append(f(i2));
            sb.append(", memory class limited? ");
            sb.append(i4 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(pVar.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(pVar.b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i2) {
        return Formatter.formatFileSize(this.c, i2);
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}

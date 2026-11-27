package com.bumptech.glide.b0;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public abstract class p {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];

    public static void a() {
        if (!p()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static String d(byte[] bArr, char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> e(int i2) {
        return new ArrayDeque(i2);
    }

    public static int f(int i2, int i3, Bitmap.Config config) {
        return i2 * i3 * h(config);
    }

    @TargetApi(19)
    public static int g(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int h(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = o.a[config.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        return i2 != 4 ? 4 : 8;
    }

    public static <T> List<T> i(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static int j(float f) {
        return k(f, 17);
    }

    public static int k(float f, int i2) {
        return l(Float.floatToIntBits(f), i2);
    }

    public static int l(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static int m(Object obj, int i2) {
        return l(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int n(boolean z, int i2) {
        return l(z ? 1 : 0, i2);
    }

    public static boolean o() {
        return !p();
    }

    public static boolean p() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean q(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean r(int i2, int i3) {
        return q(i2) && q(i3);
    }

    public static String s(byte[] bArr) {
        String strD;
        char[] cArr = b;
        synchronized (cArr) {
            strD = d(bArr, cArr);
        }
        return strD;
    }
}

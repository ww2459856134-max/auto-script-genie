package com.frame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* loaded from: classes.dex */
public class j1 {
    private static j1 b;
    private final h.d.g<String, i1> a = new h1(this, (int) (Runtime.getRuntime().maxMemory() / 6));

    private j1() {
    }

    public static j1 c() {
        if (b == null) {
            synchronized (j1.class) {
                if (b == null) {
                    b = new j1();
                }
            }
        }
        return b;
    }

    public Bitmap a(String str) {
        Bitmap bitmapB = b(str);
        if (bitmapB != null && !bitmapB.isRecycled()) {
            return bitmapB;
        }
        if (bitmapB != null && bitmapB.isRecycled()) {
            this.a.e(str);
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        d(bitmapDecodeFile, str);
        return bitmapDecodeFile;
    }

    public Bitmap b(String str) {
        i1 i1VarC = this.a.c(str);
        if (i1VarC == null) {
            return null;
        }
        return i1VarC.a;
    }

    public void d(Bitmap bitmap, String str) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.a.d(str, new i1(bitmap, null));
    }
}

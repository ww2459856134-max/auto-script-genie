package com.googlecode.leptonica.android;

/* loaded from: classes.dex */
public class Pix {
    private final long a;
    private boolean b = false;

    static {
        System.loadLibrary("jpeg");
        System.loadLibrary("pngx");
        System.loadLibrary("leptonica");
    }

    public Pix(long j2) {
        this.a = j2;
    }

    private static native long nativeClone(long j2);

    private static native void nativeDestroy(long j2);

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Pix clone() {
        if (this.b) {
            throw new IllegalStateException();
        }
        long jNativeClone = nativeClone(this.a);
        if (jNativeClone != 0) {
            return new Pix(jNativeClone);
        }
        throw new OutOfMemoryError();
    }

    public long b() {
        if (this.b) {
            throw new IllegalStateException();
        }
        return this.a;
    }

    public void c() {
        if (this.b) {
            return;
        }
        nativeDestroy(this.a);
        this.b = true;
    }
}

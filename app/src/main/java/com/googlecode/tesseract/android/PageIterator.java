package com.googlecode.tesseract.android;

/* loaded from: classes.dex */
public abstract class PageIterator {
    private final long a;

    static {
        System.loadLibrary("jpeg");
        System.loadLibrary("pngx");
        System.loadLibrary("leptonica");
        System.loadLibrary("tesseract");
    }

    PageIterator(long j2) {
        this.a = j2;
    }

    private static native void nativeBegin(long j2);

    private static native int[] nativeBoundingBox(long j2, int i2);

    private static native boolean nativeNext(long j2, int i2);

    public void a() {
        nativeBegin(this.a);
    }

    public int[] b(int i2) {
        return nativeBoundingBox(this.a, i2);
    }

    public boolean c(int i2) {
        return nativeNext(this.a, i2);
    }
}

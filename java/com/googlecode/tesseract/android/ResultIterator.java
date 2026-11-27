package com.googlecode.tesseract.android;

/* loaded from: classes.dex */
public class ResultIterator extends PageIterator {
    private final long b;

    static {
        System.loadLibrary("jpeg");
        System.loadLibrary("pngx");
        System.loadLibrary("leptonica");
        System.loadLibrary("tesseract");
    }

    ResultIterator(long j2) {
        super(j2);
        this.b = j2;
    }

    private static native float nativeConfidence(long j2, int i2);

    private static native void nativeDelete(long j2);

    private static native String nativeGetUTF8Text(long j2, int i2);

    public float d(int i2) {
        return nativeConfidence(this.b, i2);
    }

    public void e() {
        nativeDelete(this.b);
    }

    public String f(int i2) {
        return nativeGetUTF8Text(this.b, i2);
    }
}

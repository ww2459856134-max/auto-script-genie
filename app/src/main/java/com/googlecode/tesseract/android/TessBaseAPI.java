package com.googlecode.tesseract.android;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Keep;
import com.googlecode.leptonica.android.Pix;
import com.googlecode.leptonica.android.ReadFile;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class TessBaseAPI {
    private static final String d;
    private long a;
    private a b;
    private boolean c;

    public interface a {
        void a(b bVar);
    }

    public class b {
        private final int a;
        private final Rect b;
        private final Rect c;

        public b(int i2, Rect rect, Rect rect2) {
            this.a = i2;
            this.b = rect;
            this.c = rect2;
        }

        public String toString() {
            return "ProgressValues{percent=" + this.a + ", wordRect=" + this.b + ", textRect=" + this.c + '}';
        }
    }

    static {
        System.loadLibrary("jpeg");
        System.loadLibrary("pngx");
        System.loadLibrary("leptonica");
        System.loadLibrary("tesseract");
        nativeClassInit();
        d = TessBaseAPI.class.getSimpleName();
    }

    public TessBaseAPI() {
        long jNativeConstruct = nativeConstruct();
        this.a = jNativeConstruct;
        if (jNativeConstruct == 0) {
            throw new RuntimeException("Can't create TessBaseApi object");
        }
        this.c = false;
    }

    private static native void nativeClassInit();

    private native void nativeClear(long j2);

    private native long nativeConstruct();

    private native long nativeGetResultIterator(long j2);

    private native String nativeGetUTF8Text(long j2);

    private native boolean nativeInitOem(long j2, String str, String str2, int i2);

    private native boolean nativeInitParams(long j2, String str, String str2, int i2, String[] strArr, String[] strArr2);

    private native void nativeRecycle(long j2);

    private native void nativeSetImagePix(long j2, long j3);

    private native boolean nativeSetVariable(long j2, String str, String str2);

    public void a() {
        if (this.c) {
            throw new IllegalStateException();
        }
        nativeClear(this.a);
    }

    public ResultIterator b() {
        if (this.c) {
            throw new IllegalStateException();
        }
        long jNativeGetResultIterator = nativeGetResultIterator(this.a);
        if (jNativeGetResultIterator == 0) {
            return null;
        }
        return new ResultIterator(jNativeGetResultIterator);
    }

    public String c() {
        if (this.c) {
            throw new IllegalStateException();
        }
        String strNativeGetUTF8Text = nativeGetUTF8Text(this.a);
        if (strNativeGetUTF8Text != null) {
            return strNativeGetUTF8Text.trim();
        }
        return null;
    }

    public boolean d(String str, String str2, int i2) {
        return e(str, str2, i2, Collections.emptyMap());
    }

    public boolean e(String str, String str2, int i2, Map<String, String> map) {
        if (this.c) {
            throw new IllegalStateException();
        }
        if (str == null) {
            throw new IllegalArgumentException("Data path must not be null!");
        }
        String str3 = File.separator;
        if (!str.endsWith(str3)) {
            str = str + str3;
        }
        if (!new File(str).exists()) {
            throw new IllegalArgumentException("Data path does not exist!");
        }
        File file = new File(str + "tessdata");
        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("Data path must contain subfolder tessdata!");
        }
        if (map.isEmpty()) {
            return nativeInitOem(this.a, str + "tessdata", str2, i2);
        }
        int size = map.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i3 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i3] = entry.getKey();
            strArr2[i3] = entry.getValue();
            i3++;
        }
        return nativeInitParams(this.a, str + "tessdata", str2, i2, strArr, strArr2);
    }

    public void f() {
        if (this.c) {
            return;
        }
        nativeRecycle(this.a);
        this.a = 0L;
        this.c = true;
    }

    protected void finalize() throws Throwable {
        try {
            if (!this.c) {
                Log.w(d, "TessBaseAPI was not terminated using recycle()");
                f();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(Bitmap bitmap) {
        if (this.c) {
            throw new IllegalStateException();
        }
        Pix pixA = ReadFile.a(bitmap);
        if (pixA == null) {
            throw new RuntimeException("Failed to read bitmap");
        }
        nativeSetImagePix(this.a, pixA.b());
        pixA.c();
    }

    public boolean h(String str, String str2) {
        if (this.c) {
            throw new IllegalStateException();
        }
        return nativeSetVariable(this.a, str, str2);
    }

    @Keep
    protected void onProgressValues(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (this.b != null) {
            this.b.a(new b(i2, new Rect(i3, i9 - i5, i4, i9 - i6), new Rect(i7, i10, i8, i9)));
        }
    }
}

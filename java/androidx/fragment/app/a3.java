package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
final class a3 extends Writer {
    private final String c;
    private StringBuilder d = new StringBuilder(128);

    a3(String str) {
        this.c = str;
    }

    private void a() {
        if (this.d.length() > 0) {
            Log.d(this.c, this.d.toString());
            StringBuilder sb = this.d;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c = cArr[i2 + i4];
            if (c == '\n') {
                a();
            } else {
                this.d.append(c);
            }
        }
    }
}

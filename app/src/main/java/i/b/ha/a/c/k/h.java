package i.b.ha.a.c.k;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/* loaded from: classes.dex */
public class h extends Writer implements Serializable {
    private final StringBuilder c;

    public h(int i2) {
        this.c = new StringBuilder(i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char c) throws IOException {
        append(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        if (cArr != null) {
            i.b.ha.a.c.e.e(cArr, i2, i3);
            this.c.append(cArr, i2, i3);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
        append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.c.append(str);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        this.c.append(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.c.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i2, int i3) {
        this.c.append(charSequence, i2, i3);
        return this;
    }
}

package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* loaded from: classes.dex */
final class s0 extends Writer {
    private final Appendable c;
    private final r0 d = new r0();

    s0(Appendable appendable) {
        this.c = appendable;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) throws IOException {
        this.d.a(cArr);
        this.c.append(this.d, i2, i3 + i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
        append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        this.c.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public void write(int i2) throws IOException {
        this.c.append((char) i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i2, int i3) throws IOException {
        this.c.append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i2, int i3) throws IOException {
        Objects.requireNonNull(str);
        this.c.append(str, i2, i3 + i2);
    }
}

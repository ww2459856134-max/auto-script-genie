package com.google.gson.internal.bind;

import java.io.Writer;

/* loaded from: classes.dex */
class a extends Writer {
    a() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new AssertionError();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        throw new AssertionError();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        throw new AssertionError();
    }
}

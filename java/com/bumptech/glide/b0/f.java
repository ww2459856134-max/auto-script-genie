package com.bumptech.glide.b0;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public class f extends InputStream {
    private static final Queue<f> e = p.e(0);
    private InputStream c;
    private IOException d;

    f() {
    }

    public static f c(InputStream inputStream) {
        f fVarPoll;
        Queue<f> queue = e;
        synchronized (queue) {
            fVarPoll = queue.poll();
        }
        if (fVarPoll == null) {
            fVarPoll = new f();
        }
        fVarPoll.f(inputStream);
        return fVarPoll;
    }

    public IOException a() {
        return this.d;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.c.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public void d() {
        this.d = null;
        this.c = null;
        Queue<f> queue = e;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    void f(InputStream inputStream) {
        this.c = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.c.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.c.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.c.read(bArr);
        } catch (IOException e2) {
            this.d = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.c.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        try {
            return this.c.skip(j2);
        } catch (IOException e2) {
            this.d = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.c.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.d = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.c.read();
        } catch (IOException e2) {
            this.d = e2;
            return -1;
        }
    }
}

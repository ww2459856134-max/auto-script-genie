package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class PushedInputStream extends InputStream {
    private static int defaultBufferSize = 2048;
    protected byte[] buf;
    protected int marklimit;
    protected int markpos;
    protected OutputStream outputStream;
    protected int readpos;
    protected int writepos;

    public PushedInputStream() {
        this(defaultBufferSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void shift(int i2) {
        int i3 = this.readpos;
        int i4 = this.markpos;
        if (i4 > 0) {
            if (i3 - i4 > this.marklimit) {
                this.markpos = -1;
            } else {
                i3 = i4;
            }
        }
        int i5 = this.writepos - i3;
        if (i3 > 0) {
            byte[] bArr = this.buf;
            if (bArr.length - i5 < i2 || i5 > i2) {
                byte[] bArr2 = new byte[Math.max(this.buf.length << 1, i2 + i5)];
                System.arraycopy(this.buf, i3, bArr2, 0, i5);
                this.buf = bArr2;
            } else {
                System.arraycopy(bArr, i3, bArr, 0, i5);
            }
        }
        if (i3 > 0) {
            this.readpos -= i3;
            int i6 = this.markpos;
            if (i6 > 0) {
                this.markpos = i6 - i3;
            }
            this.writepos -= i3;
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.writepos - this.readpos;
    }

    protected abstract void fill(int i2) throws IOException;

    public final OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.marklimit = i2;
        this.markpos = this.readpos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.readpos >= this.writepos) {
            fill(1);
            if (this.readpos >= this.writepos) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i2 = this.readpos;
        this.readpos = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        int i2 = this.markpos;
        if (i2 < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.readpos = i2;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 <= 0) {
            return 0L;
        }
        long j3 = this.writepos - this.readpos;
        if (j3 < j2) {
            long j4 = j2 - j3;
            if (j4 > 2147483647L) {
                j4 = 2147483647L;
            }
            fill((int) j4);
            j3 = this.writepos - this.readpos;
            if (j3 <= 0) {
                return 0L;
            }
        }
        if (j3 < j2) {
            j2 = j3;
        }
        this.readpos = Math.addExact(this.readpos, Math.toIntExact(j2));
        return j2;
    }

    public PushedInputStream(int i2) {
        this.markpos = -1;
        this.outputStream = new InternalOutputStream();
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative initial buffer size");
        }
        this.buf = new byte[i2];
    }

    private class InternalOutputStream extends OutputStream {
        private InternalOutputStream() {
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i2) throws IOException {
            PushedInputStream pushedInputStream = PushedInputStream.this;
            if (pushedInputStream.writepos + 1 > pushedInputStream.buf.length) {
                pushedInputStream.shift(1);
            }
            PushedInputStream pushedInputStream2 = PushedInputStream.this;
            byte[] bArr = pushedInputStream2.buf;
            int i3 = pushedInputStream2.writepos;
            bArr[i3] = (byte) i2;
            pushedInputStream2.writepos = i3 + 1;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i2, int i3) {
            int i4;
            if (i2 >= 0) {
                if (i2 <= bArr.length && i3 >= 0 && (i4 = i2 + i3) <= bArr.length && i4 >= 0) {
                    if (i3 == 0) {
                        return;
                    }
                    PushedInputStream pushedInputStream = PushedInputStream.this;
                    if (pushedInputStream.writepos + i3 > pushedInputStream.buf.length) {
                        pushedInputStream.shift(i3);
                    }
                    PushedInputStream pushedInputStream2 = PushedInputStream.this;
                    System.arraycopy(bArr, i2, pushedInputStream2.buf, pushedInputStream2.writepos, i3);
                    PushedInputStream.this.writepos += i3;
                    return;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.writepos - this.readpos;
        if (i4 < i3) {
            fill(i3 - i4);
            i4 = this.writepos - this.readpos;
            if (i4 <= 0) {
                return -1;
            }
        }
        if (i4 < i3) {
            i3 = i4;
        }
        System.arraycopy(this.buf, this.readpos, bArr, i2, i3);
        this.readpos += i3;
        return i3;
    }
}

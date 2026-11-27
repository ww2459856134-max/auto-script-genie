package i.b.ha.a.c.k;

import i.b.ha.a.c.k.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e<T extends e<T>> extends OutputStream {
    protected int d;
    private byte[] e;
    private int g;
    private final List<byte[]> c = new ArrayList();
    private int f = -1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1483h = true;

    protected void a(int i2) {
        if (this.f < this.c.size() - 1) {
            this.g += this.e.length;
            int i3 = this.f + 1;
            this.f = i3;
            this.e = this.c.get(i3);
            return;
        }
        byte[] bArr = this.e;
        if (bArr == null) {
            if (i2 <= 0) {
                i2 = 1024;
            }
            this.g = 0;
        } else {
            i2 = Math.max(bArr.length << 1, i2 - this.g);
            this.g += this.e.length;
        }
        this.f++;
        byte[] bArrB = i.b.ha.a.c.e.b(i2);
        this.e = bArrB;
        this.c.add(bArrB);
    }

    protected void c() {
        this.d = 0;
        this.g = 0;
        this.f = 0;
        if (this.f1483h) {
            this.e = this.c.get(0);
            return;
        }
        this.e = null;
        int length = this.c.get(0).length;
        this.c.clear();
        a(length);
        this.f1483h = true;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract byte[] d();

    protected byte[] f() {
        int i2 = this.d;
        if (i2 == 0) {
            return i.b.ha.a.c.e.a;
        }
        byte[] bArrB = i.b.ha.a.c.e.b(i2);
        int i3 = 0;
        for (byte[] bArr : this.c) {
            int iMin = Math.min(bArr.length, i2);
            System.arraycopy(bArr, 0, bArrB, i3, iMin);
            i3 += iMin;
            i2 -= iMin;
            if (i2 == 0) {
                break;
            }
        }
        return bArrB;
    }

    protected <T extends InputStream> InputStream i(d<T> dVar) {
        int i2 = this.d;
        if (i2 == 0) {
            return i.b.ha.a.c.j.g.c;
        }
        ArrayList arrayList = new ArrayList(this.c.size());
        for (byte[] bArr : this.c) {
            int iMin = Math.min(bArr.length, i2);
            arrayList.add(dVar.a(bArr, 0, iMin));
            i2 -= iMin;
            if (i2 == 0) {
                break;
            }
        }
        this.f1483h = false;
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    protected int j(InputStream inputStream) throws IOException {
        int i2 = this.d - this.g;
        byte[] bArr = this.e;
        int i3 = inputStream.read(bArr, i2, bArr.length - i2);
        int i4 = 0;
        while (i3 != -1) {
            i4 += i3;
            i2 += i3;
            this.d += i3;
            byte[] bArr2 = this.e;
            if (i2 == bArr2.length) {
                a(bArr2.length);
                i2 = 0;
            }
            byte[] bArr3 = this.e;
            i3 = inputStream.read(bArr3, i2, bArr3.length - i2);
        }
        return i4;
    }

    protected void m(int i2) {
        int i3 = this.d;
        int i4 = i3 - this.g;
        if (i4 == this.e.length) {
            a(i3 + 1);
            i4 = 0;
        }
        this.e[i4] = (byte) i2;
        this.d++;
    }

    protected void n(byte[] bArr, int i2, int i3) {
        int i4 = this.d;
        int i5 = i4 + i3;
        int i6 = i4 - this.g;
        int i7 = i3;
        while (i7 > 0) {
            int iMin = Math.min(i7, this.e.length - i6);
            System.arraycopy(bArr, (i2 + i3) - i7, this.e, i6, iMin);
            i7 -= iMin;
            if (i7 > 0) {
                a(i5);
                i6 = 0;
            }
        }
        this.d = i5;
    }

    protected void o(OutputStream outputStream) throws IOException {
        int i2 = this.d;
        for (byte[] bArr : this.c) {
            int iMin = Math.min(bArr.length, i2);
            outputStream.write(bArr, 0, iMin);
            i2 -= iMin;
            if (i2 == 0) {
                return;
            }
        }
    }

    @Deprecated
    public String toString() {
        return new String(d(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public abstract void write(byte[] bArr, int i2, int i3);
}

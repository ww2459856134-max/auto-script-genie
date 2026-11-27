package k.a0.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public class j0 {

    /* renamed from: h, reason: collision with root package name */
    private static k.y.c f1813h = k.y.c.b(j0.class);
    private byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private s f;
    private k.w g;

    public j0(InputStream inputStream, k.w wVar) throws d, IOException {
        this.g = wVar;
        this.d = wVar.m();
        this.e = this.g.a();
        byte[] bArr = new byte[this.d];
        int i2 = inputStream.read(bArr);
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException();
        }
        int i3 = i2;
        while (i2 != -1) {
            if (i3 >= bArr.length) {
                byte[] bArr2 = new byte[bArr.length + this.e];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
            i2 = inputStream.read(bArr, i3, bArr.length - i3);
            i3 += i2;
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
        }
        if (i3 + 1 == 0) {
            throw new d(d.e);
        }
        s sVar = new s(bArr, wVar);
        try {
            this.a = sVar.k("workbook");
        } catch (d unused) {
            this.a = sVar.k("book");
        }
        if (!this.g.q() && sVar.e() > k.x.g.c.length) {
            this.f = sVar;
        }
        if (this.g.j()) {
            return;
        }
        System.gc();
    }

    public void a() {
        this.a = null;
    }

    s b() {
        return this.f;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.b < this.a.length + (-4);
    }

    f2 e() {
        return new f2(this.a, this.b, this);
    }

    f2 f() {
        int i2 = this.b;
        f2 f2Var = new f2(this.a, this.b, this);
        this.b = i2;
        return f2Var;
    }

    public byte[] g(int i2, int i3) {
        byte[] bArr = new byte[i3];
        try {
            System.arraycopy(this.a, i2, bArr, 0, i3);
            return bArr;
        } catch (ArrayIndexOutOfBoundsException e) {
            f1813h.a("Array index out of bounds at position " + i2 + " record length " + i3);
            throw e;
        }
    }

    public void h() {
        this.b = this.c;
    }

    public void i(int i2) {
        this.c = this.b;
        this.b = i2;
    }

    public void j(int i2) {
        this.b += i2;
    }
}

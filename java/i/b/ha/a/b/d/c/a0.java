package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class a0 extends InputStream implements i.b.ha.a.b.f.h {
    private long A;
    private final InputStream c;
    private y d;
    private final int e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private x f1399h;

    /* renamed from: i, reason: collision with root package name */
    private x f1400i;

    /* renamed from: j, reason: collision with root package name */
    private x f1401j;

    /* renamed from: k, reason: collision with root package name */
    private final z f1402k = new z(32768);
    private long t;

    a0(int i2, int i3, InputStream inputStream) {
        if (i2 != 4096 && i2 != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        }
        if (i3 != 2 && i3 != 3) {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
        this.e = i2;
        this.f = i3;
        this.g = i3;
        this.c = inputStream;
    }

    private void d() throws IOException {
        f();
        int iN = this.d.n();
        if (iN == -1) {
            return;
        }
        if (iN == 1) {
            x xVar = this.f1399h;
            int iC = xVar != null ? xVar.c(this.d) : this.d.s();
            if (iC == -1) {
                return;
            }
            this.f1402k.d(iC);
            return;
        }
        int i2 = this.e == 4096 ? 6 : 7;
        int iQ = (int) this.d.q(i2);
        int iC2 = this.f1401j.c(this.d);
        if (iC2 != -1 || iQ > 0) {
            int i3 = (iC2 << i2) | iQ;
            int iC3 = this.f1400i.c(this.d);
            if (iC3 == 63) {
                long jQ = this.d.q(8);
                if (jQ == -1) {
                    return;
                } else {
                    iC3 = i.b.ha.a.b.f.f.a(iC3, jQ);
                }
            }
            this.f1402k.b(i3 + 1, iC3 + this.g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() throws IOException {
        if (this.d == null) {
            i.b.ha.a.c.j.e eVar = ((i.b.ha.a.c.j.d) i.b.ha.a.c.j.e.j().h(i.b.ha.a.c.j.f.j(this.c))).get();
            try {
                if (this.f == 3) {
                    this.f1399h = x.b(eVar, 256);
                }
                this.f1400i = x.b(eVar, 64);
                this.f1401j = x.b(eVar, 64);
                this.A += eVar.m();
                if (eVar != null) {
                    eVar.close();
                }
                this.d = new y(this.c);
            } catch (Throwable th) {
                if (eVar != null) {
                    try {
                        eVar.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        return this.d.j() + this.A;
    }

    @Override // i.b.ha.a.b.f.h
    public long c() {
        return this.t;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.f1402k.a()) {
            try {
                d();
            } catch (IllegalArgumentException e) {
                throw new IOException("bad IMPLODE stream", e);
            }
        }
        int iC = this.f1402k.c();
        if (iC > -1) {
            this.t++;
        }
        return iC;
    }
}

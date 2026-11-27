package k.b0.v;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class l0 {
    private g0 a;
    private OutputStream b;
    private int c;
    private int d;
    private k.w e;
    k.a0.a.s f;

    static {
        k.y.c.b(l0.class);
    }

    l0(OutputStream outputStream, k.w wVar, k.a0.a.s sVar) throws IOException {
        this.b = outputStream;
        this.e = wVar;
        this.f = sVar;
        b();
    }

    private void b() throws IOException {
        if (this.e.v()) {
            this.a = new m0(this.e.u());
            return;
        }
        this.c = this.e.m();
        this.d = this.e.a();
        this.a = new i1(this.c, this.d);
    }

    void a(boolean z) throws d1, IOException {
        g0 g0Var = this.a;
        new t(g0Var, g0Var.c(), this.b, this.f).f();
        this.b.flush();
        this.a.close();
        if (z) {
            this.b.close();
        }
        this.a = null;
        if (this.e.j()) {
            return;
        }
        System.gc();
    }

    int c() throws IOException {
        return this.a.c();
    }

    void d(byte[] bArr, int i2) throws IOException {
        this.a.a(bArr, i2);
    }

    public void e(k.x.l lVar) throws IOException {
        this.a.write(lVar.a());
    }
}

package l.a.a.e.b;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import l.a.a.f.q;
import l.a.a.f.s;

/* loaded from: classes.dex */
public class l extends OutputStream {
    private l.a.a.f.l C;
    private boolean D;
    private d c;
    private char[] d;
    private q e;
    private c f;
    private l.a.a.f.i g;

    /* renamed from: h, reason: collision with root package name */
    private l.a.a.f.j f2214h;

    /* renamed from: i, reason: collision with root package name */
    private l.a.a.d.a f2215i = new l.a.a.d.a();

    /* renamed from: j, reason: collision with root package name */
    private l.a.a.d.e f2216j = new l.a.a.d.e();

    /* renamed from: k, reason: collision with root package name */
    private CRC32 f2217k = new CRC32();
    private l.a.a.i.g t = new l.a.a.i.g();
    private long A = 0;
    private boolean G = true;

    public l(OutputStream outputStream, char[] cArr, l.a.a.f.l lVar, q qVar) throws IOException {
        if (lVar.a() < 512) {
            throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        d dVar = new d(outputStream);
        this.c = dVar;
        this.d = cArr;
        this.C = lVar;
        this.e = n(qVar, dVar);
        this.D = false;
        u();
    }

    private s a(s sVar) {
        s sVar2 = new s(sVar);
        if (l.a.a.i.d.x(sVar.k())) {
            sVar2.E(false);
            sVar2.w(l.a.a.f.t.d.STORE);
            sVar2.y(false);
            sVar2.B(0L);
        }
        if (sVar.l() <= 0) {
            sVar2.D(System.currentTimeMillis());
        }
        return sVar2;
    }

    private void d() throws IOException {
        if (this.D) {
            throw new IOException("Stream is closed");
        }
    }

    private void f(s sVar) throws IOException {
        l.a.a.f.i iVarD = this.f2215i.d(sVar, this.c.m(), this.c.c(), this.C.b(), this.t);
        this.g = iVarD;
        iVarD.X(this.c.i());
        l.a.a.f.j jVarF = this.f2215i.f(this.g);
        this.f2214h = jVarF;
        this.f2216j.p(this.e, jVarF, this.c, this.C.b());
    }

    private b<?> i(k kVar, s sVar) throws IOException {
        if (!sVar.o()) {
            return new g(kVar, sVar, null);
        }
        char[] cArr = this.d;
        if (cArr == null || cArr.length == 0) {
            throw new l.a.a.c.b("password not set");
        }
        if (sVar.f() == l.a.a.f.t.e.AES) {
            return new a(kVar, sVar, this.d, this.C.c());
        }
        if (sVar.f() == l.a.a.f.t.e.ZIP_STANDARD) {
            return new m(kVar, sVar, this.d, this.C.c());
        }
        l.a.a.f.t.e eVarF = sVar.f();
        l.a.a.f.t.e eVar = l.a.a.f.t.e.ZIP_STANDARD_VARIANT_STRONG;
        if (eVarF != eVar) {
            throw new l.a.a.c.b("Invalid encryption method");
        }
        throw new l.a.a.c.b(eVar + " encryption method is not supported");
    }

    private c j(b<?> bVar, s sVar) {
        return sVar.d() == l.a.a.f.t.d.DEFLATE ? new e(bVar, sVar.c(), this.C.a()) : new j(bVar);
    }

    private c m(s sVar) throws IOException {
        return j(i(new k(this.c), sVar), sVar);
    }

    private q n(q qVar, d dVar) {
        if (qVar == null) {
            qVar = new q();
        }
        if (dVar.m()) {
            qVar.l(true);
            qVar.m(dVar.j());
        }
        return qVar;
    }

    private void p() throws IOException {
        this.A = 0L;
        this.f2217k.reset();
        this.f.close();
    }

    private void q(s sVar) {
        if (l.a.a.i.i.k(sVar.k())) {
            throw new IllegalArgumentException("fileNameInZip is null or empty");
        }
        if (sVar.d() == l.a.a.f.t.d.STORE && sVar.h() < 0 && !l.a.a.i.d.x(sVar.k()) && sVar.u()) {
            throw new IllegalArgumentException("uncompressed size should be set for zip entries of compression type store");
        }
    }

    private boolean s(l.a.a.f.i iVar) {
        if (iVar.s() && iVar.g().equals(l.a.a.f.t.e.AES)) {
            return iVar.c().d().equals(l.a.a.f.t.b.ONE);
        }
        return true;
    }

    private void u() throws IOException {
        if (this.c.m()) {
            this.t.o(this.c, (int) l.a.a.d.c.SPLIT_ZIP.a());
        }
    }

    public l.a.a.f.i c() throws IOException {
        this.f.a();
        long jC = this.f.c();
        this.g.v(jC);
        this.f2214h.v(jC);
        this.g.J(this.A);
        this.f2214h.J(this.A);
        if (s(this.g)) {
            this.g.x(this.f2217k.getValue());
            this.f2214h.x(this.f2217k.getValue());
        }
        this.e.c().add(this.f2214h);
        this.e.a().a().add(this.g);
        if (this.f2214h.q()) {
            this.f2216j.n(this.f2214h, this.c);
        }
        p();
        this.G = true;
        return this.g;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.G) {
            c();
        }
        this.e.b().n(this.c.f());
        this.f2216j.d(this.e, this.c, this.C.b());
        this.c.close();
        this.D = true;
    }

    public void o(s sVar) throws IOException {
        q(sVar);
        s sVarA = a(sVar);
        f(sVarA);
        this.f = m(sVarA);
        this.G = false;
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        d();
        this.f2217k.update(bArr, i2, i3);
        this.f.write(bArr, i2, i3);
        this.A += i3;
    }
}

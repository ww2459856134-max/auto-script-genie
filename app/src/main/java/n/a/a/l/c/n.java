package n.a.a.l.c;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import n.a.a.o.j1;
import n.a.a.o.z0;

/* loaded from: classes.dex */
public class n {

    /* renamed from: l, reason: collision with root package name */
    private static final Charset f2311l = StandardCharsets.UTF_8;
    private String b;
    private String c;
    private short d;
    private String f;
    private byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private String f2312h;

    /* renamed from: i, reason: collision with root package name */
    private String f2313i;

    /* renamed from: j, reason: collision with root package name */
    private String f2314j;

    /* renamed from: k, reason: collision with root package name */
    private m f2315k;
    private short a = 2;
    private short e = 3;

    public n(String str, String str2, String str3, byte[] bArr) {
        l(str);
        k(str2);
        i(str3);
        this.f2312h = str3;
        j(bArr);
        this.f2315k = m.parsed;
    }

    public String a() {
        return this.f;
    }

    public byte[] b() {
        return this.g;
    }

    public int c() {
        return this.g.length;
    }

    public String d() {
        return this.c;
    }

    public short e() {
        return this.a;
    }

    public short f() {
        return this.d;
    }

    public String g() {
        return this.b;
    }

    public short h() {
        return this.e;
    }

    public void i(String str) {
        this.f = str;
    }

    public void j(byte[] bArr) {
        this.g = (byte[]) bArr.clone();
    }

    public void k(String str) {
        this.c = str;
    }

    public void l(String str) {
        this.b = str;
    }

    public void m(OutputStream outputStream) throws IOException {
        z0 z0Var = new z0(outputStream);
        int i2 = l.a[this.f2315k.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                z0Var.a(c());
                outputStream.write(b());
                return;
            } else {
                z0Var.a(c() + 2);
                z0Var.c(e());
                outputStream.write(b());
                return;
            }
        }
        i.b.ha.a.c.k.j jVar = i.b.ha.a.c.k.j.p().get();
        z0 z0Var2 = new z0(jVar);
        try {
            z0Var2.c(e());
            String strG = g();
            Charset charset = f2311l;
            z0Var2.write(strG.getBytes(charset));
            z0Var2.write(0);
            z0Var2.write(d().getBytes(charset));
            z0Var2.write(0);
            z0Var2.c(f());
            z0Var2.c(h());
            z0Var2.a(a().length() + 1);
            z0Var2.write(a().getBytes(charset));
            z0Var2.write(0);
            z0Var2.a(c());
            z0Var2.write(b());
            if (this.f2312h == null || this.f2313i == null || this.f2314j == null) {
                z0Var2.c(0);
            } else {
                z0Var2.d(r2.length());
                z0Var2.write(j1.d(this.f2312h));
                z0Var2.d(this.f2313i.length());
                z0Var2.write(j1.d(this.f2313i));
                z0Var2.d(this.f2314j.length());
                z0Var2.write(j1.d(this.f2314j));
            }
            z0Var2.close();
            z0Var.a(jVar.w());
            jVar.z(outputStream);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    z0Var2.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}

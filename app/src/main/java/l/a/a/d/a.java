package l.a.a.d;

import java.nio.charset.Charset;
import l.a.a.f.s;
import l.a.a.i.i;
import l.a.a.i.j;

/* loaded from: classes.dex */
public class a {
    private int a(String str, Charset charset) {
        return d.b(str, charset).length;
    }

    private byte[] b(boolean z, s sVar, Charset charset) {
        byte[] bArr = new byte[2];
        bArr[0] = e(z, sVar);
        if (charset == null || l.a.a.i.e.b.equals(charset)) {
            bArr[1] = l.a.a.i.a.b(bArr[1], 3);
        }
        return bArr;
    }

    private l.a.a.f.a c(s sVar) throws l.a.a.c.b {
        l.a.a.f.a aVar = new l.a.a.f.a();
        if (sVar.b() != null) {
            aVar.i(sVar.b());
        }
        l.a.a.f.t.a aVarA = sVar.a();
        l.a.a.f.t.a aVar2 = l.a.a.f.t.a.KEY_STRENGTH_128;
        if (aVarA == aVar2) {
            aVar.h(aVar2);
        } else {
            l.a.a.f.t.a aVarA2 = sVar.a();
            l.a.a.f.t.a aVar3 = l.a.a.f.t.a.KEY_STRENGTH_192;
            if (aVarA2 == aVar3) {
                aVar.h(aVar3);
            } else {
                l.a.a.f.t.a aVarA3 = sVar.a();
                l.a.a.f.t.a aVar4 = l.a.a.f.t.a.KEY_STRENGTH_256;
                if (aVarA3 != aVar4) {
                    throw new l.a.a.c.b("invalid AES key strength");
                }
                aVar.h(aVar4);
            }
        }
        aVar.j(sVar.d());
        return aVar;
    }

    private byte e(boolean z, s sVar) {
        byte b = z ? l.a.a.i.a.b((byte) 0, 0) : (byte) 0;
        if (l.a.a.f.t.d.DEFLATE.equals(sVar.d())) {
            if (l.a.a.f.t.c.NORMAL.equals(sVar.c())) {
                b = l.a.a.i.a.c(l.a.a.i.a.c(b, 1), 2);
            } else if (l.a.a.f.t.c.MAXIMUM.equals(sVar.c())) {
                b = l.a.a.i.a.c(l.a.a.i.a.b(b, 1), 2);
            } else if (l.a.a.f.t.c.FAST.equals(sVar.c())) {
                b = l.a.a.i.a.b(l.a.a.i.a.c(b, 1), 2);
            } else if (l.a.a.f.t.c.FASTEST.equals(sVar.c()) || l.a.a.f.t.c.ULTRA.equals(sVar.c())) {
                b = l.a.a.i.a.b(l.a.a.i.a.b(b, 1), 2);
            }
        }
        return sVar.u() ? l.a.a.i.a.b(b, 3) : b;
    }

    private String g(String str) throws l.a.a.c.b {
        if (i.j(str)) {
            return str;
        }
        throw new l.a.a.c.b("fileNameInZip is null or empty");
    }

    public l.a.a.f.i d(s sVar, boolean z, int i2, Charset charset, l.a.a.i.g gVar) throws l.a.a.c.b {
        l.a.a.f.i iVar = new l.a.a.f.i();
        iVar.b(c.CENTRAL_DIRECTORY);
        iVar.Y(j.a(sVar, gVar));
        iVar.K(j.b(sVar).a());
        if (sVar.o() && sVar.f() == l.a.a.f.t.e.AES) {
            iVar.w(l.a.a.f.t.d.AES_INTERNAL_ONLY);
            iVar.u(c(sVar));
            iVar.D(iVar.i() + 11);
        } else {
            iVar.w(sVar.d());
        }
        if (sVar.o()) {
            if (sVar.f() == null || sVar.f() == l.a.a.f.t.e.NONE) {
                throw new l.a.a.c.b("Encryption method has to be set when encryptFiles flag is set in zip parameters");
            }
            iVar.A(true);
            iVar.B(sVar.f());
        }
        String strK = sVar.k();
        g(strK);
        iVar.E(strK);
        iVar.F(a(strK, charset));
        if (!z) {
            i2 = 0;
        }
        iVar.S(i2);
        iVar.I(i.h(sVar.l()));
        boolean zX = l.a.a.i.d.x(strK);
        iVar.z(zX);
        iVar.T(l.a.a.i.d.i(zX));
        if (sVar.u() && sVar.h() == -1) {
            iVar.J(0L);
        } else {
            iVar.J(sVar.h());
        }
        if (sVar.o() && sVar.f() == l.a.a.f.t.e.ZIP_STANDARD) {
            iVar.x(sVar.g());
        }
        iVar.H(b(iVar.s(), sVar, charset));
        iVar.y(sVar.u());
        iVar.U(sVar.j());
        return iVar;
    }

    public l.a.a.f.j f(l.a.a.f.i iVar) {
        l.a.a.f.j jVar = new l.a.a.f.j();
        jVar.b(c.LOCAL_FILE_HEADER);
        jVar.K(iVar.o());
        jVar.w(iVar.e());
        jVar.I(iVar.m());
        jVar.J(iVar.n());
        jVar.F(iVar.k());
        jVar.E(iVar.j());
        jVar.A(iVar.s());
        jVar.B(iVar.g());
        jVar.u(iVar.c());
        jVar.x(iVar.f());
        jVar.v(iVar.d());
        jVar.H((byte[]) iVar.l().clone());
        jVar.y(iVar.q());
        jVar.D(iVar.i());
        return jVar;
    }
}

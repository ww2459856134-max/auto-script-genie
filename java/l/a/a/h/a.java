package l.a.a.h;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l.a.a.f.q;
import l.a.a.f.r;
import l.a.a.f.s;

/* loaded from: classes.dex */
public abstract class a<T> extends l<T> {
    private final q d;
    private final char[] e;
    private final l.a.a.d.e f;

    a(q qVar, char[] cArr, l.a.a.d.e eVar, k kVar) {
        super(kVar);
        this.d = qVar;
        this.e = cArr;
        this.f = eVar;
    }

    private void k(File file, l.a.a.e.b.l lVar, s sVar, l.a.a.e.b.i iVar, l.a.a.g.d dVar, byte[] bArr) throws IOException {
        lVar.o(sVar);
        if (file.exists() && !file.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    lVar.write(bArr, 0, i2);
                    dVar.l(i2);
                    j();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            fileInputStream.close();
        }
        q(lVar, iVar, file, false);
    }

    private boolean m(s sVar) {
        return r.INCLUDE_LINK_ONLY.equals(sVar.n()) || r.INCLUDE_LINK_AND_LINKED_FILE.equals(sVar.n());
    }

    private void n(File file, l.a.a.e.b.l lVar, s sVar, l.a.a.e.b.i iVar) throws IOException {
        s sVar2 = new s(sVar);
        sVar2.C(v(sVar.k(), file.getName()));
        sVar2.y(false);
        sVar2.w(l.a.a.f.t.d.STORE);
        lVar.o(sVar2);
        lVar.write(l.a.a.i.d.y(file).getBytes());
        q(lVar, iVar, file, true);
    }

    private s p(s sVar, File file, l.a.a.g.d dVar) throws IOException {
        s sVar2 = new s(sVar);
        if (file.isDirectory()) {
            sVar2.B(0L);
        } else {
            sVar2.B(file.length());
        }
        if (sVar.l() <= 0) {
            sVar2.D(file.lastModified());
        }
        sVar2.E(false);
        if (!l.a.a.i.i.j(sVar.k())) {
            sVar2.C(l.a.a.i.d.p(file, sVar));
        }
        if (file.isDirectory()) {
            sVar2.w(l.a.a.f.t.d.STORE);
            sVar2.z(l.a.a.f.t.e.NONE);
            sVar2.y(false);
        } else {
            if (sVar2.o() && sVar2.f() == l.a.a.f.t.e.ZIP_STANDARD) {
                dVar.g(l.a.a.g.c.CALCULATE_CRC);
                sVar2.A(l.a.a.i.b.a(file, dVar));
                dVar.g(l.a.a.g.c.ADD_ENTRY);
            }
            if (file.length() == 0) {
                sVar2.w(l.a.a.f.t.d.STORE);
            }
        }
        return sVar2;
    }

    private void q(l.a.a.e.b.l lVar, l.a.a.e.b.i iVar, File file, boolean z) throws IOException {
        l.a.a.f.i iVarC = lVar.c();
        byte[] bArrJ = l.a.a.i.d.j(file);
        if (!z) {
            bArrJ[3] = l.a.a.i.a.c(bArrJ[3], 5);
        }
        iVarC.T(bArrJ);
        w(iVarC, iVar);
    }

    private List<File> u(List<File> list, s sVar, l.a.a.g.d dVar, l.a.a.f.l lVar) throws IOException {
        ArrayList arrayList = new ArrayList(list);
        if (!this.d.g().exists()) {
            return arrayList;
        }
        for (File file : list) {
            if (!l.a.a.i.i.j(file.getName())) {
                arrayList.remove(file);
            }
            l.a.a.f.i iVarC = l.a.a.d.d.c(this.d, l.a.a.i.d.p(file, sVar));
            if (iVarC != null) {
                if (sVar.q()) {
                    dVar.g(l.a.a.g.c.REMOVE_ENTRY);
                    t(iVarC, dVar, lVar);
                    j();
                    dVar.g(l.a.a.g.c.ADD_ENTRY);
                } else {
                    arrayList.remove(file);
                }
            }
        }
        return arrayList;
    }

    private String v(String str, String str2) {
        if (!str.contains("/")) {
            return str2;
        }
        return str.substring(0, str.lastIndexOf("/") + 1) + str2;
    }

    @Override // l.a.a.h.l
    protected l.a.a.g.c g() {
        return l.a.a.g.c.ADD_ENTRY;
    }

    void l(List<File> list, l.a.a.g.d dVar, s sVar, l.a.a.f.l lVar) throws IOException {
        l.a.a.i.d.e(list, sVar.n());
        byte[] bArr = new byte[lVar.a()];
        List<File> listU = u(list, sVar, dVar, lVar);
        l.a.a.e.b.i iVar = new l.a.a.e.b.i(this.d.g(), this.d.d());
        try {
            l.a.a.e.b.l lVarS = s(iVar, lVar);
            try {
                for (File file : listU) {
                    j();
                    s sVarP = p(sVar, file, dVar);
                    dVar.h(file.getAbsolutePath());
                    if (l.a.a.i.d.u(file) && m(sVarP)) {
                        n(file, lVarS, sVarP, iVar);
                        if (r.INCLUDE_LINK_ONLY.equals(sVarP.n())) {
                        }
                    }
                    k(file, lVarS, sVarP, iVar, dVar, bArr);
                }
                if (lVarS != null) {
                    lVarS.close();
                }
                iVar.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                iVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    long o(List<File> list, s sVar) throws l.a.a.c.b {
        long length = 0;
        for (File file : list) {
            if (file.exists()) {
                length += (sVar.o() && sVar.f() == l.a.a.f.t.e.ZIP_STANDARD) ? file.length() * 2 : file.length();
                l.a.a.f.i iVarC = l.a.a.d.d.c(r(), l.a.a.i.d.p(file, sVar));
                if (iVarC != null) {
                    length += r().g().length() - iVarC.d();
                }
            }
        }
        return length;
    }

    protected q r() {
        return this.d;
    }

    l.a.a.e.b.l s(l.a.a.e.b.i iVar, l.a.a.f.l lVar) throws IOException {
        if (this.d.g().exists()) {
            iVar.n(l.a.a.d.d.e(this.d));
        }
        return new l.a.a.e.b.l(iVar, this.e, lVar, this.d);
    }

    void t(l.a.a.f.i iVar, l.a.a.g.d dVar, l.a.a.f.l lVar) throws l.a.a.c.b {
        new p(this.d, this.f, new k(null, false, dVar)).e(new o(Collections.singletonList(iVar.j()), lVar));
    }

    void w(l.a.a.f.i iVar, l.a.a.e.b.i iVar2) throws IOException {
        this.f.k(iVar, r(), iVar2);
    }

    void x(s sVar) throws l.a.a.c.b {
        if (sVar == null) {
            throw new l.a.a.c.b("cannot validate zip parameters");
        }
        if (sVar.d() != l.a.a.f.t.d.STORE && sVar.d() != l.a.a.f.t.d.DEFLATE) {
            throw new l.a.a.c.b("unsupported compression type");
        }
        if (!sVar.o()) {
            sVar.z(l.a.a.f.t.e.NONE);
        } else {
            if (sVar.f() == l.a.a.f.t.e.NONE) {
                throw new l.a.a.c.b("Encryption method has to be set, when encrypt files flag is set");
            }
            char[] cArr = this.e;
            if (cArr == null || cArr.length <= 0) {
                throw new l.a.a.c.b("input password is empty or null");
            }
        }
    }
}

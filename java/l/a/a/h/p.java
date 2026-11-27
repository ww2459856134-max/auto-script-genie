package l.a.a.h;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import l.a.a.f.q;

/* loaded from: classes.dex */
public class p extends d<o> {
    private final q d;
    private final l.a.a.d.e e;

    public p(q qVar, l.a.a.d.e eVar, k kVar) {
        super(kVar);
        this.d = qVar;
        this.e = eVar;
    }

    private List<String> u(List<String> list) throws l.a.a.c.b {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (l.a.a.d.d.c(this.d, str) != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private long v(long j2) {
        if (j2 != Long.MIN_VALUE) {
            return -j2;
        }
        throw new ArithmeticException("long overflow");
    }

    private boolean w(l.a.a.f.i iVar, List<String> list) {
        for (String str : list) {
            if ((str.endsWith("/") && iVar.j().startsWith(str)) || iVar.j().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void x(List<l.a.a.f.i> list, l.a.a.f.i iVar, long j2) throws l.a.a.c.b {
        r(list, this.d, iVar, v(j2));
        l.a.a.f.f fVarB = this.d.b();
        fVarB.n(fVarB.g() - j2);
        fVarB.p(fVarB.h() - 1);
        if (fVarB.i() > 0) {
            fVarB.q(fVarB.i() - 1);
        }
        if (this.d.i()) {
            this.d.f().o(this.d.f().e() - j2);
            this.d.f().s(this.d.f().h() - 1);
            this.d.e().g(this.d.e().d() - j2);
        }
    }

    @Override // l.a.a.h.l
    protected l.a.a.g.c g() {
        return l.a.a.g.c.REMOVE_ENTRY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public long d(o oVar) {
        return this.d.g().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void f(o oVar, l.a.a.g.d dVar) throws IOException {
        List<l.a.a.f.i> list;
        if (this.d.h()) {
            throw new l.a.a.c.b("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        List<String> listU = u(oVar.b);
        if (listU.isEmpty()) {
            return;
        }
        File fileP = p(this.d.g().getPath());
        try {
            l.a.a.e.b.i iVar = new l.a.a.e.b.i(fileP);
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.d.g(), l.a.a.f.t.f.READ.a());
                try {
                    List<l.a.a.f.i> listL = l(this.d.a().a());
                    long j2 = 0;
                    for (l.a.a.f.i iVar2 : listL) {
                        long jO = o(listL, iVar2, this.d) - iVar.a();
                        if (w(iVar2, listU)) {
                            x(listL, iVar2, jO);
                            if (!this.d.a().a().remove(iVar2)) {
                                throw new l.a.a.c.b("Could not remove entry from list of central directory headers");
                            }
                            j2 += jO;
                            list = listL;
                        } else {
                            list = listL;
                            super.m(randomAccessFile, iVar, j2, jO, dVar, oVar.a.a());
                            j2 += jO;
                        }
                        j();
                        listL = list;
                    }
                    this.e.d(this.d, iVar, oVar.a.b());
                    randomAccessFile.close();
                    iVar.close();
                    k(true, this.d.g(), fileP);
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            k(false, this.d.g(), fileP);
            throw th;
        }
    }
}

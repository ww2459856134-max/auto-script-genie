package l.a.a.d;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import l.a.a.f.h;
import l.a.a.f.i;
import l.a.a.f.j;
import l.a.a.f.m;
import l.a.a.f.n;
import l.a.a.f.q;

/* loaded from: classes.dex */
public class e {
    private final l.a.a.i.g a = new l.a.a.i.g();
    private final byte[] b = new byte[8];
    private final byte[] c = new byte[4];

    private n a(q qVar, int i2, long j2) throws l.a.a.c.b {
        n nVar = new n();
        nVar.b(c.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
        nVar.q(44L);
        if (qVar.a() != null && qVar.a().a() != null && qVar.a().a().size() > 0) {
            i iVar = qVar.a().a().get(0);
            nVar.t(iVar.R());
            nVar.u(iVar.o());
        }
        nVar.m(qVar.b().d());
        nVar.n(qVar.b().e());
        long size = qVar.a().a().size();
        nVar.s(qVar.h() ? c(qVar.a().a(), qVar.b().d()) : size);
        nVar.r(size);
        nVar.p(i2);
        nVar.o(j2);
        return nVar;
    }

    private int b(i iVar, boolean z) {
        int iE = z ? 32 : 0;
        if (iVar.c() != null) {
            iE += 11;
        }
        if (iVar.h() != null) {
            for (h hVar : iVar.h()) {
                if (hVar.d() != c.AES_EXTRA_DATA_RECORD.a() && hVar.d() != c.ZIP64_EXTRA_FIELD_SIGNATURE.a()) {
                    iE += hVar.e() + 4;
                }
            }
        }
        return iE;
    }

    private long c(List<i> list, int i2) throws l.a.a.c.b {
        if (list == null) {
            throw new l.a.a.c.b("file headers are null, cannot calculate number of entries on this disk");
        }
        int i3 = 0;
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().N() == i2) {
                i3++;
            }
        }
        return i3;
    }

    private int e(OutputStream outputStream) {
        return outputStream instanceof l.a.a.e.b.i ? ((l.a.a.e.b.i) outputStream).c() : ((l.a.a.e.b.d) outputStream).c();
    }

    private long f(q qVar) {
        return (!qVar.i() || qVar.f() == null || qVar.f().e() == -1) ? qVar.b().g() : qVar.f().e();
    }

    private boolean g(OutputStream outputStream) {
        if (outputStream instanceof l.a.a.e.b.i) {
            return ((l.a.a.e.b.i) outputStream).m();
        }
        if (outputStream instanceof l.a.a.e.b.d) {
            return ((l.a.a.e.b.d) outputStream).m();
        }
        return false;
    }

    private boolean h(i iVar) {
        return iVar.d() >= 4294967295L || iVar.n() >= 4294967295L || iVar.Q() >= 4294967295L || iVar.N() >= 65535;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i(q qVar, OutputStream outputStream) throws IOException {
        int iC;
        if (outputStream instanceof l.a.a.e.b.h) {
            l.a.a.e.b.h hVar = (l.a.a.e.b.h) outputStream;
            qVar.b().n(hVar.a());
            iC = hVar.c();
        } else {
            iC = 0;
        }
        if (qVar.i()) {
            if (qVar.f() == null) {
                qVar.o(new n());
            }
            if (qVar.e() == null) {
                qVar.n(new m());
            }
            qVar.f().o(qVar.b().g());
            qVar.e().f(iC);
            qVar.e().h(iC + 1);
        }
        qVar.b().k(iC);
        qVar.b().l(iC);
    }

    private void j(l.a.a.e.b.i iVar, i iVar2) throws IOException {
        if (iVar2.n() < 4294967295L) {
            this.a.r(this.b, 0, iVar2.d());
            iVar.write(this.b, 0, 4);
            this.a.r(this.b, 0, iVar2.n());
            iVar.write(this.b, 0, 4);
            return;
        }
        this.a.r(this.b, 0, 4294967295L);
        iVar.write(this.b, 0, 4);
        iVar.write(this.b, 0, 4);
        int iK = iVar2.k() + 4 + 2 + 2;
        if (iVar.o(iK) == iK) {
            this.a.q(iVar, iVar2.n());
            this.a.q(iVar, iVar2.d());
        } else {
            throw new l.a.a.c.b("Unable to skip " + iK + " bytes to update LFH");
        }
    }

    private void l(q qVar, ByteArrayOutputStream byteArrayOutputStream, l.a.a.i.g gVar, Charset charset) throws l.a.a.c.b {
        if (qVar.a() == null || qVar.a().a() == null || qVar.a().a().size() <= 0) {
            return;
        }
        Iterator<i> it = qVar.a().a().iterator();
        while (it.hasNext()) {
            o(qVar, it.next(), byteArrayOutputStream, gVar, charset);
        }
    }

    private void m(q qVar, int i2, long j2, ByteArrayOutputStream byteArrayOutputStream, l.a.a.i.g gVar, Charset charset) throws IOException {
        byte[] bArr = new byte[8];
        gVar.o(byteArrayOutputStream, (int) c.END_OF_CENTRAL_DIRECTORY.a());
        gVar.s(byteArrayOutputStream, qVar.b().d());
        gVar.s(byteArrayOutputStream, qVar.b().e());
        long size = qVar.a().a().size();
        long jC = qVar.h() ? c(qVar.a().a(), qVar.b().d()) : size;
        if (jC > 65535) {
            jC = 65535;
        }
        gVar.s(byteArrayOutputStream, (int) jC);
        if (size > 65535) {
            size = 65535;
        }
        gVar.s(byteArrayOutputStream, (int) size);
        gVar.o(byteArrayOutputStream, i2);
        if (j2 > 4294967295L) {
            gVar.r(bArr, 0, 4294967295L);
            byteArrayOutputStream.write(bArr, 0, 4);
        } else {
            gVar.r(bArr, 0, j2);
            byteArrayOutputStream.write(bArr, 0, 4);
        }
        String strC = qVar.b().c();
        if (!l.a.a.i.i.j(strC)) {
            gVar.s(byteArrayOutputStream, 0);
            return;
        }
        byte[] bArrB = d.b(strC, charset);
        gVar.s(byteArrayOutputStream, bArrB.length);
        byteArrayOutputStream.write(bArrB);
    }

    private void o(q qVar, i iVar, ByteArrayOutputStream byteArrayOutputStream, l.a.a.i.g gVar, Charset charset) throws l.a.a.c.b {
        byte[] bArr;
        if (iVar == null) {
            throw new l.a.a.c.b("input parameters is null, cannot write local file header");
        }
        try {
            byte[] bArr2 = {0, 0};
            boolean zH = h(iVar);
            gVar.o(byteArrayOutputStream, (int) iVar.a().a());
            gVar.s(byteArrayOutputStream, iVar.R());
            gVar.s(byteArrayOutputStream, iVar.o());
            byteArrayOutputStream.write(iVar.l());
            gVar.s(byteArrayOutputStream, iVar.e().a());
            gVar.r(this.b, 0, iVar.m());
            byteArrayOutputStream.write(this.b, 0, 4);
            gVar.r(this.b, 0, iVar.f());
            byteArrayOutputStream.write(this.b, 0, 4);
            if (zH) {
                gVar.r(this.b, 0, 4294967295L);
                byteArrayOutputStream.write(this.b, 0, 4);
                byteArrayOutputStream.write(this.b, 0, 4);
                qVar.p(true);
                bArr = bArr2;
            } else {
                bArr = bArr2;
                gVar.r(this.b, 0, iVar.d());
                byteArrayOutputStream.write(this.b, 0, 4);
                gVar.r(this.b, 0, iVar.n());
                byteArrayOutputStream.write(this.b, 0, 4);
            }
            byte[] bArrB = new byte[0];
            if (l.a.a.i.i.j(iVar.j())) {
                bArrB = d.b(iVar.j(), charset);
            }
            gVar.s(byteArrayOutputStream, bArrB.length);
            byte[] bArr3 = new byte[4];
            if (zH) {
                gVar.r(this.b, 0, 4294967295L);
                System.arraycopy(this.b, 0, bArr3, 0, 4);
            } else {
                gVar.r(this.b, 0, iVar.Q());
                System.arraycopy(this.b, 0, bArr3, 0, 4);
            }
            gVar.s(byteArrayOutputStream, b(iVar, zH));
            String strP = iVar.P();
            byte[] bArrB2 = new byte[0];
            if (l.a.a.i.i.j(strP)) {
                bArrB2 = d.b(strP, charset);
            }
            gVar.s(byteArrayOutputStream, bArrB2.length);
            if (zH) {
                gVar.p(this.c, 0, 65535);
                byteArrayOutputStream.write(this.c, 0, 2);
            } else {
                gVar.s(byteArrayOutputStream, iVar.N());
            }
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(iVar.O());
            byteArrayOutputStream.write(bArr3);
            if (bArrB.length > 0) {
                byteArrayOutputStream.write(bArrB);
            }
            if (zH) {
                qVar.p(true);
                gVar.s(byteArrayOutputStream, (int) c.ZIP64_EXTRA_FIELD_SIGNATURE.a());
                gVar.s(byteArrayOutputStream, 28);
                gVar.q(byteArrayOutputStream, iVar.n());
                gVar.q(byteArrayOutputStream, iVar.d());
                gVar.q(byteArrayOutputStream, iVar.Q());
                gVar.o(byteArrayOutputStream, iVar.N());
            }
            if (iVar.c() != null) {
                l.a.a.f.a aVarC = iVar.c();
                gVar.s(byteArrayOutputStream, (int) aVarC.a().a());
                gVar.s(byteArrayOutputStream, aVarC.f());
                gVar.s(byteArrayOutputStream, aVarC.d().b());
                byteArrayOutputStream.write(d.b(aVarC.g(), charset));
                byteArrayOutputStream.write(new byte[]{(byte) aVarC.c().d()});
                gVar.s(byteArrayOutputStream, aVarC.e().a());
            }
            q(iVar, byteArrayOutputStream);
            if (bArrB2.length > 0) {
                byteArrayOutputStream.write(bArrB2);
            }
        } catch (Exception e) {
            throw new l.a.a.c.b(e);
        }
    }

    private void q(i iVar, OutputStream outputStream) throws IOException {
        if (iVar.h() == null || iVar.h().size() == 0) {
            return;
        }
        for (h hVar : iVar.h()) {
            if (hVar.d() != c.AES_EXTRA_DATA_RECORD.a() && hVar.d() != c.ZIP64_EXTRA_FIELD_SIGNATURE.a()) {
                this.a.s(outputStream, (int) hVar.d());
                this.a.s(outputStream, hVar.e());
                if (hVar.e() > 0 && hVar.c() != null) {
                    outputStream.write(hVar.c());
                }
            }
        }
    }

    private void r(m mVar, ByteArrayOutputStream byteArrayOutputStream, l.a.a.i.g gVar) throws IOException {
        gVar.o(byteArrayOutputStream, (int) c.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.a());
        gVar.o(byteArrayOutputStream, mVar.c());
        gVar.q(byteArrayOutputStream, mVar.d());
        gVar.o(byteArrayOutputStream, mVar.e());
    }

    private void s(n nVar, ByteArrayOutputStream byteArrayOutputStream, l.a.a.i.g gVar) throws IOException {
        gVar.o(byteArrayOutputStream, (int) nVar.a().a());
        gVar.q(byteArrayOutputStream, nVar.g());
        gVar.s(byteArrayOutputStream, nVar.j());
        gVar.s(byteArrayOutputStream, nVar.k());
        gVar.o(byteArrayOutputStream, nVar.c());
        gVar.o(byteArrayOutputStream, nVar.d());
        gVar.q(byteArrayOutputStream, nVar.i());
        gVar.q(byteArrayOutputStream, nVar.h());
        gVar.q(byteArrayOutputStream, nVar.f());
        gVar.q(byteArrayOutputStream, nVar.e());
    }

    private void t(q qVar, OutputStream outputStream, byte[] bArr, Charset charset) throws IOException {
        if (bArr == null) {
            throw new l.a.a.c.b("invalid buff to write as zip headers");
        }
        if ((outputStream instanceof l.a.a.e.b.d) && ((l.a.a.e.b.d) outputStream).d(bArr.length)) {
            d(qVar, outputStream, charset);
        } else {
            outputStream.write(bArr);
        }
    }

    public void d(q qVar, OutputStream outputStream, Charset charset) throws IOException {
        if (qVar == null || outputStream == null) {
            throw new l.a.a.c.b("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            i(qVar, outputStream);
            long jF = f(qVar);
            l(qVar, byteArrayOutputStream, this.a, charset);
            int size = byteArrayOutputStream.size();
            if (qVar.i() || jF >= 4294967295L || qVar.a().a().size() >= 65535) {
                if (qVar.f() == null) {
                    qVar.o(new n());
                }
                if (qVar.e() == null) {
                    qVar.n(new m());
                }
                qVar.e().g(size + jF);
                if (g(outputStream)) {
                    int iE = e(outputStream);
                    qVar.e().f(iE);
                    qVar.e().h(iE + 1);
                } else {
                    qVar.e().f(0);
                    qVar.e().h(1);
                }
                n nVarA = a(qVar, size, jF);
                qVar.o(nVarA);
                s(nVarA, byteArrayOutputStream, this.a);
                r(qVar.e(), byteArrayOutputStream, this.a);
            }
            m(qVar, size, jF, byteArrayOutputStream, this.a, charset);
            t(qVar, outputStream, byteArrayOutputStream.toByteArray(), charset);
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void k(i iVar, q qVar, l.a.a.e.b.i iVar2) throws IOException {
        l.a.a.e.b.i iVar3;
        String str;
        String str2;
        if (iVar == null || qVar == null) {
            throw new l.a.a.c.b("invalid input parameters, cannot update local file header");
        }
        boolean z = true;
        if (iVar.N() != iVar2.c()) {
            String parent = qVar.g().getParent();
            String strR = l.a.a.i.d.r(qVar.g().getName());
            if (parent != null) {
                str = parent + System.getProperty("file.separator");
            } else {
                str = "";
            }
            if (iVar.N() < 9) {
                str2 = str + strR + ".z0" + (iVar.N() + 1);
            } else {
                str2 = str + strR + ".z" + (iVar.N() + 1);
            }
            iVar3 = new l.a.a.e.b.i(new File(str2));
        } else {
            iVar3 = iVar2;
            z = false;
        }
        long jA = iVar3.a();
        iVar3.n(iVar.Q() + 14);
        this.a.r(this.b, 0, iVar.f());
        iVar3.write(this.b, 0, 4);
        j(iVar3, iVar);
        if (z) {
            iVar3.close();
        } else {
            iVar2.n(jA);
        }
    }

    public void n(j jVar, OutputStream outputStream) throws IOException {
        if (jVar == null || outputStream == null) {
            throw new l.a.a.c.b("input parameters is null, cannot write extended local header");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.a.o(byteArrayOutputStream, (int) c.EXTRA_DATA_RECORD.a());
            this.a.r(this.b, 0, jVar.f());
            byteArrayOutputStream.write(this.b, 0, 4);
            if (jVar.M()) {
                this.a.q(byteArrayOutputStream, jVar.d());
                this.a.q(byteArrayOutputStream, jVar.n());
            } else {
                this.a.r(this.b, 0, jVar.d());
                byteArrayOutputStream.write(this.b, 0, 4);
                this.a.r(this.b, 0, jVar.n());
                byteArrayOutputStream.write(this.b, 0, 4);
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void p(q qVar, j jVar, OutputStream outputStream, Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.a.o(byteArrayOutputStream, (int) jVar.a().a());
            this.a.s(byteArrayOutputStream, jVar.o());
            byteArrayOutputStream.write(jVar.l());
            this.a.s(byteArrayOutputStream, jVar.e().a());
            this.a.r(this.b, 0, jVar.m());
            byteArrayOutputStream.write(this.b, 0, 4);
            this.a.r(this.b, 0, jVar.f());
            byteArrayOutputStream.write(this.b, 0, 4);
            boolean z = jVar.d() >= 4294967295L || jVar.n() >= 4294967295L;
            if (z) {
                this.a.r(this.b, 0, 4294967295L);
                byteArrayOutputStream.write(this.b, 0, 4);
                byteArrayOutputStream.write(this.b, 0, 4);
                qVar.p(true);
                jVar.N(true);
            } else {
                this.a.r(this.b, 0, jVar.d());
                byteArrayOutputStream.write(this.b, 0, 4);
                this.a.r(this.b, 0, jVar.n());
                byteArrayOutputStream.write(this.b, 0, 4);
                jVar.N(false);
            }
            byte[] bArrB = new byte[0];
            if (l.a.a.i.i.j(jVar.j())) {
                bArrB = d.b(jVar.j(), charset);
            }
            this.a.s(byteArrayOutputStream, bArrB.length);
            int i2 = z ? 20 : 0;
            if (jVar.c() != null) {
                i2 += 11;
            }
            this.a.s(byteArrayOutputStream, i2);
            if (bArrB.length > 0) {
                byteArrayOutputStream.write(bArrB);
            }
            if (z) {
                this.a.s(byteArrayOutputStream, (int) c.ZIP64_EXTRA_FIELD_SIGNATURE.a());
                this.a.s(byteArrayOutputStream, 16);
                this.a.q(byteArrayOutputStream, jVar.n());
                this.a.q(byteArrayOutputStream, jVar.d());
            }
            if (jVar.c() != null) {
                l.a.a.f.a aVarC = jVar.c();
                this.a.s(byteArrayOutputStream, (int) aVarC.a().a());
                this.a.s(byteArrayOutputStream, aVarC.f());
                this.a.s(byteArrayOutputStream, aVarC.d().b());
                byteArrayOutputStream.write(d.b(aVarC.g(), charset));
                byteArrayOutputStream.write(new byte[]{(byte) aVarC.c().d()});
                this.a.s(byteArrayOutputStream, aVarC.e().a());
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}

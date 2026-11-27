package l.a.a.d;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l.a.a.f.h;
import l.a.a.f.i;
import l.a.a.f.j;
import l.a.a.f.l;
import l.a.a.f.m;
import l.a.a.f.n;
import l.a.a.f.o;
import l.a.a.f.q;

/* loaded from: classes.dex */
public class b {
    private q a;
    private final l.a.a.i.g b = new l.a.a.i.g();
    private final byte[] c = new byte[4];

    private long a(q qVar) {
        return qVar.i() ? qVar.f().h() : qVar.b().h();
    }

    private long c(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new l.a.a.c.b("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j2 = length - 22;
        w(randomAccessFile, j2);
        return ((long) this.b.c(randomAccessFile)) == c.END_OF_CENTRAL_DIRECTORY.a() ? j2 : d(randomAccessFile);
    }

    private long d(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            w(randomAccessFile, length);
            if (this.b.c(randomAccessFile) == c.END_OF_CENTRAL_DIRECTORY.a()) {
                return length;
            }
        }
        throw new l.a.a.c.b("Zip headers not found. Probably not a zip file");
    }

    private List<h> e(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < i2) {
            h hVar = new h();
            hVar.g(this.b.m(bArr, i3));
            int i4 = i3 + 2;
            int iM = this.b.m(bArr, i4);
            hVar.h(iM);
            int i5 = i4 + 2;
            if (iM > 0) {
                byte[] bArr2 = new byte[iM];
                System.arraycopy(bArr, i5, bArr2, 0, iM);
                hVar.f(bArr2);
            }
            i3 = i5 + iM;
            arrayList.add(hVar);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private l.a.a.f.a f(List<h> list, l.a.a.i.g gVar) throws l.a.a.c.b {
        if (list == null) {
            return null;
        }
        for (h hVar : list) {
            if (hVar != null) {
                long jD = hVar.d();
                c cVar = c.AES_EXTRA_DATA_RECORD;
                if (jD == cVar.a()) {
                    byte[] bArrC = hVar.c();
                    if (bArrC == null || bArrC.length != 7) {
                        throw new l.a.a.c.b("corrupt AES extra data records");
                    }
                    l.a.a.f.a aVar = new l.a.a.f.a();
                    aVar.b(cVar);
                    aVar.k(hVar.e());
                    byte[] bArrC2 = hVar.c();
                    aVar.i(l.a.a.f.t.b.a(gVar.m(bArrC2, 0)));
                    byte[] bArr = new byte[2];
                    System.arraycopy(bArrC2, 2, bArr, 0, 2);
                    aVar.l(new String(bArr));
                    aVar.h(l.a.a.f.t.a.a(bArrC2[4] & 255));
                    aVar.j(l.a.a.f.t.d.b(gVar.m(bArrC2, 5)));
                    return aVar;
                }
            }
        }
        return null;
    }

    private void g(l.a.a.f.b bVar, l.a.a.i.g gVar) throws l.a.a.c.b {
        l.a.a.f.a aVarF;
        if (bVar.h() == null || bVar.h().size() <= 0 || (aVarF = f(bVar.h(), gVar)) == null) {
            return;
        }
        bVar.u(aVarF);
        bVar.B(l.a.a.f.t.e.AES);
    }

    private l.a.a.f.c i(RandomAccessFile randomAccessFile, l.a.a.i.g gVar, Charset charset) throws IOException {
        l.a.a.f.c cVar = new l.a.a.f.c();
        ArrayList arrayList = new ArrayList();
        long jE = d.e(this.a);
        long jA = a(this.a);
        randomAccessFile.seek(jE);
        int i2 = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i3 = 0;
        int i4 = 0;
        while (i4 < jA) {
            i iVar = new i();
            byte[] bArr3 = bArr2;
            long jC = gVar.c(randomAccessFile);
            c cVar2 = c.CENTRAL_DIRECTORY;
            if (jC != cVar2.a()) {
                throw new l.a.a.c.b("Expected central directory entry not found (#" + (i4 + 1) + ")");
            }
            iVar.b(cVar2);
            iVar.Y(gVar.l(randomAccessFile));
            iVar.K(gVar.l(randomAccessFile));
            byte[] bArr4 = new byte[i2];
            randomAccessFile.readFully(bArr4);
            iVar.A(l.a.a.i.a.a(bArr4[i3], i3));
            iVar.y(l.a.a.i.a.a(bArr4[i3], 3));
            iVar.G(l.a.a.i.a.a(bArr4[1], 3));
            iVar.H((byte[]) bArr4.clone());
            iVar.w(l.a.a.f.t.d.b(gVar.l(randomAccessFile)));
            iVar.I(gVar.c(randomAccessFile));
            randomAccessFile.readFully(bArr3);
            iVar.x(gVar.j(bArr3, i3));
            int i5 = i4;
            iVar.v(gVar.i(randomAccessFile, 4));
            iVar.J(gVar.i(randomAccessFile, 4));
            int iL = gVar.l(randomAccessFile);
            iVar.F(iL);
            iVar.D(gVar.l(randomAccessFile));
            int iL2 = gVar.l(randomAccessFile);
            iVar.V(iL2);
            iVar.S(gVar.l(randomAccessFile));
            randomAccessFile.readFully(bArr);
            iVar.W((byte[]) bArr.clone());
            randomAccessFile.readFully(bArr3);
            iVar.T((byte[]) bArr3.clone());
            randomAccessFile.readFully(bArr3);
            long j2 = jA;
            byte[] bArr5 = bArr;
            iVar.X(gVar.j(bArr3, 0));
            if (iL <= 0) {
                throw new l.a.a.c.b("Invalid entry name in file header");
            }
            byte[] bArr6 = new byte[iL];
            randomAccessFile.readFully(bArr6);
            iVar.E(d.a(bArr6, iVar.t(), charset));
            iVar.z(b(iVar.O(), iVar.j()));
            o(randomAccessFile, iVar);
            t(iVar, gVar);
            g(iVar, gVar);
            if (iL2 > 0) {
                byte[] bArr7 = new byte[iL2];
                randomAccessFile.readFully(bArr7);
                iVar.U(d.a(bArr7, iVar.t(), charset));
            }
            if (iVar.s()) {
                if (iVar.c() != null) {
                    iVar.B(l.a.a.f.t.e.AES);
                } else {
                    iVar.B(l.a.a.f.t.e.ZIP_STANDARD);
                }
            }
            arrayList.add(iVar);
            bArr2 = bArr3;
            i3 = 0;
            i2 = 2;
            i4 = i5 + 1;
            bArr = bArr5;
            jA = j2;
        }
        cVar.b(arrayList);
        l.a.a.f.e eVar = new l.a.a.f.e();
        long jC2 = gVar.c(randomAccessFile);
        c cVar3 = c.DIGITAL_SIGNATURE;
        if (jC2 == cVar3.a()) {
            eVar.b(cVar3);
            eVar.e(gVar.l(randomAccessFile));
            if (eVar.c() > 0) {
                byte[] bArr8 = new byte[eVar.c()];
                randomAccessFile.readFully(bArr8);
                eVar.d(new String(bArr8));
            }
        }
        return cVar;
    }

    private l.a.a.f.f k(RandomAccessFile randomAccessFile, l.a.a.i.g gVar, l lVar) throws IOException {
        long jC = c(randomAccessFile);
        w(randomAccessFile, 4 + jC);
        l.a.a.f.f fVar = new l.a.a.f.f();
        fVar.b(c.END_OF_CENTRAL_DIRECTORY);
        fVar.k(gVar.l(randomAccessFile));
        fVar.l(gVar.l(randomAccessFile));
        fVar.q(gVar.l(randomAccessFile));
        fVar.p(gVar.l(randomAccessFile));
        fVar.o(gVar.c(randomAccessFile));
        fVar.m(jC);
        randomAccessFile.readFully(this.c);
        fVar.n(gVar.j(this.c, 0));
        fVar.j(v(randomAccessFile, gVar.l(randomAccessFile), lVar.b()));
        this.a.l(fVar.d() > 0);
        return fVar;
    }

    private List<h> l(InputStream inputStream, int i2) throws IOException {
        if (i2 < 4) {
            if (i2 <= 0) {
                return null;
            }
            inputStream.skip(i2);
            return null;
        }
        byte[] bArr = new byte[i2];
        l.a.a.i.i.l(inputStream, bArr);
        try {
            return e(bArr, i2);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    private List<h> m(RandomAccessFile randomAccessFile, int i2) throws IOException {
        if (i2 < 4) {
            if (i2 <= 0) {
                return null;
            }
            randomAccessFile.skipBytes(i2);
            return null;
        }
        byte[] bArr = new byte[i2];
        randomAccessFile.read(bArr);
        try {
            return e(bArr, i2);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    private void n(InputStream inputStream, j jVar) throws IOException {
        int i2 = jVar.i();
        if (i2 <= 0) {
            return;
        }
        jVar.C(l(inputStream, i2));
    }

    private void o(RandomAccessFile randomAccessFile, i iVar) throws IOException {
        int i2 = iVar.i();
        if (i2 <= 0) {
            return;
        }
        iVar.C(m(randomAccessFile, i2));
    }

    private n q(RandomAccessFile randomAccessFile, l.a.a.i.g gVar) throws IOException {
        if (this.a.e() == null) {
            throw new l.a.a.c.b("invalid zip64 end of central directory locator");
        }
        long jD = this.a.e().d();
        if (jD < 0) {
            throw new l.a.a.c.b("invalid offset for start of end of central directory record");
        }
        randomAccessFile.seek(jD);
        n nVar = new n();
        long jC = gVar.c(randomAccessFile);
        c cVar = c.ZIP64_END_CENTRAL_DIRECTORY_RECORD;
        if (jC != cVar.a()) {
            throw new l.a.a.c.b("invalid signature for zip64 end of central directory record");
        }
        nVar.b(cVar);
        nVar.q(gVar.h(randomAccessFile));
        nVar.t(gVar.l(randomAccessFile));
        nVar.u(gVar.l(randomAccessFile));
        nVar.m(gVar.c(randomAccessFile));
        nVar.n(gVar.c(randomAccessFile));
        nVar.s(gVar.h(randomAccessFile));
        nVar.r(gVar.h(randomAccessFile));
        nVar.p(gVar.h(randomAccessFile));
        nVar.o(gVar.h(randomAccessFile));
        long jG = nVar.g() - 44;
        if (jG > 0) {
            byte[] bArr = new byte[(int) jG];
            randomAccessFile.readFully(bArr);
            nVar.l(bArr);
        }
        return nVar;
    }

    private m r(RandomAccessFile randomAccessFile, l.a.a.i.g gVar, long j2) throws IOException {
        m mVar = new m();
        x(randomAccessFile, j2);
        long jC = gVar.c(randomAccessFile);
        c cVar = c.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR;
        if (jC != cVar.a()) {
            this.a.p(false);
            return null;
        }
        this.a.p(true);
        mVar.b(cVar);
        mVar.f(gVar.c(randomAccessFile));
        mVar.g(gVar.h(randomAccessFile));
        mVar.h(gVar.c(randomAccessFile));
        return mVar;
    }

    private o s(List<h> list, l.a.a.i.g gVar, long j2, long j3, long j4, int i2) {
        for (h hVar : list) {
            if (hVar != null && c.ZIP64_EXTRA_FIELD_SIGNATURE.a() == hVar.d()) {
                o oVar = new o();
                byte[] bArrC = hVar.c();
                if (hVar.e() <= 0) {
                    return null;
                }
                int i3 = 0;
                if (hVar.e() > 0 && j2 == 4294967295L) {
                    oVar.j(gVar.j(bArrC, 0));
                    i3 = 8;
                }
                if (i3 < hVar.e() && j3 == 4294967295L) {
                    oVar.g(gVar.j(bArrC, i3));
                    i3 += 8;
                }
                if (i3 < hVar.e() && j4 == 4294967295L) {
                    oVar.i(gVar.j(bArrC, i3));
                    i3 += 8;
                }
                if (i3 < hVar.e() && i2 == 65535) {
                    oVar.h(gVar.e(bArrC, i3));
                }
                return oVar;
            }
        }
        return null;
    }

    private void t(i iVar, l.a.a.i.g gVar) {
        o oVarS;
        if (iVar.h() == null || iVar.h().size() <= 0 || (oVarS = s(iVar.h(), gVar, iVar.n(), iVar.d(), iVar.Q(), iVar.N())) == null) {
            return;
        }
        iVar.L(oVarS);
        if (oVarS.f() != -1) {
            iVar.J(oVarS.f());
        }
        if (oVarS.c() != -1) {
            iVar.v(oVarS.c());
        }
        if (oVarS.e() != -1) {
            iVar.X(oVarS.e());
        }
        if (oVarS.d() != -1) {
            iVar.S(oVarS.d());
        }
    }

    private void u(j jVar, l.a.a.i.g gVar) throws l.a.a.c.b {
        o oVarS;
        if (jVar == null) {
            throw new l.a.a.c.b("file header is null in reading Zip64 Extended Info");
        }
        if (jVar.h() == null || jVar.h().size() <= 0 || (oVarS = s(jVar.h(), gVar, jVar.n(), jVar.d(), 0L, 0)) == null) {
            return;
        }
        jVar.L(oVarS);
        if (oVarS.f() != -1) {
            jVar.J(oVarS.f());
        }
        if (oVarS.c() != -1) {
            jVar.v(oVarS.c());
        }
    }

    private String v(RandomAccessFile randomAccessFile, int i2, Charset charset) throws IOException {
        if (i2 <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i2];
            randomAccessFile.readFully(bArr);
            if (charset == null) {
                charset = l.a.a.i.e.c;
            }
            return d.a(bArr, false, charset);
        } catch (IOException unused) {
            return null;
        }
    }

    private void w(RandomAccessFile randomAccessFile, long j2) throws IOException {
        if (randomAccessFile instanceof l.a.a.e.a.h) {
            ((l.a.a.e.a.h) randomAccessFile).f(j2);
        } else {
            randomAccessFile.seek(j2);
        }
    }

    private void x(RandomAccessFile randomAccessFile, long j2) throws IOException {
        w(randomAccessFile, (((j2 - 4) - 8) - 4) - 4);
    }

    public boolean b(byte[] bArr, String str) {
        if (bArr[0] != 0 && l.a.a.i.a.a(bArr[0], 4)) {
            return true;
        }
        if (bArr[3] != 0 && l.a.a.i.a.a(bArr[3], 6)) {
            return true;
        }
        if (str != null) {
            return str.endsWith("/") || str.endsWith("\\");
        }
        return false;
    }

    public q h(RandomAccessFile randomAccessFile, l lVar) throws IOException {
        if (randomAccessFile.length() == 0) {
            return new q();
        }
        if (randomAccessFile.length() < 22) {
            throw new l.a.a.c.b("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
        q qVar = new q();
        this.a = qVar;
        try {
            qVar.k(k(randomAccessFile, this.b, lVar));
            if (this.a.b().h() == 0) {
                return this.a;
            }
            q qVar2 = this.a;
            qVar2.n(r(randomAccessFile, this.b, qVar2.b().f()));
            if (this.a.i()) {
                this.a.o(q(randomAccessFile, this.b));
                if (this.a.f() == null || this.a.f().c() <= 0) {
                    this.a.l(false);
                } else {
                    this.a.l(true);
                }
            }
            this.a.j(i(randomAccessFile, this.b, lVar.b()));
            return this.a;
        } catch (l.a.a.c.b e) {
            throw e;
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new l.a.a.c.b("Zip headers not found. Probably not a zip file or a corrupted zip file", e2);
        }
    }

    public l.a.a.f.d j(InputStream inputStream, boolean z) throws IOException {
        l.a.a.f.d dVar = new l.a.a.f.d();
        byte[] bArr = new byte[4];
        l.a.a.i.i.l(inputStream, bArr);
        long j2 = this.b.j(bArr, 0);
        c cVar = c.EXTRA_DATA_RECORD;
        if (j2 == cVar.a()) {
            dVar.b(cVar);
            l.a.a.i.i.l(inputStream, bArr);
            dVar.g(this.b.j(bArr, 0));
        } else {
            dVar.g(j2);
        }
        if (z) {
            dVar.f(this.b.f(inputStream));
            dVar.h(this.b.f(inputStream));
        } else {
            dVar.f(this.b.b(inputStream));
            dVar.h(this.b.b(inputStream));
        }
        return dVar;
    }

    public j p(InputStream inputStream, Charset charset) throws IOException {
        j jVar = new j();
        byte[] bArr = new byte[4];
        int iB = this.b.b(inputStream);
        if (iB == c.TEMPORARY_SPANNING_MARKER.a()) {
            iB = this.b.b(inputStream);
        }
        long j2 = iB;
        c cVar = c.LOCAL_FILE_HEADER;
        if (j2 != cVar.a()) {
            return null;
        }
        jVar.b(cVar);
        jVar.K(this.b.k(inputStream));
        byte[] bArr2 = new byte[2];
        if (l.a.a.i.i.l(inputStream, bArr2) != 2) {
            throw new l.a.a.c.b("Could not read enough bytes for generalPurposeFlags");
        }
        jVar.A(l.a.a.i.a.a(bArr2[0], 0));
        jVar.y(l.a.a.i.a.a(bArr2[0], 3));
        boolean z = true;
        jVar.G(l.a.a.i.a.a(bArr2[1], 3));
        jVar.H((byte[]) bArr2.clone());
        jVar.w(l.a.a.f.t.d.b(this.b.k(inputStream)));
        jVar.I(this.b.b(inputStream));
        l.a.a.i.i.l(inputStream, bArr);
        jVar.x(this.b.j(bArr, 0));
        jVar.v(this.b.g(inputStream, 4));
        jVar.J(this.b.g(inputStream, 4));
        int iK = this.b.k(inputStream);
        jVar.F(iK);
        jVar.D(this.b.k(inputStream));
        if (iK <= 0) {
            throw new l.a.a.c.b("Invalid entry name in local file header");
        }
        byte[] bArr3 = new byte[iK];
        l.a.a.i.i.l(inputStream, bArr3);
        String strA = d.a(bArr3, jVar.t(), charset);
        jVar.E(strA);
        if (!strA.endsWith("/") && !strA.endsWith("\\")) {
            z = false;
        }
        jVar.z(z);
        n(inputStream, jVar);
        u(jVar, this.b);
        g(jVar, this.b);
        if (jVar.s() && jVar.g() != l.a.a.f.t.e.AES) {
            if (l.a.a.i.a.a(jVar.l()[0], 6)) {
                jVar.B(l.a.a.f.t.e.ZIP_STANDARD_VARIANT_STRONG);
            } else {
                jVar.B(l.a.a.f.t.e.ZIP_STANDARD);
            }
        }
        return jVar;
    }
}

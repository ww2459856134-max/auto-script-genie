package k.b0.v;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
final class t extends k.x.g {
    private static k.y.c A = k.y.c.b(t.class);
    private OutputStream d;
    private g0 e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1946h;

    /* renamed from: i, reason: collision with root package name */
    private int f1947i;

    /* renamed from: j, reason: collision with root package name */
    private int f1948j;

    /* renamed from: k, reason: collision with root package name */
    private int f1949k;

    /* renamed from: l, reason: collision with root package name */
    private int f1950l;

    /* renamed from: m, reason: collision with root package name */
    private int f1951m;

    /* renamed from: n, reason: collision with root package name */
    private int f1952n;

    /* renamed from: o, reason: collision with root package name */
    private int f1953o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private ArrayList w;
    private HashMap x;
    private int y;
    private byte[] z;

    public t(g0 g0Var, int i2, OutputStream outputStream, k.a0.a.s sVar) throws u, IOException {
        this.f = i2;
        this.e = g0Var;
        e(sVar);
        this.v = 1;
        ArrayList arrayList = this.w;
        this.u = (arrayList != null ? arrayList.size() : 0) + 4;
        if (this.w != null) {
            this.f1947i = c(this.t * 4);
            this.f1948j = c(this.t * 64);
            this.v += c(this.w.size() * 128);
        }
        int iC = c(i2);
        if (i2 < 4096) {
            this.g = XMLEvent.CHANGE_PREFIX_MAPPING;
        } else {
            this.g = iC * 512;
        }
        this.d = outputStream;
        int i3 = this.g / 512;
        this.f1951m = i3;
        this.f1946h = 1;
        int i4 = i3 + 8 + 8 + this.s + this.f1948j + this.f1947i + this.v;
        this.f1946h = (int) Math.ceil((i4 + 1) / 128.0d);
        int iCeil = (int) Math.ceil((r10 + i4) / 128.0d);
        this.f1946h = iCeil;
        int i5 = i4 + iCeil;
        if (iCeil > 108) {
            this.f1950l = 0;
            this.f1949k = (int) Math.ceil(((iCeil - 109) + 1) / 127.0d);
            int iCeil2 = (int) Math.ceil(((r8 + i4) + this.f1946h) / 128.0d);
            this.f1946h = iCeil2;
            i5 = i4 + this.f1949k + iCeil2;
        } else {
            this.f1950l = -2;
            this.f1949k = 0;
        }
        int i6 = this.f1949k;
        this.f1953o = i6;
        this.r = -2;
        if (this.w != null && this.f1948j != 0) {
            this.r = this.f1951m + i6 + this.s + 16;
        }
        this.q = -2;
        int i7 = this.r;
        if (i7 != -2) {
            this.q = i7 + this.f1948j;
        }
        int i8 = this.q;
        if (i8 != -2) {
            this.p = i8 + this.f1947i;
        } else {
            this.p = i6 + this.f1951m + this.s + 16;
        }
        int i9 = this.p + this.f1946h;
        this.f1952n = i9;
        if (i5 != i9 + this.v) {
            A.f("Root start block and total blocks are inconsistent  generated file may be corrupt");
            A.f("RootStartBlock " + this.f1952n + " totalBlocks " + i5);
        }
    }

    private void b() throws IOException {
        if (this.y >= 512) {
            this.d.write(this.z);
            this.z = new byte[512];
            this.y = 0;
        }
    }

    private int c(int i2) {
        int i3 = i2 / 512;
        return i2 % 512 > 0 ? i3 + 1 : i3;
    }

    private int d(int i2) {
        int i3 = i2 / 64;
        return i2 % 64 > 0 ? i3 + 1 : i3;
    }

    private void e(k.a0.a.s sVar) throws u, IOException {
        boolean z;
        if (sVar == null) {
            return;
        }
        this.w = new ArrayList();
        this.x = new HashMap();
        int iE = sVar.e();
        int iC = 0;
        for (int i2 = 0; i2 < iE; i2++) {
            k.x.f fVarF = sVar.f(i2);
            if (fVarF.a.equalsIgnoreCase("Root Entry")) {
                this.x.put("Root Entry", new s(fVarF, null, i2));
                z = true;
            } else {
                z = false;
            }
            int i3 = 0;
            while (true) {
                String[] strArr = k.x.g.c;
                if (i3 >= strArr.length || z) {
                    break;
                }
                if (fVarF.a.equalsIgnoreCase(strArr[i3])) {
                    k.x.f fVarB = sVar.b(fVarF.a);
                    k.y.a.a(fVarB != null);
                    if (fVarB == fVarF) {
                        this.x.put(strArr[i3], new s(fVarF, null, i2));
                        z = true;
                    }
                }
                i3++;
            }
            if (!z) {
                try {
                    byte[] bArrJ = fVarF.e > 0 ? sVar.j(i2) : new byte[0];
                    this.w.add(new s(fVarF, bArrJ, i2));
                    if (bArrJ.length > 4096) {
                        iC += c(bArrJ.length);
                    } else {
                        this.t += d(bArrJ.length);
                    }
                } catch (k.a0.a.d e) {
                    A.a(e);
                    throw new u();
                }
            }
        }
        this.s = iC;
    }

    private void g() throws IOException {
        ArrayList arrayList = this.w;
        if (arrayList == null) {
            return;
        }
        int i2 = this.f1953o + this.f1951m + 16;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr = ((s) it.next()).b;
            if (bArr.length > 4096) {
                int iC = c(bArr.length);
                j(i2, iC);
                i2 += iC;
            }
        }
    }

    private void h() throws IOException {
        ArrayList arrayList = this.w;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr = ((s) it.next()).b;
            if (bArr.length > 4096) {
                int iC = c(bArr.length) * 512;
                this.d.write(bArr, 0, bArr.length);
                int length = iC - bArr.length;
                this.d.write(new byte[length], 0, length);
            }
        }
    }

    private void i() throws IOException {
        this.z = new byte[512];
        this.y = 0;
        for (int i2 = 0; i2 < this.f1949k; i2++) {
            k.x.s0.a(-3, this.z, this.y);
            this.y += 4;
            b();
        }
        j(this.f1953o, this.f1951m);
        int i3 = this.f1953o + this.f1951m + this.s;
        int i4 = i3;
        while (i4 < i3 + 7) {
            i4++;
            k.x.s0.a(i4, this.z, this.y);
            this.y += 4;
            b();
        }
        k.x.s0.a(-2, this.z, this.y);
        this.y += 4;
        b();
        int i5 = i3 + 8;
        while (i5 < i3 + 15) {
            i5++;
            k.x.s0.a(i5, this.z, this.y);
            this.y += 4;
            b();
        }
        k.x.s0.a(-2, this.z, this.y);
        this.y += 4;
        b();
        g();
        int i6 = this.r;
        if (i6 != -2) {
            j(i6, this.f1948j);
            j(this.q, this.f1947i);
        }
        for (int i7 = 0; i7 < this.f1946h; i7++) {
            k.x.s0.a(-3, this.z, this.y);
            this.y += 4;
            b();
        }
        j(this.f1952n, this.v);
        int i8 = this.y;
        if (i8 != 0) {
            while (i8 < 512) {
                this.z[i8] = -1;
                i8++;
            }
            this.d.write(this.z);
        }
    }

    private void j(int i2, int i3) throws IOException {
        int i4 = i3 - 1;
        int i5 = i2 + 1;
        while (i4 > 0) {
            int iMin = Math.min(i4, (512 - this.y) / 4);
            for (int i6 = 0; i6 < iMin; i6++) {
                k.x.s0.a(i5, this.z, this.y);
                this.y += 4;
                i5++;
            }
            i4 -= iMin;
            b();
        }
        k.x.s0.a(-2, this.z, this.y);
        this.y += 4;
        b();
    }

    private void k() throws IOException {
        this.d.write(new byte[XMLEvent.CHANGE_PREFIX_MAPPING]);
    }

    private void l() throws IOException {
        this.e.b(this.d);
        this.d.write(new byte[this.g - this.f]);
    }

    private void m() throws IOException {
        int i2;
        byte[] bArr = new byte[512];
        int i3 = this.f1949k * 512;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = k.x.g.b;
        System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
        bArr[24] = 62;
        bArr[26] = 3;
        bArr[28] = -2;
        bArr[29] = -1;
        bArr[30] = 9;
        bArr[32] = 6;
        bArr[57] = 16;
        k.x.s0.a(this.f1946h, bArr, 44);
        k.x.s0.a(this.q, bArr, 60);
        k.x.s0.a(this.f1947i, bArr, 64);
        k.x.s0.a(this.f1950l, bArr, 68);
        k.x.s0.a(this.f1949k, bArr, 72);
        k.x.s0.a(this.f1952n, bArr, 48);
        int iMin = Math.min(this.f1946h, 109);
        int i4 = 76;
        int i5 = 0;
        for (int i6 = 0; i6 < iMin; i6++) {
            k.x.s0.a(this.p + i6, bArr, i4);
            i4 += 4;
            i5++;
        }
        while (i4 < 512) {
            bArr[i4] = -1;
            i4++;
        }
        this.d.write(bArr);
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i2 = this.f1949k;
            if (i7 >= i2) {
                break;
            }
            int iMin2 = Math.min(this.f1946h - i5, 127);
            for (int i9 = 0; i9 < iMin2; i9++) {
                k.x.s0.a(this.p + i5 + i9, bArr2, i8);
                i8 += 4;
            }
            i5 += iMin2;
            k.x.s0.a(i5 == this.f1946h ? -2 : i7 + 1, bArr2, i8);
            i8 += 4;
            i7++;
        }
        if (i2 > 0) {
            while (i8 < i3) {
                bArr2[i8] = -1;
                i8++;
            }
            this.d.write(bArr2);
        }
    }

    private void n() throws IOException {
        int[] iArr;
        int iC;
        int i2;
        int i3;
        s sVar;
        String[] strArr;
        int i4 = 512;
        byte[] bArr = new byte[this.v * 512];
        int i5 = 1;
        if (this.w != null) {
            iArr = new int[this.u];
            int i6 = 0;
            while (true) {
                strArr = k.x.g.c;
                if (i6 >= strArr.length) {
                    break;
                }
                s sVar2 = (s) this.x.get(strArr[i6]);
                if (sVar2 != null) {
                    iArr[sVar2.c] = i6;
                } else {
                    A.f("Standard property set " + strArr[i6] + " not present in source file");
                }
                i6++;
            }
            int length = strArr.length;
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                iArr[((s) it.next()).c] = length;
                length++;
            }
        } else {
            iArr = null;
        }
        if (this.w != null) {
            iC = (c(this.g) * 512) + 0 + (c(XMLEvent.CHANGE_PREFIX_MAPPING) * 512) + (c(XMLEvent.CHANGE_PREFIX_MAPPING) * 512);
            Iterator it2 = this.w.iterator();
            while (it2.hasNext()) {
                k.x.f fVar = ((s) it2.next()).a;
                if (fVar.b != 1) {
                    int i7 = fVar.e;
                    iC += i7 >= 4096 ? c(i7) * 512 : d(i7) * 64;
                }
            }
        } else {
            iC = 0;
        }
        k.x.f fVar2 = new k.x.f(this, "Root Entry");
        fVar2.g(5);
        fVar2.f(this.r);
        fVar2.e(iC);
        fVar2.d(-1);
        fVar2.c(-1);
        fVar2.b(0);
        fVar2.a(this.w != null ? iArr[((s) this.x.get("Root Entry")).a.f2019h] : 1);
        System.arraycopy(fVar2.f2020i, 0, bArr, 0, 128);
        k.x.f fVar3 = new k.x.f(this, "Workbook");
        fVar3.g(2);
        fVar3.f(this.f1953o);
        fVar3.e(this.g);
        int i8 = 3;
        if (this.w != null) {
            k.x.f fVar4 = ((s) this.x.get("Workbook")).a;
            int i9 = fVar4.f;
            i3 = i9 != -1 ? iArr[i9] : -1;
            int i10 = fVar4.g;
            i2 = i10 != -1 ? iArr[i10] : -1;
        } else {
            i2 = -1;
            i3 = 3;
        }
        fVar3.d(i3);
        fVar3.c(i2);
        fVar3.a(-1);
        System.arraycopy(fVar3.f2020i, 0, bArr, 128, 128);
        k.x.f fVar5 = new k.x.f(this, "\u0005SummaryInformation");
        fVar5.g(2);
        fVar5.f(this.f1953o + this.f1951m);
        fVar5.e(XMLEvent.CHANGE_PREFIX_MAPPING);
        if (this.w != null && (sVar = (s) this.x.get("\u0005SummaryInformation")) != null) {
            k.x.f fVar6 = sVar.a;
            int i11 = fVar6.f;
            int i12 = i11 != -1 ? iArr[i11] : -1;
            int i13 = fVar6.g;
            i8 = i13 != -1 ? iArr[i13] : -1;
            i5 = i12;
        }
        fVar5.d(i5);
        fVar5.c(i8);
        fVar5.a(-1);
        System.arraycopy(fVar5.f2020i, 0, bArr, 256, 128);
        k.x.f fVar7 = new k.x.f(this, "\u0005DocumentSummaryInformation");
        fVar7.g(2);
        fVar7.f(this.f1953o + this.f1951m + 8);
        fVar7.e(XMLEvent.CHANGE_PREFIX_MAPPING);
        fVar7.d(-1);
        fVar7.c(-1);
        fVar7.a(-1);
        System.arraycopy(fVar7.f2020i, 0, bArr, 384, 128);
        ArrayList arrayList = this.w;
        if (arrayList == null) {
            this.d.write(bArr);
            return;
        }
        int iC2 = this.f1953o + this.f1951m + 16;
        Iterator it3 = arrayList.iterator();
        int iD = 0;
        while (it3.hasNext()) {
            s sVar3 = (s) it3.next();
            int i14 = sVar3.b.length > 4096 ? iC2 : iD;
            k.x.f fVar8 = new k.x.f(this, sVar3.a.a);
            fVar8.g(sVar3.a.b);
            fVar8.f(i14);
            fVar8.e(sVar3.a.e);
            k.x.f fVar9 = sVar3.a;
            int i15 = fVar9.f;
            int i16 = i15 != -1 ? iArr[i15] : -1;
            int i17 = fVar9.g;
            int i18 = i17 != -1 ? iArr[i17] : -1;
            int i19 = fVar9.f2019h;
            int i20 = i19 != -1 ? iArr[i19] : -1;
            fVar8.d(i16);
            fVar8.c(i18);
            fVar8.a(i20);
            System.arraycopy(fVar8.f2020i, 0, bArr, i4, 128);
            i4 += 128;
            byte[] bArr2 = sVar3.b;
            if (bArr2.length > 4096) {
                iC2 += c(bArr2.length);
            } else {
                iD += d(bArr2.length);
            }
        }
        this.d.write(bArr);
    }

    private void o() throws IOException {
        ArrayList arrayList = this.w;
        if (arrayList == null) {
            return;
        }
        byte[] bArr = new byte[this.f1948j * 512];
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            s sVar = (s) it.next();
            byte[] bArr2 = sVar.b;
            if (bArr2.length <= 4096) {
                int iD = d(bArr2.length) * 64;
                byte[] bArr3 = sVar.b;
                System.arraycopy(bArr3, 0, bArr, i2, bArr3.length);
                i2 += iD;
            }
        }
        this.d.write(bArr);
    }

    private void p() throws IOException {
        if (this.q == -2) {
            return;
        }
        byte[] bArr = new byte[this.f1947i * 512];
        Iterator it = this.w.iterator();
        int i2 = 0;
        int i3 = 1;
        while (it.hasNext()) {
            byte[] bArr2 = ((s) it.next()).b;
            if (bArr2.length <= 4096 && bArr2.length != 0) {
                int iD = d(bArr2.length);
                for (int i4 = 0; i4 < iD - 1; i4++) {
                    k.x.s0.a(i3, bArr, i2);
                    i2 += 4;
                    i3++;
                }
                k.x.s0.a(-2, bArr, i2);
                i2 += 4;
                i3++;
            }
        }
        this.d.write(bArr);
    }

    private void q() throws IOException {
        this.d.write(new byte[XMLEvent.CHANGE_PREFIX_MAPPING]);
    }

    public void f() throws IOException {
        m();
        l();
        k();
        q();
        h();
        o();
        p();
        i();
        n();
    }
}

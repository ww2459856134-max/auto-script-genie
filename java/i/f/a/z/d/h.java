package i.f.a.z.d;

import java.util.Formatter;

/* loaded from: classes.dex */
final class h {
    private final a a;
    private final i[] b;
    private c c;
    private final int d;

    h(a aVar, c cVar) {
        this.a = aVar;
        int iA = aVar.a();
        this.d = iA;
        this.c = cVar;
        this.b = new i[iA + 2];
    }

    private void a(i iVar) {
        if (iVar != null) {
            ((j) iVar).g(this.a);
        }
    }

    private static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    private static int c(int i2, int i3, d dVar) {
        if (dVar == null || dVar.g()) {
            return i3;
        }
        if (!dVar.h(i2)) {
            return i3 + 1;
        }
        dVar.i(i2);
        return 0;
    }

    private int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i2 = 1; i2 < this.d + 1; i2++) {
            d[] dVarArrD = this.b[i2].d();
            for (int i3 = 0; i3 < dVarArrD.length; i3++) {
                if (dVarArrD[i3] != null && !dVarArrD[i3].g()) {
                    e(i2, i3, dVarArrD);
                }
            }
        }
        return iF;
    }

    private void e(int i2, int i3, d[] dVarArr) {
        d dVar = dVarArr[i3];
        d[] dVarArrD = this.b[i2 - 1].d();
        i[] iVarArr = this.b;
        int i4 = i2 + 1;
        d[] dVarArrD2 = iVarArr[i4] != null ? iVarArr[i4].d() : dVarArrD;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrD[i3];
        dVarArr2[3] = dVarArrD2[i3];
        if (i3 > 0) {
            int i5 = i3 - 1;
            dVarArr2[0] = dVarArr[i5];
            dVarArr2[4] = dVarArrD[i5];
            dVarArr2[5] = dVarArrD2[i5];
        }
        if (i3 > 1) {
            int i6 = i3 - 2;
            dVarArr2[8] = dVarArr[i6];
            dVarArr2[10] = dVarArrD[i6];
            dVarArr2[11] = dVarArrD2[i6];
        }
        if (i3 < dVarArr.length - 1) {
            int i7 = i3 + 1;
            dVarArr2[1] = dVarArr[i7];
            dVarArr2[6] = dVarArrD[i7];
            dVarArr2[7] = dVarArrD2[i7];
        }
        if (i3 < dVarArr.length - 2) {
            int i8 = i3 + 2;
            dVarArr2[9] = dVarArr[i8];
            dVarArr2[12] = dVarArrD[i8];
            dVarArr2[13] = dVarArrD2[i8];
        }
        for (int i9 = 0; i9 < 14 && !b(dVar, dVarArr2[i9]); i9++) {
        }
    }

    private int f() {
        g();
        return h() + i();
    }

    private void g() {
        i[] iVarArr = this.b;
        if (iVarArr[0] == null || iVarArr[this.d + 1] == null) {
            return;
        }
        d[] dVarArrD = iVarArr[0].d();
        d[] dVarArrD2 = this.b[this.d + 1].d();
        for (int i2 = 0; i2 < dVarArrD.length; i2++) {
            if (dVarArrD[i2] != null && dVarArrD2[i2] != null && dVarArrD[i2].c() == dVarArrD2[i2].c()) {
                for (int i3 = 1; i3 <= this.d; i3++) {
                    d dVar = this.b[i3].d()[i2];
                    if (dVar != null) {
                        dVar.i(dVarArrD[i2].c());
                        if (!dVar.g()) {
                            this.b[i3].d()[i2] = null;
                        }
                    }
                }
            }
        }
    }

    private int h() {
        i[] iVarArr = this.b;
        if (iVarArr[0] == null) {
            return 0;
        }
        d[] dVarArrD = iVarArr[0].d();
        int i2 = 0;
        for (int i3 = 0; i3 < dVarArrD.length; i3++) {
            if (dVarArrD[i3] != null) {
                int iC = dVarArrD[i3].c();
                int iC2 = 0;
                for (int i4 = 1; i4 < this.d + 1 && iC2 < 2; i4++) {
                    d dVar = this.b[i4].d()[i3];
                    if (dVar != null) {
                        iC2 = c(iC, iC2, dVar);
                        if (!dVar.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    private int i() {
        i[] iVarArr = this.b;
        int i2 = this.d;
        if (iVarArr[i2 + 1] == null) {
            return 0;
        }
        d[] dVarArrD = iVarArr[i2 + 1].d();
        int i3 = 0;
        for (int i4 = 0; i4 < dVarArrD.length; i4++) {
            if (dVarArrD[i4] != null) {
                int iC = dVarArrD[i4].c();
                int iC2 = 0;
                for (int i5 = this.d + 1; i5 > 0 && iC2 < 2; i5--) {
                    d dVar = this.b[i5].d()[i4];
                    if (dVar != null) {
                        iC2 = c(iC, iC2, dVar);
                        if (!dVar.g()) {
                            i3++;
                        }
                    }
                }
            }
        }
        return i3;
    }

    int j() {
        return this.d;
    }

    int k() {
        return this.a.b();
    }

    int l() {
        return this.a.c();
    }

    c m() {
        return this.c;
    }

    i n(int i2) {
        return this.b[i2];
    }

    i[] o() {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i2 = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i2) {
                break;
            }
            i2 = iD;
        }
        return this.b;
    }

    void p(c cVar) {
        this.c = cVar;
    }

    void q(int i2, i iVar) {
        this.b[i2] = iVar;
    }

    public String toString() {
        i[] iVarArr = this.b;
        i iVar = iVarArr[0];
        if (iVar == null) {
            iVar = iVarArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < iVar.d().length; i2++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i2));
                for (int i3 = 0; i3 < this.d + 2; i3++) {
                    i[] iVarArr2 = this.b;
                    if (iVarArr2[i3] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = iVarArr2[i3].d()[i2];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}

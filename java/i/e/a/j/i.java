package i.e.a.j;

/* loaded from: classes.dex */
public class i extends i.e.a.l.f {
    protected w[] a;
    protected h[] b;
    protected int c;
    protected int d;
    protected int e;
    protected boolean f = true;

    public i(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("Can not use negative/zero initial size: " + i2);
        }
        int i3 = 16;
        while (i3 < i2) {
            i3 += i3;
        }
        this.a = new w[i3];
        this.b = new h[i3 >> 1];
        this.e = i3 - 1;
        this.c = 0;
        this.d = ((i3 * 3) + 3) >> 2;
    }

    private void b() {
        w[] wVarArr = this.a;
        int length = wVarArr.length;
        w[] wVarArr2 = new w[length];
        this.a = wVarArr2;
        System.arraycopy(wVarArr, 0, wVarArr2, 0, length);
        h[] hVarArr = this.b;
        int length2 = hVarArr.length;
        h[] hVarArr2 = new h[length2];
        this.b = hVarArr2;
        System.arraycopy(hVarArr, 0, hVarArr2, 0, length2);
        this.f = true;
    }

    private void f() {
        w[] wVarArr = this.a;
        int length = wVarArr.length;
        int i2 = length + length;
        h[] hVarArr = this.b;
        this.a = new w[i2];
        this.b = new h[i2 >> 1];
        this.e = i2 - 1;
        int i3 = this.d;
        this.d = i3 + i3;
        int i4 = 0;
        for (w wVar : wVarArr) {
            if (wVar != null) {
                i4++;
                int iX = wVar.x() & this.e;
                w[] wVarArr2 = this.a;
                if (wVarArr2[iX] == null) {
                    wVarArr2[iX] = wVar;
                } else {
                    int i5 = iX >> 1;
                    h[] hVarArr2 = this.b;
                    hVarArr2[i5] = new h(wVar, hVarArr2[i5]);
                }
            }
        }
        int i6 = length >> 1;
        for (int i7 = 0; i7 < i6; i7++) {
            for (h hVarB = hVarArr[i7]; hVarB != null; hVarB = hVarB.b()) {
                i4++;
                w wVarC = hVarB.c();
                int iX2 = wVarC.x() & this.e;
                w[] wVarArr3 = this.a;
                if (wVarArr3[iX2] == null) {
                    wVarArr3[iX2] = wVarC;
                } else {
                    int i8 = iX2 >> 1;
                    h[] hVarArr3 = this.b;
                    hVarArr3[i8] = new h(wVarC, hVarArr3[i8]);
                }
            }
        }
        if (i4 == this.c) {
            return;
        }
        throw new Error("Internal error on SymbolTable.rehash(): had " + this.c + " entries; now have " + i4 + ".");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0018 A[PHI: r5
      0x0018: PHI (r5v7 int) = (r5v2 int), (r5v4 int) binds: [B:3:0x0016, B:8:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w a(char[] cArr, int i2, int i3, int i4) {
        w wVarV = w.v(new String(cArr, i2, i3).intern(), i4);
        int i5 = this.e & i4;
        boolean z = false;
        if (this.a[i5] != null) {
            if (this.c >= this.d) {
                f();
                i5 = this.e & i4;
                if (this.a[i5] == null) {
                    z = true;
                }
            }
        }
        if (!this.f) {
            b();
        }
        this.c++;
        if (z) {
            this.a[i5] = wVarV;
        } else {
            int i6 = i5 >> 1;
            h[] hVarArr = this.b;
            hVarArr[i6] = new h(wVarV, hVarArr[i6]);
        }
        return wVarV;
    }

    public w c(char[] cArr, int i2, int i3, int i4) {
        w wVarA;
        int i5 = this.e & i4;
        w wVar = this.a[i5];
        if (wVar == null) {
            return null;
        }
        if (wVar.w(cArr, i2, i3, i4)) {
            return wVar;
        }
        h hVar = this.b[i5 >> 1];
        if (hVar == null || (wVarA = hVar.a(cArr, i2, i3, i4)) == null) {
            return null;
        }
        return wVarA;
    }

    public boolean d() {
        return this.f;
    }

    public synchronized void e(i iVar) {
        if (iVar.g() <= g()) {
            return;
        }
        this.a = iVar.a;
        this.b = iVar.b;
        this.c = iVar.c;
        this.d = iVar.d;
        this.e = iVar.e;
        this.f = false;
        iVar.f = false;
    }

    public int g() {
        return this.c;
    }

    i(i iVar) {
        this.a = iVar.a;
        this.b = iVar.b;
        this.c = iVar.c;
        this.d = iVar.d;
        this.e = iVar.e;
    }
}

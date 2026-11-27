package i.f.a.v.n;

/* loaded from: classes.dex */
public final class c {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    private int[] b(b bVar) throws e {
        int iF = bVar.f();
        int i2 = 0;
        if (iF == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[iF];
        for (int i3 = 1; i3 < this.a.f() && i2 < iF; i3++) {
            if (bVar.c(i3) == 0) {
                iArr[i2] = this.a.h(i3);
                i2++;
            }
        }
        if (i2 == iF) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iH = this.a.h(iArr[i2]);
            int iJ = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 != i3) {
                    int iJ2 = this.a.j(iArr[i3], iH);
                    iJ = this.a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i2] = this.a.j(bVar.c(iH), this.a.h(iJ));
            if (this.a.d() != 0) {
                iArr2[i2] = this.a.j(iArr2[i2], iH);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i2) throws e {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b bVarG = this.a.g();
        b bVarE = this.a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = bVarE;
            b bVar5 = bVarG;
            bVarG = bVar4;
            if (bVar.f() < i2 / 2) {
                int iD = bVarG.d(0);
                if (iD == 0) {
                    throw new e("sigmaTilde(0) was zero");
                }
                int iH = this.a.h(iD);
                return new b[]{bVarG.h(iH), bVar.h(iH)};
            }
            if (bVar.g()) {
                throw new e("r_{i-1} was zero");
            }
            b bVarG2 = this.a.g();
            int iH2 = this.a.h(bVar.d(bVar.f()));
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int iF = bVar2.f() - bVar.f();
                int iJ = this.a.j(bVar2.d(bVar2.f()), iH2);
                bVarG2 = bVarG2.a(this.a.b(iF, iJ));
                bVar2 = bVar2.a(bVar.j(iF, iJ));
            }
            bVarE = bVarG2.i(bVarG).a(bVar5);
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i2) throws e {
        b bVar = new b(this.a, iArr);
        int[] iArr2 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.a;
            int iC = bVar.c(aVar.c(aVar.d() + i3));
            iArr2[(i2 - 1) - i3] = iC;
            if (iC != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        b[] bVarArrD = d(this.a.b(i2, 1), new b(this.a, iArr2), i2);
        b bVar2 = bVarArrD[0];
        b bVar3 = bVarArrD[1];
        int[] iArrB = b(bVar2);
        int[] iArrC = c(bVar3, iArrB);
        for (int i4 = 0; i4 < iArrB.length; i4++) {
            int length = (iArr.length - 1) - this.a.i(iArrB[i4]);
            if (length < 0) {
                throw new e("Bad error location");
            }
            iArr[length] = a.a(iArr[length], iArrC[i4]);
        }
    }
}

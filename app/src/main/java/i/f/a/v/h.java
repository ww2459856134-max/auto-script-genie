package i.f.a.v;

/* loaded from: classes.dex */
public abstract class h extends i.f.a.b {
    private static final byte[] d = new byte[0];
    private byte[] b;
    private final int[] c;

    public h(i.f.a.i iVar) {
        super(iVar);
        this.b = d;
        this.c = new int[32];
    }

    private static int g(int[] iArr) throws i.f.a.k {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 <= i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i4 - i6 <= length / 16) {
            throw i.f.a.k.a();
        }
        int i12 = i4 - 1;
        int i13 = -1;
        int i14 = i12;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i4 - i12) * (i3 - iArr[i12]);
            if (i16 > i13) {
                i14 = i12;
                i13 = i16;
            }
            i12--;
        }
        return i14 << 3;
    }

    private void h(int i2) {
        if (this.b.length < i2) {
            this.b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.c[i3] = 0;
        }
    }

    @Override // i.f.a.b
    public b b() throws i.f.a.k {
        i.f.a.i iVarE = e();
        int iD = iVarE.d();
        int iA = iVarE.a();
        b bVar = new b(iD, iA);
        h(iD);
        int[] iArr = this.c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] bArrC = iVarE.c((iA * i2) / 5, this.b);
            int i3 = (iD << 2) / 5;
            for (int i4 = iD / 5; i4 < i3; i4++) {
                int i5 = (bArrC[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrB = iVarE.b();
        for (int i6 = 0; i6 < iA; i6++) {
            int i7 = i6 * iD;
            for (int i8 = 0; i8 < iD; i8++) {
                if ((bArrB[i7 + i8] & 255) < iG) {
                    bVar.l(i8, i6);
                }
            }
        }
        return bVar;
    }

    @Override // i.f.a.b
    public a c(int i2, a aVar) throws i.f.a.k {
        i.f.a.i iVarE = e();
        int iD = iVarE.d();
        if (aVar == null || aVar.k() < iD) {
            aVar = new a(iD);
        } else {
            aVar.d();
        }
        h(iD);
        byte[] bArrC = iVarE.c(i2, this.b);
        int[] iArr = this.c;
        for (int i3 = 0; i3 < iD; i3++) {
            int i4 = (bArrC[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int iG = g(iArr);
        if (iD < 3) {
            for (int i5 = 0; i5 < iD; i5++) {
                if ((bArrC[i5] & 255) < iG) {
                    aVar.p(i5);
                }
            }
        } else {
            int i6 = 1;
            int i7 = bArrC[0] & 255;
            int i8 = bArrC[1] & 255;
            while (i6 < iD - 1) {
                int i9 = i6 + 1;
                int i10 = bArrC[i9] & 255;
                if ((((i8 << 2) - i7) - i10) / 2 < iG) {
                    aVar.p(i6);
                }
                i7 = i8;
                i6 = i9;
                i8 = i10;
            }
        }
        return aVar;
    }
}

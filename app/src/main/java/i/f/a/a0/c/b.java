package i.f.a.a0.c;

/* loaded from: classes.dex */
final class b {
    private final int a;
    private final byte[] b;

    private b(int i2, byte[] bArr) {
        this.a = i2;
        this.b = bArr;
    }

    static b[] b(byte[] bArr, u uVar, o oVar) {
        if (bArr.length != uVar.h()) {
            throw new IllegalArgumentException();
        }
        t tVarF = uVar.f(oVar);
        s[] sVarArrA = tVarF.a();
        int iA = 0;
        for (s sVar : sVarArrA) {
            iA += sVar.a();
        }
        b[] bVarArr = new b[iA];
        int i2 = 0;
        for (s sVar2 : sVarArrA) {
            int i3 = 0;
            while (i3 < sVar2.a()) {
                int iB = sVar2.b();
                bVarArr[i2] = new b(iB, new byte[tVarF.b() + iB]);
                i3++;
                i2++;
            }
        }
        int length = bVarArr[0].b.length;
        int i4 = iA - 1;
        while (i4 >= 0 && bVarArr[i4].b.length != length) {
            i4--;
        }
        int i5 = i4 + 1;
        int iB2 = length - tVarF.b();
        int i6 = 0;
        for (int i7 = 0; i7 < iB2; i7++) {
            int i8 = 0;
            while (i8 < i2) {
                bVarArr[i8].b[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        int i9 = i5;
        while (i9 < i2) {
            bVarArr[i9].b[iB2] = bArr[i6];
            i9++;
            i6++;
        }
        int length2 = bVarArr[0].b.length;
        while (iB2 < length2) {
            int i10 = 0;
            while (i10 < i2) {
                bVarArr[i10].b[i10 < i5 ? iB2 : iB2 + 1] = bArr[i6];
                i10++;
                i6++;
            }
            iB2++;
        }
        return bVarArr;
    }

    byte[] a() {
        return this.b;
    }

    int c() {
        return this.a;
    }
}

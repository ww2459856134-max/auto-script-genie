package i.f.a.w.b;

/* loaded from: classes.dex */
final class b {
    private final int a;
    private final byte[] b;

    private b(int i2, byte[] bArr) {
        this.a = i2;
        this.b = bArr;
    }

    static b[] b(byte[] bArr, j jVar) {
        i iVarD = jVar.d();
        h[] hVarArrA = iVarD.a();
        int iA = 0;
        for (h hVar : hVarArrA) {
            iA += hVar.a();
        }
        b[] bVarArr = new b[iA];
        int i2 = 0;
        for (h hVar2 : hVarArrA) {
            int i3 = 0;
            while (i3 < hVar2.a()) {
                int iB = hVar2.b();
                bVarArr[i2] = new b(iB, new byte[iVarD.b() + iB]);
                i3++;
                i2++;
            }
        }
        int length = bVarArr[0].b.length - iVarD.b();
        int i4 = length - 1;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                bVarArr[i7].b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        boolean z = jVar.i() == 24;
        int i8 = z ? 8 : i2;
        int i9 = 0;
        while (i9 < i8) {
            bVarArr[i9].b[i4] = bArr[i5];
            i9++;
            i5++;
        }
        int length2 = bVarArr[0].b.length;
        while (length < length2) {
            int i10 = 0;
            while (i10 < i2) {
                int i11 = z ? (i10 + 8) % i2 : i10;
                bVarArr[i11].b[(!z || i11 <= 7) ? length : length - 1] = bArr[i5];
                i10++;
                i5++;
            }
            length++;
        }
        if (i5 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    byte[] a() {
        return this.b;
    }

    int c() {
        return this.a;
    }
}

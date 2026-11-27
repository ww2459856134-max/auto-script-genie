package i.f.a.x.b;

import i.f.a.d;
import i.f.a.g;
import i.f.a.v.n.e;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {
    private final i.f.a.v.n.c a = new i.f.a.v.n.c(i.f.a.v.n.a.f1694o);

    private void a(byte[] bArr, int i2, int i3, int i4, int i5) throws d {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[i6 / i7];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & 255;
            }
        }
        try {
            this.a.a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (e unused) {
            throw d.a();
        }
    }

    public i.f.a.v.e b(i.f.a.v.b bVar, Map<i.f.a.e, ?> map) throws d, g {
        byte[] bArr;
        byte[] bArrA = new a(bVar).a();
        a(bArrA, 0, 10, 10, 0);
        int i2 = bArrA[0] & 15;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            a(bArrA, 20, 84, 40, 1);
            a(bArrA, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i2 != 5) {
                throw g.a();
            }
            a(bArrA, 20, 68, 56, 1);
            a(bArrA, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i2);
    }
}

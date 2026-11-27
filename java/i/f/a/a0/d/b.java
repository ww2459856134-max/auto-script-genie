package i.f.a.a0.d;

import i.f.a.k;
import i.f.a.s;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class b {
    private final i.f.a.v.b a;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;

    /* renamed from: i, reason: collision with root package name */
    private final s f1665i;
    private final List<a> b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f1664h = new int[3];

    b(i.f.a.v.b bVar, int i2, int i3, int i4, int i5, float f, s sVar) {
        this.a = bVar;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = f;
        this.f1665i = sVar;
    }

    private static float a(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float b(int i2, int i3, int i4, int i5) {
        i.f.a.v.b bVar = this.a;
        int iG = bVar.g();
        int[] iArr = this.f1664h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i2;
        while (i6 >= 0 && bVar.d(i3, i6) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i6--;
        }
        if (i6 >= 0 && iArr[1] <= i4) {
            while (i6 >= 0 && !bVar.d(i3, i6) && iArr[0] <= i4) {
                iArr[0] = iArr[0] + 1;
                i6--;
            }
            if (iArr[0] > i4) {
                return Float.NaN;
            }
            int i7 = i2 + 1;
            while (i7 < iG && bVar.d(i3, i7) && iArr[1] <= i4) {
                iArr[1] = iArr[1] + 1;
                i7++;
            }
            if (i7 != iG && iArr[1] <= i4) {
                while (i7 < iG && !bVar.d(i3, i7) && iArr[2] <= i4) {
                    iArr[2] = iArr[2] + 1;
                    i7++;
                }
                if (iArr[2] <= i4 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i5) * 5 < i5 * 2 && d(iArr)) {
                    return a(iArr, i7);
                }
            }
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f = this.g;
        float f2 = f / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f - iArr[i2]) >= f2) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i3);
        float fB = b(i2, (int) fA, iArr[1] * 2, i4);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.b) {
            if (aVar.f(f, fB, fA)) {
                return aVar.g(fB, fA, f);
            }
        }
        a aVar2 = new a(fA, fB, f);
        this.b.add(aVar2);
        s sVar = this.f1665i;
        if (sVar == null) {
            return null;
        }
        sVar.a(aVar2);
        return null;
    }

    a c() throws k {
        a aVarE;
        a aVarE2;
        int i2 = this.c;
        int i3 = this.f;
        int i4 = this.e + i2;
        int i5 = this.d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.a.d(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.a.d(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else {
                    if (d(iArr) && (aVarE2 = e(iArr, i7, i8)) != null) {
                        return aVarE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (d(iArr) && (aVarE = e(iArr, i7, i4)) != null) {
                return aVarE;
            }
        }
        if (this.b.isEmpty()) {
            throw k.a();
        }
        return this.b.get(0);
    }
}

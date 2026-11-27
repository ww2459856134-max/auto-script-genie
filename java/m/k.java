package m;

import java.util.Arrays;

/* loaded from: classes.dex */
final class k extends d {

    /* renamed from: h, reason: collision with root package name */
    final transient byte[][] f2253h;

    /* renamed from: i, reason: collision with root package name */
    final transient int[] f2254i;

    k(a aVar, int i2) {
        super(null);
        n.b(aVar.d, 0L, i2);
        i iVar = aVar.c;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = iVar.c;
            int i7 = iVar.b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            iVar = iVar.f;
        }
        this.f2253h = new byte[i5][];
        this.f2254i = new int[i5 * 2];
        i iVar2 = aVar.c;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f2253h;
            bArr[i8] = iVar2.a;
            int i9 = iVar2.c;
            int i10 = iVar2.b;
            i3 += i9 - i10;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f2254i;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            iVar2.d = true;
            i8++;
            iVar2 = iVar2.f;
        }
    }

    private int n(int i2) {
        int iBinarySearch = Arrays.binarySearch(this.f2254i, 0, this.f2253h.length, i2 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private d p() {
        return new d(o());
    }

    @Override // m.d
    public byte d(int i2) {
        n.b(this.f2254i[this.f2253h.length - 1], i2, 1L);
        int iN = n(i2);
        int i3 = iN == 0 ? 0 : this.f2254i[iN - 1];
        int[] iArr = this.f2254i;
        byte[][] bArr = this.f2253h;
        return bArr[iN][(i2 - i3) + iArr[bArr.length + iN]];
    }

    @Override // m.d
    public String e() {
        return p().e();
    }

    @Override // m.d
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.size() == size() && h(0, dVar, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // m.d
    byte[] f() {
        return o();
    }

    @Override // m.d
    public boolean h(int i2, d dVar, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int iN = n(i2);
        while (i4 > 0) {
            int i5 = iN == 0 ? 0 : this.f2254i[iN - 1];
            int iMin = Math.min(i4, ((this.f2254i[iN] - i5) + i5) - i2);
            int[] iArr = this.f2254i;
            byte[][] bArr = this.f2253h;
            if (!dVar.i(i3, bArr[iN], (i2 - i5) + iArr[bArr.length + iN], iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iN++;
        }
        return true;
    }

    @Override // m.d
    public int hashCode() {
        int i2 = this.d;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f2253h.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.f2253h[i3];
            int[] iArr = this.f2254i;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        this.d = i4;
        return i4;
    }

    @Override // m.d
    public boolean i(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int iN = n(i2);
        while (i4 > 0) {
            int i5 = iN == 0 ? 0 : this.f2254i[iN - 1];
            int iMin = Math.min(i4, ((this.f2254i[iN] - i5) + i5) - i2);
            int[] iArr = this.f2254i;
            byte[][] bArr2 = this.f2253h;
            if (!n.a(bArr2[iN], (i2 - i5) + iArr[bArr2.length + iN], bArr, i3, iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iN++;
        }
        return true;
    }

    @Override // m.d
    public d l(int i2, int i3) {
        return p().l(i2, i3);
    }

    @Override // m.d
    public String m() {
        return p().m();
    }

    public byte[] o() {
        int[] iArr = this.f2254i;
        byte[][] bArr = this.f2253h;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f2254i;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f2253h[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // m.d
    public int size() {
        return this.f2254i[this.f2253h.length - 1];
    }

    @Override // m.d
    public String toString() {
        return p().toString();
    }
}

package i.e.a.j;

/* loaded from: classes.dex */
public final class e extends i.e.a.l.f {
    private int a;
    private int b;
    private int[] c;
    private b[] d;
    private d[] e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private transient boolean f1578h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1579i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1580j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1581k;

    public e(int i2) {
        int i3 = 16;
        if (i2 < 16) {
            i2 = i3;
        } else if (((i2 - 1) & i2) != 0) {
            while (i3 < i2) {
                i3 += i3;
            }
            i2 = i3;
        }
        this.a = 0;
        this.f1579i = false;
        this.f1580j = false;
        this.b = i2 - 1;
        this.c = new int[i2];
        this.d = new b[i2];
        this.f1581k = true;
        this.e = null;
        this.g = 0;
        this.f1578h = false;
    }

    public static final int b(int i2) {
        int i3 = i2 * 31;
        int i4 = i3 ^ (i3 >>> 16);
        return i4 ^ (i4 >>> 8);
    }

    public static final int c(int i2, int i3) {
        int i4 = (i2 * 31) + i3;
        int i5 = i4 ^ (i4 >>> 16);
        return i5 ^ (i5 >>> 8);
    }

    public static final int d(int[] iArr, int i2) {
        int i3 = iArr[0];
        for (int i4 = 1; i4 < i2; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i3 >>> 16) ^ i3;
        return i5 ^ (i5 >>> 8);
    }

    private void e(int i2, b bVar) {
        int iG;
        if (this.f1579i) {
            o();
        }
        if (this.f1578h) {
            m();
        }
        this.a++;
        int i3 = this.b & i2;
        if (this.d[i3] == null) {
            this.c[i3] = i2 << 8;
            if (this.f1580j) {
                p();
            }
            this.d[i3] = bVar;
        } else {
            if (this.f1581k) {
                n();
            }
            this.f++;
            int i4 = this.c[i3];
            int i5 = i4 & 255;
            if (i5 == 0) {
                iG = this.g;
                if (iG <= 254) {
                    this.g = iG + 1;
                    if (iG >= this.e.length) {
                        f();
                    }
                } else {
                    iG = g();
                }
                this.c[i3] = (i4 & (-256)) | (iG + 1);
            } else {
                iG = i5 - 1;
            }
            d[] dVarArr = this.e;
            dVarArr[iG] = new d(bVar, dVarArr[iG]);
        }
        int length = this.c.length;
        int i6 = this.a;
        if (i6 > (length >> 1)) {
            int i7 = length >> 2;
            if (i6 > length - i7) {
                this.f1578h = true;
            } else if (this.f >= i7) {
                this.f1578h = true;
            }
        }
    }

    private void f() {
        d[] dVarArr = this.e;
        int length = dVarArr.length;
        d[] dVarArr2 = new d[length + length];
        this.e = dVarArr2;
        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
    }

    private int g() {
        d[] dVarArr = this.e;
        int i2 = this.g;
        int i3 = Integer.MAX_VALUE;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            int iC = dVarArr[i5].c();
            if (iC < i3) {
                if (iC == 1) {
                    return i5;
                }
                i4 = i5;
                i3 = iC;
            }
        }
        return i4;
    }

    private void m() {
        int iG;
        this.f1578h = false;
        this.f1580j = false;
        int length = this.c.length;
        int i2 = length + length;
        this.c = new int[i2];
        this.b = i2 - 1;
        b[] bVarArr = this.d;
        this.d = new b[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            b bVar = bVarArr[i4];
            if (bVar != null) {
                i3++;
                int iHashCode = bVar.hashCode();
                int i5 = this.b & iHashCode;
                this.d[i5] = bVar;
                this.c[i5] = iHashCode << 8;
            }
        }
        int i6 = this.g;
        if (i6 == 0) {
            return;
        }
        this.f = 0;
        this.g = 0;
        this.f1581k = false;
        d[] dVarArr = this.e;
        this.e = new d[dVarArr.length];
        for (int i7 = 0; i7 < i6; i7++) {
            for (d dVar = dVarArr[i7]; dVar != null; dVar = dVar.b) {
                i3++;
                b bVar2 = dVar.a;
                int iHashCode2 = bVar2.hashCode();
                int i8 = this.b & iHashCode2;
                int[] iArr = this.c;
                int i9 = iArr[i8];
                b[] bVarArr2 = this.d;
                if (bVarArr2[i8] == null) {
                    iArr[i8] = iHashCode2 << 8;
                    bVarArr2[i8] = bVar2;
                } else {
                    this.f++;
                    int i10 = i9 & 255;
                    if (i10 == 0) {
                        iG = this.g;
                        if (iG <= 254) {
                            this.g = iG + 1;
                            if (iG >= this.e.length) {
                                f();
                            }
                        } else {
                            iG = g();
                        }
                        this.c[i8] = (i9 & (-256)) | (iG + 1);
                    } else {
                        iG = i10 - 1;
                    }
                    d[] dVarArr2 = this.e;
                    dVarArr2[iG] = new d(bVar2, dVarArr2[iG]);
                }
            }
        }
        if (i3 == this.a) {
            return;
        }
        throw new Error("Internal error: count after rehash " + i3 + "; should be " + this.a);
    }

    private void n() {
        d[] dVarArr = this.e;
        if (dVarArr == null) {
            this.e = new d[32];
        } else {
            int length = dVarArr.length;
            d[] dVarArr2 = new d[length];
            this.e = dVarArr2;
            System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
        }
        this.f1581k = false;
    }

    private void o() {
        int[] iArr = this.c;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        this.c = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.f1579i = false;
    }

    private void p() {
        b[] bVarArr = this.d;
        int length = bVarArr.length;
        b[] bVarArr2 = new b[length];
        this.d = bVarArr2;
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        this.f1580j = false;
    }

    public b a(int i2, String str, int i3, int[] iArr, int i4) {
        b bVarA = c.b().a(i2, str, i3, iArr, i4);
        e(i2, bVarA);
        return bVarA;
    }

    public b h(int i2, int i3, int i4) {
        int i5 = this.b & i2;
        int i6 = this.c[i5];
        if ((((i6 >> 8) ^ i2) << 8) == 0) {
            b bVar = this.d[i5];
            if (bVar == null) {
                return null;
            }
            if (bVar.t(i3, i4)) {
                return bVar;
            }
        } else if (i6 == 0) {
            return null;
        }
        int i7 = i6 & 255;
        if (i7 > 0) {
            d dVar = this.e[i7 - 1];
            if (dVar != null) {
                return dVar.a(i2, i3, i4);
            }
        }
        return null;
    }

    public b i(int i2, int[] iArr, int i3) {
        if (i3 < 3) {
            return h(i2, iArr[0], i3 >= 2 ? iArr[1] : 0);
        }
        int i4 = this.b & i2;
        int i5 = this.c[i4];
        if ((((i5 >> 8) ^ i2) << 8) == 0) {
            b bVar = this.d[i4];
            if (bVar == null) {
                return null;
            }
            if (bVar.u(iArr, i3)) {
                return bVar;
            }
        } else if (i5 == 0) {
            return null;
        }
        int i6 = i5 & 255;
        if (i6 > 0) {
            d dVar = this.e[i6 - 1];
            if (dVar != null) {
                return dVar.b(i2, iArr, i3);
            }
        }
        return null;
    }

    public void j() {
        this.f1579i = true;
        this.f1580j = true;
        this.f1581k = true;
    }

    public boolean k() {
        return !this.f1579i;
    }

    public boolean l(e eVar) {
        int i2 = eVar.a;
        if (i2 <= this.a) {
            return false;
        }
        this.a = i2;
        this.b = eVar.b;
        this.c = eVar.c;
        this.d = eVar.d;
        this.e = eVar.e;
        this.f = eVar.f;
        this.g = eVar.g;
        eVar.j();
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[PNameTable, size: ");
        sb.append(this.a);
        sb.append('/');
        sb.append(this.c.length);
        sb.append(", ");
        sb.append(this.f);
        sb.append(" coll; avg length: ");
        int i2 = this.a;
        for (int i3 = 0; i3 < this.g; i3++) {
            for (int i4 = 1; i4 <= this.e[i3].c(); i4++) {
                i2 += i4;
            }
        }
        int i5 = this.a;
        sb.append(i5 == 0 ? 0.0d : i2 / i5);
        sb.append(']');
        return sb.toString();
    }

    e(e eVar) {
        this.a = eVar.a;
        this.b = eVar.b;
        this.c = eVar.c;
        this.d = eVar.d;
        this.e = eVar.e;
        this.f = eVar.f;
        this.g = eVar.g;
        this.f1578h = false;
        this.f1579i = true;
        this.f1580j = true;
        this.f1581k = true;
    }
}

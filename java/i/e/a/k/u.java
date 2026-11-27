package i.e.a.k;

import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class u extends i.e.a.l.f {
    final s a;
    final u b;
    private int c;
    private int d;
    private int[] e;
    private r[] f;
    private t[] g;

    /* renamed from: h, reason: collision with root package name */
    private int f1634h;

    /* renamed from: i, reason: collision with root package name */
    private int f1635i;

    /* renamed from: j, reason: collision with root package name */
    private transient boolean f1636j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1637k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1638l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1639m;

    protected u(int i2) {
        this.a = null;
        this.b = null;
        int i3 = 16;
        if (i2 < 16) {
            i2 = i3;
        } else if (((i2 - 1) & i2) != 0) {
            while (i3 < i2) {
                i3 += i3;
            }
            i2 = i3;
        }
        this.c = 0;
        this.f1637k = false;
        this.f1638l = false;
        this.d = i2 - 1;
        this.e = new int[i2];
        this.f = new r[i2];
        this.f1639m = true;
        this.g = null;
        this.f1635i = 0;
        this.f1636j = false;
    }

    private void a(r rVar) {
        int iD;
        if (this.f1637k) {
            m();
        }
        if (this.f1636j) {
            k();
        }
        int iHashCode = rVar.hashCode();
        this.c++;
        int i2 = this.d & iHashCode;
        if (this.f[i2] == null) {
            this.e[i2] = iHashCode << 8;
            if (this.f1638l) {
                n();
            }
            this.f[i2] = rVar;
        } else {
            if (this.f1639m) {
                l();
            }
            this.f1634h++;
            int i3 = this.e[i2];
            int i4 = i3 & 255;
            if (i4 == 0) {
                iD = this.f1635i;
                if (iD <= 254) {
                    this.f1635i = iD + 1;
                    if (iD >= this.g.length) {
                        c();
                    }
                } else {
                    iD = d();
                }
                this.e[i2] = (i3 & (-256)) | (iD + 1);
            } else {
                iD = i4 - 1;
            }
            t[] tVarArr = this.g;
            tVarArr[iD] = new t(rVar, tVarArr[iD]);
        }
        int length = this.e.length;
        int i5 = this.c;
        if (i5 > (length >> 1)) {
            int i6 = length >> 2;
            if (i5 > length - i6) {
                this.f1636j = true;
            } else if (this.f1634h >= i6) {
                this.f1636j = true;
            }
        }
    }

    private void c() {
        t[] tVarArr = this.g;
        int length = tVarArr.length;
        t[] tVarArr2 = new t[length + length];
        this.g = tVarArr2;
        System.arraycopy(tVarArr, 0, tVarArr2, 0, length);
    }

    private int d() {
        t[] tVarArr = this.g;
        int i2 = this.f1635i;
        int i3 = Integer.MAX_VALUE;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            int iC = tVarArr[i5].c();
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

    private synchronized boolean i(u uVar) {
        int i2 = uVar.c;
        if (i2 <= this.c) {
            return false;
        }
        this.c = i2;
        this.d = uVar.d;
        this.e = uVar.e;
        this.f = uVar.f;
        this.g = uVar.g;
        this.f1634h = uVar.f1634h;
        this.f1635i = uVar.f1635i;
        return true;
    }

    private void k() {
        int iD;
        this.f1636j = false;
        this.f1638l = false;
        int length = this.e.length;
        int i2 = length + length;
        this.e = new int[i2];
        this.d = i2 - 1;
        r[] rVarArr = this.f;
        this.f = new r[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            r rVar = rVarArr[i4];
            if (rVar != null) {
                i3++;
                int iHashCode = rVar.hashCode();
                int i5 = this.d & iHashCode;
                this.f[i5] = rVar;
                this.e[i5] = iHashCode << 8;
            }
        }
        int i6 = this.f1635i;
        if (i6 == 0) {
            return;
        }
        this.f1634h = 0;
        this.f1635i = 0;
        this.f1639m = false;
        t[] tVarArr = this.g;
        this.g = new t[tVarArr.length];
        for (int i7 = 0; i7 < i6; i7++) {
            for (t tVar = tVarArr[i7]; tVar != null; tVar = tVar.b) {
                i3++;
                r rVar2 = tVar.a;
                int iHashCode2 = rVar2.hashCode();
                int i8 = this.d & iHashCode2;
                int[] iArr = this.e;
                int i9 = iArr[i8];
                r[] rVarArr2 = this.f;
                if (rVarArr2[i8] == null) {
                    iArr[i8] = iHashCode2 << 8;
                    rVarArr2[i8] = rVar2;
                } else {
                    this.f1634h++;
                    int i10 = i9 & 255;
                    if (i10 == 0) {
                        iD = this.f1635i;
                        if (iD <= 254) {
                            this.f1635i = iD + 1;
                            if (iD >= this.g.length) {
                                c();
                            }
                        } else {
                            iD = d();
                        }
                        this.e[i8] = (i9 & (-256)) | (iD + 1);
                    } else {
                        iD = i10 - 1;
                    }
                    t[] tVarArr2 = this.g;
                    tVarArr2[iD] = new t(rVar2, tVarArr2[iD]);
                }
            }
        }
        if (i3 == this.c) {
            return;
        }
        throw new Error("Internal error: count after rehash " + i3 + "; should be " + this.c);
    }

    private void l() {
        t[] tVarArr = this.g;
        if (tVarArr == null) {
            this.g = new t[32];
        } else {
            int length = tVarArr.length;
            t[] tVarArr2 = new t[length];
            this.g = tVarArr2;
            System.arraycopy(tVarArr, 0, tVarArr2, 0, length);
        }
        this.f1639m = false;
    }

    private void m() {
        int[] iArr = this.e;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        this.e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.f1637k = false;
    }

    private void n() {
        r[] rVarArr = this.f;
        int length = rVarArr.length;
        r[] rVarArr2 = new r[length];
        this.f = rVarArr2;
        System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
        this.f1638l = false;
    }

    protected synchronized u b(s sVar) {
        return new u(this, sVar);
    }

    public r e(String str) throws XMLStreamException {
        int i2;
        r rVarA;
        r rVar;
        int iHashCode = str.hashCode();
        int i3 = this.d & iHashCode;
        int i4 = this.e[i3];
        if (((iHashCode ^ (i4 >> 8)) << 8) == 0 && (rVar = this.f[i3]) != null && rVar.e(str)) {
            return rVar;
        }
        if (i4 != 0 && (i2 = i4 & 255) > 0) {
            t tVar = this.g[i2 - 1];
            if (tVar != null && (rVarA = tVar.a(str)) != null) {
                return rVarA;
            }
        }
        r rVarA2 = this.a.a(str);
        a(rVarA2);
        return rVarA2;
    }

    public r f(String str, String str2) throws XMLStreamException {
        int i2;
        r rVarB;
        r rVar;
        int iHashCode = str2.hashCode() ^ str.hashCode();
        int i3 = this.d & iHashCode;
        int i4 = this.e[i3];
        if (((iHashCode ^ (i4 >> 8)) << 8) == 0 && (rVar = this.f[i3]) != null && rVar.f(str, str2)) {
            return rVar;
        }
        if (i4 != 0 && (i2 = i4 & 255) > 0) {
            t tVar = this.g[i2 - 1];
            if (tVar != null && (rVarB = tVar.b(str, str2)) != null) {
                return rVarB;
            }
        }
        r rVarB2 = this.a.b(str, str2);
        a(rVarB2);
        return rVarB2;
    }

    public void g() {
        this.f1637k = true;
        this.f1638l = true;
        this.f1639m = true;
    }

    public boolean h() {
        return !this.f1637k;
    }

    public boolean j() {
        boolean zI = this.b.i(this);
        g();
        return zI;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[WNameTable, size: ");
        sb.append(this.c);
        sb.append('/');
        sb.append(this.e.length);
        sb.append(", ");
        sb.append(this.f1634h);
        sb.append(" coll; avg length: ");
        int i2 = this.c;
        for (int i3 = 0; i3 < this.f1635i; i3++) {
            for (int i4 = 1; i4 <= this.g[i3].c(); i4++) {
                i2 += i4;
            }
        }
        int i5 = this.c;
        sb.append(i5 == 0 ? 0.0d : i2 / i5);
        sb.append(']');
        return sb.toString();
    }

    private u(u uVar, s sVar) {
        this.b = uVar;
        this.a = sVar;
        this.c = uVar.c;
        this.d = uVar.d;
        this.e = uVar.e;
        this.f = uVar.f;
        this.g = uVar.g;
        this.f1634h = uVar.f1634h;
        this.f1635i = uVar.f1635i;
        this.f1636j = false;
        this.f1637k = true;
        this.f1638l = true;
        this.f1639m = true;
    }
}

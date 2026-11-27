package k.a0.a;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class s extends k.x.g {
    private static k.y.c p = k.y.c.b(s.class);
    private byte[] d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1851h;

    /* renamed from: i, reason: collision with root package name */
    private int f1852i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f1853j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f1854k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f1855l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f1856m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList f1857n;

    /* renamed from: o, reason: collision with root package name */
    private k.x.f f1858o;

    public s(byte[] bArr, k.w wVar) throws d {
        int i2;
        this.d = bArr;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte[] bArr2 = k.x.g.b;
            if (i4 >= bArr2.length) {
                this.f1857n = new ArrayList();
                byte[] bArr3 = this.d;
                this.e = k.x.s0.d(bArr3[44], bArr3[45], bArr3[46], bArr3[47]);
                byte[] bArr4 = this.d;
                this.f = k.x.s0.d(bArr4[60], bArr4[61], bArr4[62], bArr4[63]);
                byte[] bArr5 = this.d;
                this.g = k.x.s0.d(bArr5[48], bArr5[49], bArr5[50], bArr5[51]);
                byte[] bArr6 = this.d;
                this.f1851h = k.x.s0.d(bArr6[68], bArr6[69], bArr6[70], bArr6[71]);
                byte[] bArr7 = this.d;
                int iD = k.x.s0.d(bArr7[72], bArr7[73], bArr7[74], bArr7[75]);
                this.f1852i = iD;
                int i5 = this.e;
                this.f1856m = new int[i5];
                int i6 = 76;
                i5 = iD != 0 ? 109 : i5;
                for (int i7 = 0; i7 < i5; i7++) {
                    this.f1856m[i7] = k.x.s0.d(bArr[i6], bArr[i6 + 1], bArr[i6 + 2], bArr[i6 + 3]);
                    i6 += 4;
                }
                while (i3 < this.f1852i) {
                    int i8 = (this.f1851h + 1) * 512;
                    int iMin = Math.min(this.e - i5, 127);
                    int i9 = i5;
                    while (true) {
                        i2 = i5 + iMin;
                        if (i9 >= i2) {
                            break;
                        }
                        this.f1856m[i9] = k.x.s0.d(bArr[i8], bArr[i8 + 1], bArr[i8 + 2], bArr[i8 + 3]);
                        i8 += 4;
                        i9++;
                    }
                    if (i2 < this.e) {
                        this.f1851h = k.x.s0.d(bArr[i8], bArr[i8 + 1], bArr[i8 + 2], bArr[i8 + 3]);
                    }
                    i3++;
                    i5 = i2;
                }
                l();
                o();
                this.f1853j = m(this.g);
                n();
                return;
            }
            if (this.d[i4] != bArr2[i4]) {
                throw new d(d.f);
            }
            i4++;
        }
    }

    private k.x.f c(String str, k.x.f fVar) {
        int i2 = fVar.f2019h;
        if (i2 == -1) {
            return null;
        }
        k.x.f fVarG = g(i2);
        if (fVarG.a.equalsIgnoreCase(str)) {
            return fVarG;
        }
        k.x.f fVarG2 = fVarG;
        do {
            int i3 = fVarG2.f;
            if (i3 == -1) {
                k.x.f fVarG3 = fVarG;
                do {
                    int i4 = fVarG3.g;
                    if (i4 == -1) {
                        return c(str, fVarG);
                    }
                    fVarG3 = g(i4);
                } while (!fVarG3.a.equalsIgnoreCase(str));
                return fVarG3;
            }
            fVarG2 = g(i3);
        } while (!fVarG2.a.equalsIgnoreCase(str));
        return fVarG2;
    }

    private byte[] d(k.x.f fVar) {
        int i2 = fVar.e;
        int i3 = i2 / 512;
        if (i2 % 512 != 0) {
            i3++;
        }
        byte[] bArr = new byte[i3 * 512];
        int i4 = fVar.d;
        int i5 = 0;
        while (i4 != -2 && i5 < i3) {
            System.arraycopy(this.d, (i4 + 1) * 512, bArr, i5 * 512, 512);
            i5++;
            i4 = this.f1854k[i4];
        }
        if (i4 != -2 && i5 == i3) {
            p.f("Property storage size inconsistent with block chain.");
        }
        return bArr;
    }

    private k.x.f g(int i2) {
        return (k.x.f) this.f1857n.get(i2);
    }

    private k.x.f h(String str) throws d {
        Iterator it = this.f1857n.iterator();
        k.x.f fVar = null;
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            k.x.f fVar2 = (k.x.f) it.next();
            if (fVar2.a.equalsIgnoreCase(str)) {
                z = z2;
                fVar = fVar2;
                z2 = true;
            }
        }
        if (z) {
            p.f("found multiple copies of property set " + str);
        }
        if (z2) {
            return fVar;
        }
        throw new d(d.g);
    }

    private byte[] i(k.x.f fVar) throws d {
        int[] iArr;
        byte[] bArrM = m(this.f1858o.d);
        byte[] bArr = new byte[0];
        int i2 = fVar.d;
        int i3 = 0;
        while (true) {
            iArr = this.f1855l;
            if (i3 > iArr.length || i2 == -2) {
                break;
            }
            byte[] bArr2 = new byte[bArr.length + 64];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bArrM, i2 * 64, bArr2, bArr.length, 64);
            int i4 = this.f1855l[i2];
            if (i4 == -1) {
                p.f("Incorrect terminator for small block stream " + fVar.a);
                i2 = -2;
            } else {
                i2 = i4;
            }
            i3++;
            bArr = bArr2;
        }
        if (i3 <= iArr.length) {
            return bArr;
        }
        throw new d(d.f1792i);
    }

    private void l() {
        this.f1854k = new int[(this.e * 512) / 4];
        int i2 = 0;
        for (int i3 = 0; i3 < this.e; i3++) {
            int i4 = (this.f1856m[i3] + 1) * 512;
            for (int i5 = 0; i5 < 128; i5++) {
                int[] iArr = this.f1854k;
                byte[] bArr = this.d;
                iArr[i2] = k.x.s0.d(bArr[i4], bArr[i4 + 1], bArr[i4 + 2], bArr[i4 + 3]);
                i4 += 4;
                i2++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r2 > r3.length) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        throw new k.a0.a.d(k.a0.a.d.f1792i);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] m(int i2) throws d {
        byte[] bArr = new byte[0];
        int i3 = 0;
        while (true) {
            int[] iArr = this.f1854k;
            if (i3 > iArr.length || i2 == -2) {
                break;
            }
            byte[] bArr2 = new byte[bArr.length + 512];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(this.d, (i2 + 1) * 512, bArr2, bArr.length, 512);
            int[] iArr2 = this.f1854k;
            if (iArr2[i2] == i2) {
                throw new d(d.f1792i);
            }
            i2 = iArr2[i2];
            i3++;
            bArr = bArr2;
        }
    }

    private void n() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f1853j;
            if (i2 >= bArr.length) {
                break;
            }
            byte[] bArr2 = new byte[128];
            System.arraycopy(bArr, i2, bArr2, 0, 128);
            k.x.f fVar = new k.x.f(this, bArr2);
            String str = fVar.a;
            if (str == null || str.length() == 0) {
                if (fVar.b == 5) {
                    fVar.a = "Root Entry";
                    p.f("Property storage name for " + fVar.b + " is empty - setting to Root Entry");
                } else if (fVar.e != 0) {
                    p.f("Property storage type " + fVar.b + " is non-empty and has no associated name");
                }
            }
            this.f1857n.add(fVar);
            if (fVar.a.equalsIgnoreCase("Root Entry")) {
                this.f1858o = fVar;
            }
            i2 += 128;
        }
        if (this.f1858o == null) {
            this.f1858o = (k.x.f) this.f1857n.get(0);
        }
    }

    private void o() throws d {
        int[] iArr;
        int i2 = this.f;
        this.f1855l = new int[0];
        if (i2 == -1) {
            p.f("invalid small block depot number");
            return;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            iArr = this.f1854k;
            if (i3 > iArr.length || i2 == -2) {
                break;
            }
            int[] iArr2 = this.f1855l;
            int[] iArr3 = new int[iArr2.length + 128];
            this.f1855l = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            int i5 = (i2 + 1) * 512;
            for (int i6 = 0; i6 < 128; i6++) {
                int[] iArr4 = this.f1855l;
                byte[] bArr = this.d;
                iArr4[i4] = k.x.s0.d(bArr[i5], bArr[i5 + 1], bArr[i5 + 2], bArr[i5 + 3]);
                i5 += 4;
                i4++;
            }
            i2 = this.f1854k[i2];
            i3++;
        }
        if (i3 > iArr.length) {
            throw new d(d.f1792i);
        }
    }

    public k.x.f b(String str) {
        return c(str, this.f1858o);
    }

    public int e() {
        return this.f1857n.size();
    }

    public k.x.f f(int i2) {
        return g(i2);
    }

    public byte[] j(int i2) throws d {
        k.x.f fVarG = g(i2);
        return (fVarG.e >= 4096 || fVarG.a.equalsIgnoreCase("Root Entry")) ? d(fVarG) : i(fVarG);
    }

    public byte[] k(String str) throws d {
        k.x.f fVarC = c(str, this.f1858o);
        if (fVarC == null) {
            fVarC = h(str);
        }
        return (fVarC.e >= 4096 || str.equalsIgnoreCase("Root Entry")) ? d(fVarC) : i(fVarC);
    }
}

package i.e.a.j;

import java.text.MessageFormat;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class a {
    protected int e;
    protected int f;
    private v[] b = null;
    private char[] c = null;
    protected int[] d = null;
    private int[] g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1571h = true;

    /* renamed from: i, reason: collision with root package name */
    private String f1572i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f1573j = null;
    private int a = 0;

    protected a(z zVar) {
    }

    private final boolean a(n.b.a.n.c cVar) {
        if (!(cVar instanceof n.b.a.m.o.c)) {
            return false;
        }
        ((n.b.a.m.o.c) cVar).d();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
    
        r0 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r0 >= r9) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
    
        if (r7[r0] <= ' ') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        r6 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
    
        r4 = r0;
        r0 = r8;
        r8 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0020, code lost:
    
        r2 = r0 + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r6.a(r7, r8, r0) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (a(r6) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        r0 = r8;
        r8 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        r6 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
    
        r0 = r8;
        r8 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        throw new n.b.a.n.e(new java.lang.String(r7, r0, r8 - r0), r6.getMessage(), r10.D(), r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int f(n.b.a.n.c cVar, char[] cArr, int i2, int i3, e0 e0Var) throws XMLStreamException {
        int i4 = 0;
        int i5 = i2;
        loop0: while (i2 < i3) {
            while (true) {
                try {
                    if (cArr[i2] > ' ') {
                        break;
                    }
                    i2++;
                    if (i2 >= i3) {
                        break loop0;
                    }
                } catch (IllegalArgumentException e) {
                    e = e;
                }
            }
        }
        return i4;
    }

    private static final boolean p(char c) {
        return c <= ' ';
    }

    private void q(int i2, int i3) {
        this.f1572i = MessageFormat.format(i.e.a.i.b.f1566m, this.b[i2].toString(), Integer.valueOf(i2), this.b[i3].toString(), Integer.valueOf(i3));
    }

    public char[] b() {
        return this.c;
    }

    public byte[] c(int i2, n.b.a.n.a aVar, n.b.a.m.o.b bVar, e0 e0Var) throws XMLStreamException {
        int i3;
        if (i2 < 0 || i2 >= this.a) {
            throw new IllegalArgumentException("Invalid index " + i2 + "; current element has only " + this.a + " attributes");
        }
        int i4 = 0;
        if (i2 == 0) {
            i3 = this.g[0];
        } else {
            int[] iArr = this.g;
            int i5 = iArr[i2 - 1];
            i3 = iArr[i2];
            i4 = i5;
        }
        int i6 = i3 - i4;
        bVar.h(aVar, true, this.c, i4, i3, null);
        try {
            return bVar.b();
        } catch (IllegalArgumentException e) {
            throw new n.b.a.n.e(new String(this.c, i4, i6), e.getMessage(), e0Var.D(), e);
        }
    }

    public final void d(int i2, n.b.a.n.d dVar) throws IllegalArgumentException {
        int i3;
        if (i2 < 0 || i2 >= this.a) {
            throw new IllegalArgumentException("Invalid index " + i2 + "; current element has only " + this.a + " attributes");
        }
        int i4 = 0;
        if (i2 == 0) {
            i3 = this.g[0];
        } else {
            int[] iArr = this.g;
            int i5 = iArr[i2 - 1];
            i3 = iArr[i2];
            i4 = i5;
        }
        char[] cArr = this.c;
        while (i4 < i3) {
            if (!p(cArr[i4])) {
                do {
                    i3--;
                    if (i3 <= i4) {
                        break;
                    }
                } while (p(cArr[i3]));
                dVar.b(cArr, i4, i3 + 1);
                return;
            }
            i4++;
        }
        dVar.c();
        throw null;
    }

    public final int e(int i2, n.b.a.n.c cVar, e0 e0Var) throws XMLStreamException {
        int i3;
        int i4;
        if (i2 < 0 || i2 >= this.a) {
            throw new IllegalArgumentException("Invalid index " + i2 + "; current element has only " + this.a + " attributes");
        }
        if (i2 == 0) {
            i3 = this.g[0];
            i4 = 0;
        } else {
            int[] iArr = this.g;
            int i5 = iArr[i2 - 1];
            i3 = iArr[i2];
            i4 = i5;
        }
        return f(cVar, this.c, i4, i3, e0Var);
    }

    public int g(String str, String str2) {
        int i2 = this.e;
        if (i2 < 1) {
            int i3 = this.a;
            for (int i4 = 0; i4 < i3; i4++) {
                if (this.b[i4].b(str, str2)) {
                    return i4;
                }
            }
            return -1;
        }
        int iD = v.d(str, str2);
        int i5 = this.d[(i2 - 1) & iD];
        if (i5 > 0) {
            int i6 = i5 - 1;
            if (this.b[i6].b(str, str2)) {
                return i6;
            }
            int i7 = this.f;
            while (i2 < i7) {
                int[] iArr = this.d;
                if (iArr[i2] == iD) {
                    int i8 = iArr[i2 + 1];
                    if (this.b[i8].b(str, str2)) {
                        return i8;
                    }
                }
                i2 += 2;
            }
        }
        return -1;
    }

    public final int h(int i2) {
        if (this.f1571h) {
            return 0;
        }
        this.f1571h = true;
        int i3 = this.a;
        this.g[i3 - 1] = i2;
        if (i3 >= 3) {
            return i();
        }
        this.e = 0;
        if (i3 == 2) {
            v[] vVarArr = this.b;
            if (vVarArr[0].a(vVarArr[1])) {
                q(0, 1);
                return -1;
            }
        }
        return i3;
    }

    public final int i() {
        int i2 = this.a;
        v[] vVarArr = this.b;
        int[] iArrC = this.d;
        int i3 = 8;
        while (i3 < (i2 >> 2) + i2) {
            i3 += i3;
        }
        this.e = i3;
        int i4 = (i3 >> 4) + i3;
        if (iArrC == null || iArrC.length < i4) {
            iArrC = new int[i4];
        } else {
            iArrC[7] = 0;
            iArrC[6] = 0;
            iArrC[5] = 0;
            iArrC[4] = 0;
            iArrC[3] = 0;
            iArrC[2] = 0;
            iArrC[1] = 0;
            iArrC[0] = 0;
            for (int i5 = 8; i5 < i3; i5++) {
                iArrC[i5] = 0;
            }
        }
        int i6 = i3 - 1;
        int i7 = i3;
        for (int i8 = 0; i8 < i2; i8++) {
            v vVar = vVarArr[i8];
            int iC = vVar.c();
            int i9 = iC & i6;
            int i10 = iArrC[i9];
            if (i10 == 0) {
                iArrC[i9] = i8 + 1;
            } else {
                int i11 = i10 - 1;
                if (vVarArr[i11].a(vVar) && this.f1572i == null) {
                    q(i11, i8);
                }
                int i12 = i7 + 1;
                if (i12 >= iArrC.length) {
                    iArrC = i.e.a.l.c.c(iArrC, 8);
                }
                int i13 = i3;
                while (true) {
                    if (i13 >= i7) {
                        break;
                    }
                    if (iArrC[i13] == iC) {
                        int i14 = iArrC[i13 + 1];
                        if (vVarArr[i14].a(vVar)) {
                            if (this.f1572i == null) {
                                q(i14, i8);
                            }
                        }
                    }
                    i13 += 2;
                }
                iArrC[i7] = iC;
                i7 = i12 + 1;
                iArrC[i12] = i8;
            }
        }
        this.f = i7;
        this.d = iArrC;
        if (this.f1572i == null) {
            return i2;
        }
        return -1;
    }

    public final int j() {
        return this.a;
    }

    public String k() {
        return this.f1572i;
    }

    public final v l(int i2) {
        return this.b[i2];
    }

    public final QName m(int i2) {
        return this.b[i2].e();
    }

    public String n(int i2) {
        int i3 = this.a;
        if (this.f1573j == null) {
            int i4 = this.g[i3 - 1];
            this.f1573j = i4 == 0 ? "" : new String(this.c, 0, i4);
        }
        if (i2 == 0) {
            if (i3 == 1) {
                return this.f1573j;
            }
            int i5 = this.g[0];
            return i5 == 0 ? "" : this.f1573j.substring(0, i5);
        }
        int[] iArr = this.g;
        int i6 = iArr[i2 - 1];
        int i7 = iArr[i2];
        return i6 == i7 ? "" : this.f1573j.substring(i6, i7);
    }

    public String o(String str, String str2) {
        int iG = g(str, str2);
        if (iG >= 0) {
            return n(iG);
        }
        return null;
    }

    public char[] r(v vVar, int i2) {
        int i3 = 0;
        if (this.f1571h) {
            this.f1571h = false;
            this.a = 0;
            this.f1573j = null;
            if (this.c == null) {
                this.b = new v[12];
                this.c = new char[120];
                this.g = new int[12];
            }
        } else {
            int i4 = this.a;
            int[] iArr = this.g;
            if (i4 >= iArr.length) {
                v[] vVarArr = this.b;
                int length = iArr.length;
                int i5 = length + length;
                this.g = new int[i5];
                this.b = new v[i5];
                while (i3 < length) {
                    this.g[i3] = iArr[i3];
                    this.b[i3] = vVarArr[i3];
                    i3++;
                }
            }
            if (i4 > 0) {
                this.g[i4 - 1] = i2;
            }
            i3 = i4;
        }
        this.b[i3] = vVar;
        this.a++;
        return this.c;
    }

    public char[] s() {
        char[] cArr = this.c;
        char[] cArrB = i.e.a.l.c.b(cArr, cArr.length);
        this.c = cArrB;
        return cArrB;
    }
}

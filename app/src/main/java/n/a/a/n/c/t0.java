package n.a.a.n.c;

import n.a.a.n.c.t1.j6;
import n.a.a.n.c.u1.c2;
import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.p2;

/* loaded from: classes.dex */
public final class t0 {
    private final t a;
    private final int b;
    private final int c;
    private final int d;
    private final p e;
    private final n1 f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2388h;

    static {
        j6 j6Var = k1.a;
    }

    public t0(n1 n1Var, t tVar, int i2, int i3, int i4, p pVar) {
        this(n1Var, tVar, i2, i3, i4, pVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static n.a.a.n.e.s a(n.a.a.n.e.s sVar, String str) throws NumberFormatException {
        int i2;
        int i3;
        String upperCase = str.toUpperCase(n.a.a.o.a1.e());
        int iIndexOf = upperCase.indexOf(82);
        int iIndexOf2 = upperCase.indexOf(67);
        if (iIndexOf < 0 || iIndexOf2 <= iIndexOf) {
            throw new IllegalArgumentException(str + " is not a valid R1C1 reference");
        }
        String strTrim = str.substring(iIndexOf + 1, iIndexOf2).trim();
        String strTrim2 = str.substring(iIndexOf2 + 1).trim();
        int i4 = 0;
        int i5 = -1;
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            i2 = Integer.parseInt(strTrim.substring(1, strTrim.length() - 1).trim());
        } else {
            if (!strTrim.isEmpty()) {
                i3 = Integer.parseInt(strTrim);
                i2 = 0;
                if (!strTrim2.startsWith("[") && strTrim2.endsWith("]")) {
                    i4 = Integer.parseInt(strTrim2.substring(1, strTrim2.length() - 1).trim());
                } else if (!strTrim2.isEmpty()) {
                    i5 = Integer.parseInt(strTrim2);
                }
                return new n.a.a.n.e.s(i3 < 0 ? i3 - 1 : sVar.m() + i2, i5 < 0 ? i5 - 1 : sVar.l() + i4);
            }
            i2 = 0;
        }
        i3 = -1;
        if (!strTrim2.startsWith("[")) {
            if (!strTrim2.isEmpty()) {
            }
        }
        return new n.a.a.n.e.s(i3 < 0 ? i3 - 1 : sVar.m() + i2, i5 < 0 ? i5 - 1 : sVar.l() + i4);
    }

    private static n.a.a.n.e.r b(String str, n.a.a.n.a aVar) {
        return str.length() < 1 ? n.a.a.n.e.r.BAD_CELL_OR_NAMED_RANGE : n.a.a.n.e.s.c(str, aVar);
    }

    private n.a.a.n.c.r1.w0 c(Object obj) {
        if (obj == null) {
            throw new IllegalStateException("Array item cannot be null");
        }
        if (obj instanceof String) {
            return new n.a.a.n.c.r1.m0((String) obj);
        }
        if (obj instanceof Double) {
            return new n.a.a.n.c.r1.x(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return n.a.a.n.c.r1.m.v(((Boolean) obj).booleanValue());
        }
        if (obj instanceof n.a.a.n.c.q1.c) {
            return n.a.a.n.c.r1.o.w(((n.a.a.n.c.q1.c) obj).a());
        }
        throw new IllegalArgumentException("Unexpected constant class (" + obj.getClass().getName() + ")");
    }

    private h1 f(String str, String str2) {
        n1 n1VarR;
        if (str == null) {
            n1VarR = this.f;
        } else {
            if (str2 == null) {
                throw new IllegalArgumentException("sheetName must not be null if workbookName is provided");
            }
            try {
                n1VarR = this.f.r(str);
            } catch (h unused) {
                return null;
            }
        }
        int iT = str2 == null ? this.b : n1VarR.t(str2);
        if (iT < 0) {
            return null;
        }
        return new h1(n1VarR, this.e, iT);
    }

    private n.a.a.n.c.r1.w0 m(q qVar, String str) {
        try {
            n1 n1VarR = this.f.r(str);
            n nVarQ = n1VarR.q(qVar.b(), qVar.a() - 1);
            if (nVarQ != null && nVarQ.e()) {
                if (nVarQ.b().length > 1) {
                    throw new IllegalStateException("Complex name formulas not supported yet");
                }
                t0 t0Var = new t0(n1VarR, n1VarR.x(), -1, -1, -1, this.e);
                k2 k2Var = nVarQ.b()[0];
                if (k2Var instanceof p2) {
                    return t0Var.q((p2) k2Var);
                }
                if (k2Var instanceof n.a.a.n.c.u1.b1) {
                    return t0Var.h((n.a.a.n.c.u1.b1) k2Var);
                }
            }
            return n.a.a.n.c.r1.o.f;
        } catch (h unused) {
            return n.a.a.n.c.r1.o.f;
        }
    }

    private n.a.a.n.c.r1.w0 n(c2 c2Var) {
        int iG = c2Var.c() != null ? this.a.g(c2Var.c()) : -1;
        String strR = c2Var.r();
        n nVarA = this.a.a(strR, iG);
        return nVarA != null ? new n.a.a.n.c.r1.q(nVarA) : new n.a.a.n.c.r1.s(strR);
    }

    private static n.a.a.n.e.r p(String str) {
        String upperCase = str.toUpperCase(n.a.a.o.a1.e());
        int iIndexOf = upperCase.indexOf(82);
        int iIndexOf2 = upperCase.indexOf(67);
        return iIndexOf != -1 ? iIndexOf2 == -1 ? n.a.a.n.e.r.ROW : n.a.a.n.e.r.CELL : iIndexOf2 == -1 ? n.a.a.n.e.r.BAD_CELL_OR_NAMED_RANGE : n.a.a.n.e.r.COLUMN;
    }

    private static int y(String str) {
        return Integer.parseInt(str) - 1;
    }

    private static int z(String str) {
        return n.a.a.n.e.s.d(str);
    }

    public void A(boolean z) {
        this.f2388h = z;
    }

    f1 d(String str, String str2, int i2) {
        return e(this.a.o(str, str2, i2));
    }

    f1 e(r rVar) {
        n1 n1VarR;
        int iG;
        int iG2;
        if (rVar == null || rVar.b() == null) {
            n1VarR = this.f;
            iG = rVar == null ? 0 : this.a.g(rVar.a());
            iG2 = rVar instanceof s ? this.a.g(((s) rVar).c()) : -1;
        } else {
            String strB = rVar.b();
            try {
                n1VarR = this.f.r(strB);
                iG = n1VarR.t(rVar.a());
                iG2 = rVar instanceof s ? n1VarR.t(((s) rVar).c()) : -1;
                if (iG < 0) {
                    throw new IllegalStateException("Invalid sheet name '" + rVar.a() + "' in bool '" + strB + "'.");
                }
            } catch (h e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
        if (iG2 == -1) {
            iG2 = iG;
        }
        int i2 = (iG2 - iG) + 1;
        h1[] h1VarArr = new h1[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            h1VarArr[i3] = new h1(n1VarR, this.e, i3 + iG);
        }
        return new f1(iG, iG2, h1VarArr);
    }

    public j6 g(String str) {
        return this.f.l(str);
    }

    public n.a.a.n.c.r1.w0 h(n.a.a.n.c.u1.b1 b1Var) {
        return new n0(b1Var.getFirstRow(), b1Var.getFirstColumn(), b1Var.getLastRow(), b1Var.getLastColumn(), d(b1Var.c(), b1Var.g(), b1Var.f()));
    }

    public n.a.a.n.c.r1.w0 i(int i2, int i3, int i4, int i5) {
        return new n0(i2, i3, i4, i5, s());
    }

    public n.a.a.n.c.r1.w0 j(int i2, int i3, int i4, int i5, Object[][] objArr) {
        n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[objArr.length * objArr[0].length];
        int i6 = 0;
        for (Object[] objArr2 : objArr) {
            int i7 = 0;
            while (i7 < objArr[0].length) {
                w0VarArr[i6] = c(objArr2[i7]);
                i7++;
                i6++;
            }
        }
        return new e(i2, i3, i4, i5, w0VarArr);
    }

    public int k() {
        return this.d;
    }

    public n.a.a.n.c.r1.w0 l(String str, String str2, String str3, String str4, boolean z) {
        int iZ;
        int iZ2;
        int iY;
        int iY2;
        int iK;
        int iT;
        h1 h1VarF = f(str, str2);
        if (h1VarF == null) {
            return n.a.a.n.c.r1.o.f;
        }
        f1 f1Var = new f1(this.b, h1VarF);
        n.a.a.n.a aVarB = this.a.b();
        n.a.a.n.e.r rVarB = z ? b(str3, aVarB) : p(str3);
        int[] iArr = s0.a;
        int i2 = iArr[rVarB.ordinal()];
        if (i2 == 1) {
            return n.a.a.n.c.r1.o.f;
        }
        if (i2 == 2) {
            n nVarA = this.a.a(str3, this.b);
            if (nVarA != null) {
                if (nVarA.a()) {
                    return this.f.j(nVarA.b(), this);
                }
                throw new IllegalStateException("Specified name '" + str3 + "' is not a range as expected.");
            }
            throw new IllegalStateException("Specified name '" + str3 + "' is not found in the workbook (sheetIndex=" + this.b + ").");
        }
        if (str4 == null) {
            int i3 = iArr[rVarB.ordinal()];
            if (i3 == 3) {
                if (z) {
                    return n.a.a.n.c.r1.o.f;
                }
                try {
                    String strTrim = str3.substring(str3.toUpperCase(n.a.a.o.a1.e()).indexOf(67) + 1).trim();
                    if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
                        iK = k() + Integer.parseInt(strTrim.substring(1, strTrim.length() - 1).trim());
                    } else {
                        if (strTrim.isEmpty()) {
                            return n.a.a.n.c.r1.o.f;
                        }
                        iK = Integer.parseInt(strTrim) - 1;
                    }
                    return new n0(0, iK, aVarB.c(), iK, f1Var);
                } catch (Exception unused) {
                    return n.a.a.n.c.r1.o.f;
                }
            }
            if (i3 != 4) {
                if (i3 == 5) {
                    n.a.a.n.e.s sVar = z ? new n.a.a.n.e.s(str3) : a(new n.a.a.n.e.s(t(), k()), str3);
                    return new o0(sVar.m(), sVar.l(), f1Var);
                }
                throw new IllegalStateException("Unexpected reference classification of '" + str3 + "'.");
            }
            if (z) {
                return n.a.a.n.c.r1.o.f;
            }
            try {
                String strTrim2 = str3.substring(str3.toUpperCase(n.a.a.o.a1.e()).indexOf(82) + 1).trim();
                if (strTrim2.startsWith("[") && strTrim2.endsWith("]")) {
                    iT = t() + Integer.parseInt(strTrim2.substring(1, strTrim2.length() - 1).trim());
                } else {
                    if (strTrim2.isEmpty()) {
                        return n.a.a.n.c.r1.o.f;
                    }
                    iT = Integer.parseInt(strTrim2) - 1;
                }
                return new n0(iT, 0, iT, aVarB.a(), f1Var);
            } catch (Exception unused2) {
                return n.a.a.n.c.r1.o.f;
            }
        }
        n.a.a.n.e.r rVarB2 = z ? b(str4, aVarB) : p(str4);
        int i4 = iArr[rVarB2.ordinal()];
        if (i4 == 1) {
            return n.a.a.n.c.r1.o.f;
        }
        if (i4 == 2) {
            throw new IllegalStateException("Cannot evaluate '" + str3 + "'. Indirect evaluation of defined names not supported yet");
        }
        if (rVarB2 != rVarB) {
            return n.a.a.n.c.r1.o.f;
        }
        int i5 = iArr[rVarB.ordinal()];
        if (i5 == 3) {
            int iC = aVarB.c();
            iZ = z(str3);
            iZ2 = z(str4);
            iY = iC;
            iY2 = 0;
        } else if (i5 == 4) {
            iZ2 = aVarB.a();
            iZ = 0;
            iY2 = y(str3);
            iY = y(str4);
        } else {
            if (i5 != 5) {
                throw new IllegalStateException("Unexpected reference classification of '" + str3 + "'.");
            }
            n.a.a.n.e.s sVar2 = z ? new n.a.a.n.e.s(str3) : a(new n.a.a.n.e.s(t(), k()), str3);
            int iM = sVar2.m();
            short sL = sVar2.l();
            n.a.a.n.e.s sVar3 = z ? new n.a.a.n.e.s(str4) : a(new n.a.a.n.e.s(t(), k()), str4);
            iY = sVar3.m();
            iZ2 = sVar3.l();
            iZ = sL;
            iY2 = iM;
        }
        return new n0(iY2, iZ, iY, iZ2, f1Var);
    }

    public n.a.a.n.c.r1.w0 o(c2 c2Var) {
        r rVarO = this.a.o(c2Var.c(), null, c2Var.f());
        if (rVarO == null || rVarO.b() == null) {
            return n(c2Var);
        }
        return m(this.a.e(c2Var.r(), c2Var.c(), c2Var.f()), rVarO.b());
    }

    public n.a.a.n.c.r1.w0 q(p2 p2Var) {
        return new o0(p2Var.s(), p2Var.r(), d(p2Var.c(), p2Var.g(), p2Var.f()));
    }

    public n.a.a.n.c.r1.w0 r(int i2, int i3) {
        return new o0(i2, i3, s());
    }

    public f1 s() {
        return new f1(this.b, new h1(this.f, this.e, this.b));
    }

    public int t() {
        return this.c;
    }

    public int u() {
        return this.b;
    }

    public t v() {
        return this.a;
    }

    public boolean w() {
        return this.f2388h;
    }

    public boolean x() {
        return this.g;
    }

    public t0(n1 n1Var, t tVar, int i2, int i3, int i4, p pVar, boolean z) {
        this.f = n1Var;
        this.a = tVar;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = pVar;
        this.g = z;
    }
}

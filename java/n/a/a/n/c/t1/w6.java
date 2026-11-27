package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class w6 extends dc implements x2 {
    public static boolean m(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        Boolean boolD = n.a.a.n.c.r1.z.d(n.a.a.n.c.r1.z.i(w0Var, i2, i3), false);
        if (boolD == null) {
            return false;
        }
        return boolD.booleanValue();
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            return m(w0Var, i2, i3) ? w0Var2 == n.a.a.n.c.r1.u.a ? n.a.a.n.c.r1.l.a : w0Var2 : w0Var3 == n.a.a.n.c.r1.u.a ? n.a.a.n.c.r1.l.a : w0Var3;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.x2
    public n.a.a.n.c.r1.w0 h(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 2 || w0VarArr.length > 3) {
            return n.a.a.n.c.r1.o.e;
        }
        return l(w0VarArr[0], w0VarArr[1], w0VarArr.length == 2 ? n.a.a.n.c.r1.m.b : w0VarArr[2], i2, i3);
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            return m(w0Var, i2, i3) ? w0Var2 == n.a.a.n.c.r1.u.a ? n.a.a.n.c.r1.l.a : w0Var2 : n.a.a.n.c.r1.m.b;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    n.a.a.n.c.r1.w0 l(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, int i2, int i3) {
        int i4;
        int row;
        int iA;
        int iB;
        int row2;
        int width;
        int iA2;
        int iB2;
        int row3;
        int iB3;
        n.a.a.n.c.r1.w0 w0VarA;
        n.a.a.n.c.r1.w0 w0VarA2;
        n.a.a.n.c.r1.w0 w0VarA3;
        int i5;
        n.a.a.n.c.r1.w0 w0Var4 = w0Var;
        if (w0Var4 instanceof n.a.a.n.c.r1.j) {
            n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var4;
            int width2 = jVar.getWidth();
            iA = jVar.a();
            iB = jVar.getFirstColumn();
            row = jVar.getFirstRow();
            i4 = width2;
        } else if (w0Var4 instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var4;
            iB = c0Var.b();
            row = c0Var.getRow();
            i4 = 1;
            iA = 1;
        } else {
            i4 = 1;
            row = 0;
            iA = 1;
            iB = 0;
        }
        if (w0Var2 instanceof n.a.a.n.c.r1.j) {
            n.a.a.n.c.r1.j jVar2 = (n.a.a.n.c.r1.j) w0Var2;
            width = jVar2.getWidth();
            iA2 = jVar2.a();
            iB2 = jVar2.getFirstColumn();
            row2 = jVar2.getFirstRow();
        } else if (w0Var2 instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var2 = (n.a.a.n.c.r1.c0) w0Var2;
            iB2 = c0Var2.b();
            row2 = c0Var2.getRow();
            width = 1;
            iA2 = 1;
        } else {
            row2 = 0;
            width = 1;
            iA2 = 1;
            iB2 = 0;
        }
        if (w0Var3 instanceof n.a.a.n.c.r1.j) {
            n.a.a.n.c.r1.j jVar3 = (n.a.a.n.c.r1.j) w0Var3;
            iB3 = jVar3.getFirstColumn();
            row3 = jVar3.getFirstRow();
        } else if (w0Var3 instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var3 = (n.a.a.n.c.r1.c0) w0Var3;
            iB3 = c0Var3.b();
            row3 = c0Var3.getRow();
        } else {
            row3 = 0;
            iB3 = 0;
        }
        int iMax = Math.max(i4, width);
        int iMax2 = Math.max(iA, iA2);
        int i6 = iMax2 * iMax;
        n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[i6];
        int i7 = 0;
        int i8 = 0;
        while (i8 < iMax2) {
            int i9 = i7;
            int i10 = 0;
            while (i10 < iMax) {
                int i11 = row;
                try {
                    w0VarA = n.a.a.n.c.r1.z.i(w0Var4, row + i8, iB + i10);
                } catch (n.a.a.n.c.r1.p e) {
                    w0VarA = e.a();
                } catch (n.a.a.n.c.x unused) {
                    w0VarA = n.a.a.n.c.r1.o.g;
                }
                n.a.a.n.c.r1.w0 w0Var5 = w0VarA;
                try {
                    w0VarA2 = n.a.a.n.c.r1.z.i(w0Var2, row2 + i8, iB2 + i10);
                } catch (n.a.a.n.c.r1.p e2) {
                    w0VarA2 = e2.a();
                } catch (n.a.a.n.c.x unused2) {
                    w0VarA2 = n.a.a.n.c.r1.o.g;
                }
                n.a.a.n.c.r1.w0 w0Var6 = w0VarA2;
                try {
                    w0VarA3 = n.a.a.n.c.r1.z.i(w0Var3, row3 + i8, iB3 + i10);
                } catch (n.a.a.n.c.r1.p e3) {
                    w0VarA3 = e3.a();
                } catch (n.a.a.n.c.x unused3) {
                    w0VarA3 = n.a.a.n.c.r1.o.g;
                }
                if (w0Var5 instanceof n.a.a.n.c.r1.o) {
                    w0VarArr[i9] = w0Var5;
                    i9++;
                } else {
                    try {
                        Boolean boolD = n.a.a.n.c.r1.z.d(w0Var5, false);
                        i5 = i9 + 1;
                        if (boolD != null) {
                            try {
                                if (boolD.booleanValue()) {
                                    w0VarA3 = w0Var6;
                                }
                            } catch (n.a.a.n.c.r1.p e4) {
                                e = e4;
                                i9 = i5;
                                i5 = i9 + 1;
                                w0VarArr[i9] = e.a();
                                i9 = i5;
                                i10++;
                                w0Var4 = w0Var;
                                row = i11;
                            }
                        }
                        w0VarArr[i9] = w0VarA3;
                    } catch (n.a.a.n.c.r1.p e5) {
                        e = e5;
                    }
                    i9 = i5;
                }
                i10++;
                w0Var4 = w0Var;
                row = i11;
            }
            i8++;
            w0Var4 = w0Var;
            i7 = i9;
        }
        return i6 == 1 ? w0VarArr[0] : new n.a.a.n.c.e(i2, i3, (i2 + iMax2) - 1, (i3 + iMax) - 1, w0VarArr);
    }
}

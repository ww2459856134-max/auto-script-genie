package n.a.a.n.c.t1;

import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes.dex */
public interface x2 {
    static n.a.a.n.c.r1.w0 b(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, int i2, int i3, BiFunction<n.a.a.n.c.r1.w0, n.a.a.n.c.r1.w0, n.a.a.n.c.r1.w0> biFunction) {
        int i4;
        int row;
        int iA;
        int iB;
        int row2;
        int width;
        int iA2;
        int iB2;
        n.a.a.n.c.r1.w0 w0VarA;
        n.a.a.n.c.r1.w0 w0VarA2;
        n.a.a.n.c.r1.w0 w0Var3 = w0Var;
        if (w0Var3 instanceof n.a.a.n.c.r1.j) {
            n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var3;
            int width2 = jVar.getWidth();
            iA = jVar.a();
            iB = jVar.getFirstColumn();
            row = jVar.getFirstRow();
            i4 = width2;
        } else if (w0Var3 instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var3;
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
        int iMax = Math.max(i4, width);
        int iMax2 = Math.max(iA, iA2);
        int i5 = iMax2 * iMax;
        n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[i5];
        int i6 = 0;
        int i7 = 0;
        while (i7 < iMax2) {
            int i8 = i6;
            int i9 = 0;
            while (i9 < iMax) {
                try {
                    w0VarA = n.a.a.n.c.r1.z.i(w0Var3, row + i7, iB + i9);
                } catch (n.a.a.n.c.x unused) {
                    w0VarA = n.a.a.n.c.r1.o.g;
                } catch (RuntimeException e) {
                    if (!e.getMessage().startsWith("Don't know how to evaluate name")) {
                        throw e;
                    }
                    w0VarA = n.a.a.n.c.r1.o.g;
                } catch (n.a.a.n.c.r1.p e2) {
                    w0VarA = e2.a();
                }
                n.a.a.n.c.r1.w0 w0Var4 = w0VarA;
                try {
                    w0VarA2 = n.a.a.n.c.r1.z.i(w0Var2, row2 + i7, iB2 + i9);
                } catch (RuntimeException e3) {
                    if (!e3.getMessage().startsWith("Don't know how to evaluate name")) {
                        throw e3;
                    }
                    w0VarA2 = n.a.a.n.c.r1.o.g;
                } catch (n.a.a.n.c.r1.p e4) {
                    w0VarA2 = e4.a();
                } catch (n.a.a.n.c.x unused2) {
                    w0VarA2 = n.a.a.n.c.r1.o.g;
                }
                if (w0Var4 instanceof n.a.a.n.c.r1.o) {
                    w0VarArr[i8] = w0Var4;
                    i8++;
                } else if (w0VarA2 instanceof n.a.a.n.c.r1.o) {
                    w0VarArr[i8] = w0VarA2;
                    i8++;
                } else {
                    w0VarArr[i8] = biFunction.apply(w0Var4, w0VarA2);
                    i8++;
                }
                i9++;
                w0Var3 = w0Var;
            }
            i7++;
            w0Var3 = w0Var;
            i6 = i8;
        }
        return i5 == 1 ? w0VarArr[0] : new n.a.a.n.c.e(i2, i3, (i2 + iMax2) - 1, (i3 + iMax) - 1, w0VarArr);
    }

    static n.a.a.n.c.r1.w0 f(n.a.a.n.c.r1.w0 w0Var, int i2, int i3, Function<n.a.a.n.c.r1.w0, n.a.a.n.c.r1.w0> function) {
        int row;
        int iB;
        int i4;
        int iA;
        n.a.a.n.c.r1.w0 w0VarA;
        if (w0Var instanceof n.a.a.n.c.r1.j) {
            n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
            int width = jVar.getWidth();
            iA = jVar.a();
            iB = jVar.getFirstColumn();
            row = jVar.getFirstRow();
            i4 = width;
        } else {
            if (w0Var instanceof n.a.a.n.c.r1.c0) {
                n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
                iB = c0Var.b();
                row = c0Var.getRow();
            } else {
                row = 0;
                iB = 0;
            }
            i4 = 1;
            iA = 1;
        }
        int iMax = Math.max(i4, 1);
        int iMax2 = Math.max(iA, 1);
        int i5 = iMax2 * iMax;
        n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[i5];
        int i6 = 0;
        int i7 = 0;
        while (i7 < iMax2) {
            int i8 = i6;
            int i9 = 0;
            while (i9 < iMax) {
                try {
                    w0VarA = n.a.a.n.c.r1.z.i(w0Var, row + i7, iB + i9);
                } catch (n.a.a.n.c.r1.p e) {
                    w0VarA = e.a();
                } catch (n.a.a.n.c.x unused) {
                    w0VarA = n.a.a.n.c.r1.o.g;
                } catch (RuntimeException e2) {
                    if (!e2.getMessage().startsWith("Don't know how to evaluate name")) {
                        throw e2;
                    }
                    w0VarA = n.a.a.n.c.r1.o.g;
                }
                w0VarArr[i8] = function.apply(w0VarA);
                i9++;
                i8++;
            }
            i7++;
            i6 = i8;
        }
        return i5 == 1 ? w0VarArr[0] : new n.a.a.n.c.e(i2, i3, (i2 + iMax2) - 1, (i3 + iMax) - 1, w0VarArr);
    }

    default n.a.a.n.c.r1.w0 a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3, Function<n.a.a.n.c.r1.w0, n.a.a.n.c.r1.w0> function) {
        return f(w0Var, i2, i3, function);
    }

    default n.a.a.n.c.r1.w0 d(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, int i2, int i3, BiFunction<n.a.a.n.c.r1.w0, n.a.a.n.c.r1.w0, n.a.a.n.c.r1.w0> biFunction) {
        return b(w0Var, w0Var2, i2, i3, biFunction);
    }

    n.a.a.n.c.r1.w0 h(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3);
}

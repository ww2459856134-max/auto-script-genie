package n.a.a.n.c.t1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;

/* loaded from: classes.dex */
public class k6 extends c6 {
    public static final p6 a = new k6();

    private k6() {
    }

    static int l(double d, double[] dArr) {
        int iBinarySearch = Arrays.binarySearch(dArr, d);
        return iBinarySearch >= 0 ? iBinarySearch + 1 : -iBinarySearch;
    }

    static int[] m(double[] dArr, double[] dArr2) {
        int[] iArr = new int[dArr2.length + 1];
        for (double d : dArr) {
            int iL = l(d, dArr2) - 1;
            iArr[iL] = iArr[iL] + 1;
        }
        return iArr;
    }

    static /* synthetic */ n.a.a.n.c.r1.x[] n(int i2) {
        return new n.a.a.n.c.r1.x[i2];
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        v8 v8Var = new v8(false, false);
        try {
            return new n.a.a.n.c.e(i2, i3, (r8.length + i2) - 1, i3, (n.a.a.n.c.r1.x[]) Arrays.stream(m(v8Var.p(w0Var), v8Var.p(w0Var2))).boxed().map(new Function() { // from class: n.a.a.n.c.t1.p1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return new n.a.a.n.c.r1.x(((Integer) obj).intValue());
                }
            }).toArray(new IntFunction() { // from class: n.a.a.n.c.t1.m
                @Override // java.util.function.IntFunction
                public final Object apply(int i4) {
                    return k6.n(i4);
                }
            }));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}

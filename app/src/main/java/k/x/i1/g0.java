package k.x.i1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g0 {
    private static g0[] c = new g0[0];
    public int a;
    public String b;

    g0(int i2, String str) {
        this.a = i2;
        this.b = str;
        g0[] g0VarArr = c;
        g0[] g0VarArr2 = new g0[g0VarArr.length + 1];
        c = g0VarArr2;
        System.arraycopy(g0VarArr, 0, g0VarArr2, 0, g0VarArr.length);
        c[g0VarArr.length] = this;
    }

    public static g0 a(int i2) {
        g0 g0Var = h0.f2072n;
        for (int i3 = 0; i3 < c.length && g0Var == h0.f2072n; i3++) {
            g0[] g0VarArr = c;
            if (g0VarArr[i3].a == i2) {
                g0Var = g0VarArr[i3];
            }
        }
        return g0Var;
    }

    public String toString() {
        return this.b;
    }
}

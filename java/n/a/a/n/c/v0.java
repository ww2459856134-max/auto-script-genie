package n.a.a.n.c;

import n.a.a.n.c.u1.k2;

/* loaded from: classes.dex */
final class v0 {
    private final k2[] a;
    private int b = 0;

    public v0(int i2) {
        this.a = new k2[i2];
    }

    public void a(k2 k2Var) {
        if (k2Var == null) {
            throw new IllegalArgumentException("token must not be null");
        }
        k2[] k2VarArr = this.a;
        int i2 = this.b;
        k2VarArr[i2] = k2Var;
        this.b = i2 + 1;
    }

    public int b() {
        int i2 = this.b;
        this.b = i2 + 1;
        return i2;
    }

    public k2[] c() {
        return this.a;
    }

    public void d(int i2, k2 k2Var) {
        k2[] k2VarArr = this.a;
        if (k2VarArr[i2] == null) {
            k2VarArr[i2] = k2Var;
            return;
        }
        throw new IllegalStateException("Invalid placeholder index (" + i2 + ")");
    }

    public int e(int i2, int i3) {
        int iL = 0;
        while (i2 < i3) {
            iL += this.a[i2].l();
            i2++;
        }
        return iL;
    }
}

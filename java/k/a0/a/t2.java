package k.a0.a;

import java.util.ArrayList;

/* loaded from: classes.dex */
class t2 {

    /* renamed from: i, reason: collision with root package name */
    private static k.y.c f1862i = k.y.c.b(t2.class);
    private int a;
    private int b;
    private int c;
    private int d;
    private b e;
    private ArrayList f;
    private byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private y2 f1863h;

    public t2(f2 f2Var, b bVar, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var) {
        this.f1863h = y2Var;
        byte[] bArrC = f2Var.c();
        this.a = k.x.s0.c(bArrC[0], bArrC[1]);
        this.b = k.x.s0.c(bArrC[2], bArrC[3]);
        this.c = bArrC[4] & 255;
        this.d = bArrC[5] & 255;
        this.f = new ArrayList();
        this.e = bVar;
        byte[] bArr = new byte[bArrC.length - 10];
        this.g = bArr;
        System.arraycopy(bArrC, 10, bArr, 0, bArr.length);
    }

    public boolean a(b bVar) {
        int iB;
        int row = bVar.getRow();
        if (row < this.a || row > this.b || (iB = bVar.b()) < this.c || iB > this.d) {
            return false;
        }
        this.f.add(bVar);
        return true;
    }

    k.c[] b(k.x.n0 n0Var, boolean z) {
        k.c[] cVarArr = new k.c[this.f.size() + 1];
        b bVar = this.e;
        int i2 = 0;
        if (bVar == null) {
            f1862i.f("Shared formula template formula is null");
            return new k.c[0];
        }
        bVar.E(this.g);
        if (this.e.getType() == k.f.g) {
            u2 u2Var = (u2) this.e;
            u2Var.F();
            if (n0Var.i(this.e.z())) {
                r2 r2Var = new r2(u2Var, n0Var, z, this.f1863h, u2Var.B());
                this.e = r2Var;
                r2Var.E(u2Var.D());
            }
        }
        cVarArr[0] = this.e;
        while (i2 < this.f.size()) {
            b r2Var2 = (b) this.f.get(i2);
            if (r2Var2.getType() == k.f.g) {
                u2 u2Var2 = (u2) r2Var2;
                if (n0Var.i(r2Var2.z())) {
                    r2Var2 = new r2(u2Var2, n0Var, z, this.f1863h, u2Var2.B());
                }
            }
            r2Var2.E(this.g);
            i2++;
            cVarArr[i2] = r2Var2;
        }
        return cVarArr;
    }

    b c() {
        return this.e;
    }
}

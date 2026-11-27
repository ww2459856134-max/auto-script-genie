package k.x.i1;

import k.x.z0;

/* loaded from: classes.dex */
public class e implements k.x.l, c0 {
    private e0 a;
    private h0 b;
    private int c;
    private int d;
    private k.a0.a.j0 e;
    private t f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f2055h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2056i;

    static {
        k.y.c.b(e.class);
    }

    public e(e0 e0Var, h0 h0Var, t tVar, int i2, int i3, k.a0.a.j0 j0Var, k.w wVar) {
        this.a = e0Var;
        this.b = h0Var;
        this.c = i2;
        this.d = i3;
        this.e = j0Var;
        boolean z = true;
        if (e0Var != null) {
            this.f = tVar;
            tVar.a(e0Var.x().c());
            this.g = this.f.c() - 1;
        }
        this.f2056i = false;
        if ((e0Var == null || h0Var == null) && (e0Var != null || h0Var != null)) {
            z = false;
        }
        k.y.a.a(z);
    }

    private void e() {
        k.a0.a.j0 j0Var = this.e;
        int i2 = this.c;
        this.f2055h = j0Var.g(i2, this.d - i2);
        this.f2056i = true;
    }

    @Override // k.x.l
    public byte[] a() {
        if (!this.f2056i) {
            e();
        }
        return this.f2055h;
    }

    e0 b() {
        return this.a;
    }

    h0 c() {
        return this.b;
    }

    y d() {
        return this.f.d(this.g);
    }

    public void f(k.x.r0 r0Var, k.x.r0 r0Var2, k.x.r0 r0Var3) {
        if (!this.f2056i) {
            e();
        }
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f2055h;
            if (i2 >= bArr.length) {
                return;
            }
            int iC = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
            byte[] bArr2 = this.f2055h;
            int iC2 = k.x.s0.c(bArr2[i2 + 2], bArr2[i2 + 3]);
            z0 z0VarA = z0.a(iC);
            if (z0VarA == z0.h1) {
                byte[] bArr3 = this.f2055h;
                int i3 = i2 + 4;
                k.x.s0.f(r0Var2.a(k.x.s0.c(bArr3[i3], bArr3[i2 + 5])), this.f2055h, i3);
            } else if (z0VarA == z0.j1) {
                byte[] bArr4 = this.f2055h;
                int i4 = i2 + 12;
                k.x.s0.f(r0Var2.a(k.x.s0.c(bArr4[i4], bArr4[i2 + 13])), this.f2055h, i4);
            } else if (z0VarA == z0.i1) {
                byte[] bArr5 = this.f2055h;
                int i5 = i2 + 4;
                k.x.s0.f(r0Var3.a(k.x.s0.c(bArr5[i5], bArr5[i2 + 5])), this.f2055h, i5);
            } else if (z0VarA == z0.k1) {
                byte[] bArr6 = this.f2055h;
                int iC3 = k.x.s0.c(bArr6[i2 + 4], bArr6[i2 + 5]);
                int i6 = i2 + 6;
                for (int i7 = 0; i7 < iC3; i7++) {
                    byte[] bArr7 = this.f2055h;
                    int i8 = i6 + 2;
                    k.x.s0.f(r0Var2.a(k.x.s0.c(bArr7[i8], bArr7[i6 + 3])), this.f2055h, i8);
                    i6 += 4;
                }
            }
            i2 += iC2 + 4;
        }
    }

    @Override // k.x.i1.c0
    public byte[] getData() {
        return this.a.x().c();
    }
}

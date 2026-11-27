package androidx.fragment.app;

/* loaded from: classes.dex */
class o1 implements d0 {
    final boolean a;
    final a b;
    private int c;

    o1(a aVar, boolean z) {
        this.a = z;
        this.b = aVar;
    }

    @Override // androidx.fragment.app.d0
    public void a() {
        this.c++;
    }

    @Override // androidx.fragment.app.d0
    public void b() {
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 != 0) {
            return;
        }
        this.b.q.g1();
    }

    void c() {
        a aVar = this.b;
        aVar.q.t(aVar, this.a, false, false);
    }

    void d() {
        boolean z = this.c > 0;
        for (Fragment fragment : this.b.q.s0()) {
            fragment.K1(null);
            if (z && fragment.j0()) {
                fragment.T1();
            }
        }
        a aVar = this.b;
        aVar.q.t(aVar, this.a, !z, true);
    }

    public boolean e() {
        return this.c == 0;
    }
}

package i.b.ha.a.e.c;

/* loaded from: classes.dex */
class a extends i {
    private int a;
    private int b;
    final /* synthetic */ double[][] c;

    a(c cVar, double[][] dArr) {
        this.c = dArr;
    }

    @Override // i.b.ha.a.e.c.i, i.b.ha.a.e.c.t
    public void b(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.a = i4;
        this.b = i6;
    }

    @Override // i.b.ha.a.e.c.t
    public void c(int i2, int i3, double d) {
        this.c[i2 - this.a][i3 - this.b] = d;
    }
}

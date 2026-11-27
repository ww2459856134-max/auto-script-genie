package i.f.a.a0.c;

/* loaded from: classes.dex */
public final class t {
    private final int a;
    private final s[] b;

    t(int i2, s... sVarArr) {
        this.a = i2;
        this.b = sVarArr;
    }

    public s[] a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        int iA = 0;
        for (s sVar : this.b) {
            iA += sVar.a();
        }
        return iA;
    }

    public int d() {
        return this.a * c();
    }
}

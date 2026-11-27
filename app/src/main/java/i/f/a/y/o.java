package i.f.a.y;

/* loaded from: classes.dex */
final class o {
    private static final int[] c = {1, 1, 2};
    private final m a = new m();
    private final n b = new n();

    o() {
    }

    i.f.a.p a(int i2, i.f.a.v.a aVar, int i3) throws i.f.a.k {
        int[] iArrN = p.n(aVar, i3, false, c);
        try {
            return this.b.b(i2, aVar, iArrN);
        } catch (i.f.a.o unused) {
            return this.a.b(i2, aVar, iArrN);
        }
    }
}

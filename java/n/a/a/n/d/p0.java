package n.a.a.n.d;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface p0 extends Iterable<o0> {
    o0 B(int i2);

    String c();

    int d();

    o0 f(int i2);

    i1 getWorkbook();

    @Override // java.lang.Iterable
    default Iterator<o0> iterator() {
        return o();
    }

    int m();

    Iterator<o0> o();

    g<? extends e> y(e eVar);
}

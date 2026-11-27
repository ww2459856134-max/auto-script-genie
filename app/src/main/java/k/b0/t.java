package k.b0;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class t {
    public static final p a;
    public static final p b;
    public static final m c;
    public static final m d;
    public static final m e;

    static {
        o oVar = p.p;
        p pVar = new p(oVar);
        a = pVar;
        p pVar2 = new p(oVar, 10, p.q, false, k.z.n.d, k.z.e.f2180h);
        b = pVar2;
        c = new m(pVar, j.a);
        d = new m(pVar2);
        e = new m(new c(";;;"));
    }

    protected t() {
    }

    public abstract void f() throws u, IOException;

    public abstract s g(int i2) throws IndexOutOfBoundsException;

    public abstract void h() throws IOException;
}

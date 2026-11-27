package i.b.ha.a.e.c;

/* loaded from: classes.dex */
public abstract class l {
    static {
        s.d();
        new s("[", "]", "", "", "; ", ", ");
    }

    public static void a(d dVar, int i2) throws i.b.ha.a.e.b.o {
        if (i2 < 0 || i2 >= dVar.a()) {
            throw new i.b.ha.a.e.b.o(i.b.ha.a.e.b.p.d.COLUMN_INDEX, Integer.valueOf(i2), 0, Integer.valueOf(dVar.a() - 1));
        }
    }

    public static void b(d dVar, int i2, int i3) throws i.b.ha.a.e.b.o {
        d(dVar, i2);
        a(dVar, i3);
    }

    public static void c(d dVar, d dVar2) throws i.b.ha.a.e.b.b {
        if (dVar.a() != dVar2.d()) {
            throw new i.b.ha.a.e.b.b(dVar.a(), dVar2.d());
        }
    }

    public static void d(d dVar, int i2) throws i.b.ha.a.e.b.o {
        if (i2 < 0 || i2 >= dVar.d()) {
            throw new i.b.ha.a.e.b.o(i.b.ha.a.e.b.p.d.ROW_INDEX, Integer.valueOf(i2), 0, Integer.valueOf(dVar.d() - 1));
        }
    }

    public static void e(d dVar, int i2, int i3, int i4, int i5) throws i.b.ha.a.e.b.o, i.b.ha.a.e.b.n {
        d(dVar, i2);
        d(dVar, i3);
        if (i3 < i2) {
            throw new i.b.ha.a.e.b.n(i.b.ha.a.e.b.p.d.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(i3), Integer.valueOf(i2), false);
        }
        a(dVar, i4);
        a(dVar, i5);
        if (i5 < i4) {
            throw new i.b.ha.a.e.b.n(i.b.ha.a.e.b.p.d.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(i5), Integer.valueOf(i4), false);
        }
    }

    public static r f(int i2) throws i.b.ha.a.e.b.o {
        r rVarG = g(i2, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            rVarG.f(i3, i3, 1.0d);
        }
        return rVarG;
    }

    public static r g(int i2, int i3) {
        return i2 * i3 <= 4096 ? new e(i2, i3) : new g(i2, i3);
    }

    public static r h(r rVar) throws i.b.ha.a.e.b.l, w, m {
        return i(rVar, 0.0d);
    }

    public static r i(r rVar, double d) throws i.b.ha.a.e.b.l, w, m {
        i.b.ha.a.e.g.m.a(rVar);
        if (rVar.g()) {
            return new p(rVar, d).b().b();
        }
        throw new m(rVar.d(), rVar.a());
    }
}

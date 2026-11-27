package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract class j9 {
    private static <T> k9<T, o5> a(k9<T, o5> k9Var, l9 l9Var) {
        int i2 = i9.a[l9Var.ordinal()];
        if (i2 == 1) {
            return k9Var;
        }
        if (i2 == 2) {
            return e();
        }
        if (i2 == 3) {
            return k();
        }
        throw new AssertionError();
    }

    static k9<n.a.a.n.c.r1.l, o5> b(l9 l9Var) {
        return a(new k9() { // from class: n.a.a.n.c.t1.t
            @Override // n.a.a.n.c.t1.k9
            public final void accept(Object obj, Object obj2) {
                ((o5) obj2).a(0.0d);
            }
        }, l9Var);
    }

    static k9<n.a.a.n.c.r1.m, o5> c(l9 l9Var) {
        return a(new k9() { // from class: n.a.a.n.c.t1.u
            @Override // n.a.a.n.c.t1.k9
            public final void accept(Object obj, Object obj2) {
                ((o5) obj2).a(((n.a.a.n.c.r1.m) obj).r());
            }
        }, l9Var);
    }

    static k9<n.a.a.n.c.r1.u, o5> d(l9 l9Var) {
        return a(new k9() { // from class: n.a.a.n.c.t1.s
            @Override // n.a.a.n.c.t1.k9
            public final void accept(Object obj, Object obj2) {
                ((o5) obj2).a(0.0d);
            }
        }, l9Var);
    }

    private static <T> k9<T, o5> e() {
        return new k9() { // from class: n.a.a.n.c.t1.r
            @Override // n.a.a.n.c.t1.k9
            public final void accept(Object obj, Object obj2) throws n.a.a.n.c.r1.p {
                j9.i(obj, (o5) obj2);
            }
        };
    }

    static /* synthetic */ void i(Object obj, o5 o5Var) throws n.a.a.n.c.r1.p {
    }

    static /* synthetic */ void j(Object obj, o5 o5Var) throws n.a.a.n.c.r1.p {
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    private static <T> k9<T, o5> k() {
        return new k9() { // from class: n.a.a.n.c.t1.q
            @Override // n.a.a.n.c.t1.k9
            public final void accept(Object obj, Object obj2) throws n.a.a.n.c.r1.p {
                j9.j(obj, (o5) obj2);
                throw null;
            }
        };
    }
}

package i.b.ha.a.b.d.c;

/* loaded from: classes.dex */
final class f2 extends o1 {
    private f2() {
    }

    @Override // i.b.ha.a.b.d.c.o1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return B() == f2Var.B() && super.q() == f2Var.q() && super.s() == f2Var.s();
    }

    @Override // i.b.ha.a.b.d.c.o1, java.util.zip.ZipEntry
    public int hashCode() {
        return (super.hashCode() * 3) + ((int) B()) + ((int) (B() >> 32));
    }

    /* synthetic */ f2(b2 b2Var) {
        this();
    }
}

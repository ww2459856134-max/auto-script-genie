package n.a.a.n.c.u1;

/* loaded from: classes.dex */
public abstract class k2 implements n.a.a.e.a.a {
    private byte c;

    protected k2() {
        this.c = (byte) 0;
    }

    public final byte i() {
        return this.c;
    }

    public abstract byte k();

    public abstract int l();

    public abstract boolean m();

    public final void n(byte b) {
        if (m()) {
            throw new IllegalStateException("setClass should not be called on a base token");
        }
        this.c = b;
    }

    public abstract String o();

    public final String toString() {
        return n.a.a.o.t0.o(this);
    }

    protected k2(k2 k2Var) {
        this.c = (byte) 0;
        this.c = k2Var.c;
    }
}

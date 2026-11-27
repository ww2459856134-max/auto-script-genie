package n.b.a.m.o;

/* loaded from: classes2.dex */
public abstract class c extends n.b.a.n.c {
    protected int a;
    protected int b;
    protected int c = 0;

    protected c(int i2, int i3) {
        this.a = i2;
        if (i3 < 1) {
            throw new IllegalArgumentException("Number of elements to read can not be less than 1");
        }
        this.b = i3;
    }

    @Override // n.b.a.n.c
    public final boolean b() {
        return this.c < this.b;
    }

    protected int c(int i2) {
        return i2 < 4000 ? i2 << 2 : i2 + i2;
    }

    public abstract void d();
}

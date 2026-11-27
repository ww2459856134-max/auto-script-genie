package n.a.a.n.c.u1;

/* loaded from: classes.dex */
public class c1 implements d1 {
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    public c1(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.d = Math.min(i4, i5) + i2;
        this.f = i2 + Math.max(i4, i5);
        this.c = Math.min(i6, i7) + i3;
        this.e = i3 + Math.max(i6, i7);
    }

    @Override // n.a.a.n.c.u1.d1
    public int getFirstColumn() {
        return this.c;
    }

    @Override // n.a.a.n.c.u1.d1
    public int getFirstRow() {
        return this.d;
    }

    @Override // n.a.a.n.c.u1.d1
    public int getLastColumn() {
        return this.e;
    }

    @Override // n.a.a.n.c.u1.d1
    public int getLastRow() {
        return this.f;
    }
}

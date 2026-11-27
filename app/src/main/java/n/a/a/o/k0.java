package n.a.a.o;

/* loaded from: classes.dex */
public class k0 {
    private final int a;
    private final int b;

    public k0(int i2) {
        this.a = i2;
        int i3 = 0;
        if (i2 != 0) {
            while ((i2 & 1) == 0) {
                i3++;
                i2 >>= 1;
            }
        }
        this.b = i3;
    }

    public int a(int i2) {
        return i2 & (~this.a);
    }

    public int b() {
        return this.a;
    }

    public int c(int i2) {
        return i2 & this.a;
    }

    public int d(int i2) {
        return c(i2) >>> this.b;
    }

    public boolean e(int i2) {
        return (i2 & this.a) != 0;
    }

    public int f(int i2) {
        return i2 | this.a;
    }

    public int g(int i2, boolean z) {
        return z ? f(i2) : a(i2);
    }

    public int h(int i2, int i3) {
        int i4 = this.a;
        return (i2 & (~i4)) | ((i3 << this.b) & i4);
    }
}

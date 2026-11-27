package i.f.a.z.d.m;

/* loaded from: classes.dex */
public final class b {
    public static final b f = new b(929, 3);
    private final int[] a;
    private final int[] b;
    private final c c;
    private final c d;
    private final int e;

    private b(int i2, int i3) {
        this.e = i2;
        this.a = new int[i2];
        this.b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.a[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.b[this.a[i6]] = i6;
        }
        this.c = new c(this, new int[]{0});
        this.d = new c(this, new int[]{1});
    }

    int a(int i2, int i3) {
        return (i2 + i3) % this.e;
    }

    c b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new c(this, iArr);
    }

    int c(int i2) {
        return this.a[i2];
    }

    c d() {
        return this.d;
    }

    int e() {
        return this.e;
    }

    c f() {
        return this.c;
    }

    int g(int i2) {
        if (i2 != 0) {
            return this.a[(this.e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int h(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    int i(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    int j(int i2, int i3) {
        int i4 = this.e;
        return ((i2 + i4) - i3) % i4;
    }
}

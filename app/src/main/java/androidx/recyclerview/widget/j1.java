package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class j1 {
    int a = 0;
    int b;
    int c;
    int d;
    int e;

    j1() {
    }

    void a(int i2) {
        this.a = i2 | this.a;
    }

    boolean b() {
        int i2 = this.a;
        if ((i2 & 7) != 0 && (i2 & (c(this.d, this.b) << 0)) == 0) {
            return false;
        }
        int i3 = this.a;
        if ((i3 & 112) != 0 && (i3 & (c(this.d, this.c) << 4)) == 0) {
            return false;
        }
        int i4 = this.a;
        if ((i4 & 1792) != 0 && (i4 & (c(this.e, this.b) << 8)) == 0) {
            return false;
        }
        int i5 = this.a;
        return (i5 & 28672) == 0 || (i5 & (c(this.e, this.c) << 12)) != 0;
    }

    int c(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i2 == i3 ? 2 : 4;
    }

    void d() {
        this.a = 0;
    }

    void e(int i2, int i3, int i4, int i5) {
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }
}

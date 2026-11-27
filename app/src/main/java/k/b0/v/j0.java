package k.b0.v;

/* loaded from: classes.dex */
class j0 {
    int a;
    int b;
    int c;

    j0(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    void a(int i2) {
        int i3 = this.b;
        if (i3 >= i2) {
            this.b = i3 + 1;
        }
        int i4 = this.c;
        if (i4 >= i2) {
            this.c = i4 + 1;
        }
    }
}

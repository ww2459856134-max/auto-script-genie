package h.i.a;

/* loaded from: classes.dex */
class c {
    public final int a;
    public final String b;
    public final int c;
    public final int d;

    c(String str, int i2, int i3) {
        this.b = str;
        this.a = i2;
        this.c = i3;
        this.d = -1;
    }

    boolean a(int i2) {
        int i3;
        int i4 = this.c;
        if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.d) == i2) {
            return true;
        }
        if ((i4 == 4 || i3 == 4) && i2 == 3) {
            return true;
        }
        if ((i4 == 9 || i3 == 9) && i2 == 8) {
            return true;
        }
        return (i4 == 12 || i3 == 12) && i2 == 11;
    }

    c(String str, int i2, int i3, int i4) {
        this.b = str;
        this.a = i2;
        this.c = i3;
        this.d = i4;
    }
}

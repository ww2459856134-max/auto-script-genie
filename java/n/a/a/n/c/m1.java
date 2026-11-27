package n.a.a.n.c;

/* loaded from: classes.dex */
abstract /* synthetic */ class m1 {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[n.a.a.n.d.j.values().length];
        a = iArr;
        try {
            iArr[n.a.a.n.d.j.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[n.a.a.n.d.j.STRING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[n.a.a.n.d.j.BLANK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[n.a.a.n.d.j.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[n.a.a.n.d.j.ERROR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[n.a.a.n.d.j.FORMULA.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

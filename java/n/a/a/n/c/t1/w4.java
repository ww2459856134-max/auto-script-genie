package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract /* synthetic */ class w4 {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[y4.values().length];
        a = iArr;
        try {
            iArr[y4.largerThan.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[y4.largerEqualThan.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[y4.smallerThan.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[y4.smallerEqualThan.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[y4.equal.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[y4.notEqual.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

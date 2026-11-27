package n.a.a.n.d;

/* loaded from: classes.dex */
abstract /* synthetic */ class k {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[j.values().length];
        a = iArr;
        try {
            iArr[j.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[j.STRING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[j.BOOLEAN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[j.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

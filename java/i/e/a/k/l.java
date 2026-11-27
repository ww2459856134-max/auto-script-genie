package i.e.a.k;

/* loaded from: classes.dex */
abstract /* synthetic */ class l {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[j.values().length];
        a = iArr;
        try {
            iArr[j.UNBOUND.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[j.OK.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[j.MISBOUND.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

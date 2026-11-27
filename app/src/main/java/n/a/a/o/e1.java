package n.a.a.o;

/* loaded from: classes.dex */
abstract /* synthetic */ class e1 {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[f1.values().length];
        a = iArr;
        try {
            iArr[f1.NOT_MATCHED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[f1.MATCHING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[f1.REPLACING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[f1.UNBUFFER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

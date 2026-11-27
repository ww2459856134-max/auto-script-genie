package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract /* synthetic */ class w7 {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[d8.values().length];
        a = iArr;
        try {
            iArr[d8.ExactMatchFallbackToLargerValue.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[d8.ExactMatchFallbackToSmallerValue.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

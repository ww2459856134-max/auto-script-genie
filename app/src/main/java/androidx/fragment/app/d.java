package androidx.fragment.app;

/* loaded from: classes.dex */
abstract /* synthetic */ class d {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[h3.values().length];
        a = iArr;
        try {
            iArr[h3.GONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[h3.INVISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[h3.REMOVED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[h3.VISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

package androidx.fragment.app;

/* loaded from: classes.dex */
abstract /* synthetic */ class d3 {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[g3.values().length];
        b = iArr;
        try {
            iArr[g3.ADDING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[g3.REMOVING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[g3.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[h3.values().length];
        a = iArr2;
        try {
            iArr2[h3.REMOVED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[h3.VISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[h3.GONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[h3.INVISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
    }
}

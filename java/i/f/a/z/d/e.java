package i.f.a.z.d;

/* loaded from: classes.dex */
abstract /* synthetic */ class e {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[f.values().length];
        a = iArr;
        try {
            iArr[f.ALPHA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[f.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[f.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[f.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[f.ALPHA_SHIFT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[f.PUNCT_SHIFT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

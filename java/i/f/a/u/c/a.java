package i.f.a.u.c;

/* loaded from: classes.dex */
abstract /* synthetic */ class a {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[b.values().length];
        a = iArr;
        try {
            iArr[b.UPPER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[b.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[b.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[b.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[b.DIGIT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}

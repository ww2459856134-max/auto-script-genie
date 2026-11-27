package i.f.a.w.b;

/* loaded from: classes.dex */
abstract /* synthetic */ class c {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[d.values().length];
        a = iArr;
        try {
            iArr[d.C40_ENCODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[d.TEXT_ENCODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[d.ANSIX12_ENCODE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[d.EDIFACT_ENCODE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[d.BASE256_ENCODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}

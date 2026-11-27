package n.a.a.l.c;

/* loaded from: classes.dex */
abstract /* synthetic */ class l {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[m.values().length];
        a = iArr;
        try {
            iArr[m.parsed.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[m.compact.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[m.unparsed.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

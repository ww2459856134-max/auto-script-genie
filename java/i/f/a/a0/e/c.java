package i.f.a.a0.e;

import i.f.a.a0.c.q;

/* loaded from: classes.dex */
abstract /* synthetic */ class c {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[q.values().length];
        a = iArr;
        try {
            iArr[q.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[q.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[q.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[q.KANJI.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

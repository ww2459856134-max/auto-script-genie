package org.apache.poi.xssf.usermodel;

/* loaded from: classes.dex */
abstract /* synthetic */ class y0 {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[n.a.a.n.d.j.values().length];
        a = iArr;
        try {
            iArr[n.a.a.n.d.j.BLANK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[n.a.a.n.d.j.BOOLEAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[n.a.a.n.d.j.FORMULA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[n.a.a.n.d.j.NUMERIC.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[n.a.a.n.d.j.STRING.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[n.a.a.n.d.j.ERROR.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

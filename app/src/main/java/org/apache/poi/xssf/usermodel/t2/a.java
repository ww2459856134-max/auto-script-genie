package org.apache.poi.xssf.usermodel.t2;

/* loaded from: classes.dex */
abstract /* synthetic */ class a {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[b.values().length];
        a = iArr;
        try {
            iArr[b.TOP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[b.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[b.BOTTOM.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[b.LEFT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[b.DIAGONAL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[b.VERTICAL.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[b.HORIZONTAL.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}

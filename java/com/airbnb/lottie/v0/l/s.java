package com.airbnb.lottie.v0.l;

/* loaded from: classes.dex */
abstract /* synthetic */ class s {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[u.values().length];
        b = iArr;
        try {
            iArr[u.BEVEL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[u.MITER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[u.ROUND.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[t.values().length];
        a = iArr2;
        try {
            iArr2[t.BUTT.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[t.ROUND.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[t.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

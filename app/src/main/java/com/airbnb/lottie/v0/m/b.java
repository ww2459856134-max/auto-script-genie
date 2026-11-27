package com.airbnb.lottie.v0.m;

/* loaded from: classes.dex */
abstract /* synthetic */ class b {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[com.airbnb.lottie.v0.l.g.values().length];
        b = iArr;
        try {
            iArr[com.airbnb.lottie.v0.l.g.MASK_MODE_NONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[com.airbnb.lottie.v0.l.g.MASK_MODE_SUBTRACT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[com.airbnb.lottie.v0.l.g.MASK_MODE_INTERSECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[com.airbnb.lottie.v0.l.g.MASK_MODE_ADD.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[g.values().length];
        a = iArr2;
        try {
            iArr2[g.SHAPE.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[g.PRE_COMP.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[g.SOLID.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[g.IMAGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[g.NULL.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[g.TEXT.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[g.UNKNOWN.ordinal()] = 7;
        } catch (NoSuchFieldError unused11) {
        }
    }
}

package org.apache.poi.xssf.usermodel;

import n.a.a.n.d.o0;

/* loaded from: classes.dex */
abstract /* synthetic */ class e2 {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[o0.a.values().length];
        b = iArr;
        try {
            iArr[o0.a.RETURN_NULL_AND_BLANK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[o0.a.RETURN_BLANK_AS_NULL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[o0.a.CREATE_NULL_AS_BLANK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[n.a.a.n.d.j.values().length];
        a = iArr2;
        try {
            iArr2[n.a.a.n.d.j.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[n.a.a.n.d.j.STRING.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[n.a.a.n.d.j.BOOLEAN.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[n.a.a.n.d.j.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
    }
}

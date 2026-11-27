package androidx.lifecycle;

import androidx.lifecycle.f;

/* loaded from: classes.dex */
abstract /* synthetic */ class e {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[f.a.values().length];
        b = iArr;
        try {
            iArr[f.a.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[f.a.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[f.a.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[f.a.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[f.a.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[f.a.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            b[f.a.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr2 = new int[f.b.values().length];
        a = iArr2;
        try {
            iArr2[f.b.CREATED.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[f.b.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[f.b.RESUMED.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[f.b.DESTROYED.ordinal()] = 4;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            a[f.b.INITIALIZED.ordinal()] = 5;
        } catch (NoSuchFieldError unused12) {
        }
    }
}

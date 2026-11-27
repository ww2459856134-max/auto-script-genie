package androidx.fragment.app;

import androidx.lifecycle.f;

/* loaded from: classes.dex */
abstract /* synthetic */ class a2 {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[f.b.values().length];
        a = iArr;
        try {
            iArr[f.b.RESUMED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[f.b.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[f.b.CREATED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[f.b.INITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

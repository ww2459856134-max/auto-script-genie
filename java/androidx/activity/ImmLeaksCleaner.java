package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.f;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.g {
    private static int b;
    private static Field c;
    private static Field d;
    private static Field e;
    private Activity a;

    ImmLeaksCleaner(Activity activity) {
        this.a = activity;
    }

    private static void h() throws NoSuchFieldException {
        try {
            b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            c = declaredField3;
            declaredField3.setAccessible(true);
            b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.g
    public void a(androidx.lifecycle.i iVar, f.a aVar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (aVar != f.a.ON_DESTROY) {
            return;
        }
        if (b == 0) {
            h();
        }
        if (b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
            try {
                Object obj = c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}

package com.frame;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;

/* loaded from: classes.dex */
public abstract class t0 {
    public static Context a() {
        v0 v0VarG = v0.g();
        return (Build.VERSION.SDK_INT <= 21 || !w0.d()) ? v0VarG : w0.b();
    }

    public static WindowManager.LayoutParams b(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 21 && w0.d()) {
            layoutParams.type = 2032;
        } else if (i2 >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        if (!z) {
            layoutParams.flags = 16778008;
        } else if (i2 >= 19) {
            layoutParams.flags = 201328136;
        } else {
            layoutParams.flags = 1544;
        }
        if (i2 >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        layoutParams.format = 1;
        layoutParams.gravity = 51;
        return layoutParams;
    }
}

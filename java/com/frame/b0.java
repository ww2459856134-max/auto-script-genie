package com.frame;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;

/* loaded from: classes.dex */
class b0 implements g0.b {
    final /* synthetic */ int a;
    final /* synthetic */ String[] b;
    final /* synthetic */ g0 c;

    b0(g0 g0Var, int i2, String[] strArr) {
        this.c = g0Var;
        this.a = i2;
        this.b = strArr;
    }

    @Override // com.frame.g0.b
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return this.c.o(this.a, accessibilityNodeInfo, true, false, this.b);
    }
}

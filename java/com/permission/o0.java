package com.permission;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;

/* loaded from: classes.dex */
class o0 implements g0.c {
    final /* synthetic */ u0 a;

    o0(u0 u0Var) {
        this.a = u0Var;
    }

    @Override // com.frame.g0.c
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (a1.g().h() instanceof g0) {
            return;
        }
        this.a.c("主屏幕", null);
    }

    @Override // com.frame.g0.c
    public void b() {
    }
}

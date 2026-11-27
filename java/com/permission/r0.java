package com.permission;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;

/* loaded from: classes.dex */
class r0 implements g0.c {
    r0(t0 t0Var) {
    }

    @Override // com.frame.g0.c
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        ClickView.getInstance().n("后台", "点击允许后台弹出界面");
    }

    @Override // com.frame.g0.c
    public void b() {
    }
}

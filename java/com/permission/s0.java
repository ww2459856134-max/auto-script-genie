package com.permission;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;

/* loaded from: classes.dex */
class s0 implements g0.c {
    s0(t0 t0Var) {
    }

    @Override // com.frame.g0.c
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        ClickView.getInstance().n("悬浮", "点击开启悬浮窗权限");
    }

    @Override // com.frame.g0.c
    public void b() {
    }
}

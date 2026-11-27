package com.permission;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;

/* loaded from: classes.dex */
class q0 implements g0.c {
    q0(t0 t0Var) {
    }

    @Override // com.frame.g0.c
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        ClickView.getInstance().n("动态壁纸", "点击允许动态壁纸权限");
    }

    @Override // com.frame.g0.c
    public void b() {
    }
}

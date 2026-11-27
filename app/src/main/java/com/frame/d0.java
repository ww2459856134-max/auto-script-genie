package com.frame;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;

/* loaded from: classes.dex */
class d0 implements g0.b {
    final /* synthetic */ String a;

    d0(g0 g0Var, String str) {
        this.a = str;
    }

    @Override // com.frame.g0.b
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : accessibilityNodeInfo.findAccessibilityNodeInfosByText(this.a)) {
                if (accessibilityNodeInfo2.getText() != null) {
                    return accessibilityNodeInfo2;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

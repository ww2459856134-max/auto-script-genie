package com.frame;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;

/* loaded from: classes.dex */
class c0 implements g0.b {
    final /* synthetic */ String[] a;
    final /* synthetic */ int b;

    c0(g0 g0Var, String[] strArr, int i2) {
        this.a = strArr;
        this.b = i2;
    }

    @Override // com.frame.g0.b
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2 = 0;
        while (true) {
            try {
                String[] strArr = this.a;
                if (i2 >= strArr.length) {
                    return null;
                }
                for (AccessibilityNodeInfo accessibilityNodeInfo2 : accessibilityNodeInfo.findAccessibilityNodeInfosByText(strArr[i2])) {
                    if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.getText() != null && accessibilityNodeInfo2.getText().length() < this.b) {
                        return accessibilityNodeInfo2;
                    }
                }
                i2++;
            } catch (Exception e) {
                k0.r(e);
                return null;
            }
        }
    }
}

package com.permission;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class p0 implements g0.c {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ g0.c b;

    p0(u0 u0Var, AtomicReference atomicReference, g0.c cVar) {
        this.a = atomicReference;
        this.b = cVar;
    }

    @Override // com.frame.g0.c
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (((Boolean) this.a.get()).booleanValue()) {
            try {
                this.a.set(Boolean.FALSE);
                accessibilityNodeInfo.performAction(16);
                g0.c cVar = this.b;
                if (cVar != null) {
                    cVar.a(accessibilityNodeInfo);
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    @Override // com.frame.g0.c
    public void b() {
    }
}

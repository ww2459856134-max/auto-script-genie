package h.e.j;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* loaded from: classes.dex */
final class a extends View.AccessibilityDelegate {
    final b a;

    a(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        h.e.j.q1.f fVarB = this.a.b(view);
        if (fVarB != null) {
            return (AccessibilityNodeProvider) fVarB.a();
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.f(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        h.e.j.q1.e eVarO0 = h.e.j.q1.e.o0(accessibilityNodeInfo);
        eVarO0.h0(s0.M(view));
        eVarO0.c0(s0.I(view));
        eVarO0.f0(s0.m(view));
        eVarO0.l0(s0.D(view));
        this.a.g(view, eVarO0);
        eVarO0.e(accessibilityNodeInfo.getText(), view);
        List<h.e.j.q1.c> listC = b.c(view);
        for (int i2 = 0; i2 < listC.size(); i2++) {
            eVarO0.b(listC.get(i2));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.h(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.i(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        return this.a.j(view, i2, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i2) {
        this.a.l(view, i2);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.a.m(view, accessibilityEvent);
    }
}

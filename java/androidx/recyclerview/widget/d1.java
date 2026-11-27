package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class d1 extends h.e.j.b {
    final e1 d;
    private Map<View, h.e.j.b> e = new WeakHashMap();

    public d1(e1 e1Var) {
        this.d = e1Var;
    }

    @Override // h.e.j.b
    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        h.e.j.b bVar = this.e.get(view);
        return bVar != null ? bVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
    }

    @Override // h.e.j.b
    public h.e.j.q1.f b(View view) {
        h.e.j.b bVar = this.e.get(view);
        return bVar != null ? bVar.b(view) : super.b(view);
    }

    @Override // h.e.j.b
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        h.e.j.b bVar = this.e.get(view);
        if (bVar != null) {
            bVar.f(view, accessibilityEvent);
        } else {
            super.f(view, accessibilityEvent);
        }
    }

    @Override // h.e.j.b
    public void g(View view, h.e.j.q1.e eVar) {
        if (this.d.o() || this.d.d.getLayoutManager() == null) {
            super.g(view, eVar);
            return;
        }
        this.d.d.getLayoutManager().N0(view, eVar);
        h.e.j.b bVar = this.e.get(view);
        if (bVar != null) {
            bVar.g(view, eVar);
        } else {
            super.g(view, eVar);
        }
    }

    @Override // h.e.j.b
    public void h(View view, AccessibilityEvent accessibilityEvent) {
        h.e.j.b bVar = this.e.get(view);
        if (bVar != null) {
            bVar.h(view, accessibilityEvent);
        } else {
            super.h(view, accessibilityEvent);
        }
    }

    @Override // h.e.j.b
    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        h.e.j.b bVar = this.e.get(viewGroup);
        return bVar != null ? bVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
    }

    @Override // h.e.j.b
    public boolean j(View view, int i2, Bundle bundle) {
        if (this.d.o() || this.d.d.getLayoutManager() == null) {
            return super.j(view, i2, bundle);
        }
        h.e.j.b bVar = this.e.get(view);
        if (bVar != null) {
            if (bVar.j(view, i2, bundle)) {
                return true;
            }
        } else if (super.j(view, i2, bundle)) {
            return true;
        }
        return this.d.d.getLayoutManager().g1(view, i2, bundle);
    }

    @Override // h.e.j.b
    public void l(View view, int i2) {
        h.e.j.b bVar = this.e.get(view);
        if (bVar != null) {
            bVar.l(view, i2);
        } else {
            super.l(view, i2);
        }
    }

    @Override // h.e.j.b
    public void m(View view, AccessibilityEvent accessibilityEvent) {
        h.e.j.b bVar = this.e.get(view);
        if (bVar != null) {
            bVar.m(view, accessibilityEvent);
        } else {
            super.m(view, accessibilityEvent);
        }
    }

    h.e.j.b n(View view) {
        return this.e.remove(view);
    }

    void o(View view) {
        h.e.j.b bVarI = h.e.j.s0.i(view);
        if (bVarI == null || bVarI == this) {
            return;
        }
        this.e.put(view, bVarI);
    }
}

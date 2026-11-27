package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class e1 extends h.e.j.b {
    final RecyclerView d;
    private final d1 e;

    public e1(RecyclerView recyclerView) {
        this.d = recyclerView;
        h.e.j.b bVarN = n();
        if (bVarN == null || !(bVarN instanceof d1)) {
            this.e = new d1(this);
        } else {
            this.e = (d1) bVarN;
        }
    }

    @Override // h.e.j.b
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().J0(accessibilityEvent);
        }
    }

    @Override // h.e.j.b
    public void g(View view, h.e.j.q1.e eVar) {
        super.g(view, eVar);
        if (o() || this.d.getLayoutManager() == null) {
            return;
        }
        this.d.getLayoutManager().L0(eVar);
    }

    @Override // h.e.j.b
    public boolean j(View view, int i2, Bundle bundle) {
        if (super.j(view, i2, bundle)) {
            return true;
        }
        if (o() || this.d.getLayoutManager() == null) {
            return false;
        }
        return this.d.getLayoutManager().e1(i2, bundle);
    }

    public h.e.j.b n() {
        return this.e;
    }

    boolean o() {
        return this.d.n0();
    }
}

package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
class w1 extends h.e.j.b1 {
    private boolean a = false;
    final /* synthetic */ int b;
    final /* synthetic */ x1 c;

    w1(x1 x1Var, int i2) {
        this.c = x1Var;
        this.b = i2;
    }

    @Override // h.e.j.b1, h.e.j.a1
    public void a(View view) {
        this.a = true;
    }

    @Override // h.e.j.a1
    public void b(View view) {
        if (this.a) {
            return;
        }
        this.c.a.setVisibility(this.b);
    }

    @Override // h.e.j.b1, h.e.j.a1
    public void c(View view) {
        this.c.a.setVisibility(0);
    }
}

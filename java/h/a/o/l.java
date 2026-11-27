package h.a.o;

import android.view.View;
import h.e.j.a1;
import h.e.j.b1;

/* loaded from: classes.dex */
class l extends b1 {
    private boolean a = false;
    private int b = 0;
    final /* synthetic */ m c;

    l(m mVar) {
        this.c = mVar;
    }

    @Override // h.e.j.a1
    public void b(View view) {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == this.c.a.size()) {
            a1 a1Var = this.c.d;
            if (a1Var != null) {
                a1Var.b(null);
            }
            d();
        }
    }

    @Override // h.e.j.b1, h.e.j.a1
    public void c(View view) {
        if (this.a) {
            return;
        }
        this.a = true;
        a1 a1Var = this.c.d;
        if (a1Var != null) {
            a1Var.c(null);
        }
    }

    void d() {
        this.b = 0;
        this.a = false;
        this.c.b();
    }
}

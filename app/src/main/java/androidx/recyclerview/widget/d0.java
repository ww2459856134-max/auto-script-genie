package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class d0 implements Runnable {
    final /* synthetic */ k0 c;

    d0(k0 k0Var) {
        this.c = k0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        k0 k0Var = this.c;
        if (k0Var.c == null || !k0Var.B()) {
            return;
        }
        k0 k0Var2 = this.c;
        RecyclerView.d0 d0Var = k0Var2.c;
        if (d0Var != null) {
            k0Var2.w(d0Var);
        }
        k0 k0Var3 = this.c;
        k0Var3.r.removeCallbacks(k0Var3.s);
        h.e.j.s0.U(this.c.r, this);
    }
}

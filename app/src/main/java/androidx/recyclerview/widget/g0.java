package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class g0 implements Runnable {
    final /* synthetic */ n0 c;
    final /* synthetic */ int d;
    final /* synthetic */ k0 e;

    g0(k0 k0Var, n0 n0Var, int i2) {
        this.e = k0Var;
        this.c = n0Var;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.e.r;
        if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
            return;
        }
        n0 n0Var = this.c;
        if (n0Var.f365k || n0Var.e.getAdapterPosition() == -1) {
            return;
        }
        RecyclerView.l itemAnimator = this.e.r.getItemAnimator();
        if ((itemAnimator == null || !itemAnimator.q(null)) && !this.e.u()) {
            this.e.f359m.onSwiped(this.c.e, this.d);
        } else {
            this.e.r.post(this);
        }
    }
}

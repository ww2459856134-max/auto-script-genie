package androidx.appcompat.widget;

/* loaded from: classes.dex */
class z0 implements Runnable {
    final /* synthetic */ a1 c;

    z0(a1 a1Var) {
        this.c = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        p0 p0Var = this.c.e;
        if (p0Var == null || !h.e.j.s0.J(p0Var) || this.c.e.getCount() <= this.c.e.getChildCount()) {
            return;
        }
        int childCount = this.c.e.getChildCount();
        a1 a1Var = this.c;
        if (childCount <= a1Var.H) {
            a1Var.e0.setInputMethodMode(2);
            this.c.g();
        }
    }
}

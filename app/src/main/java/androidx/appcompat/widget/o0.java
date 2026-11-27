package androidx.appcompat.widget;

/* loaded from: classes.dex */
class o0 implements Runnable {
    final /* synthetic */ p0 c;

    o0(p0 p0Var) {
        this.c = p0Var;
    }

    public void a() {
        p0 p0Var = this.c;
        p0Var.G = null;
        p0Var.removeCallbacks(this);
    }

    public void b() {
        this.c.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        p0 p0Var = this.c;
        p0Var.G = null;
        p0Var.drawableStateChanged();
    }
}

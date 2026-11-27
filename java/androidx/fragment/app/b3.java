package androidx.fragment.app;

/* loaded from: classes.dex */
class b3 implements Runnable {
    final /* synthetic */ e3 c;
    final /* synthetic */ j3 d;

    b3(j3 j3Var, e3 e3Var) {
        this.d = j3Var;
        this.c = e3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d.b.contains(this.c)) {
            this.c.e().a(this.c.f().h0);
        }
    }
}

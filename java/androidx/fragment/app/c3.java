package androidx.fragment.app;

/* loaded from: classes.dex */
class c3 implements Runnable {
    final /* synthetic */ e3 c;
    final /* synthetic */ j3 d;

    c3(j3 j3Var, e3 e3Var) {
        this.d = j3Var;
        this.c = e3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.b.remove(this.c);
        this.d.c.remove(this.c);
    }
}

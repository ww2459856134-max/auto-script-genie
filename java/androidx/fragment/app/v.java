package androidx.fragment.app;

/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ j3 c;

    v(Fragment fragment, j3 j3Var) {
        this.c = j3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.g();
    }
}

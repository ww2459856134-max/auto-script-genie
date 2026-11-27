package androidx.fragment.app;

/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ q c;

    n(r rVar, q qVar) {
        this.c = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a();
    }
}

package h.a.l.a;

/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ m c;

    i(m mVar) {
        this.c = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(true);
        this.c.invalidateSelf();
    }
}

package h.e.g;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ p c;
    final /* synthetic */ int d;

    b(c cVar, p pVar, int i2) {
        this.c = pVar;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.d);
    }
}

package h.e.g;

/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ h.e.i.a c;
    final /* synthetic */ Object d;

    t(u uVar, h.e.i.a aVar, Object obj) {
        this.c = aVar;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.accept(this.d);
    }
}

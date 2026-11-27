package androidx.core.app;

/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ k c;
    final /* synthetic */ Object d;

    h(k kVar, Object obj) {
        this.c = kVar;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a = this.d;
    }
}

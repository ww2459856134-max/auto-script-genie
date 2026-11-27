package androidx.core.content.c;

/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ int c;
    final /* synthetic */ m d;

    l(m mVar, int i2) {
        this.d = mVar;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.d(this.c);
    }
}

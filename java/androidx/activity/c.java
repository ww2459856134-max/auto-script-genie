package androidx.activity;

/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ int c;
    final /* synthetic */ androidx.activity.result.l.a d;
    final /* synthetic */ e e;

    c(e eVar, int i2, androidx.activity.result.l.a aVar) {
        this.e = eVar;
        this.c = i2;
        this.d = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.c(this.c, this.d.a());
    }
}

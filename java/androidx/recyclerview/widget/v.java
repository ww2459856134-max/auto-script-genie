package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ z c;

    v(z zVar) {
        this.c = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.p(500);
    }
}

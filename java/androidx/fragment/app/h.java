package androidx.fragment.app;

/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ i c;

    h(i iVar) {
        this.c = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.c;
        iVar.c.endViewTransition(iVar.d);
        this.c.e.a();
    }
}

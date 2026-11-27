package l.a.a.h;

/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ Object c;
    final /* synthetic */ l d;

    j(l lVar, Object obj) {
        this.d = lVar;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l lVar = this.d;
            lVar.i(this.c, lVar.a);
        } catch (l.a.a.c.b unused) {
        } catch (Throwable th) {
            this.d.c.shutdown();
            throw th;
        }
        this.d.c.shutdown();
    }
}

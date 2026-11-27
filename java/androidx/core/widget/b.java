package androidx.core.widget;

import h.e.j.s0;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ c c;

    b(c cVar) {
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.c;
        if (cVar.H) {
            if (cVar.D) {
                cVar.D = false;
                cVar.c.m();
            }
            a aVar = this.c.c;
            if (aVar.h() || !this.c.u()) {
                this.c.H = false;
                return;
            }
            c cVar2 = this.c;
            if (cVar2.G) {
                cVar2.G = false;
                cVar2.c();
            }
            aVar.a();
            this.c.j(aVar.b(), aVar.c());
            s0.U(this.c.e, this);
        }
    }
}

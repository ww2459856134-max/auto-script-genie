package com.bluetooth.cursor;

/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ t c;

    s(t tVar) {
        this.c = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.c.U && this.c.b0) {
            this.c.X0();
            if (com.bluetooth.cursor.w.q.l() && com.bluetooth.cursor.w.q.k() && System.currentTimeMillis() - this.c.d0 > 3000) {
                this.c.d0 = System.currentTimeMillis();
                this.c.s0(false);
            }
            this.c.Y0();
        }
    }
}

package androidx.appcompat.app;

import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t0 c;

    w(t0 t0Var) {
        this.c = t0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        t0 t0Var = this.c;
        if ((t0Var.u0 & 1) != 0) {
            t0Var.U(0);
        }
        t0 t0Var2 = this.c;
        if ((t0Var2.u0 & XMLEvent.CHANGE_PREFIX_MAPPING) != 0) {
            t0Var2.U(108);
        }
        t0 t0Var3 = this.c;
        t0Var3.t0 = false;
        t0Var3.u0 = 0;
    }
}

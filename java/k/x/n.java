package k.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class n {
    private p a;
    private ArrayList b = new ArrayList();

    public n(p pVar) {
        this.a = pVar;
    }

    public void a(q qVar) {
        this.b.add(qVar);
    }

    public void b(k.b0.v.l0 l0Var) throws IOException {
        l0Var.e(this.a);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            l0Var.e((q) it.next());
        }
    }
}

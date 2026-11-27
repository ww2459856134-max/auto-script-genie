package n.a.a.k.b.z.r;

import i.b.ha.a.b.d.c.o1;
import i.b.ha.a.b.d.c.w1;
import java.io.IOException;
import java.io.OutputStream;
import n.a.a.k.a.f;
import n.a.a.k.b.m;
import n.a.a.k.b.u;
import n.a.a.k.b.z.q;

/* loaded from: classes.dex */
public final class d extends c {
    @Override // n.a.a.k.b.z.r.c, n.a.a.k.b.z.l
    public boolean a(m mVar, OutputStream outputStream) throws f {
        if (!(outputStream instanceof w1)) {
            throw new IllegalArgumentException("ZipOutputStream expected!");
        }
        w1 w1Var = (w1) outputStream;
        o1 o1Var = new o1(q.d(mVar.r().g().toString()));
        try {
            q.a(o1Var);
            w1Var.J(o1Var);
            try {
                super.a(mVar, outputStream);
                return u.a(this.b, outputStream);
            } finally {
                w1Var.f();
            }
        } catch (IOException e) {
            throw new f(e.getLocalizedMessage(), e);
        }
    }
}

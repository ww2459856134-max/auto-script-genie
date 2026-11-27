package k.x;

import java.io.IOException;

/* loaded from: classes.dex */
public class a {
    private f0 a;
    private b b;
    private c c;

    public a(f0 f0Var, b bVar) {
        this.a = f0Var;
        this.b = bVar;
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void b(k.b0.v.l0 l0Var) throws IOException {
        f0 f0Var = this.a;
        if (f0Var != null) {
            l0Var.e(f0Var);
        }
        b bVar = this.b;
        if (bVar != null) {
            l0Var.e(bVar);
        }
        c cVar = this.c;
        if (cVar != null) {
            l0Var.e(cVar);
        }
    }
}

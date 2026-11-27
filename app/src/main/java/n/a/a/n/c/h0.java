package n.a.a.n.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class h0 {
    private final List<g0> a = new ArrayList();
    private int b = -1;
    private int c;
    private int d;
    private g0 e;
    private int f;

    public h0(int i2) {
        this.f = i2;
    }

    public void a(int i2, int i3) {
        if (i2 > this.f) {
            return;
        }
        int i4 = this.b;
        if (i4 == -1) {
            this.b = i2;
            this.c = i3;
            this.d = i3;
        } else {
            if (i4 == i2 && this.d + 1 == i3) {
                this.d = i3;
                return;
            }
            g0 g0Var = this.e;
            if (g0Var == null) {
                this.e = new g0(i4, this.c, this.d);
            } else if (!g0Var.a(i4, this.c, this.d)) {
                this.a.add(this.e);
                this.e = new g0(this.b, this.c, this.d);
            }
            this.b = i2;
            this.c = i3;
            this.d = i3;
        }
    }
}

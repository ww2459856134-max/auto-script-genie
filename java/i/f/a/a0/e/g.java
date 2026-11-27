package i.f.a.a0.e;

import androidx.recyclerview.widget.k0;
import i.f.a.a0.c.o;
import i.f.a.a0.c.q;
import i.f.a.a0.c.u;

/* loaded from: classes.dex */
public final class g {
    private q a;
    private o b;
    private u c;
    private int d = -1;
    private b e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public b a() {
        return this.e;
    }

    public void c(o oVar) {
        this.b = oVar;
    }

    public void d(int i2) {
        this.d = i2;
    }

    public void e(b bVar) {
        this.e = bVar;
    }

    public void f(q qVar) {
        this.a = qVar;
    }

    public void g(u uVar) {
        this.c = uVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(k0.a.DEFAULT_DRAG_ANIMATION_DURATION);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.d);
        if (this.e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}

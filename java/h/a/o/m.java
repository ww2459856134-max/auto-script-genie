package h.a.o;

import android.view.animation.Interpolator;
import h.e.j.a1;
import h.e.j.b1;
import h.e.j.z0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class m {
    private Interpolator c;
    a1 d;
    private boolean e;
    private long b = -1;
    private final b1 f = new l(this);
    final ArrayList<z0> a = new ArrayList<>();

    public void a() {
        if (this.e) {
            Iterator<z0> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    void b() {
        this.e = false;
    }

    public m c(z0 z0Var) {
        if (!this.e) {
            this.a.add(z0Var);
        }
        return this;
    }

    public m d(z0 z0Var, z0 z0Var2) {
        this.a.add(z0Var);
        z0Var2.h(z0Var.c());
        this.a.add(z0Var2);
        return this;
    }

    public m e(long j2) {
        if (!this.e) {
            this.b = j2;
        }
        return this;
    }

    public m f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public m g(a1 a1Var) {
        if (!this.e) {
            this.d = a1Var;
        }
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        Iterator<z0> it = this.a.iterator();
        while (it.hasNext()) {
            z0 next = it.next();
            long j2 = this.b;
            if (j2 >= 0) {
                next.d(j2);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                next.e(interpolator);
            }
            if (this.d != null) {
                next.f(this.f);
            }
            next.j();
        }
        this.e = true;
    }
}

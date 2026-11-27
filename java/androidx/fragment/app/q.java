package androidx.fragment.app;

/* loaded from: classes.dex */
class q extends p {
    private final Object c;
    private final boolean d;
    private final Object e;

    q(i3 i3Var, h.e.f.c cVar, boolean z, boolean z2) {
        super(i3Var, cVar);
        if (i3Var.e() == h3.VISIBLE) {
            this.c = z ? i3Var.f().Q() : i3Var.f().z();
            this.d = z ? i3Var.f().s() : i3Var.f().r();
        } else {
            this.c = z ? i3Var.f().S() : i3Var.f().C();
            this.d = true;
        }
        if (!z2) {
            this.e = null;
        } else if (z) {
            this.e = i3Var.f().U();
        } else {
            this.e = i3Var.f().T();
        }
    }

    private y2 f(Object obj) {
        if (obj == null) {
            return null;
        }
        y2 y2Var = o2.b;
        if (y2Var != null && y2Var.e(obj)) {
            return y2Var;
        }
        y2 y2Var2 = o2.c;
        if (y2Var2 != null && y2Var2.e(obj)) {
            return y2Var2;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
    }

    y2 e() {
        y2 y2VarF = f(this.c);
        y2 y2VarF2 = f(this.e);
        if (y2VarF == null || y2VarF2 == null || y2VarF == y2VarF2) {
            return y2VarF != null ? y2VarF : y2VarF2;
        }
        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.c + " which uses a different Transition  type than its shared element transition " + this.e);
    }

    public Object g() {
        return this.e;
    }

    Object h() {
        return this.c;
    }

    public boolean i() {
        return this.e != null;
    }

    boolean j() {
        return this.d;
    }
}

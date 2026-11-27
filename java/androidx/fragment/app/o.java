package androidx.fragment.app;

import android.content.Context;

/* loaded from: classes.dex */
class o extends p {
    private boolean c;
    private boolean d;
    private m0 e;

    o(i3 i3Var, h.e.f.c cVar, boolean z) {
        super(i3Var, cVar);
        this.d = false;
        this.c = z;
    }

    m0 e(Context context) {
        if (this.d) {
            return this.e;
        }
        m0 m0VarC = o0.c(context, b().f(), b().e() == h3.VISIBLE, this.c);
        this.e = m0VarC;
        this.d = true;
        return m0VarC;
    }
}

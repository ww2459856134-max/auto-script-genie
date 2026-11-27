package h.e.j;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
class m0 implements View.OnApplyWindowInsetsListener {
    e1 a = null;
    final /* synthetic */ View b;
    final /* synthetic */ a0 c;

    m0(View view, a0 a0Var) {
        this.b = view;
        this.c = a0Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        e1 e1VarS = e1.s(windowInsets, view);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            n0.a(windowInsets, this.b);
            if (e1VarS.equals(this.a)) {
                return this.c.a(view, e1VarS).q();
            }
        }
        this.a = e1VarS;
        e1 e1VarA = this.c.a(view, e1VarS);
        if (i2 >= 30) {
            return e1VarA.q();
        }
        s0.W(view);
        return e1VarA.q();
    }
}

package h.e.j;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
abstract class o0 {
    public static e1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        e1 e1VarR = e1.r(rootWindowInsets);
        e1VarR.o(e1VarR);
        e1VarR.d(view.getRootView());
        return e1VarR;
    }
}

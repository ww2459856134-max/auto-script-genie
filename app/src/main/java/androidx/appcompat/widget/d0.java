package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class d0 extends androidx.core.content.c.m {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ WeakReference c;
    final /* synthetic */ f0 d;

    d0(f0 f0Var, int i2, int i3, WeakReference weakReference) {
        this.d = f0Var;
        this.a = i2;
        this.b = i3;
        this.c = weakReference;
    }

    @Override // androidx.core.content.c.m
    public void d(int i2) {
    }

    @Override // androidx.core.content.c.m
    public void e(Typeface typeface) {
        int i2;
        if (Build.VERSION.SDK_INT >= 28 && (i2 = this.a) != -1) {
            typeface = Typeface.create(typeface, i2, (this.b & 2) != 0);
        }
        this.d.n(this.c, typeface);
    }
}

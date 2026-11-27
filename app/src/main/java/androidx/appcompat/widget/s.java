package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
class s extends PopupWindow {
    private static final boolean b;
    private boolean a;

    static {
        b = Build.VERSION.SDK_INT < 21;
    }

    public s(Context context, AttributeSet attributeSet, int i2, int i3) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        t1 t1VarU = t1.u(context, attributeSet, h.a.j.Q1, i2, i3);
        int i4 = h.a.j.S1;
        if (t1VarU.r(i4)) {
            b(t1VarU.a(i4, false));
        }
        setBackgroundDrawable(t1VarU.f(h.a.j.R1));
        t1VarU.v();
    }

    private void b(boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (b) {
            this.a = z;
        } else {
            androidx.core.widget.k.a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (b && this.a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (b && this.a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (b && this.a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}

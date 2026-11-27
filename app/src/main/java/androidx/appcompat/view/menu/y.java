package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.z;
import h.e.j.s0;

/* loaded from: classes.dex */
public class y {
    private final Context a;
    private final m b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f94h;

    /* renamed from: i, reason: collision with root package name */
    private z.a f95i;

    /* renamed from: j, reason: collision with root package name */
    private w f96j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f97k;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f98l;

    public y(Context context, m mVar, View view, boolean z, int i2) {
        this(context, mVar, view, z, i2, 0);
    }

    private w a() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        w iVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(h.a.d.c) ? new i(this.a, this.f, this.d, this.e, this.c) : new f0(this.a, this.b, this.f, this.d, this.e, this.c);
        iVar.l(this.b);
        iVar.u(this.f98l);
        iVar.p(this.f);
        iVar.j(this.f95i);
        iVar.r(this.f94h);
        iVar.s(this.g);
        return iVar;
    }

    private void l(int i2, int i3, boolean z, boolean z2) {
        w wVarC = c();
        wVarC.v(z2);
        if (z) {
            if ((h.e.j.n.a(this.g, s0.w(this.f)) & 7) == 5) {
                i2 -= this.f.getWidth();
            }
            wVarC.t(i2);
            wVarC.w(i3);
            int i4 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            wVarC.q(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        wVarC.g();
    }

    public void b() {
        if (d()) {
            this.f96j.dismiss();
        }
    }

    public w c() {
        if (this.f96j == null) {
            this.f96j = a();
        }
        return this.f96j;
    }

    public boolean d() {
        w wVar = this.f96j;
        return wVar != null && wVar.a();
    }

    protected void e() {
        this.f96j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f97k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f = view;
    }

    public void g(boolean z) {
        this.f94h = z;
        w wVar = this.f96j;
        if (wVar != null) {
            wVar.r(z);
        }
    }

    public void h(int i2) {
        this.g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f97k = onDismissListener;
    }

    public void j(z.a aVar) {
        this.f95i = aVar;
        w wVar = this.f96j;
        if (wVar != null) {
            wVar.j(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public y(Context context, m mVar, View view, boolean z, int i2, int i3) {
        this.g = 8388611;
        this.f98l = new x(this);
        this.a = context;
        this.b = mVar;
        this.f = view;
        this.c = z;
        this.d = i2;
        this.e = i3;
    }
}

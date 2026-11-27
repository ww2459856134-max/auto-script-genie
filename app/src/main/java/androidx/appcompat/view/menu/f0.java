package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.z;
import androidx.appcompat.widget.MenuPopupWindow;
import h.e.j.s0;

/* loaded from: classes.dex */
final class f0 extends w implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, z, View.OnKeyListener {
    private static final int Q = h.a.g.f1216o;
    private PopupWindow.OnDismissListener C;
    private View D;
    View G;
    private z.a H;
    ViewTreeObserver I;
    private boolean J;
    private boolean K;
    private int M;
    private boolean P;
    private final Context d;
    private final m e;
    private final l f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private final int f65h;

    /* renamed from: i, reason: collision with root package name */
    private final int f66i;

    /* renamed from: j, reason: collision with root package name */
    private final int f67j;

    /* renamed from: k, reason: collision with root package name */
    final MenuPopupWindow f68k;
    final ViewTreeObserver.OnGlobalLayoutListener t = new d0(this);
    private final View.OnAttachStateChangeListener A = new e0(this);
    private int O = 0;

    public f0(Context context, m mVar, View view, int i2, int i3, boolean z) {
        this.d = context;
        this.e = mVar;
        this.g = z;
        this.f = new l(mVar, LayoutInflater.from(context), z, Q);
        this.f66i = i2;
        this.f67j = i3;
        Resources resources = context.getResources();
        this.f65h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(h.a.d.d));
        this.D = view;
        this.f68k = new MenuPopupWindow(context, null, i2, i3);
        mVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (a()) {
            return true;
        }
        if (this.J || (view = this.D) == null) {
            return false;
        }
        this.G = view;
        this.f68k.F(this);
        this.f68k.G(this);
        this.f68k.E(true);
        View view2 = this.G;
        boolean z = this.I == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.I = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.t);
        }
        view2.addOnAttachStateChangeListener(this.A);
        this.f68k.y(view2);
        this.f68k.B(this.O);
        if (!this.K) {
            this.M = w.o(this.f, null, this.d, this.f65h);
            this.K = true;
        }
        this.f68k.A(this.M);
        this.f68k.D(2);
        this.f68k.C(n());
        this.f68k.g();
        ListView listViewI = this.f68k.i();
        listViewI.setOnKeyListener(this);
        if (this.P && this.e.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.d).inflate(h.a.g.f1215n, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.e.x());
            }
            frameLayout.setEnabled(false);
            listViewI.addHeaderView(frameLayout, null, false);
        }
        this.f68k.n(this.f);
        this.f68k.g();
        return true;
    }

    @Override // androidx.appcompat.view.menu.c0
    public boolean a() {
        return !this.J && this.f68k.a();
    }

    @Override // androidx.appcompat.view.menu.z
    public void b(m mVar, boolean z) {
        if (mVar != this.e) {
            return;
        }
        dismiss();
        z.a aVar = this.H;
        if (aVar != null) {
            aVar.b(mVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public void d(boolean z) {
        this.K = false;
        l lVar = this.f;
        if (lVar != null) {
            lVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.c0
    public void dismiss() {
        if (a()) {
            this.f68k.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.c0
    public void g() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.c0
    public ListView i() {
        return this.f68k.i();
    }

    @Override // androidx.appcompat.view.menu.z
    public void j(z.a aVar) {
        this.H = aVar;
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean k(g0 g0Var) {
        if (g0Var.hasVisibleItems()) {
            y yVar = new y(this.d, g0Var, this.G, this.g, this.f66i, this.f67j);
            yVar.j(this.H);
            yVar.g(w.x(g0Var));
            yVar.i(this.C);
            this.C = null;
            this.e.e(false);
            int iJ = this.f68k.j();
            int iF = this.f68k.f();
            if ((Gravity.getAbsoluteGravity(this.O, s0.w(this.D)) & 7) == 5) {
                iJ += this.D.getWidth();
            }
            if (yVar.n(iJ, iF)) {
                z.a aVar = this.H;
                if (aVar == null) {
                    return true;
                }
                aVar.c(g0Var);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.w
    public void l(m mVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.J = true;
        this.e.close();
        ViewTreeObserver viewTreeObserver = this.I;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.I = this.G.getViewTreeObserver();
            }
            this.I.removeGlobalOnLayoutListener(this.t);
            this.I = null;
        }
        this.G.removeOnAttachStateChangeListener(this.A);
        PopupWindow.OnDismissListener onDismissListener = this.C;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.w
    public void p(View view) {
        this.D = view;
    }

    @Override // androidx.appcompat.view.menu.w
    public void r(boolean z) {
        this.f.d(z);
    }

    @Override // androidx.appcompat.view.menu.w
    public void s(int i2) {
        this.O = i2;
    }

    @Override // androidx.appcompat.view.menu.w
    public void t(int i2) {
        this.f68k.k(i2);
    }

    @Override // androidx.appcompat.view.menu.w
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.C = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.w
    public void v(boolean z) {
        this.P = z;
    }

    @Override // androidx.appcompat.view.menu.w
    public void w(int i2) {
        this.f68k.c(i2);
    }
}

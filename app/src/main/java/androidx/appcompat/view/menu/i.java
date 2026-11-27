package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.z;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.b1;
import h.e.j.s0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class i extends w implements z, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int b0 = h.a.g.g;
    private View H;
    View I;
    private boolean K;
    private boolean M;
    private int O;
    private int P;
    private boolean U;
    private z.a V;
    ViewTreeObserver W;
    private PopupWindow.OnDismissListener Z;
    boolean a0;
    private final Context d;
    private final int e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f69h;

    /* renamed from: i, reason: collision with root package name */
    final Handler f70i;

    /* renamed from: j, reason: collision with root package name */
    private final List<m> f71j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    final List<h> f72k = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener t = new d(this);
    private final View.OnAttachStateChangeListener A = new e(this);
    private final b1 C = new g(this);
    private int D = 0;
    private int G = 0;
    private boolean Q = false;
    private int J = D();

    public i(Context context, View view, int i2, int i3, boolean z) {
        this.d = context;
        this.H = view;
        this.f = i2;
        this.g = i3;
        this.f69h = z;
        Resources resources = context.getResources();
        this.e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(h.a.d.d));
        this.f70i = new Handler();
    }

    private int A(m mVar) {
        int size = this.f72k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (mVar == this.f72k.get(i2).b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem B(m mVar, m mVar2) {
        int size = mVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = mVar.getItem(i2);
            if (item.hasSubMenu() && mVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(h hVar, m mVar) {
        l lVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(hVar.b, mVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = hVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            lVar = (l) headerViewListAdapter.getWrappedAdapter();
        } else {
            lVar = (l) adapter;
            headersCount = 0;
        }
        int count = lVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (menuItemB == lVar.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return s0.w(this.H) == 1 ? 0 : 1;
    }

    private int E(int i2) {
        List<h> list = this.f72k;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.I.getWindowVisibleDisplayFrame(rect);
        return this.J == 1 ? (iArr[0] + listViewA.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void F(m mVar) {
        h hVar;
        View viewC;
        int i2;
        int i3;
        int i4;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.d);
        l lVar = new l(mVar, layoutInflaterFrom, this.f69h, b0);
        if (!a() && this.Q) {
            lVar.d(true);
        } else if (a()) {
            lVar.d(w.x(mVar));
        }
        int iO = w.o(lVar, null, this.d, this.e);
        MenuPopupWindow menuPopupWindowZ = z();
        menuPopupWindowZ.n(lVar);
        menuPopupWindowZ.A(iO);
        menuPopupWindowZ.B(this.G);
        if (this.f72k.size() > 0) {
            List<h> list = this.f72k;
            hVar = list.get(list.size() - 1);
            viewC = C(hVar, mVar);
        } else {
            hVar = null;
            viewC = null;
        }
        if (viewC != null) {
            menuPopupWindowZ.P(false);
            menuPopupWindowZ.M(null);
            int iE = E(iO);
            boolean z = iE == 1;
            this.J = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindowZ.y(viewC);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.H.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.G & 7) == 5) {
                    iArr[0] = iArr[0] + this.H.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.G & 5) == 5) {
                if (!z) {
                    iO = viewC.getWidth();
                    i4 = i2 - iO;
                }
                i4 = i2 + iO;
            } else {
                if (z) {
                    iO = viewC.getWidth();
                    i4 = i2 + iO;
                }
                i4 = i2 - iO;
            }
            menuPopupWindowZ.k(i4);
            menuPopupWindowZ.H(true);
            menuPopupWindowZ.c(i3);
        } else {
            if (this.K) {
                menuPopupWindowZ.k(this.O);
            }
            if (this.M) {
                menuPopupWindowZ.c(this.P);
            }
            menuPopupWindowZ.C(n());
        }
        this.f72k.add(new h(menuPopupWindowZ, mVar, this.J));
        menuPopupWindowZ.g();
        ListView listViewI = menuPopupWindowZ.i();
        listViewI.setOnKeyListener(this);
        if (hVar == null && this.U && mVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(h.a.g.f1215n, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(mVar.x());
            listViewI.addHeaderView(frameLayout, null, false);
            menuPopupWindowZ.g();
        }
    }

    private MenuPopupWindow z() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.d, null, this.f, this.g);
        menuPopupWindow.O(this.C);
        menuPopupWindow.G(this);
        menuPopupWindow.F(this);
        menuPopupWindow.y(this.H);
        menuPopupWindow.B(this.G);
        menuPopupWindow.E(true);
        menuPopupWindow.D(2);
        return menuPopupWindow;
    }

    @Override // androidx.appcompat.view.menu.c0
    public boolean a() {
        return this.f72k.size() > 0 && this.f72k.get(0).a.a();
    }

    @Override // androidx.appcompat.view.menu.z
    public void b(m mVar, boolean z) {
        int iA = A(mVar);
        if (iA < 0) {
            return;
        }
        int i2 = iA + 1;
        if (i2 < this.f72k.size()) {
            this.f72k.get(i2).b.e(false);
        }
        h hVarRemove = this.f72k.remove(iA);
        hVarRemove.b.O(this);
        if (this.a0) {
            hVarRemove.a.N(null);
            hVarRemove.a.z(0);
        }
        hVarRemove.a.dismiss();
        int size = this.f72k.size();
        if (size > 0) {
            this.J = this.f72k.get(size - 1).c;
        } else {
            this.J = D();
        }
        if (size != 0) {
            if (z) {
                this.f72k.get(0).b.e(false);
                return;
            }
            return;
        }
        dismiss();
        z.a aVar = this.V;
        if (aVar != null) {
            aVar.b(mVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.W;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.W.removeGlobalOnLayoutListener(this.t);
            }
            this.W = null;
        }
        this.I.removeOnAttachStateChangeListener(this.A);
        this.Z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.z
    public void d(boolean z) {
        Iterator<h> it = this.f72k.iterator();
        while (it.hasNext()) {
            w.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.c0
    public void dismiss() {
        int size = this.f72k.size();
        if (size > 0) {
            h[] hVarArr = (h[]) this.f72k.toArray(new h[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                h hVar = hVarArr[i2];
                if (hVar.a.a()) {
                    hVar.a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.c0
    public void g() {
        if (a()) {
            return;
        }
        Iterator<m> it = this.f71j.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.f71j.clear();
        View view = this.H;
        this.I = view;
        if (view != null) {
            boolean z = this.W == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.W = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.t);
            }
            this.I.addOnAttachStateChangeListener(this.A);
        }
    }

    @Override // androidx.appcompat.view.menu.c0
    public ListView i() {
        if (this.f72k.isEmpty()) {
            return null;
        }
        return this.f72k.get(r0.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.z
    public void j(z.a aVar) {
        this.V = aVar;
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean k(g0 g0Var) {
        for (h hVar : this.f72k) {
            if (g0Var == hVar.b) {
                hVar.a().requestFocus();
                return true;
            }
        }
        if (!g0Var.hasVisibleItems()) {
            return false;
        }
        l(g0Var);
        z.a aVar = this.V;
        if (aVar != null) {
            aVar.c(g0Var);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.w
    public void l(m mVar) {
        mVar.c(this, this.d);
        if (a()) {
            F(mVar);
        } else {
            this.f71j.add(mVar);
        }
    }

    @Override // androidx.appcompat.view.menu.w
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        h hVar;
        int size = this.f72k.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                hVar = null;
                break;
            }
            hVar = this.f72k.get(i2);
            if (!hVar.a.a()) {
                break;
            } else {
                i2++;
            }
        }
        if (hVar != null) {
            hVar.b.e(false);
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
        if (this.H != view) {
            this.H = view;
            this.G = h.e.j.n.a(this.D, s0.w(view));
        }
    }

    @Override // androidx.appcompat.view.menu.w
    public void r(boolean z) {
        this.Q = z;
    }

    @Override // androidx.appcompat.view.menu.w
    public void s(int i2) {
        if (this.D != i2) {
            this.D = i2;
            this.G = h.e.j.n.a(i2, s0.w(this.H));
        }
    }

    @Override // androidx.appcompat.view.menu.w
    public void t(int i2) {
        this.K = true;
        this.O = i2;
    }

    @Override // androidx.appcompat.view.menu.w
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.Z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.w
    public void v(boolean z) {
        this.U = z;
    }

    @Override // androidx.appcompat.view.menu.w
    public void w(int i2) {
        this.M = true;
        this.P = i2;
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.a0;
import java.util.ArrayList;

/* loaded from: classes.dex */
class k extends androidx.appcompat.view.menu.b implements h.e.j.c {
    private boolean A;
    private boolean C;
    private boolean D;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean M;
    private boolean O;
    private int P;
    private final SparseBooleanArray Q;
    i U;
    d V;
    f W;
    private e Z;
    final j a0;
    int b0;

    /* renamed from: k, reason: collision with root package name */
    h f168k;
    private Drawable t;

    public k(Context context) {
        super(context, h.a.g.c, h.a.g.b);
        this.Q = new SparseBooleanArray();
        this.a0 = new j(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View A(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f64j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof a0.a) && ((a0.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable B() {
        h hVar = this.f168k;
        if (hVar != null) {
            return hVar.getDrawable();
        }
        if (this.A) {
            return this.t;
        }
        return null;
    }

    public boolean C() {
        Object obj;
        f fVar = this.W;
        if (fVar != null && (obj = this.f64j) != null) {
            ((View) obj).removeCallbacks(fVar);
            this.W = null;
            return true;
        }
        i iVar = this.U;
        if (iVar == null) {
            return false;
        }
        iVar.b();
        return true;
    }

    public boolean D() {
        d dVar = this.V;
        if (dVar == null) {
            return false;
        }
        dVar.b();
        return true;
    }

    public boolean E() {
        return this.W != null || F();
    }

    public boolean F() {
        i iVar = this.U;
        return iVar != null && iVar.d();
    }

    public void G(Configuration configuration) {
        if (!this.J) {
            this.I = h.a.o.a.b(this.d).d();
        }
        androidx.appcompat.view.menu.m mVar = this.e;
        if (mVar != null) {
            mVar.K(true);
        }
    }

    public void H(boolean z) {
        this.O = z;
    }

    public void I(ActionMenuView actionMenuView) {
        this.f64j = actionMenuView;
        actionMenuView.a(this.e);
    }

    public void J(Drawable drawable) {
        h hVar = this.f168k;
        if (hVar != null) {
            hVar.setImageDrawable(drawable);
        } else {
            this.A = true;
            this.t = drawable;
        }
    }

    public void K(boolean z) {
        this.C = z;
        this.D = true;
    }

    public boolean L() {
        androidx.appcompat.view.menu.m mVar;
        if (!this.C || F() || (mVar = this.e) == null || this.f64j == null || this.W != null || mVar.z().isEmpty()) {
            return false;
        }
        f fVar = new f(this, new i(this, this.d, this.e, this.f168k, true));
        this.W = fVar;
        ((View) this.f64j).post(fVar);
        return true;
    }

    @Override // h.e.j.c
    public void a(boolean z) {
        if (z) {
            super.k(null);
            return;
        }
        androidx.appcompat.view.menu.m mVar = this.e;
        if (mVar != null) {
            mVar.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.z
    public void b(androidx.appcompat.view.menu.m mVar, boolean z) {
        z();
        super.b(mVar, z);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.z
    public void d(boolean z) {
        super.d(z);
        ((View) this.f64j).requestLayout();
        androidx.appcompat.view.menu.m mVar = this.e;
        boolean z2 = false;
        if (mVar != null) {
            ArrayList<androidx.appcompat.view.menu.p> arrayListS = mVar.s();
            int size = arrayListS.size();
            for (int i2 = 0; i2 < size; i2++) {
                h.e.j.e eVarA = arrayListS.get(i2).a();
                if (eVarA != null) {
                    eVarA.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.m mVar2 = this.e;
        ArrayList<androidx.appcompat.view.menu.p> arrayListZ = mVar2 != null ? mVar2.z() : null;
        if (this.C && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z2 = !arrayListZ.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f168k == null) {
                this.f168k = new h(this, this.c);
            }
            ViewGroup viewGroup = (ViewGroup) this.f168k.getParent();
            if (viewGroup != this.f64j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f168k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f64j;
                actionMenuView.addView(this.f168k, actionMenuView.D());
            }
        } else {
            h hVar = this.f168k;
            if (hVar != null) {
                Object parent = hVar.getParent();
                Object obj = this.f64j;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f168k);
                }
            }
        }
        ((ActionMenuView) this.f64j).setOverflowReserved(this.C);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.z
    public boolean e() {
        ArrayList<androidx.appcompat.view.menu.p> arrayListE;
        int size;
        int i2;
        int iJ;
        boolean z;
        int i3;
        k kVar = this;
        androidx.appcompat.view.menu.m mVar = kVar.e;
        View view = null;
        ?? r3 = 0;
        if (mVar != null) {
            arrayListE = mVar.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i4 = kVar.I;
        int i5 = kVar.H;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) kVar.f64j;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            androidx.appcompat.view.menu.p pVar = arrayListE.get(i8);
            if (pVar.o()) {
                i6++;
            } else if (pVar.n()) {
                i7++;
            } else {
                z2 = true;
            }
            if (kVar.O && pVar.isActionViewExpanded()) {
                i4 = 0;
            }
        }
        if (kVar.C && (z2 || i7 + i6 > i4)) {
            i4--;
        }
        int i9 = i4 - i6;
        SparseBooleanArray sparseBooleanArray = kVar.Q;
        sparseBooleanArray.clear();
        if (kVar.K) {
            int i10 = kVar.P;
            iJ = i5 / i10;
            i2 = i10 + ((i5 % i10) / iJ);
        } else {
            i2 = 0;
            iJ = 0;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            androidx.appcompat.view.menu.p pVar2 = arrayListE.get(i11);
            if (pVar2.o()) {
                View viewO = kVar.o(pVar2, view, viewGroup);
                if (kVar.K) {
                    iJ -= ActionMenuView.J(viewO, i2, iJ, iMakeMeasureSpec, r3);
                } else {
                    viewO.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewO.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                int groupId = pVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                pVar2.u(true);
                z = r3;
                i3 = size;
            } else if (pVar2.n()) {
                int groupId2 = pVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i9 > 0 || z3) && i5 > 0 && (!kVar.K || iJ > 0);
                boolean z5 = z4;
                i3 = size;
                if (z4) {
                    View viewO2 = kVar.o(pVar2, null, viewGroup);
                    if (kVar.K) {
                        int iJ2 = ActionMenuView.J(viewO2, i2, iJ, iMakeMeasureSpec, 0);
                        iJ -= iJ2;
                        if (iJ2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewO2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewO2.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i12 == 0) {
                        i12 = measuredWidth2;
                    }
                    z4 = z6 & (!kVar.K ? i5 + i12 <= 0 : i5 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i13 = 0; i13 < i11; i13++) {
                        androidx.appcompat.view.menu.p pVar3 = arrayListE.get(i13);
                        if (pVar3.getGroupId() == groupId2) {
                            if (pVar3.l()) {
                                i9++;
                            }
                            pVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i9--;
                }
                pVar2.u(z4);
                z = false;
            } else {
                z = r3;
                i3 = size;
                pVar2.u(z);
            }
            i11++;
            r3 = z;
            size = i3;
            view = null;
            kVar = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.z
    public void h(Context context, androidx.appcompat.view.menu.m mVar) {
        super.h(context, mVar);
        Resources resources = context.getResources();
        h.a.o.a aVarB = h.a.o.a.b(context);
        if (!this.D) {
            this.C = aVarB.h();
        }
        if (!this.M) {
            this.G = aVarB.c();
        }
        if (!this.J) {
            this.I = aVarB.d();
        }
        int measuredWidth = this.G;
        if (this.C) {
            if (this.f168k == null) {
                h hVar = new h(this, this.c);
                this.f168k = hVar;
                if (this.A) {
                    hVar.setImageDrawable(this.t);
                    this.t = null;
                    this.A = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f168k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f168k.getMeasuredWidth();
        } else {
            this.f168k = null;
        }
        this.H = measuredWidth;
        this.P = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b
    public void i(androidx.appcompat.view.menu.p pVar, a0.a aVar) {
        aVar.d(pVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f64j);
        if (this.Z == null) {
            this.Z = new e(this);
        }
        actionMenuItemView.setPopupCallback(this.Z);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.z
    public boolean k(androidx.appcompat.view.menu.g0 g0Var) {
        boolean z = false;
        if (!g0Var.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.g0 g0Var2 = g0Var;
        while (g0Var2.e0() != this.e) {
            g0Var2 = (androidx.appcompat.view.menu.g0) g0Var2.e0();
        }
        View viewA = A(g0Var2.getItem());
        if (viewA == null) {
            return false;
        }
        g0Var.getItem().getItemId();
        int size = g0Var.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = g0Var.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i2++;
        }
        d dVar = new d(this, this.d, g0Var, viewA);
        this.V = dVar;
        dVar.g(z);
        this.V.k();
        super.k(g0Var);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean m(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f168k) {
            return false;
        }
        return super.m(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.b
    public View o(androidx.appcompat.view.menu.p pVar, View view, ViewGroup viewGroup) {
        View actionView = pVar.getActionView();
        if (actionView == null || pVar.j()) {
            actionView = super.o(pVar, view, viewGroup);
        }
        actionView.setVisibility(pVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.a0 p(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.a0 a0Var = this.f64j;
        androidx.appcompat.view.menu.a0 a0VarP = super.p(viewGroup);
        if (a0Var != a0VarP) {
            ((ActionMenuView) a0VarP).setPresenter(this);
        }
        return a0VarP;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean r(int i2, androidx.appcompat.view.menu.p pVar) {
        return pVar.l();
    }

    public boolean z() {
        return C() | D();
    }
}

package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.a0;
import androidx.appcompat.view.menu.z;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements z {
    protected Context c;
    protected Context d;
    protected m e;
    protected LayoutInflater f;
    private z.a g;

    /* renamed from: h, reason: collision with root package name */
    private int f62h;

    /* renamed from: i, reason: collision with root package name */
    private int f63i;

    /* renamed from: j, reason: collision with root package name */
    protected a0 f64j;

    public b(Context context, int i2, int i3) {
        this.c = context;
        this.f = LayoutInflater.from(context);
        this.f62h = i2;
        this.f63i = i3;
    }

    @Override // androidx.appcompat.view.menu.z
    public void b(m mVar, boolean z) {
        z.a aVar = this.g;
        if (aVar != null) {
            aVar.b(mVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean c(m mVar, p pVar) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.z
    public void d(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f64j;
        if (viewGroup == null) {
            return;
        }
        m mVar = this.e;
        int i2 = 0;
        if (mVar != null) {
            mVar.r();
            ArrayList<p> arrayListE = this.e.E();
            int size = arrayListE.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                p pVar = arrayListE.get(i4);
                if (r(i3, pVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    p itemData = childAt instanceof a0.a ? ((a0.a) childAt).getItemData() : null;
                    View viewO = o(pVar, childAt, viewGroup);
                    if (pVar != itemData) {
                        viewO.setPressed(false);
                        viewO.jumpDrawablesToCurrentState();
                    }
                    if (viewO != childAt) {
                        g(viewO, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!m(viewGroup, i2)) {
                i2++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean f(m mVar, p pVar) {
        return false;
    }

    protected void g(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f64j).addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.z
    public void h(Context context, m mVar) {
        this.d = context;
        LayoutInflater.from(context);
        this.e = mVar;
    }

    public abstract void i(p pVar, a0.a aVar);

    @Override // androidx.appcompat.view.menu.z
    public void j(z.a aVar) {
        this.g = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.m] */
    @Override // androidx.appcompat.view.menu.z
    public boolean k(g0 g0Var) {
        z.a aVar = this.g;
        g0 g0Var2 = g0Var;
        if (aVar == null) {
            return false;
        }
        if (g0Var == null) {
            g0Var2 = this.e;
        }
        return aVar.c(g0Var2);
    }

    public a0.a l(ViewGroup viewGroup) {
        return (a0.a) this.f.inflate(this.f63i, viewGroup, false);
    }

    protected boolean m(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public z.a n() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View o(p pVar, View view, ViewGroup viewGroup) {
        a0.a aVarL = view instanceof a0.a ? (a0.a) view : l(viewGroup);
        i(pVar, aVarL);
        return (View) aVarL;
    }

    public a0 p(ViewGroup viewGroup) {
        if (this.f64j == null) {
            a0 a0Var = (a0) this.f.inflate(this.f62h, viewGroup, false);
            this.f64j = a0Var;
            a0Var.a(this.e);
            d(true);
        }
        return this.f64j;
    }

    public void q(int i2) {
    }

    public abstract boolean r(int i2, p pVar);
}

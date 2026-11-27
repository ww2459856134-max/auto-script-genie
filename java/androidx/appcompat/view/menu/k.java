package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.z;

/* loaded from: classes.dex */
public class k implements z, AdapterView.OnItemClickListener {
    Context c;
    LayoutInflater d;
    m e;
    ExpandedMenuView f;
    int g;

    /* renamed from: h, reason: collision with root package name */
    int f73h;

    /* renamed from: i, reason: collision with root package name */
    int f74i;

    /* renamed from: j, reason: collision with root package name */
    private z.a f75j;

    /* renamed from: k, reason: collision with root package name */
    j f76k;

    public k(Context context, int i2) {
        this(i2, 0);
        this.c = context;
        this.d = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f76k == null) {
            this.f76k = new j(this);
        }
        return this.f76k;
    }

    @Override // androidx.appcompat.view.menu.z
    public void b(m mVar, boolean z) {
        z.a aVar = this.f75j;
        if (aVar != null) {
            aVar.b(mVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean c(m mVar, p pVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.z
    public void d(boolean z) {
        j jVar = this.f76k;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean f(m mVar, p pVar) {
        return false;
    }

    public a0 g(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (ExpandedMenuView) this.d.inflate(h.a.g.f1210i, viewGroup, false);
            if (this.f76k == null) {
                this.f76k = new j(this);
            }
            this.f.setAdapter((ListAdapter) this.f76k);
            this.f.setOnItemClickListener(this);
        }
        return this.f;
    }

    @Override // androidx.appcompat.view.menu.z
    public void h(Context context, m mVar) {
        if (this.f73h != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f73h);
            this.c = contextThemeWrapper;
            this.d = LayoutInflater.from(contextThemeWrapper);
        } else if (this.c != null) {
            this.c = context;
            if (this.d == null) {
                this.d = LayoutInflater.from(context);
            }
        }
        this.e = mVar;
        j jVar = this.f76k;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public void j(z.a aVar) {
        this.f75j = aVar;
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean k(g0 g0Var) {
        if (!g0Var.hasVisibleItems()) {
            return false;
        }
        new n(g0Var).d(null);
        z.a aVar = this.f75j;
        if (aVar == null) {
            return true;
        }
        aVar.c(g0Var);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.e.M(this.f76k.getItem(i2), this, 0);
    }

    public k(int i2, int i3) {
        this.f74i = i2;
        this.f73h = i3;
    }
}

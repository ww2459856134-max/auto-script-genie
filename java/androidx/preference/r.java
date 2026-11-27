package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import h.e.j.s0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* loaded from: classes.dex */
public class r extends RecyclerView.g<x> implements Preference.c {
    private PreferenceGroup a;
    private List<Preference> b;
    private List<Preference> c;
    private List<q> d;
    private q e;
    private Handler f;
    private c g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f302h;

    public r(PreferenceGroup preferenceGroup) {
        this(preferenceGroup, new Handler());
    }

    private void c(Preference preference) {
        q qVarD = d(preference, null);
        if (this.d.contains(qVarD)) {
            return;
        }
        this.d.add(qVarD);
    }

    private q d(Preference preference, q qVar) {
        if (qVar == null) {
            qVar = new q();
        }
        qVar.c = preference.getClass().getName();
        qVar.a = preference.p();
        qVar.b = preference.B();
        return qVar;
    }

    private void e(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.J0();
        int iE0 = preferenceGroup.E0();
        for (int i2 = 0; i2 < iE0; i2++) {
            Preference preferenceD0 = preferenceGroup.D0(i2);
            list.add(preferenceD0);
            c(preferenceD0);
            if (preferenceD0 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceD0;
                if (preferenceGroup2.F0()) {
                    e(list, preferenceGroup2);
                }
            }
            preferenceD0.n0(this);
        }
    }

    @Override // androidx.preference.Preference.c
    public void a(Preference preference) {
        int iIndexOf = this.b.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.c
    public void b(Preference preference) {
        this.f.removeCallbacks(this.f302h);
        this.f.post(this.f302h);
    }

    public Preference f(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.b.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(x xVar, int i2) {
        f(i2).N(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        if (hasStableIds()) {
            return f(i2).m();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        q qVarD = d(f(i2), this.e);
        this.e = qVarD;
        int iIndexOf = this.d.indexOf(qVarD);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.d.size();
        this.d.add(new q(this.e));
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public x onCreateViewHolder(ViewGroup viewGroup, int i2) {
        q qVar = this.d.get(i2);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, e0.a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(e0.b);
        if (drawable == null) {
            drawable = androidx.core.content.a.e(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(qVar.a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            s0.a0(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i3 = qVar.b;
            if (i3 != 0) {
                layoutInflaterFrom.inflate(i3, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new x(viewInflate);
    }

    void i() {
        Iterator<Preference> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().n0(null);
        }
        ArrayList arrayList = new ArrayList(this.c.size());
        e(arrayList, this.a);
        List<Preference> listC = this.g.c(this.a);
        List<Preference> list = this.b;
        this.b = listC;
        this.c = arrayList;
        t tVarX = this.a.x();
        if (tVarX == null || tVarX.i() == null) {
            notifyDataSetChanged();
        } else {
            androidx.recyclerview.widget.r.a(new p(this, list, listC, tVarX.i())).e(this);
        }
        Iterator<Preference> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().c();
        }
    }

    private r(PreferenceGroup preferenceGroup, Handler handler) {
        this.e = new q();
        this.f302h = new o(this);
        this.a = preferenceGroup;
        this.f = handler;
        this.g = new c(preferenceGroup, this);
        this.a.n0(this);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.a;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).K0());
        } else {
            setHasStableIds(true);
        }
        i();
    }
}

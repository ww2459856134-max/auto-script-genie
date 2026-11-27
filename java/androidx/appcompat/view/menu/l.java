package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.a0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends BaseAdapter {
    m c;
    private int d = -1;
    private boolean e;
    private final boolean f;
    private final LayoutInflater g;

    /* renamed from: h, reason: collision with root package name */
    private final int f77h;

    public l(m mVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f = z;
        this.g = layoutInflater;
        this.c = mVar;
        this.f77h = i2;
        a();
    }

    void a() {
        p pVarV = this.c.v();
        if (pVarV != null) {
            ArrayList<p> arrayListZ = this.c.z();
            int size = arrayListZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayListZ.get(i2) == pVarV) {
                    this.d = i2;
                    return;
                }
            }
        }
        this.d = -1;
    }

    public m b() {
        return this.c;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public p getItem(int i2) {
        ArrayList<p> arrayListZ = this.f ? this.c.z() : this.c.E();
        int i3 = this.d;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayListZ.get(i2);
    }

    public void d(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d < 0 ? (this.f ? this.c.z() : this.c.E()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.g.inflate(this.f77h, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.c.F() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        a0.a aVar = (a0.a) view;
        if (this.e) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}

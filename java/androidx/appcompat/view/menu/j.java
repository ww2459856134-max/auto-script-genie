package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.a0;
import java.util.ArrayList;

/* loaded from: classes.dex */
class j extends BaseAdapter {
    private int c = -1;
    final /* synthetic */ k d;

    public j(k kVar) {
        this.d = kVar;
        a();
    }

    void a() {
        p pVarV = this.d.e.v();
        if (pVarV != null) {
            ArrayList<p> arrayListZ = this.d.e.z();
            int size = arrayListZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayListZ.get(i2) == pVarV) {
                    this.c = i2;
                    return;
                }
            }
        }
        this.c = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p getItem(int i2) {
        ArrayList<p> arrayListZ = this.d.e.z();
        int i3 = i2 + this.d.g;
        int i4 = this.c;
        if (i4 >= 0 && i3 >= i4) {
            i3++;
        }
        return arrayListZ.get(i3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.d.e.z().size() - this.d.g;
        return this.c < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            k kVar = this.d;
            view = kVar.d.inflate(kVar.f74i, viewGroup, false);
        }
        ((a0.a) view).d(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}

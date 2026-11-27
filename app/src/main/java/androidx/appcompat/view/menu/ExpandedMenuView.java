package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.t1;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements m.b, a0, AdapterView.OnItemClickListener {
    private static final int[] e = {R.attr.background, R.attr.divider};
    private m c;
    private int d;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.a0
    public void a(m mVar) {
        this.c = mVar;
    }

    @Override // androidx.appcompat.view.menu.m.b
    public boolean d(p pVar) {
        return this.c.L(pVar, 0);
    }

    public int getWindowAnimations() {
        return this.d;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        d((p) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        t1 t1VarU = t1.u(context, attributeSet, e, i2, 0);
        if (t1VarU.r(0)) {
            setBackgroundDrawable(t1VarU.f(0));
        }
        if (t1VarU.r(1)) {
            setDivider(t1VarU.f(1));
        }
        t1VarU.v();
    }
}

package com.yl.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.yl.ui.b0;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentViewPager extends LinearLayout implements ViewPager.j, View.OnClickListener {
    private ViewPager c;
    List<e> d;
    List<a> e;
    View f;
    LinearLayout g;

    public static class a {
    }

    public FragmentViewPager(Context context) {
        super(context);
        this.e = null;
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void a(int i2, float f, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void b(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void d(int i2) throws Resources.NotFoundException {
        setSelect(i2);
    }

    public a getCurrent() {
        return this.e.get(this.c.getCurrentItem());
    }

    public int getLayoutId() {
        return b0.f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        setSelect(((Integer) view.getTag()).intValue());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), getLayoutId(), this);
    }

    public void setSelect(int i2) throws Resources.NotFoundException {
        View view = this.f;
        if (view != null) {
            view.setSelected(false);
        }
        View childAt = this.g.getChildAt(i2);
        childAt.setSelected(true);
        this.f = childAt;
        this.d.get(i2).d2();
        this.c.setCurrentItem(i2, true);
    }

    public FragmentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = null;
    }

    public FragmentViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = null;
    }
}

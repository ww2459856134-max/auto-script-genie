package com.yl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class TabLinearLayout extends LinearLayout implements View.OnClickListener {
    private View.OnClickListener c;
    private View d;

    public TabLinearLayout(Context context) {
        super(context);
    }

    private void a(View view, boolean z) {
        View.OnClickListener onClickListener;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setSelected(false);
        }
        view.setSelected(true);
        this.d = view;
        if (!z || (onClickListener = this.c) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void b(int i2) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById != null) {
            a(viewFindViewById, true);
        }
    }

    public View getSelectedTabView() {
        return this.d;
    }

    public int getSelectedTabViewId() {
        return this.d.getId();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(view, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setOnClickListener(this);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setEnabled(z);
        }
    }

    public void setTabClickListener(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public TabLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TabLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

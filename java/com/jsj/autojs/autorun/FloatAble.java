package com.jsj.autojs.autorun;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class FloatAble extends ViewGroup {
    protected WindowManager c;
    protected WindowManager.LayoutParams d;

    public FloatAble(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public FloatAble(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatAble(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

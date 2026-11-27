package com.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.frame.v0;
import i.a.k;
import j.a.c;

/* loaded from: classes.dex */
public class AdParamsLinearLayout extends LinearLayout {
    private String c;
    private String d;

    public AdParamsLinearLayout(Context context) {
        super(context);
    }

    public void a() {
        ImageView imageView = null;
        TextView textView = null;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else if (childAt instanceof ImageView) {
                imageView = (ImageView) childAt;
            }
        }
        new k().c(this.d, this, imageView, textView, v0.g().d(), this.c);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public AdParamsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, c.a, 0, 0);
        this.c = typedArrayObtainStyledAttributes.getString(c.b);
        this.d = typedArrayObtainStyledAttributes.getString(c.c);
        typedArrayObtainStyledAttributes.recycle();
    }

    public AdParamsLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

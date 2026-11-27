package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {
    private int c;
    private int d;

    public FlowLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i7 = paddingLeft;
        int iMax = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                iMax = Math.max(measuredHeight, iMax);
                if (i7 + measuredWidth + paddingRight > i6) {
                    paddingTop += this.c + iMax;
                    i7 = paddingLeft;
                    iMax = measuredHeight;
                }
                childAt.layout(i7, paddingTop, i7 + measuredWidth, measuredHeight + paddingTop);
                i7 += measuredWidth + this.d;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int iResolveSize = ViewGroup.resolveSize(0, i2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i4 = paddingLeft;
        int i5 = paddingTop;
        int iMax = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                iMax = Math.max(measuredHeight, iMax);
                if (i4 + measuredWidth + paddingRight > iResolveSize) {
                    i5 += this.c + iMax;
                    i4 = paddingLeft;
                    iMax = measuredHeight;
                }
                childAt.layout(i4, i5, i4 + measuredWidth, measuredHeight + i5);
                i4 += measuredWidth + this.d;
            }
        }
        setMeasuredDimension(iResolveSize, i5 + iMax);
    }

    public void setHorizontalSpacing(int i2) {
        this.d = i2;
    }

    public void setVerticalSpacing(int i2) {
        this.c = i2;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

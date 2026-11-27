package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    private boolean A(int i2, int i3) throws NoSuchFieldException {
        int iCombineMeasuredStates;
        int iZ;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == h.a.f.V) {
                    view = childAt;
                } else if (id == h.a.f.f1205l) {
                    view2 = childAt;
                } else {
                    if ((id != h.a.f.f1207n && id != h.a.f.p) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i2, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i2, 0);
            iZ = z(view2);
            measuredHeight = view2.getMeasuredHeight() - iZ;
            paddingTop += iZ;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iZ = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i2, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i5 = size - paddingTop;
        if (view2 != null) {
            int i6 = paddingTop - iZ;
            int iMin = Math.min(i5, measuredHeight);
            if (iMin > 0) {
                i5 -= iMin;
                iZ += iMin;
            }
            view2.measure(i2, View.MeasureSpec.makeMeasureSpec(iZ, WXVideoFileObject.FILE_SIZE_LIMIT));
            paddingTop = i6 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i5 > 0) {
            view3.measure(i2, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i5, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i2, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i3, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        j(childCount, i3);
        return true;
    }

    private void j(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), WXVideoFileObject.FILE_SIZE_LIMIT);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i3, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i5;
                }
            }
        }
    }

    private void y(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private static int z(View view) throws NoSuchFieldException {
        int iX = h.e.j.s0.x(view);
        if (iX > 0) {
            return iX;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return z(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i10 = gravity & 112;
        int i11 = gravity & 8388615;
        int paddingTop = i10 != 16 ? i10 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - measuredHeight : getPaddingTop() + (((i5 - i3) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt.getLayoutParams();
                int i13 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i13 < 0) {
                    i13 = i11;
                }
                int iA = h.e.j.n.a(i13, h.e.j.s0.w(this)) & 7;
                if (iA == 1) {
                    i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i7 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                } else if (iA != 5) {
                    i8 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    if (r(i12)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i14 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    y(childAt, i8, i14, measuredWidth, measuredHeight2);
                    paddingTop = i14 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                } else {
                    i6 = paddingRight - measuredWidth;
                    i7 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i8 = i6 - i7;
                if (r(i12)) {
                }
                int i142 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                y(childAt, i8, i142, measuredWidth, measuredHeight2);
                paddingTop = i142 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (A(i2, i3)) {
            return;
        }
        super.onMeasure(i2, i3);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

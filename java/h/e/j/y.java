package h.e.j;

import android.view.View;

/* loaded from: classes.dex */
public interface y {
    boolean onNestedFling(View view, float f, float f2, boolean z);

    boolean onNestedPreFling(View view, float f, float f2);

    void onNestedPreScroll(View view, int i2, int i3, int[] iArr);

    void onNestedScroll(View view, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(View view, View view2, int i2);

    boolean onStartNestedScroll(View view, View view2, int i2);

    void onStopNestedScroll(View view);
}

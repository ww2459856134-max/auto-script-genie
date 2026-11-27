package h.e.j;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class v0 {
    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT < 21) {
            if (viewParent instanceof y) {
                return ((y) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f, float f2) {
        if (Build.VERSION.SDK_INT < 21) {
            if (viewParent instanceof y) {
                return ((y) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof w) {
            ((w) viewParent).j(view, i2, i3, iArr, i4);
            return;
        }
        if (i4 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof y) {
                    ((y) viewParent).onNestedPreScroll(view, i2, i3, iArr);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedPreScroll(view, i2, i3, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (viewParent instanceof x) {
            ((x) viewParent).l(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent instanceof w) {
            ((w) viewParent).h(view, i2, i3, i4, i5, i6);
            return;
        }
        if (i6 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof y) {
                    ((y) viewParent).onNestedScroll(view, i2, i3, i4, i5);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedScroll(view, i2, i3, i4, i5);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof w) {
            ((w) viewParent).f(view, view2, i2, i3);
            return;
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof y) {
                    ((y) viewParent).onNestedScrollAccepted(view, view2, i2);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedScrollAccepted(view, view2, i2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof w) {
            return ((w) viewParent).m(view, view2, i2, i3);
        }
        if (i3 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            if (viewParent instanceof y) {
                return ((y) viewParent).onStartNestedScroll(view, view2, i2);
            }
            return false;
        }
        try {
            return viewParent.onStartNestedScroll(view, view2, i2);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof w) {
            ((w) viewParent).g(view, i2);
            return;
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof y) {
                    ((y) viewParent).onStopNestedScroll(view);
                    return;
                }
                return;
            }
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
            }
        }
    }
}

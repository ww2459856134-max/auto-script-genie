package h.e.j.q1;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public class d {
    final Object a;

    d(Object obj) {
        this.a = obj;
    }

    public static d a(int i2, int i3, boolean z, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        return i5 >= 21 ? new d(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4)) : i5 >= 19 ? new d(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z)) : new d(null);
    }
}

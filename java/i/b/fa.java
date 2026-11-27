package i.b;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class fa {
    private boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo.getChildCount() < 3) {
            return false;
        }
        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(0);
        AccessibilityNodeInfo child2 = accessibilityNodeInfo.getChild(1);
        AccessibilityNodeInfo child3 = accessibilityNodeInfo.getChild(2);
        if (child != null && child2 != null && child3 != null) {
            int childCount = child.getChildCount();
            int childCount2 = child2.getChildCount();
            int childCount3 = child2.getChildCount();
            if (childCount != 0 && childCount == childCount2 && childCount == childCount3) {
                CharSequence className = child.getClassName();
                CharSequence className2 = child2.getClassName();
                CharSequence className3 = child3.getClassName();
                if (className.equals(className2) && className.equals(className3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Integer> a(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        ArrayList arrayList = new ArrayList();
        while (accessibilityNodeInfo != null && !accessibilityNodeInfo.equals(accessibilityNodeInfo2)) {
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            if (parent == null) {
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 < parent.getChildCount()) {
                    AccessibilityNodeInfo child = parent.getChild(i2);
                    if (child != null && child.equals(accessibilityNodeInfo)) {
                        arrayList.add(0, Integer.valueOf(i2));
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            accessibilityNodeInfo = parent;
        }
        return arrayList;
    }

    public AccessibilityNodeInfo c(AccessibilityNodeInfo accessibilityNodeInfo) {
        while (accessibilityNodeInfo != null) {
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
            if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() > 1 && b(accessibilityNodeInfo)) {
                return accessibilityNodeInfo;
            }
        }
        return null;
    }
}

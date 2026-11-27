package com.permission;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

/* loaded from: classes.dex */
final class k0 implements l0 {
    private ClickView a;

    private k0() {
    }

    @Override // com.permission.l0
    public void a() {
        ClickView clickView = this.a;
        if (clickView != null) {
            ClickView.d(clickView);
        }
        this.a = null;
    }

    @Override // com.permission.l0
    public boolean available() {
        return Build.VERSION.SDK_INT >= 16 && com.frame.w0.d();
    }

    @Override // com.permission.l0
    public AccessibilityNodeInfo b() {
        return com.frame.w0.b().getRootInActiveWindow();
    }

    @Override // com.permission.l0
    public void c() {
        Toast.makeText(com.frame.v0.g(), "请手动进入：应用详情 → 权限管理 → 自启动，开启本应用的自启动开关", 1).show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        r3.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r4.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r7 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    @Override // com.permission.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        if (!accessibilityNodeInfo.refresh() || !accessibilityNodeInfo.isVisibleToUser()) {
            throw new IllegalStateException("Autostart target is no longer visible");
        }
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (parent != null) {
            int i2 = 0;
            AccessibilityNodeInfo accessibilityNodeInfo3 = null;
            while (true) {
                try {
                    if (i2 >= parent.getChildCount()) {
                        accessibilityNodeInfo2 = accessibilityNodeInfo3;
                        break;
                    }
                    AccessibilityNodeInfo child = parent.getChild(i2);
                    if (child != null) {
                        if (!child.isVisibleToUser() || !child.isCheckable()) {
                            child.recycle();
                        } else if (accessibilityNodeInfo3 != null) {
                            break;
                        } else {
                            accessibilityNodeInfo3 = child;
                        }
                    }
                    i2++;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    accessibilityNodeInfo2 = accessibilityNodeInfo3;
                    if (parent != null) {
                        parent.recycle();
                    }
                    if (accessibilityNodeInfo2 != null) {
                        accessibilityNodeInfo2.recycle();
                    }
                    throw th2;
                }
            }
        }
        ClickView clickView = ClickView.getInstance();
        this.a = clickView;
        if (accessibilityNodeInfo2 != null) {
            accessibilityNodeInfo = accessibilityNodeInfo2;
        }
        clickView.a(accessibilityNodeInfo, "点击开启自启动");
        if (parent != null) {
            parent.recycle();
        }
        if (accessibilityNodeInfo2 != null) {
            accessibilityNodeInfo2.recycle();
        }
    }

    @Override // com.permission.l0
    public boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo.refresh() && accessibilityNodeInfo.isVisibleToUser() && "权限管理".contentEquals(accessibilityNodeInfo.getText())) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            int i2 = 0;
            while (i2 < 4 && accessibilityNodeInfoObtain != null) {
                try {
                    if (accessibilityNodeInfoObtain.isClickable()) {
                        return accessibilityNodeInfoObtain.performAction(16);
                    }
                    AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
                    accessibilityNodeInfoObtain.recycle();
                    i2++;
                    accessibilityNodeInfoObtain = parent;
                } finally {
                    if (accessibilityNodeInfoObtain != null) {
                        accessibilityNodeInfoObtain.recycle();
                    }
                }
            }
            if (accessibilityNodeInfoObtain != null) {
                accessibilityNodeInfoObtain.recycle();
            }
        }
        return false;
    }

    @Override // com.permission.l0
    public boolean f(String str) {
        ActivityInfo activityInfo;
        if (str.equals(com.frame.v0.g().getPackageName())) {
            return false;
        }
        try {
            if ((com.frame.v0.g().getPackageManager().getApplicationInfo(str, 0).flags & 129) == 0) {
                return false;
            }
            ResolveInfo resolveInfoResolveActivity = com.frame.v0.g().getPackageManager().resolveActivity(new Intent("android.settings.SETTINGS"), 0);
            if (!"com.android.settings".equals(str) && ((resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || !str.equals(activityInfo.packageName)) && !str.endsWith(".permissioncontroller"))) {
                if (!str.startsWith("com.oplus.") && !str.startsWith("com.coloros.")) {
                    return false;
                }
                if (!str.contains("permission")) {
                    if (!str.contains("safecenter")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

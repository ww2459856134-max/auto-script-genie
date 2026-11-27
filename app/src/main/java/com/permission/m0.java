package com.permission;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.l1;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f832h = {"允许自启动", "自启动", "自动启动"};
    private final l0 a;
    private final Handler b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private long g;

    public m0() {
        this(new k0());
    }

    private static AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo, String[] strArr, int[] iArr, int i2) {
        if (accessibilityNodeInfo != null && i2 <= 40) {
            int i3 = iArr[0];
            iArr[0] = i3 - 1;
            if (i3 > 0) {
                if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.getText() != null) {
                    String strTrim = accessibilityNodeInfo.getText().toString().trim();
                    for (String str : strArr) {
                        if (str.equals(strTrim)) {
                            return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                        }
                    }
                }
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    if (child != null) {
                        try {
                            AccessibilityNodeInfo accessibilityNodeInfoB = b(child, strArr, iArr, i2 + 1);
                            if (accessibilityNodeInfoB != null) {
                                return accessibilityNodeInfoB;
                            }
                        } finally {
                            child.recycle();
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean c(String str, String str2) {
        return "oneplus".equalsIgnoreCase(str) || "oneplus".equalsIgnoreCase(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(final int i2, int i3, boolean z, String str, AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
        try {
            try {
                if (this.e && i2 == this.c && this.d == i3) {
                    boolean z3 = true;
                    if (SystemClock.uptimeMillis() >= this.g) {
                        if (this.d == 2) {
                            z3 = false;
                        }
                        a();
                        if (z3) {
                            this.a.c();
                        }
                        if (accessibilityNodeInfo != null) {
                            accessibilityNodeInfo.recycle();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        this.f = true;
                    } else if (this.f && str != null) {
                        a();
                        if (accessibilityNodeInfo != null) {
                            accessibilityNodeInfo.recycle();
                            return;
                        }
                        return;
                    }
                    if (accessibilityNodeInfo != null) {
                        if (z2) {
                            this.a.d(accessibilityNodeInfo);
                            this.d = 2;
                            this.g = SystemClock.uptimeMillis() + 10000;
                        } else {
                            if (!this.a.e(accessibilityNodeInfo)) {
                                a();
                                this.a.c();
                                if (accessibilityNodeInfo != null) {
                                    accessibilityNodeInfo.recycle();
                                    return;
                                }
                                return;
                            }
                            this.d = 1;
                            this.g = SystemClock.uptimeMillis() + 5000;
                        }
                    }
                    if (accessibilityNodeInfo != null) {
                        accessibilityNodeInfo.recycle();
                    }
                    this.b.postDelayed(new Runnable() { // from class: com.permission.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.e(i2);
                        }
                    }, 200L);
                    return;
                }
                if (accessibilityNodeInfo != null) {
                    accessibilityNodeInfo.recycle();
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
                a();
                this.a.c();
                if (accessibilityNodeInfo != null) {
                    accessibilityNodeInfo.recycle();
                }
            }
        } catch (Throwable th) {
            if (accessibilityNodeInfo != null) {
                accessibilityNodeInfo.recycle();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void i(final int i2, final int i3) throws Throwable {
        Exception exc;
        AccessibilityNodeInfo accessibilityNodeInfo;
        String string;
        final boolean z;
        final AccessibilityNodeInfo accessibilityNodeInfo2;
        AccessibilityNodeInfo accessibilityNodeInfoB = null;
        boolean z2 = false;
        try {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoB2 = this.a.b();
                if (accessibilityNodeInfoB2 != null) {
                    try {
                        try {
                            if (accessibilityNodeInfoB2.getPackageName() != null) {
                                string = accessibilityNodeInfoB2.getPackageName().toString();
                                try {
                                    boolean zF = this.a.f(string);
                                    if (!zF || i2 == 2) {
                                        z = false;
                                    } else {
                                        try {
                                            accessibilityNodeInfoB = b(accessibilityNodeInfoB2, f832h, new int[]{600}, 0);
                                            z = accessibilityNodeInfoB != null;
                                            if (accessibilityNodeInfoB == null && i2 == 0) {
                                                try {
                                                    accessibilityNodeInfoB = b(accessibilityNodeInfoB2, new String[]{"权限管理"}, new int[]{600}, 0);
                                                } catch (Exception e) {
                                                    e = e;
                                                    z2 = zF;
                                                    exc = e;
                                                    accessibilityNodeInfo = accessibilityNodeInfoB;
                                                    accessibilityNodeInfoB = accessibilityNodeInfoB2;
                                                    com.frame.k0.r(exc);
                                                    if (accessibilityNodeInfoB != null) {
                                                        accessibilityNodeInfoB.recycle();
                                                    }
                                                    accessibilityNodeInfo2 = accessibilityNodeInfo;
                                                    final String str = string;
                                                    final boolean z3 = z2;
                                                    this.b.post(new Runnable() { // from class: com.permission.o
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            this.c.g(i3, i2, z3, str, accessibilityNodeInfo2, z);
                                                        }
                                                    });
                                                }
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            z = false;
                                        }
                                    }
                                    z2 = zF;
                                } catch (Exception e3) {
                                    e = e3;
                                    z = false;
                                }
                            } else {
                                string = null;
                                z = false;
                            }
                            if (accessibilityNodeInfoB2 != null) {
                                accessibilityNodeInfoB2.recycle();
                            }
                            accessibilityNodeInfo2 = accessibilityNodeInfoB;
                        } catch (Exception e4) {
                            string = null;
                            z = false;
                            accessibilityNodeInfoB = accessibilityNodeInfoB2;
                            exc = e4;
                            accessibilityNodeInfo = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfoB = accessibilityNodeInfoB2;
                        if (accessibilityNodeInfoB != null) {
                            accessibilityNodeInfoB.recycle();
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                exc = e5;
                accessibilityNodeInfo = null;
                string = null;
                z = false;
            }
            final String str2 = string;
            final boolean z32 = z2;
            this.b.post(new Runnable() { // from class: com.permission.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.g(i3, i2, z32, str2, accessibilityNodeInfo2, z);
                }
            });
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void e(final int i2) {
        if (this.e && i2 == this.c) {
            if (SystemClock.uptimeMillis() >= this.g) {
                boolean z = this.d != 2;
                a();
                if (z) {
                    this.a.c();
                    return;
                }
                return;
            }
            if (this.a.available()) {
                final int i3 = this.d;
                l1.g(new Runnable() { // from class: com.permission.p
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.c.i(i3, i2);
                    }
                });
            } else {
                a();
                this.a.c();
            }
        }
    }

    public void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.b.post(new Runnable() { // from class: com.permission.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.a();
                }
            });
            return;
        }
        this.c++;
        this.e = false;
        this.a.a();
    }

    public void k() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.b.post(new Runnable() { // from class: com.permission.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.k();
                }
            });
            return;
        }
        a();
        if (!this.a.available()) {
            this.a.c();
            return;
        }
        this.e = true;
        this.f = false;
        this.d = 0;
        this.g = SystemClock.uptimeMillis() + 5000;
        d(this.c);
    }

    m0(l0 l0Var) {
        this.b = new Handler(Looper.getMainLooper());
        this.a = l0Var;
    }
}

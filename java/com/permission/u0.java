package com.permission;

import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;
import com.frame.l1;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class u0 {
    private static u0 c;
    private final m0 a = new m0();
    public boolean b;

    private u0() {
    }

    private boolean f(final boolean z, final String str, String... strArr) {
        com.frame.g0.v().p(null, com.frame.g0.v().a(Integer.MAX_VALUE, strArr), new g0.a() { // from class: com.permission.z
            @Override // com.frame.g0.a
            public final void a(AccessibilityNodeInfo accessibilityNodeInfo) {
                u0.l(z, str, accessibilityNodeInfo);
            }
        });
        return true;
    }

    public static u0 g() {
        u0 u0Var = c;
        if (u0Var != null) {
            return u0Var;
        }
        u0 u0Var2 = new u0();
        c = u0Var2;
        return u0Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(String str, AtomicReference atomicReference, g0.c cVar) {
        try {
            com.frame.g0.v().M(null, null, str, 5000L, 200L, false, atomicReference, new p0(this, atomicReference, cVar));
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void l(boolean z, final String str, AccessibilityNodeInfo accessibilityNodeInfo) {
        final AccessibilityNodeInfo accessibilityNodeInfoF = com.frame.g0.v().f(accessibilityNodeInfo, 3);
        if (accessibilityNodeInfoF == null) {
            return;
        }
        if (z) {
            accessibilityNodeInfoF.performAction(16);
        } else {
            l1.e(new Runnable() { // from class: com.permission.y
                @Override // java.lang.Runnable
                public final void run() {
                    ClickView.getInstance().b(accessibilityNodeInfoF, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(String str) {
        try {
            f(false, "请点击开启壁纸守护", str.split(","));
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void b() {
        c(a1.g().h() instanceof i0 ? "设置壁纸" : a1.g().h() instanceof g0 ? "应用" : "应用,设为,设置壁纸", new o0(this));
    }

    public void c(String str, final g0.c cVar) {
        final AtomicReference atomicReference = new AtomicReference(Boolean.TRUE);
        for (final String str2 : str.split(",")) {
            l1.g(new Runnable() { // from class: com.permission.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.j(str2, atomicReference, cVar);
                }
            });
        }
    }

    public void d(String str) {
        x0.m().s(new t0(this, str));
    }

    public void e() {
        this.a.a();
    }

    public boolean h() {
        return x0.m().l() != null;
    }

    public void o(boolean z) {
        this.b = z;
    }

    public void p() {
        final String str = a1.g().h() instanceof g0 ? "应用" : "应用,设为,设置壁纸";
        l1.g(new Runnable() { // from class: com.permission.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.n(str);
            }
        });
    }
}

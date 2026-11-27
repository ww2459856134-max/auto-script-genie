package com.permission;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.frame.g0;
import com.frame.l1;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.TipFloatView;
import java.io.IOException;
import wallpaper.WallpaperSetting;

/* loaded from: classes.dex */
class t0 implements w0 {
    final /* synthetic */ String a;
    final /* synthetic */ u0 b;

    t0(u0 u0Var, String str) {
        this.b = u0Var;
        this.a = str;
    }

    static /* synthetic */ void k(AccessibilityNodeInfo accessibilityNodeInfo) throws InterruptedException {
        try {
            AccessibilityNodeInfo accessibilityNodeInfoF = com.frame.g0.v().f(accessibilityNodeInfo, 3);
            com.frame.y0.o("触发点击：是否可点击：" + accessibilityNodeInfoF);
            accessibilityNodeInfoF.performAction(16);
            Thread.sleep(500L);
            ClickView.getInstance().o("com.huawei.systemmanager", com.frame.v0.g().getString(j.e.e.a), "点击改成手动", new View.OnClickListener() { // from class: com.permission.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalStateException, IOException, IllegalArgumentException {
                    com.frame.k0.c().p("huawei_3click.mp4");
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        this.b.b();
    }

    static /* synthetic */ void p(View view) {
        WallpaperSetting.A();
        com.frame.s0.g().d(TipFloatView.class);
    }

    static /* synthetic */ void q(View view) {
        DingMsgView dingMsgView = new DingMsgView();
        dingMsgView.h("壁纸守护将跟随桌面壁纸");
        dingMsgView.l("壁纸守护");
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.permission.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                t0.p(view2);
            }
        });
        dingMsgView.i("取消", null);
        dingMsgView.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s() {
        if (com.frame.w0.d() && Build.VERSION.SDK_INT >= 16) {
            if (this.b.b) {
                l1.g(new Runnable() { // from class: com.permission.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.n();
                    }
                });
            } else {
                l1.f(new Runnable() { // from class: com.permission.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        u0.g().p();
                    }
                }, 500L);
            }
        }
        try {
            TipFloatView.c(com.frame.v0.g().getResources().getDrawable(j.e.b.a), "使用桌面壁纸", "点击跟随桌面壁纸", new View.OnClickListener() { // from class: com.permission.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t0.q(view);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    @Override // com.permission.w0
    public void a() {
        this.b.e();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16 || !com.frame.w0.d()) {
            ToastAct.V(j.e.d.d);
        } else if (i2 < 33 || !(a1.g().h() instanceof i0)) {
            ClickView.getInstance().n("动态壁纸", "点击允许动态壁纸权限");
        } else {
            this.b.c("其他权限", new q0(this));
        }
    }

    @Override // com.permission.w0
    public void b() {
        this.b.e();
        com.frame.s0.g().e();
        if (TextUtils.isEmpty(this.a) || !i(this.a)) {
            ToastAct.V(j.e.d.a);
        } else {
            ToastAct.X(this.a, "accessibility");
        }
    }

    @Override // com.permission.w0
    public void c() {
        this.b.e();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16 || !com.frame.w0.d()) {
            ToastAct.V(j.e.d.c);
        } else if (i2 < 33 || !(a1.g().h() instanceof i0)) {
            ClickView.getInstance().n("后台", "点击允许后台弹出界面");
        } else {
            this.b.c("其他权限", new r0(this));
        }
    }

    @Override // com.permission.w0
    public void d() {
        this.b.e();
        if (a1.g().h() instanceof n0) {
            float fG = a1.g().h().g();
            if (fG <= 2.0f && fG != -1.0f && Build.VERSION.SDK_INT < 28) {
                ToastAct.V(j.e.d.f);
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16 || !com.frame.w0.d()) {
            if (a1.g().h() instanceof i0) {
                ToastAct.V(j.e.d.e);
                return;
            } else if (a1.g().h() instanceof n0) {
                ToastAct.W(j.e.d.g, 800L);
                return;
            } else {
                ToastAct.V(j.e.d.g);
                return;
            }
        }
        if (a1.g().h() instanceof g0) {
            ClickView.getInstance().n("应用上层显示", "点击开启悬浮窗权限");
            return;
        }
        if (!(a1.g().h() instanceof i0)) {
            ClickView.getInstance().n(com.frame.v0.g().getString(j.e.e.a), "点击开启悬浮窗权限");
        } else if (i2 >= 33) {
            this.b.c("其他权限", new s0(this));
        } else {
            ClickView.getInstance().n("悬浮", "点击开启悬浮窗权限");
        }
    }

    @Override // com.permission.w0
    public void e() {
        this.b.e();
        if (Build.VERSION.SDK_INT < 16 || !com.frame.w0.d()) {
            return;
        }
        if ((a1.g().h() instanceof i0) || ((a1.g().h() instanceof g0) && a1.g().l())) {
            ClickView.getInstance().n(com.frame.v0.g().getString(j.e.e.a), "点击开启权限");
        }
    }

    @Override // com.permission.w0
    public void f() {
        if (m0.c(Build.BRAND, Build.MANUFACTURER)) {
            ClickView.c();
            this.b.a.k();
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16 || !com.frame.w0.d()) {
            if (a1.g().h() instanceof g0) {
                ToastAct.V(j.e.d.b);
                return;
            } else {
                ToastAct.V(j.e.d.g);
                return;
            }
        }
        if ((a1.g().h() instanceof n0) && i2 >= 30) {
            ClickView.getInstance().n("耗电", "点击允许后台运行");
            return;
        }
        if (a1.g().h() instanceof i0) {
            ClickView.getInstance().n("自启动", "点击开启自启动");
            return;
        }
        if (!(a1.g().h() instanceof g0) || !a1.g().l()) {
            ClickView.getInstance().n(com.frame.v0.g().getString(j.e.e.a), a1.g().h() instanceof g0 ? "点击改成手动" : "点击允许后台运行");
        } else if (i2 >= 21) {
            l1.g(new Runnable() { // from class: com.permission.q
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.g0.v().p("com.huawei.systemmanager", com.frame.g0.v().b("应用启动管理"), new g0.a() { // from class: com.permission.v
                        @Override // com.frame.g0.a
                        public final void a(AccessibilityNodeInfo accessibilityNodeInfo) throws InterruptedException {
                            t0.k(accessibilityNodeInfo);
                        }
                    });
                }
            });
        }
    }

    @Override // com.permission.w0
    public void g() {
        this.b.e();
        WallpaperSetting.w(new Runnable() { // from class: com.permission.x
            @Override // java.lang.Runnable
            public final void run() {
                this.c.s();
            }
        });
    }

    @Override // com.permission.w0
    public void h() {
        this.b.e();
        if (Build.VERSION.SDK_INT >= 16 && com.frame.w0.d() && (a1.g().h() instanceof i0)) {
            ClickView.getInstance().n("无限制", "点击无限制");
        }
    }

    public boolean i(String str) throws IOException {
        try {
            for (String str2 : com.frame.v0.g().getAssets().list("")) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } catch (IOException e) {
            com.frame.k0.r(e);
        }
        return false;
    }
}

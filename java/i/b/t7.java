package i.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.a.WallpaperSelectAct;
import com.act.WebAct;
import com.airbnb.lottie.LottieAnimationView;
import com.permission.ClickView;
import com.s.BoxService;
import com.tencent.open.SocialConstants;
import com.v.AlarmTaskDialogView;
import com.v.NodeListDialogView;
import com.v.TaskChooseDialogView;
import com.yl.ui.s;
import i.h.f;
import java.io.IOException;
import wallpaper.WallpaperSetting;

/* loaded from: classes.dex */
public class t7 {
    public static int d = 30;
    private boolean a = false;
    private Runnable b;
    private Dialog c;

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(boolean z) {
        com.frame.n0.g("voiceToggle", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(DialogInterface dialogInterface, int i2) {
        com.frame.k0.i("wallpaper_alert_close");
        B0(false);
        Toast.makeText(com.frame.v0.g(), "已放弃稳定性，可在设置页面重新开启", 0).show();
        d();
    }

    private void B0(boolean z) {
        com.frame.n0.g("wallToggle", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(View view) {
        try {
            Dialog dialog = this.c;
            if (dialog != null) {
                dialog.cancel();
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        try {
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.g(j.b.d.q0);
            aVar.j("【壁纸守护】可使禅定不被中断，更加稳定，你确定放弃稳定性吗？");
            aVar.r("再看看", new DialogInterface.OnClickListener() { // from class: i.b.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.A(dialogInterface, i2);
                }
            });
            aVar.m("放弃稳定性", new DialogInterface.OnClickListener() { // from class: i.b.y
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.C(dialogInterface, i2);
                }
            });
            aVar.e().show();
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        try {
            if (!com.frame.n0.a("already_accessibility_permission", false)) {
                s.a aVar = new s.a(com.frame.v0.g().d());
                aVar.u(null);
                aVar.m("询问客服", new DialogInterface.OnClickListener() { // from class: i.b.b1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.R(dialogInterface, i2);
                    }
                });
                aVar.q(j.b.g.f1767j, new DialogInterface.OnClickListener() { // from class: i.b.h0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        t7.S(dialogInterface, i2);
                    }
                });
                aVar.s(j.b.g.b);
                aVar.j(String.format("未启动成功，如果找不到，可在无障碍设置中进入<strong><font color='#F45075'>已下载的服务</font></strong>或<strong><font color='#F45075'>已安装的服务</font></strong>中点击<strong><font color='#F45075'>%s</font></strong>开启服务。无障碍服务仅用于自动操作的相关功能，如：模拟点击、控件识别、模拟手势等，APP中有隐私政策可以在关于页面中查阅。", com.frame.v0.g().getString(j.b.g.c)));
                aVar.e().show();
            } else if (m("accessibility.json")) {
                View viewInflate = LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.a, (ViewGroup) null);
                final LottieAnimationView lottieAnimationView = (LottieAnimationView) viewInflate.findViewById(j.b.e.a);
                lottieAnimationView.setFailureListener(new com.airbnb.lottie.g0() { // from class: i.b.u
                    @Override // com.airbnb.lottie.g0
                    public final void a(Object obj) {
                        lottieAnimationView.setVisibility(8);
                    }
                });
                if (!(com.permission.a1.g().h() instanceof com.permission.i0)) {
                    lottieAnimationView.setMinProgress(0.25f);
                    lottieAnimationView.setMaxProgress(1.0f);
                }
                ImageView imageView = (ImageView) viewInflate.findViewById(j.b.e.G3);
                ImageView imageView2 = (ImageView) viewInflate.findViewById(j.b.e.C3);
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                imageView2.setImageResource(j.b.d.F0);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: i.b.e0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        t7.U(view);
                    }
                });
                if (!(com.permission.a1.g().h() instanceof com.permission.i0)) {
                    lottieAnimationView.setMinProgress(0.175f);
                    lottieAnimationView.setMaxProgress(1.0f);
                }
                TextView textView = (TextView) viewInflate.findViewById(j.b.e.o6);
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setPadding(com.frame.p1.c(25.0f), 0, 0, com.frame.p1.c(10.0f));
                textView.setTextSize(12.0f);
                textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
                textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.J0, 0, 0, 0);
                textView.setText("强制停止应用，重新设置权限");
                textView.setOnClickListener(new View.OnClickListener() { // from class: i.b.t0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.permission.x0.m().i();
                    }
                });
                ((LinearLayout) textView.getParent()).setGravity(3);
                com.frame.k0.i("accessibility_open_failed");
                s.a aVar2 = new s.a(com.frame.v0.g().d());
                aVar2.u(viewInflate);
                aVar2.m("询问客服", new DialogInterface.OnClickListener() { // from class: i.b.j0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.X(dialogInterface, i2);
                    }
                });
                aVar2.q(j.b.g.f1767j, new DialogInterface.OnClickListener() { // from class: i.b.w
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        t7.Y(dialogInterface, i2);
                    }
                });
                aVar2.s(j.b.g.b);
                aVar2.j("【无障碍】未成功开启！，可以权限关闭后再开启，如果连续多次失败，可以<big><strong><font color='#F45075'>重启手机</font></strong></big>解决问题！！！如果有提示<strong><font color='#F45075'>权限受限</font></strong>是由于高版本安卓系统需要去手机自带的应用市场下载版本才行。");
                aVar2.e().show();
            } else {
                View viewInflate2 = LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.h1, (ViewGroup) null);
                com.permission.z0 z0VarH = com.permission.a1.g().h();
                if (!(z0VarH instanceof com.permission.g0) && !(z0VarH instanceof com.permission.i0)) {
                    viewInflate2.findViewById(j.b.e.b6).setVisibility(8);
                    viewInflate2.findViewById(j.b.e.s4).setVisibility(8);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.rightMargin = com.frame.p1.c(20.0f);
                layoutParams.leftMargin = com.frame.p1.c(20.0f);
                com.frame.k0.i("accessibility_open_failed");
                s.a aVar3 = new s.a(com.frame.v0.g().d());
                aVar3.v(viewInflate2, layoutParams);
                aVar3.m("询问客服", new DialogInterface.OnClickListener() { // from class: i.b.v
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.a0(dialogInterface, i2);
                    }
                });
                aVar3.q(j.b.g.f1767j, new DialogInterface.OnClickListener() { // from class: i.b.n0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        t7.b0(dialogInterface, i2);
                    }
                });
                aVar3.s(j.b.g.b);
                aVar3.j("【无障碍】未成功开启！，连续多次失败，可以<big><strong><font color='#F45075'>重启手机</font></strong></big>解决问题！！！");
                aVar3.e().show();
            }
            if (!com.frame.n0.a("already_accessibility_permission", false) || com.frame.n0.f("mp3Play", "1").equals("2")) {
                return;
            }
            da.B().B1("noacc.mp3");
            com.frame.n0.k("mp3Play", "1");
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(View view) {
        k();
    }

    private void G0() {
        try {
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.l(j.b.g.e, null);
            aVar.q(j.b.g.f1765h, new DialogInterface.OnClickListener() { // from class: i.b.k0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.p0(dialogInterface, i2);
                }
            });
            aVar.s(j.b.g.b);
            aVar.g(j.b.d.y);
            aVar.i(j.b.g.d);
            aVar.e().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I() {
        SystemClock.sleep(1000L);
        for (int i2 = 0; i2 < 60; i2++) {
            SystemClock.sleep(600L);
            if (com.permission.x0.m().n()) {
                try {
                    Intent intentC = com.frame.v0.g().d() == null ? com.frame.i0.c(com.frame.v0.g().getPackageName()) : new Intent(com.frame.v0.g(), com.frame.v0.g().d().getClass());
                    intentC.setFlags(67108864);
                    com.frame.v0.g().startActivity(intentC);
                } catch (PackageManager.NameNotFoundException e) {
                    com.frame.k0.r(e);
                }
                com.frame.l1.f(new x6(this), 500L);
                return;
            }
        }
    }

    private void H0() {
        try {
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.g(j.b.d.q0);
            aVar.r("已经开启", new DialogInterface.OnClickListener() { // from class: i.b.d0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.r0(dialogInterface, i2);
                }
            });
            aVar.l(j.b.g.f1767j, new DialogInterface.OnClickListener() { // from class: i.b.c0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    t7.s0(dialogInterface, i2);
                }
            });
            aVar.s(j.b.g.b);
            aVar.j("是否确定已经开启来后台弹出权限？");
            aVar.e().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void J() {
        try {
            com.frame.w0.b().performGlobalAction(1);
            com.frame.w0.b().performGlobalAction(1);
            for (int i2 = 0; i2 < 10; i2++) {
                SystemClock.sleep(400L);
                if (com.frame.v0.g().k()) {
                    return;
                }
                com.frame.w0.b().performGlobalAction(1);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(ImageView imageView, TextView textView, View view) {
        boolean z = !o();
        imageView.setImageResource(z ? j.b.d.E0 : j.b.d.f1747n);
        textView.setText(z ? "点击这里可以关闭语言指导" : "点击这里可以开启语言指导");
        A0(z);
        com.frame.k0.i("voice_toggle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(DialogInterface dialogInterface, int i2) {
        k();
    }

    static /* synthetic */ void S(DialogInterface dialogInterface, int i2) {
        com.frame.k0.i("accessibility_alert_click_again");
        com.permission.x0.m().a();
    }

    static /* synthetic */ void U(View view) {
        if (!com.user.w.h().k(com.frame.v0.g())) {
            Toast.makeText(com.frame.v0.g(), "您未安装微信，可发邮件至chenai@skyingidea.com", 0).show();
            return;
        }
        Toast.makeText(com.frame.v0.g(), "如无法跳转微信客服，可邮件至chenai@skyingidea.com", 0).show();
        Intent intent = new Intent(com.frame.v0.g().d(), (Class<?>) WebAct.class);
        intent.addFlags(268435456);
        intent.putExtra(SocialConstants.PARAM_URL, "https://work.weixin.qq.com/kfid/kfcf58e5e221dd87445");
        intent.putExtra("title", "客服");
        com.frame.v0.g().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i2) {
        k();
    }

    static /* synthetic */ void Y(DialogInterface dialogInterface, int i2) {
        com.frame.k0.i("accessibility_alert_click_again");
        com.permission.x0.m().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i2) {
        k();
    }

    static /* synthetic */ void b0(DialogInterface dialogInterface, int i2) {
        com.frame.k0.i("accessibility_alert_click_again");
        com.permission.x0.m().a();
    }

    static /* synthetic */ void d0(DialogInterface dialogInterface, int i2) {
    }

    static /* synthetic */ void e0(DialogInterface dialogInterface, int i2) {
        if (WallpaperSetting.q()) {
            dialogInterface.cancel();
        }
    }

    static /* synthetic */ void f0(DialogInterface dialogInterface, int i2) {
        com.frame.k0.i("wallpaper_alert_ok");
        com.frame.v0.g().startActivity(new Intent(com.frame.v0.g(), (Class<?>) WallpaperSelectAct.class));
    }

    private boolean h() {
        if (WallpaperSetting.q()) {
            return true;
        }
        E0(true);
        return false;
    }

    static /* synthetic */ void h0(DialogInterface dialogInterface, int i2) {
        if (WallpaperSetting.q()) {
            dialogInterface.cancel();
        }
    }

    private View i() {
        TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setText("不再提示壁纸守护，放弃稳定性");
        textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(8.0f), 0, com.frame.p1.c(10.0f));
        textView.setTextSize(12.0f);
        textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.J0, 0, 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: i.b.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.E(view);
            }
        });
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0(DialogInterface dialogInterface, int i2) {
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        } else {
            Log.e("ding", "checkAndStart: mStartListener不能为空");
        }
    }

    private View j(String str) {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y, null);
        int iC = com.frame.p1.c(20.0f);
        viewInflate.setPadding(iC, 0, iC, iC);
        ((ImageView) viewInflate.findViewById(j.b.e.I3)).setImageResource(j.b.d.F0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: i.b.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.G(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i2) {
        c();
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= d ? Environment.isExternalStorageManager() : androidx.core.content.a.a(com.frame.v0.g(), "android.permission.READ_EXTERNAL_STORAGE") == 0 && androidx.core.content.a.a(com.frame.v0.g(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(DialogInterface dialogInterface, int i2) {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        return com.frame.n0.a("voiceToggle", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(DialogInterface dialogInterface, int i2) {
        if (com.frame.w0.d()) {
            BoxService.m().x();
        }
        com.permission.x0.m().c();
        this.a = true;
        w0();
    }

    private boolean p() {
        return com.frame.n0.a("wallToggle", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(DialogInterface dialogInterface, int i2) {
        if (Build.VERSION.SDK_INT < 20 || !n() || com.permission.x0.m().n()) {
            d();
            return;
        }
        com.frame.k0.i("backgroundStart_open_failed");
        s.a aVar = new s.a(com.frame.v0.g().d());
        aVar.g(j.b.d.q0);
        aVar.u(j("background_video"));
        aVar.l(j.b.g.f1766i, new DialogInterface.OnClickListener() { // from class: i.b.a0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i3) {
                this.c.u0(dialogInterface2, i3);
            }
        });
        aVar.q(j.b.g.f1767j, new DialogInterface.OnClickListener() { // from class: i.b.p0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i3) {
                t7.v0(dialogInterface2, i3);
            }
        });
        aVar.s(j.b.g.b);
        aVar.j("后台弹出权限未成功开启！出现了什么问题吗？可点击下方查看<big><strong><font color='#F45075'>视频教程</font></strong></big>，或者点击建议反馈，<big><strong><font color='#F45075'>加群</font></strong></big>暴打开发者。");
        aVar.e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s() {
        ClickView.c();
        I0();
    }

    static /* synthetic */ void s0(DialogInterface dialogInterface, int i2) {
        if (com.frame.w0.d()) {
            BoxService.m().x();
        }
        com.permission.x0.m().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        I0();
        ClickView.c();
        WallpaperSetting.x(null);
        WallpaperSetting.v(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(DialogInterface dialogInterface, int i2) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(DialogInterface dialogInterface, int i2) {
        c();
    }

    static /* synthetic */ void v0(DialogInterface dialogInterface, int i2) {
        if (com.frame.w0.d()) {
            BoxService.m().x();
        }
        com.permission.x0.m().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(DialogInterface dialogInterface, int i2) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(DialogInterface dialogInterface, int i2) {
        c();
    }

    public void C0() {
        com.frame.w0.j(new Runnable() { // from class: i.b.i
            @Override // java.lang.Runnable
            public final void run() {
                this.c.x0();
            }
        });
        s7 s7Var = new s7(this);
        boolean zO = o();
        if (!m("accessibility.json")) {
            View viewInflate = LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.h1, (ViewGroup) null);
            com.permission.z0 z0VarH = com.permission.a1.g().h();
            if (!(z0VarH instanceof com.permission.g0) && !(z0VarH instanceof com.permission.i0)) {
                viewInflate.findViewById(j.b.e.b6).setVisibility(8);
                viewInflate.findViewById(j.b.e.s4).setVisibility(8);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.rightMargin = com.frame.p1.c(20.0f);
            layoutParams.leftMargin = com.frame.p1.c(20.0f);
            try {
                s.a aVar = new s.a(com.frame.v0.g().d());
                aVar.q(j.b.g.f, s7Var);
                aVar.l(j.b.g.e, new DialogInterface.OnClickListener() { // from class: i.b.m0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        com.frame.k0.i("accessibility_alert_close");
                    }
                });
                aVar.v(viewInflate, layoutParams);
                aVar.i(j.b.g.a);
                aVar.e().show();
                return;
            } catch (Exception e) {
                com.frame.k0.r(e);
                return;
            }
        }
        View viewInflate2 = LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.a, (ViewGroup) null);
        final LottieAnimationView lottieAnimationView = (LottieAnimationView) viewInflate2.findViewById(j.b.e.a);
        lottieAnimationView.setFailureListener(new com.airbnb.lottie.g0() { // from class: i.b.y0
            @Override // com.airbnb.lottie.g0
            public final void a(Object obj) {
                lottieAnimationView.setVisibility(8);
            }
        });
        if (!(com.permission.a1.g().h() instanceof com.permission.i0)) {
            lottieAnimationView.setMinProgress(0.25f);
            lottieAnimationView.setMaxProgress(1.0f);
        }
        final ImageView imageView = (ImageView) viewInflate2.findViewById(j.b.e.G3);
        final TextView textView = (TextView) viewInflate2.findViewById(j.b.e.o6);
        imageView.setImageResource(zO ? j.b.d.E0 : j.b.d.f1747n);
        textView.setText(zO ? "点击这里可以关闭语言指导" : "点击这里可以开启语言指导");
        viewInflate2.setOnClickListener(new View.OnClickListener() { // from class: i.b.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.N(imageView, textView, view);
            }
        });
        try {
            s.a aVar2 = new s.a(com.frame.v0.g().d());
            aVar2.q(j.b.g.f, s7Var);
            aVar2.l(j.b.g.e, new DialogInterface.OnClickListener() { // from class: i.b.g0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.frame.k0.i("accessibility_alert_close");
                }
            });
            aVar2.u(viewInflate2);
            aVar2.i(j.b.g.a);
            aVar2.e().show();
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void E0(boolean z) {
        View viewI;
        Activity activityD = com.frame.v0.g().d();
        if (activityD == null) {
            return;
        }
        if (z) {
            try {
                viewI = i();
            } catch (Exception e) {
                com.frame.k0.r(e);
                return;
            }
        } else {
            viewI = null;
        }
        com.frame.k0.i("wallpaper_alert_show");
        String str = "为了在自动执行过程中后台<strong><font color='#55CA9B'>避免中断</font></strong>，可以开启<strong><font color='#55CA9B'>壁纸守护</font></strong>，使用<strong><font color='#55CA9B'>壁纸守护</font></strong>绑定桌面壁纸增强自动化工作流的稳定性防止后台被系统关闭。";
        if ((com.permission.a1.g().h() instanceof com.permission.i0) && Build.VERSION.SDK_INT >= 32) {
            str = "为了在自动执行过程中后台<strong><font color='#55CA9B'>避免中断</font></strong>，可以开启<strong><font color='#55CA9B'>壁纸守护</font></strong>，使用<strong><font color='#55CA9B'>壁纸守护</font></strong>绑定桌面壁纸增强自动化工作流的稳定性防止后台被系统关闭。<br/><br/><font color='#F45075'><strong>小米手机</strong></font>如果开启不了，请去桌面长按我们app图标进入<font color='#F45075'><strong>应用管理</strong></font>-<font color='#F45075'><strong>权限管理</strong></font>打开<font color='#F45075'><strong>动态壁纸服务</strong></font>后再试壁纸守护功能。";
            LinearLayout linearLayout = new LinearLayout(com.frame.v0.g());
            linearLayout.setOrientation(1);
            View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.p1, null);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: i.b.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.permission.x0.m().e();
                }
            });
            linearLayout.addView(viewInflate);
            if (viewI != null) {
                linearLayout.addView(viewI);
            }
            viewI = linearLayout;
        }
        s.a aVar = new s.a(activityD);
        aVar.f();
        aVar.u(viewI);
        aVar.m("取消", new DialogInterface.OnClickListener() { // from class: i.b.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                t7.d0(dialogInterface, i2);
            }
        });
        aVar.p(new DialogInterface.OnClickListener() { // from class: i.b.v0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                t7.e0(dialogInterface, i2);
            }
        });
        aVar.r("开启守护", new DialogInterface.OnClickListener() { // from class: i.b.u0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                t7.f0(dialogInterface, i2);
            }
        });
        aVar.j(str);
        aVar.t("温馨提示");
        com.yl.ui.s sVarE = aVar.e();
        if (sVarE != null) {
            sVarE.show();
        }
        this.c = sVarE;
    }

    public void F0() {
        try {
            Activity activityD = com.frame.v0.g().d();
            if (activityD != null && !activityD.isFinishing()) {
                View viewI = i();
                String str = "壁纸守护未成功开启！出现了什么问题吗？可进入交流群咨询。";
                if ((com.permission.a1.g().h() instanceof com.permission.i0) && Build.VERSION.SDK_INT >= 32) {
                    str = "壁纸守护未成功开启！出现了什么问题吗？可进入交流群咨询。<br/><br/><font color='#F45075'><strong>小米手机</strong></font>如果开启不了，请去桌面长按我们app图标进入<font color='#F45075'><strong>应用管理</strong></font>-<font color='#F45075'><strong>权限管理</strong></font>打开<font color='#F45075'><strong>动态壁纸服务</strong></font>后再试壁纸守护功能。";
                    LinearLayout linearLayout = new LinearLayout(com.frame.v0.g());
                    linearLayout.setOrientation(1);
                    View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.p1, null);
                    viewInflate.setOnClickListener(new View.OnClickListener() { // from class: i.b.z
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            com.permission.x0.m().e();
                        }
                    });
                    linearLayout.addView(viewInflate);
                    if (viewI != null) {
                        linearLayout.addView(viewI);
                    }
                    viewI = linearLayout;
                }
                s.a aVar = new s.a(com.frame.v0.g().d());
                aVar.g(j.b.d.q0);
                aVar.u(viewI);
                aVar.p(new DialogInterface.OnClickListener() { // from class: i.b.p
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        t7.h0(dialogInterface, i2);
                    }
                });
                aVar.m("直接使用", new DialogInterface.OnClickListener() { // from class: i.b.z0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.j0(dialogInterface, i2);
                    }
                });
                aVar.q(j.b.g.f1767j, new DialogInterface.OnClickListener() { // from class: i.b.r0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.l0(dialogInterface, i2);
                    }
                });
                aVar.s(j.b.g.b);
                aVar.k(str, new DialogInterface.OnClickListener() { // from class: i.b.x0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.n0(dialogInterface, i2);
                    }
                });
                com.yl.ui.s sVarE = aVar.e();
                sVarE.show();
                this.c = sVarE;
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.k0.r(e);
        }
    }

    public void I0() {
        try {
            Intent intentC = com.frame.v0.g().d() == null ? com.frame.i0.c(com.frame.v0.g().getPackageName()) : new Intent(com.frame.v0.g(), com.frame.v0.g().d().getClass());
            intentC.setFlags(67108864);
            com.frame.v0.g().startActivity(intentC);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void c() {
        try {
            if (com.frame.w0.d()) {
                BoxService.m().x();
            }
            com.permission.x0.m().j();
            WallpaperSetting.v(new Runnable() { // from class: i.b.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.s();
                }
            });
            WallpaperSetting.x(new Runnable() { // from class: i.b.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.u();
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void d() {
        try {
            if (g() && e() && (!p() || h())) {
                Runnable runnable = this.b;
                if (runnable != null) {
                    runnable.run();
                } else {
                    Log.e("ding", "checkAndStart: mStartListener不能为空");
                }
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT < 23 || !n() || com.permission.x0.m().n()) {
            return true;
        }
        G0();
        return false;
    }

    public void f() {
        try {
            if (WallpaperSetting.k()) {
                s.a aVar = new s.a(com.frame.v0.g().d());
                aVar.g(j.b.d.y);
                aVar.m("知道了", null);
                aVar.r("立即守护", new DialogInterface.OnClickListener() { // from class: i.b.s0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.w(dialogInterface, i2);
                    }
                });
                aVar.s(j.b.g.b);
                aVar.j("壁纸守护缓存已清理成功，请重新设置壁纸后再设置壁纸守护！");
                aVar.e().show();
            } else {
                s.a aVar2 = new s.a(com.frame.v0.g().d());
                aVar2.g(j.b.d.q0);
                aVar2.m("知道了", null);
                aVar2.r("立即守护", new DialogInterface.OnClickListener() { // from class: i.b.o0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.y(dialogInterface, i2);
                    }
                });
                aVar2.s(j.b.g.b);
                aVar2.j("未找到壁纸守护缓存，您可以开启『壁纸守护』让护眼更加稳定！");
                aVar2.e().show();
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.k0.r(e);
        }
    }

    public boolean g() {
        if (com.frame.w0.d()) {
            return true;
        }
        C0();
        return false;
    }

    public void k() {
        if (com.user.w.h().k(com.frame.v0.g())) {
            f.a aVar = new f.a();
            aVar.f("/getKefuUrl");
            aVar.a().l(String.class, new r7(this));
        } else {
            s.a aVar2 = new s.a(com.frame.v0.g().d());
            aVar2.r("知道了", null);
            aVar2.j("您未安装微信，可发邮件至chenai@skyingidea.com");
            aVar2.t("温馨提示");
            aVar2.e().show();
        }
    }

    public boolean m(String str) throws IOException {
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

    public boolean n() {
        return com.permission.a1.g().h() instanceof com.permission.i0;
    }

    public void w0() {
        com.frame.l1.g(new Runnable() { // from class: i.b.w0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.I();
            }
        });
    }

    public void x0() {
        com.frame.l1.g(new Runnable() { // from class: i.b.b0
            @Override // java.lang.Runnable
            public final void run() {
                t7.J();
            }
        });
    }

    public void y0(int i2, int i3, Intent intent) {
        if (com.permission.x0.c.intValue() == i2) {
            if (com.frame.w0.d()) {
                com.frame.k0.i("accessibility_set_success");
                com.frame.n0.g("already_accessibility_permission", true);
                com.frame.l1.f(new x6(this), 500L);
                if (com.frame.n0.f("mp3Play", null) != null) {
                    com.frame.n0.k("mp3Play", "2");
                }
            } else {
                com.frame.k0.i("accessibility_set_fail");
                com.frame.l1.f(new Runnable() { // from class: i.b.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.D0();
                    }
                }, 500L);
            }
        } else if (2005 == i2) {
            if (WallpaperSetting.q()) {
                if (com.permission.x0.m().p() && e()) {
                    Runnable runnable = this.b;
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        Log.e("ding", "checkAndStart: mStartListener不能为空");
                    }
                } else {
                    d();
                }
            }
        } else if (i2 == 981) {
            if (new i.a.l().i()) {
                com.frame.s0.g().u(TaskChooseDialogView.class);
                com.frame.s0.g().u(NodeListDialogView.class);
                com.frame.s0.g().u(AlarmTaskDialogView.class);
            }
        } else if (com.permission.x0.d.intValue() != i2) {
            Integer num = com.permission.x0.b;
            if (num.intValue() == i2 && this.a) {
                if (!n() || com.permission.x0.m().n()) {
                    d();
                } else {
                    H0();
                }
            } else if (num.intValue() == i2) {
                d();
            } else if (com.permission.x0.e.intValue() == i2 || com.permission.x0.f.intValue() == i2) {
                com.frame.v0 v0VarG = com.frame.v0.g();
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= d) {
                    if (Environment.isExternalStorageManager()) {
                        com.frame.k0.i("storage_set_success");
                        c();
                    } else {
                        com.frame.k0.i("storage_set_fail");
                    }
                } else if (v0VarG.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                    com.frame.k0.i("storage_set_success");
                    c();
                } else if (i4 < d || !Environment.isExternalStorageManager()) {
                    com.frame.k0.i("storage_set_fail");
                } else {
                    c();
                }
            }
        } else if (WallpaperSetting.q()) {
            com.frame.k0.i("wallpaper_set_success");
            if (com.frame.w0.d()) {
                com.frame.l1.f(new x6(this), 500L);
            } else {
                com.frame.l1.f(new Runnable() { // from class: i.b.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.permission.x0.m().a();
                    }
                }, 500L);
            }
        } else {
            com.frame.k0.i("wallpaper_set_fail");
            com.frame.l1.f(new Runnable() { // from class: i.b.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.F0();
                }
            }, 500L);
        }
        this.a = false;
    }

    public void z0(Runnable runnable) {
        this.b = runnable;
    }
}

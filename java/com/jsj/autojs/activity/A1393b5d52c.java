package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.jsj.widget.BottomView;
import com.user.AccountTool;
import com.yl.ui.s;
import com.yl.widget.PageAlertView;
import i.b.da;
import i.b.ea;
import java.util.HashMap;

/* loaded from: classes.dex */
public class A1393b5d52c extends r8 implements View.OnClickListener {
    static boolean d0;
    private BottomView U;
    private View W;
    private View Z;
    com.yl.widget.e b0;
    public long c0;
    private final HashMap<String, com.yl.widget.e> V = new HashMap<>();
    private final ea a0 = new ea();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0() {
        if (com.jsj.autojs.l.c0.e().b(this)) {
            com.jsj.autojs.l.c0.e().c(this);
            if (d0 || com.frame.w0.d() || !com.frame.n0.a("already_accessibility_permission", false) || com.frame.n0.a("ignore_acc_alert", false)) {
                return;
            }
            d0 = true;
            s.a aVar = new s.a(this);
            aVar.g(2131231019);
            aVar.r("立即加固", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.h0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.w0(dialogInterface, i2);
                }
            });
            aVar.m("忽略", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.j0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    A1393b5d52c.z0(dialogInterface, i2);
                }
            });
            aVar.j("后台服务<strong><font color='#F45075'>被系统关闭</font></strong>，这会导致自动点击功能功能失效，这是由于大部分厂商为了省电，会停止非系统软件后台服务。<br/><br/>需要去『权限加固』中进行防异常设置就可防止类似情况发生，尤其是<strong><font color='#55CA9B'>『自启动』</font></strong>和<strong><font color='#55CA9B'>『壁纸守护』</font></strong>");
            aVar.t("权限失效警告");
            aVar.e().show();
            com.frame.k0.i("dingPermission_error_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0(View view) {
        com.yl.widget.e o1Var;
        int id = view.getId();
        if (id == 2131297092) {
            o1Var = this.V.get("data");
            if (o1Var == null) {
                o1Var = new com.jsj.autojs.j.o1();
                this.V.put("data", o1Var);
            }
            com.frame.k0.i("bottom_click_data");
        } else if (id == 2131297094) {
            o1Var = new com.jsj.autojs.j.p1();
            this.V.put("main", o1Var);
            com.frame.k0.i("bottom_click_main");
        } else if (id != 2131297107) {
            o1Var = null;
        } else {
            o1Var = new com.jsj.autojs.j.q1();
            this.V.put("set", o1Var);
            com.frame.k0.i("bottom_click_mine");
        }
        if (o1Var != null) {
            H0(o1Var);
            o1Var.d2();
        }
    }

    static /* synthetic */ void E0() {
        com.permission.u0.g().d("accessibility.json");
        com.permission.u0.g().o(da.B().M().isAutoWallpaperSafe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G0() {
        this.a0.g(this);
    }

    private void s0() {
        BottomView bottomView = (BottomView) findViewById(2131296338);
        this.U = bottomView;
        bottomView.setBottomOnClick(new View.OnClickListener() { // from class: com.jsj.autojs.activity.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.D0(view);
            }
        });
        com.jsj.autojs.j.p1 p1Var = new com.jsj.autojs.j.p1();
        this.V.put("main", p1Var);
        p1Var.d2();
        H0(p1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(DialogInterface dialogInterface, int i2) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(DialogInterface dialogInterface, int i2) {
        new com.jsj.autojs.i.x().j2(x(), "permission");
    }

    private void y() {
        s0();
        ((PageAlertView) findViewById(2131296973)).a("home_alert");
        com.frame.l1.f(new Runnable() { // from class: com.jsj.autojs.activity.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.B0();
            }
        }, 500L);
    }

    static /* synthetic */ void z0(DialogInterface dialogInterface, int i2) {
        try {
            ImageView imageView = new ImageView(com.frame.v0.g());
            com.jsj.autojs.l.w.b(imageView, "qq_acc_error.webp");
            imageView.setAdjustViewBounds(true);
            int iC = com.frame.p1.c(25.0f);
            imageView.setPadding(iC, 0, iC, iC);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.jsj.autojs.l.c0.e().h();
                }
            });
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.u(imageView);
            aVar.j("如果您已经设置好了<strong><font color='#55CA9B'>『自启动』</font></strong>和<strong><font color='#55CA9B'>『防异常设置』</font></strong>，可以选择【不再提示】");
            aVar.r("忽略本次", null);
            aVar.m("不再提示", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.d0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i3) {
                    com.frame.n0.g("ignore_acc_alert", true);
                }
            });
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void H0(Fragment fragment) {
        this.b0 = (com.yl.widget.e) fragment;
        androidx.fragment.app.f2 f2VarL = x().l();
        f2VarL.o(2131296566, fragment);
        f2VarL.h();
    }

    @Override // com.jsj.autojs.activity.r8, com.act.f, i.a.i
    public void l() {
        super.l();
        if (Build.VERSION.SDK_INT < 24) {
            try {
                s.a aVar = new s.a(this);
                aVar.g(2131231138);
                aVar.r("知道了", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.i0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.u0(dialogInterface, i2);
                    }
                });
                aVar.j("目前仅支持android api 24以上的手机，您的手机android版本过低无法使用！");
                aVar.t("兼容问题");
                aVar.e().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.W.getVisibility() != 0) {
            try {
                getWindow().getDecorView().setBackground(getApplicationContext().getResources().getDrawable(2131099675));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.W.setVisibility(0);
            this.Z.setVisibility(0);
            y();
        }
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        com.yl.widget.e eVar = this.b0;
        if (eVar != null) {
            eVar.q0(i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() < this.c0 + 3000) {
            if (System.currentTimeMillis() > this.c0 + 500) {
                this.c0 = 0L;
                super.onBackPressed();
                com.frame.v0.g().o(null);
                return;
            }
            return;
        }
        this.c0 = System.currentTimeMillis();
        try {
            Toast.makeText(this, "再按一下退出", 0).show();
        } catch (Exception e) {
            com.frame.y0.l(e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.yl.ui.h0, com.act.f, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492908);
        this.W = findViewById(2131296566);
        this.Z = findViewById(2131296338);
        if (!com.frame.v0.g().l()) {
            this.W.setVisibility(8);
            this.Z.setVisibility(8);
        } else {
            try {
                getWindow().getDecorView().setBackground(getApplicationContext().getResources().getDrawable(2131099675));
            } catch (Exception e) {
                e.printStackTrace();
            }
            y();
        }
    }

    @Override // com.act.f, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.jsj.autojs.activity.r8, com.act.f, androidx.appcompat.app.s, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.l0
            @Override // java.lang.Runnable
            public final void run() {
                A1393b5d52c.E0();
            }
        });
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        com.yl.widget.e eVar = this.b0;
        if (eVar != null) {
            eVar.P0(i2, strArr, iArr);
        }
    }

    @Override // com.yl.ui.h0, com.act.f, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.frame.v0.g().l() && AccountTool.d().m()) {
            AccountTool.d().A(new Runnable() { // from class: com.jsj.autojs.activity.e0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.G0();
                }
            });
        }
    }
}

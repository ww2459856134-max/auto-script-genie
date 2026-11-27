package com.jsj.autojs.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.user.AccountTool;
import com.user.p;
import com.user.w;
import com.yl.ui.s;
import i.b.da;
import i.b.u8;
import i.h.f;
import java.text.ParseException;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: classes.dex */
public class A047634d3a4 extends com.yl.ui.p implements View.OnClickListener {
    private CheckBox P;
    private boolean Q;
    private boolean U;
    private boolean V;
    private int W;
    private TextView Z;
    private CharSequence a0;
    private ProgressDialog b0;
    private final Handler c0 = new Handler(Looper.getMainLooper());
    private Runnable d0;
    private CountDownTimer e0;

    class a implements p.a {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(int i2, String str, String str2) {
            if (A047634d3a4.this.n1(i2)) {
                A047634d3a4.this.i1(str, str2, i2);
            }
        }

        @Override // com.user.p.a
        public void a(final String str, final String str2) {
            A047634d3a4 a047634d3a4 = A047634d3a4.this;
            final int i2 = this.a;
            a047634d3a4.runOnUiThread(new Runnable() { // from class: com.jsj.autojs.activity.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d(i2, str, str2);
                }
            });
        }

        @Override // com.user.p.a
        public void b(String str) {
            A047634d3a4.this.w0(this.a, str);
        }
    }

    class b extends w.a {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(int i2, String str) {
            if (A047634d3a4.this.n1(i2)) {
                A047634d3a4.this.j1(str, i2);
            }
        }

        @Override // com.user.w.a
        public void a(final String str) {
            A047634d3a4 a047634d3a4 = A047634d3a4.this;
            final int i2 = this.a;
            a047634d3a4.runOnUiThread(new Runnable() { // from class: com.jsj.autojs.activity.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.f(i2, str);
                }
            });
        }

        @Override // com.user.w.a
        public void b(String str) {
            A047634d3a4.this.w0(this.a, "已取消微信登录");
        }

        @Override // com.user.w.a
        public void c(String str) {
            A047634d3a4.this.w0(this.a, "微信授权未完成，请重新登录");
        }
    }

    class c extends i.h.g<String> {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Activity activity, int i2) {
            super(activity);
            this.b = i2;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            super.a(i2, str);
            A047634d3a4.this.x0(this.b, str);
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            if (A047634d3a4.this.z0(this.b)) {
                com.frame.k0.i("login_qq_success");
                A047634d3a4.this.V = true;
                A047634d3a4.this.v0();
                A047634d3a4.this.h1(str);
            }
        }
    }

    class d extends i.h.g<String> {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Activity activity, int i2) {
            super(activity);
            this.b = i2;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            A047634d3a4.this.x0(this.b, str);
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            if (A047634d3a4.this.z0(this.b)) {
                com.frame.k0.i("login_wx_success");
                A047634d3a4.this.V = true;
                A047634d3a4.this.v0();
                A047634d3a4.this.h1(str);
            }
        }
    }

    class e extends CountDownTimer {
        final /* synthetic */ TextView a;
        final /* synthetic */ u8 b;
        final /* synthetic */ com.yl.ui.s c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j2, long j3, TextView textView, u8 u8Var, com.yl.ui.s sVar) {
            super(j2, j3);
            this.a = textView;
            this.b = u8Var;
            this.c = sVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.b.k();
            A047634d3a4.this.k1(this.c);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            int i2 = (int) (j2 / 1000);
            if (i2 <= 0) {
                this.a.setText("即将关闭");
                return;
            }
            this.a.setText(i2 + "秒后失效，自动关闭");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(int i2) {
        x0(i2, "授权等待超时，请重新登录");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0(int i2, String str) {
        if (this.U) {
            return;
        }
        x0(i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(int i2, String str) {
        if (z0(i2)) {
            this.c0.removeCallbacks(this.d0);
            this.Q = false;
            this.U = false;
            this.V = false;
            v0();
            S();
            TextView textView = this.Z;
            if (textView != null) {
                textView.setText(this.a0);
            }
            l1(true);
            if (TextUtils.isEmpty(str)) {
                str = "登录失败，请重试";
            }
            Y(str);
        }
    }

    static /* synthetic */ void G0() {
        if (System.currentTimeMillis() - com.frame.k0.b() > 86400000) {
            da.B().V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(String str, View view) {
        com.frame.m0.a(str);
        Y("登录码已复制到剪切板");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0() {
        u0();
        S();
        com.jsj.autojs.l.c0.e().B("网络连接失败，请检查网络连接!", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M0() {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.m
            @Override // java.lang.Runnable
            public final void run() {
                this.c.K0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O0(final u8 u8Var, String str, final com.yl.ui.s sVar, final TextView textView) {
        u8Var.l(str, new Runnable() { // from class: com.jsj.autojs.activity.p
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Y0(sVar, u8Var, textView);
            }
        }, new Runnable() { // from class: com.jsj.autojs.activity.i
            @Override // java.lang.Runnable
            public final void run() {
                this.c.e1(sVar);
            }
        }, new Runnable() { // from class: com.jsj.autojs.activity.w
            @Override // java.lang.Runnable
            public final void run() {
                this.c.M0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q0(u8 u8Var, DialogInterface dialogInterface) {
        u0();
        u8Var.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0(DialogInterface dialogInterface, int i2) {
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U0(u8 u8Var, DialogInterface dialogInterface, int i2) {
        u0();
        u8Var.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W0(com.yl.ui.s sVar, u8 u8Var, TextView textView) {
        S();
        if (y0()) {
            sVar.show();
            o1(sVar, u8Var, textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y0(final com.yl.ui.s sVar, final u8 u8Var, final TextView textView) {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.o
            @Override // java.lang.Runnable
            public final void run() {
                this.c.W0(sVar, u8Var, textView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a1() {
        startActivity(new Intent(this, (Class<?>) A1393b5d52c.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c1(com.yl.ui.s sVar) {
        u0();
        com.yl.ui.i0.g(this, "login.json", 2500L, new Runnable() { // from class: com.jsj.autojs.activity.u
            @Override // java.lang.Runnable
            public final void run() {
                this.c.a1();
            }
        });
        k1(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e1(final com.yl.ui.s sVar) {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c1(sVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g1() {
        startActivity(new Intent(this, (Class<?>) A1393b5d52c.class));
        try {
            if (TextUtils.isEmpty(AccountTool.d().c().getAccount())) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(2025, 7, 1);
                calendar.getTimeInMillis();
                com.frame.m1.e(AccountTool.d().c().getInsertTime(), "yyyy-MM-dd HH:mm");
                startActivity(new Intent(this, (Class<?>) A4e5efa332d.class));
            }
            finish();
        } catch (ParseException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(String str, String str2, int i2) {
        f.a aVar = new f.a();
        aVar.f("/loginByQQNew");
        aVar.b();
        aVar.e("openId", str2);
        aVar.e("isNew", "1");
        aVar.e("accessToken", str);
        aVar.e("inviteCode", com.frame.n0.e("promoteCode"));
        aVar.g(false);
        aVar.a().l(String.class, new c(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(String str, int i2) {
        f.a aVar = new f.a();
        aVar.f("/loginByWechatNew");
        aVar.b();
        aVar.e("code", str);
        aVar.e("isNew", "1");
        aVar.e("inviteCode", com.frame.n0.e("promoteCode"));
        aVar.g(false);
        aVar.a().l(String.class, new d(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(com.yl.ui.s sVar) {
        if (sVar == null || !y0()) {
            return;
        }
        try {
            if (sVar.isShowing()) {
                sVar.cancel();
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    private void l1(boolean z) {
        int[] iArr = {2131296476, 2131296475, 2131296339, 2131296473, 2131296474};
        for (int i2 = 0; i2 < 5; i2++) {
            findViewById(iArr[i2]).setEnabled(z);
        }
    }

    private void m1() {
        if (y0() && this.Q && !this.V) {
            if (this.b0 == null) {
                ProgressDialog progressDialog = new ProgressDialog(this);
                this.b0 = progressDialog;
                progressDialog.setMessage("正在登录中，请稍候…");
                this.b0.setCancelable(false);
                this.b0.setCanceledOnTouchOutside(false);
            }
            if (this.b0.isShowing()) {
                return;
            }
            this.b0.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n1(int i2) {
        if (!z0(i2) || this.U) {
            return false;
        }
        this.U = true;
        this.c0.removeCallbacks(this.d0);
        m1();
        return true;
    }

    private void o1(com.yl.ui.s sVar, u8 u8Var, TextView textView) {
        u0();
        e eVar = new e(120000L, 1000L, textView, u8Var, sVar);
        this.e0 = eVar;
        eVar.start();
    }

    private boolean t0(View view) {
        if (this.Q || !y0()) {
            return false;
        }
        this.Q = true;
        this.U = false;
        this.V = false;
        final int i2 = this.W + 1;
        this.W = i2;
        TextView textView = (TextView) view;
        this.Z = textView;
        this.a0 = textView.getText();
        this.Z.setText("正在登录中…");
        l1(false);
        m1();
        Runnable runnable = new Runnable() { // from class: com.jsj.autojs.activity.v
            @Override // java.lang.Runnable
            public final void run() {
                this.c.B0(i2);
            }
        };
        this.d0 = runnable;
        this.c0.postDelayed(runnable, 120000L);
        return true;
    }

    private void u0() {
        CountDownTimer countDownTimer = this.e0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.e0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        ProgressDialog progressDialog = this.b0;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.b0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(final int i2, final String str) {
        runOnUiThread(new Runnable() { // from class: com.jsj.autojs.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                this.c.D0(i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(final int i2, final String str) {
        runOnUiThread(new Runnable() { // from class: com.jsj.autojs.activity.s
            @Override // java.lang.Runnable
            public final void run() {
                this.c.F0(i2, str);
            }
        });
    }

    private boolean y0() {
        return (isFinishing() || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z0(int i2) {
        return this.Q && i2 == this.W && y0();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492906;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("登录");
        if (AccountTool.d().j()) {
            startActivity(new Intent(this, (Class<?>) A1393b5d52c.class));
            finish();
            return;
        }
        this.P = (CheckBox) findViewById(2131296546);
        findViewById(2131296339).setOnClickListener(this);
        findViewById(2131296475).setOnClickListener(this);
        findViewById(2131296476).setOnClickListener(this);
        findViewById(2131296473).setOnClickListener(this);
        findViewById(2131296474).setOnClickListener(this);
        findViewById(2131297314).setOnClickListener(this);
        findViewById(2131297315).setOnClickListener(this);
        i.a.k kVar = new i.a.k();
        kVar.c("privacy", findViewById(2131297315), null, null, this, com.jsj.autojs.l.c0.e().f());
        kVar.c("user_privacy", findViewById(2131297314), null, null, this, "https://h5.skyingidea.com/useragree/autojs.html");
        new Thread(new Runnable() { // from class: com.jsj.autojs.activity.t
            @Override // java.lang.Runnable
            public final void run() {
                A047634d3a4.G0();
            }
        }).start();
    }

    public void h1(String str) {
        try {
            AccountTool.d().x(str);
            com.frame.a1.b().a();
            long jE = com.frame.m1.e(AccountTool.d().c().getInsertTime(), "yyyy-MM-dd HH:mm");
            if (AccountTool.d().m() || System.currentTimeMillis() - jE >= 6.048E8f) {
                com.yl.ui.i0.g(this, "login.json", 2500L, new Runnable() { // from class: com.jsj.autojs.activity.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.g1();
                    }
                });
                return;
            }
            try {
                if (TextUtils.isEmpty(AccountTool.d().c().getAccount())) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2025, 7, 1);
                    calendar.getTimeInMillis();
                    com.frame.m1.e(AccountTool.d().c().getInsertTime(), "yyyy-MM-dd HH:mm");
                    startActivity(new Intent(this, (Class<?>) A4e5efa332d.class));
                }
                finish();
            } catch (ParseException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            x0(this.W, "登录结果处理失败，请重试");
        }
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Q) {
            return;
        }
        int id = view.getId();
        if (id != 2131296339) {
            switch (id) {
                case 2131296474:
                    Y("请先使用微信/QQ登录");
                    break;
                case 2131296475:
                    if (!this.P.isChecked()) {
                        findViewById(2131296948).startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
                        Y("请先阅读《隐私政策》与《用户协议》后，点击同意");
                        break;
                    } else if (t0(view)) {
                        int i2 = this.W;
                        try {
                            if (!com.user.p.g().j()) {
                                x0(i2, "未安装QQ，请先安装QQ");
                                break;
                            } else {
                                com.user.p.g().n(new a(i2));
                                break;
                            }
                        } catch (Exception unused) {
                            x0(i2, "无法启动QQ登录，请重试");
                            return;
                        }
                    }
                    break;
                case 2131296476:
                    if (!this.P.isChecked()) {
                        findViewById(2131296948).startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
                        Y("请先阅读《隐私政策》与《用户协议》后，点击同意");
                        break;
                    } else if (t0(view)) {
                        int i3 = this.W;
                        try {
                            if (!com.user.w.h().k(this)) {
                                x0(i3, "未安装微信，请先安装微信");
                                break;
                            } else {
                                com.user.w.h().A(new b(i3));
                                break;
                            }
                        } catch (Exception unused2) {
                            x0(i3, "无法启动微信登录，请重试");
                            return;
                        }
                    }
                    break;
            }
            return;
        }
        if (!this.P.isChecked()) {
            findViewById(2131296948).startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
            Y("请先阅读《隐私政策》与《用户协议》后，点击同意");
            return;
        }
        com.frame.a1.b().a();
        try {
            final u8 u8Var = new u8();
            final String strTrim = com.frame.n1.g(UUID.randomUUID().toString()).trim();
            Bitmap bitmapC = new com.jsj.autojs.l.f0().c(strTrim);
            ImageView imageView = new ImageView(com.frame.v0.g());
            imageView.setImageBitmap(bitmapC);
            TextView textView = new TextView(this);
            textView.setGravity(17);
            textView.setTextSize(11.0f);
            textView.setTextColor(-9013883);
            textView.setTextIsSelectable(true);
            textView.setText("登录码：" + strTrim);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.I0(strTrim, view2);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = com.frame.p1.c(16.0f);
            layoutParams.rightMargin = com.frame.p1.c(16.0f);
            final TextView textView2 = new TextView(this);
            textView2.setGravity(17);
            textView2.setTextSize(14.0f);
            textView2.setTextColor(-9013883);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(imageView);
            linearLayout.addView(textView, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = com.frame.p1.c(6.0f);
            linearLayout.addView(textView2, layoutParams2);
            U();
            s.a aVar = new s.a(this);
            aVar.t("我的登录绑定码");
            aVar.u(linearLayout);
            aVar.o(new DialogInterface.OnCancelListener() { // from class: com.jsj.autojs.activity.q
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.c.Q0(u8Var, dialogInterface);
                }
            });
            aVar.j("请使用已登录的设备扫描此二维码，扫描后账号将切换到此设备上，原来设备的账号将下线，您也可以开通多个子账号互相同步脚本。");
            aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.c.S0(dialogInterface, i4);
                }
            });
            aVar.m("取消", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.c.U0(u8Var, dialogInterface, i4);
                }
            });
            final com.yl.ui.s sVarE = aVar.e();
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.O0(u8Var, strTrim, sVarE, textView2);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        this.W++;
        this.c0.removeCallbacksAndMessages(null);
        v0();
        u0();
        com.user.w.h().H();
        super.onDestroy();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.Q) {
            m1();
        } else {
            S();
        }
    }
}

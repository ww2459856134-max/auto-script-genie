package com.jsj.autojs.l;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.h0;
import com.frame.k0;
import com.frame.l1;
import com.user.AccountTool;
import com.yl.ui.s;
import i.b.u8;
import i.h.f;

/* loaded from: classes.dex */
public class e0 {
    private h0 a;
    private a b;
    private String c = "您的账号已在其他设备登录";
    private String d = "知道了";
    private String e;
    private Runnable f;
    private Long g;

    public interface a {
        void a();

        void b(String str);
    }

    public e0(h0 h0Var, a aVar) {
        this.b = aVar;
        this.a = h0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f() {
        try {
            s.a aVar = new s.a(this.a);
            aVar.t("温馨提示");
            aVar.j("已绑定邀请码，免费获得vip体验，请重新登录账号查看。");
            aVar.r("知道了", null);
            aVar.e().show();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h() {
        AccountTool.d().y(null, null);
        l1.e(new Runnable() { // from class: com.jsj.autojs.l.s
            @Override // java.lang.Runnable
            public final void run() {
                this.c.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(String str) {
        new u8().a(str, new Runnable() { // from class: com.jsj.autojs.l.l
            @Override // java.lang.Runnable
            public final void run() {
                this.c.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(DialogInterface dialogInterface, int i2) {
        Runnable runnable = this.f;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        this.b.a();
        try {
            s.a aVar = new s.a(this.a);
            aVar.t("温馨提示");
            aVar.j(this.c);
            aVar.r(this.d, new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.l(dialogInterface, i2);
                }
            });
            if (!TextUtils.isEmpty(this.e)) {
                aVar.m(this.e, null);
            }
            aVar.e().show();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(String str) {
        new u8().c(str, new Runnable() { // from class: com.jsj.autojs.l.t
            @Override // java.lang.Runnable
            public final void run() {
                this.c.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r() {
        this.g = null;
        this.b.a();
        try {
            s.a aVar = new s.a(this.a);
            aVar.t("温馨提示");
            aVar.j("扫描成功，子账号登录成功。");
            aVar.r("知道了", null);
            aVar.e().show();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(String str) {
        new u8().b(str, this.g, new Runnable() { // from class: com.jsj.autojs.l.q
            @Override // java.lang.Runnable
            public final void run() {
                this.c.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String str) {
        if (!TextUtils.isEmpty(str)) {
            d(str);
        } else {
            Toast.makeText(this.a, "未识别到二维码", 0).show();
            this.b.b("未识别到二维码");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Intent intent) throws Throwable {
        final String strG = new f0().g(this.a, intent.getData());
        l1.e(new Runnable() { // from class: com.jsj.autojs.l.n
            @Override // java.lang.Runnable
            public final void run() {
                this.c.v(strG);
            }
        });
    }

    public e0 A(String str, String str2, Runnable runnable) {
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
        }
        this.e = str2;
        this.f = runnable;
        return this;
    }

    public e0 B(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
        }
        return this;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(this.a, "请输入登录码", 0).show();
        } else {
            d(str.trim());
        }
    }

    public void d(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.contains("邀请码")) {
                final String str2 = str.split("：")[1];
                l1.g(new Runnable() { // from class: com.jsj.autojs.l.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.j(str2);
                    }
                });
            } else if (str.contains("绑定子账号:")) {
                String str3 = str.split("绑定子账号:")[1];
                f.a aVar = new f.a();
                aVar.f(k0.g + "/bindSubUser");
                aVar.e("secret", str3);
                aVar.g(true);
                aVar.a().l(String.class, new d0(this, this.a));
            } else {
                l1.g(new Runnable() { // from class: com.jsj.autojs.l.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.p(str);
                    }
                });
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void y(int i2, int i3, final Intent intent) {
        if (i2 == 1025 && intent != null) {
            final String stringExtra = intent.getStringExtra("qrcode_result");
            l1.g(new Runnable() { // from class: com.jsj.autojs.l.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.t(stringExtra);
                }
            });
            return;
        }
        if (i2 == 1024 && intent != null) {
            d(intent.getStringExtra("qrcode_result"));
            return;
        }
        if (i2 == 1027 && i3 == -1 && intent != null) {
            l1.g(new Runnable() { // from class: com.jsj.autojs.l.o
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.c.x(intent);
                }
            });
        } else if (i2 == 1026 && i3 == -1) {
            new f0().j(this.a, 1024);
        }
    }

    public void z(Long l2) {
        this.g = l2;
    }
}

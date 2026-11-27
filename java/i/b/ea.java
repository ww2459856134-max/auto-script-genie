package i.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.user.AccountTool;
import com.v.TaskChooseDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.ui.s;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ea {
    private String a = "chenai://www.skyingidea.com/pay";
    private String b = "chenai://www.auto/login";
    private String c = "chenai://www.auto/invite";
    private long d = 604800000;
    private long e = 1296000000;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        da.B().h2();
        com.frame.s0.g().d(TaskChooseDialogView.class);
        AccountTool.d().y(null, new Runnable() { // from class: i.b.s6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(final Activity activity, DialogInterface dialogInterface, int i2) {
        AccountTool.d().y(null, new Runnable() { // from class: i.b.q6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.h(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(View view) {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(this.a));
            intent.putExtra("fromEvent", "limitCount");
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.i("no_webapp");
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(View view) {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.putExtra("fromEvent", "limitImage");
            intent.setData(Uri.parse(this.a));
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.i("no_webapp");
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(this.b));
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.i("no_webapp");
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String str) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        if (str == null) {
            str = "此任务已用到「图片识别」等功能，请登录后使用？";
        }
        dingMsgView.h(str);
        dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.u6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.k("去登录", new View.OnClickListener() { // from class: i.b.m6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    static /* synthetic */ void x(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(TaskChooseDialogView.class);
        da.B().h2();
    }

    public void C() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("可免费执行/录制使用" + AccountTool.e + "个任务，您已超出，解锁更多任务及会员权益，请开通VIP可继续使用？");
        dingMsgView.i("免费获取", new View.OnClickListener() { // from class: i.b.i6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.l(view);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.k("去开通", new View.OnClickListener() { // from class: i.b.r6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.n(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void D() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("此任务已用到「图片识别」等会员功能，可以免费使用半个月，解锁更多任务及会员权益，请开通VIP可继续使用？");
        dingMsgView.i("免费获取", new View.OnClickListener() { // from class: i.b.t6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.p(view);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.k("去开通", new View.OnClickListener() { // from class: i.b.j6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void E(final String str) {
        com.frame.l1.f(new Runnable() { // from class: i.b.k6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.w(str);
            }
        }, 100L);
    }

    public void F() {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        da.B().h2();
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("多次联网验证失败，请检查网络连接是否成功，检查是否将APP禁用网络！");
        dingMsgView.g(j.b.d.q0);
        dingMsgView.i("放弃执行", new View.OnClickListener() { // from class: i.b.n6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ea.x(view);
            }
        });
        dingMsgView.k("重新连接", new View.OnClickListener() { // from class: i.b.p6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.B(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean z() {
        int iC = com.frame.n0.c("uisfc", 0);
        if (iC <= 4) {
            com.frame.n0.i("uisfc", iC + 1);
            return true;
        }
        com.frame.v0.f().edit().putLong("getCurrentUserInfo", 0L).apply();
        F();
        return false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean h(final Activity activity) {
        int iC = com.frame.n0.c("uisfc", 0);
        if (iC <= 1) {
            com.frame.n0.i("uisfc", iC + 1);
            return true;
        }
        try {
            com.frame.v0.f().edit().putLong("getCurrentUserInfo", 0L).apply();
            s.a aVar = new s.a(activity);
            aVar.j("多次联网验证失败，请检查网络连接是否成功，检查是否将APP禁用网络！");
            aVar.g(j.b.d.q0);
            aVar.f();
            aVar.m("关闭App", new DialogInterface.OnClickListener() { // from class: i.b.l6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    activity.finish();
                }
            });
            aVar.r("重新连接", new DialogInterface.OnClickListener() { // from class: i.b.o6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.j(activity, dialogInterface, i2);
                }
            });
            aVar.t("温馨提示");
            com.yl.ui.s sVarE = aVar.e();
            sVarE.setCancelable(false);
            sVarE.show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        return false;
    }

    public boolean c() {
        if (!AccountTool.d().j()) {
            E(null);
            return false;
        }
        try {
            long jE = com.frame.m1.e(AccountTool.d().c().getInsertTime(), "yyyy-MM-dd HH:mm");
            long jB = com.frame.k0.b();
            boolean z = System.currentTimeMillis() - jE > this.e;
            boolean z2 = System.currentTimeMillis() - jB > this.d;
            if (AccountTool.d().m() || (!(z || z2) || da.B().C().size() <= 1)) {
                return true;
            }
            D();
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean d() {
        if (da.B().C().size() <= AccountTool.e || AccountTool.d().m()) {
            return true;
        }
        C();
        return false;
    }

    public void e() {
        String str = this.c;
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(str));
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }
}

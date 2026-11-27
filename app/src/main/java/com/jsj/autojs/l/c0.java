package com.jsj.autojs.l;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.frame.a1;
import com.frame.i0;
import com.frame.k0;
import com.frame.l1;
import com.frame.n1;
import com.frame.v0;
import com.frame.w0;
import com.jsj.autojs.activity.A047634d3a4;
import com.jsj.autojs.activity.A891aae5203;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.yl.ui.s;
import i.h.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c0 {
    private static c0 a;

    private c0() {
    }

    public static final void A(Activity activity, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", str);
            intent.putExtra("android.intent.extra.TEXT", str2);
            activity.startActivity(Intent.createChooser(intent, "邀请好友"));
            k0.i("share");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str, long j2) {
        ShortcutManager shortcutManager;
        if (Build.VERSION.SDK_INT < 26 || (shortcutManager = (ShortcutManager) v0.g().getSystemService(ShortcutManager.class)) == null || !shortcutManager.isRequestPinShortcutSupported()) {
            return;
        }
        Intent intent = new Intent(v0.g(), (Class<?>) A891aae5203.class);
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.putExtra("shortcut_task_id", j2);
        ShortcutInfo shortcutInfoBuild = new ShortcutInfo.Builder(v0.g(), j2 + "").setShortLabel(str).setLongLabel(str).setIcon(Icon.createWithResource(v0.g(), 2131231019)).setIntent(intent).build();
        boolean zRequestPinShortcut = shortcutManager.requestPinShortcut(shortcutInfoBuild, i0.f(0, shortcutManager.createShortcutResultIntent(shortcutInfoBuild)).getIntentSender());
        v0 v0VarG = v0.g();
        StringBuilder sb = new StringBuilder();
        sb.append("set pinned shortcuts ");
        sb.append(zRequestPinShortcut ? "success" : "failed");
        sb.append("!");
        Toast.makeText(v0VarG, sb.toString(), 0).show();
        if (zRequestPinShortcut) {
            com.yl.ui.i0.j();
        }
    }

    public static c0 e() {
        c0 c0Var = a;
        if (c0Var != null) {
            return c0Var;
        }
        c0 c0Var2 = new c0();
        a = c0Var2;
        return c0Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str) {
        Intent intent = new Intent();
        try {
            intent.setData(Uri.parse(n1.c("T9C7Ef43sERru3cU6zDwO8uCr9VP1xunnCpxt9hOl3u4ao65BGshJrr6YoSfz6Z2aS2v+His72g7Cw6Mgm8Y1Y+RFm7VLgFUnS1Gopnaj8LV70zupzHAnkhp4XU5il5ZEqn2QbKjKxudcRbmnRVjsQPmfOrQjdZ05g34UAESlbYqBzYAgCStpQ==", "com.jsj.autojs") + str));
            v0.g().startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    static /* synthetic */ void j(DialogInterface dialogInterface, int i2) {
        v0.g().p(1);
        i0.h(v0.g().getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(DialogInterface dialogInterface, int i2) {
        C();
        k0.i("bad");
        v0.g().p(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() throws JSONException, PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = v0.g().getPackageManager().getPackageInfo(v0.g().getPackageName(), 0);
            int i2 = v0.f().getInt("lastVersion", 0);
            if (packageInfo.versionCode > i2 && i2 != 0) {
                if (!w0.d()) {
                    l1.e(new Runnable() { // from class: com.jsj.autojs.l.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            c0.p();
                        }
                    });
                }
                v0.f().edit().putInt("lastVersion", packageInfo.versionCode).apply();
                return;
            }
            if (i2 == 0) {
                v0.f().edit().putInt("lastVersion", packageInfo.versionCode).apply();
            }
            JSONObject jSONObjectF = a1.b().f("versionNew");
            if (jSONObjectF == null) {
                return;
            }
            final String strOptString = jSONObjectF.optString(SocialConstants.PARAM_APP_DESC);
            final String strOptString2 = jSONObjectF.optString(SocialConstants.PARAM_URL);
            final int i3 = jSONObjectF.getInt("version");
            String strOptString3 = jSONObjectF.optString("channels");
            if (packageInfo.versionCode < i3 && v0.f().getInt("version", 0) != i3) {
                if (TextUtils.isEmpty(strOptString3) || strOptString3.contains(k0.a())) {
                    l1.e(new Runnable() { // from class: com.jsj.autojs.l.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.w(strOptString, strOptString2, i3);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void p() {
        try {
            s.a aVar = new s.a(v0.g().d());
            aVar.t("温馨提示");
            aVar.g(R.drawable.great_icon);
            aVar.j("您已成功升级版本，部分手机在升级版本后无障碍权限会丢失，需要重启手机后重新开启权限。");
            aVar.r("知道了", null);
            aVar.m("给好评", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    i0.h(v0.g().getPackageName());
                }
            });
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(String str, DialogInterface dialogInterface, int i2) {
        k0.i("versionUpdateClick");
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
        } catch (Exception e) {
            B("请去应用市场更新", e);
            k0.i("no_market");
            e.printStackTrace();
        }
        v0.g().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(String str, DialogInterface dialogInterface, int i2) {
        k0.i("versionUpdateClick");
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
        } catch (Exception e) {
            B("请去应用市场更新", e);
            k0.i("no_market");
            e.printStackTrace();
        }
        v0.g().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String str, final String str2, final int i2) {
        try {
            if (str.contains("尽快更新") || str.contains("强制更新")) {
                AccountTool.d().s();
                s.a aVar = new s.a(v0.g().d());
                aVar.t("版本更新");
                aVar.j(str);
                aVar.n();
                aVar.f();
                aVar.r("立即更新", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.c.r(str2, dialogInterface, i3);
                    }
                });
                com.yl.ui.s sVarE = aVar.e();
                sVarE.setCancelable(false);
                sVarE.show();
            } else {
                s.a aVar2 = new s.a(v0.g().d());
                aVar2.t("版本更新");
                aVar2.j(str);
                aVar2.r("立即更新", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.c.t(str2, dialogInterface, i3);
                    }
                });
                aVar2.m("不再提示", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        v0.f().edit().putInt("version", i2).apply();
                    }
                });
                aVar2.e().show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void y(String str, Exception exc) {
        try {
            s.a aVar = new s.a(v0.g().d());
            aVar.g(2131231019);
            aVar.f();
            aVar.r("知道了", null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("</br>");
            sb.append(exc == null ? "" : exc.getMessage());
            aVar.j(sb.toString());
            aVar.t("温馨提示");
            aVar.g(2131231019);
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void B(final String str, final Exception exc) {
        l1.e(new Runnable() { // from class: com.jsj.autojs.l.f
            @Override // java.lang.Runnable
            public final void run() {
                c0.y(str, exc);
            }
        });
    }

    public void C() {
        e().h();
    }

    public boolean b(Activity activity) {
        try {
            if (v0.g().h() < 6 || v0.g().j()) {
                return true;
            }
            s.a aVar = new s.a(activity);
            aVar.r("五星好评", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    c0.j(dialogInterface, i2);
                }
            });
            aVar.m("吐槽一下", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.l(dialogInterface, i2);
                }
            });
            aVar.o(new z(this));
            aVar.s(2131558482);
            aVar.g(R.drawable.great_icon);
            aVar.i(2131558481);
            aVar.e().show();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            k0.r(e);
            return true;
        }
    }

    public void c(Activity activity) {
        l1.g(new Runnable() { // from class: com.jsj.autojs.l.j
            @Override // java.lang.Runnable
            public final void run() throws JSONException, PackageManager.NameNotFoundException {
                this.c.n();
            }
        });
    }

    public String f() {
        return "https://h5.skyingidea.com/privacy/autojs.html";
    }

    public void g() {
        if (com.user.w.h().k(v0.g())) {
            f.a aVar = new f.a();
            aVar.f("/getKefuUrl");
            aVar.a().l(String.class, new b0(this));
        } else {
            s.a aVar2 = new s.a(v0.g().d());
            aVar2.r("知道了", null);
            aVar2.j("您未安装微信，可发邮件至chenai@skyingidea.com");
            aVar2.t("温馨提示");
            aVar2.e().show();
        }
    }

    public final void h() {
        if (!AccountTool.d().j()) {
            Toast.makeText(v0.g(), "请先登录", 0).show();
            v0.g().startActivity(new Intent(v0.g(), (Class<?>) A047634d3a4.class));
            return;
        }
        if (com.user.p.g().j()) {
            f.a aVar = new f.a();
            aVar.f("/getQQGroupCode");
            aVar.b();
            aVar.a().l(String.class, new a0(this));
            return;
        }
        s.a aVar2 = new s.a(v0.g().d());
        aVar2.r("知道了", null);
        aVar2.m("反馈", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.l.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                c0.e().g();
            }
        });
        aVar2.j("投诉反馈需要通过QQ进行反馈，您还未安装QQ请先安装QQ。");
        aVar2.t("温馨提示");
        aVar2.e().show();
    }

    public final void z(Activity activity) {
        A(activity, "自动脚本精灵", a1.b().e("shareText", "【自动脚本精灵】自动点击神器，类似PC版本按键精灵，功能遥遥领先。https://a.app.qq.com/o/simple.jsp?pkgname=com.jsj.autojs"));
    }
}

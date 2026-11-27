package i.b.ja;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.frame.l1;
import com.frame.n0;
import com.frame.s0;
import com.frame.v0;
import com.yl.float_ui.DingMsgView;

/* loaded from: classes.dex */
public abstract class o {
    private static volatile Runnable a;

    public static boolean a() {
        k kVarH = m.i().h();
        if (kVarH.e()) {
            m();
            return true;
        }
        k(kVarH.d(), kVarH.c());
        return false;
    }

    static /* synthetic */ void c(View view) {
        s0.g().d(DingMsgView.class);
        Runnable runnable = a;
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void d(l lVar, String str) {
        String str2;
        String str3;
        if (lVar == l.NOT_SUPER_VIP) {
            DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
            dingMsgView.l("Paddle OCR 插件（内测）");
            n(dingMsgView, "此插件仅供终身会员使用。开通终身会员后，可在会员群下载插件并使用 Paddle OCR 功能；限时会员暂不包含此权益。");
            return;
        }
        DingMsgView dingMsgView2 = (DingMsgView) s0.g().x(DingMsgView.class);
        dingMsgView2.l("Paddle OCR 插件（内测）");
        if (lVar == l.UNSUPPORTED_ABI) {
            n(dingMsgView2, str);
            return;
        }
        if (lVar == l.RECOGNITION_FAILED) {
            n(dingMsgView2, "插件已连接，但本次识别失败：" + str + "。请检查识别区域和语言，并点击“测试”确认。<br><br><b>内测说明</b><br>Paddle OCR 插件目前处于内测阶段，识别效果和连接稳定性仍在优化。建议先点“测试”确认后再保存任务。<br><br><b>正确使用方法</b><br>1. 安装后没有桌面图标是正常现象，无需单独打开插件。<br>2. 返回主应用的“图片文字识别”节点。<br>3. 将“识别方案”选为“Paddle OCR（插件内测）”。<br>4. 选择中文、英文或数字，先点“测试”，识别正常后再保存节点。");
            return;
        }
        if (lVar == l.DISABLED) {
            o(dingMsgView2, "Paddle OCR 插件目前处于内测阶段。已检测到插件，但它被系统停用。请点击“去插件设置”启用插件，并进入“权限”开启“关联启动”，然后返回主应用重新选择。");
            return;
        }
        if (lVar != l.SERVICE_UNAVAILABLE) {
            if (lVar == l.NOT_INSTALLED) {
                str2 = "Paddle OCR 插件目前处于内测阶段，未检测到插件，请先下载并安装。";
            } else {
                str2 = str + "。请卸载设备上的旧插件，再安装与当前主应用匹配的最新版。";
            }
            dingMsgView2.h(str2 + "<br><br><b>内测说明</b><br>Paddle OCR 插件目前处于内测阶段，识别效果和连接稳定性仍在优化。建议先点“测试”确认后再保存任务。<br><br><b>正确使用方法</b><br>1. 安装后没有桌面图标是正常现象，无需单独打开插件。<br>2. 返回主应用的“图片文字识别”节点。<br>3. 将“识别方案”选为“Paddle OCR（插件内测）”。<br>4. 选择中文、英文或数字，先点“测试”，识别正常后再保存节点。");
            dingMsgView2.i("稍后", new View.OnClickListener() { // from class: i.b.ja.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView2.k("下载插件", new View.OnClickListener() { // from class: i.b.ja.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.c(view);
                }
            });
            return;
        }
        if (str == null || str.trim().isEmpty()) {
            str3 = "";
        } else {
            str3 = "（" + str.trim() + "）";
        }
        o(dingMsgView2, "Paddle OCR 插件目前处于内测阶段，服务未正常启动" + str3 + "。请前往“系统设置 → 应用管理 → Paddle OCR 插件 → 权限”开启“关联启动”，然后返回主应用重新测试。");
    }

    static /* synthetic */ void e() {
        DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
        dingMsgView.l("Paddle OCR 插件（内测）权限提醒");
        o(dingMsgView, "该功能目前处于内测阶段，识别效果和连接稳定性仍在优化。首次使用前，请前往“系统设置 → 应用管理 → Paddle OCR 插件 → 权限”开启“关联启动”。未开启时，主应用可能无法启动或连接 OCR 插件。");
    }

    static /* synthetic */ void h(View view) {
        s0.g().d(DingMsgView.class);
        i();
    }

    private static void i() {
        v0 v0VarG = v0.g();
        try {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:com.jsj.autojs.paddleocr"));
                intent.addFlags(268435456);
                v0VarG.startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
                intent2.addFlags(268435456);
                v0VarG.startActivity(intent2);
            }
        } catch (Exception unused2) {
            Toast.makeText(v0VarG, "无法打开系统设置，请手动进入“系统设置 → 应用管理 → Paddle OCR 插件 → 权限”开启权限", 1).show();
        }
    }

    public static void j(Runnable runnable) {
        a = runnable;
    }

    public static void k(final l lVar, final String str) {
        l1.e(new Runnable() { // from class: i.b.ja.b
            @Override // java.lang.Runnable
            public final void run() {
                o.d(lVar, str);
            }
        });
    }

    public static void l(n nVar) {
        k(nVar.a(), nVar.getMessage());
    }

    private static void m() {
        if (n0.a("paddle_ocr_association_notice_shown", false)) {
            return;
        }
        n0.g("paddle_ocr_association_notice_shown", true);
        l1.e(new Runnable() { // from class: i.b.ja.e
            @Override // java.lang.Runnable
            public final void run() {
                o.e();
            }
        });
    }

    private static void n(DingMsgView dingMsgView, String str) {
        dingMsgView.h(str);
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: i.b.ja.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.g().d(DingMsgView.class);
            }
        });
    }

    private static void o(DingMsgView dingMsgView, String str) {
        dingMsgView.h(str);
        dingMsgView.i("稍后", new View.OnClickListener() { // from class: i.b.ja.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.k("去插件设置", new View.OnClickListener() { // from class: i.b.ja.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.h(view);
            }
        });
    }
}

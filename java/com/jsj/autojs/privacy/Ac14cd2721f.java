package com.jsj.autojs.privacy;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.frame.k0;
import com.frame.p1;
import com.user.AccountTool;
import com.user.model.WechatModel;
import com.yl.ui.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public class Ac14cd2721f extends p {
    private static final int[] W = {120, 150, 170, 110, 206};
    private final List<a> P = new ArrayList();
    private LinearLayout Q;
    private LinearLayout U;
    private String V;

    private static final class a {
        final String a;
        final String b;
        final String c;
        final String d;
        final String e;
        final String f;

        a(String str, String str2, String str3, String str4, String str5, String str6) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
        }
    }

    private void k0(String str, String str2, String str3, String str4, String str5, String str6) {
        this.P.add(new a(str, str2, str3, str4, str5, t0(str6)));
    }

    private String l0() throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName + ProcessIdUtil.DEFAULT_PROCESSID + packageInfo.versionCode;
        } catch (Exception e) {
            k0.r(e);
            return "/";
        }
    }

    private void m0() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<a> it = this.P.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().a);
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            final String str = (String) it2.next();
            TextView textView = new TextView(this);
            textView.setText(str);
            textView.setTextSize(13.0f);
            textView.setGravity(17);
            textView.setPadding(p1.c(14.0f), 0, p1.c(14.0f), 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, p1.c(36.0f));
            layoutParams.rightMargin = p1.c(10.0f);
            this.Q.addView(textView, layoutParams);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.privacy.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.r0(str, view);
                }
            });
        }
        if (linkedHashSet.isEmpty()) {
            return;
        }
        u0((String) linkedHashSet.iterator().next());
    }

    private void n0() {
        k0("设备信息", "系统剪切板", "分享、跳转或文本输入", "用户主动复制、粘贴、分享或执行文本相关功能时", "为实现服务目的的一次性使用，不存储", "具体信息内容已删除");
        k0("设备信息", "设备已安装应用列表", "展示可选择应用并执行应用相关功能", "用户进入应用选择页或开启对应功能时", "按功能使用情况收集", "可在设备内查看已安装应用");
        k0("设备信息", "设备型号和名称", "安全运行、兼容性判断", "APP启动和功能运行时", "已收集", t0(Build.MANUFACTURER + " " + Build.MODEL));
        k0("设备信息", "CPU型号", "兼容性判断", "APP功能兼容性判断", "已收集", Arrays.toString(Build.SUPPORTED_ABIS));
        k0("设备信息", "SDK版本(Android_version)", "兼容性判断", "APP功能兼容性判断", "已收集", String.valueOf(Build.VERSION.SDK_INT));
        k0("设备信息", "软件版本号", "配置下发、问题定位", "初始化、检查更新或故障诊断时", "已收集", l0());
        k0("设备信息", "IP地址", "安全运行与风控验证", "联网访问、登录、同步、支付或崩溃上报时", "已收集（联网时）", "由服务端网络日志记录，本页不额外获取");
        k0("设备信息", "设备网络类型", "网络连接判断", "联网服务或第三方SDK初始化时", "按功能运行时处理", "本页不额外读取");
        WechatModel wechatModelC = AccountTool.d().c();
        String strValueOf = (wechatModelC == null || wechatModelC.getId() == null) ? null : String.valueOf(wechatModelC.getId());
        k0("用户资料信息", "用户ID", "账号识别、客服核验", "登录、绑定或问题反馈时", v0(strValueOf), s0(strValueOf));
        k0("用户资料信息", "昵称", "展示用户信息", "我的页面、排行榜或分享时", v0(wechatModelC == null ? null : wechatModelC.getName()), s0(wechatModelC == null ? null : wechatModelC.getName()));
        String headimgurl = wechatModelC != null ? wechatModelC.getHeadimgurl() : null;
        k0("用户资料信息", "头像", "展示用户信息", "我的页面、排行榜或分享时", v0(headimgurl), p0(headimgurl) ? "/" : "已设置");
        k0("应用与使用信息", "自动化任务及规则", "按用户设置执行点击、滑动、返回或定时任务", "创建、编辑、运行或删除自动化任务时", "按功能使用情况收集", "本地保存任务配置");
        k0("应用与使用信息", "页面识别信息", "识别目标控件并执行用户设置的自动化规则", "开启无障碍并运行页面规则时", "按功能运行时处理", "仅在设备本地运行时处理");
        k0("应用与使用信息", "截图及图像识别结果", "查找用户指定的图像目标", "用户主动开启截图识别任务时", "按功能运行时处理", "截图仅在设备本地处理");
        k0("应用与使用信息", "任务运行状态和执行记录", "展示任务状态并辅助定位运行问题", "启动或停止任务、查看运行结果时", "按发生情况收集", "本地任务状态及执行结果");
        k0("应用与使用信息", "订单记录", "依照相关法规要求保存记录", "用户每次下单时", "按发生情况收集", "订单号、金额、渠道、支付状态、服务");
        k0("应用与使用信息", "崩溃及故障诊断信息", "复现、定位和修复崩溃及兼容性问题", "APP发生异常并在下次启动尝试上报时", "按发生情况收集", "崩溃类型、异常信息和堆栈");
        k0("应用与使用信息", "本地安全检查信息", "防止应用被篡改、调试或恶意注入", "APP启动及完整功能模式运行期间", "已收集（本地运行时）", "检测完成后不持久化");
        k0("权限与本地内容", "系统日历提醒", "由系统日历辅助按时提醒", "用户主动开启定时或日期提醒时", "按授权和功能使用情况收集", "仅处理本APP创建的日历提醒");
        k0("权限与本地内容", "图片、文件及头像", "展示头像或背景、生成分享图片", "主动选择、保存、修改或分享图片时", "按功能使用情况收集", "用户主动选择的本地内容");
        k0("权限与本地内容", "悬浮窗及前台服务状态", "稳定展示运行状态和功能界面", "相关任务需要保持运行时", "按授权情况收集", "仅处理权限及服务状态");
        k0("权限与本地内容", "通知栏展示", "显示任务状态或提醒", "允许通知并开启相关提醒功能时", "按功能运行时处理", "APP生成通知，不读取其他APP通知");
    }

    private View o0(String[] strArr, boolean z, int i2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(getResources().getColor(z ? 2131099746 : i2 % 2 == 0 ? 2131099747 : 2131099748));
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (i3 > 0) {
                View view = new View(this);
                view.setBackgroundColor(getResources().getColor(2131099745));
                linearLayout.addView(view, new LinearLayout.LayoutParams(p1.c(1.0f), -1));
            }
            TextView textView = new TextView(this);
            textView.setText(strArr[i3]);
            textView.setTextSize(12.0f);
            textView.setTextColor(getResources().getColor(2131099751));
            textView.setGravity(17);
            textView.setPadding(p1.c(10.0f), p1.c(10.0f), p1.c(10.0f), p1.c(10.0f));
            textView.setMinHeight(p1.c(z ? 56.0f : 108.0f));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(p1.c(W[i3]), -2));
        }
        return linearLayout;
    }

    private static boolean p0(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(String str, View view) {
        u0(str);
    }

    private static String s0(String str) {
        if (p0(str)) {
            return "/";
        }
        String strTrim = str.trim();
        if (strTrim.length() == 1) {
            return "*";
        }
        if (strTrim.length() <= 3) {
            return strTrim.charAt(0) + "*";
        }
        return strTrim.charAt(0) + "******" + strTrim.charAt(strTrim.length() - 1);
    }

    private static String t0(String str) {
        return p0(str) ? "/" : str;
    }

    private void u0(String str) {
        this.V = str;
        w0();
        this.U.removeAllViews();
        this.U.addView(o0(new String[]{"信息名称", "使用目的", "使用场景", "收集情况", "信息内容"}, true, 0));
        int i2 = 0;
        for (a aVar : this.P) {
            if (str.equals(aVar.a)) {
                this.U.addView(o0(new String[]{aVar.b, aVar.c, aVar.d, aVar.e, aVar.f}, false, i2));
                i2++;
            }
        }
    }

    private static String v0(String str) {
        return p0(str) ? "未收集" : "1条";
    }

    private void w0() {
        for (int i2 = 0; i2 < this.Q.getChildCount(); i2++) {
            TextView textView = (TextView) this.Q.getChildAt(i2);
            boolean zContentEquals = this.V.contentEquals(textView.getText());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(p1.c(18.0f));
            gradientDrawable.setColor(getResources().getColor(zContentEquals ? 2131099742 : 2131099750));
            textView.setBackground(gradientDrawable);
            textView.setTextColor(getResources().getColor(zContentEquals ? 2131099749 : 2131099751));
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492926;
    }

    @Override // com.yl.ui.p
    public void b0() {
        Z();
        j0("个人信息收集清单");
        this.Q = (LinearLayout) findViewById(2131296975);
        this.U = (LinearLayout) findViewById(2131296976);
        n0();
        m0();
    }
}

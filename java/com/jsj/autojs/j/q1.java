package com.jsj.autojs.j;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.WallpaperSelectAct;
import com.act.WebAct;
import com.bluetooth.cursor.BluetoothHidClientAct;
import com.google.gson.Gson;
import com.jsj.autojs.activity.A03b698f07b;
import com.jsj.autojs.activity.A047634d3a4;
import com.jsj.autojs.activity.A147a4ab161;
import com.jsj.autojs.activity.A592aa6ab95;
import com.jsj.autojs.activity.A63ddcc819d;
import com.jsj.autojs.activity.A68c0a83b53;
import com.jsj.autojs.activity.A91391ecb39;
import com.jsj.autojs.activity.A99df5502f5;
import com.jsj.autojs.activity.Aa6cb29bc07;
import com.jsj.autojs.activity.Ab27c48088c;
import com.jsj.autojs.activity.Abd192a7cca;
import com.jsj.autojs.activity.Ad1caecde37;
import com.jsj.autojs.activity.Ad1cbbb5a22;
import com.jsj.autojs.activity.Ad513564891;
import com.jsj.autojs.activity.Aec5865a7cc;
import com.jsj.autojs.i.y;
import com.jsj.autojs.l.e0;
import com.jsj.widget.UserTop;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.v.ImageBoxSelectDialogView;
import com.v.TaskChooseDialogView1;
import com.v.nt;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import com.yl.ui.s;
import com.yl.ui.v;
import com.yl.widget.TitleBar;
import i.b.b8;
import i.b.da;
import i.b.f8;
import i.b.t7;
import i.b.v7;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class q1 extends com.yl.widget.e implements View.OnClickListener, y.a {
    private WeakReference<ProgressDialog> H0;
    private i.a.k I0;
    private t7 J0;
    private UserTop K0;
    private ImageView L0;
    private boolean M0;
    com.jsj.autojs.l.e0 N0;
    private final androidx.activity.result.d<String[]> O0 = v1(new androidx.activity.result.l.c(), new androidx.activity.result.c() { // from class: com.jsj.autojs.j.d1
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.x2((Uri) obj);
        }
    });
    private final androidx.activity.result.d<Uri> P0 = v1(new androidx.activity.result.l.d(), new androidx.activity.result.c() { // from class: com.jsj.autojs.j.u0
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.G2((Uri) obj);
        }
    });

    class a implements e0.a {
        a() {
        }

        @Override // com.jsj.autojs.l.e0.a
        public void a() {
            if (q1.this.K0 != null) {
                q1.this.K0.d();
            }
        }

        @Override // com.jsj.autojs.l.e0.a
        public void b(String str) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ProgressDialog progressDialog = q1.this.H0 == null ? null : (ProgressDialog) q1.this.H0.get();
                if (progressDialog == null || !progressDialog.isShowing()) {
                    return;
                }
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                if (com.frame.v0.g().l()) {
                    com.frame.k0.r(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C2(final h.h.a.a aVar) throws UnsupportedEncodingException {
        try {
            s.a aVar2 = new s.a(q());
            aVar2.t("备份完成");
            aVar2.g(R.drawable.great_icon);
            final String strDecode = URLDecoder.decode(String.valueOf(aVar.i()), StandardCharsets.UTF_8.name());
            aVar2.j("全部脚本已备份到：<strong><font color='#F45075'>" + strDecode + "</font></strong>");
            aVar2.r("发送", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.t0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.z2(aVar, dialogInterface, i2);
                }
            });
            aVar2.m("复制地址", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.s0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.jsj.autojs.l.y.a(strDecode);
                }
            });
            aVar2.e().show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E2(Uri uri, String str, String str2, File file) throws IOException {
        h.h.a.a aVarG;
        try {
            aVarG = h.h.a.a.g(y1(), uri);
        } catch (Exception e) {
            com.jsj.autojs.l.c0.e().B("备份出错，请联系客服", e);
        }
        if (aVarG != null && aVarG.a()) {
            h.h.a.a aVarE = aVarG.e(str);
            if (aVarE != null && aVarE.d()) {
                aVarE.c();
            }
            final h.h.a.a aVarB = aVarG.b("application/zip", str);
            if (aVarB == null) {
                Log.e("SAF", "创建文件失败");
                return;
            }
            new v7().m(str2);
            try {
                OutputStream outputStreamOpenOutputStream = y1().getContentResolver().openOutputStream(aVarB.i());
                try {
                    o.a.b.a(new FileInputStream(file), outputStreamOpenOutputStream);
                    Log.i("SAF", "文件导出成功 路径：" + aVarB.i());
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                } finally {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("SAF", "文件写入失败");
            }
            file.delete();
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.n0
                @Override // java.lang.Runnable
                public final void run() throws UnsupportedEncodingException {
                    this.c.C2(aVarB);
                }
            });
            U1();
            return;
        }
        Log.e("SAF", "目录无写入权限");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G2(final Uri uri) {
        if (uri == null) {
            com.jsj.autojs.l.c0.e().B("未选择文件夹", null);
            return;
        }
        y1().getContentResolver().takePersistableUriPermission(uri, 3);
        Log.d("SAF", "已授权目录：" + uri);
        final String str = da.z() + "/backup/本地备份" + com.frame.m1.a("yyyy年MM月dd日") + ".zip";
        final File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        final String name = file.getName();
        f2("备份中...");
        new Thread(new Runnable() { // from class: com.jsj.autojs.j.e1
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.c.E2(uri, name, str, file);
            }
        }).start();
    }

    static /* synthetic */ void I2(boolean z, TaskSimple taskSimple) {
        com.jsj.autojs.l.c0.d(taskSimple.getName(), taskSimple.getId());
        com.yl.ui.i0.j();
    }

    static /* synthetic */ void J2() {
        TaskChooseDialogView1 taskChooseDialogView1U = TaskChooseDialogView1.u();
        taskChooseDialogView1U.findViewById(2131296730).setVisibility(8);
        taskChooseDialogView1U.setOnChooseListener(new TaskChooseDialogView1.b() { // from class: com.jsj.autojs.j.y0
            @Override // com.v.TaskChooseDialogView1.b
            public final void a(boolean z, TaskSimple taskSimple) {
                q1.I2(z, taskSimple);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L2(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(q(), "localRestore");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N2(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(q(), "localRestore");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S2(int i2, final List list) {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.j.h1
            @Override // java.lang.Runnable
            public final void run() {
                b8.c().d(list);
            }
        });
        com.yl.ui.i0.g(q(), "success.json", 1200L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U2() {
        ImageBoxSelectDialogView imageBoxSelectDialogView = (ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class);
        imageBoxSelectDialogView.b();
        imageBoxSelectDialogView.setListType();
        imageBoxSelectDialogView.setOnImageBoxChoose(new ImageBoxSelectDialogView.c() { // from class: com.jsj.autojs.j.k1
            @Override // com.v.ImageBoxSelectDialogView.c
            public final void a(int i2, List list) {
                this.a.S2(i2, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X2() {
        P1(new Intent(com.frame.v0.g(), (Class<?>) Aec5865a7cc.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z2(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://lestore.lenovo.com/detail/L122838"));
        intent.addCategory("android.intent.category.BROWSABLE");
        try {
            P1(intent);
        } catch (ActivityNotFoundException unused) {
            h2("未找到浏览器");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean b3(Dialog dialog, String str) {
        if (TextUtils.isEmpty(str)) {
            h2("请输入登录码");
            return false;
        }
        this.N0.c(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d3() {
        this.M0 = false;
        com.yl.ui.i0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f3() {
        this.M0 = false;
        h2("找回失败，请重试");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h3() {
        Iterator<String> it;
        int i2;
        String string;
        int i3;
        int i4;
        try {
            HashMap map = new HashMap();
            Gson gson = new Gson();
            int i5 = 0;
            com.frame.f1 f1VarF = com.frame.f1.f(com.frame.v0.g(), "app_data", 0);
            Map<String, ?> all = f1VarF.g().getAll();
            int i6 = 5;
            String[] strArr = {"", com.frame.n1.l(), "ef14", com.frame.n1.k(), "4jso$dkm#kkd*lsdk@"};
            com.frame.y0.n("存储记录::" + all.keySet().size());
            Iterator<String> it2 = all.keySet().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                int i7 = i5;
                while (i7 < i6) {
                    String str = strArr[i7];
                    try {
                        String string2 = TextUtils.isEmpty(str) ? next.toString() : ((com.frame.f1) com.frame.v0.f()).i(next.toString(), str);
                        if (!string2.startsWith("task:") || map.containsKey(string2)) {
                            it = it2;
                            String string3 = f1VarF.g().getString(next.toString(), null);
                            i2 = 5;
                            for (int i8 = 0; i8 < 5; i8++) {
                                try {
                                    try {
                                        da.B().R1((Task) gson.j(com.frame.n1.c(string3, strArr[i8]), Task.class));
                                        break;
                                    } catch (Exception unused) {
                                        com.frame.y0.n(string2 + "::" + string3);
                                    }
                                } catch (Exception unused2) {
                                }
                            }
                        } else {
                            try {
                                string = f1VarF.g().getString(next.toString(), null);
                                i4 = 0;
                            } catch (Exception unused3) {
                            }
                            for (i3 = 5; i4 < i3; i3 = 5) {
                                try {
                                    it = it2;
                                } catch (Exception unused4) {
                                    it = it2;
                                }
                                try {
                                    da.B().R1((Task) gson.j(com.frame.n1.c(string, strArr[i4]), Task.class));
                                    if (TextUtils.isEmpty(str)) {
                                        map.put(next.toString(), "");
                                    }
                                    i2 = 5;
                                } catch (Exception unused5) {
                                    try {
                                        com.frame.y0.n(string2 + "::" + string);
                                        i4++;
                                        it2 = it;
                                    } catch (Exception unused6) {
                                    }
                                }
                            }
                            it = it2;
                            i2 = 5;
                        }
                    } catch (Exception unused7) {
                        it = it2;
                        i2 = i6;
                    }
                    i7++;
                    i6 = i2;
                    it2 = it;
                    i5 = 0;
                }
            }
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.w0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d3();
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.f3();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j3(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        o3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l3(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        t3();
    }

    private void m2() {
        da.B().B1("selectfolder.mp4");
        this.P0.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n3(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        u3();
    }

    private int n2(int i2) {
        return Math.round(i2 * R().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p2(DialogInterface dialogInterface, int i2) {
        androidx.core.app.f.l(q(), new String[]{"android.permission.CAMERA"}, 1026);
    }

    private void o3() {
        if (this.M0) {
            h2("正在找回脚本，请稍候");
        } else {
            this.M0 = true;
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.j.n1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.h3();
                }
            });
        }
    }

    private void p3() {
        View viewV1 = V1(2131296684);
        if (viewV1 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || !AccountTool.d().l()) {
            viewV1.setVisibility(8);
            return;
        }
        viewV1.setVisibility(0);
        if (viewV1 instanceof TextView) {
            r3((TextView) viewV1, "ESP32 HID 模式", (com.bluetooth.cursor.w.q.l() ? "当前已开启" : "当前未开启") + " · 通过 ESP32 设备执行触控操作");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r2() {
        s.a aVar = new s.a(q());
        aVar.t("恢复完成");
        aVar.g(R.drawable.great_icon);
        aVar.j("脚本已恢复。返回首页下拉刷新后即可查看。");
        aVar.r("知道了", null);
        aVar.e().show();
    }

    private void q3() {
        this.O0.a(new String[]{"*/*"});
    }

    private void r3(TextView textView, String str, String str2) {
        String str3 = str + "\n" + str2;
        int length = str.length() + 1;
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new ForegroundColorSpan(R().getColor(R.color.gray_999)), length, str3.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.75f), length, str3.length(), 33);
        spannableString.setSpan(new StyleSpan(0), length, str3.length(), 33);
        textView.setText(spannableString);
        textView.setLineSpacing(n2(3), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t2() {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.r2();
            }
        });
    }

    private void s3() {
        if (d0() && !w().K0() && w().i0("qr_login_choose") == null) {
            new com.jsj.autojs.i.y().k2(w(), "qr_login_choose");
        }
    }

    private void t3() {
        s.a aVar = new s.a(q());
        aVar.g(2131231019);
        aVar.t("最后确认");
        aVar.j("请再次确认：当前确实存在丢失脚本，并且你已了解覆盖风险。操作开始后无法自动撤销。");
        aVar.m("取消", null);
        aVar.r("确认找回", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.o0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.j3(dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v2(Uri uri, File file) {
        InputStream inputStreamOpenInputStream;
        try {
            try {
                inputStreamOpenInputStream = y1().getContentResolver().openInputStream(uri);
            } catch (Exception e) {
                com.jsj.autojs.l.c0.e().B("恢复脚本出错(" + file.getName() + "):", e);
            }
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                o.a.b.a(inputStreamOpenInputStream, new FileOutputStream(file));
                new f8().l(file, new Runnable() { // from class: com.jsj.autojs.j.g1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.t2();
                    }
                });
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                U1();
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } finally {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    private void u3() {
        s.a aVar = new s.a(q());
        aVar.g(2131231019);
        aVar.t("当前脚本可能被覆盖");
        aVar.j("同一 ID 的历史脚本可能覆盖当前版本，现有内容可能丢失。建议先使用“备份全部脚本”。");
        aVar.m("返回", null);
        aVar.r("我已了解", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.m0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.l3(dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    private void v3() {
        if (this.M0) {
            h2("正在找回脚本，请稍候");
            return;
        }
        s.a aVar = new s.a(q());
        aVar.g(2131231019);
        aVar.t("请勿随意使用");
        aVar.j("如果当前没有脚本丢失，请不要继续。此功能会扫描并写回历史脚本数据，可能覆盖你现在的脚本。");
        aVar.m("取消", null);
        aVar.r("继续确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.f1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.n3(dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x2(final Uri uri) {
        if (uri == null) {
            com.jsj.autojs.l.c0.e().B("未选择文件", null);
            return;
        }
        h.h.a.a aVarF = h.h.a.a.f(y1(), uri);
        if (aVarF == null || !aVarF.d()) {
            com.jsj.autojs.l.c0.e().B("文件不存在", null);
            return;
        }
        y1().getContentResolver().takePersistableUriPermission(uri, 1);
        f2("恢复中...");
        final File file = new File(da.z() + "/restore/本地备份" + com.frame.m1.a("yyyy年MM月dd日") + ".zip");
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.j.m1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.v2(uri, file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z2(h.h.a.a aVar, DialogInterface dialogInterface, int i2) {
        com.frame.k0.u(q(), aVar.i());
    }

    @Override // androidx.fragment.app.Fragment
    public void P0(int i2, String[] strArr, int[] iArr) {
        super.P0(i2, strArr, iArr);
        t7 t7Var = this.J0;
        if (t7Var != null) {
            t7Var.y0(i2, 0, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        UserTop userTop = this.K0;
        if (userTop != null) {
            userTop.d();
        }
        if (AccountTool.d().m()) {
            com.jsj.autojs.l.w.b(this.L0, "vip_has.webp");
        } else {
            com.jsj.autojs.l.w.b(this.L0, "vip_img.webp");
        }
        this.L0.setVisibility(AccountTool.d().l() ? 8 : 0);
        p3();
    }

    @Override // com.yl.widget.e
    public void U1() {
        com.frame.l1.e(new b());
    }

    @Override // com.yl.widget.e
    public int X1() {
        return 2131493044;
    }

    @Override // com.yl.widget.e
    public void e2(Bundle bundle) {
        super.e2(bundle);
        TitleBar titleBar = (TitleBar) V1(R.id.title_bar);
        titleBar.setTitle("设置");
        titleBar.b();
        r3((TextView) V1(2131296795), "兼容设置", "录屏、识别、触控和屏幕适配");
        r3((TextView) V1(2131296783), "运行设置", "提醒、息屏、音量键和异常恢复");
        r3((TextView) V1(2131296778), "双任务运行", "安装“小触控”后可同时运行两个脚本");
        r3((TextView) V1(2131296771), "备份全部脚本", "导出到本地文件夹，会员可用");
        r3((TextView) V1(2131296772), "恢复本地备份", "从备份文件恢复全部脚本，会员可用");
        r3((TextView) V1(2131296819), "找回丢失脚本", "仅在脚本丢失时使用，历史版本可能覆盖当前脚本");
        this.I0 = new i.a.k();
        ImageView imageView = (ImageView) V1(2131296798);
        this.L0 = imageView;
        imageView.setOnClickListener(this);
        V1(2131296334).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.j.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.Z2(view);
            }
        });
        this.K0 = (UserTop) V1(2131297324);
        com.jsj.autojs.l.e0 e0Var = new com.jsj.autojs.l.e0(q(), new a());
        this.N0 = e0Var;
        e0Var.B("登录成功。一个账号仅支持在一台设备登录；如需多设备使用，可购买子账号。");
        e0Var.A("查看子账号", "暂不", new Runnable() { // from class: com.jsj.autojs.j.v0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.X2();
            }
        });
        V1(2131296757).setOnClickListener(this);
        V1(2131296819).setOnClickListener(this);
        V1(2131296792).setOnClickListener(this);
        V1(2131296771).setOnClickListener(this);
        V1(2131296772).setOnClickListener(this);
        V1(2131296786).setOnClickListener(this);
        V1(2131297149).setOnClickListener(this);
        V1(2131296745).setOnClickListener(this);
        V1(2131296759).setOnClickListener(this);
        V1(2131296784).setOnClickListener(this);
        V1(2131296801).setOnClickListener(this);
        V1(2131296756).setOnClickListener(this);
        V1(2131296770).setOnClickListener(this);
        V1(2131296761).setOnClickListener(this);
        V1(2131296737).setOnClickListener(this);
        V1(2131296773).setOnClickListener(this);
        V1(2131296738).setOnClickListener(this);
        V1(2131296768).setOnClickListener(this);
        V1(2131296742).setOnClickListener(this);
        V1(2131296794).setOnClickListener(this);
        V1(2131296777).setOnClickListener(this);
        V1(2131296766).setOnClickListener(this);
        V1(2131296795).setOnClickListener(this);
        V1(2131296783).setOnClickListener(this);
        V1(2131296750).setOnClickListener(this);
        V1(2131296791).setOnClickListener(this);
        V1(2131296778).setOnClickListener(this);
        V1(2131296684).setOnClickListener(this);
        this.I0.c("donate", V1(2131296753), null, null, q(), null);
        this.J0 = new t7();
        if (AccountTool.d().j() && AccountTool.d().c().getPid() != null && !AccountTool.d().k(AccountTool.d().c().getPid())) {
            V1(2131296745).setVisibility(8);
        }
        if (System.currentTimeMillis() - com.frame.k0.b() > 172800000) {
            this.L0.setVisibility(0);
        } else {
            this.L0.setVisibility(8);
        }
        try {
            i.a.k kVar = new i.a.k();
            ImageView imageView2 = (ImageView) V1(2131296330);
            ImageView imageView3 = (ImageView) V1(2131296331);
            kVar.d("set_banner1", imageView2, imageView2, null, q(), null, false, 500L, null, 0);
            kVar.d("set_banner2", imageView3, imageView3, null, q(), null, false, 500L, null, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        p3();
    }

    @Override // com.yl.widget.e
    public void f2(String str) {
        try {
            WeakReference<ProgressDialog> weakReference = this.H0;
            ProgressDialog progressDialog = weakReference == null ? null : weakReference.get();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(q(), 3);
                progressDialog.setProgressStyle(0);
                this.H0 = new WeakReference<>(progressDialog);
            } else if (progressDialog.isShowing()) {
                return;
            }
            progressDialog.setMessage(str);
            progressDialog.setCancelable(false);
            progressDialog.show();
        } catch (Exception e) {
            if (com.frame.v0.g().l()) {
                com.frame.k0.r(e);
            }
        }
    }

    @Override // com.jsj.autojs.i.y.a
    public void g(int i2) {
        if (!d0() || q() == null) {
            return;
        }
        if (i2 == 0) {
            if (k2()) {
                new com.jsj.autojs.l.f0().j(q(), 1024);
            }
        } else {
            if (i2 == 1) {
                new com.jsj.autojs.l.f0().i(q(), 1027);
                return;
            }
            if (i2 != 2) {
                return;
            }
            v.a aVar = new v.a(q());
            aVar.n("输入登录码");
            aVar.f("请输入登录码");
            aVar.l(3);
            aVar.g(new v.b() { // from class: com.jsj.autojs.j.i1
                @Override // com.yl.ui.v.b
                public final boolean a(Dialog dialog, String str) {
                    return this.a.b3(dialog, str);
                }
            });
            aVar.d().show();
        }
    }

    public boolean k2() {
        if (androidx.core.content.a.a(q(), "android.permission.CAMERA") == 0) {
            return true;
        }
        s.a aVar = new s.a(q());
        aVar.j("扫码登录需要使用相机，是否开启相机权限？");
        aVar.m("取消", null);
        aVar.r("去开启", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.q0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.p2(dialogInterface, i2);
            }
        });
        aVar.t("需要相机权限");
        aVar.e().show();
        return false;
    }

    public void l2(Runnable runnable) {
        if (this.J0 == null) {
            this.J0 = new t7();
        }
        this.J0.z0(runnable);
        this.J0.d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296684:
                P1(new Intent(q(), (Class<?>) BluetoothHidClientAct.class));
                break;
            case 2131296737:
                P1(new Intent(q(), (Class<?>) A91391ecb39.class));
                break;
            case 2131296738:
                com.frame.k0.i("set_click_alarm");
                P1(new Intent(q(), (Class<?>) Aa6cb29bc07.class));
                break;
            case 2131296742:
                P1(new Intent(com.frame.v0.g(), (Class<?>) Aec5865a7cc.class));
                break;
            case 2131296745:
                if (!AccountTool.d().j()) {
                    h2("请先登录");
                    P1(new Intent(q(), (Class<?>) A047634d3a4.class));
                    break;
                } else {
                    s3();
                    break;
                }
            case 2131296750:
                P1(new Intent(com.frame.v0.g(), (Class<?>) A68c0a83b53.class));
                break;
            case 2131296753:
                Intent intent = new Intent(q(), (Class<?>) WebAct.class);
                intent.putExtra(SocialConstants.PARAM_URL, "https://h5.skyingidea.com/shanSupport/index.html");
                intent.putExtra("title", "支持一下");
                P1(intent);
                break;
            case 2131296756:
                P1(new Intent(q(), (Class<?>) A592aa6ab95.class));
                break;
            case 2131296757:
                l2(new Runnable() { // from class: com.jsj.autojs.j.b1
                    @Override // java.lang.Runnable
                    public final void run() {
                        nt.p();
                    }
                });
                break;
            case 2131296759:
                try {
                    s.a aVar = new s.a(q());
                    aVar.g(2131231019);
                    aVar.r("去评价", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.c1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            com.frame.i0.h(com.frame.v0.g().getPackageName());
                        }
                    });
                    aVar.m("暂不", null);
                    aVar.j("如果自动脚本精灵对你有帮助，欢迎前往应用商店评价。你的反馈会帮助我们继续改进。");
                    aVar.t("评价应用");
                    aVar.e().show();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 2131296761:
                if (!AccountTool.d().j()) {
                    P1(new Intent(q(), (Class<?>) A047634d3a4.class));
                    break;
                } else {
                    P1(new Intent(q(), (Class<?>) Ad1cbbb5a22.class));
                    break;
                }
            case 2131296766:
                Runnable runnable = new Runnable() { // from class: com.jsj.autojs.j.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.U2();
                    }
                };
                if (!com.permission.x0.m().k()) {
                    if (this.J0 == null) {
                        this.J0 = new t7();
                    }
                    this.J0.z0(runnable);
                    this.J0.d();
                    break;
                } else {
                    runnable.run();
                    break;
                }
            case 2131296768:
                if (!AccountTool.d().j()) {
                    P1(new Intent(q(), (Class<?>) A047634d3a4.class));
                    break;
                } else {
                    P1(new Intent(com.frame.v0.g(), (Class<?>) A63ddcc819d.class));
                    break;
                }
            case 2131296769:
                if (!com.user.p.g().j()) {
                    s.a aVar2 = new s.a(com.frame.v0.g().d());
                    aVar2.r("知道了", null);
                    aVar2.m("反馈", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.l0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            com.jsj.autojs.l.c0.e().g();
                        }
                    });
                    aVar2.j("群交流需要通过QQ进行反馈，您还未安装QQ请先安装QQ。");
                    aVar2.t("温馨提示");
                    aVar2.e().show();
                    break;
                } else {
                    com.jsj.autojs.l.c0.e().C();
                    break;
                }
            case 2131296770:
                com.jsj.autojs.l.c0.e().h();
                break;
            case 2131296771:
                if (AccountTool.d().m()) {
                    m2();
                    break;
                } else {
                    try {
                        s.a aVar3 = new s.a(q());
                        aVar3.r("开通会员", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.j1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.c.N2(dialogInterface, i2);
                            }
                        });
                        aVar3.m("取消", null);
                        aVar3.j("备份全部脚本是会员功能，开通会员后可继续使用。");
                        aVar3.t("需要会员");
                        aVar3.g(2131231019);
                        aVar3.e().show();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            case 2131296772:
                if (AccountTool.d().m()) {
                    q3();
                    break;
                } else {
                    try {
                        s.a aVar4 = new s.a(q());
                        aVar4.r("开通会员", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.a1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.c.L2(dialogInterface, i2);
                            }
                        });
                        aVar4.m("取消", null);
                        aVar4.j("恢复本地备份是会员功能，开通会员后可继续使用。");
                        aVar4.t("需要会员");
                        aVar4.g(2131231019);
                        aVar4.e().show();
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            case 2131296773:
                P1(new Intent(q(), (Class<?>) Ad1caecde37.class));
                break;
            case 2131296778:
                try {
                    s.a aVar5 = new s.a(q());
                    aVar5.g(2131231019);
                    aVar5.r("去下载", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.l1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            com.frame.i0.j("小触控");
                        }
                    });
                    aVar5.m("取消", null);
                    aVar5.j("安装“小触控”后，可与自动脚本精灵同时运行两个脚本，脚本文件可以通用。");
                    aVar5.t("双任务运行");
                    aVar5.e().show();
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case 2131296783:
                P1(new Intent(com.frame.v0.g(), (Class<?>) Ab27c48088c.class));
                break;
            case 2131296784:
                if (da.B().C() != null && !da.B().C().isEmpty()) {
                    P1(new Intent(com.frame.v0.g(), (Class<?>) A03b698f07b.class));
                    break;
                } else {
                    h2("请先添加脚本任务");
                    break;
                }
                break;
            case 2131296786:
                P1(new Intent(com.frame.v0.g(), (Class<?>) A99df5502f5.class));
                break;
            case 2131296791:
                com.jsj.autojs.l.c0.e().z(q());
                break;
            case 2131296792:
                p0 p0Var = new Runnable() { // from class: com.jsj.autojs.j.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        q1.J2();
                    }
                };
                if (!com.permission.x0.m().k()) {
                    if (this.J0 == null) {
                        this.J0 = new t7();
                    }
                    this.J0.z0(p0Var);
                    this.J0.d();
                    break;
                } else {
                    p0Var.run();
                    break;
                }
            case 2131296794:
                com.frame.k0.i("stability_click");
                P1(new Intent(q(), (Class<?>) Ad513564891.class));
                break;
            case 2131296795:
                P1(new Intent(com.frame.v0.g(), (Class<?>) A147a4ab161.class));
                break;
            case 2131296798:
            case 2131296950:
                Abd192a7cca.D0(q(), "set_click");
                break;
            case 2131296801:
                com.frame.k0.i("set_click_wallpaper");
                P1(new Intent(q(), (Class<?>) WallpaperSelectAct.class));
                break;
            case 2131296819:
                v3();
                break;
            case 2131297149:
                Intent intent2 = new Intent(q(), (Class<?>) WebAct.class);
                intent2.putExtra(SocialConstants.PARAM_URL, "https://beian.miit.gov.cn");
                intent2.putExtra("title", "备案");
                P1(intent2);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void q0(int i2, int i3, Intent intent) {
        super.q0(i2, i3, intent);
        t7 t7Var = this.J0;
        if (t7Var != null) {
            t7Var.y0(i2, i3, intent);
        }
        this.N0.y(i2, i3, intent);
    }
}

package com.jsj.autojs.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.cursor.R;
import com.v.FloatToast;
import com.yl.float_ui.SimpleLogView;
import com.yl.model.TaskConfig;
import com.yl.ui.s;
import com.yl.ui.v;
import com.yl.widget.TabLinearLayout;
import i.b.a9;
import i.b.da;
import i.b.i9;
import i.b.o7;

/* loaded from: classes.dex */
public class A147a4ab161 extends com.yl.ui.p implements View.OnClickListener {
    private TaskConfig P;
    private TextView Q;
    private TextView U;
    private TextView V;
    private TextView W;
    private TextView Z;
    private TabLinearLayout a0;
    private TabLinearLayout b0;
    private TabLinearLayout c0;
    private TextView d0;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            A147a4ab161.this.P.scanNum = (seekBar.getProgress() + 10) / 10.0f;
            da.B().S1(A147a4ab161.this.P);
        }
    }

    class b implements View.OnClickListener {
        b(A147a4ab161 a147a4ab161) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case 2131296978:
                    FloatToast.setPosition(48);
                    break;
                case 2131296979:
                    FloatToast.setPosition(80);
                    break;
                case 2131296980:
                    FloatToast.setPosition(-1);
                    break;
            }
            com.frame.l1.i(8887777);
            com.frame.s0.g().d(FloatToast.class);
            FloatToast.i("已修改提示条位置");
        }
    }

    class c implements View.OnClickListener {
        c(A147a4ab161 a147a4ab161) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case 2131297134:
                    i.b.j7.a().i(0);
                    break;
                case 2131297135:
                    i.b.j7.a().i(1);
                    break;
                case 2131297136:
                    i.b.j7.a().i(2);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(boolean z) {
        if (da.B().U()) {
            Y("请先停止脚本，再切换截图方式");
            return;
        }
        if (this.P.useAccessibilityScreenshot != z) {
            i9.v().s();
            this.P.useAccessibilityScreenshot = z;
        }
        this.P.captureModeConfirmed = true;
        da.B().S1(this.P);
        Q0();
    }

    static /* synthetic */ void C0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(DialogInterface dialogInterface, int i2) {
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G0(boolean z, DialogInterface dialogInterface, int i2) {
        if (z) {
            l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(View view, DialogInterface dialogInterface, int i2) {
        view.setSelected(true);
        this.P.isReleaseScreenCapAfterStop = true;
        da.B().S1(this.P);
    }

    private void K0(TextView textView, String str, String str2) {
        String str3 = str + "\n" + str2;
        SpannableString spannableString = new SpannableString(str3);
        int length = str.length() + 1;
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.gray_999)), length, str3.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.75f), length, str3.length(), 33);
        spannableString.setSpan(new StyleSpan(0), length, str3.length(), 33);
        textView.setText(spannableString);
        textView.setLineSpacing(m0(4), 1.0f);
    }

    private void L0() {
        if (da.B().U()) {
            Y("请先停止脚本，再切换截图方式");
        } else {
            i.b.o7.k(this, new o7.a() { // from class: com.jsj.autojs.activity.r0
                @Override // i.b.o7.a
                public final void a(boolean z) {
                    this.a.B0(z);
                }
            }, new Runnable() { // from class: com.jsj.autojs.activity.q0
                @Override // java.lang.Runnable
                public final void run() {
                    A147a4ab161.C0();
                }
            });
        }
    }

    private void M0() {
        final boolean zC = i.b.z7.c();
        try {
            s.a aVar = new s.a(this);
            aVar.t("HID录屏授权脚本");
            aVar.j(zC ? "当前已录制HID录屏授权脚本。重新录制会覆盖旧脚本，长按设置项也可以清除。" : "录制后，HID模式遇到录屏权限弹窗时会自动执行这段点击/滑动。");
            aVar.r(zC ? "重新录制" : "开始录制", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.y0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.E0(dialogInterface, i2);
                }
            });
            aVar.m(zC ? "清除脚本" : "取消", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.w0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.G0(zC, dialogInterface, i2);
                }
            });
            com.yl.ui.s sVarE = aVar.e();
            if (sVarE != null) {
                sVarE.show();
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    private void N0(final View view) {
        try {
            s.a aVar = new s.a(this);
            aVar.t("不建议开启");
            aVar.g(2131231019);
            aVar.j("开启后，每次脚本结束都会关闭录屏权限。下次执行脚本时需要重新开启录屏权限，可能影响连续执行。是否仍要开启？");
            aVar.r("仍要开启", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.m0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.I0(view, dialogInterface, i2);
                }
            });
            aVar.m("取消", null);
            com.yl.ui.s sVarE = aVar.e();
            if (sVarE != null) {
                sVarE.show();
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    private void O0() {
        if (com.frame.w0.d()) {
            i.b.z7.g();
            return;
        }
        try {
            s.a aVar = new s.a(this);
            aVar.t("需要先开启无障碍");
            aVar.j("录制HID录屏授权脚本时，需要用无障碍创建遮罩来覆盖系统授权弹窗并记录点击/滑动轨迹。请先开启一次无障碍，录制完成后可以再关闭无障碍；授权脚本会一直复用。");
            aVar.r("去开启无障碍", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.x0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.permission.x0.m().a();
                }
            });
            aVar.m("取消", null);
            com.yl.ui.s sVarE = aVar.e();
            if (sVarE != null) {
                sVarE.show();
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    private void P0() {
        int i2 = (!this.P.isAutoClickScanPermission || i9.v().F()) ? 8 : 0;
        findViewById(2131296944).setVisibility(i2);
        findViewById(2131296935).setVisibility(i2);
    }

    private void Q0() {
        String strU;
        boolean zF = i9.v().F();
        String str = zF ? "当前：无障碍截图（需要 VIP），无需录屏授权。" : "当前：录屏截图（默认），适合连续快速识别。";
        if (zF && (strU = i9.v().u()) != null) {
            str = str + "\n" + strU;
        }
        String str2 = str + "\n点击切换，两种方式均支持找图、找色和文字识别；无障碍截图需要 VIP。";
        if (da.B().O()) {
            str2 = str2 + "\n当前为 HID 模式，仅支持录屏模式。";
        }
        K0((TextView) findViewById(2131296744), "截图方式", str2);
        int[] iArr = {2131296740, 2131296787, 2131297204, 2131296935};
        for (int i2 = 0; i2 < 4; i2++) {
            View viewFindViewById = findViewById(iArr[i2]);
            viewFindViewById.setEnabled(!zF);
            viewFindViewById.setAlpha(zF ? 0.45f : 1.0f);
        }
        K0((TextView) findViewById(2131296740), "自动确认录屏权限", zF ? "仅录屏截图模式生效，原设置已保留" : "脚本需要录屏时，自动点击系统授权弹窗中的确认按钮");
        K0((TextView) findViewById(2131296787), "停止后释放录屏资源", zF ? "仅录屏截图模式生效，原设置已保留" : "每次脚本结束立即释放录屏占用，下次运行会重新申请录屏权限");
        P0();
    }

    private void R0() {
        TextView textView = this.Z;
        if (textView != null) {
            textView.setText(i.b.z7.c() ? "已录制" : "未录制");
        }
    }

    private void l0() {
        i.b.z7.a();
        R0();
        Y("已清除HID录屏授权脚本，将不再自动授权");
    }

    private int m0(int i2) {
        return (int) ((i2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(View view) {
        L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean q0(View view) {
        l0();
        return true;
    }

    static /* synthetic */ void r0(View view) {
        switch (view.getId()) {
            case 2131296971:
                a9.h(0);
                break;
            case 2131296972:
                a9.h(1);
                break;
        }
        a9.g();
        try {
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.r("知道了", null);
            aVar.j("请确认当前的屏幕是否是宽：" + com.frame.k0.c().e() + "，高：" + com.frame.k0.c().d() + "，如果不是请切换回去，避免影响图片识别等功能，大部分手机默认都是竖屏，部分模拟器默认是横屏。");
            aVar.t("兼容提醒");
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean t0(Dialog dialog, String str) {
        try {
            this.P.imgDefaultTimeout = Long.parseLong(str);
            da.B().S1(this.P);
            this.Q.setText(this.P.imgDefaultTimeout + "");
            dialog.cancel();
            return true;
        } catch (Exception e) {
            Y("请输入整数（毫秒）");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean v0(Dialog dialog, String str) {
        try {
            if (Long.parseLong(str) < 2) {
                Y("请输入整数不要低于2毫秒，建议100毫秒");
                return false;
            }
            this.P.clickDuration = Long.parseLong(str);
            da.B().S1(this.P);
            this.U.setText(this.P.clickDuration + "");
            dialog.cancel();
            return true;
        } catch (Exception e) {
            Y("请输入整数（毫秒）");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean x0(Dialog dialog, String str) throws NumberFormatException {
        try {
            long j2 = Long.parseLong(str);
            if (j2 < 10) {
                Y("请输入整数不要低于10毫秒，避免识别太快导致死机，建议80毫秒");
                return false;
            }
            if (j2 > 500) {
                Y("请输入整数不要大于500毫秒，避免识别太慢，建议80毫秒");
                return false;
            }
            this.P.imgScanDelay = j2;
            da.B().S1(this.P);
            this.V.setText(this.P.imgScanDelay + "");
            dialog.cancel();
            return true;
        } catch (Exception e) {
            Y("请输入整数（毫秒）");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean z0(Dialog dialog, String str) {
        try {
            this.P.scanButtonText = str;
            da.B().S1(this.P);
            this.W.setText(str);
            dialog.cancel();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492918;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("兼容设置");
        this.c0 = (TabLinearLayout) findViewById(2131297102);
        TextView textView = (TextView) findViewById(2131296752);
        K0(textView, "调试模式", "显示详细运行日志，排查问题时再开启");
        textView.setOnClickListener(this);
        textView.setSelected(com.frame.y0.b().f());
        this.P = da.B().M();
        findViewById(2131296744).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o0(view);
            }
        });
        TextView textView2 = (TextView) findViewById(2131297159);
        this.d0 = textView2;
        textView2.setText("当前分辨率：" + com.frame.k0.c().e() + " x " + com.frame.k0.c().d());
        TextView textView3 = (TextView) findViewById(2131296740);
        K0(textView3, "自动确认录屏权限", "脚本需要录屏时，自动点击系统授权弹窗中的确认按钮");
        textView3.setOnClickListener(this);
        textView3.setSelected(this.P.isAutoClickScanPermission);
        TextView textView4 = (TextView) findViewById(2131296802);
        K0(textView4, "自动开启壁纸守护", "锁屏或后台运行不稳定时，尝试通过壁纸守护提高保活成功率");
        textView4.setOnClickListener(this);
        textView4.setSelected(this.P.isAutoWallpaperSafe);
        findViewById(2131296937).setOnClickListener(this);
        findViewById(2131296923).setOnClickListener(this);
        findViewById(2131296936).setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(2131297204);
        this.W = textView5;
        textView5.setText(this.P.scanButtonText);
        this.W.setOnClickListener(this);
        this.Z = (TextView) findViewById(2131297229);
        findViewById(2131296935).setOnClickListener(this);
        findViewById(2131296935).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.jsj.autojs.activity.v0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.c.q0(view);
            }
        });
        R0();
        this.a0 = (TabLinearLayout) findViewById(2131297103);
        P0();
        findViewById(2131296682);
        TextView textView6 = (TextView) findViewById(2131297212);
        this.U = textView6;
        textView6.setText(this.P.clickDuration + "");
        TextView textView7 = (TextView) findViewById(2131297235);
        this.V = textView7;
        textView7.setText(this.P.imgScanDelay + "");
        TextView textView8 = (TextView) findViewById(2131297236);
        this.Q = textView8;
        textView8.setText(this.P.imgDefaultTimeout + "");
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(com.frame.v0.g().getAssets(), "fonts/SwitzerlandBold2.otf");
        this.U.setTypeface(typefaceCreateFromAsset);
        this.V.setTypeface(typefaceCreateFromAsset);
        this.Q.setTypeface(typefaceCreateFromAsset);
        TextView textView9 = (TextView) findViewById(2131296760);
        K0(textView9, "显示操作红点", "执行点击、滑动时显示红点轨迹，方便核对脚本操作位置");
        textView9.setOnClickListener(this);
        textView9.setSelected(this.P.isShowGesturePath);
        TextView textView10 = (TextView) findViewById(2131296787);
        K0(textView10, "停止后释放录屏资源", "每次脚本结束立即释放录屏占用，下次运行会重新申请录屏权限");
        textView10.setOnClickListener(this);
        textView10.setSelected(this.P.isReleaseScreenCapAfterStop);
        Q0();
        SeekBar seekBar = (SeekBar) findViewById(2131297060);
        seekBar.setMax(20);
        seekBar.setProgress(Math.round(this.P.scanNum * 10.0f) - 10);
        seekBar.setOnSeekBarChangeListener(new a());
        b bVar = new b(this);
        int i2 = FloatToast.f961h;
        if (i2 == -1) {
            this.a0.b(2131296980);
        } else if (i2 == 48) {
            this.a0.b(2131296978);
        } else if (i2 == 80) {
            this.a0.b(2131296979);
        }
        this.a0.setTabClickListener(bVar);
        this.b0 = (TabLinearLayout) findViewById(2131297106);
        c cVar = new c(this);
        int iB = i.b.j7.a().b();
        if (iB == 0) {
            this.b0.b(2131297134);
        } else if (iB == 1) {
            this.b0.b(2131297135);
        } else if (iB == 2) {
            this.b0.b(2131297136);
        }
        this.b0.setTabClickListener(cVar);
        int iA = a9.a();
        if (iA == 0) {
            this.c0.b(2131296971);
        } else if (iA == 1) {
            this.c0.b(2131296972);
        }
        this.c0.setTabClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                A147a4ab161.r0(view);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296740:
                view.setSelected(!view.isSelected());
                this.P.isAutoClickScanPermission = view.isSelected();
                da.B().S1(this.P);
                P0();
                break;
            case 2131296752:
                view.setSelected(!view.isSelected());
                com.frame.y0.b().r(view.isSelected());
                if (!view.isSelected()) {
                    com.frame.s0.g().d(SimpleLogView.class);
                    break;
                } else {
                    SimpleLogView.P();
                    break;
                }
            case 2131296760:
                view.setSelected(!view.isSelected());
                this.P.isShowGesturePath = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296787:
                if (!view.isSelected()) {
                    N0(view);
                    break;
                } else {
                    view.setSelected(false);
                    this.P.isReleaseScreenCapAfterStop = false;
                    da.B().S1(this.P);
                    break;
                }
            case 2131296802:
                view.setSelected(!view.isSelected());
                this.P.isAutoWallpaperSafe = view.isSelected();
                da.B().S1(this.P);
                com.permission.u0.g().o(this.P.isAutoWallpaperSafe);
                break;
            case 2131296923:
                v.a aVar = new v.a(this);
                aVar.n("设置点击耗时");
                aVar.f("请输入点击耗时");
                aVar.h(2);
                aVar.k(this.P.clickDuration + "");
                aVar.l(1);
                aVar.i(3);
                aVar.o("毫秒");
                aVar.e(false);
                aVar.g(new v.b() { // from class: com.jsj.autojs.activity.o0
                    @Override // com.yl.ui.v.b
                    public final boolean a(Dialog dialog, String str) {
                        return this.a.v0(dialog, str);
                    }
                });
                aVar.d().show();
                break;
            case 2131296935:
                M0();
                break;
            case 2131296936:
                v.a aVar2 = new v.a(this);
                aVar2.n("设置图片识别间隔");
                aVar2.f("请输入两次识别之间的等待时间");
                aVar2.h(2);
                aVar2.k(this.P.imgScanDelay + "");
                aVar2.l(1);
                aVar2.i(3);
                aVar2.o("毫秒");
                aVar2.e(false);
                aVar2.g(new v.b() { // from class: com.jsj.autojs.activity.t0
                    @Override // com.yl.ui.v.b
                    public final boolean a(Dialog dialog, String str) {
                        return this.a.x0(dialog, str);
                    }
                });
                aVar2.d().show();
                break;
            case 2131296937:
                v.a aVar3 = new v.a(this);
                aVar3.n("设置图片识别超时");
                aVar3.f("请输入等待识别结果的最长时间");
                aVar3.h(2);
                aVar3.k(this.P.imgDefaultTimeout + "");
                aVar3.l(1);
                aVar3.i(4);
                aVar3.o("毫秒");
                aVar3.e(false);
                aVar3.g(new v.b() { // from class: com.jsj.autojs.activity.u0
                    @Override // com.yl.ui.v.b
                    public final boolean a(Dialog dialog, String str) {
                        return this.a.t0(dialog, str);
                    }
                });
                aVar3.d().show();
                break;
            case 2131297204:
                v.a aVar4 = new v.a(this);
                aVar4.n("授权按钮文字");
                aVar4.f("请输入系统弹窗上的确认按钮文字");
                aVar4.k(this.P.scanButtonText);
                aVar4.l(1);
                aVar4.e(false);
                aVar4.g(new v.b() { // from class: com.jsj.autojs.activity.p0
                    @Override // com.yl.ui.v.b
                    public final boolean a(Dialog dialog, String str) {
                        return this.a.z0(dialog, str);
                    }
                });
                aVar4.d().show();
                break;
        }
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        R0();
        if (this.P != null) {
            Q0();
        }
    }
}

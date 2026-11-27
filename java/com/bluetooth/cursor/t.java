package com.bluetooth.cursor;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import com.frame.k0;
import com.frame.l1;
import com.frame.m0;
import com.tencent.cursor.R;
import com.yl.ui.s;

/* loaded from: classes.dex */
public abstract class t extends com.yl.ui.p {
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean Z;
    private boolean a0;
    private boolean b0;
    private boolean c0;
    private long d0;
    private int P = 0;
    private int Q = 0;
    private final Runnable e0 = new s(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C0(View view) {
        if (this.c0) {
            return;
        }
        Y("正在尝试连接已配对的B手机");
        com.bluetooth.cursor.w.q.g().c(this);
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(View view) {
        if (this.c0) {
            return;
        }
        com.bluetooth.cursor.w.q.H(false);
        Z0(false);
        com.bluetooth.cursor.w.q.g().z();
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G0(View view) {
        if (this.c0) {
            return;
        }
        m0.a(com.bluetooth.cursor.w.q.j());
        Y("已复制蓝牙名称");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(View view) {
        startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(CompoundButton compoundButton, boolean z) {
        if (this.V) {
            return;
        }
        if (!z) {
            com.bluetooth.cursor.w.q.G(false);
            Y("已切回无障碍执行模式");
            X0();
            return;
        }
        if (com.bluetooth.cursor.w.q.k()) {
            com.bluetooth.cursor.w.q.G(true);
            Y("已开启HID执行模式");
            r0();
        } else {
            b1(false);
            e1(true);
        }
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M0(CompoundButton compoundButton, boolean z) {
        if (this.W || this.c0) {
            return;
        }
        com.bluetooth.cursor.w.q.H(z);
        if (z) {
            f1();
        } else {
            com.bluetooth.cursor.w.q.g().z();
            this.a0 = false;
            Y("已关闭模拟外设网络服务");
        }
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O0(View view) {
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q0(View view) {
        e1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0(View view) {
        if (this.c0) {
            return;
        }
        com.bluetooth.cursor.w.q.H(true);
        Z0(true);
        f1();
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U0(EditText editText, EditText editText2, boolean z, DialogInterface dialogInterface, int i2) {
        try {
            String strTrim = editText.getText().toString().trim();
            String strTrim2 = editText2.getText().toString().trim();
            if (!TextUtils.isEmpty(strTrim) && !TextUtils.isEmpty(strTrim2)) {
                com.bluetooth.cursor.w.q.C(strTrim, Integer.parseInt(strTrim2));
                if (z) {
                    com.bluetooth.cursor.w.q.G(true);
                }
                Y(z ? "已绑定并开启HID执行模式" : "绑定成功");
                r0();
                X0();
                return;
            }
            Y("请输入IP和端口");
        } catch (Exception e) {
            Y("请输入正确值");
            k0.r(e);
        }
    }

    private String V0(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "未配置" : "连接失败" : "连接成功" : "连接中";
    }

    private void W0() {
        String str;
        TextView textView = (TextView) findViewById(R.id.deviceNameDisplay);
        TextView textView2 = (TextView) findViewById(R.id.deviceNameHelp);
        String strJ = com.bluetooth.cursor.w.q.j();
        if (textView != null) {
            if (this.c0) {
                str = "ESP32 HID开发板";
            } else {
                str = "蓝牙名称：" + strJ;
            }
            textView.setText(str);
        }
        if (textView2 != null) {
            if (this.c0) {
                textView2.setText("使用说明\n1. 当前固件适配 ESP32-C3 和 ESP32-S3 开发板，请加入SVIP群获取对应型号的固件及刷写说明。\n2. 首次使用时，连接开发板热点 AutoJS-HID-xxxx，打开 http://192.168.4.1 配置 2.4GHz Wi-Fi。\n3. 在手机系统蓝牙中搜索并配对 AutoJS HID-xxxx；刷写新固件后请先取消旧配对再重新配对。\n4. 手机切回与开发板相同的局域网，点击「自动发现/刷新」；无法发现时可手动绑定 ESP32 IP 和端口 21115。\n5. 开启HID模式后，点击、长按、滑动会通过局域网发送给ESP32，再由开发板通过蓝牙HID操作手机。");
                return;
            }
            textView2.setText("使用说明\n1. B手机使用「蓝牙HID模式」栏目：先绑定A手机显示的IP和端口，再开启HID模式。执行脚本时会通过网络把点击/滑动发送给A手机。\n2. A手机使用「模拟外设」栏目：点击创建外设，同意蓝牙可发现授权后，B手机在系统蓝牙中搜索并配对「" + strJ + "」。\n3. 配对完成后，A手机点重新链接，让A作为B手机的HID鼠标外设。若B手机提示个人热点/通过蓝牙共享网络，取消或忽略即可。\n4. 已配对过旧版本时，请先在系统蓝牙里取消配对再重新配对，否则绝对触摸HID可能不生效。\n5. HID模式也兼容ESP32设备（当前固件适配ESP32-C3和ESP32-S3开发板），请加入SVIP群获取对应型号的开发板固件及刷写说明。");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        if (this.U || !this.b0) {
            return;
        }
        a1(R.id.tvHidModeStatus, "执行模式：", com.bluetooth.cursor.w.q.l() ? "已开启" : "未开启");
        b1(com.bluetooth.cursor.w.q.l());
        Z0(com.bluetooth.cursor.w.q.o());
        if (com.bluetooth.cursor.w.q.k()) {
            a1(R.id.tvBindNetworkStatus, "网络连接配置：", V0(this.P));
            c1(R.id.tvBindNetworkDetail, "IP：" + com.bluetooth.cursor.w.q.e() + "  端口：" + com.bluetooth.cursor.w.q.f());
            a1(R.id.tvBindBluetoothStatus, this.c0 ? "ESP32蓝牙连接状态：" : "外设蓝牙配对状态：", V0(this.Q));
            c1(R.id.tvBindBluetoothDetail, this.c0 ? "连接成功表示ESP32已通过蓝牙HID连接本机" : "连接成功表示A手机已作为B手机HID鼠标外设");
        } else {
            a1(R.id.tvBindNetworkStatus, "网络连接配置：", "未配置");
            c1(R.id.tvBindNetworkDetail, "IP：未配置  端口：未配置");
            a1(R.id.tvBindBluetoothStatus, this.c0 ? "ESP32蓝牙连接状态：" : "外设蓝牙配对状态：", "未配置");
            c1(R.id.tvBindBluetoothDetail, this.c0 ? "请先配对ESP32蓝牙，再点击自动发现或手动绑定" : "请先绑定A手机模拟外设的IP和端口");
        }
        if (this.c0) {
            d1(R.id.lyPeripheralPanel, 8);
            h1(R.id.lyHidModePanel, this.P == 2 && this.Q == 2);
            return;
        }
        int iH = com.bluetooth.cursor.w.q.g().h();
        a1(R.id.tvPeripheralBluetoothStatus, "模拟外设蓝牙：", com.bluetooth.cursor.w.q.g().m() ? v0(iH) : "未创建");
        W0();
        String str = !com.bluetooth.cursor.w.q.g().n() ? "未启动" : System.currentTimeMillis() - com.bluetooth.cursor.w.q.g().i() < 10000 ? "连接成功" : "等待B手机连接";
        a1(R.id.tvPeripheralNetworkStatus, "网络服务：", str);
        c1(R.id.tvPeripheralNetworkDetail, "IP：" + t0() + "  端口：21115");
        boolean z = this.P == 2 && this.Q == 2;
        boolean z2 = iH == 2 && "连接成功".equals(str);
        h1(R.id.lyHidModePanel, z);
        h1(R.id.lyPeripheralPanel, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        l1.h(this.e0);
        if (this.U || !this.b0) {
            return;
        }
        l1.f(this.e0, 1000L);
    }

    private void Z0(boolean z) {
        Switch r0 = (Switch) findViewById(R.id.switchPeripheral);
        if (r0 == null || r0.isChecked() == z) {
            return;
        }
        this.W = true;
        r0.setChecked(z);
        this.W = false;
    }

    private void a1(int i2, String str, String str2) {
        TextView textView = (TextView) findViewById(i2);
        if (textView == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(u0(str2)), str.length(), spannableString.length(), 33);
        textView.setText(spannableString);
    }

    private void b1(boolean z) {
        Switch r0 = (Switch) findViewById(R.id.switchHidMode);
        if (r0 == null || r0.isChecked() == z) {
            return;
        }
        this.V = true;
        r0.setChecked(z);
        this.V = false;
    }

    private void c1(int i2, String str) {
        TextView textView = (TextView) findViewById(i2);
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void d1(int i2, int i3) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(i3);
        }
    }

    private void e1(final boolean z) {
        if (w0()) {
            View viewInflate = View.inflate(getApplicationContext(), R.layout.ly_ipconfig, null);
            final EditText editText = (EditText) viewInflate.findViewById(R.id.etIp);
            final EditText editText2 = (EditText) viewInflate.findViewById(R.id.etPort);
            editText.setText(com.bluetooth.cursor.w.q.e());
            int iF = com.bluetooth.cursor.w.q.f();
            if (iF <= 0) {
                iF = 21115;
            }
            editText2.setText(String.valueOf(iF));
            s.a aVar = new s.a(this);
            aVar.t(this.c0 ? "绑定ESP32 HID开发板" : "绑定模拟外设网络");
            aVar.j(this.c0 ? "请输入ESP32在局域网内的IP与UDP端口（默认21115）。也可取消后点击「自动发现/刷新」自动绑定。" : "请输入A手机「模拟外设」栏目显示的IP与端口。保存后会刷新网络连接配置状态。");
            aVar.u(viewInflate);
            aVar.r("保存", new DialogInterface.OnClickListener() { // from class: com.bluetooth.cursor.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.U0(editText, editText2, z, dialogInterface, i2);
                }
            });
            aVar.m("取消", null);
            aVar.e().show();
        }
    }

    private void f1() {
        if (this.a0) {
            return;
        }
        if (com.bluetooth.cursor.w.q.g().m() && com.bluetooth.cursor.w.q.g().n()) {
            return;
        }
        this.a0 = true;
        try {
            try {
                W0();
                com.bluetooth.cursor.w.q.g().v(this);
            } catch (Exception e) {
                k0.r(e);
                Y("模拟外设开启失败，请重试");
            }
        } finally {
            this.a0 = false;
            X0();
        }
    }

    private int g1(int i2) {
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 3) {
        }
        return 3;
    }

    private void h1(int i2, boolean z) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(z ? 4 : 0, Color.parseColor("#1AA260"));
        viewFindViewById.setBackground(gradientDrawable);
    }

    private void r0() {
        s0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(boolean z) {
        if (this.Z) {
            return;
        }
        this.Z = true;
        if (z) {
            this.P = 1;
            this.Q = 1;
            X0();
        }
        l1.g(new Runnable() { // from class: com.bluetooth.cursor.k
            @Override // java.lang.Runnable
            public final void run() {
                this.c.A0();
            }
        });
    }

    private String t0() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        return wifiManager != null ? Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress()) : "未获取";
    }

    private int u0(String str) {
        return "连接成功".equals(str) ? Color.parseColor("#1AA260") : ("已开启".equals(str) || "已安装".equals(str)) ? Color.parseColor("#1AA260") : "连接失败".equals(str) ? Color.parseColor("#D93025") : ("未创建".equals(str) || "未启动".equals(str) || "未安装".equals(str)) ? Color.parseColor("#1A73E8") : Color.parseColor("#333333");
    }

    private String v0(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "未创建" : "连接失败" : "连接成功" : "连接中";
    }

    private boolean w0() {
        return !isFinishing() && (Build.VERSION.SDK_INT < 17 || !isDestroyed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(int i2) {
        if (this.U) {
            this.Z = false;
            return;
        }
        this.Z = false;
        this.P = i2 == 0 ? 3 : 2;
        this.Q = g1(i2);
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0() {
        final int iB = com.bluetooth.cursor.w.q.g().B(1200);
        l1.e(new Runnable() { // from class: com.bluetooth.cursor.e
            @Override // java.lang.Runnable
            public final void run() {
                this.c.y0(iB);
            }
        });
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = false;
        if (getIntent() != null && getIntent().getBooleanExtra("clientOnly", false)) {
            z = true;
        }
        this.c0 = z;
        setContentView(R.layout.activity_bb);
        getWindow().addFlags(128);
        j0(this.c0 ? "ESP32 HID模式" : "蓝牙HID模式");
        if (this.c0) {
            d1(R.id.lyPeripheralPanel, 8);
        }
        W0();
        ((Button) findViewById(R.id.connectButton)).setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.C0(view);
            }
        });
        findViewById(R.id.disConnect).setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.E0(view);
            }
        });
        findViewById(R.id.copyDeviceName).setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.G0(view);
            }
        });
        findViewById(R.id.openBluetoothSettings).setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.I0(view);
            }
        });
        ((Switch) findViewById(R.id.switchHidMode)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bluetooth.cursor.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.K0(compoundButton, z2);
            }
        });
        ((Switch) findViewById(R.id.switchPeripheral)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bluetooth.cursor.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.M0(compoundButton, z2);
            }
        });
        findViewById(R.id.btnCheckBindStatus).setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.O0(view);
            }
        });
        findViewById(R.id.btnBind).setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.Q0(view);
            }
        });
        findViewById(R.id.btnCrete).setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.S0(view);
            }
        });
        X0();
        r0();
        if (!this.c0 && com.bluetooth.cursor.w.q.o()) {
            f1();
        }
        this.b0 = true;
        Y0();
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        this.U = true;
        this.b0 = false;
        l1.h(this.e0);
        super.onDestroy();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onPause() {
        this.b0 = false;
        l1.h(this.e0);
        S();
        super.onPause();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        this.b0 = true;
        X0();
        Y0();
    }
}

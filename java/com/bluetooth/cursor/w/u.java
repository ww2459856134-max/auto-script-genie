package com.bluetooth.cursor.w;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.bluetooth.BluetoothHidDeviceAppSdpSettings;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.frame.l1;
import com.frame.v0;
import com.yl.ui.s;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class u {
    private final Activity a;
    private com.bluetooth.cursor.x.c b;
    public BluetoothAdapter c;
    private BluetoothHidDevice d;
    private BluetoothDevice e;
    private boolean f;
    public o g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f574h = 3;

    /* renamed from: i, reason: collision with root package name */
    private final BluetoothHidDeviceAppSdpSettings f575i = new BluetoothHidDeviceAppSdpSettings(q.j(), "VV for you", "VV", (byte) -64, r.a);

    public u(Activity activity, com.bluetooth.cursor.x.c cVar) {
        this.a = activity;
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C() {
        if (t()) {
            androidx.core.app.f.l(this.a, new String[]{"android.permission.BLUETOOTH_ADVERTISE"}, 1005);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(int i2) {
        if (t()) {
            androidx.core.app.f.l(this.a, new String[]{"android.permission.BLUETOOTH_CONNECT"}, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(BluetoothDevice bluetoothDevice) {
        n(bluetoothDevice.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(com.yl.ui.s[] sVarArr, final BluetoothDevice bluetoothDevice, View view) {
        if (sVarArr[0] != null) {
            sVarArr[0].dismiss();
        }
        l1.g(new Runnable() { // from class: com.bluetooth.cursor.w.f
            @Override // java.lang.Runnable
            public final void run() {
                this.c.G(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(Set set) {
        if (t()) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(24, 24, 24, 24);
            TextView textView = new TextView(this.a);
            textView.setText("选择刚刚和A手机配对的B手机。选错时可取消后在系统蓝牙里断开无关设备。");
            textView.setTextSize(14.0f);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            final com.yl.ui.s[] sVarArr = new com.yl.ui.s[1];
            Iterator it = set.iterator();
            while (it.hasNext()) {
                final BluetoothDevice bluetoothDevice = (BluetoothDevice) it.next();
                Button button = new Button(this.a);
                button.setText(T(bluetoothDevice) + "\n" + bluetoothDevice.getAddress());
                button.setAllCaps(false);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.bluetooth.cursor.w.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.I(sVarArr, bluetoothDevice, view);
                    }
                });
                linearLayout.addView(button, new LinearLayout.LayoutParams(-1, -2));
            }
            s.a aVar = new s.a(this.a);
            aVar.t("选择B手机");
            aVar.u(linearLayout);
            aVar.m("取消", null);
            sVarArr[0] = aVar.e();
            sVarArr[0].show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(Activity activity, String str) {
        if (t()) {
            s.a aVar = new s.a(activity);
            aVar.j(str);
            aVar.f();
            aVar.t("温馨提示");
            aVar.r("知道了", null);
            aVar.e().show();
        }
    }

    private boolean N() {
        if (this.a == null) {
            return false;
        }
        final Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
        intent.putExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", 120);
        if (!R()) {
            return false;
        }
        try {
            l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.y(intent);
                }
            });
            return true;
        } catch (Exception e) {
            Log.e("new Connect Manager:", "makeDeviceDiscoverable failed", e);
            W("无法打开蓝牙可发现授权，请手动打开系统蓝牙");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (S(1)) {
            l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.A();
                }
            });
            BluetoothHidDevice bluetoothHidDevice = this.d;
            if (bluetoothHidDevice == null || this.f) {
                return;
            }
            this.f = true;
            if (bluetoothHidDevice.registerApp(this.f575i, null, null, v0.g().getMainExecutor(), new t(this))) {
                return;
            }
            this.f = false;
            W("模拟外设注册失败，请重试");
        }
    }

    private boolean R() {
        Context contextG = this.a;
        if (contextG == null) {
            contextG = v0.g();
        }
        if (Build.VERSION.SDK_INT < 31 || androidx.core.content.a.a(contextG, "android.permission.BLUETOOTH_ADVERTISE") == 0) {
            return true;
        }
        if (t()) {
            l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.C();
                }
            });
            return false;
        }
        l1.j("请打开HID设置页授予蓝牙广播权限");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(final int i2) {
        Context contextG = this.a;
        if (contextG == null) {
            contextG = v0.g();
        }
        if (Build.VERSION.SDK_INT < 31 || androidx.core.content.a.a(contextG, "android.permission.BLUETOOTH_CONNECT") == 0) {
            return true;
        }
        if (t()) {
            l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.E(i2);
                }
            });
            return false;
        }
        l1.j("请打开HID设置页授予蓝牙权限");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return "未知设备";
        }
        try {
            String name = bluetoothDevice.getName();
            return TextUtils.isEmpty(name) ? "未知设备" : name;
        } catch (Exception e) {
            Log.e("new Connect Manager:", "safeDeviceName failed", e);
            return "未知设备";
        }
    }

    @SuppressLint({"MissingPermission"})
    private void U(final Set<BluetoothDevice> set) {
        if (t()) {
            l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.K(set);
                }
            });
        } else {
            l1.j("A端有多个已配对设备，请断开无关设备后点重新链接");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        l1.j(str);
    }

    @SuppressLint({"MissingPermission"})
    private void X(BluetoothAdapter bluetoothAdapter) {
        Activity activity;
        if (bluetoothAdapter == null || (activity = this.a) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 31 || androidx.core.content.a.a(activity, "android.permission.BLUETOOTH_CONNECT") == 0) {
            try {
                String strJ = q.j();
                if (TextUtils.equals(bluetoothAdapter.getName(), strJ)) {
                    return;
                }
                bluetoothAdapter.setName(strJ);
            } catch (Exception e) {
                Log.e("new Connect Manager:", "updateBluetoothName failed", e);
            }
        }
    }

    private BluetoothAdapter p() {
        if (!S(1002)) {
            return null;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) v0.g().getSystemService("bluetooth");
        BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
        if (adapter == null) {
            V(this.a, "设备不支持蓝牙");
            return null;
        }
        if (adapter.isEnabled()) {
            W("蓝牙已开启");
            X(adapter);
            return adapter;
        }
        final Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        if (t()) {
            l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.w(intent);
                }
            });
        } else {
            W("请先打开蓝牙后再开启模拟外设");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        Activity activity = this.a;
        return (activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && this.a.isDestroyed())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(Intent intent) {
        try {
            if (t()) {
                this.a.startActivityForResult(intent, 1003);
            }
        } catch (Exception e) {
            Log.e("new Connect Manager:", "open bluetooth enable page failed", e);
            W("无法打开蓝牙开启授权，请手动打开系统蓝牙");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(Intent intent) {
        try {
            if (t()) {
                this.a.startActivityForResult(intent, 1004);
            }
        } catch (Exception e) {
            Log.e("new Connect Manager:", "makeDeviceDiscoverable failed", e);
            W("无法打开蓝牙可发现授权，请手动打开系统蓝牙");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        if (t()) {
            ((com.act.e) this.a).W("模拟外设已开启，请在B手机系统蓝牙中搜索并配对：" + q.j() + "。如B提示个人热点/通过蓝牙共享网络，请取消或忽略。", true);
        }
    }

    public void O(boolean z) {
        if (z && t() && !N()) {
            return;
        }
        P();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"MissingPermission"})
    public void Q() {
        try {
            try {
                if (this.d != null) {
                    if (this.e != null && u()) {
                        this.d.disconnect(this.e);
                    }
                    if (this.f) {
                        this.d.unregisterApp();
                    }
                }
            } catch (Exception e) {
                Log.e("new Connect Manager:", "release failed", e);
            }
        } finally {
            this.f = false;
            this.g = null;
            this.e = null;
            this.f574h = 3;
        }
    }

    public void V(final Activity activity, final String str) {
        if (t()) {
            l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.M(activity, str);
                }
            });
        }
    }

    public void n(String str) {
        if (S(100)) {
            if (this.c == null) {
                this.c = p();
            }
            if (this.c == null || TextUtils.isEmpty(str)) {
                W("蓝牙未初始化或设备地址为空，请重新创建模拟外设");
                return;
            }
            try {
                BluetoothDevice remoteDevice = this.c.getRemoteDevice(str);
                this.e = remoteDevice;
                if (remoteDevice == null) {
                    Log.d("new Connect Manager:", "activeConnect: 设备未找到");
                    return;
                }
                String strT = T(remoteDevice);
                Log.d("new Connect Manager:", "activeConnect: 设备已找到");
                Log.d("new Connect Manager:", "activeConnect: 设备名称: " + strT);
                V(this.a, "已找到已配对设备：" + strT + "。如果B手机提示个人热点/通过蓝牙共享网络，取消或忽略即可，HID不需要开启热点。");
                Set<BluetoothDevice> bondedDevices = this.c.getBondedDevices();
                boolean z = false;
                if (bondedDevices != null) {
                    Iterator<BluetoothDevice> it = bondedDevices.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        BluetoothDevice next = it.next();
                        Log.d("new Connect Manager:", "activeConnect----------------");
                        Log.d("new Connect Manager:", "activeConnect name: " + T(next));
                        Log.d("new Connect Manager:", "activeConnect: address: " + next.getAddress());
                        Log.d("new Connect Manager:", "activeConnect: address: " + str);
                        Log.d("new Connect Manager:", "activeConnect----------------");
                        if (next.getAddress().equals(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    Log.d("new Connect Manager:", "activeConnect: 设备未配对");
                    return;
                }
                Log.d("new Connect Manager:", "activeConnect: bluetoothAdapter.isEnabled() " + this.c.isEnabled());
                BluetoothHidDevice bluetoothHidDevice = this.d;
                if (bluetoothHidDevice == null) {
                    W("模拟外设尚未初始化完成，请稍后重试");
                    return;
                }
                this.f574h = 1;
                if (bluetoothHidDevice.connect(this.e)) {
                    Log.d("new Connect Manager:", "activeConnect: 连接成功");
                } else {
                    this.f574h = 3;
                    Log.d("new Connect Manager:", "activeConnect: 连接失败");
                }
            } catch (Exception e) {
                Log.e("new Connect Manager:", "activeConnect: invalid bluetooth address", e);
                W("蓝牙设备地址无效，请重新配对");
            }
        }
    }

    public void o() {
        if (u()) {
            W("HID鼠标已连接");
            return;
        }
        com.bluetooth.cursor.x.d dVarB = this.b.b(0);
        if (dVarB != null) {
            n(dVarB.a());
            return;
        }
        if (S(100)) {
            if (this.c == null) {
                BluetoothAdapter bluetoothAdapterP = p();
                this.c = bluetoothAdapterP;
                if (bluetoothAdapterP == null) {
                    W("蓝牙未初始化，请重新创建模拟外设");
                    return;
                }
            }
            Set<BluetoothDevice> bondedDevices = this.c.getBondedDevices();
            if (bondedDevices == null || bondedDevices.isEmpty()) {
                W("没有已配对设备，请先让B手机配对A手机");
            } else if (bondedDevices.size() == 1) {
                n(bondedDevices.iterator().next().getAddress());
            } else {
                U(bondedDevices);
            }
        }
    }

    public int q() {
        if (u()) {
            return 2;
        }
        return this.f574h;
    }

    public boolean r() {
        return t();
    }

    public void s() {
        if (S(100)) {
            BluetoothAdapter bluetoothAdapterP = p();
            this.c = bluetoothAdapterP;
            if (bluetoothAdapterP == null || bluetoothAdapterP.getProfileProxy(v0.g(), new s(this), 19)) {
                return;
            }
            V(this.a, "init: 蓝牙HID设备代理获取失败");
        }
    }

    public boolean u() {
        return this.g != null;
    }
}

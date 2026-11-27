package com.bluetooth.cursor.w;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.util.Log;
import com.frame.l1;

/* loaded from: classes.dex */
class t extends BluetoothHidDevice.Callback {
    final /* synthetic */ u a;

    t(u uVar) {
        this.a = uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        if (this.a.t()) {
            ((com.act.e) this.a.a).S();
        }
    }

    @Override // android.bluetooth.BluetoothHidDevice.Callback
    public void onAppStatusChanged(BluetoothDevice bluetoothDevice, boolean z) {
        this.a.f = z;
        if (this.a.S(1)) {
            StringBuilder sb = new StringBuilder();
            sb.append("应用状态变化: ");
            sb.append(z ? "已注册" : "未注册");
            sb.append(", 插入设备: ");
            sb.append(bluetoothDevice != null ? this.a.T(bluetoothDevice) : "无");
            Log.d("new Connect Manager:", sb.toString());
            if (bluetoothDevice != null) {
                final u uVar = this.a;
                l1.g(new Runnable() { // from class: com.bluetooth.cursor.w.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        uVar.o();
                    }
                });
            }
        }
    }

    @Override // android.bluetooth.BluetoothHidDevice.Callback
    public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, int i2) {
        if (this.a.S(1)) {
            String strT = this.a.T(bluetoothDevice);
            Log.d("new Connect Manager:", "连接状态变化: " + strT + ", 状态: " + i2);
            if (i2 == 0) {
                this.a.f574h = 3;
                this.a.g = null;
                Log.d("new Connect Manager:", "设备已断开连接: " + strT);
                return;
            }
            if (i2 == 1) {
                this.a.f574h = 1;
                Log.d("new Connect Manager:", "设备正在连接: " + strT);
                return;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.a.f574h = 1;
                Log.d("new Connect Manager:", "设备正在断开连接: " + strT);
                return;
            }
            if (bluetoothDevice == null) {
                return;
            }
            this.a.f574h = 2;
            q.t();
            Log.d("new Connect Manager:", "设备已连接: " + strT);
            this.a.b.a(new com.bluetooth.cursor.x.d(bluetoothDevice.getAddress(), strT, System.currentTimeMillis()));
            this.a.e = bluetoothDevice;
            u uVar = this.a;
            uVar.g = new o(uVar.d, this.a.e);
            this.a.W("设备已连接");
            if (this.a.t()) {
                l1.e(new Runnable() { // from class: com.bluetooth.cursor.w.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.b();
                    }
                });
            }
        }
    }
}

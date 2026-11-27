package com.bluetooth.cursor.w;

import android.bluetooth.BluetoothHidDevice;
import android.bluetooth.BluetoothProfile;
import android.util.Log;

/* loaded from: classes.dex */
class s implements BluetoothProfile.ServiceListener {
    final /* synthetic */ u a;

    s(u uVar) {
        this.a = uVar;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int i2, BluetoothProfile bluetoothProfile) {
        Log.d("new Connect Manager:", "onServiceConnected: 和蓝牙配置文件服务建立连接");
        if (i2 == 19) {
            this.a.d = (BluetoothHidDevice) bluetoothProfile;
            this.a.P();
        } else {
            u uVar = this.a;
            uVar.V(uVar.a, "onServiceConnected: 未知的蓝牙配置文件, profile: " + i2);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int i2) {
        Log.d("new Connect Manager:", "onServiceDisconnected: 和蓝牙配置文件服务断开连接");
    }
}

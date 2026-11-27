package com.bluetooth.cursor.w;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.os.SystemClock;
import android.util.Log;
import com.frame.k0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class o {
    private final BluetoothHidDevice a;
    private final BluetoothDevice b;
    private int d;
    private int e;
    public boolean c = true;
    String f = "BluetoothHidMouse";

    public o(BluetoothHidDevice bluetoothHidDevice, BluetoothDevice bluetoothDevice) {
        this.a = bluetoothHidDevice;
        this.b = bluetoothDevice;
    }

    private boolean a() {
        if (this.a == null) {
            Log.e(this.f, "sendMouse failed, hid device is null!");
            return false;
        }
        if (this.b != null) {
            return this.c;
        }
        Log.e(this.f, "sendMouse failed, hid device is not connected!");
        return false;
    }

    private int b(int i2) {
        return Math.max(-127, Math.min(127, i2));
    }

    private int c(int i2) {
        return Math.max(0, Math.min(32767, i2));
    }

    private int d(int i2, int i3) {
        return Math.max(1, Math.max(((Math.abs(i2) + 127) - 1) / 127, ((Math.abs(i3) + 127) - 1) / 127));
    }

    private int e(int i2, int i3, int i4, int i5) {
        return Math.max(1, (int) Math.ceil(Math.hypot(i4 - i2, i5 - i3) / 12.0d));
    }

    private int f(ArrayList<Integer> arrayList) {
        int iE = 0;
        for (int i2 = 2; i2 < arrayList.size(); i2 += 2) {
            iE += e(arrayList.get(i2 - 2).intValue(), arrayList.get(i2 - 1).intValue(), arrayList.get(i2).intValue(), arrayList.get(i2 + 1).intValue());
        }
        return Math.max(1, iE);
    }

    private int g(int i2, int i3) {
        if (i3 <= 1) {
            return 0;
        }
        return c(Math.round(i2 * (32767.0f / (i3 - 1))));
    }

    private void i(int i2, int i3, int i4, long j2) {
        int i5 = i2 - this.d;
        int i6 = i3 - this.e;
        long jMax = j2 > 0 ? Math.max(1L, j2 / d(i5, i6)) : 0L;
        while (true) {
            if (i5 == 0 && i6 == 0) {
                return;
            }
            int iB = b(i5);
            int iB2 = b(i6);
            o(i4, iB, iB2, 0, 0);
            this.d += iB;
            this.e += iB2;
            i5 -= iB;
            i6 -= iB2;
            if (jMax > 0) {
                SystemClock.sleep(jMax);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private void l(ArrayList<Integer> arrayList, long j2, int i2, int i3) {
        int size = arrayList.size() / 2;
        long j3 = 0;
        long jMax = Math.max(j2, 0L);
        Log.d(this.f, "performTouchGesture start, pointCount=" + size + ", duration=" + jMax + ", screen=" + i2 + "x" + i3);
        int iIntValue = arrayList.get(0).intValue();
        int iIntValue2 = arrayList.get(1).intValue();
        int i4 = 1;
        q(true, iIntValue, iIntValue2, i2, i3);
        SystemClock.sleep(20L);
        if (size == 1) {
            SystemClock.sleep(Math.max(jMax, 50L));
            q(false, iIntValue, iIntValue2, i2, i3);
            return;
        }
        long jMax2 = jMax > 0 ? Math.max(1L, jMax / Math.max(1, f(arrayList))) : 0L;
        int i5 = 2;
        while (i5 < arrayList.size()) {
            int iIntValue3 = arrayList.get(i5 - 2).intValue();
            int iIntValue4 = arrayList.get(i5 - 1).intValue();
            int iIntValue5 = arrayList.get(i5).intValue();
            int iIntValue6 = arrayList.get(i5 + 1).intValue();
            int iE = e(iIntValue3, iIntValue4, iIntValue5, iIntValue6);
            int i6 = i4;
            while (i6 <= iE) {
                float f = i6 / iE;
                int iRound = Math.round(iIntValue3 + ((iIntValue5 - iIntValue3) * f));
                int i7 = i6;
                int iRound2 = Math.round(iIntValue4 + ((iIntValue6 - iIntValue4) * f));
                int i8 = iE;
                int i9 = iIntValue6;
                int i10 = iIntValue5;
                int i11 = iIntValue4;
                int i12 = iIntValue3;
                q(true, iRound, iRound2, i2, i3);
                if (jMax2 > 0) {
                    SystemClock.sleep(jMax2);
                }
                iIntValue4 = i11;
                iIntValue5 = i10;
                iIntValue3 = i12;
                i6 = i7 + 1;
                iIntValue6 = i9;
                iE = i8;
                j3 = 0;
            }
            i5 += 2;
            i4 = 1;
        }
        q(false, arrayList.get(arrayList.size() - 2).intValue(), arrayList.get(arrayList.size() - 1).intValue(), i2, i3);
    }

    private void m() {
        for (int i2 = 0; i2 < 32; i2++) {
            o(0, -127, -127, 0, 0);
            SystemClock.sleep(2L);
        }
        this.d = 0;
        this.e = 0;
    }

    @SuppressLint({"MissingPermission"})
    private boolean o(int i2, int i3, int i4, int i5, int i6) {
        if (!a()) {
            return false;
        }
        boolean zSendReport = this.a.sendReport(this.b, 4, new byte[]{(byte) i2, (byte) b(i3), (byte) b(i4), (byte) b(i5), (byte) b(i6)});
        if (!zSendReport) {
            Log.e(this.f, "sendReport failed, button=" + i2 + ", dx=" + i3 + ", dy=" + i4);
        }
        return zSendReport;
    }

    @SuppressLint({"MissingPermission"})
    private boolean q(boolean z, int i2, int i3, int i4, int i5) {
        if (!a()) {
            return false;
        }
        int iG = g(i2, i4);
        int iG2 = g(i3, i5);
        byte[] bArr = new byte[6];
        bArr[0] = (byte) (z ? 3 : 0);
        bArr[1] = 1;
        bArr[2] = (byte) (iG & 255);
        bArr[3] = (byte) ((iG >> 8) & 255);
        bArr[4] = (byte) (iG2 & 255);
        bArr[5] = (byte) ((iG2 >> 8) & 255);
        boolean zSendReport = this.a.sendReport(this.b, 5, bArr);
        if (!zSendReport) {
            Log.e(this.f, "sendTouchReport failed, touching=" + z + ", x=" + i2 + ", y=" + i3 + ", hidX=" + iG + ", hidY=" + iG2);
        }
        return zSendReport;
    }

    @SuppressLint({"MissingPermission"})
    public boolean h(byte b, byte b2) {
        return o(0, b, b2, 0, 0);
    }

    @SuppressLint({"MissingPermission"})
    public void j(ArrayList<Integer> arrayList, long j2) {
        k(arrayList, j2, 0, 0);
    }

    @SuppressLint({"MissingPermission"})
    public void k(ArrayList<Integer> arrayList, long j2, int i2, int i3) {
        if (arrayList != null) {
            if (arrayList.size() >= 2 && arrayList.size() % 2 == 0 && a()) {
                if (i2 > 0 && i3 > 0) {
                    l(arrayList, j2, i2, i3);
                    return;
                }
                int size = arrayList.size() / 2;
                Log.d(this.f, "performGesture start, pointCount=" + size + ", duration=" + j2);
                long jMax = Math.max(j2, 0L);
                long jMax2 = Math.max(jMax, 50L);
                long j3 = size > 1 ? jMax / (size - 1) : 0L;
                m();
                SystemClock.sleep(20L);
                i(arrayList.get(0).intValue(), arrayList.get(1).intValue(), 0, 0L);
                if (size == 1) {
                    o(1, 0, 0, 0, 0);
                    SystemClock.sleep(jMax2);
                    o(0, 0, 0, 0, 0);
                    return;
                } else {
                    o(1, 0, 0, 0, 0);
                    SystemClock.sleep(20L);
                    for (int i4 = 2; i4 < arrayList.size(); i4 += 2) {
                        i(arrayList.get(i4).intValue(), arrayList.get(i4 + 1).intValue(), 1, j3);
                    }
                    o(0, 0, 0, 0, 0);
                    return;
                }
            }
        }
        String str = this.f;
        StringBuilder sb = new StringBuilder();
        sb.append("performGesture ignored, pathSize=");
        sb.append(arrayList != null ? arrayList.size() : 0);
        Log.e(str, sb.toString());
    }

    @SuppressLint({"MissingPermission"})
    public void n(boolean z) throws InterruptedException {
        o(1, 0, 0, 0, 0);
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            k0.r(e);
        }
        o(0, 0, 0, 0, 0);
    }

    @SuppressLint({"MissingPermission"})
    public void p(boolean z) throws InterruptedException {
        o(2, 0, 0, 0, 0);
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            k0.r(e);
        }
        o(0, 0, 0, 0, 0);
    }

    @SuppressLint({"MissingPermission"})
    public void r(byte b, byte b2) {
        o(0, 0, 0, b2, b);
        Log.d(this.f, "sendWheel vWheel:" + ((int) b2) + ",hWheel：" + ((int) b));
    }
}

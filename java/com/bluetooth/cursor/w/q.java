package com.bluetooth.cursor.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.bluetooth.cursor.v;
import com.frame.k0;
import com.frame.l1;
import com.frame.n0;
import com.frame.v0;
import com.google.gson.Gson;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class q {
    private static q d;
    private u a;
    private v b;
    private PowerManager.WakeLock c;

    private q() {
    }

    private void A() {
        try {
            try {
                PowerManager.WakeLock wakeLock = this.c;
                if (wakeLock != null && wakeLock.isHeld()) {
                    this.c.release();
                }
            } catch (Exception e) {
                Log.e("DefaultBluetoothConnect", "releaseWakeLock failed", e);
            }
        } finally {
            this.c = null;
        }
    }

    public static void C(String str, int i2) {
        n0.k("hidIP", str);
        n0.i("hidPort", i2);
    }

    private void F(byte[] bArr) {
        if (!k()) {
            Log.e("DefaultBluetoothConnect", "sendSocketCommand ignored, bind device is empty");
            return;
        }
        Log.d("DefaultBluetoothConnect", "sendSocketCommand type=" + ((int) bArr[0]) + ", length=" + bArr.length + ", target=" + e() + ParameterizedMessage.ERROR_MSG_SEPARATOR + f());
        v.n(bArr, e(), f());
    }

    public static void G(boolean z) {
        n0.g("hidModel", z);
    }

    public static void H(boolean z) {
        n0.g("hidPeripheralEnabled", z);
    }

    private void I(Activity activity, boolean z) {
        d();
        u uVar = this.a;
        if (uVar != null) {
            uVar.Q();
            this.a = null;
        }
        u uVar2 = new u(activity, new com.bluetooth.cursor.x.c(v0.g()));
        this.a = uVar2;
        uVar2.s();
        v vVar = new v();
        this.b = vVar;
        vVar.p(this.a);
        a();
        this.a.O(z);
    }

    public static void J(Context context) {
        int i2;
        if (context == null || (i2 = Build.VERSION.SDK_INT) < 28) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) com.bluetooth.cursor.u.class);
            intent.setAction("com.bluetooth.cursor.action.START_HID_PERIPHERAL");
            if (i2 >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } catch (Exception e) {
            Log.e("DefaultBluetoothConnect", "startPeripheralService failed", e);
        }
    }

    public static void K(Context context) {
        if (context == null) {
            return;
        }
        try {
            context.stopService(new Intent(context, (Class<?>) com.bluetooth.cursor.u.class));
        } catch (Exception e) {
            Log.e("DefaultBluetoothConnect", "stopPeripheralService failed", e);
        }
    }

    private void a() {
        PowerManager powerManager;
        try {
            PowerManager.WakeLock wakeLock = this.c;
            if ((wakeLock == null || !wakeLock.isHeld()) && (powerManager = (PowerManager) v0.g().getSystemService("power")) != null) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "AutoJS:HidPeripheral");
                this.c = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
                this.c.acquire();
            }
        } catch (Exception e) {
            Log.e("DefaultBluetoothConnect", "acquireWakeLock failed", e);
        }
    }

    public static String e() {
        return n0.e("hidIP");
    }

    public static int f() {
        return n0.c("hidPort", 0);
    }

    public static q g() {
        q qVar = d;
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q();
        d = qVar2;
        return qVar2;
    }

    public static String j() {
        String strE = n0.e("hidDeviceName");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String str = "AutoJS HID-" + String.format(Locale.US, "%04d", Integer.valueOf(Math.abs((int) (System.currentTimeMillis() % 10000))));
        n0.k("hidDeviceName", str);
        return str;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(e()) && f() > 0;
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 28 && n0.a("hidModel", false) && k();
    }

    public static boolean o() {
        return n0.a("hidPeripheralEnabled", false);
    }

    public static void t() {
        n0.g("hidPeripheralEverConnected", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.net.DatagramSocket] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    private int w(String str, int i2, int i3, boolean z) throws Throwable {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2;
        byte[] bArr;
        DatagramPacket datagramPacket;
        byte b;
        ?? r3 = 0;
        DatagramSocket datagramSocket3 = null;
        DatagramSocket datagramSocket4 = null;
        try {
            try {
                datagramSocket2 = new DatagramSocket();
            } catch (Throwable th) {
                th = th;
            }
        } catch (SocketTimeoutException unused) {
        } catch (Exception e) {
            e = e;
        }
        try {
            datagramSocket2.setBroadcast(z);
            datagramSocket2.setSoTimeout(i3);
            byte[] bArr2 = {8};
            InetAddress byName = InetAddress.getByName(str);
            if (!z) {
                datagramSocket2.connect(byName, i2);
            }
            datagramSocket2.send(new DatagramPacket(bArr2, 1, byName, i2));
            bArr = new byte[2];
            datagramPacket = new DatagramPacket(bArr, 2);
            datagramSocket2.receive(datagramPacket);
            b = bArr[0];
        } catch (SocketTimeoutException unused2) {
            datagramSocket3 = datagramSocket2;
            Log.d("DefaultBluetoothConnect", "requestRemoteStatus timeout, target=" + str + ParameterizedMessage.ERROR_MSG_SEPARATOR + i2);
            r3 = datagramSocket3;
            datagramSocket = datagramSocket3;
            if (datagramSocket3 != null) {
                datagramSocket.close();
                r3 = datagramSocket;
            }
            return 0;
        } catch (Exception e2) {
            e = e2;
            datagramSocket4 = datagramSocket2;
            Log.e("DefaultBluetoothConnect", "requestRemoteStatus failed, target=" + str + ParameterizedMessage.ERROR_MSG_SEPARATOR + i2, e);
            r3 = datagramSocket4;
            if (datagramSocket4 != null) {
                datagramSocket = datagramSocket4;
                datagramSocket.close();
                r3 = datagramSocket;
            }
            return 0;
        } catch (Throwable th2) {
            th = th2;
            r3 = datagramSocket2;
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
        if (b != 9) {
            datagramSocket2.close();
            r3 = b;
            return 0;
        }
        if (z) {
            C(datagramPacket.getAddress().getHostAddress(), i2);
        }
        byte b2 = bArr[1];
        datagramSocket2.close();
        return b2;
    }

    public int B(int i2) {
        int iW;
        int iF = f() > 0 ? f() : 21115;
        String strE = e();
        int iMax = Math.max(500, i2);
        return (TextUtils.isEmpty(strE) || (iW = w(strE, iF, iMax, false)) == 0) ? w("255.255.255.255", iF, iMax, true) : iW;
    }

    public void D(ArrayList<Integer> arrayList, long j2) {
        if (arrayList == null || arrayList.size() < 2 || arrayList.size() % 2 != 0) {
            return;
        }
        p pVar = new p();
        pVar.a = arrayList;
        pVar.b = j2;
        pVar.c = k0.c().e();
        pVar.d = k0.c().d();
        byte[] bytes = new Gson().s(pVar).getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 6;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        F(bArr);
    }

    public void E(int i2, int i3) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(9).order(ByteOrder.BIG_ENDIAN);
        byteBufferOrder.put((byte) 7);
        byteBufferOrder.putInt(i2);
        byteBufferOrder.putInt(i3);
        F(byteBufferOrder.array());
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void q(Activity activity) {
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                u uVar = this.a;
                if (uVar != null && uVar.r()) {
                    this.a.o();
                    return;
                }
                r(activity);
                return;
            }
        }
        Log.e("DefaultBluetoothConnect", "connect ignored, activity is null or sdk < P");
    }

    public void c(final Activity activity) {
        l1.g(new Runnable() { // from class: com.bluetooth.cursor.w.d
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q(activity);
            }
        });
    }

    public synchronized void d() {
        v vVar = this.b;
        if (vVar != null) {
            vVar.q();
            this.b = null;
        }
    }

    public int h() {
        u uVar = this.a;
        if (uVar == null) {
            return 3;
        }
        return uVar.q();
    }

    public long i() {
        v vVar = this.b;
        if (vVar == null) {
            return 0L;
        }
        return vVar.b();
    }

    public boolean m() {
        return this.a != null;
    }

    public boolean n() {
        v vVar = this.b;
        return vVar != null && vVar.c();
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public synchronized void s(Activity activity) {
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                I(activity, true);
                J(activity);
                return;
            }
        }
        Log.e("DefaultBluetoothConnect", "passiveScan ignored, activity is null or sdk < P");
    }

    public void v(final Activity activity) {
        l1.g(new Runnable() { // from class: com.bluetooth.cursor.w.c
            @Override // java.lang.Runnable
            public final void run() {
                this.c.s(activity);
            }
        });
    }

    public synchronized void x() {
        y(true);
    }

    public synchronized void y(boolean z) {
        d();
        u uVar = this.a;
        if (uVar != null) {
            uVar.Q();
            this.a = null;
        }
        A();
        if (z) {
            K(v0.g());
        }
    }

    public void z() {
        l1.g(new Runnable() { // from class: com.bluetooth.cursor.w.b
            @Override // java.lang.Runnable
            public final void run() {
                this.c.x();
            }
        });
    }
}

package com.bluetooth.cursor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.frame.k0;
import com.frame.l1;
import com.google.gson.Gson;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class v {
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private Future<?> b;
    private DatagramSocket c;
    private volatile long d;
    private com.bluetooth.cursor.w.u e;
    private byte[][] f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f572h;

    /* renamed from: i, reason: collision with root package name */
    BitmapFactory.Options f573i;

    private int a(int i2) {
        return Math.max(-127, Math.min(127, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(byte[] bArr) {
        com.bluetooth.cursor.w.o oVar;
        try {
            byte[] bArr2 = new byte[bArr.length - 1];
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            ArrayList<Integer> arrayList = (ArrayList) new Gson().k(new String(bArr2, StandardCharsets.UTF_8), com.google.gson.k0.a.c(ArrayList.class, Integer.class).e());
            com.bluetooth.cursor.w.u uVar = this.e;
            if (uVar == null || (oVar = uVar.g) == null) {
                return;
            }
            oVar.j(arrayList, 300L);
        } catch (Exception e) {
            Log.e("UdpServer", "legacy drag failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[bArr.length - 1];
            int size = 0;
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            com.bluetooth.cursor.w.p pVar = (com.bluetooth.cursor.w.p) new Gson().j(new String(bArr2, StandardCharsets.UTF_8), com.bluetooth.cursor.w.p.class);
            if (pVar == null) {
                Log.e("UdpServer", "gesture command is null");
                return;
            }
            ArrayList<Integer> arrayList = pVar.a;
            if (arrayList != null) {
                size = arrayList.size() / 2;
            }
            Log.d("UdpServer", "gesture command received, pointCount=" + size + ", duration=" + pVar.b + ", screen=" + pVar.c + "x" + pVar.d);
            com.bluetooth.cursor.w.u uVar = this.e;
            if (uVar == null) {
                Log.e("UdpServer", "gesture ignored, connectionManager is null");
                l1.j("收到B端手势，但A端连接管理器未初始化");
                return;
            }
            com.bluetooth.cursor.w.o oVar = uVar.g;
            if (oVar != null) {
                oVar.k(pVar.a, pVar.b, pVar.c, pVar.d);
                return;
            }
            Log.e("UdpServer", "gesture ignored, hid mouse is not connected");
            l1.j("收到B端手势，但HID鼠标未连接。请在A端点重新链接，或重新配对B手机");
            this.e.o();
        } catch (Exception e) {
            Log.e("UdpServer", "gesture failed", e);
        }
    }

    static /* synthetic */ void h(byte[] bArr, InetAddress inetAddress, int i2) throws Throwable {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2 = null;
        try {
            try {
                datagramSocket = new DatagramSocket();
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            datagramSocket.send(new DatagramPacket(bArr, bArr.length, inetAddress, i2));
            datagramSocket.close();
        } catch (Exception e2) {
            e = e2;
            datagramSocket2 = datagramSocket;
            Log.e("UdpServer", "sendUdpMessage failed", e);
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            throw th;
        }
    }

    static /* synthetic */ void i(String str, byte[] bArr, int i2) throws Throwable {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2 = null;
        DatagramSocket datagramSocket3 = null;
        try {
            try {
                datagramSocket = new DatagramSocket();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName(str), i2);
            datagramSocket.send(datagramPacket);
            datagramSocket2 = datagramPacket;
            if (!datagramSocket.isClosed()) {
                datagramSocket.close();
                datagramSocket2 = datagramPacket;
            }
        } catch (Exception e2) {
            e = e2;
            datagramSocket3 = datagramSocket;
            k0.r(e);
            datagramSocket2 = datagramSocket3;
            if (datagramSocket3 != null) {
                boolean zIsClosed = datagramSocket3.isClosed();
                datagramSocket2 = datagramSocket3;
                if (!zIsClosed) {
                    datagramSocket3.close();
                    datagramSocket2 = datagramSocket3;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null && !datagramSocket2.isClosed()) {
                datagramSocket2.close();
            }
            throw th;
        }
    }

    private void k(int i2, int i3) {
        if (i2 < -127 || i2 > 127 || i3 < -127 || i3 > 127) {
            Log.e("UdpServer", "Target position out of bounds");
            return;
        }
        com.bluetooth.cursor.w.u uVar = this.e;
        if (uVar == null) {
            Log.d("UdpServer", "moveTo: 连接管理器未初始化");
        } else if (uVar.u()) {
            this.e.g.h((byte) i2, (byte) i3);
        } else {
            Log.d("UdpServer", "moveTo: 设备未连接");
        }
    }

    private void l(final byte[] bArr, InetAddress inetAddress, int i2) {
        com.bluetooth.cursor.w.o oVar;
        com.bluetooth.cursor.w.o oVar2;
        com.bluetooth.cursor.w.o oVar3;
        if (bArr != null) {
            try {
            } catch (Exception e) {
                Log.e("UdpServer", "Error parsing binary message", e);
            }
            if (bArr.length == 0) {
                return;
            }
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            byte b = byteBufferOrder.get();
            switch (b) {
                case 1:
                    if (bArr.length < 9) {
                        Log.e("UdpServer", "move packet ignored, length=" + bArr.length);
                        break;
                    } else {
                        int i3 = byteBufferOrder.getInt();
                        int i4 = byteBufferOrder.getInt();
                        Log.d("UdpServer", "onMessageReceived: Move Mouse x=" + i3 + ", y=" + i4);
                        k(i3, i4);
                        break;
                    }
                case 2:
                    if (bArr.length < 5) {
                        Log.e("UdpServer", "image packet ignored, length=" + bArr.length);
                        break;
                    } else {
                        short s = byteBufferOrder.getShort();
                        int i5 = byteBufferOrder.getShort();
                        if (i5 > 0 && i5 <= 2048 && s >= 0 && s < i5) {
                            byte[] bArr2 = new byte[bArr.length - 5];
                            byteBufferOrder.get(bArr2);
                            if (this.f == null || this.g != i5) {
                                this.g = i5;
                                this.f572h = 0;
                                this.f = new byte[i5][];
                            }
                            byte[][] bArr3 = this.f;
                            if (bArr3[s] == null) {
                                bArr3[s] = bArr2;
                                this.f572h++;
                            }
                            if (this.f572h == i5) {
                                byte[] bArr4 = new byte[i5 * 1395];
                                int length = 0;
                                for (byte[] bArr5 : bArr3) {
                                    if (bArr5 != null) {
                                        System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
                                        length += bArr5.length;
                                    }
                                }
                                this.f572h = 0;
                                this.f = null;
                                break;
                            }
                        }
                        Log.e("UdpServer", "image packet ignored, chunkIndex=" + ((int) s) + ", totalChunks=" + i5);
                        break;
                    }
                    break;
                case 3:
                    Log.d("UdpServer", "onMessageReceived: 鼠标左键点击");
                    com.bluetooth.cursor.w.u uVar = this.e;
                    if (uVar != null && (oVar = uVar.g) != null) {
                        oVar.n(true);
                        break;
                    }
                    break;
                case 4:
                    Log.d("UdpServer", "onMessageReceived: 新鼠标压枪");
                    com.bluetooth.cursor.w.u uVar2 = this.e;
                    if (uVar2 != null && (oVar2 = uVar2.g) != null) {
                        oVar2.p(true);
                        break;
                    }
                    break;
                case 5:
                    if (bArr.length <= 1) {
                        Log.e("UdpServer", "legacy drag packet ignored, length=" + bArr.length);
                        break;
                    } else {
                        l1.g(new Runnable() { // from class: com.bluetooth.cursor.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.e(bArr);
                            }
                        });
                        break;
                    }
                case 6:
                    if (bArr.length <= 1) {
                        Log.e("UdpServer", "gesture packet ignored, length=" + bArr.length);
                        break;
                    } else {
                        l1.g(new Runnable() { // from class: com.bluetooth.cursor.q
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.g(bArr);
                            }
                        });
                        break;
                    }
                case 7:
                    if (bArr.length < 9) {
                        Log.e("UdpServer", "wheel packet ignored, length=" + bArr.length);
                        break;
                    } else {
                        int i6 = byteBufferOrder.getInt();
                        int i7 = byteBufferOrder.getInt();
                        com.bluetooth.cursor.w.u uVar3 = this.e;
                        if (uVar3 != null && (oVar3 = uVar3.g) != null) {
                            oVar3.r((byte) a(i6), (byte) a(i7));
                            break;
                        }
                    }
                    break;
                case 8:
                    com.bluetooth.cursor.w.u uVar4 = this.e;
                    int iQ = uVar4 == null ? 3 : uVar4.q();
                    o(new byte[]{9, (byte) iQ}, inetAddress, i2);
                    final com.bluetooth.cursor.w.u uVar5 = this.e;
                    if (uVar5 != null && iQ != 2) {
                        Objects.requireNonNull(uVar5);
                        l1.g(new Runnable() { // from class: com.bluetooth.cursor.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                uVar5.o();
                            }
                        });
                        break;
                    }
                    break;
                default:
                    Log.e("UdpServer", "Unknown message type: " + ((int) b));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        DatagramSocket datagramSocket;
        try {
            try {
                DatagramSocket datagramSocket2 = new DatagramSocket((SocketAddress) null);
                this.c = datagramSocket2;
                datagramSocket2.setReuseAddress(true);
                this.c.bind(new InetSocketAddress(21115));
                byte[] bArr = new byte[1400];
                while (!Thread.currentThread().isInterrupted()) {
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 1400);
                    this.c.receive(datagramPacket);
                    int length = datagramPacket.getLength();
                    this.d = System.currentTimeMillis();
                    Log.d("UdpServer", "onMessageReceived: packet length=" + length + ", from=" + datagramPacket.getAddress().getHostAddress());
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(datagramPacket.getData(), 0, bArr2, 0, length);
                    l(bArr2, datagramPacket.getAddress(), datagramPacket.getPort());
                }
                datagramSocket = this.c;
            } catch (Exception e) {
                if (!Thread.currentThread().isInterrupted()) {
                    Log.e("UdpServer", "Error in UDP server", e);
                }
                DatagramSocket datagramSocket3 = this.c;
                if (datagramSocket3 != null && !datagramSocket3.isClosed()) {
                }
            }
            if (datagramSocket != null && !datagramSocket.isClosed()) {
                this.c.close();
            }
            this.c = null;
            Log.d("UdpServer", "UDP server stopped");
        } catch (Throwable th) {
            DatagramSocket datagramSocket4 = this.c;
            if (datagramSocket4 != null && !datagramSocket4.isClosed()) {
                this.c.close();
            }
            this.c = null;
            Log.d("UdpServer", "UDP server stopped");
            throw th;
        }
    }

    public static void n(final byte[] bArr, final String str, final int i2) {
        new Thread(new Runnable() { // from class: com.bluetooth.cursor.o
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                v.i(str, bArr, i2);
            }
        }).start();
    }

    public static void o(final byte[] bArr, final InetAddress inetAddress, final int i2) {
        new Thread(new Runnable() { // from class: com.bluetooth.cursor.r
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                v.h(bArr, inetAddress, i2);
            }
        }).start();
    }

    public long b() {
        return this.d;
    }

    public boolean c() {
        DatagramSocket datagramSocket = this.c;
        return (datagramSocket == null || datagramSocket.isClosed()) ? false : true;
    }

    public void p(com.bluetooth.cursor.w.u uVar) {
        this.e = uVar;
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f573i = options;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        this.b = this.a.submit(new Runnable() { // from class: com.bluetooth.cursor.p
            @Override // java.lang.Runnable
            public final void run() {
                this.c.m();
            }
        });
        Log.d("UdpServer", "start: UDP server started");
    }

    public void q() {
        Future<?> future = this.b;
        if (future != null) {
            future.cancel(true);
            this.b = null;
        }
        DatagramSocket datagramSocket = this.c;
        if (datagramSocket != null && !datagramSocket.isClosed()) {
            this.c.close();
        }
        this.a.shutdownNow();
    }
}

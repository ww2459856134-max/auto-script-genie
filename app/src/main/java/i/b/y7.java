package i.b;

import android.content.Intent;
import android.view.View;
import com.bluetooth.cursor.BluetoothHidClientAct;
import com.v.FloatToast;
import com.yl.float_ui.DingMsgView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class y7 {
    private static long a;

    private static String a(String str, int i2) {
        return "正在连接ESP32 HID开发板，连接成功后将继续" + str + "。<br/><br/>正在尝试重连：" + i2 + "/30<br/>剩余约：" + Math.max(0, (((30 - i2) + 1) * 3) / 2) + "秒<br/><br/>请确认ESP32已与本机蓝牙配对，且开发板与手机位于同一局域网。";
    }

    private static void b(DingMsgView dingMsgView) {
        if (dingMsgView != null) {
            try {
                com.frame.s0.g().o(dingMsgView);
                dingMsgView.c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(String str, Runnable runnable) {
        d(str, runnable, null);
    }

    public static void d(final String str, final Runnable runnable, final Runnable runnable2) {
        if (!da.B().O()) {
            if (runnable2 != null) {
                runnable2.run();
            }
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (!e()) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final AtomicReference atomicReference = new AtomicReference();
            com.frame.l1.e(new Runnable() { // from class: i.b.l1
                @Override // java.lang.Runnable
                public final void run() {
                    y7.h(atomicReference, str, atomicBoolean);
                }
            });
            com.frame.l1.g(new Runnable() { // from class: i.b.j1
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    y7.l(atomicBoolean, atomicReference, str, runnable2, runnable);
                }
            });
            return;
        }
        if (runnable2 != null) {
            runnable2.run();
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static boolean e() {
        return System.currentTimeMillis() - a < 5000;
    }

    static /* synthetic */ void g(View view) {
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) BluetoothHidClientAct.class);
        intent.addFlags(268435456);
        com.frame.v0.g().startActivity(intent);
    }

    static /* synthetic */ void h(AtomicReference atomicReference, String str, final AtomicBoolean atomicBoolean) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        atomicReference.set(dingMsgView);
        dingMsgView.l("ESP32 HID连接");
        dingMsgView.h(a(str, 1));
        dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                atomicBoolean.set(true);
            }
        });
        dingMsgView.k("查看设置", new View.OnClickListener() { // from class: i.b.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y7.g(view);
            }
        });
    }

    static /* synthetic */ void j(AtomicReference atomicReference, Runnable runnable, Runnable runnable2) {
        b((DingMsgView) atomicReference.get());
        if (runnable != null) {
            runnable.run();
        }
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    static /* synthetic */ void k(AtomicReference atomicReference, Runnable runnable, AtomicBoolean atomicBoolean) {
        b((DingMsgView) atomicReference.get());
        if (runnable != null) {
            runnable.run();
        }
        if (atomicBoolean.get()) {
            FloatToast.i("已取消HID连接");
        } else {
            FloatToast.i("ESP32 HID未连接，请检查开发板供电、蓝牙配对和局域网");
        }
    }

    static /* synthetic */ void l(final AtomicBoolean atomicBoolean, final AtomicReference atomicReference, final String str, final Runnable runnable, final Runnable runnable2) throws InterruptedException {
        final int i2 = 0;
        while (i2 < 30 && !atomicBoolean.get()) {
            i2++;
            com.frame.l1.e(new Runnable() { // from class: i.b.h1
                @Override // java.lang.Runnable
                public final void run() {
                    y7.m((DingMsgView) atomicReference.get(), str, i2);
                }
            });
            int iB = com.bluetooth.cursor.w.q.g().B(800);
            if (iB == 2) {
                a = System.currentTimeMillis();
                com.frame.l1.e(new Runnable() { // from class: i.b.g1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y7.j(atomicReference, runnable, runnable2);
                    }
                });
                return;
            } else {
                if (iB == 1) {
                    FloatToast.i("ESP32 HID连接中...");
                }
                try {
                    Thread.sleep(700L);
                } catch (InterruptedException unused) {
                }
            }
        }
        com.frame.l1.e(new Runnable() { // from class: i.b.m1
            @Override // java.lang.Runnable
            public final void run() {
                y7.k(atomicReference, runnable, atomicBoolean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(DingMsgView dingMsgView, String str, int i2) {
        if (dingMsgView != null) {
            dingMsgView.h(a(str, i2));
        }
    }
}

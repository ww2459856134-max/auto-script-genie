package i.b;

import android.content.DialogInterface;
import android.os.SystemClock;

/* loaded from: classes.dex */
class s7 implements DialogInterface.OnClickListener {
    final /* synthetic */ t7 c;

    s7(t7 t7Var) {
        this.c = t7Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        try {
            SystemClock.sleep(500L);
            if (this.c.o()) {
                da.B().B1("wuzhangai.mp4");
                this.c.A0(false);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.k0.r(e);
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        com.frame.k0.i("accessibility_alert_ok");
        com.permission.x0.m().a();
        com.frame.l1.g(new Runnable() { // from class: i.b.s
            @Override // java.lang.Runnable
            public final void run() {
                this.c.b();
            }
        });
    }
}

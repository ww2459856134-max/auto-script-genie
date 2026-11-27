package i.b;

import android.os.PowerManager;
import com.v.FloatHandlerRun;
import com.yl.model.Task;
import i.b.da;

/* loaded from: classes.dex */
class z9 implements da.a {
    final /* synthetic */ Task a;
    final /* synthetic */ PowerManager.WakeLock b;
    final /* synthetic */ aa c;

    z9(aa aaVar, Task task, PowerManager.WakeLock wakeLock) {
        this.c = aaVar;
        this.a = task;
        this.b = wakeLock;
    }

    @Override // i.b.da.a
    public void a() {
        if (this.a.isShowBar()) {
            ((FloatHandlerRun) com.frame.s0.g().h(FloatHandlerRun.class)).O();
        }
        i7.p().A(this.b);
        if (this.c.e.f1394m == null || !this.c.e.f1394m.isAutoOffscreen) {
            return;
        }
        this.c.e.j2();
    }

    @Override // i.b.da.a
    public void b() {
        i7.p().A(this.b);
    }
}

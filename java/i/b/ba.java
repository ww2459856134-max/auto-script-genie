package i.b;

import android.os.PowerManager;
import com.v.FloatHandler;
import com.v.FloatHandlerRun;
import com.yl.model.Task;
import i.b.da;

/* loaded from: classes.dex */
class ba implements da.a {
    final /* synthetic */ Task a;
    final /* synthetic */ PowerManager.WakeLock b;
    final /* synthetic */ da c;

    ba(da daVar, Task task, PowerManager.WakeLock wakeLock) {
        this.c = daVar;
        this.a = task;
        this.b = wakeLock;
    }

    @Override // i.b.da.a
    public void a() {
        if (this.a.isShowBar()) {
            ((FloatHandlerRun) com.frame.s0.g().h(FloatHandlerRun.class)).O();
        }
        com.frame.s0.g().u(FloatHandler.class);
        i7.p().A(this.b);
        if (this.b == null || this.c.f1394m == null || !this.c.f1394m.isAutoOffscreen) {
            return;
        }
        this.c.j2();
    }

    @Override // i.b.da.a
    public void b() {
        i7.p().A(this.b);
    }
}

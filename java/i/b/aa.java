package i.b;

import android.os.PowerManager;
import android.widget.RelativeLayout;
import com.yl.model.Task;
import i.b.da;
import org.json.JSONException;

/* loaded from: classes.dex */
class aa implements da.a {
    final /* synthetic */ long a;
    final /* synthetic */ RelativeLayout b;
    final /* synthetic */ Task c;
    final /* synthetic */ PowerManager.WakeLock d;
    final /* synthetic */ da e;

    aa(da daVar, long j2, RelativeLayout relativeLayout, Task task, PowerManager.WakeLock wakeLock) {
        this.e = daVar;
        this.a = j2;
        this.b = relativeLayout;
        this.c = task;
        this.d = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(long j2, Task task, PowerManager.WakeLock wakeLock) throws JSONException {
        if (this.e.S(j2)) {
            x7.d().b(1000L);
            if (this.e.S(j2)) {
                da.B().b2(task, null, this.e.M().isShowHandlerWithAutoRun, new z9(this, task, wakeLock), false);
            }
        }
    }

    @Override // i.b.da.a
    public void a() {
        if (this.e.S(this.a)) {
            final RelativeLayout relativeLayout = this.b;
            if (relativeLayout != null) {
                com.frame.l1.f(new Runnable() { // from class: i.b.j4
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.s0.g().o(relativeLayout);
                    }
                }, 300L);
            }
            final long j2 = this.a;
            final Task task = this.c;
            final PowerManager.WakeLock wakeLock = this.d;
            com.frame.l1.g(new Runnable() { // from class: i.b.l4
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.c.e(j2, task, wakeLock);
                }
            });
        }
    }

    @Override // i.b.da.a
    public void b() {
        final RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            com.frame.l1.f(new Runnable() { // from class: i.b.k4
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().o(relativeLayout);
                }
            }, 300L);
        }
        i7.p().A(this.d);
    }
}

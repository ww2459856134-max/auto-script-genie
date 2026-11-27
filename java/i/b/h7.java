package i.b;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import com.user.AccountTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/* loaded from: classes.dex */
final class h7 {

    /* renamed from: h, reason: collision with root package name */
    private static final long f1398h;
    private final Handler a;
    private List<g7> c;
    private long d;
    private int e;
    private AccessibilityService f;
    private final List<g7> b = new ArrayList();
    private final Runnable g = new Runnable() { // from class: i.b.e
        @Override // java.lang.Runnable
        public final void run() {
            this.c.k();
        }
    };

    static {
        f1398h = Build.VERSION.SDK_INT == 30 ? 1050L : 350L;
    }

    h7() {
        HandlerThread handlerThread = new HandlerThread("accessibility-screenshot");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i2, List<g7> list, Bitmap bitmap, String str) {
        if (i2 != this.e || this.c != list) {
            return;
        }
        Iterator<g7> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.c = null;
                this.e++;
                s();
                return;
            } else {
                g7 next = it.next();
                if (next.b()) {
                    next.a();
                } else {
                    next.c(bitmap != null ? bitmap.copy(Bitmap.Config.ARGB_8888, false) : null, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.b.removeIf(new Predicate() { // from class: i.b.c7
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((g7) obj).b();
            }
        });
        if (this.b.isEmpty() || this.c != null) {
            return;
        }
        if (!AccountTool.d().m()) {
            Iterator<g7> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().c(null, i9.v().u());
            }
            this.b.clear();
            return;
        }
        final ArrayList arrayList = new ArrayList(this.b);
        this.b.clear();
        this.c = arrayList;
        final int i2 = this.e + 1;
        this.e = i2;
        this.d = SystemClock.uptimeMillis();
        Runnable runnable = new Runnable() { // from class: i.b.d
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q(i2, arrayList);
            }
        };
        this.a.postDelayed(runnable, 1500L);
        try {
            AccessibilityService accessibilityService = this.f;
            final Handler handler = this.a;
            Objects.requireNonNull(handler);
            accessibilityService.takeScreenshot(0, new Executor() { // from class: i.b.d7
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable2) {
                    handler.post(runnable2);
                }
            }, new f7(this, runnable, i2, arrayList));
        } catch (RuntimeException e) {
            Log.e("AccessibilityCapture", "Screenshot request failed", e);
            this.a.removeCallbacks(runnable);
            j(i2, arrayList, null, "无障碍截图不可用，请重新开启无障碍服务");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m() {
        this.e++;
        this.a.removeCallbacks(this.g);
        Iterator<g7> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.b.clear();
        List<g7> list = this.c;
        if (list != null) {
            Iterator<g7> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(g7 g7Var, AccessibilityService accessibilityService) {
        if (g7Var.b()) {
            g7Var.a();
            return;
        }
        this.f = accessibilityService;
        this.b.add(g7Var);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(int i2, List list) {
        j(i2, list, null, "无障碍截图响应超时");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.c != null || this.b.isEmpty()) {
            return;
        }
        this.a.removeCallbacks(this.g);
        this.a.postAtTime(this.g, Math.max(SystemClock.uptimeMillis(), this.d + f1398h));
    }

    void h() {
        this.a.post(new Runnable() { // from class: i.b.c
            @Override // java.lang.Runnable
            public final void run() {
                this.c.m();
            }
        });
    }

    g7 i(final AccessibilityService accessibilityService, long j2, t9 t9Var) {
        final g7 g7Var = new g7(j2, t9Var);
        this.a.post(new Runnable() { // from class: i.b.f
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o(g7Var, accessibilityService);
            }
        });
        while (true) {
            try {
                if (g7Var.a.await(25L, TimeUnit.MILLISECONDS)) {
                    break;
                }
                if (g7Var.b()) {
                    g7Var.a();
                    break;
                }
            } catch (InterruptedException unused) {
                g7Var.a();
                Thread.currentThread().interrupt();
            }
        }
        if (g7Var.b()) {
            g7Var.a();
        }
        return g7Var;
    }
}

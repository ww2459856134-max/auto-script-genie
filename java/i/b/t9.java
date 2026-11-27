package i.b;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.v.FloatHandlerRun;
import com.v.GesturePlayFloatView;
import com.v.ProgressBar;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONException;
import org.opencv.core.Mat;

/* loaded from: classes.dex */
public class t9 implements Runnable {
    private static final ThreadLocal<t9> H = new ThreadLocal<>();
    private int A;
    private volatile boolean d;
    private volatile boolean e;
    private int g;

    /* renamed from: i, reason: collision with root package name */
    private Node f1548i;

    /* renamed from: j, reason: collision with root package name */
    private LinkedList<Node> f1549j;

    /* renamed from: k, reason: collision with root package name */
    private Task f1550k;
    private da.a t;
    private volatile boolean c = true;
    private final Object f = new Object();

    /* renamed from: h, reason: collision with root package name */
    private final x7 f1547h = x7.f();
    private boolean C = true;
    private final o.a.c D = new o.a.c();
    private final q9 G = new q9();

    public t9(Task task) {
        this.f1550k = task;
        if (task == null || TextUtils.isEmpty(task.getName())) {
            com.frame.y0.j("new TaskRunThread");
            return;
        }
        com.frame.y0.j("开启新任务线程:" + task.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() throws JSONException {
        da.B().x1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F() throws JSONException {
        da.B().x1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J() throws JSONException {
        da.B().x1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L() throws InterruptedException {
        G(this.f1548i, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N() throws JSONException {
        da.B().x1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P() throws InterruptedException {
        G(this.f1548i, this);
    }

    private void T(final Node node) {
        final Task task = this.f1550k;
        if (task == null || !task.isShowBar() || node == null) {
            return;
        }
        com.frame.l1.c(1027348, new Runnable() { // from class: i.b.q3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.x(task, node);
            }
        }, 0L);
    }

    public static t9 d() {
        return H.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Task task) {
        if (this.c && this.f1550k == task) {
            com.frame.s0.g().E(GesturePlayFloatView.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Task task, Node node) {
        if (this.f1550k == task && task.isShowBar()) {
            try {
                ((FloatHandlerRun) com.frame.s0.g().h(FloatHandlerRun.class)).R(node, task.getNodeMap().size());
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(Runnable runnable) {
        ThreadLocal<t9> threadLocal = H;
        threadLocal.set(this);
        try {
            if (this.c && !this.d) {
                runnable.run();
            }
            threadLocal.remove();
            synchronized (this.f) {
                this.g--;
                this.f.notifyAll();
            }
        } catch (Throwable th) {
            H.remove();
            synchronized (this.f) {
                this.g--;
                this.f.notifyAll();
                throw th;
            }
        }
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void H(Node node, Runnable runnable) throws InterruptedException {
        if (this.c) {
            if (this.f1549j == null) {
                this.f1549j = new LinkedList<>();
            }
            this.f1549j.add(node);
            while (this.f1549j.size() > 200) {
                this.f1549j.removeFirst();
            }
            this.f1548i = node;
            da.B().Q1(this);
            if (!com.frame.s0.g().m(GesturePlayFloatView.class)) {
                final Task task = this.f1550k;
                com.frame.l1.c(1027349, new Runnable() { // from class: i.b.s3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.v(task);
                    }
                }, 0L);
            }
            if (node.getDelay() > 0 && this.c) {
                e(node.getDelay());
            }
            try {
                T(node);
                if (this.c) {
                    s(node, runnable);
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    public synchronized o.a.e R(Mat mat, Bitmap bitmap, double d) {
        if (this.c) {
            return this.D.a(mat, bitmap, d);
        }
        return new o.a.e(-1, -1);
    }

    public void S(Long l2) {
        com.frame.y0.j("跳转失败，未找到节点id：" + l2);
        da.B().w1("未找到节点id：" + l2);
        da.B().h2();
    }

    public void U(long j2, Runnable runnable) {
        Node node = this.f1550k.getNodeMap().get(Long.valueOf(j2));
        if (node == null) {
            S(Long.valueOf(j2));
        } else {
            V(node, runnable);
        }
    }

    public void V(final Node node, final Runnable runnable) {
        if (node == null) {
            com.frame.y0.j("跳转失败，节点=null");
            da.B().h2();
            return;
        }
        while (node.invalid) {
            if (node.nextId == 0) {
                com.frame.l1.e(new Runnable() { // from class: i.b.z3
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.c.B();
                    }
                });
                return;
            }
            Node node2 = this.f1550k.getNodeMap().get(Long.valueOf(node.nextId));
            if (node2 == null) {
                com.frame.y0.j("跳转失败，未找到【" + node.getName() + "】的下个节点");
                da.B().w1("跳转失败，未找到【" + node.getName() + "】的下个节点");
                da.B().h2();
                return;
            }
            node = node2;
        }
        W(new Runnable() { // from class: i.b.y3
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.c.D(node, runnable);
            }
        });
    }

    public void W(final Runnable runnable) {
        if (runnable != null && this.c) {
            synchronized (this.f) {
                this.g++;
            }
            com.frame.l1.g(new Runnable() { // from class: i.b.v3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.z(runnable);
                }
            });
        }
    }

    public void X(Runnable runnable) {
        ArrayList arrayList = new ArrayList(this.f1550k.getNodeMap().values());
        if (!arrayList.isEmpty()) {
            V((Node) arrayList.get(0), runnable);
            return;
        }
        da.B().w1("任务(" + this.f1550k.getName() + ")没有节点");
    }

    public void Y(Node node, final Runnable runnable) {
        Task task;
        if (node == null) {
            return;
        }
        if (node.nextId == 0 || (task = this.f1550k) == null || task.getNodeMap() == null) {
            com.frame.l1.e(new Runnable() { // from class: i.b.u3
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.c.J();
                }
            });
            return;
        }
        final Node node2 = this.f1550k.getNodeMap().get(Long.valueOf(node.nextId));
        if (node2 == null) {
            S(Long.valueOf(node.nextId));
            return;
        }
        while (node2.invalid) {
            if (node2.nextId == 0) {
                com.frame.l1.e(new Runnable() { // from class: i.b.p3
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.c.F();
                    }
                });
                return;
            }
            node2 = this.f1550k.getNodeMap().get(Long.valueOf(node2.nextId));
            if (node2 == null) {
                S(Long.valueOf(node.nextId));
                return;
            }
        }
        try {
            W(new Runnable() { // from class: i.b.t3
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.c.H(node2, runnable);
                }
            });
        } catch (Exception e) {
            com.frame.y0.l(e);
        }
    }

    public void Z(Runnable runnable) {
        Y(this.f1548i, runnable);
    }

    public void a(Path path, ArrayList<Integer> arrayList) {
        for (int i2 = 0; i2 < arrayList.size() / 2; i2++) {
            int i3 = i2 * 2;
            int iAbs = Math.abs(arrayList.get(i3).intValue());
            int iAbs2 = Math.abs(arrayList.get(i3 + 1).intValue());
            if (path.isEmpty()) {
                path.moveTo(iAbs, iAbs2);
            } else {
                path.lineTo(arrayList.get(i3).intValue(), arrayList.get(r3).intValue());
            }
        }
    }

    public q8 a0(String str, String str2, String str3, Bitmap bitmap) throws Exception {
        if (this.c) {
            return this.G.l(str, str2, str3, bitmap);
        }
        throw new IllegalStateException("任务已停止");
    }

    public boolean b(long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis() + j2;
        synchronized (this.f) {
            while (this.g > 0) {
                long jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis();
                if (jCurrentTimeMillis2 <= 0) {
                    return false;
                }
                try {
                    this.f.wait(jCurrentTimeMillis2);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            return true;
        }
    }

    public synchronized boolean b0() {
        if (this.c && !this.d) {
            this.d = true;
            return true;
        }
        return false;
    }

    public synchronized void c() {
        if (this.d) {
            this.e = true;
        }
    }

    public void c0() {
        com.frame.y0.j("TaskRunThread.resume");
        this.c = true;
        if (this.f1548i != null) {
            W(new Runnable() { // from class: i.b.o3
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.c.L();
                }
            });
        }
    }

    public void d0(boolean z) {
        this.C = z;
    }

    public void e(long j2) throws InterruptedException {
        if (j2 > 0) {
            if (j2 > 500) {
                try {
                    if (da.B().M().isShowTimeDown) {
                        ProgressBar.h((int) j2);
                    }
                } catch (InterruptedException e) {
                    com.frame.k0.r(e);
                    return;
                }
            }
            if (j2 < 1000) {
                Thread.sleep(j2);
                return;
            }
            long j3 = j2 / 1000;
            for (int i2 = 0; i2 < j3; i2++) {
                Thread.sleep(1000L);
            }
            Thread.sleep(j2 % 1000);
        }
    }

    public void e0(Node node) {
        this.f1548i = node;
    }

    public void f(Node node, final AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        a(path, node.pathPoints);
        if (path.isEmpty()) {
            com.frame.y0.j("滑动path为空");
            gestureResultCallback.onCancelled(null);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && da.B().O()) {
            long duration = node.getDuration();
            com.bluetooth.cursor.w.q.g().D(node.pathPoints, duration);
            com.frame.l1.f(new Runnable() { // from class: i.b.w3
                @Override // java.lang.Runnable
                public final void run() {
                    gestureResultCallback.onCompleted(null);
                }
            }, Math.max(80L, duration + 200));
        } else {
            if (com.frame.w0.b() == null) {
                gestureResultCallback.onCancelled(null);
                return;
            }
            try {
                com.frame.w0.b().dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, node.getDuration())).build(), gestureResultCallback, null);
            } catch (Exception e) {
                com.frame.k0.r(e);
                gestureResultCallback.onCancelled(null);
            }
        }
    }

    void f0(int i2) {
        this.A = i2;
    }

    public void g() {
        W(this);
    }

    public void g0(boolean z) {
        this.c = z;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void t(final Node node, final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            W(new Runnable() { // from class: i.b.a4
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.t(node, runnable);
                }
            });
            return;
        }
        ThreadLocal<t9> threadLocal = H;
        t9 t9Var = threadLocal.get();
        threadLocal.set(this);
        try {
            if (node == null) {
                if (runnable != null) {
                    runnable.run();
                }
                this.c = false;
                if (t9Var == null) {
                    threadLocal.remove();
                    return;
                } else {
                    threadLocal.set(t9Var);
                    return;
                }
            }
            i.b.ka.x5 x5VarK = k(node.type);
            if (x5VarK != null) {
                try {
                    if (!this.c) {
                        if (t9Var == null) {
                            threadLocal.remove();
                            return;
                        } else {
                            threadLocal.set(t9Var);
                            return;
                        }
                    }
                    Task task = this.f1550k;
                    if (task == null) {
                        com.frame.k0.r(new IllegalStateException("脚本任务为空"));
                        da.B().w1("脚本执行错误：脚本任务为空");
                        if (runnable != null) {
                            runnable.run();
                        } else {
                            this.c = false;
                        }
                        if (t9Var == null) {
                            threadLocal.remove();
                            return;
                        } else {
                            threadLocal.set(t9Var);
                            return;
                        }
                    }
                    x5VarK.o(this, task.getNodeMap(), node, runnable);
                    if (runnable == null) {
                        this.c = false;
                    }
                } catch (Exception e) {
                    da.B().w1("脚本执行错误，请联系技术小哥。" + e.getMessage());
                    com.frame.y0.l(e);
                }
            } else {
                String str = "未注册的动作类型(type=" + node.type + ")";
                com.frame.k0.r(new IllegalArgumentException(str));
                da.B().w1("脚本执行错误：" + str);
                if (runnable != null) {
                    runnable.run();
                } else {
                    this.c = false;
                }
            }
        } finally {
            if (t9Var == null) {
                H.remove();
            } else {
                H.set(t9Var);
            }
        }
    }

    public void h0(da.a aVar) {
        this.t = aVar;
    }

    public Node i() {
        return this.f1548i;
    }

    public void i0() {
        j0(this.f1550k.getNodeMap().values().iterator().next());
    }

    int j() {
        return this.A;
    }

    public void j0(Node node) {
        k0(node, 0);
    }

    public i.b.ka.x5 k(int i2) {
        return this.f1547h.e(i2);
    }

    void k0(Node node, int i2) {
        Node node2;
        Node node3;
        this.A = i2;
        this.f1549j = new LinkedList<>();
        if (node != null) {
            this.f1548i = node;
        } else {
            if (this.f1550k.getNodeMap().isEmpty()) {
                com.frame.y0.j("该任务没有节点，请先检查任务～");
                da.B().w1("该任务没有节点，请先检查任务～");
                da.B().h2();
                return;
            }
            this.f1548i = this.f1550k.getNodeMap().values().iterator().next();
        }
        if (this.f1548i == null) {
            com.frame.y0.j("startGesture:没有节点");
            return;
        }
        do {
            node2 = this.f1548i;
            if (!node2.invalid) {
                da.B().Q1(this);
                W(new Runnable() { // from class: i.b.x3
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.c.P();
                    }
                });
                return;
            } else if (node2.nextId == 0) {
                com.frame.l1.e(new Runnable() { // from class: i.b.r3
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.c.N();
                    }
                });
                return;
            } else {
                node3 = this.f1550k.getNodeMap().get(Long.valueOf(this.f1548i.nextId));
                this.f1548i = node3;
            }
        } while (node3 != null);
        com.frame.y0.j("跳转失败，未找到【" + node2.getName() + "】的下个节点");
        da.B().w1("跳转失败，未找到【" + node2.getName() + "】的下个节点");
        da.B().h2();
    }

    public Task l() {
        return this.f1550k;
    }

    public synchronized void l0() {
        this.c = false;
        this.D.b();
        final q9 q9Var = this.G;
        Objects.requireNonNull(q9Var);
        com.frame.l1.g(new Runnable() { // from class: i.b.y6
            @Override // java.lang.Runnable
            public final void run() {
                q9Var.n();
            }
        });
        if (this.f1550k != null) {
            com.frame.y0.j(this.f1550k.getName() + "：停止当前任务线程");
        }
    }

    public da.a m() {
        return this.t;
    }

    public boolean n() {
        return this.e;
    }

    public boolean o() {
        return this.d;
    }

    public boolean p() {
        return this.C;
    }

    public boolean q() {
        return this.c;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c) {
            Node node = this.f1548i;
            if (node == null) {
                com.frame.y0.j("执行下一步出错，未找到mLastNode");
                return;
            }
            int i2 = node.repeatCount;
            if (i2 != -1 && (i2 <= 1 || i2 <= this.A + 1)) {
                this.A = 0;
                Y(node, this);
                return;
            }
            this.A++;
            com.frame.y0.m("「" + this.f1548i.getStepAndName() + "」节点循环执行:第<big><strong>" + (this.A + 1) + "</strong></big>次");
            V(this.f1548i, this);
        }
    }
}

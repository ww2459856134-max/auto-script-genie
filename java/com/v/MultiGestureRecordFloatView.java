package com.v;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.v.FingerLine;
import com.v.MultiGestureRecordFloatView;
import com.yl.model.GesturePath;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public class MultiGestureRecordFloatView extends FrameLayout {
    private static final int[] M = {Color.parseColor("#E53935"), Color.parseColor("#1E88E5"), Color.parseColor("#43A047"), Color.parseColor("#FB8C00"), Color.parseColor("#8E24AA"), Color.parseColor("#00ACC1")};
    private float A;
    private float C;
    private final LinkedHashMap<Integer, Point> D;
    private Node G;
    boolean H;
    private int I;
    private lt J;
    private final Choreographer.FrameCallback K;
    private Paint c;
    private Paint d;
    private Paint e;
    private Paint f;
    private final LinkedHashMap<Integer, GesturePath> g;

    /* renamed from: h, reason: collision with root package name */
    private final LinkedHashMap<Integer, b> f990h;

    /* renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f991i;

    /* renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f992j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f993k;
    private long t;

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {
        float a;
        float b;
        float c;
        float d;
        int e;
        int f;
        final ArrayList<e> g;

        /* renamed from: h, reason: collision with root package name */
        final CopyOnWriteArrayList<d> f994h;

        private b() {
            this.g = new ArrayList<>();
            this.f994h = new CopyOnWriteArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c {
        final float a;
        final float b;
        final long c = SystemClock.uptimeMillis();
        final int d;

        c(float f, float f2, int i2) {
            this.a = f;
            this.b = f2;
            this.d = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class d {
        final FingerLine.b a;
        final long b;

        d(FingerLine.b bVar, long j2) {
            this.a = bVar;
            this.b = j2;
        }
    }

    private static final class e {
        final float a;
        final float b;
        final long c;

        e(float f, float f2, long j2) {
            this.a = f;
            this.b = f2;
            this.c = j2;
        }
    }

    public MultiGestureRecordFloatView() {
        super(com.frame.v0.g());
        this.g = new LinkedHashMap<>();
        this.f990h = new LinkedHashMap<>();
        this.f991i = new CopyOnWriteArrayList<>();
        this.f992j = new CopyOnWriteArrayList<>();
        this.D = new LinkedHashMap<>();
        this.I = Integer.MAX_VALUE;
        this.K = new Choreographer.FrameCallback() { // from class: com.v.pc
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.c.n(j2);
            }
        };
        setBackgroundColor(-16777216);
        setAlpha(0.3f);
    }

    private void A() {
        i();
        Node node = this.G;
        if (node == null) {
            this.t = System.currentTimeMillis();
            Node nodeQ = i.b.v8.m().Q();
            this.G = nodeQ;
            nodeQ.type = 26;
            nodeQ.duration = 500L;
        } else {
            node.duration = System.currentTimeMillis() - this.t;
        }
        Node node2 = this.G;
        node2.nextType = 2;
        node2.paths = new ArrayList<>();
        for (GesturePath gesturePath : this.g.values()) {
            if (gesturePath != null) {
                this.G.paths.add(gesturePath);
            }
        }
        if (this.G.paths.size() == 1) {
            GesturePath gesturePath2 = this.G.paths.get(0);
            if (this.H) {
                this.G.type = 2;
            } else {
                this.G.type = 1;
            }
            Node node3 = this.G;
            ArrayList<Integer> arrayList = gesturePath2.points;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            node3.pathPoints = arrayList;
        } else {
            this.G.type = 26;
        }
        i.b.v8.m().X(this.G);
        F(new Runnable() { // from class: com.v.ec
            @Override // java.lang.Runnable
            public final void run() {
                this.c.t();
            }
        });
    }

    private void B(int i2) {
        b bVarRemove = this.f990h.remove(Integer.valueOf(i2));
        if (bVarRemove != null && !bVarRemove.f994h.isEmpty()) {
            this.f991i.add(bVarRemove);
            L();
        }
        if (this.f990h.isEmpty() && this.f991i.isEmpty() && this.f992j.isEmpty()) {
            M();
        }
    }

    private void C(int i2, float f, float f2, boolean z) {
        b bVar = this.f990h.get(Integer.valueOf(i2));
        if (bVar == null) {
            bVar = new b();
            bVar.e = b(i2);
            bVar.c = f;
            bVar.d = f2;
            this.f990h.put(Integer.valueOf(i2), bVar);
            this.f992j.add(new c(f, f2, bVar.e));
        } else if (z) {
            this.f992j.add(new c(f, f2, bVar.e));
        }
        bVar.a = f;
        bVar.b = f2;
        bVar.g.add(new e(f, f2, SystemClock.uptimeMillis()));
        while (bVar.g.size() > 14) {
            bVar.g.remove(0);
        }
        L();
    }

    private void D() {
        this.t = System.currentTimeMillis();
        Node nodeQ = i.b.v8.m().Q();
        this.G = nodeQ;
        nodeQ.type = 26;
        this.H = false;
        this.D.clear();
        a();
    }

    public static void E() {
        F(null);
    }

    public static void F(final Runnable runnable) {
        final MultiGestureRecordFloatView multiGestureRecordFloatView = (MultiGestureRecordFloatView) com.frame.s0.g().f(MultiGestureRecordFloatView.class);
        if (multiGestureRecordFloatView != null) {
            com.frame.l1.e(new Runnable() { // from class: com.v.hc
                @Override // java.lang.Runnable
                public final void run() {
                    MultiGestureRecordFloatView.v(this.c, runnable);
                }
            });
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public static void G(final Node node, final long j2) {
        if (node != null) {
            F(new Runnable() { // from class: com.v.kc
                @Override // java.lang.Runnable
                public final void run() {
                    MultiGestureRecordFloatView.y(j2, node);
                }
            });
        } else {
            com.frame.k0.r(new IllegalArgumentException("pauseAndResume: node is null"));
            c(j2 + 200);
        }
    }

    private static boolean H(b bVar, final long j2) {
        return FingerLine.q(bVar.f994h, new Predicate() { // from class: com.v.oc
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MultiGestureRecordFloatView.z(j2, (MultiGestureRecordFloatView.d) obj);
            }
        });
    }

    private static void I(b bVar, long j2) {
        Iterator<e> it = bVar.g.iterator();
        while (it.hasNext()) {
            if (j2 - it.next().c > 420) {
                it.remove();
            }
        }
    }

    private void J(int i2, int i3, int i4) {
        this.D.put(Integer.valueOf(i2), new Point(i3, i4));
    }

    private Point K(MotionEvent motionEvent, int i2) {
        Point point;
        Point point2;
        int pointerCount = motionEvent.getPointerCount();
        if (i2 >= 0 && pointerCount > 0 && i2 < pointerCount) {
            int pointerId = motionEvent.getPointerId(i2);
            int x = (int) motionEvent.getX(i2);
            int y = (int) motionEvent.getY(i2);
            return (x == 0 && y == 0 && (point2 = this.D.get(Integer.valueOf(pointerId))) != null) ? point2 : new Point(x, y);
        }
        if (pointerCount <= 0) {
            return new Point(0, 0);
        }
        int pointerId2 = motionEvent.getPointerId(0);
        int x2 = (int) motionEvent.getX(0);
        int y2 = (int) motionEvent.getY(0);
        return (x2 == 0 && y2 == 0 && (point = this.D.get(Integer.valueOf(pointerId2))) != null) ? point : new Point(x2, y2);
    }

    private void L() {
        if (this.f993k) {
            return;
        }
        this.f993k = true;
        Choreographer.getInstance().postFrameCallback(this.K);
    }

    private void M() {
        this.f993k = false;
        Choreographer.getInstance().removeFrameCallback(this.K);
    }

    private void N(int i2, GesturePath gesturePath) {
        ArrayList<Integer> arrayList;
        b bVar = this.f990h.get(Integer.valueOf(i2));
        if (bVar == null || gesturePath == null || (arrayList = gesturePath.points) == null) {
            return;
        }
        List<FingerLine.b> listB = FingerLine.b(arrayList);
        while (bVar.f < listB.size()) {
            bVar.f994h.add(new d(listB.get(bVar.f), SystemClock.uptimeMillis()));
            bVar.f++;
        }
    }

    private void a() {
        this.f990h.clear();
        this.f991i.clear();
        this.f992j.clear();
        M();
    }

    private int b(int i2) {
        int[] iArr = M;
        return iArr[Math.abs(i2) % iArr.length];
    }

    public static void c(long j2) {
        com.frame.l1.f(new Runnable() { // from class: com.v.dc
            @Override // java.lang.Runnable
            public final void run() {
                MultiGestureRecordFloatView.j();
            }
        }, j2);
    }

    private void d(Canvas canvas, b bVar) {
        float f = bVar.c;
        float f2 = bVar.d;
        float fC = com.frame.p1.c(16.0f);
        float fC2 = com.frame.p1.c(5.0f);
        this.d.setShader(new RadialGradient(f, f2, fC, new int[]{Color.argb(90, Color.red(bVar.e), Color.green(bVar.e), Color.blue(bVar.e)), 0}, new float[]{0.25f, 1.0f}, Shader.TileMode.CLAMP));
        canvas.drawCircle(f, f2, fC, this.d);
        this.d.setShader(null);
        this.d.setColor(-1);
        this.d.setAlpha(230);
        canvas.drawCircle(f, f2, fC2, this.d);
        this.d.setColor(bVar.e);
        this.d.setAlpha(255);
        canvas.drawCircle(f, f2, 0.55f * fC2, this.d);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setColor(-1);
        this.f.setAlpha(160);
        this.f.setStrokeWidth(com.frame.p1.c(1.5f));
        canvas.drawCircle(f, f2, fC2 + com.frame.p1.c(3.0f), this.f);
        float fC3 = com.frame.p1.c(7.0f);
        this.f.setAlpha(100);
        this.f.setStrokeWidth(com.frame.p1.c(1.0f));
        canvas.drawLine(f - fC3, f2, f + fC3, f2, this.f);
        canvas.drawLine(f, f2 - fC3, f, f2 + fC3, this.f);
    }

    private void e(Canvas canvas, b bVar) {
        if (bVar.f994h.isEmpty()) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int size = bVar.f994h.size();
        int i2 = 0;
        Iterator<d> it = bVar.f994h.iterator();
        while (it.hasNext()) {
            d next = it.next();
            float f = (jUptimeMillis - next.b) / 400.0f;
            if (f < 1.0f) {
                this.c.setColor(bVar.e);
                FingerLine.a(this.c, 1.0f - f, (i2 + 1.0f) / size);
                FingerLine.f(canvas, this.c, next.a);
            }
            i2++;
        }
    }

    private void f(Canvas canvas) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float fC = com.frame.p1.c(30.0f);
        Iterator<c> it = this.f992j.iterator();
        while (it.hasNext()) {
            c next = it.next();
            float f = (jUptimeMillis - next.c) / 380.0f;
            if (f < 1.0f) {
                this.f.setColor(next.d);
                this.f.setAlpha((int) ((1.0f - f) * 120.0f));
                this.f.setStrokeWidth(com.frame.p1.c(2.0f) * (1.0f - (f * 0.5f)));
                canvas.drawCircle(next.a, next.b, fC * f, this.f);
            }
        }
    }

    private void g(Canvas canvas, b bVar) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        int size = bVar.g.size();
        if (size <= 1) {
            return;
        }
        float fC = com.frame.p1.c(4.0f);
        for (int i2 = 0; i2 < size - 1; i2++) {
            e eVar = bVar.g.get(i2);
            float f = (jUptimeMillis - eVar.c) / 420.0f;
            if (f < 1.0f) {
                float f2 = (1.0f - f) * 0.55f;
                this.e.setColor(bVar.e);
                this.e.setAlpha((int) (255.0f * f2));
                canvas.drawCircle(eVar.a, eVar.b, (f2 + 0.45f) * fC, this.e);
            }
        }
    }

    private void h() {
        if (this.d == null) {
            Paint paint = new Paint(1);
            this.d = paint;
            paint.setStyle(Paint.Style.FILL);
        }
        if (this.e == null) {
            Paint paint2 = new Paint(1);
            this.e = paint2;
            paint2.setStyle(Paint.Style.FILL);
        }
        if (this.f == null) {
            Paint paint3 = new Paint(1);
            this.f = paint3;
            paint3.setStyle(Paint.Style.STROKE);
            this.f.setStrokeCap(Paint.Cap.ROUND);
        }
        if (this.c == null) {
            Paint paint4 = new Paint(1);
            this.c = paint4;
            paint4.setStyle(Paint.Style.STROKE);
            this.c.setStrokeCap(Paint.Cap.ROUND);
            this.c.setStrokeJoin(Paint.Join.ROUND);
        }
    }

    private void i() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.t;
        long clickDuration = i.b.da.B().M().getClickDuration();
        for (GesturePath gesturePath : this.g.values()) {
            if (gesturePath.duration <= 0) {
                gesturePath.duration = Math.max(clickDuration, jCurrentTimeMillis - gesturePath.startTime);
            }
            ArrayList<Integer> arrayList = gesturePath.points;
            if (arrayList != null && arrayList.size() == 2) {
                gesturePath.lineTo(gesturePath.points.get(0).intValue(), gesturePath.points.get(1).intValue());
            }
        }
    }

    static /* synthetic */ void j() {
        MultiGestureRecordFloatView multiGestureRecordFloatView = (MultiGestureRecordFloatView) com.frame.s0.g().f(MultiGestureRecordFloatView.class);
        if (multiGestureRecordFloatView != null) {
            multiGestureRecordFloatView.setVisibility(0);
        }
    }

    static /* synthetic */ boolean k(long j2, b bVar) {
        H(bVar, j2);
        return bVar.f994h.isEmpty();
    }

    static /* synthetic */ boolean l(long j2, c cVar) {
        return j2 - cVar.c >= 380;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void n(long j2) {
        boolean z;
        boolean z2 = false;
        this.f993k = false;
        final long jUptimeMillis = SystemClock.uptimeMillis();
        Iterator<b> it = this.f990h.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            float f = next.a - next.c;
            float f2 = next.b - next.d;
            if (Math.abs(f) > 0.5f || Math.abs(f2) > 0.5f) {
                next.c += f * 0.38f;
                next.d += f2 * 0.38f;
                z2 = true;
            } else {
                next.c = next.a;
                next.d = next.b;
            }
            I(next, jUptimeMillis);
            if (H(next, jUptimeMillis) || !next.f994h.isEmpty()) {
                z2 = true;
            }
        }
        FingerLine.q(this.f991i, new Predicate() { // from class: com.v.nc
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MultiGestureRecordFloatView.k(jUptimeMillis, (MultiGestureRecordFloatView.b) obj);
            }
        });
        if (!this.f991i.isEmpty()) {
            z2 = true;
        }
        if (!this.f992j.isEmpty()) {
            FingerLine.q(this.f992j, new Predicate() { // from class: com.v.mc
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return MultiGestureRecordFloatView.l(jUptimeMillis, (MultiGestureRecordFloatView.c) obj);
                }
            });
            z = this.f992j.isEmpty() ? z2 : true;
        }
        if (!z && this.f990h.isEmpty() && this.f991i.isEmpty() && this.f992j.isEmpty()) {
            return;
        }
        postInvalidate();
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        lt ltVar = this.J;
        if (ltVar != null) {
            ltVar.a(this.G);
        }
        if (com.frame.s0.g().f(FloatHandlerRecord.class) != null) {
            com.frame.s0.g().u(FloatHandlerRecord.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r() {
        try {
            try {
                SystemClock.sleep(80L);
                new i.b.t9(i.b.v8.m().p()).s(this.G, new Runnable() { // from class: com.v.gc
                    @Override // java.lang.Runnable
                    public final void run() {
                        MultiGestureRecordFloatView.u();
                    }
                });
                com.frame.l1.f(new Runnable() { // from class: com.v.lc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.p();
                    }
                }, this.G.duration + 200);
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        } finally {
            c(this.G.duration + 300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        com.frame.l1.g(new Runnable() { // from class: com.v.ic
            @Override // java.lang.Runnable
            public final void run() {
                this.c.r();
            }
        });
    }

    static /* synthetic */ void u() {
    }

    static /* synthetic */ void v(MultiGestureRecordFloatView multiGestureRecordFloatView, Runnable runnable) {
        multiGestureRecordFloatView.setVisibility(8);
        multiGestureRecordFloatView.post(runnable);
    }

    static /* synthetic */ void w(boolean[] zArr, long j2) {
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        c(j2);
    }

    static /* synthetic */ void x(Node node, Runnable runnable) {
        try {
            try {
                SystemClock.sleep(150L);
                new i.b.t9(i.b.v8.m().p()).s(node, runnable);
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        } finally {
            runnable.run();
        }
    }

    static /* synthetic */ void y(long j2, final Node node) {
        final long j3 = j2 + 200;
        final boolean[] zArr = {false};
        final Runnable runnable = new Runnable() { // from class: com.v.fc
            @Override // java.lang.Runnable
            public final void run() {
                MultiGestureRecordFloatView.w(zArr, j3);
            }
        };
        com.frame.l1.g(new Runnable() { // from class: com.v.jc
            @Override // java.lang.Runnable
            public final void run() {
                MultiGestureRecordFloatView.x(node, runnable);
            }
        });
    }

    static /* synthetic */ boolean z(long j2, d dVar) {
        return j2 - dVar.b >= 400;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        h();
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
        }
        canvas.drawColor(0);
        try {
            Iterator<b> it = this.f991i.iterator();
            while (it.hasNext()) {
                e(canvas, it.next());
            }
            Iterator<b> it2 = this.f990h.values().iterator();
            while (it2.hasNext()) {
                e(canvas, it2.next());
            }
            f(canvas);
            for (b bVar : this.f990h.values()) {
                g(canvas, bVar);
                d(canvas, bVar);
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        M();
        this.f990h.clear();
        this.f991i.clear();
        this.f992j.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0144  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            D();
            this.A = motionEvent.getRawX();
            this.C = motionEvent.getRawY();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                int pointerId = motionEvent.getPointerId(i2);
                int x = (int) motionEvent.getX(i2);
                int y = (int) motionEvent.getY(i2);
                J(pointerId, x, y);
                GesturePath gesturePath = this.g.get(Integer.valueOf(pointerId));
                if (gesturePath != null) {
                    gesturePath.moveTo(x, y);
                } else {
                    gesturePath = new GesturePath();
                    gesturePath.moveTo(x, y);
                    this.g.put(Integer.valueOf(pointerId), gesturePath);
                }
                C(pointerId, x, y, true);
                N(pointerId, gesturePath);
            }
            postInvalidate();
        } else if (action == 1) {
            postInvalidate();
            try {
                if (this.g.size() == 1 && this.H) {
                    int pointerId2 = motionEvent.getPointerCount() > 0 ? motionEvent.getPointerId(0) : -1;
                    GesturePath next = this.g.get(Integer.valueOf(pointerId2));
                    if (next == null && !this.g.isEmpty()) {
                        next = this.g.values().iterator().next();
                    }
                    if (next != null) {
                        Point pointK = K(motionEvent, 0);
                        next.lineTo(pointK.x, pointK.y);
                        N(pointerId2, next);
                    }
                }
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
            A();
            this.g.clear();
            this.D.clear();
            Iterator it = new ArrayList(this.f990h.keySet()).iterator();
            while (it.hasNext()) {
                B(((Integer) it.next()).intValue());
            }
            this.f992j.clear();
            L();
        } else if (action == 2) {
            if (!this.H && (Math.abs(motionEvent.getRawX() - this.A) > 6.0f || Math.abs(motionEvent.getRawY() - this.C) > 6.0f)) {
                this.H = true;
            }
            for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
                int pointerId3 = motionEvent.getPointerId(i3);
                int x2 = (int) motionEvent.getX(i3);
                int y2 = (int) motionEvent.getY(i3);
                J(pointerId3, x2, y2);
                GesturePath gesturePath2 = this.g.get(Integer.valueOf(pointerId3));
                if (gesturePath2 != null) {
                    gesturePath2.duration = (System.currentTimeMillis() - this.t) - gesturePath2.startTime;
                    float f = x2;
                    float f2 = y2;
                    gesturePath2.lineTo(f, f2);
                    C(pointerId3, f, f2, false);
                    N(pointerId3, gesturePath2);
                }
            }
            postInvalidate();
        } else if (action != 3) {
            if (action == 5) {
                for (int i4 = 0; i4 < motionEvent.getPointerCount(); i4++) {
                    int pointerId4 = motionEvent.getPointerId(i4);
                    int x3 = (int) motionEvent.getX(i4);
                    int y3 = (int) motionEvent.getY(i4);
                    J(pointerId4, x3, y3);
                    GesturePath gesturePath3 = this.g.get(Integer.valueOf(pointerId4));
                    if (gesturePath3 != null) {
                        gesturePath3.lineTo(x3, y3);
                        z = false;
                    } else {
                        gesturePath3 = new GesturePath();
                        gesturePath3.startTime = System.currentTimeMillis() - this.t;
                        gesturePath3.moveTo(x3, y3);
                        this.g.put(Integer.valueOf(pointerId4), gesturePath3);
                        z = true;
                    }
                    C(pointerId4, x3, y3, z);
                    N(pointerId4, gesturePath3);
                }
                postInvalidate();
            } else if (action == 6 && (actionIndex = motionEvent.getActionIndex()) >= 0 && actionIndex < motionEvent.getPointerCount()) {
                int pointerId5 = motionEvent.getPointerId(actionIndex);
                Point pointK2 = K(motionEvent, actionIndex);
                GesturePath gesturePath4 = this.g.get(Integer.valueOf(pointerId5));
                if (gesturePath4 != null) {
                    gesturePath4.duration = (System.currentTimeMillis() - this.t) - gesturePath4.startTime;
                    gesturePath4.lineTo(pointK2.x, pointK2.y);
                    N(pointerId5, gesturePath4);
                    LinkedHashMap<Integer, GesturePath> linkedHashMap = this.g;
                    int i5 = this.I;
                    this.I = i5 - 1;
                    linkedHashMap.put(Integer.valueOf(i5), gesturePath4);
                    this.g.remove(Integer.valueOf(pointerId5));
                    this.D.remove(Integer.valueOf(pointerId5));
                    B(pointerId5);
                }
                postInvalidate();
            }
        }
        return true;
    }

    public void setCallback(lt ltVar) {
        this.J = ltVar;
    }

    public MultiGestureRecordFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new LinkedHashMap<>();
        this.f990h = new LinkedHashMap<>();
        this.f991i = new CopyOnWriteArrayList<>();
        this.f992j = new CopyOnWriteArrayList<>();
        this.D = new LinkedHashMap<>();
        this.I = Integer.MAX_VALUE;
        this.K = new Choreographer.FrameCallback() { // from class: com.v.pc
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.c.n(j2);
            }
        };
    }

    public MultiGestureRecordFloatView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = new LinkedHashMap<>();
        this.f990h = new LinkedHashMap<>();
        this.f991i = new CopyOnWriteArrayList<>();
        this.f992j = new CopyOnWriteArrayList<>();
        this.D = new LinkedHashMap<>();
        this.I = Integer.MAX_VALUE;
        this.K = new Choreographer.FrameCallback() { // from class: com.v.pc
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.c.n(j2);
            }
        };
    }
}

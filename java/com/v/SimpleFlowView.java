package com.v;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.RelativeLayout;
import com.v.SimpleFlowView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SimpleFlowView extends RelativeLayout {
    public boolean A;
    public i.b.ia.b C;
    private GestureDetector c;
    private ScaleGestureDetector d;
    protected int e;
    protected int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1053h;

    /* renamed from: i, reason: collision with root package name */
    private i.b.ia.f f1054i;

    /* renamed from: j, reason: collision with root package name */
    private float f1055j;

    /* renamed from: k, reason: collision with root package name */
    private float f1056k;
    private float t;

    class a implements View.OnTouchListener {
        a() {
        }

        static /* synthetic */ void a(View view) {
            com.frame.s0.g().d(SimpleFlowView.class);
            com.frame.s0.g().d(DingMsgView.class);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getLocationInWindow(new int[2]);
            motionEvent.offsetLocation(r1[0], r1[1]);
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                SimpleFlowView simpleFlowView = SimpleFlowView.this;
                simpleFlowView.A = true;
                simpleFlowView.g = (int) motionEvent.getX();
                SimpleFlowView.this.f1053h = (int) motionEvent.getY();
            } else if (action == 1) {
                SimpleFlowView.this.A = false;
                if (rawX - view.getWidth() < 0 || rawX + view.getWidth() > com.frame.q1.e() || rawY + view.getHeight() > com.frame.q1.d()) {
                    DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                    dingMsgView.l("温馨提示");
                    dingMsgView.h("是否关闭流程图");
                    dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.jl
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            SimpleFlowView.a.a(view2);
                        }
                    });
                    dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.kl
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            com.frame.s0.g().d(DingMsgView.class);
                        }
                    });
                }
                SimpleFlowView.this.l();
            } else if (action == 2) {
                SimpleFlowView simpleFlowView2 = SimpleFlowView.this;
                simpleFlowView2.A = true;
                simpleFlowView2.e = rawY - simpleFlowView2.f1053h;
                SimpleFlowView simpleFlowView3 = SimpleFlowView.this;
                simpleFlowView3.f = rawX - simpleFlowView3.g;
                SimpleFlowView.this.s(r7.f, r7.e);
            }
            return true;
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            SimpleFlowView.this.k(motionEvent.getX(), motionEvent.getY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            SimpleFlowView.d(SimpleFlowView.this, f);
            SimpleFlowView.e(SimpleFlowView.this, f2);
            SimpleFlowView.this.postInvalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            SimpleFlowView.c(SimpleFlowView.this, scaleGestureDetector.getScaleFactor());
            SimpleFlowView simpleFlowView = SimpleFlowView.this;
            float f = 3.0f;
            if (simpleFlowView.t < 0.1d) {
                f = 0.1f;
            } else if (SimpleFlowView.this.t <= 3.0f) {
                f = SimpleFlowView.this.t;
            }
            simpleFlowView.t = f;
            SimpleFlowView.this.postInvalidate();
            return true;
        }
    }

    public SimpleFlowView() {
        super(com.frame.v0.g());
        this.t = 1.0f;
        n();
    }

    static /* synthetic */ float c(SimpleFlowView simpleFlowView, float f) {
        float f2 = simpleFlowView.t * f;
        simpleFlowView.t = f2;
        return f2;
    }

    static /* synthetic */ float d(SimpleFlowView simpleFlowView, float f) {
        float f2 = simpleFlowView.f1055j - f;
        simpleFlowView.f1055j = f2;
        return f2;
    }

    static /* synthetic */ float e(SimpleFlowView simpleFlowView, float f) {
        float f2 = simpleFlowView.f1056k - f;
        simpleFlowView.f1056k = f2;
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f, float f2) {
        float f3 = f - this.f1055j;
        float f4 = f2 - this.f1056k;
        float f5 = this.t;
        float f6 = f3 / f5;
        float f7 = f4 / f5;
        HashMap<Long, i.b.ia.f> map = i.b.ia.f.I;
        if (map == null) {
            return;
        }
        Iterator<i.b.ia.f> it = map.values().iterator();
        i.b.ia.f fVar = null;
        i.b.ia.b bVarH = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i.b.ia.f next = it.next();
            if (next.contains(f6, f7) && (bVarH = next.h(f6, f7)) != null) {
                fVar = next;
                break;
            }
        }
        if (bVarH == null) {
            return;
        }
        Node node = bVarH.e;
        final Task taskJ = fVar.j();
        i.b.v8.m().d(taskJ, node, new lt() { // from class: com.v.ml
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.p(taskJ, node2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(Task task, Node node) {
        postInvalidate();
        i.b.da.B().R1(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        com.frame.s0.g().o(this);
    }

    public static SimpleFlowView x() {
        int i2;
        int i3;
        if (com.frame.s0.g().m(SimpleFlowView.class)) {
            return (SimpleFlowView) com.frame.s0.g().f(SimpleFlowView.class);
        }
        int iC = com.frame.n0.c("sfv_x", 0);
        int iC2 = com.frame.n0.c("sfv_y", 100);
        int iC3 = com.frame.p1.c(150.0f);
        int iC4 = com.frame.p1.c(250.0f);
        int iC5 = com.frame.n0.c("sfv_w", iC3);
        int iC6 = com.frame.n0.c("sfv_h", iC4);
        if ((iC5 >= iC3 / 2 || iC6 >= iC4 / 2) && iC5 < iC3 && iC6 < iC4) {
            i2 = iC5;
            i3 = iC6;
        } else {
            i2 = iC3;
            i3 = iC4;
        }
        return (SimpleFlowView) com.frame.s0.g().y(SimpleFlowView.class, iC, iC2, i2, i3);
    }

    protected void l() {
        boolean z;
        boolean z2 = true;
        if (this.f < 0) {
            this.f = 0;
            z = true;
        } else {
            z = false;
        }
        if (this.e < 0) {
            this.e = 0;
            z = true;
        }
        if (this.f + getWidth() > com.frame.q1.e()) {
            this.f = com.frame.q1.e() - getWidth();
            z = true;
        }
        if (this.e + getHeight() > com.frame.q1.d()) {
            this.e = com.frame.q1.d() - getHeight();
        } else {
            z2 = z;
        }
        if (z2) {
            s(this.f, this.e);
            t();
        } else if (this.e != 0) {
            v(new Point(this.f, this.e));
        }
    }

    public void m() {
        int width = getWidth();
        int height = getHeight();
        com.frame.n0.i("sfv_w", width);
        com.frame.n0.i("sfv_h", height);
    }

    public void n() {
        this.d = new ScaleGestureDetector(com.frame.v0.g(), new c());
        this.c = new GestureDetector(com.frame.v0.g(), new b());
        View.inflate(com.frame.v0.g(), j.b.f.o1, this);
        setBackgroundColor(Color.parseColor("#eeF8F8FB"));
        View viewFindViewById = findViewById(j.b.e.Q0);
        View viewFindViewById2 = findViewById(j.b.e.B0);
        findViewById(j.b.e.f1756o).setOnClickListener(new View.OnClickListener() { // from class: com.v.ll
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r(view);
            }
        });
        new i.b.y8().b(this, viewFindViewById, new Runnable() { // from class: com.v.q9
            @Override // java.lang.Runnable
            public final void run() {
                this.c.m();
            }
        });
        viewFindViewById2.setOnTouchListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = com.frame.n0.c("sfv_x", 0);
        this.e = com.frame.n0.c("log_y", 100);
        post(new Runnable() { // from class: com.v.at
            @Override // java.lang.Runnable
            public final void run() {
                this.c.l();
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.f1055j, this.f1056k);
        float f = this.t;
        canvas.scale(f, f);
        i.b.ia.f fVar = this.f1054i;
        if (fVar != null) {
            fVar.t(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.c.onTouchEvent(motionEvent);
        this.d.onTouchEvent(motionEvent);
        return true;
    }

    protected void s(float f, float f2) {
        com.frame.s0.g().G(this, (int) f, (int) f2);
    }

    public void setNodeStep(long j2, long j3) {
        HashMap<Long, i.b.ia.f> map = i.b.ia.f.I;
        if (map != null) {
            i.b.ia.f fVar = map.get(Long.valueOf(j2));
            try {
                Iterator<i.b.ia.c> it = fVar.g().iterator();
                while (it.hasNext()) {
                    i.b.ia.c next = it.next();
                    if (this.C != null) {
                        if (next.e.b() == this.C.b()) {
                            next.q(0);
                        } else if (next.e.b() == j3 && this.C.b() == next.d.b()) {
                            next.q(3);
                        }
                    }
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            try {
                i.b.ia.b bVar = this.C;
                if (bVar != null) {
                    bVar.d(0);
                }
                i.b.ia.b bVar2 = fVar.i().get(Long.valueOf(j3));
                bVar2.d(3);
                this.C = bVar2;
                postInvalidate();
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
    }

    public boolean t() {
        return false;
    }

    public void u() {
        if (this.f1054i == null) {
            FloatToast.i("mTaskFlow=null");
            return;
        }
        int i2 = getLayoutParams().height;
        int i3 = getLayoutParams().width;
        float fC = com.frame.p1.c(100.0f);
        float fS = this.f1054i.s() + fC;
        float fR = this.f1054i.r() + fC;
        float f = i3;
        float f2 = i2;
        float fMin = Math.min(f / fS, f2 / fR);
        this.t = fMin;
        this.f1055j = ((f - (fS * fMin)) / 2.0f) - (this.f1054i.f1516k * fMin);
        this.f1056k = ((f2 - (fR * fMin)) / 2.0f) + com.frame.p1.c(20.0f);
        postInvalidate();
    }

    public void v(Point point) {
        com.frame.n0.i("sfv_x", point.x);
        com.frame.n0.i("sfv_y", point.y);
    }

    public SimpleFlowView w(Task task) {
        HashMap<Long, i.b.ia.f> map;
        if (task != null && (this.f1054i == null || (map = i.b.ia.f.I) == null || !map.containsKey(Long.valueOf(task.getId())))) {
            i.b.ia.f.l();
            i.b.ia.f fVar = new i.b.ia.f();
            this.f1054i = fVar;
            fVar.m(task);
        }
        return this;
    }
}

package com.v;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.RelativeLayout;
import com.permission.ClickView;
import com.v.DelaySetDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.ia.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Collectors;

/* loaded from: classes.dex */
public class FlowView extends RelativeLayout implements View.OnClickListener, f.a, f.b {
    private boolean A;
    private boolean C;
    private i.b.ia.b D;
    private HashMap<Long, i.b.ia.b> c;
    private HashMap<Long, i.b.ia.c> d;
    private float e;
    private float f;
    private GestureDetector g;

    /* renamed from: h, reason: collision with root package name */
    private View f962h;

    /* renamed from: i, reason: collision with root package name */
    private float f963i;

    /* renamed from: j, reason: collision with root package name */
    private ScaleGestureDetector f964j;

    /* renamed from: k, reason: collision with root package name */
    private i.b.ia.f f965k;
    private FlowBottomView t;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(MotionEvent motionEvent) {
            FlowView.this.j(motionEvent.getX(), motionEvent.getY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            FlowView.this.k(motionEvent.getX(), motionEvent.getY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            FlowView.f(FlowView.this, f);
            FlowView.g(FlowView.this, f2);
            FlowView.this.postInvalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(final MotionEvent motionEvent) {
            com.frame.l1.g(new Runnable() { // from class: com.v.o8
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.b(motionEvent);
                }
            });
            return true;
        }
    }

    class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        b() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            FlowView.e(FlowView.this, scaleGestureDetector.getScaleFactor());
            FlowView flowView = FlowView.this;
            float f = 3.0f;
            if (flowView.f963i < 0.1d) {
                f = 0.1f;
            } else if (FlowView.this.f963i <= 3.0f) {
                f = FlowView.this.f963i;
            }
            flowView.f963i = f;
            FlowView.this.postInvalidate();
            return true;
        }
    }

    public FlowView() {
        super(com.frame.v0.g());
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        this.f963i = 1.0f;
        m();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(final i.b.ia.c cVar, final i.b.ia.f fVar) {
        this.t.b();
        if (this.t.c()) {
            return;
        }
        this.t.removeAllViews();
        this.t.a("取消", new View.OnClickListener() { // from class: com.v.e9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.v(cVar, view);
            }
        });
        if ("识别超时".equals(cVar.f1511i)) {
            this.t.a("确定", new View.OnClickListener() { // from class: com.v.w8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.x(cVar, view);
                }
            });
        } else {
            this.t.a("确定", new View.OnClickListener() { // from class: com.v.z8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.z(cVar, fVar, view);
                }
            });
        }
        this.t.d();
    }

    static /* synthetic */ void A0(Task task, Node node, View view) {
        i.b.v8.m().k0(task);
        i.b.v8.m().j0(node);
        com.frame.s0.g().d(DingMsgView.class);
        final FloatHandlerContinue floatHandlerContinueM = FloatHandlerContinue.m();
        floatHandlerContinueM.l(task, node);
        com.frame.s0.g().i(FloatHandler.class);
        com.frame.l1.f(new Runnable() { // from class: com.v.y8
            @Override // java.lang.Runnable
            public final void run() {
                ClickView.getInstance().a(floatHandlerContinueM.createAccessibilityNodeInfo(), null);
            }
        }, 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C0(Task task, Node node) {
        if (node == null) {
            com.frame.s0.g().u(FlowView.class);
            return;
        }
        this.C = false;
        i.b.da.B().z1(task);
        FlowView flowView = (FlowView) com.frame.s0.g().u(FlowView.class);
        if (flowView != null) {
            flowView.setTask(task);
            flowView.setNodeStep(task.getId(), node.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D() {
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(HashMap map, String str) {
        for (i.b.ia.c cVar : map.values()) {
            i.b.ia.b bVar = cVar.e;
            if (bVar != null && bVar.e != null) {
                cVar.f1511i = cVar.e.e.delay + "毫秒";
            }
        }
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(i.b.ia.f fVar, i.b.ia.b bVar, View view) {
        G0(fVar, bVar.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean H(Node node, i.b.ia.b bVar, String str) {
        node.name = str;
        bVar.d = str;
        postInvalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(View view) {
        this.C = true;
        try {
            final i.b.ia.b next = this.c.values().iterator().next();
            final Node node = next.e;
            InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.l("重命名");
            inputDialogView.s("请输入节点名称");
            inputDialogView.w(node.name);
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.m8
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.H(node, next, str);
                }
            });
            inputDialogView.v(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(View view) {
        if (!com.frame.w0.d()) {
            if (!com.permission.u0.g().h()) {
                com.permission.u0.g().d("accessibility");
            }
            com.permission.x0.m().a();
            return;
        }
        if (!this.c.isEmpty()) {
            I0();
            this.t.b();
        }
        if (!this.d.isEmpty()) {
            J0();
            this.t.b();
        }
        FloatToast.i("请选择在哪个节点后新增操作");
        this.A = true;
        com.frame.s0.g().d(DingMsgView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Node node) {
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(i.b.ia.f fVar, View view) {
        this.C = true;
        i.b.v8.m().d(fVar.j(), this.c.values().iterator().next().e, new lt() { // from class: com.v.l9
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.N(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(i.b.ia.f fVar, i.b.ia.b bVar, View view) {
        fVar.v(bVar);
        postInvalidate();
        com.frame.s0.g().d(DingMsgView.class);
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(final i.b.ia.b bVar, final i.b.ia.f fVar, View view) {
        this.C = true;
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否确认删除【" + bVar.d + "】操作节点？");
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.d9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.d8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.S(fVar, bVar, view2);
            }
        });
        dingMsgView.l("温馨提示");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(View view) {
        Iterator<i.b.ia.b> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().d(0);
        }
        this.c.clear();
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(final i.b.ia.f fVar, final i.b.ia.b bVar) {
        if (this.c.isEmpty()) {
            this.t.b();
            return;
        }
        if (this.t.c()) {
            return;
        }
        this.t.removeAllViews();
        this.t.a("插入", new View.OnClickListener() { // from class: com.v.a8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.F(fVar, bVar, view);
            }
        });
        this.t.a("重命名", new View.OnClickListener() { // from class: com.v.u8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.J(view);
            }
        });
        this.t.a("编辑", new View.OnClickListener() { // from class: com.v.v8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.P(fVar, view);
            }
        });
        this.t.a("删除", new View.OnClickListener() { // from class: com.v.p8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.U(bVar, fVar, view);
            }
        });
        this.t.a("取消", new View.OnClickListener() { // from class: com.v.k8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.W(view);
            }
        });
        this.t.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(View view) {
        this.C = true;
        i.b.ia.c next = this.d.values().iterator().next();
        this.D = null;
        Node node = next.d.e;
        node.errorType = 3;
        node.errorId = next.e.e.id;
        J0();
        I0();
        this.t.b();
        com.frame.s0.g().d(DingMsgView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d0() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("刚刚修改了识别超时的跳转操作，是否先保存？");
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.b8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.q8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.b0(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    static /* synthetic */ float e(FlowView flowView, float f) {
        float f2 = flowView.f963i * f;
        flowView.f963i = f2;
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f0(View view) {
        com.frame.s0.g().o(this);
    }

    static /* synthetic */ float f(FlowView flowView, float f) {
        float f2 = flowView.e - f;
        flowView.e = f2;
        return f2;
    }

    static /* synthetic */ float g(FlowView flowView, float f) {
        float f2 = flowView.f - f;
        flowView.f = f2;
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h0(i.b.ia.f fVar, i.b.ia.c cVar) {
        G0(fVar, cVar.d.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0() {
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(float f, float f2) {
        float f3 = f - this.e;
        float f4 = f2 - this.f;
        float f5 = this.f963i;
        float f6 = f3 / f5;
        float f7 = f4 / f5;
        Iterator<i.b.ia.f> it = i.b.ia.f.I.values().iterator();
        while (it.hasNext() && !it.next().a(f6, f7)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f, float f2) {
        float f3 = f - this.e;
        float f4 = f2 - this.f;
        float f5 = this.f963i;
        float f6 = f3 / f5;
        float f7 = f4 / f5;
        i.b.ia.b bVarH = null;
        for (i.b.ia.f fVar : i.b.ia.f.I.values()) {
            if (fVar.contains(f6, f7) && (bVarH = fVar.h(f6, f7)) != null) {
                break;
            }
        }
        if (bVarH == null) {
            return;
        }
        bVarH.d(2);
        postInvalidate();
        com.frame.l1.e(new Runnable() { // from class: com.v.h9
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q();
            }
        });
    }

    private void l() {
        this.f964j = new ScaleGestureDetector(com.frame.v0.g(), new b());
        this.g = new GestureDetector(com.frame.v0.g(), new a());
        setBackgroundColor(Color.parseColor("#eeF8F8FB"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(View view) {
        HashMap<Long, i.b.ia.c> map = this.d;
        H0(map, (Collection) map.values().stream().map(new Function() { // from class: com.v.h8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((i.b.ia.c) obj).e.e;
            }
        }).collect(Collectors.toList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(View view) {
        Iterator<i.b.ia.b> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().d(0);
        }
        this.c.clear();
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(View view) {
        Iterator<i.b.ia.c> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next().q(0);
        }
        this.d.clear();
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        if (this.c.isEmpty()) {
            this.t.b();
        } else {
            if (this.t.c()) {
                return;
            }
            this.t.removeAllViews();
            this.t.a("取消", new View.OnClickListener() { // from class: com.v.j9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.o(view);
                }
            });
            this.t.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0() {
        if (this.d.isEmpty()) {
            this.t.b();
        } else {
            if (this.t.c()) {
                return;
            }
            this.t.removeAllViews();
            this.t.a("修改延迟", new View.OnClickListener() { // from class: com.v.c9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.m0(view);
                }
            });
            this.t.a("取消", new View.OnClickListener() { // from class: com.v.l8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.o0(view);
                }
            });
            this.t.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(View view) {
        com.frame.s0.g().o(this);
        Iterator<i.b.ia.f> it = i.b.ia.f.I.values().iterator();
        while (it.hasNext()) {
            i.b.da.B().z1(it.next().j());
        }
        com.yl.ui.i0.l(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(i.b.ia.f fVar, i.b.ia.b bVar) {
        G0(fVar, bVar.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(DingMsgView dingMsgView, View view) {
        removeView(dingMsgView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(i.b.ia.c cVar, View view) {
        cVar.e = this.D;
        this.D = null;
        J0();
        I0();
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(DingMsgView dingMsgView, View view) {
        this.C = false;
        Iterator<i.b.ia.f> it = i.b.ia.f.I.values().iterator();
        while (it.hasNext()) {
            i.b.da.B().z1(it.next().j());
        }
        removeView(dingMsgView);
        com.yl.ui.i0.l(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(i.b.ia.c cVar, View view) {
        this.D = null;
        Node node = cVar.d.e;
        node.errorType = 3;
        node.errorId = cVar.e.e.id;
        J0();
        I0();
        this.t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(final Task task, Node node, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(NodeListDialogView.class);
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().i(FlowView.class);
        if (!this.c.isEmpty()) {
            I0();
            this.t.b();
        }
        i.b.v8.m().k0(task);
        i.b.v8.m().j0(node);
        ((OptionListDialogView) com.frame.s0.g().x(OptionListDialogView.class)).setCallback(new lt() { // from class: com.v.n8
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.C0(task, node2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(i.b.ia.c cVar, i.b.ia.f fVar, View view) {
        this.D = null;
        cVar.d.e.nextType = 3;
        i.b.v8.m().K(cVar.d.e, cVar.e.e);
        fVar.u();
        this.t.b();
    }

    public void F0() {
        int i2 = getLayoutParams().height;
        int i3 = getLayoutParams().width;
        float fS = this.f965k.s();
        float fR = this.f965k.r();
        float f = i3;
        float f2 = i2;
        float fMin = Math.min(f / fS, f2 / fR);
        this.f963i = fMin;
        this.e = ((f - (fS * fMin)) / 2.0f) - (this.f965k.f1516k * fMin);
        this.f = (f2 - (fR * fMin)) / 2.0f;
        postInvalidate();
    }

    public void G0(i.b.ia.f fVar, final Node node) {
        this.C = true;
        final Task taskJ = fVar.j();
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否在【" + node.getName() + "】节点后加入新的操作节点？");
        dingMsgView.i("继续录制", new View.OnClickListener() { // from class: com.v.b9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlowView.A0(taskJ, node, view);
            }
        });
        dingMsgView.k("添加单个操作", new View.OnClickListener() { // from class: com.v.m9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.y0(taskJ, node, view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void H0(final HashMap<Long, i.b.ia.c> map, Collection<Node> collection) {
        this.C = true;
        DelaySetDialogView delaySetDialogView = (DelaySetDialogView) com.frame.s0.g().B(DelaySetDialogView.class);
        delaySetDialogView.setNodeList(collection);
        delaySetDialogView.v(new DelaySetDialogView.a() { // from class: com.v.s8
            @Override // com.v.DelaySetDialogView.a
            public final void a(String str) {
                this.a.E0(map, str);
            }
        });
    }

    public void I0() {
        Iterator<i.b.ia.b> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().d(0);
        }
        this.c.clear();
    }

    public void J0() {
        Iterator<i.b.ia.c> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next().q(0);
        }
        this.d.clear();
    }

    @Override // i.b.ia.f.b
    public void a(final i.b.ia.f fVar, final i.b.ia.c cVar) {
        if (this.D != null) {
            com.frame.l1.e(new Runnable() { // from class: com.v.g8
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d0();
                }
            });
            return;
        }
        if (this.A && cVar.d != null) {
            com.frame.l1.e(new Runnable() { // from class: com.v.i8
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.h0(fVar, cVar);
                }
            });
            this.A = false;
            return;
        }
        if (!this.c.isEmpty()) {
            I0();
            com.frame.l1.e(new Runnable() { // from class: com.v.f8
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.j0();
                }
            });
        }
        if (!this.d.isEmpty() && this.d.values().iterator().next().c != cVar.c) {
            J0();
        }
        if (this.d.containsKey(Long.valueOf(cVar.n()))) {
            cVar.q(0);
            this.d.remove(Long.valueOf(cVar.n()));
        } else {
            cVar.q(1);
            this.d.put(Long.valueOf(cVar.n()), cVar);
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.t8
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q0();
            }
        });
        postInvalidate();
    }

    @Override // i.b.ia.f.a
    public void b(final i.b.ia.f fVar, final i.b.ia.b bVar) {
        if (this.A) {
            com.frame.l1.e(new Runnable() { // from class: com.v.x8
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.t(fVar, bVar);
                }
            });
            this.A = false;
            return;
        }
        if (!this.d.isEmpty()) {
            if (this.d.size() == 1) {
                final i.b.ia.c next = this.d.values().iterator().next();
                if (this.D == null) {
                    this.D = next.e;
                }
                next.e = bVar;
                next.q(3);
                bVar.d(3);
                I0();
                this.c.put(Long.valueOf(bVar.b()), bVar);
                com.frame.l1.e(new Runnable() { // from class: com.v.g9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.B(next, fVar);
                    }
                });
                return;
            }
            J0();
            com.frame.l1.e(new Runnable() { // from class: com.v.a9
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.D();
                }
            });
        }
        if (this.c.containsKey(Long.valueOf(bVar.b()))) {
            bVar.d(0);
            this.c.remove(Long.valueOf(bVar.b()));
        } else {
            I0();
            bVar.d(1);
            this.c.put(Long.valueOf(bVar.b()), bVar);
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.k9
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Y(fVar, bVar);
            }
        });
        postInvalidate();
    }

    public void m() {
        View.inflate(com.frame.v0.g(), j.b.f.l1, this);
        findViewById(j.b.e.h0).setOnClickListener(this);
        findViewById(j.b.e.y0).setOnClickListener(this);
        findViewById(j.b.e.H0).setOnClickListener(this);
        findViewById(j.b.e.c1).setOnClickListener(this);
        this.t = (FlowBottomView) findViewById(j.b.e.v4);
        View viewFindViewById = findViewById(j.b.e.G4);
        this.f962h = viewFindViewById;
        viewFindViewById.findViewById(j.b.e.p0).setOnClickListener(this);
        this.f962h.findViewById(j.b.e.C0).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.p0) {
            F0();
            return;
        }
        if (id == j.b.e.H0) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("是否需要添加新节点操作？");
            dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.f9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.i9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.L(view2);
                }
            });
            dingMsgView.l("温馨提示");
            return;
        }
        if (id == j.b.e.h0) {
            if (!this.C) {
                com.frame.s0.g().o(this);
                return;
            }
            DingMsgView dingMsgView2 = new DingMsgView();
            dingMsgView2.h("是否先保存编辑内容后再退出？");
            dingMsgView2.i("关闭", new View.OnClickListener() { // from class: com.v.e8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.f0(view2);
                }
            });
            dingMsgView2.k("保存", new View.OnClickListener() { // from class: com.v.r8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.s0(view2);
                }
            });
            dingMsgView2.l("温馨提示");
            addView(dingMsgView2, -1, -1);
            return;
        }
        if (id == j.b.e.y0) {
            View view2 = this.f962h;
            view2.setVisibility(view2.getVisibility() == 0 ? 8 : 0);
        } else if (id == j.b.e.c1) {
            final DingMsgView dingMsgView3 = new DingMsgView();
            dingMsgView3.h("是否保存编辑内容？");
            dingMsgView3.i("取消", new View.OnClickListener() { // from class: com.v.c8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.c.u0(dingMsgView3, view3);
                }
            });
            dingMsgView3.k("确定", new View.OnClickListener() { // from class: com.v.j8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.c.w0(dingMsgView3, view3);
                }
            });
            dingMsgView3.l("温馨提示");
            addView(dingMsgView3, -1, -1);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.e, this.f);
        float f = this.f963i;
        canvas.scale(f, f);
        i.b.ia.f fVar = this.f965k;
        if (fVar != null) {
            fVar.t(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.g.onTouchEvent(motionEvent);
        this.f964j.onTouchEvent(motionEvent);
        return true;
    }

    public void setNodeStep(long j2, long j3) {
        HashMap<Long, i.b.ia.f> map = i.b.ia.f.I;
        if (map != null) {
            try {
                map.get(Long.valueOf(j2)).i().get(Long.valueOf(j3)).d(3);
                postInvalidate();
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    public void setTask(Task task) {
        this.c.clear();
        this.d.clear();
        i.b.ia.f.l();
        i.b.ia.f fVar = new i.b.ia.f();
        this.f965k = fVar;
        fVar.w(this);
        this.f965k.x(this);
        this.f965k.m(task);
        F0();
    }
}

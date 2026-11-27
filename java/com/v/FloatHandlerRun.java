package com.v;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yl.float_ui.CanDragFloatView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class FloatHandlerRun extends CanDragFloatView implements View.OnClickListener {
    private View A;
    private View C;
    private String D;
    private int G;
    private Node H;
    private TextView c;
    private SimpleFlowView d;
    private boolean e;
    private View f;
    private View g;

    /* renamed from: h, reason: collision with root package name */
    private View f957h;

    /* renamed from: i, reason: collision with root package name */
    private View f958i;

    /* renamed from: j, reason: collision with root package name */
    private View f959j;

    /* renamed from: k, reason: collision with root package name */
    private View f960k;
    private View t;

    public FloatHandlerRun(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(View view) {
        findViewById(j.b.e.r0).setVisibility(0);
        findViewById(j.b.e.x4).setVisibility(8);
        post(new Runnable() { // from class: com.v.v7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.A();
            }
        });
        com.frame.s0.g().d(DingMsgView.class);
        i.b.j7.a().i(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E() {
        setMagnet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(View view) {
        findViewById(j.b.e.r0).setVisibility(8);
        findViewById(j.b.e.x4).setVisibility(8);
        post(new Runnable() { // from class: com.v.s7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.E();
            }
        });
        com.frame.s0.g().d(DingMsgView.class);
        i.b.j7.a().i(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J() {
        S(i.b.j7.a().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L() {
        setMagnet(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N() {
        setMagnet(true);
    }

    public static FloatHandlerRun T() {
        return (FloatHandlerRun) com.frame.s0.g().y(FloatHandlerRun.class, com.frame.n0.c("fhx", 0), com.frame.n0.c("fhy", 100), -2, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j() {
        S(i.b.j7.a().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        setMagnet(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        NodeListDialogView.g1(this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        NodeListDialogView.g1(this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(Task task, Node node) {
        if (node != null) {
            i.b.da.B().z1(task);
            SimpleFlowView simpleFlowView = this.d;
            if (simpleFlowView != null) {
                simpleFlowView.w(task);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        setMagnet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(View view) {
        findViewById(j.b.e.r0).setVisibility(0);
        findViewById(j.b.e.x4).setVisibility(8);
        post(new Runnable() { // from class: com.v.j7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.t();
            }
        });
        com.frame.s0.g().d(DingMsgView.class);
        i.b.j7.a().i(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(DingMsgView dingMsgView, View view) {
        view.setSelected(!view.isSelected());
        if (view.isSelected()) {
            dingMsgView.k("完全关闭", new View.OnClickListener() { // from class: com.v.n7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.G(view2);
                }
            });
        } else {
            dingMsgView.k("最小化", new View.OnClickListener() { // from class: com.v.r7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.v(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        setMagnet(true);
    }

    public void O() {
        com.frame.y0.j("onFinishTask");
        i.b.i7.p().z();
        i.b.da.B().h2();
    }

    public FloatHandlerRun P() {
        try {
            this.G = i.b.da.B().N().l().getNodeMap().size();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        SimpleFlowView simpleFlowView = (SimpleFlowView) com.frame.s0.g().u(SimpleFlowView.class);
        this.d = simpleFlowView;
        if (simpleFlowView != null) {
            simpleFlowView.w(i.b.da.B().N().l());
        }
        com.frame.s0.g().i(FloatHandler.class);
        return this;
    }

    public void Q(Node node) {
        R(node, this.G);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a9 -> B:28:0x00ac). Please report as a decompilation issue!!! */
    public void R(final Node node, int i2) {
        this.H = node;
        this.D = node.step;
        this.G = i2;
        this.c.setText(this.D + "/" + i2);
        if (i.b.da.B().N() == null) {
            return;
        }
        Task taskL = i.b.da.B().N().l();
        SimpleFlowView simpleFlowView = this.d;
        if (simpleFlowView != null && taskL != null) {
            simpleFlowView.setNodeStep(taskL.getId(), node.id);
        }
        if (taskL != null && (taskL.isCanNotShare() || i.b.da.q)) {
            this.A.setVisibility(8);
            this.C.setVisibility(8);
        }
        if (taskL == null || !taskL.isCanNotShare()) {
            try {
                final NodeListDialogView nodeListDialogView = (NodeListDialogView) com.frame.s0.g().f(NodeListDialogView.class);
                if (nodeListDialogView != null) {
                    Task taskL2 = i.b.da.B().N().l();
                    if (nodeListDialogView.getTask().getId() != taskL2.getId()) {
                        NodeListDialogView.h1(taskL2.getId()).post(new Runnable() { // from class: com.v.f7
                            @Override // java.lang.Runnable
                            public final void run() {
                                nodeListDialogView.u(node);
                            }
                        });
                    } else {
                        nodeListDialogView.u(node);
                    }
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    public void S(String str) {
        int iC = str.equals("custom") ? com.frame.p1.c(35.0f) : str.equals("small") ? com.frame.p1.c(28.0f) : str.equals("big") ? com.frame.p1.c(45.0f) : 0;
        LinearLayout linearLayout = (LinearLayout) findViewById(j.b.e.x4);
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayout.getChildAt(i2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.width = iC;
            layoutParams.height = iC;
            childAt.setLayoutParams(layoutParams);
        }
        int iB = i.b.j7.a().b();
        if (iB == 0) {
            post(new Runnable() { // from class: com.v.k7
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.L();
                }
            });
        } else {
            if (iB != 1) {
                setVisibility(8);
                return;
            }
            findViewById(j.b.e.r0).setVisibility(0);
            findViewById(j.b.e.x4).setVisibility(8);
            post(new Runnable() { // from class: com.v.u7
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.N();
                }
            });
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        return new Point(com.frame.n0.c("fhx", 0), com.frame.n0.c("fhy", 100));
    }

    @Override // com.yl.float_ui.CanDragFloatView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.frame.s0.g().i(FloatHandler.class);
        post(new Runnable() { // from class: com.v.g7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.j();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.U0) {
            return;
        }
        if (id == j.b.e.X0) {
            try {
                if (i.b.da.B().N() == null || i.b.da.B().N().l() == null) {
                    return;
                }
                NodeListDialogView.h1(i.b.da.B().N().l().getId());
                return;
            } catch (Exception e) {
                com.frame.y0.l(e);
                return;
            }
        }
        int i2 = j.b.e.r0;
        if (id == i2) {
            findViewById(i2).setVisibility(8);
            findViewById(j.b.e.x4).setVisibility(0);
            post(new Runnable() { // from class: com.v.q7
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l();
                }
            });
            return;
        }
        Task taskL = null;
        if (id == j.b.e.V0) {
            if (this.d != null) {
                com.frame.s0.g().o(this.d);
                this.d = null;
                return;
            }
            if (i.b.da.B().N() == null || i.b.da.B().N().l() == null) {
                return;
            }
            SimpleFlowView simpleFlowViewX = SimpleFlowView.x();
            this.d = simpleFlowViewX;
            simpleFlowViewX.w(i.b.da.B().N().l());
            this.d.u();
            if (this.H != null) {
                try {
                    this.d.setNodeStep(i.b.da.B().N().l().getId(), this.H.id);
                    return;
                } catch (Exception e2) {
                    com.frame.k0.r(e2);
                    return;
                }
            }
            return;
        }
        if (id == j.b.e.b1) {
            com.frame.y0.j("点击悬浮条停止按钮");
            com.frame.s0.g().o(this);
            i.b.i9.v().h0();
            O();
            return;
        }
        if (id != j.b.e.Z0) {
            if (id == j.b.e.T0) {
                final Task taskL2 = i.b.da.B().N().l();
                i.b.v8.m().k0(taskL2);
                if (this.H == null) {
                    FloatToast.i("未找到当前进行中的节点");
                    return;
                } else {
                    i.b.v8.m().j0(taskL2.nodeMap.get(Long.valueOf(this.H.id)));
                    ((OptionListDialogView) com.frame.s0.g().x(OptionListDialogView.class)).setCallback(new lt() { // from class: com.v.m7
                        @Override // com.v.lt
                        public final void a(Node node) {
                            this.a.r(taskL2, node);
                        }
                    });
                    return;
                }
            }
            if (id == j.b.e.Y0 || id == j.b.e.W0 || id != j.b.e.a1) {
                return;
            }
            i.b.da.B().N1();
            this.f960k.setVisibility(0);
            this.f958i.setVisibility(0);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            this.f957h.setVisibility(8);
            this.f959j.setVisibility(8);
            this.t.setVisibility(8);
            return;
        }
        setVisibility(0);
        i.b.i7.p().z();
        i.b.da.B().A1();
        this.f958i.setVisibility(8);
        try {
            if (i.b.da.B().N() != null && i.b.da.B().N().l() != null) {
                taskL = i.b.da.B().N().l();
            }
            if (!taskL.isCanNotShare() && !i.b.da.q && !com.frame.n0.a("psnl", true)) {
                NodeListDialogView nodeListDialogView = (NodeListDialogView) com.frame.s0.g().f(NodeListDialogView.class);
                if (nodeListDialogView == null) {
                    NodeListDialogView.h1(taskL.getId()).post(new Runnable() { // from class: com.v.p7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.n();
                        }
                    });
                } else if (nodeListDialogView.getTask().getId() != taskL.getId()) {
                    NodeListDialogView.h1(taskL.getId()).post(new Runnable() { // from class: com.v.o7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.p();
                        }
                    });
                }
            }
        } catch (Exception e3) {
            com.frame.k0.r(e3);
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.f957h.setVisibility(8);
        this.f959j.setVisibility(8);
        this.t.setVisibility(8);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public boolean onOutScreen() {
        if (this.e) {
            TextView textView = new TextView(com.frame.v0.g());
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setText("完全关闭，不再显示");
            textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(8.0f), 0, com.frame.p1.c(10.0f));
            textView.setTextSize(12.0f);
            textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
            textView.setCompoundDrawablesWithIntrinsicBounds(com.yl.float_ui.i0.a, 0, 0, 0);
            final DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.m(textView);
            dingMsgView.h("已拖到屏幕边缘，是要最小化还是关闭呢？可在【我的-自定义悬浮工具条】中修改。");
            dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.t7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.k("最小化", new View.OnClickListener() { // from class: com.v.l7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.C(view);
                }
            });
            dingMsgView.l("温馨提示");
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.h7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.x(dingMsgView, view);
                }
            });
        }
        return super.onOutScreen();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            post(new Runnable() { // from class: com.v.i7
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.J();
                }
            });
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("fhx", point.x);
        com.frame.n0.i("fhy", point.y);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void setMagnet(boolean z) {
        this.magnet = z;
        boolean z2 = false;
        boolean z3 = true;
        if (z) {
            ImageView imageView = (ImageView) findViewById(j.b.e.r0);
            if (this.xx > (com.frame.k0.c().e() - getWidth()) / 2) {
                this.xx = com.frame.k0.c().e() - getWidth();
                imageView.setRotation(180.0f);
            } else {
                imageView.setRotation(0.0f);
                this.xx = 0;
            }
            if (this.yy == 0) {
                this.yy = loadXY().y;
            }
            z2 = true;
        }
        if (this.xx + getWidth() > com.frame.k0.c().e()) {
            this.xx = com.frame.k0.c().e() - getWidth();
            z2 = true;
        }
        if (this.yy + getHeight() > com.frame.q1.d()) {
            this.yy = com.frame.q1.d() - getHeight();
        } else {
            z3 = z2;
        }
        if (z3) {
            move(this.xx, this.yy);
        }
    }

    public FloatHandlerRun(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatHandlerRun(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public FloatHandlerRun() {
        super(com.frame.v0.g());
        setMagnet(false);
        View.inflate(com.frame.v0.g(), j.b.f.s0, this);
        try {
            setKeepScreenOn(true);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        this.c = (TextView) findViewById(j.b.e.t6);
        this.f959j = findViewById(j.b.e.T0);
        this.f960k = findViewById(j.b.e.b1);
        this.f = findViewById(j.b.e.a1);
        this.g = findViewById(j.b.e.Y0);
        this.f957h = findViewById(j.b.e.W0);
        this.f958i = findViewById(j.b.e.Z0);
        this.t = findViewById(j.b.e.U0);
        this.A = findViewById(j.b.e.V0);
        View viewFindViewById = findViewById(j.b.e.X0);
        this.C = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.C.setOnTouchListener(this.mSubTouchListener);
        this.A.setOnClickListener(this);
        this.A.setOnTouchListener(this.mSubTouchListener);
        this.g.setOnClickListener(this);
        this.g.setOnTouchListener(this.mSubTouchListener);
        this.f.setOnClickListener(this);
        this.f.setOnTouchListener(this.mSubTouchListener);
        this.f957h.setOnClickListener(this);
        this.f957h.setOnTouchListener(this.mSubTouchListener);
        this.f958i.setOnClickListener(this);
        this.f958i.setOnTouchListener(this.mSubTouchListener);
        this.f959j.setOnClickListener(this);
        this.f959j.setOnTouchListener(this.mSubTouchListener);
        this.f960k.setOnClickListener(this);
        this.f960k.setOnTouchListener(this.mSubTouchListener);
        this.t.setOnClickListener(this);
        this.t.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById2 = findViewById(j.b.e.r0);
        viewFindViewById2.setOnClickListener(this);
        viewFindViewById2.setOnTouchListener(this.mSubTouchListener);
        this.e = i.b.j7.a().e();
    }
}

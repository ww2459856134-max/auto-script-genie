package com.v;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.permission.ClickView;
import com.v.TaskChooseDialogView;
import com.yl.float_ui.CanDragFloatView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Task;
import com.yl.model.TaskSimple;

/* loaded from: classes.dex */
public class FloatHandler extends CanDragFloatView implements View.OnClickListener {
    private boolean c;

    public FloatHandler(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C() {
        com.frame.s0.g().j(this);
        com.frame.s0.g().E(GesturePlayFloatView.class);
        i.b.v8.m().j0(null);
        com.frame.l1.f(y3.c, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(View view) {
        com.frame.k0.c().x(com.s.u.class);
        com.frame.s0.g().d(getClass());
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.n0.g("fhclose", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G() {
        setMagnet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(View view) {
        findViewById(j.b.e.r0).setVisibility(0);
        findViewById(j.b.e.x4).setVisibility(8);
        com.frame.s0.g().d(DingMsgView.class);
        post(new Runnable() { // from class: com.v.i6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.G();
            }
        });
    }

    static /* synthetic */ void J(FloatTopControllerView floatTopControllerView, int i2, int i3) {
        try {
            floatTopControllerView.a(i2, i3);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L() {
        setMagnet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N() {
        setMagnet(false);
    }

    public static FloatHandler P() {
        int iC = com.frame.n0.c("fh_x", com.frame.p1.c(150.0f));
        int iC2 = com.frame.n0.c("fh_y", com.frame.p1.c(150.0f));
        if (iC >= com.frame.q1.e()) {
            iC = 0;
        }
        int i2 = iC;
        if (iC2 >= com.frame.q1.d()) {
            iC2 = com.frame.p1.c(150.0f);
        }
        return (FloatHandler) com.frame.s0.g().y(FloatHandler.class, i2, iC2, -2, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j() {
        O(i.b.j7.a().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        setMagnet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(View view) {
        com.frame.s0.g().d(getClass());
        com.frame.s0.g().d(DingMsgView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        setMagnet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        findViewById(j.b.e.r0).setVisibility(0);
        findViewById(j.b.e.x4).setVisibility(8);
        com.frame.s0.g().d(DingMsgView.class);
        post(new Runnable() { // from class: com.v.e6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.p();
            }
        });
        i.b.j7.a().l(true);
    }

    static /* synthetic */ void s(TaskSimple taskSimple) {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        Task taskL = i.b.da.B().L(taskSimple.getId());
        i.b.da.B().f();
        i.b.da.B().e2(taskL, true);
    }

    static /* synthetic */ void u() {
        final int w = TaskChooseDialogView.getW();
        final int h2 = TaskChooseDialogView.getH();
        int iE = (com.frame.q1.e() - w) / 2;
        int iD = (com.frame.q1.d() - h2) / 2;
        final int iC = com.frame.n0.c("tcd_x", iE);
        final int iC2 = com.frame.n0.c("tcd_y", iD);
        com.frame.l1.e(new Runnable() { // from class: com.v.f6
            @Override // java.lang.Runnable
            public final void run() {
                ((TaskChooseDialogView) com.frame.s0.g().y(TaskChooseDialogView.class, iC, iC2, w, h2)).setOnChooseListener(new TaskChooseDialogView.b() { // from class: com.v.j6
                    @Override // com.v.TaskChooseDialogView.b
                    public final void a(TaskSimple taskSimple) {
                        FloatHandler.s(taskSimple);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w() {
        setMagnet(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(final View view) {
        post(new Runnable() { // from class: com.v.o6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.y(view);
            }
        });
    }

    public void O(String str) {
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
        if (!i.b.j7.a().g()) {
            post(new Runnable() { // from class: com.v.l6
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.N();
                }
            });
            return;
        }
        findViewById(j.b.e.r0).setVisibility(0);
        findViewById(j.b.e.x4).setVisibility(8);
        post(new Runnable() { // from class: com.v.c6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.L();
            }
        });
    }

    @Override // com.yl.float_ui.CanDragFloatView
    protected void endMove(boolean z) {
        super.endMove(z);
        FloatTopControllerView floatTopControllerView = (FloatTopControllerView) com.frame.s0.g().f(FloatTopControllerView.class);
        if (floatTopControllerView != null) {
            floatTopControllerView.b();
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        return new Point(com.frame.n0.c("fh_x", 150), com.frame.n0.c("fh_y", 150));
    }

    @Override // com.yl.float_ui.CanDragFloatView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (com.frame.s0.g().l(FloatHandlerRecord.class, FloatHandlerRun.class)) {
            com.frame.s0.g().j(this);
        }
    }

    @Override // android.view.View.OnClickListener
    /* renamed from: onClick, reason: merged with bridge method [inline-methods] */
    public void y(final View view) {
        int id = view.getId();
        if (id == j.b.e.M0) {
            ClickView.p();
            i.b.v8.m();
            if (!com.frame.w0.d()) {
                if (!i.b.da.B().O()) {
                    com.permission.x0.m().a();
                    Toast.makeText(com.frame.v0.g(), "请先开启无障碍权限", 0).show();
                    return;
                } else if (!i.b.y7.e()) {
                    i.b.y7.c("录制脚本", new Runnable() { // from class: com.v.k6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.A(view);
                        }
                    });
                    return;
                }
            }
            if (i.b.da.B().C().size() < 4 && com.frame.n0.a("guideAudio", true)) {
                i.b.da.B().B1("record.mp4");
            }
            if (new i.b.ea().d()) {
                i.b.v8.m().k();
                com.frame.l1.e(new Runnable() { // from class: com.v.p6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.C();
                    }
                });
                return;
            }
            return;
        }
        if (id == j.b.e.z0) {
            findViewById(j.b.e.r0).setVisibility(0);
            findViewById(j.b.e.x4).setVisibility(8);
            post(new Runnable() { // from class: com.v.r6
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l();
                }
            });
            i.b.j7.a().l(true);
            return;
        }
        if (id == j.b.e.h0) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("关闭操作面板后，如果想要再次开启面板，需要进入应用开启服务。");
            dingMsgView.i("关闭", new View.OnClickListener() { // from class: com.v.n6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.n(view2);
                }
            });
            dingMsgView.k("最小化", new View.OnClickListener() { // from class: com.v.b6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.r(view2);
                }
            });
            dingMsgView.l("温馨提示");
            return;
        }
        if (id == j.b.e.S0) {
            i.b.a9.g();
            if (com.frame.w0.d() || (Build.VERSION.SDK_INT >= 28 && i.b.da.B().O())) {
                com.frame.l1.g(new Runnable() { // from class: com.v.m6
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatHandler.u();
                    }
                });
                return;
            } else {
                com.permission.x0.m().a();
                Toast.makeText(com.frame.v0.g(), "请先开启无障碍权限", 0).show();
                return;
            }
        }
        int i2 = j.b.e.r0;
        if (id == i2) {
            findViewById(i2).setVisibility(8);
            findViewById(j.b.e.x4).setVisibility(0);
            post(new Runnable() { // from class: com.v.q6
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.w();
                }
            });
            i.b.j7.a().l(false);
            return;
        }
        if (id == j.b.e.x0) {
            if (com.frame.w0.d() || (Build.VERSION.SDK_INT >= 28 && i.b.da.B().O())) {
                com.frame.l1.f(it.c, 50L);
            } else {
                com.permission.x0.m().a();
                Toast.makeText(com.frame.v0.g(), "请先开启无障碍权限", 0).show();
            }
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public boolean onOutScreen() {
        if (this.c) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("已拖到屏幕边缘，是要最小化还是关闭呢？关闭后如需再显示就需要打开APP点击显示悬浮条。");
            dingMsgView.i("关闭", new View.OnClickListener() { // from class: com.v.a6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.E(view);
                }
            });
            dingMsgView.k("最小化", new View.OnClickListener() { // from class: com.v.g6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.I(view);
                }
            });
            dingMsgView.l("温馨提示");
        }
        return super.onOutScreen();
    }

    @Override // com.yl.float_ui.CanDragFloatView
    protected void onScroll(final int i2, final int i3) {
        if (this.magnet) {
            final FloatTopControllerView floatTopControllerViewH = FloatTopControllerView.h();
            com.frame.l1.e(new Runnable() { // from class: com.v.d6
                @Override // java.lang.Runnable
                public final void run() {
                    FloatHandler.J(floatTopControllerViewH, i2, i3);
                }
            });
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0 && com.frame.s0.g().l(FloatHandlerRecord.class, FloatHandlerRun.class)) {
            com.frame.s0.g().j(this);
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("fh_x", point.x);
        com.frame.n0.i("fh_y", point.y);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void setMagnet(boolean z) {
        boolean z2;
        this.magnet = z;
        boolean z3 = true;
        if (z) {
            ImageView imageView = (ImageView) findViewById(j.b.e.r0);
            if (this.xx > (com.frame.k0.c().e() - getWidth()) / 2) {
                this.xx = com.frame.k0.c().e() - getWidth();
                imageView.setBackgroundResource(j.b.d.c);
                imageView.setImageResource(j.b.d.f1744k);
            } else {
                imageView.setBackgroundResource(j.b.d.b);
                imageView.setImageResource(j.b.d.f1743j);
                this.xx = 0;
            }
            if (this.yy == 0) {
                this.yy = loadXY().y;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.xx < 0) {
            this.xx = 0;
            z2 = true;
        }
        if (this.yy < 0) {
            this.yy = 0;
            z2 = true;
        }
        if (this.xx + getWidth() > com.frame.k0.c().e()) {
            this.xx = com.frame.k0.c().e() - getWidth();
            z2 = true;
        }
        if (this.yy + getHeight() > com.frame.k0.c().d()) {
            this.yy = com.frame.k0.c().d() - getHeight();
        } else {
            z3 = z2;
        }
        if (z3) {
            move(this.xx, this.yy);
        }
    }

    public void setToolbarBorder(boolean z) {
        this.c = z;
    }

    public FloatHandler(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatHandler(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public FloatHandler() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.p0, this);
        int i2 = j.b.e.M0;
        View viewFindViewById = findViewById(i2);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById2 = findViewById(j.b.e.x0);
        viewFindViewById2.setOnClickListener(this);
        viewFindViewById2.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById3 = findViewById(j.b.e.S0);
        viewFindViewById3.setOnClickListener(this);
        viewFindViewById3.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById4 = findViewById(j.b.e.r0);
        viewFindViewById4.setOnClickListener(this);
        viewFindViewById4.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById5 = findViewById(j.b.e.h0);
        viewFindViewById5.setOnClickListener(this);
        viewFindViewById5.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById6 = findViewById(j.b.e.z0);
        viewFindViewById6.setOnClickListener(this);
        viewFindViewById6.setOnTouchListener(this.mSubTouchListener);
        if (i.b.j7.a().d()) {
            viewFindViewById6.setVisibility(0);
        } else {
            viewFindViewById6.setVisibility(8);
        }
        if (i.b.da.q) {
            findViewById(i2).setVisibility(8);
        }
        this.c = i.b.j7.a().e();
        post(new Runnable() { // from class: com.v.h6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.j();
            }
        });
    }
}

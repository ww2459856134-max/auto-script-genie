package com.v;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.v.FloatButtonConfigDialogView;
import com.v.ItemChooseDialogView;
import com.yl.float_ui.CanDragFloatView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.FloatButtonConfig;
import com.yl.model.Task;
import i.b.da;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class FloatButton extends CanDragFloatView implements View.OnClickListener {
    private long c;
    private FloatButtonConfig d;
    private int e;
    private ColorView f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    int f952h;

    class a implements da.a {
        final /* synthetic */ Task a;

        a(Task task) {
            this.a = task;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            FloatButton.this.setDefaultState();
        }

        @Override // i.b.da.a
        public void a() {
            if (this.a.isShowBar()) {
                ((FloatHandlerRun) com.frame.s0.g().h(FloatHandlerRun.class)).O();
            }
        }

        @Override // i.b.da.a
        public void b() {
            com.frame.l1.e(new Runnable() { // from class: com.v.j5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d();
                }
            });
        }
    }

    class b implements da.a {
        final /* synthetic */ Task a;

        b(Task task) {
            this.a = task;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            FloatButton.this.setDefaultState();
        }

        @Override // i.b.da.a
        public void a() {
            if (this.a.isShowBar()) {
                ((FloatHandlerRun) com.frame.s0.g().h(FloatHandlerRun.class)).O();
            }
        }

        @Override // i.b.da.a
        public void b() {
            com.frame.l1.e(new Runnable() { // from class: com.v.k5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d();
                }
            });
        }
    }

    public FloatButton() {
        super(com.frame.v0.g());
        this.f952h = -16711936;
        this.magnet = false;
        View.inflate(com.frame.v0.g(), j.b.f.m0, this);
        this.g = (TextView) findViewById(j.b.e.t5);
        ColorView colorView = (ColorView) findViewById(j.b.e.c);
        this.f = colorView;
        colorView.setOnClickListener(this);
        this.f.setOnTouchListener(this.mSubTouchListener);
        this.f.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.v.q5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.c.j(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean j(View view) {
        if (this.isDragging) {
            return true;
        }
        s();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(FloatButtonConfig floatButtonConfig) {
        try {
            endMove(false);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
            int i2 = this.e;
            layoutParams.width = i2;
            layoutParams.height = i2;
            layoutParams.x = Math.abs(floatButtonConfig.x);
            layoutParams.y = Math.abs(floatButtonConfig.y);
            layoutParams.alpha = floatButtonConfig.alpha;
            com.frame.s0.g().I(this, layoutParams);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void n(FloatButtonConfig floatButtonConfig) {
        i.b.w7.g().r();
        i.b.w7.g().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = (String) list.get(i2);
        if ("编辑按钮".equals(str)) {
            this.d.taskId = i.b.da.B().L(this.c).getId();
            FloatButtonConfigDialogView floatButtonConfigDialogView = (FloatButtonConfigDialogView) com.frame.s0.g().B(FloatButtonConfigDialogView.class);
            floatButtonConfigDialogView.i(this.d);
            floatButtonConfigDialogView.j(new FloatButtonConfigDialogView.c() { // from class: com.v.i5
                @Override // com.v.FloatButtonConfigDialogView.c
                public final void a(FloatButtonConfig floatButtonConfig) {
                    FloatButton.n(floatButtonConfig);
                }
            });
            return;
        }
        if ("修改参数".equals(str)) {
            Task taskL = i.b.da.B().L(this.c);
            if (TextUtils.isEmpty(taskL.getArgumentJson())) {
                FloatToast.i("没有预置的参数");
                return;
            } else {
                com.frame.s0.g().d(ItemChooseDialogView.class);
                ((ArgumentSetDialogView) com.frame.s0.g().B(ArgumentSetDialogView.class)).setTask(taskL);
                return;
            }
        }
        if ("编辑脚本".equals(str)) {
            Task taskL2 = i.b.da.B().L(this.c);
            if (taskL2 != null) {
                NodeListDialogView.h1(taskL2.getId());
                return;
            }
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("未找到任务~");
            dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.o5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.l5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.l("温馨提示");
            return;
        }
        if ("锁定按钮位置".equals(str) || "解除锁定按钮位置".equals(str)) {
            this.d.lockPosition = !r3.lockPosition;
            i.b.w7.g().r();
        } else if ("删除按钮".equals(str)) {
            i.b.w7.g().q(this.d);
        }
    }

    private void s() {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择菜单");
        if (this.d.lockPosition) {
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("编辑按钮,编辑脚本,修改参数,解除锁定按钮位置,删除按钮".split(","))));
        } else {
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("编辑按钮,编辑脚本,修改参数,锁定按钮位置,删除按钮".split(","))));
        }
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.p5
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.r(i2, list);
            }
        });
    }

    public long getConfigId() {
        return this.d.id;
    }

    public long getTaskId() {
        return this.c;
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        if (this.d == null) {
            return new Point(100, 100);
        }
        FloatButtonConfig floatButtonConfig = this.d;
        return new Point(floatButtonConfig.x, floatButtonConfig.y);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    protected void move(float f, float f2) {
        FloatButtonConfig floatButtonConfig = this.d;
        if (floatButtonConfig == null || floatButtonConfig.lockPosition) {
            return;
        }
        floatButtonConfig.x = (int) f;
        floatButtonConfig.y = (int) f2;
        com.frame.s0 s0VarG = com.frame.s0.g();
        int iAbs = (int) Math.abs(f);
        int iAbs2 = (int) Math.abs(f2);
        int i2 = this.e;
        s0VarG.H(this, iAbs, iAbs2, i2, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (i.b.da.B().U()) {
                i.b.t9 t9VarN = i.b.da.B().N();
                if (t9VarN == null || t9VarN.l() == null || this.d.taskId != t9VarN.l().getId()) {
                    i.b.da.B().h2();
                    setSelectState();
                    Task taskL = i.b.da.B().L(this.c);
                    com.frame.y0.j("点击悬浮按钮停止当前，并切换执行脚本:" + taskL.getName());
                    i.b.da.B().f();
                    i.b.da.B().b2(taskL, null, i.b.j7.a().f(), new a(taskL), true);
                } else {
                    com.frame.y0.j("点击悬浮停止当前脚本");
                    i.b.da.B().h2();
                    setDefaultState();
                }
            } else {
                setSelectState();
                Task taskL2 = i.b.da.B().L(this.c);
                com.frame.y0.j("点击悬浮按钮执行脚本:" + taskL2.getName());
                i.b.da.B().f();
                i.b.da.B().b2(taskL2, null, i.b.j7.a().f(), new b(taskL2), true);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            Toast.makeText(com.frame.v0.g(), "未找到任务", 0).show();
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void onRotationMove() {
        if (this.d.lockPosition) {
            return;
        }
        super.onRotationMove();
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        FloatButtonConfig floatButtonConfig = this.d;
        if (floatButtonConfig != null) {
            floatButtonConfig.x = point.x;
            floatButtonConfig.y = point.y;
            i.b.w7.g().r();
            com.frame.l1.c(456546, new Runnable() { // from class: com.v.m5
                @Override // java.lang.Runnable
                public final void run() {
                    i.b.w7.g().r();
                }
            }, 10000L);
        }
    }

    public void setCurrentColor(int i2) {
        this.f.setBoundColor(i2);
        this.f.invalidate();
        this.g.setTextColor(i2);
    }

    public void setDefaultState() {
        if (this.d.hideInRun) {
            setVisibility(0);
        } else {
            setCurrentColor(-1);
        }
    }

    public void setSelectState() {
        if (this.d.hideInRun) {
            setVisibility(8);
        } else {
            setCurrentColor(this.f952h);
        }
    }

    public void setSelectedColor(int i2) {
        this.f952h = i2;
    }

    public void setup(final FloatButtonConfig floatButtonConfig) {
        this.d = floatButtonConfig;
        this.c = floatButtonConfig.taskId;
        this.e = com.frame.p1.c(floatButtonConfig.radius) * 2;
        this.f.setBoundColor(-1);
        this.f.setColor(floatButtonConfig.color);
        int i2 = floatButtonConfig.textColor;
        if (i2 != 0) {
            this.g.setTextColor(i2);
        }
        if (!TextUtils.isEmpty(floatButtonConfig.text)) {
            this.g.setText(floatButtonConfig.text);
        }
        post(new Runnable() { // from class: com.v.n5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.m(floatButtonConfig);
            }
        });
    }
}

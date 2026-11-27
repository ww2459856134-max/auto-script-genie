package com.v;

import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.s.BoxService;
import com.v.LooperCountDurationDialogView;
import com.yl.float_ui.CanDragFloatView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Task;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FloatHandlerRecord extends CanDragFloatView implements View.OnClickListener {
    private LinearLayout c;
    private Chronometer d;
    private View e;
    private View f;

    class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ TextView a;
        final /* synthetic */ TextView b;

        a(FloatHandlerRecord floatHandlerRecord, TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.a.setVisibility(z ? 0 : 8);
            this.b.setVisibility(z ? 0 : 8);
        }
    }

    public FloatHandlerRecord(Context context) {
        super(context);
    }

    static /* synthetic */ void i(Task task) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        NodeListDialogView.h1(task.getId());
    }

    static /* synthetic */ void j(TextView textView, Task task, TextView textView2, String str) {
        textView.setText("循环次数：" + task.getRepeatCount());
        textView2.setText("循环间隔：" + task.getRepeatDelay());
    }

    static /* synthetic */ void k(final Task task, final TextView textView, final TextView textView2, View view) {
        LooperCountDurationDialogView looperCountDurationDialogView = (LooperCountDurationDialogView) com.frame.s0.g().B(LooperCountDurationDialogView.class);
        looperCountDurationDialogView.setTask(task);
        looperCountDurationDialogView.setAutoSave(false);
        looperCountDurationDialogView.y(new LooperCountDurationDialogView.a() { // from class: com.v.u6
            @Override // com.v.LooperCountDurationDialogView.a
            public final void a(String str) {
                FloatHandlerRecord.j(textView, task, textView2, str);
            }
        });
    }

    static /* synthetic */ void m(Task task) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        NodeListDialogView.h1(task.getId());
    }

    static /* synthetic */ boolean n(final Task task, String str) {
        if (TextUtils.isEmpty(str)) {
            task.setName("未命名" + (new ArrayList(i.b.da.B().C()).size() + 1));
        } else {
            String strTrim = str.trim();
            if (i.b.da.B().R(strTrim)) {
                try {
                    DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                    dingMsgView.g(j.b.d.q0);
                    dingMsgView.h("任务名请不要重复~~~");
                    dingMsgView.l("温馨提示");
                    dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.a7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            com.frame.s0.g().d(DingMsgView.class);
                        }
                    });
                    dingMsgView.l("温馨提示");
                    return false;
                } catch (Exception e) {
                    com.frame.k0.r(e);
                    return false;
                }
            }
            task.setName(strTrim);
        }
        task.setId(System.currentTimeMillis());
        i.b.v8.m().l0();
        i.b.da.B().R1(task);
        if (i.b.da.B().C().size() < 4 && com.frame.n0.a("guideAudio", true)) {
            i.b.da.B().B1("record_finish.mp4");
        }
        com.yl.ui.i0.l(new Runnable() { // from class: com.v.x6
            @Override // java.lang.Runnable
            public final void run() {
                FloatHandlerRecord.m(task);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(final Task task) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.s("请输入任务名称");
        inputDialogView.findViewById(j.b.e.w6).setVisibility(8);
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.c1, null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(j.b.e.m1);
        final TextView textView = (TextView) viewInflate.findViewById(j.b.e.q6);
        final TextView textView2 = (TextView) viewInflate.findViewById(j.b.e.r6);
        checkBox.setOnCheckedChangeListener(new a(this, textView, textView2));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.v.v6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatHandlerRecord.k(task, textView, textView2, view);
            }
        };
        textView2.setText("循环间隔：" + task.getRepeatDelay() + "ms");
        textView2.setOnClickListener(onClickListener);
        textView.setText("循环次数：" + task.getRepeatCount());
        textView.setOnClickListener(onClickListener);
        inputDialogView.a(viewInflate);
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.d7
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return FloatHandlerRecord.n(task, str);
            }
        });
    }

    static /* synthetic */ void q(View view) {
        i.b.ka.x5 x5VarE = i.b.x7.d().e(((Integer) view.getTag()).intValue());
        if (x5VarE != null) {
            x5VarE.R(0, null);
        } else {
            i.b.da.B().w1("未找到录制操作...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(String[] strArr, View.OnClickListener onClickListener, int i2, int i3) {
        int i4;
        i.b.ka.x5 x5VarE;
        this.c.removeAllViews();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && (x5VarE = i.b.x7.d().e((i4 = Integer.parseInt(str)))) != null) {
                ImageView imageView = new ImageView(com.frame.v0.g());
                imageView.setImageResource(x5VarE.r());
                imageView.setTag(Integer.valueOf(i4));
                imageView.setOnClickListener(onClickListener);
                imageView.setOnTouchListener(this.mSubTouchListener);
                imageView.setPadding(i2, i2, i2, i2);
                this.c.addView(imageView, i3, i3);
            }
        }
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i3;
            this.f.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.e.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        i.b.x7.d();
        final String[] strArrSplit = com.frame.n0.f("optToolBar", "3,4,10,19").split(",");
        String strF = com.frame.n0.f("tbSize1", "custom");
        final int iC = strF.equals("custom") ? com.frame.p1.c(35.0f) : strF.equals("small") ? com.frame.p1.c(28.0f) : strF.equals("big") ? com.frame.p1.c(45.0f) : 35;
        final int iC2 = com.frame.p1.c(8.0f);
        final y6 y6Var = new View.OnClickListener() { // from class: com.v.y6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatHandlerRecord.q(view);
            }
        };
        com.frame.l1.e(new Runnable() { // from class: com.v.e7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.s(strArrSplit, y6Var, iC2, iC);
            }
        });
    }

    public static FloatHandlerRecord w() {
        return (FloatHandlerRecord) com.frame.s0.g().y(FloatHandlerRecord.class, com.frame.n0.c("fhr_x", 0), com.frame.n0.c("fhr_y", 100), -2, -2);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        return new Point(com.frame.n0.c("fhr_x", 0), com.frame.n0.c("fhr_y", 100));
    }

    @Override // com.yl.float_ui.CanDragFloatView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.frame.s0.g().i(FloatHandler.class);
        i.b.w7.g().d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.A0) {
            return;
        }
        if (id == j.b.e.N0) {
            com.frame.s0.g().a(GesturePlayFloatView.class);
            com.frame.s0.g().a(MultiGestureRecordFloatView.class);
            y();
            final Task taskP = i.b.v8.m().p();
            if (taskP == null) {
                Toast.makeText(com.frame.v0.g(), "录制出错", 0).show();
                return;
            }
            if (TextUtils.isEmpty(taskP.getName())) {
                com.frame.l1.f(new Runnable() { // from class: com.v.w6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.p(taskP);
                    }
                }, 100L);
            } else if (taskP.getId() != 0) {
                i.b.da.B().R1(taskP);
                com.yl.ui.i0.l(new Runnable() { // from class: com.v.z6
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatHandlerRecord.i(taskP);
                    }
                });
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i.b.w7.g().p();
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("fhr_x", point.x);
        com.frame.n0.i("fhr_y", point.y);
    }

    public void v() {
        com.frame.l1.g(new Runnable() { // from class: com.v.b7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.u();
            }
        });
    }

    public void x() {
        Chronometer chronometer = (Chronometer) findViewById(j.b.e.p6);
        this.d = chronometer;
        chronometer.setBase(SystemClock.elapsedRealtime());
        this.d.setFormat("%s");
        this.d.start();
    }

    public void y() {
        if (!com.frame.s0.g().m(FloatHandlerRun.class)) {
            post(new Runnable() { // from class: com.v.jb
                @Override // java.lang.Runnable
                public final void run() {
                    FloatHandler.P();
                }
            });
        }
        com.frame.s0.g().o(this);
        Chronometer chronometer = this.d;
        if (chronometer != null) {
            try {
                chronometer.stop();
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    public FloatHandlerRecord(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatHandlerRecord(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public FloatHandlerRecord() {
        super(com.frame.v0.g());
        setMagnet(false);
        View.inflate(com.frame.v0.g(), j.b.f.r0, this);
        if (com.frame.w0.d()) {
            BoxService.m().x();
        }
        this.c = (LinearLayout) findViewById(j.b.e.H4);
        View viewFindViewById = findViewById(j.b.e.N0);
        this.e = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.e.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById2 = findViewById(j.b.e.A0);
        this.f = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.f.setOnTouchListener(this.mSubTouchListener);
        v();
        com.frame.l1.f(new Runnable() { // from class: com.v.c7
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().E(GesturePlayFloatView.class);
            }
        }, 100L);
        x();
        com.frame.s0.g().x(MultiGestureRecordFloatView.class);
    }
}

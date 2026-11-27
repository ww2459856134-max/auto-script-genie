package com.v;

import android.graphics.Rect;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.g0;
import com.v.item.ImageAreaChooseItem;
import com.v.item.InputItem;
import com.v.item.OffersetChooseItem;
import com.v.item.ParamNameTextView;
import com.v.item.SelectAndDelayItem;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class ToggleParamsCreateDialogView extends RelativeLayout implements View.OnClickListener {
    private InputItem A;
    private boolean C;
    private SelectAndDelayItem D;
    private SelectAndDelayItem G;
    private Node H;
    private View c;
    private View d;
    private View e;
    private OffersetChooseItem f;
    private InputItem g;

    /* renamed from: h, reason: collision with root package name */
    private ImageAreaChooseItem f1074h;

    /* renamed from: i, reason: collision with root package name */
    private lt f1075i;

    /* renamed from: j, reason: collision with root package name */
    protected TextView f1076j;

    /* renamed from: k, reason: collision with root package name */
    protected TextView f1077k;
    private Task t;

    class a extends CountDownTimer {
        a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ToggleParamsCreateDialogView.this.f1077k.setText("确定");
            ToggleParamsCreateDialogView.this.f1077k.setEnabled(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            ToggleParamsCreateDialogView.this.f1077k.setText("识别中(" + (j2 / 1000) + ")...");
        }
    }

    class b implements g0.c {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            com.frame.s0.g().o(ToggleParamsCreateDialogView.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(View view) {
            com.frame.s0.g().d(ToggleParamsCreateDialogView.class);
            com.frame.s0.g().d(DingMsgView.class);
            ToggleParamsCreateDialogView.this.f1075i.a(ToggleParamsCreateDialogView.this.H);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(View view) {
            view.setEnabled(true);
            FloatToast.g(j.b.d.l0, "未找到：『" + ToggleParamsCreateDialogView.this.g.getValue().toString() + "』");
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("未找到该文字元素，是否先添加节点？");
            dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.mq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.k("先添加", new View.OnClickListener() { // from class: com.v.pq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.g(view2);
                }
            });
            dingMsgView.l("温馨提示");
        }

        @Override // com.frame.g0.c
        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            if (accessibilityNodeInfo != null) {
                Rect rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                ToggleParamsCreateDialogView.this.H.setSrcRectNew(rect);
            }
            com.frame.l1.e(new Runnable() { // from class: com.v.nq
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d();
                }
            });
            ToggleParamsCreateDialogView.this.f1075i.a(ToggleParamsCreateDialogView.this.H);
        }

        @Override // com.frame.g0.c
        public void b() {
            final View view = this.a;
            com.frame.l1.e(new Runnable() { // from class: com.v.oq
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.i(view);
                }
            });
        }
    }

    public ToggleParamsCreateDialogView() {
        super(com.frame.v0.g());
        this.C = true;
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.R, (ViewGroup) this, true);
        InputItem inputItem = (InputItem) findViewById(j.b.e.A2);
        this.g = inputItem;
        inputItem.setUnitOnClickListener(new View.OnClickListener() { // from class: com.v.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.j(view);
            }
        });
        OffersetChooseItem offersetChooseItem = (OffersetChooseItem) findViewById(j.b.e.e4);
        this.f = offersetChooseItem;
        offersetChooseItem.setCallback(new lt() { // from class: com.v.wq
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.x(node);
            }
        });
        this.f1076j = (TextView) findViewById(j.b.e.P);
        this.f1077k = (TextView) findViewById(j.b.e.g);
        InputItem inputItem2 = (InputItem) findViewById(j.b.e.o4);
        this.A = inputItem2;
        inputItem2.setInputType(2);
        this.D = (SelectAndDelayItem) findViewById(j.b.e.h3);
        this.G = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.D.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.qq
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.z();
            }
        });
        this.D.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.rq
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.B();
            }
        });
        this.D.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.zq
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.D(str, str2);
            }
        });
        this.G.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.tq
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.F();
            }
        });
        this.G.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.cr
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.H();
            }
        });
        this.G.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.lq
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.J(str, str2);
            }
        });
        this.f1074h = (ImageAreaChooseItem) findViewById(j.b.e.Q3);
        View viewFindViewById = findViewById(j.b.e.u3);
        this.e = viewFindViewById;
        viewFindViewById.findViewById(j.b.e.c5).setOnClickListener(this);
        View view = this.e;
        int i2 = j.b.e.d5;
        view.findViewById(i2).setOnClickListener(this);
        this.e.findViewById(i2).callOnClick();
        this.c = findViewById(j.b.e.d1);
        this.d = findViewById(j.b.e.j0);
        this.c.setSelected(false);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.v.fr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.L(view2);
            }
        });
        this.d.setSelected(false);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.v.yq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.l(view2);
            }
        });
        this.f1076j.setOnClickListener(new View.OnClickListener() { // from class: com.v.br
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ToggleParamsCreateDialogView.m(view2);
            }
        });
        this.f1077k.setOnClickListener(new View.OnClickListener() { // from class: com.v.vq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.v(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String B() {
        return this.H.nextMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(String str, String str2) {
        Node node = this.H;
        node.nextDelay = str;
        node.nextMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String F() {
        return this.H.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String H() {
        return this.H.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(String str, String str2) {
        Node node = this.H;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(View view) {
        this.c.setSelected(!view.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f() {
        this.g.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        FloatToast.i("请输入要识别文字");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean h(String str) {
        InputItem inputItem = this.g;
        if (!str.startsWith("${")) {
            str = "${" + str + "}";
        }
        inputItem.setValue(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        new ParamNameTextView(com.frame.v0.g()).k(new InputDialogView.a() { // from class: com.v.xq
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.h(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(View view) {
        this.d.setSelected(!view.isSelected());
    }

    static /* synthetic */ void m(View view) {
        com.frame.s0.g().d(ToggleParamsCreateDialogView.class);
        MultiGestureRecordFloatView.c(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o() {
        this.A.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        FloatToast.i("请输入正确的超时时间");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(long j2) {
        this.f1077k.setText("识别中...");
        new a(j2, 1000L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(final View view) throws NumberFormatException {
        Node node;
        SystemClock.sleep(100L);
        try {
            final long j2 = Long.parseLong(this.A.getValue());
            if (d()) {
                com.frame.l1.e(new Runnable() { // from class: com.v.dr
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.q(j2);
                    }
                });
                this.H.text = this.g.getValue();
                this.H.arg2 = this.c.isSelected() ? "1" : "0";
                this.H.arg4 = this.d.isSelected() ? "1" : "0";
                this.H.setPointNew(this.f.getValue());
                this.H.what = ((View) this.e.getTag()).getId() == j.b.e.d5 ? 0 : 1;
                if (this.D.getVisibility() == 0 && this.G.getVisibility() == 0) {
                    if (!this.D.c() || !this.G.c()) {
                        return;
                    }
                    this.H.nextType = ((Integer) this.D.getValue()).intValue();
                    this.H.errorType = ((Integer) this.G.getValue()).intValue();
                    if (this.H.isJumOtherType()) {
                        this.H.nextTaskId = ((Long) this.D.getSubValue()).longValue();
                    } else {
                        Node node2 = this.H;
                        int i2 = node2.nextType;
                        if (i2 == 3 || i2 == 13) {
                            if (node2.nextId != ((Long) this.D.getSubValue()).longValue() && this.H.nextId != 0 && (node = this.t.getNodeMap().get(Long.valueOf(this.H.nextId))) != null) {
                                node.frontId = 0L;
                            }
                            this.H.nextId = ((Long) this.D.getSubValue()).longValue();
                        } else if (i2 == 9 || i2 == 11) {
                            node2.arg3 = this.D.getSelectSubLabel();
                            this.H.lineNextNodeAtIndex(this.t);
                        } else {
                            node2.lineNextNodeAtIndex(this.t);
                            this.H.arg3 = null;
                        }
                    }
                    if (this.G.getSubValue() != null) {
                        this.H.errorId = ((Long) this.G.getSubValue()).longValue();
                    }
                }
                Node node3 = this.H;
                node3.timeOut = j2;
                this.f1074h.p(node3);
                com.frame.l1.e(new Runnable() { // from class: com.v.sq
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setEnabled(false);
                    }
                });
                if (this.C) {
                    com.frame.g0.v().L(null, this.H.getArea(), null, null, i.b.da.B().G(this.g.getValue()), this.H.timeOut, 0L, this.H.what == 1, this.c.isSelected(), new AtomicReference<>(Boolean.TRUE), new b(view));
                } else {
                    com.frame.s0.g().o(this);
                    this.f1075i.a(this.H);
                }
            }
        } catch (Exception unused) {
            com.frame.l1.e(new Runnable() { // from class: com.v.er
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.o();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(final View view) {
        if (this.f1075i != null) {
            com.frame.l1.g(new Runnable() { // from class: com.v.uq
                @Override // java.lang.Runnable
                public final void run() throws NumberFormatException {
                    this.c.t(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Node node) {
        if (((Integer) this.D.getValue()).intValue() == 7) {
            this.D.setSelectValue(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String z() {
        return this.H.nextDelay;
    }

    public boolean d() {
        if (this.g.getVisibility() != 0 || !TextUtils.isEmpty(this.g.getValue())) {
            return true;
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.gr
            @Override // java.lang.Runnable
            public final void run() {
                this.c.f();
            }
        });
        return false;
    }

    public LinkedHashMap<String, Object> getNodeListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Long l2 : this.t.getNodeMap().keySet()) {
            Node node = this.t.getNodeMap().get(l2);
            if (node != null) {
                linkedHashMap.put(node.getStepAndName(), l2);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getParamListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        Set<String> set = this.t.params;
        if (set != null) {
            for (String str : set) {
                linkedHashMap.put(str, str);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getTaskListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (TaskSimple taskSimple : i.b.da.B().C()) {
            linkedHashMap.put(taskSimple.getName(), Long.valueOf(taskSimple.getId()));
        }
        return linkedHashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.c5 || id == j.b.e.d5) {
            if (this.e.getTag() != null) {
                ((View) this.e.getTag()).setSelected(false);
            }
            view.setSelected(true);
            this.e.setTag(view);
        }
    }

    public void setNeedAcceptScan(boolean z) {
        this.C = z;
    }

    public void setRect(Rect rect) {
    }
}

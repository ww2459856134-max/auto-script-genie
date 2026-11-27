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
import com.v.item.CheckItem;
import com.v.item.ImageAreaChooseItem;
import com.v.item.InputItem;
import com.v.item.OffersetChooseItem;
import com.v.item.ParamNameTextView;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.v.item.SelectItem;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.widget.TabLinearLayout;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class TextScanDialogView extends RelativeLayout implements View.OnClickListener {
    protected TextView A;
    protected TextView C;
    private Task D;
    private final InputItem G;
    private boolean H;
    private SelectAndDelayItem I;
    private final SelectAndDelayItem J;
    private Node K;
    private final TabLinearLayout M;
    private final SelectItem O;
    private final View c;
    private final TextView d;
    private final CheckItem e;
    private final RunConditionItem f;
    private final View g;

    /* renamed from: h, reason: collision with root package name */
    private final View f1070h;

    /* renamed from: i, reason: collision with root package name */
    private final OffersetChooseItem f1071i;

    /* renamed from: j, reason: collision with root package name */
    private final InputItem f1072j;

    /* renamed from: k, reason: collision with root package name */
    private final ImageAreaChooseItem f1073k;
    private lt t;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == j.b.e.L4) {
                TextScanDialogView.this.f1070h.setVisibility(0);
                TextScanDialogView.this.c.setVisibility(0);
                TextScanDialogView.this.g.setVisibility(0);
                TextScanDialogView.this.O.setVisibility(8);
                return;
            }
            if (id == j.b.e.M4) {
                TextScanDialogView.this.f1070h.setVisibility(8);
                TextScanDialogView.this.c.setVisibility(8);
                TextScanDialogView.this.g.setVisibility(8);
                TextScanDialogView.this.O.setVisibility(i.b.ja.i.b(TextScanDialogView.this.getContext().getPackageName()) ? 0 : 8);
            }
        }
    }

    class b extends CountDownTimer {
        b(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            TextScanDialogView.this.C.setText("确定");
            TextScanDialogView.this.C.setEnabled(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            TextScanDialogView.this.C.setText("识别中(" + (j2 / 1000) + ")...");
        }
    }

    class c implements g0.c {
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            com.frame.s0.g().o(TextScanDialogView.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(View view) {
            com.frame.s0.g().d(TextScanDialogView.class);
            com.frame.s0.g().d(DingMsgView.class);
            TextScanDialogView.this.t.a(TextScanDialogView.this.K);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(View view) {
            view.setEnabled(true);
            FloatToast.g(j.b.d.l0, "未找到：『" + TextScanDialogView.this.f1072j.getValue() + "』");
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("未找到该文字元素，是否先添加节点？");
            dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.mp
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.k("先添加", new View.OnClickListener() { // from class: com.v.np
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
                TextScanDialogView.this.K.setSrcRectNew(rect);
            }
            com.frame.l1.e(new Runnable() { // from class: com.v.kp
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d();
                }
            });
            TextScanDialogView.this.t.a(TextScanDialogView.this.K);
        }

        @Override // com.frame.g0.c
        public void b() {
            final View view = this.a;
            com.frame.l1.e(new Runnable() { // from class: com.v.lp
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.i(view);
                }
            });
        }
    }

    public TextScanDialogView() {
        super(com.frame.v0.g());
        this.H = true;
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.a0, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(j.b.e.L);
        this.d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.dq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextScanDialogView.l(view);
            }
        });
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.f = runConditionItem;
        runConditionItem.setAttachView(this);
        this.e = (CheckItem) findViewById(j.b.e.x2);
        InputItem inputItem = (InputItem) findViewById(j.b.e.A2);
        this.f1072j = inputItem;
        inputItem.setUnitOnClickListener(new View.OnClickListener() { // from class: com.v.jp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.L(view);
            }
        });
        OffersetChooseItem offersetChooseItem = (OffersetChooseItem) findViewById(j.b.e.e4);
        this.f1071i = offersetChooseItem;
        offersetChooseItem.setCallback(new lt() { // from class: com.v.zp
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.N(node);
            }
        });
        this.A = (TextView) findViewById(j.b.e.P);
        this.C = (TextView) findViewById(j.b.e.g);
        TabLinearLayout tabLinearLayout = (TabLinearLayout) findViewById(j.b.e.a5);
        this.M = tabLinearLayout;
        SelectItem selectItem = (SelectItem) findViewById(j.b.e.M2);
        this.O = selectItem;
        if (!i.b.ja.i.b(getContext().getPackageName())) {
            selectItem.setItems(new String[]{"默认OCR（内置）"});
            selectItem.setVisibility(8);
        }
        selectItem.setOnItemClick(new SelectItem.a() { // from class: com.v.bq
            @Override // com.v.item.SelectItem.a
            public final void a(boolean z, int i2, Object obj, String str) {
                this.a.P(z, i2, obj, str);
            }
        });
        InputItem inputItem2 = (InputItem) findViewById(j.b.e.o4);
        this.G = inputItem2;
        inputItem2.setInputType(2);
        this.I = (SelectAndDelayItem) findViewById(j.b.e.h3);
        SelectAndDelayItem selectAndDelayItem = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.J = selectAndDelayItem;
        this.I.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.fq
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.R();
            }
        });
        this.I.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.wp
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.T();
            }
        });
        this.I.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.iq
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.V(str, str2);
            }
        });
        selectAndDelayItem.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.yp
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.X();
            }
        });
        selectAndDelayItem.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.aq
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.n();
            }
        });
        selectAndDelayItem.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.eq
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.p(str, str2);
            }
        });
        this.f1073k = (ImageAreaChooseItem) findViewById(j.b.e.Q3);
        View viewFindViewById = findViewById(j.b.e.u3);
        this.f1070h = viewFindViewById;
        viewFindViewById.findViewById(j.b.e.c5).setOnClickListener(this);
        int i2 = j.b.e.d5;
        viewFindViewById.findViewById(i2).setOnClickListener(this);
        viewFindViewById.findViewById(i2).callOnClick();
        View viewFindViewById2 = findViewById(j.b.e.d1);
        this.c = viewFindViewById2;
        View viewFindViewById3 = findViewById(j.b.e.j0);
        this.g = viewFindViewById3;
        viewFindViewById2.setSelected(false);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.v.qp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r(view);
            }
        });
        viewFindViewById3.setSelected(false);
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.v.hq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.t(view);
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.v.jq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextScanDialogView.u(view);
            }
        });
        tabLinearLayout.setTabClickListener(new a());
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.v.gq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.J(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D() {
        this.t.a(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean F(String str) {
        InputItem inputItem = this.f1072j;
        if (!str.startsWith("${")) {
            str = "${" + str + "}";
        }
        inputItem.setValue(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(final View view) throws NumberFormatException {
        Node node;
        SystemClock.sleep(100L);
        try {
            final long j2 = Long.parseLong(this.G.getValue());
            if (h()) {
                try {
                    this.K.argInt1 = Integer.valueOf(this.d.getText().toString().replace("毫秒", "").replace("滑动间隔时间：", "")).intValue();
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
                this.K.whatIndex = this.M.getSelectedTabViewId() == j.b.e.L4 ? 0 : 1;
                String strC = i.b.ja.i.c(this.O.getSelectLabel().startsWith("Paddle") ? "paddle" : i.b.ja.i.a, getContext().getPackageName());
                if (this.K.whatIndex == 1 && i.b.ja.i.a(strC) && !i.b.ja.o.a()) {
                    com.frame.l1.e(new Runnable() { // from class: com.v.sp
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.y();
                        }
                    });
                    return;
                }
                Node node2 = this.K;
                if (node2.whatIndex != 1) {
                    strC = null;
                }
                node2.ocrEngine = strC;
                node2.text = this.f1072j.getValue();
                this.K.arg2 = this.c.isSelected() ? "1" : "0";
                this.K.arg4 = this.g.isSelected() ? "1" : "0";
                this.K.setPointNew(this.f1071i.getValue());
                this.K.arg5 = this.e.getValue().booleanValue() ? "1" : "0";
                this.K.what = ((View) this.f1070h.getTag()).getId() == j.b.e.d5 ? 0 : 1;
                if (this.I.getVisibility() == 0 && this.J.getVisibility() == 0) {
                    if (!this.I.c() || !this.J.c()) {
                        return;
                    }
                    this.K.nextType = ((Integer) this.I.getValue()).intValue();
                    this.K.errorType = ((Integer) this.J.getValue()).intValue();
                    if (this.K.isJumOtherType()) {
                        this.K.nextTaskId = ((Long) this.I.getSubValue()).longValue();
                    } else {
                        Node node3 = this.K;
                        int i2 = node3.nextType;
                        if (i2 == 3 || i2 == 13) {
                            if (node3.nextId != ((Long) this.I.getSubValue()).longValue() && this.K.nextId != 0 && (node = this.D.getNodeMap().get(Long.valueOf(this.K.nextId))) != null) {
                                node.frontId = 0L;
                            }
                            this.K.nextId = ((Long) this.I.getSubValue()).longValue();
                        } else if (i2 == 9 || i2 == 11) {
                            node3.arg3 = this.I.getSelectSubLabel();
                            this.K.lineNextNodeAtIndex(this.D);
                        } else {
                            node3.lineNextNodeAtIndex(this.D);
                            this.K.arg3 = null;
                        }
                    }
                    if (this.J.getSubValue() != null) {
                        this.K.errorId = ((Long) this.J.getSubValue()).longValue();
                    }
                }
                Node node4 = this.K;
                node4.timeOut = j2;
                this.f1073k.p(node4);
                if (!this.H || this.K.whatIndex != 0) {
                    com.frame.s0.g().d(TextScanDialogView.class);
                    post(new Runnable() { // from class: com.v.pp
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.D();
                        }
                    });
                } else {
                    com.frame.l1.e(new Runnable() { // from class: com.v.vp
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.A(j2);
                        }
                    });
                    com.frame.l1.e(new Runnable() { // from class: com.v.up
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.setEnabled(false);
                        }
                    });
                    com.frame.g0.v().L(null, this.K.getArea(), null, null, i.b.da.B().G(this.f1072j.getValue()), this.K.timeOut, 0L, this.K.what == 1, this.c.isSelected(), new AtomicReference<>(Boolean.TRUE), new c(view));
                }
            }
        } catch (Exception unused) {
            com.frame.l1.e(new Runnable() { // from class: com.v.cq
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.w();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(final View view) {
        if (this.t == null) {
            return;
        }
        com.frame.l1.g(new Runnable() { // from class: com.v.tp
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.c.H(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(View view) {
        new ParamNameTextView(com.frame.v0.g()).k(new InputDialogView.a() { // from class: com.v.op
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.F(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Node node) {
        if (((Integer) this.I.getValue()).intValue() == 7) {
            this.I.setSelectValue(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(boolean z, int i2, Object obj, String str) {
        if (z && str.startsWith("Paddle") && !i.b.ja.o.a()) {
            this.O.setSelectLabel("默认OCR（内置）");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String R() {
        return this.K.nextDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String T() {
        return this.K.nextMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(String str, String str2) {
        Node node = this.K;
        node.nextDelay = str;
        node.nextMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String X() {
        return this.K.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j() {
        this.f1072j.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        FloatToast.i("请输入要识别文字");
    }

    static /* synthetic */ boolean k(TextView textView, String str) {
        textView.setText("滑动间隔时间：" + str + "毫秒");
        return true;
    }

    static /* synthetic */ void l(View view) {
        final TextView textView = (TextView) view;
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("滑动间隔时间");
        inputDialogView.w(textView.getText().toString().replace("毫秒", "").replace("滑动间隔时间：", ""));
        inputDialogView.s("请输入滑动间隔时间");
        inputDialogView.x("毫秒");
        inputDialogView.u(2);
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.xp
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return TextScanDialogView.k(textView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String n() {
        return this.K.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(String str, String str2) {
        Node node = this.K;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        this.c.setSelected(!view.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(View view) {
        this.g.setSelected(!view.isSelected());
    }

    static /* synthetic */ void u(View view) {
        com.frame.s0.g().d(TextScanDialogView.class);
        MultiGestureRecordFloatView.c(0L);
        com.frame.s0.g().v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w() {
        this.G.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        FloatToast.i("请输入正确的超时时间");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y() {
        this.O.setSelectLabel("默认OCR（内置）");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(long j2) {
        this.C.setText("识别中...");
        new b(j2, 1000L).start();
    }

    public TextScanDialogView Y(lt ltVar) {
        this.t = ltVar;
        return this;
    }

    public TextScanDialogView Z(Task task, Node node) {
        this.D = task;
        this.K = node;
        if (node != null) {
            this.f.setTaskNode(task, node);
            this.f1073k.setValue(node.getSrcRect(), this.K.getArea(), this.K.areaParam);
            this.f1071i.setValue(node.getSrcRect(), this.K.getPoint());
            this.e.setValue(!"0".equals(node.arg5));
            this.d.setText("滑动间隔时间：" + node.argInt1 + "毫秒");
            if (node.whatIndex == 1) {
                this.M.b(j.b.e.M4);
            } else {
                this.M.b(j.b.e.L4);
            }
            this.O.setSelectLabel(i.b.ja.i.a(i.b.ja.i.c(node.ocrEngine, getContext().getPackageName())) ? "Paddle OCR（插件内测）" : "默认OCR（内置）");
            LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("跳转任务", null);
            linkedHashMap.put("点击后跳任务", null);
            linkedHashMap.put("跳转节点", null);
            linkedHashMap.put("点击后跳节点", null);
            LinkedHashMap<String, Object> paramListMap = getParamListMap();
            linkedHashMap.put("将文本给变量", paramListMap);
            linkedHashMap.put("将坐标给变量", paramListMap);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("点击文字", 7);
            linkedHashMap2.put("模拟点击", 0);
            linkedHashMap2.put("点击后跳任务", 12);
            linkedHashMap2.put("点击后跳节点", 13);
            linkedHashMap2.put("点击文字内随机坐标", 10);
            linkedHashMap2.put("将文字复制至剪切板", 8);
            linkedHashMap2.put("将文本给变量", 9);
            linkedHashMap2.put("将坐标给变量", 11);
            linkedHashMap2.put("长按文字", 5);
            linkedHashMap2.put("跳转节点", 3);
            linkedHashMap2.put("跳转任务", 4);
            linkedHashMap2.put("结束任务", -3);
            linkedHashMap2.put("结束子任务/循环", -4);
            linkedHashMap2.put("跳转下一个节点", 2);
            this.I.setItems(linkedHashMap2, linkedHashMap);
            this.I.setSubHint("请选择");
            SelectAndDelayItem selectAndDelayItem = this.I;
            selectAndDelayItem.setOnItemClick(new com.v.item.k2(this.D, this.K, selectAndDelayItem, this.f1071i));
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("跳转节点", 3);
            linkedHashMap3.put("跳转任务", 4);
            linkedHashMap3.put("结束任务", -3);
            linkedHashMap3.put("结束子任务/循环", -4);
            linkedHashMap3.put("弹窗报错", -2);
            linkedHashMap3.put("跳转下一个节点", 2);
            linkedHashMap3.put("分支节点", 6);
            this.J.setItems(linkedHashMap3, linkedHashMap);
            this.J.setSubHint("请选择");
            SelectAndDelayItem selectAndDelayItem2 = this.J;
            selectAndDelayItem2.setOnItemClick(new com.v.item.j2(this.D, this.K, selectAndDelayItem2));
            this.I.setSelectValue(Integer.valueOf(node.nextType));
            this.J.setSelectValue(Integer.valueOf(node.errorType));
            this.f1072j.setValue(node.text);
            this.G.setValue(node.timeOut + "");
            if (node.what == 0) {
                findViewById(j.b.e.d5).callOnClick();
            } else {
                findViewById(j.b.e.c5).callOnClick();
            }
            this.f1071i.setValue(this.K.getSrcRect(), this.K.getPoint());
            node.getSrcRect();
            this.c.setSelected("1".equals(node.arg2));
            this.g.setSelected("1".equals(node.arg4));
        }
        return this;
    }

    public LinkedHashMap<String, Object> getParamListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        Set<String> set = this.D.params;
        if (set != null) {
            for (String str : set) {
                linkedHashMap.put(str, str);
            }
        }
        return linkedHashMap;
    }

    public boolean h() {
        if (this.f1072j.getVisibility() != 0 || !TextUtils.isEmpty(this.f1072j.getValue())) {
            return true;
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.rp
            @Override // java.lang.Runnable
            public final void run() {
                this.c.j();
            }
        });
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.c5 || id == j.b.e.d5) {
            if (this.f1070h.getTag() != null) {
                ((View) this.f1070h.getTag()).setSelected(false);
            }
            view.setSelected(true);
            this.f1070h.setTag(view);
        }
    }

    public void setMiniModel() {
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.G.setVisibility(8);
        this.f.setVisibility(8);
        this.f1071i.setVisibility(8);
        this.c.setVisibility(8);
    }

    public void setNeedAcceptScan(boolean z) {
        this.H = z;
    }

    public void setRect(Rect rect) {
    }
}

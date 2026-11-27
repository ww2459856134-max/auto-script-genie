package com.v;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.PageScanFloatView;
import com.v.item.AreaChooseItem;
import com.v.item.CheckItem;
import com.v.item.InputItem;
import com.v.item.OffersetChooseItem;
import com.v.item.ParamNameTextView;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.v.item.SelectItem;
import com.v.item.WidgetScanItem;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class WidgetScanDialogView extends RelativeLayout implements View.OnClickListener {
    private SelectItem A;
    private lt C;
    protected TextView D;
    protected TextView G;
    private Task H;
    private Node I;
    private CheckItem c;
    private TextView d;
    private View e;
    private RunConditionItem f;
    private InputItem g;

    /* renamed from: h, reason: collision with root package name */
    private WidgetScanItem f1085h;

    /* renamed from: i, reason: collision with root package name */
    private SelectAndDelayItem f1086i;

    /* renamed from: j, reason: collision with root package name */
    private SelectAndDelayItem f1087j;

    /* renamed from: k, reason: collision with root package name */
    private AreaChooseItem f1088k;
    private OffersetChooseItem t;

    class a implements SelectItem.a {
        final /* synthetic */ Node a;

        a(Node node) {
            this.a = node;
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            if ("第n个".equals(str)) {
                WidgetScanDialogView.this.A.setSelectSubLabel(this.a.arg4);
            }
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ Node c;

        b(Node node) {
            this.c = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean b(InputDialogView inputDialogView, String str) {
            inputDialogView.w(str);
            WidgetScanDialogView.this.A.setSelectSubLabel(str);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(final InputDialogView inputDialogView, View view) {
            ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
            paramNameTextView.setInputHint("请输入序号变量");
            paramNameTextView.setInputLabel("请输入序号变量");
            paramNameTextView.k(new InputDialogView.a() { // from class: com.v.cs
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.b(inputDialogView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean f(String str) {
            if (str.contains("${") && str.contains("}")) {
                try {
                    WidgetScanDialogView.this.A.setSelectSubLabel(str);
                    return true;
                } catch (Exception unused) {
                    FloatToast.i("请输入数字");
                    return false;
                }
            }
            try {
                WidgetScanDialogView.this.A.setSelectSubLabel(Integer.valueOf(str) + "");
                return true;
            } catch (Exception unused2) {
                FloatToast.i("请输入数字");
                return false;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.v(1);
            inputDialogView.l("序号");
            inputDialogView.w(this.c.arg4);
            inputDialogView.s("请输入序号");
            inputDialogView.y("使用变量", new View.OnClickListener() { // from class: com.v.ds
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.d(inputDialogView, view2);
                }
            });
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.es
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.f(str);
                }
            });
        }
    }

    class c implements PageScanFloatView.b {
        final /* synthetic */ PageScanFloatView a;

        c(PageScanFloatView pageScanFloatView) {
            this.a = pageScanFloatView;
        }

        @Override // com.v.PageScanFloatView.b
        public void a(int i2, Rect rect, String str, AccessibilityNodeInfo accessibilityNodeInfo) {
            Node nodeC = this.a.c(accessibilityNodeInfo);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(WidgetScanDialogView.class);
            WidgetScanDialogView.this.I.arg1 = nodeC.arg1;
            WidgetScanDialogView widgetScanDialogView = WidgetScanDialogView.this;
            widgetScanDialogView.D(widgetScanDialogView.H, WidgetScanDialogView.this.I);
        }

        @Override // com.v.PageScanFloatView.b
        public void cancel() {
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(WidgetScanDialogView.class);
        }
    }

    public WidgetScanDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.i0, (ViewGroup) this, true);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.f = runConditionItem;
        runConditionItem.setAttachView(this);
        findViewById(j.b.e.L0).setOnClickListener(this);
        this.f1085h = (WidgetScanItem) findViewById(j.b.e.o3);
        OffersetChooseItem offersetChooseItem = (OffersetChooseItem) findViewById(j.b.e.e4);
        this.t = offersetChooseItem;
        offersetChooseItem.setCallback(new lt() { // from class: com.v.rs
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.e(node);
            }
        });
        this.A = (SelectItem) findViewById(j.b.e.c4);
        InputItem inputItem = (InputItem) findViewById(j.b.e.o4);
        this.g = inputItem;
        inputItem.setInputType(2);
        this.f1086i = (SelectAndDelayItem) findViewById(j.b.e.h3);
        this.f1087j = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.f1086i.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.ls
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.g();
            }
        });
        this.f1086i.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.js
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.k();
            }
        });
        this.f1086i.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.fs
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.m(str, str2);
            }
        });
        this.f1087j.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.gs
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.o();
            }
        });
        this.f1087j.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.is
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.q();
            }
        });
        this.f1087j.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.ps
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.s(str, str2);
            }
        });
        this.D = (TextView) findViewById(j.b.e.P);
        this.G = (TextView) findViewById(j.b.e.g);
        this.f1088k = (AreaChooseItem) findViewById(j.b.e.Q3);
        TextView textView = (TextView) findViewById(j.b.e.L);
        this.d = textView;
        textView.setOnClickListener(this);
        View viewFindViewById = findViewById(j.b.e.d1);
        this.e = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.c = (CheckItem) findViewById(j.b.e.x2);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.v.ks
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetScanDialogView.t(view);
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.v.qs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.i(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Node node) {
        if (((Integer) this.f1086i.getValue()).intValue() == 7) {
            this.f1086i.setSelectValue(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String g() {
        return this.I.nextDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(View view) {
        com.frame.l1.g(new Runnable() { // from class: com.v.ms
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.c.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String k() {
        return this.I.nextMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(String str, String str2) {
        Node node = this.I;
        node.nextDelay = str;
        node.nextMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String o() {
        return this.I.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String q() {
        return this.I.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(String str, String str2) {
        Node node = this.I;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    static /* synthetic */ void t(View view) {
        com.frame.s0.g().d(WidgetScanDialogView.class);
        MultiGestureRecordFloatView.c(0L);
        com.frame.s0.g().v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v() {
        this.g.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        FloatToast.i("请输入正确的超时时间");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x() throws NumberFormatException {
        Node node;
        SystemClock.sleep(100L);
        try {
            long j2 = Long.parseLong(this.g.getValue());
            if (this.f1086i.getVisibility() == 0 && this.f1087j.getVisibility() == 0) {
                if (!this.f1086i.c() || !this.f1087j.c()) {
                    return;
                }
                try {
                    this.I.argInt1 = Integer.valueOf(this.d.getText().toString().replace("毫秒", "").replace("滑动间隔时间：", "")).intValue();
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
                this.I.nextType = ((Integer) this.f1086i.getValue()).intValue();
                this.I.errorType = ((Integer) this.f1087j.getValue()).intValue();
                if (this.I.isJumOtherType()) {
                    this.I.nextTaskId = ((Long) this.f1086i.getSubValue()).longValue();
                } else {
                    Node node2 = this.I;
                    int i2 = node2.nextType;
                    if (i2 == 3 || i2 == 13) {
                        if (node2.nextId != ((Long) this.f1086i.getSubValue()).longValue() && this.I.nextId != 0 && (node = this.H.getNodeMap().get(Long.valueOf(this.I.nextId))) != null) {
                            node.frontId = 0L;
                        }
                        this.I.nextId = ((Long) this.f1086i.getSubValue()).longValue();
                    } else if (i2 == 9 || i2 == 11 || i2 == 17) {
                        node2.arg3 = this.f1086i.getSelectSubLabel();
                        this.I.lineNextNodeAtIndex(this.H);
                    } else {
                        node2.lineNextNodeAtIndex(this.H);
                        this.I.arg3 = null;
                    }
                }
                if (this.f1087j.getSubValue() != null) {
                    this.I.errorId = ((Long) this.f1087j.getSubValue()).longValue();
                }
            }
            this.I.arg1 = this.f1085h.getValue();
            this.I.setPointNew(this.t.getValue());
            this.I.arg2 = this.e.isSelected() ? "1" : "0";
            this.I.arg5 = this.c.getValue().booleanValue() ? "1" : "0";
            if ("第一个".equals(this.A.getSelectLabel())) {
                this.I.whatIndex = 1;
            } else if ("最后一个".equals(this.A.getSelectLabel())) {
                this.I.whatIndex = -1;
            } else if ("每次递进".equals(this.A.getSelectLabel())) {
                this.I.whatIndex = Integer.MIN_VALUE;
            } else if ("第n个".equals(this.A.getSelectLabel())) {
                Node node3 = this.I;
                node3.whatIndex = -2;
                node3.arg4 = this.A.getSelectSubLabel();
            } else if ("同时操作全部".equals(this.A.getSelectLabel())) {
                this.I.whatIndex = Integer.MAX_VALUE;
            } else {
                this.I.whatIndex = 1;
            }
            Node node4 = this.I;
            node4.timeOut = j2;
            this.f1088k.u(node4);
            com.frame.s0.g().o(this);
            lt ltVar = this.C;
            if (ltVar != null) {
                ltVar.a(this.I);
            }
        } catch (Exception unused) {
            com.frame.l1.e(new Runnable() { // from class: com.v.ns
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.v();
                }
            });
        }
    }

    static /* synthetic */ boolean y(TextView textView, String str) {
        textView.setText("滑动间隔时间：" + str + "毫秒");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(Node node) {
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        Node node2 = this.I;
        node2.arg1 = node.arg1;
        D(this.H, node2);
    }

    public WidgetScanDialogView B(boolean z) {
        if (z) {
            this.g.setVisibility(8);
            this.f1086i.setVisibility(8);
            this.f1087j.setVisibility(8);
            this.f.setVisibility(8);
        }
        return this;
    }

    public WidgetScanDialogView C(lt ltVar) {
        this.C = ltVar;
        return this;
    }

    public WidgetScanDialogView D(Task task, Node node) {
        this.H = task;
        this.I = node;
        this.f.setTaskNode(task, node);
        this.f1085h.setValue(task, node);
        int i2 = node.whatIndex;
        if (i2 == 1) {
            this.A.setSelectLabel("第一个");
        } else if (i2 == -1) {
            this.A.setSelectLabel("最后一个");
        } else if (i2 == Integer.MIN_VALUE) {
            this.A.setSelectLabel("每次递进");
        } else if (i2 == Integer.MAX_VALUE) {
            this.A.setSelectLabel("同时操作全部");
        } else {
            this.A.setSelectLabel("第n个");
            this.A.setSelectSubLabel(node.arg4);
        }
        this.d.setText("滑动间隔时间：" + node.argInt1 + "毫秒");
        this.A.setOnItemClick(new a(node));
        this.A.setOnSubClickListener(new b(node));
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        try {
            linkedHashMap.put("跳转任务", null);
            linkedHashMap.put("点击后跳任务", null);
            linkedHashMap.put("跳转节点", null);
            linkedHashMap.put("点击后跳节点", null);
            LinkedHashMap<String, Object> paramListMap = getParamListMap();
            linkedHashMap.put("将文本给变量", paramListMap);
            linkedHashMap.put("将坐标给变量", paramListMap);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("点击元素", 7);
        linkedHashMap2.put("模拟点击", 0);
        linkedHashMap2.put("点击后跳任务", 12);
        linkedHashMap2.put("点击后跳节点", 13);
        linkedHashMap2.put("点击控件内随机坐标", 10);
        linkedHashMap2.put("将内容复制至剪切板", 8);
        linkedHashMap2.put("将文本给变量", 9);
        linkedHashMap2.put("将坐标给变量", 11);
        linkedHashMap2.put("将区域坐标给变量", 17);
        linkedHashMap2.put("长按控件", 5);
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.f1086i.setItems(linkedHashMap2, linkedHashMap);
        this.f1086i.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.f1086i;
        selectAndDelayItem.setOnItemClick(new com.v.item.k2(this.H, this.I, selectAndDelayItem, this.t));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("跳转节点", 3);
        linkedHashMap3.put("跳转任务", 4);
        linkedHashMap3.put("结束任务", -3);
        linkedHashMap3.put("结束子任务/循环", -4);
        linkedHashMap3.put("弹窗报错", -2);
        linkedHashMap3.put("跳转下一个节点", 2);
        linkedHashMap3.put("分支节点", 6);
        this.f1087j.setItems(linkedHashMap3, linkedHashMap);
        this.f1087j.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem2 = this.f1087j;
        selectAndDelayItem2.setOnItemClick(new com.v.item.j2(this.H, this.I, selectAndDelayItem2));
        this.f1086i.setSelectValue(Integer.valueOf(node.nextType));
        this.f1087j.setSelectValue(Integer.valueOf(node.errorType));
        this.f1088k.setValue(node.getArea(), node.areaParam);
        this.g.setValue(node.timeOut + "");
        this.e.setSelected("1".equals(node.arg2));
        this.c.setValue("0".equals(node.arg5) ^ true);
        this.t.setValue(this.I.getSrcRect(), this.I.getPoint());
        return this;
    }

    public LinkedHashMap<String, Object> getNodeListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Long l2 : this.H.getNodeMap().keySet()) {
            Node node = this.H.getNodeMap().get(l2);
            if (node != null) {
                linkedHashMap.put(node.getStepAndName(), l2);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getParamListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        Set<String> set = this.H.params;
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
        if (j.b.e.L == id) {
            final TextView textView = (TextView) view;
            InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.v(1);
            inputDialogView.l("滑动间隔时间");
            inputDialogView.w(textView.getText().toString().replace("毫秒", "").replace("滑动间隔时间：", ""));
            inputDialogView.s("请输入滑动间隔时间");
            inputDialogView.x("毫秒");
            inputDialogView.u(2);
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.hs
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return WidgetScanDialogView.y(textView, str);
                }
            });
            return;
        }
        if (j.b.e.d1 == id) {
            view.setSelected(!view.isSelected());
            return;
        }
        if (j.b.e.L0 == id) {
            com.frame.s0.g().i(FlowView.class);
            com.frame.s0.g().i(NodeListDialogView.class);
            com.frame.s0.g().j(this);
            MultiGestureRecordFloatView.F(null);
            PageScanFloatView pageScanFloatView = (PageScanFloatView) com.frame.s0.g().x(PageScanFloatView.class);
            pageScanFloatView.d(new c(pageScanFloatView));
            pageScanFloatView.setNodeCallback(new lt() { // from class: com.v.os
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.A(node);
                }
            });
            if (i.b.da.B().C().size() >= 4 || !com.frame.n0.a("guideAudio", true)) {
                return;
            }
            i.b.da.B().B1("record_text.mp4");
        }
    }

    public void setNeedAcceptScan(boolean z) {
    }
}

package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.LogicNodeAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.google.gson.Gson;
import com.v.ImageBoxSelectDialogView;
import com.v.ItemChooseDialogView;
import com.v.item.InputItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.yl.float_ui.InputDialogView;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.widget.TabLinearLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class MultiLogicDialogView extends RelativeLayout implements View.OnClickListener {
    private RecyclerView c;
    private LogicNodeAdapter d;
    private lt e;
    private InputItem f;
    private Task g;

    /* renamed from: h, reason: collision with root package name */
    private Node f995h;

    /* renamed from: i, reason: collision with root package name */
    private TabLinearLayout f996i;

    /* renamed from: j, reason: collision with root package name */
    private SelectAndDelayItem f997j;

    /* renamed from: k, reason: collision with root package name */
    private SelectAndDelayItem f998k;
    private RunConditionItem t;

    class a implements OnItemDragListener {
        a(MultiLogicDialogView multiLogicDialogView) {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemDragListener
        public void onItemDragEnd(RecyclerView.d0 d0Var, int i2) {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemDragListener
        public void onItemDragMoving(RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3) {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemDragListener
        public void onItemDragStart(RecyclerView.d0 d0Var, int i2) {
        }
    }

    public MultiLogicDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.L, (ViewGroup) this, true);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.t = runConditionItem;
        runConditionItem.setAttachView(this);
        this.f997j = (SelectAndDelayItem) findViewById(j.b.e.h3);
        this.f998k = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.f997j.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.xc
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.g();
            }
        });
        this.f997j.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.id
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.i();
            }
        });
        this.f997j.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.gd
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.k(str, str2);
            }
        });
        this.f998k.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.qc
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.m();
            }
        });
        this.f998k.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.tc
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.o();
            }
        });
        this.f998k.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.fd
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.q(str, str2);
            }
        });
        this.f996i = (TabLinearLayout) findViewById(j.b.e.h5);
        InputItem inputItem = (InputItem) findViewById(j.b.e.p4);
        this.f = inputItem;
        inputItem.setInputType(2);
        this.d = new LogicNodeAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        this.c.setAdapter(this.d);
        this.d.addHeaderView(a());
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.uc
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.t(baseQuickAdapter, view, i2);
            }
        });
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.wc
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.x(baseQuickAdapter, view, i2);
            }
        });
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.d));
        k0Var.j(this.c);
        this.d.enableDragItem(k0Var, j.b.e.h1, false);
        this.d.setOnItemDragListener(new a(this));
        findViewById(j.b.e.g).setOnClickListener(this);
        findViewById(j.b.e.P).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Node node) {
        com.frame.s0.g().u(MultiLogicDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(int i2, List list) {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
        if (i2 == -1) {
            FloatToast.i("请选择图集");
            return;
        }
        if (((ImageBox) list.get(i2)).urls.isEmpty()) {
            FloatToast.i("此图集为空");
            return;
        }
        long j2 = ((ImageBox) list.get(i2)).id;
        Node nodeH = i.b.v8.m().h(null);
        nodeH.url = j2 + "";
        nodeH.delay = "500";
        nodeH.duration = 50L;
        nodeH.type = 22;
        this.d.addData((LogicNodeAdapter) nodeH);
    }

    static /* synthetic */ void E() {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(Node node) {
        com.frame.s0.g().u(MultiLogicDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Node node) {
        com.frame.s0.g().u(MultiLogicDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(Node node) {
        com.frame.s0.g().u(MultiLogicDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(List list) {
        this.d.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O() {
        final List list = (List) new Gson().k(this.f995h.arg1, com.google.gson.k0.a.c(List.class, Node.class).e());
        com.frame.l1.e(new Runnable() { // from class: com.v.jd
            @Override // java.lang.Runnable
            public final void run() {
                this.c.M(list);
            }
        });
    }

    private void Q() {
        com.frame.s0.g().i(MultiLogicDialogView.class);
        i.b.x7.d().e(13).R(1, new lt() { // from class: com.v.yc
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.z(node);
            }
        });
    }

    private void R() {
        com.frame.s0.g().i(MultiLogicDialogView.class);
        i.b.x7.d().e(3).R(1, new lt() { // from class: com.v.vc
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.B(node);
            }
        });
    }

    private void S() {
        com.frame.s0.g().i(MultiLogicDialogView.class);
        ImageBoxSelectDialogView imageBoxSelectDialogView = (ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class);
        imageBoxSelectDialogView.b();
        imageBoxSelectDialogView.setOnImageBoxChoose(new ImageBoxSelectDialogView.c() { // from class: com.v.ad
            @Override // com.v.ImageBoxSelectDialogView.c
            public final void a(int i2, List list) {
                this.a.D(i2, list);
            }
        });
        imageBoxSelectDialogView.setOnCancelListener(new Runnable() { // from class: com.v.bd
            @Override // java.lang.Runnable
            public final void run() {
                MultiLogicDialogView.E();
            }
        });
    }

    private void T() {
        com.frame.s0.g().i(MultiLogicDialogView.class);
        i.b.x7.d().e(24).R(1, new lt() { // from class: com.v.cd
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.G(node);
            }
        });
    }

    private void U() {
        com.frame.s0.g().i(MultiLogicDialogView.class);
        i.b.x7.d().e(4).R(1, new lt() { // from class: com.v.zc
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.I(node);
            }
        });
    }

    private void V() {
        com.frame.s0.g().i(MultiLogicDialogView.class);
        i.b.x7.d().e(19).R(1, new lt() { // from class: com.v.kd
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.K(node);
            }
        });
    }

    private View a() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y0, null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.rc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.e(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            R();
            return;
        }
        if (i2 == 1) {
            V();
            return;
        }
        if (i2 == 2) {
            Q();
            return;
        }
        if (i2 == 3) {
            T();
        } else if (i2 == 4) {
            S();
        } else {
            if (i2 != 5) {
                return;
            }
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择触发条件");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("是否包含图片,是否包含控件,是否包含颜色,是否变量为真,是否包含图集,是否包含文字".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.hd
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.c(i2, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String g() {
        return this.f995h.nextDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String i() {
        return this.f995h.nextMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(String str, String str2) {
        Node node = this.f995h;
        node.nextDelay = str;
        node.nextMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String m() {
        return this.f995h.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String o() {
        return this.f995h.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(String str, String str2) {
        Node node = this.f995h;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        com.frame.s0.g().i(MultiLogicDialogView.class);
        Node item = this.d.getItem(i2);
        i.b.x7.d().e(item.type).P(1, this.g, item, new lt() { // from class: com.v.sc
            @Override // com.v.lt
            public final void a(Node node) {
                com.frame.s0.g().v();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean v(Node node, int i2, String str) {
        node.name = str;
        this.d.refreshNotifyItemChanged(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        if (j.b.e.O0 == view.getId()) {
            this.d.remove(i2);
            return;
        }
        if (j.b.e.v6 == view.getId()) {
            final Node item = this.d.getItem(i2);
            InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.v(1);
            inputDialogView.w(item.name);
            inputDialogView.l("判断节点名称");
            inputDialogView.s("请输入节点名称");
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.dd
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.v(item, i2, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(Node node) {
        com.frame.s0.g().u(MultiLogicDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    public void P() {
        Node node;
        try {
            this.f995h.timeOut = Long.parseLong(this.f.getValue());
            if (this.f996i.getSelectedTabViewId() == j.b.e.N3) {
                this.f995h.what = 1;
            } else if (this.f996i.getSelectedTabViewId() == j.b.e.O3) {
                this.f995h.what = 2;
            }
            if (this.f997j.getVisibility() == 0 && this.f998k.getVisibility() == 0) {
                if (!this.f997j.c() || !this.f998k.c()) {
                    return;
                }
                this.f995h.nextType = ((Integer) this.f997j.getValue()).intValue();
                this.f995h.errorType = ((Integer) this.f998k.getValue()).intValue();
                if (this.f995h.isJumOtherType()) {
                    this.f995h.nextTaskId = ((Long) this.f997j.getSubValue()).longValue();
                } else {
                    Node node2 = this.f995h;
                    int i2 = node2.nextType;
                    if (i2 == 3) {
                        if (node2.nextId != ((Long) this.f997j.getSubValue()).longValue() && this.f995h.nextId != 0 && (node = this.g.getNodeMap().get(Long.valueOf(this.f995h.nextId))) != null) {
                            node.frontId = 0L;
                        }
                        this.f995h.nextId = ((Long) this.f997j.getSubValue()).longValue();
                    } else if (i2 == 9 || i2 == 11) {
                        node2.arg3 = this.f997j.getSelectSubLabel();
                        this.f995h.lineNextNodeAtIndex(this.g);
                    } else {
                        node2.lineNextNodeAtIndex(this.g);
                        this.f995h.arg3 = null;
                    }
                }
                if (this.f998k.getSubValue() != null) {
                    this.f995h.errorId = ((Long) this.f998k.getSubValue()).longValue();
                }
            }
            int i3 = 0;
            while (i3 < this.d.getData().size()) {
                Node node3 = this.d.getData().get(i3);
                i3++;
                node3.step = String.valueOf(i3);
            }
            this.f995h.arg1 = new Gson().s(this.d.getData());
            com.frame.s0.g().d(MultiLogicDialogView.class);
            lt ltVar = this.e;
            if (ltVar != null) {
                ltVar.a(this.f995h);
            }
        } catch (Exception unused) {
            this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入正确的超时时间");
        }
    }

    public MultiLogicDialogView W(lt ltVar) {
        this.e = ltVar;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogicNodeAdapter logicNodeAdapter = this.d;
        if (logicNodeAdapter != null) {
            logicNodeAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().u(FloatHandlerRecord.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().d(MultiLogicDialogView.class);
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            P();
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.g = task;
        this.f995h = node;
        this.f.setValue(String.valueOf(node.timeOut));
        this.t.setTaskNode(task, node);
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("跳转任务", null);
        linkedHashMap.put("点击后跳任务", null);
        linkedHashMap.put("跳转节点", null);
        linkedHashMap.put("点击后跳节点", null);
        linkedHashMap.put("将坐标给变量", null);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("点击元素", 0);
        linkedHashMap2.put("点击元素内随机坐标", 10);
        linkedHashMap2.put("将坐标给变量", 11);
        linkedHashMap2.put("点击后跳任务", 12);
        linkedHashMap2.put("点击后跳节点", 13);
        linkedHashMap2.put("长按元素", 5);
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.f997j.setItems(linkedHashMap2, linkedHashMap);
        this.f997j.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.f997j;
        selectAndDelayItem.setOnItemClick(new com.v.item.k2(this.g, this.f995h, selectAndDelayItem, null));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("跳转节点", 3);
        linkedHashMap3.put("跳转任务", 4);
        linkedHashMap3.put("结束任务", -3);
        linkedHashMap3.put("结束子任务/循环", -4);
        linkedHashMap3.put("弹窗报错", -2);
        linkedHashMap3.put("跳转下一个节点", 2);
        this.f998k.setItems(linkedHashMap3, linkedHashMap);
        this.f998k.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem2 = this.f998k;
        selectAndDelayItem2.setOnItemClick(new com.v.item.j2(this.g, this.f995h, selectAndDelayItem2));
        this.f997j.setSelectValue(Integer.valueOf(node.nextType));
        this.f998k.setSelectValue(Integer.valueOf(node.errorType));
        int i2 = this.f995h.what;
        if (i2 == 1) {
            this.f996i.b(j.b.e.N3);
        } else if (i2 == 2) {
            this.f996i.b(j.b.e.O3);
        }
        if (TextUtils.isEmpty(this.f995h.arg1)) {
            return;
        }
        com.frame.l1.g(new Runnable() { // from class: com.v.ed
            @Override // java.lang.Runnable
            public final void run() {
                this.c.O();
            }
        });
    }
}

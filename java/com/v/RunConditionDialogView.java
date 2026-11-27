package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.v.item.RunCountItem;
import com.v.item.SelectAndDelayItem;
import com.yl.float_ui.InputDialogView;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import com.yl.widget.TabLinearLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class RunConditionDialogView extends RelativeLayout implements View.OnClickListener {
    private View A;
    private RecyclerView c;
    private LogicNodeAdapter d;
    private lt e;
    private RunCountItem f;
    private Task g;

    /* renamed from: h, reason: collision with root package name */
    private Node f1045h;

    /* renamed from: i, reason: collision with root package name */
    private Node f1046i;

    /* renamed from: j, reason: collision with root package name */
    private TabLinearLayout f1047j;

    /* renamed from: k, reason: collision with root package name */
    private SelectAndDelayItem f1048k;
    private SelectAndDelayItem t;

    class a implements OnItemDragListener {
        a(RunConditionDialogView runConditionDialogView) {
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

    public RunConditionDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.T, (ViewGroup) this, true);
        this.f = (RunCountItem) findViewById(j.b.e.V2);
        this.f1048k = (SelectAndDelayItem) findViewById(j.b.e.h3);
        SelectAndDelayItem selectAndDelayItem = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.t = selectAndDelayItem;
        selectAndDelayItem.setVisibility(8);
        this.f1048k.setVisibility(8);
        this.f1047j = (TabLinearLayout) findViewById(j.b.e.h5);
        this.d = new LogicNodeAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        this.c.setAdapter(this.d);
        this.d.addFooterView(a());
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.vk
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.h(baseQuickAdapter, view, i2);
            }
        });
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.bl
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.l(baseQuickAdapter, view, i2);
            }
        });
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.d));
        k0Var.j(this.c);
        this.d.enableDragItem(k0Var, j.b.e.h1, false);
        this.d.setOnItemDragListener(new a(this));
        findViewById(j.b.e.g).setOnClickListener(this);
        findViewById(j.b.e.P).setOnClickListener(this);
    }

    static /* synthetic */ void A() {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(RunConditionDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            node.type = 36;
            node.name = "未匹配到文字";
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            node.type = 39;
            if (TextUtils.isEmpty(node.name)) {
                node.name = "未匹配到控件";
            }
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
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
        final List list = (List) new Gson().k(this.f1045h.getCondition().arg1, com.google.gson.k0.a.c(List.class, Node.class).e());
        com.frame.l1.e(new Runnable() { // from class: com.v.nk
            @Override // java.lang.Runnable
            public final void run() {
                this.c.M(list);
            }
        });
    }

    static lt P(final int i2, final lt ltVar) {
        return new lt() { // from class: com.v.uk
            @Override // com.v.lt
            public final void a(Node node) {
                RunConditionDialogView.m(i2, ltVar, node);
            }
        };
    }

    private void R() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(13).R(1, new lt() { // from class: com.v.lk
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.o(node);
            }
        });
    }

    private void S() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(3).R(1, new lt() { // from class: com.v.qk
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.q(node);
            }
        });
    }

    private void T() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        ImageBoxSelectDialogView imageBoxSelectDialogView = (ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class);
        imageBoxSelectDialogView.b();
        imageBoxSelectDialogView.setOnImageBoxChoose(new ImageBoxSelectDialogView.c() { // from class: com.v.ok
            @Override // com.v.ImageBoxSelectDialogView.c
            public final void a(int i2, List list) {
                this.a.s(i2, list);
            }
        });
        imageBoxSelectDialogView.setOnCancelListener(new Runnable() { // from class: com.v.mk
            @Override // java.lang.Runnable
            public final void run() {
                RunConditionDialogView.t();
            }
        });
    }

    private void U() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(13).R(1, new lt() { // from class: com.v.cl
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.v(node);
            }
        });
    }

    private void V() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(3).R(1, new lt() { // from class: com.v.rk
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.x(node);
            }
        });
    }

    private void W() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        ImageBoxSelectDialogView imageBoxSelectDialogView = (ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class);
        imageBoxSelectDialogView.b();
        imageBoxSelectDialogView.setOnImageBoxChoose(new ImageBoxSelectDialogView.c() { // from class: com.v.kk
            @Override // com.v.ImageBoxSelectDialogView.c
            public final void a(int i2, List list) {
                this.a.z(i2, list);
            }
        });
        imageBoxSelectDialogView.setOnCancelListener(new Runnable() { // from class: com.v.al
            @Override // java.lang.Runnable
            public final void run() {
                RunConditionDialogView.A();
            }
        });
    }

    private void X() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(4).R(1, new lt() { // from class: com.v.zk
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.C(node);
            }
        });
    }

    private void Y() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(19).R(1, new lt() { // from class: com.v.yk
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.E(node);
            }
        });
    }

    private void Z() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(24).R(1, new lt() { // from class: com.v.pk
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.G(node);
            }
        });
    }

    private View a() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y0, null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.ik
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.e(view);
            }
        });
        return viewInflate;
    }

    private void a0() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(4).R(1, new lt() { // from class: com.v.dl
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.I(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        switch (i2) {
            case 0:
                S();
                break;
            case 1:
                b0();
                break;
            case 2:
                R();
                break;
            case 3:
                Z();
                break;
            case 4:
                T();
                break;
            case 5:
                a0();
                break;
            case 6:
                V();
                break;
            case 7:
                Y();
                break;
            case 8:
                U();
                break;
            case 9:
                W();
                break;
            case 10:
                X();
                break;
        }
    }

    private void b0() {
        com.frame.s0.g().i(RunConditionDialogView.class);
        i.b.x7.d().e(19).R(1, new lt() { // from class: com.v.xk
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.K(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择触发条件");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("是否包含图片,是否包含控件,是否包含颜色,是否变量为真,是否包含图集,是否包含文字,未匹配到图片,未匹配到控件,未匹配到颜色,未匹配到图集,未匹配到文字".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.sk
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.c(i2, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        com.frame.s0.g().i(RunConditionDialogView.class);
        Node item = this.d.getItem(i2);
        int i3 = item.type;
        int i4 = 3;
        if (i3 == 39) {
            i4 = 19;
        } else if (i3 != 37 && i3 != 40) {
            i4 = i3 == 36 ? 4 : i3 == 38 ? 13 : i3;
        }
        i.b.x7.d().e(i4).P(1, this.g, item, P(i3, new lt() { // from class: com.v.jk
            @Override // com.v.lt
            public final void a(Node node) {
                com.frame.s0.g().v();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean j(Node node, int i2, String str) {
        node.name = str;
        this.d.notifyItemChanged(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
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
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.wk
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.j(item, i2, str);
                }
            });
        }
    }

    static /* synthetic */ void m(int i2, lt ltVar, Node node) {
        if (node != null) {
            node.type = i2;
        }
        ltVar.a(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(int i2, List list) {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(RunConditionDialogView.class);
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

    static /* synthetic */ void t() {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(RunConditionDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            node.type = 38;
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Node node) {
        com.frame.s0.g().u(RunConditionDialogView.class);
        if (node != null) {
            node.type = 37;
            node.name = "未匹配到图片";
            this.d.addData((LogicNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(int i2, List list) {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(RunConditionDialogView.class);
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
        nodeH.type = 40;
        nodeH.name = "未匹配到图集";
        this.d.addData((LogicNodeAdapter) nodeH);
    }

    public void Q() {
        if (this.f1047j.getSelectedTabViewId() == j.b.e.N3) {
            this.f1046i.what = 1;
        } else if (this.f1047j.getSelectedTabViewId() == j.b.e.O3) {
            this.f1046i.what = 2;
        }
        this.f1046i.arg1 = new Gson().s(this.d.getData());
        this.f1045h.setCondition(this.f1046i);
        com.frame.s0.g().d(RunConditionDialogView.class);
        lt ltVar = this.e;
        if (ltVar != null) {
            ltVar.a(this.f1046i);
        }
    }

    public RunConditionDialogView c0(lt ltVar) {
        this.e = ltVar;
        return this;
    }

    public LinkedHashMap<String, Object> getNodeListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Long l2 : this.g.getNodeMap().keySet()) {
            Node node = this.g.getNodeMap().get(l2);
            if (node != null) {
                linkedHashMap.put(node.getStepAndName(), l2);
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogicNodeAdapter logicNodeAdapter = this.d;
        if (logicNodeAdapter != null) {
            logicNodeAdapter.notifyDataSetChanged();
        }
        com.frame.s0.g().j(this.A);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().u(FloatHandlerRecord.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().d(RunConditionDialogView.class);
            com.frame.s0.g().u(this.A.getClass());
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(this.A.getClass());
            Q();
        }
    }

    public void setAttachView(View view) {
        this.A = view;
    }

    public void setTaskNode(Task task, Node node) {
        this.g = task;
        this.f1045h = node;
        if (node.getCondition() != null) {
            Node condition = this.f1045h.getCondition();
            this.f1046i = condition;
            if (condition.what == 1) {
                this.f1047j.b(j.b.e.N3);
            } else {
                this.f1047j.b(j.b.e.O3);
            }
            this.f.setNode(this.f1046i);
            if (TextUtils.isEmpty(this.f1045h.getCondition().arg1)) {
                return;
            }
            com.frame.l1.g(new Runnable() { // from class: com.v.tk
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.O();
                }
            });
            return;
        }
        TabLinearLayout tabLinearLayout = this.f1047j;
        int i2 = j.b.e.N3;
        tabLinearLayout.b(i2);
        Node node2 = new Node();
        this.f1046i = node2;
        node2.setCheckDelay(500L);
        this.f1046i.setCheckCount(1L);
        Node node3 = this.f1046i;
        node3.what = 1;
        this.f.setNode(node3);
        this.f1047j.b(i2);
    }
}

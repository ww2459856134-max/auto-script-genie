package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.LogicJumpNodeAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.google.gson.Gson;
import com.v.ImageBoxSelectDialogView;
import com.v.ItemChooseDialogView;
import com.v.TaskChooseDialogView1;
import com.v.item.InputItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.yl.float_ui.InputDialogView;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class MultiLogicJumpDialogView extends RelativeLayout implements View.OnClickListener {
    private RecyclerView c;
    private LogicJumpNodeAdapter d;
    private lt e;
    private InputItem f;
    private Task g;

    /* renamed from: h, reason: collision with root package name */
    private Node f999h;

    /* renamed from: i, reason: collision with root package name */
    private SelectAndDelayItem f1000i;

    /* renamed from: j, reason: collision with root package name */
    private RunConditionItem f1001j;

    class a implements OnItemDragListener {
        a(MultiLogicJumpDialogView multiLogicJumpDialogView) {
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

    public MultiLogicJumpDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.M, (ViewGroup) this, true);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.f1001j = runConditionItem;
        runConditionItem.setAttachView(this);
        SelectAndDelayItem selectAndDelayItem = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.f1000i = selectAndDelayItem;
        selectAndDelayItem.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.qd
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.h();
            }
        });
        this.f1000i.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.wd
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.j();
            }
        });
        this.f1000i.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.pd
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.p(str, str2);
            }
        });
        InputItem inputItem = (InputItem) findViewById(j.b.e.p4);
        this.f = inputItem;
        inputItem.setInputType(2);
        this.d = new LogicJumpNodeAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        this.c.setAdapter(this.d);
        this.d.addFooterView(b());
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.fe
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.s(baseQuickAdapter, view, i2);
            }
        });
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.rd
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.n(baseQuickAdapter, view, i2);
            }
        });
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.d));
        k0Var.j(this.c);
        this.d.enableDragItem(k0Var, j.b.e.h1, false);
        this.d.setOnItemDragListener(new a(this));
        findViewById(j.b.e.B).setOnClickListener(this);
        findViewById(j.b.e.f1754m).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(Node node) throws NumberFormatException {
        com.frame.s0.g().u(MultiLogicJumpDialogView.class);
        if (node != null) {
            this.d.addData((LogicJumpNodeAdapter) node);
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(Node node) throws NumberFormatException {
        com.frame.s0.g().u(MultiLogicJumpDialogView.class);
        if (node != null) {
            this.d.addData((LogicJumpNodeAdapter) node);
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(int i2, List list) throws NumberFormatException {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(MultiLogicJumpDialogView.class);
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
        this.d.addData((LogicJumpNodeAdapter) nodeH);
        a0();
    }

    static /* synthetic */ void H() {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        com.frame.s0.g().u(MultiLogicJumpDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Node node) {
        com.frame.s0.g().u(MultiLogicJumpDialogView.class);
        if (node != null) {
            this.d.addData((LogicJumpNodeAdapter) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(Node node) throws NumberFormatException {
        com.frame.s0.g().u(MultiLogicJumpDialogView.class);
        if (node != null) {
            this.d.addData((LogicJumpNodeAdapter) node);
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Node node) throws NumberFormatException {
        com.frame.s0.g().u(MultiLogicJumpDialogView.class);
        if (node != null) {
            this.d.addData((LogicJumpNodeAdapter) node);
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(boolean z, List list) throws NumberFormatException {
        if (z) {
            a0();
        }
        this.d.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R() {
        final boolean z = false;
        final List list = (List) new Gson().k(this.f999h.arg1, com.google.gson.k0.a.c(List.class, Node.class).e());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Node) it.next()).type != 24) {
                z = true;
            }
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.ge
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.c.P(z, list);
            }
        });
    }

    private void T() {
        com.frame.s0.g().i(MultiLogicJumpDialogView.class);
        i.b.x7.d().e(13).R(1, new lt() { // from class: com.v.yd
            @Override // com.v.lt
            public final void a(Node node) throws NumberFormatException {
                this.a.C(node);
            }
        });
    }

    private void U() {
        com.frame.s0.g().i(MultiLogicJumpDialogView.class);
        i.b.x7.d().e(3).R(1, new lt() { // from class: com.v.ld
            @Override // com.v.lt
            public final void a(Node node) throws NumberFormatException {
                this.a.E(node);
            }
        });
    }

    private void V() {
        com.frame.s0.g().i(MultiLogicJumpDialogView.class);
        ImageBoxSelectDialogView imageBoxSelectDialogView = (ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class);
        imageBoxSelectDialogView.b();
        imageBoxSelectDialogView.setOnImageBoxChoose(new ImageBoxSelectDialogView.c() { // from class: com.v.vd
            @Override // com.v.ImageBoxSelectDialogView.c
            public final void a(int i2, List list) throws NumberFormatException {
                this.a.G(i2, list);
            }
        });
        imageBoxSelectDialogView.setOnCancelListener(new Runnable() { // from class: com.v.ud
            @Override // java.lang.Runnable
            public final void run() {
                MultiLogicJumpDialogView.H();
            }
        });
    }

    private void W() {
        com.frame.s0.g().i(MultiLogicJumpDialogView.class);
        i.b.x7.d().e(24).R(1, new lt() { // from class: com.v.be
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.J(node);
            }
        });
    }

    private void X() {
        com.frame.s0.g().i(MultiLogicJumpDialogView.class);
        i.b.x7.d().e(4).R(1, new lt() { // from class: com.v.ce
            @Override // com.v.lt
            public final void a(Node node) throws NumberFormatException {
                this.a.L(node);
            }
        });
    }

    private void Y() {
        com.frame.s0.g().i(MultiLogicJumpDialogView.class);
        i.b.x7.d().e(19).R(1, new lt() { // from class: com.v.ae
            @Override // com.v.lt
            public final void a(Node node) throws NumberFormatException {
                this.a.N(node);
            }
        });
    }

    private void a() throws NumberFormatException {
        List<Node> data = this.d.getData();
        if (data.isEmpty()) {
            FloatToast.i("还没有可复制的条件");
            return;
        }
        Node node = (Node) new Gson().j(new Gson().s(data.get(data.size() - 1)), Node.class);
        node.id = System.currentTimeMillis();
        node.step = null;
        this.d.addData((LogicJumpNodeAdapter) node);
        if (node.type != 24) {
            a0();
        }
        FloatToast.i("已复制上一条条件");
    }

    private void a0() throws NumberFormatException {
        long j2;
        this.f.setVisibility(0);
        try {
            j2 = Long.parseLong(this.f.getValue());
        } catch (Exception unused) {
            this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            j2 = 0;
        }
        if (j2 == 0) {
            this.f.setValue("5000");
        }
    }

    private View b() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y0, null);
        ((TextView) viewInflate.findViewById(j.b.e.K5)).setText("添加跳转逻辑");
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.ee
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(int i2, List list) throws NumberFormatException {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = (String) list.get(i2);
        str.hashCode();
        switch (str) {
            case "是否包含图片":
                U();
                break;
            case "是否包含图集":
                V();
                break;
            case "是否包含控件":
                Y();
                break;
            case "是否包含文字":
                X();
                break;
            case "是否包含颜色":
                T();
                break;
            case "是否变量为真":
                W();
                break;
            case "复制上一条条件":
                a();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择触发条件");
        ArrayList arrayList = new ArrayList(Arrays.asList("是否包含图片,是否包含控件,是否包含颜色,是否变量为真,是否包含图集,是否包含文字".split(",")));
        if (!this.d.getData().isEmpty()) {
            arrayList.add(0, "复制上一条条件");
        }
        itemChooseDialogView.setDefaultData(-1, arrayList);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.de
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) throws NumberFormatException {
                this.a.d(i2, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String h() {
        return this.f999h.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String j() {
        return this.f999h.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean l(Node node, int i2, String str) {
        node.name = str;
        this.d.notifyItemChanged(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(BaseQuickAdapter baseQuickAdapter, final View view, final int i2) {
        if (j.b.e.g6 == view.getId()) {
            ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.setTitle("选择菜单");
            final String[] strArr = {"跳转任务", "跳转节点", "点击后跳转任务", "点击后跳转节点", "结束任务", "结束子任务/循环", "跳转下一个节点", "点击后跳下个节点"};
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList(strArr)));
            itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.he
                @Override // com.v.ItemChooseDialogView.b
                public final void a(int i3, List list) {
                    this.a.A(strArr, i2, view, i3, list);
                }
            });
            return;
        }
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
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.xd
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.l(item, i2, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(String str, String str2) {
        Node node = this.f999h;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        com.frame.s0.g().i(MultiLogicJumpDialogView.class);
        Node item = this.d.getItem(i2);
        i.b.x7.d().e(item.type).P(1, this.g, item, new lt() { // from class: com.v.od
            @Override // com.v.lt
            public final void a(Node node) {
                com.frame.s0.g().v();
            }
        });
    }

    static /* synthetic */ void t(Node node, View view, boolean z, TaskSimple taskSimple) {
        com.frame.s0.g().d(TaskChooseDialogView1.class);
        node.nextTaskId = taskSimple.getId();
        node.nextType = 4;
        node.successJumpBack = z;
        node.nextId = 0L;
        ((TextView) view).setText("跳任务：" + taskSimple.getName());
    }

    static /* synthetic */ void u(Node node, View view, boolean z, TaskSimple taskSimple) {
        com.frame.s0.g().d(TaskChooseDialogView1.class);
        node.nextTaskId = taskSimple.getId();
        node.nextType = 12;
        node.successJumpBack = z;
        node.nextId = 0L;
        ((TextView) view).setText("点击后跳任务：" + taskSimple.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(Node node, View view, Node node2) {
        node.nextId = node2.id;
        node.nextType = 13;
        node.nextTaskId = 0L;
        ((TextView) view).setText("点击后跳节点：" + this.g.getNodeMap().get(Long.valueOf(node2.id)).getStepAndName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(Node node, View view, Node node2) {
        node.nextId = node2.id;
        node.nextType = 3;
        node.nextTaskId = 0L;
        ((TextView) view).setText("跳节点：" + this.g.getNodeMap().get(Long.valueOf(node2.id)).getStepAndName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(String[] strArr, int i2, final View view, int i3, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = strArr[i3];
        final Node item = this.d.getItem(i2);
        if ("跳转任务".equals(str)) {
            TaskChooseDialogView1 taskChooseDialogView1U = TaskChooseDialogView1.u();
            taskChooseDialogView1U.setDefaultValue(item.successJumpBack, i.b.da.B().w(item.nextTaskId));
            taskChooseDialogView1U.setOnChooseListener(new TaskChooseDialogView1.b() { // from class: com.v.md
                @Override // com.v.TaskChooseDialogView1.b
                public final void a(boolean z, TaskSimple taskSimple) {
                    MultiLogicJumpDialogView.t(item, view, z, taskSimple);
                }
            });
            return;
        }
        if ("点击后跳转任务".equals(str)) {
            TaskChooseDialogView1 taskChooseDialogView1U2 = TaskChooseDialogView1.u();
            taskChooseDialogView1U2.setDefaultValue(item.successJumpBack, i.b.da.B().w(item.nextTaskId));
            taskChooseDialogView1U2.setOnChooseListener(new TaskChooseDialogView1.b() { // from class: com.v.td
                @Override // com.v.TaskChooseDialogView1.b
                public final void a(boolean z, TaskSimple taskSimple) {
                    MultiLogicJumpDialogView.u(item, view, z, taskSimple);
                }
            });
            return;
        }
        if ("点击后跳转节点".equals(str)) {
            ((SearchNodeView) com.frame.s0.g().B(SearchNodeView.class)).set(new ArrayList(this.g.getNodeMap().values()), -1, new lt() { // from class: com.v.zd
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.w(item, view, node);
                }
            });
            return;
        }
        if ("跳转节点".equals(str)) {
            ((SearchNodeView) com.frame.s0.g().B(SearchNodeView.class)).set(new ArrayList(this.g.getNodeMap().values()), -1, new lt() { // from class: com.v.nd
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.y(item, view, node);
                }
            });
            return;
        }
        if ("点击后跳下个节点".equals(str)) {
            item.nextType = 0;
            item.nextTaskId = 0L;
            item.nextId = 0L;
            ((TextView) view).setText("点击后跳下个节点");
            return;
        }
        if ("跳转下一个节点".equals(str)) {
            item.nextType = 2;
            item.nextTaskId = 0L;
            item.nextId = 0L;
            ((TextView) view).setText("跳节下个节点");
            return;
        }
        if ("结束任务".equals(str)) {
            item.nextType = -3;
            ((TextView) view).setText("结束任务");
        } else if ("结束子任务/循环".equals(str)) {
            item.nextType = -4;
            item.nextTaskId = 0L;
            item.nextId = 0L;
            ((TextView) view).setText("结束子任务/循环");
        }
    }

    public void S() throws NumberFormatException {
        int i2 = 0;
        boolean z = false;
        while (i2 < this.d.getData().size()) {
            Node item = this.d.getItem(i2);
            i2++;
            item.step = String.valueOf(i2);
            if (item.type != 24) {
                z = true;
            }
            int i3 = item.nextType;
            if (i3 != 2 && i3 != -3 && i3 != -4 && i3 != 0) {
                if (i3 == 3 || i3 == 13) {
                    if (item.nextId == 0) {
                        FloatToast.i("请选择跳转节点");
                        return;
                    }
                } else if (i3 != 4 && i3 != 12) {
                    FloatToast.i("请设置列表中每一条跳转");
                    return;
                } else if (item.nextTaskId == 0) {
                    FloatToast.i("请选择跳转任务");
                    return;
                }
            }
        }
        if (z) {
            try {
                this.f999h.timeOut = Long.parseLong(this.f.getValue());
            } catch (Exception unused) {
                this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入正确的超时时间");
                return;
            }
        } else {
            this.f999h.timeOut = 0L;
        }
        if (this.f1000i.getVisibility() == 0) {
            if (!this.f1000i.c()) {
                return;
            }
            this.f999h.errorType = ((Integer) this.f1000i.getValue()).intValue();
            if (this.f1000i.getSubValue() != null) {
                this.f999h.errorId = ((Long) this.f1000i.getSubValue()).longValue();
            }
        }
        this.f999h.arg1 = new Gson().s(this.d.getData());
        com.frame.s0.g().d(MultiLogicJumpDialogView.class);
        lt ltVar = this.e;
        if (ltVar != null) {
            ltVar.a(this.f999h);
        }
    }

    public MultiLogicJumpDialogView Z(lt ltVar) {
        this.e = ltVar;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogicJumpNodeAdapter logicJumpNodeAdapter = this.d;
        if (logicJumpNodeAdapter != null) {
            logicJumpNodeAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        int id = view.getId();
        if (id == j.b.e.f1754m) {
            com.frame.s0.g().u(FloatHandlerRecord.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().d(MultiLogicJumpDialogView.class);
            return;
        }
        if (id == j.b.e.B) {
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            S();
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.g = task;
        this.f999h = node;
        this.f.setValue(String.valueOf(node.timeOut));
        this.f1001j.setTaskNode(task, node);
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("跳转任务", null);
        linkedHashMap.put("点击后跳任务", null);
        linkedHashMap.put("跳转节点", null);
        linkedHashMap.put("点击后跳节点", null);
        linkedHashMap.put("将坐标给变量", null);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("弹窗报错", -2);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.f1000i.setItems(linkedHashMap2, linkedHashMap);
        this.f1000i.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.f1000i;
        selectAndDelayItem.setOnItemClick(new com.v.item.j2(this.g, this.f999h, selectAndDelayItem));
        this.f1000i.setSelectValue(Integer.valueOf(node.errorType));
        if (TextUtils.isEmpty(this.f999h.arg1)) {
            return;
        }
        com.frame.l1.g(new Runnable() { // from class: com.v.sd
            @Override // java.lang.Runnable
            public final void run() {
                this.c.R();
            }
        });
    }
}

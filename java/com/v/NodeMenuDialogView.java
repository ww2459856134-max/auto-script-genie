package com.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.NodeListAdapter;
import com.adapter.TaskMenuGridAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.NodeClipBoardDialogView;
import com.v.NodeRepeatCountDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;

/* loaded from: classes.dex */
public class NodeMenuDialogView extends FrameLayout implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    private static final Map<String, Integer> f1010i;
    private TaskMenuGridAdapter c;
    private NodeListDialogView d;
    private Node e;
    private int f;
    private View g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f1011h;

    class a extends RecyclerView.n {
        final /* synthetic */ int a;

        a(NodeMenuDialogView nodeMenuDialogView, int i2) {
            this.a = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            int i2 = this.a;
            rect.left = i2;
            rect.right = i2;
            rect.bottom = i2;
            rect.top = i2;
        }
    }

    static {
        HashMap map = new HashMap();
        f1010i = map;
        map.put("编辑", Integer.valueOf(j.b.d.L));
        map.put("复制\n（插入到下一条）", Integer.valueOf(j.b.d.t0));
        map.put("复制\n（插入到最后）", Integer.valueOf(j.b.d.s0));
        map.put("复制至剪切板", Integer.valueOf(j.b.d.u0));
        map.put("从剪切板插入", Integer.valueOf(j.b.d.v0));
        map.put("插入新节点", Integer.valueOf(j.b.d.C));
        map.put("循环执行次数", Integer.valueOf(j.b.d.x0));
        map.put("从此节点执行脚本", Integer.valueOf(j.b.d.z0));
        map.put("执行节点", Integer.valueOf(j.b.d.d0));
        map.put("禁用节点", Integer.valueOf(j.b.d.w0));
        map.put("解除禁用节点", Integer.valueOf(j.b.d.R));
        map.put("移动到第n个节点", Integer.valueOf(j.b.d.j0));
        map.put("删除节点", Integer.valueOf(j.b.d.y0));
    }

    public NodeMenuDialogView() {
        this(com.frame.v0.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(NodeListAdapter nodeListAdapter, int i2, Node node, Task task, Node node2) {
        nodeListAdapter.addData(i2 + 1, (int) node);
        i.b.v8.m().q(task, node2, node);
        this.d.e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(NodeListAdapter nodeListAdapter, Task task, Node node) {
        if (!nodeListAdapter.getData().isEmpty()) {
            i.b.v8.m().q(task, nodeListAdapter.getData().get(nodeListAdapter.getData().size() - 1), node);
        }
        nodeListAdapter.addData((NodeListAdapter) node);
        this.d.e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(NodeListAdapter nodeListAdapter, int i2, Node node, Task task, Node node2) {
        nodeListAdapter.addData(i2 + 1, (int) node);
        i.b.v8.m().q(task, node2, node);
        this.d.e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I() {
        this.d.getNodeAdapter().notifyItemChanged(this.f);
        this.d.b1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean K(String str) {
        if (this.e.type != 15 || !i.b.da.B().R(str)) {
            this.e.name = str;
            TextView textView = this.f1011h;
            if (textView != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "未命名节点";
                }
                textView.setText(str);
            }
            M(new Runnable() { // from class: com.v.xg
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.I();
                }
            });
            return true;
        }
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.g(j.b.d.q0);
            dingMsgView.h("任务名请不要重复~~~");
            dingMsgView.l("温馨提示");
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.og
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            return false;
        } catch (Exception e) {
            com.frame.k0.r(e);
            return false;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void L(String str) throws JSONException {
        final NodeListAdapter nodeAdapter;
        final Task nodeTask;
        final Node node;
        final int i2;
        View view;
        c();
        nodeAdapter = this.d.getNodeAdapter();
        nodeTask = this.d.getNodeTask();
        node = this.e;
        i2 = this.f;
        str.hashCode();
        switch (str) {
            case "插入新节点":
                this.d.n(i2, node);
                break;
            case "复制至剪切板":
                i.b.v8.m().c(i.b.n8.a(Collections.singletonList(node), i.b.v8.m().n()).get(0));
                com.frame.s0.g().x(NodeClipBoardDialogView.class);
                break;
            case "移动到第n个节点":
                InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
                inputDialogView.v(1);
                inputDialogView.l("移动节点");
                inputDialogView.u(2);
                inputDialogView.s("请输入需要移动到第n个节点");
                inputDialogView.t(new InputDialogView.a() { // from class: com.v.lg
                    @Override // com.yl.float_ui.InputDialogView.a
                    public final boolean a(String str2) {
                        return this.a.v(nodeAdapter, i2, node, nodeTask, str2);
                    }
                });
                break;
            case "循环执行次数":
                NodeRepeatCountDialogView nodeRepeatCountDialogView = (NodeRepeatCountDialogView) com.frame.s0.g().B(NodeRepeatCountDialogView.class);
                nodeRepeatCountDialogView.setNode(node);
                nodeRepeatCountDialogView.u(new NodeRepeatCountDialogView.a() { // from class: com.v.ng
                    @Override // com.v.NodeRepeatCountDialogView.a
                    public final void a(String str2) {
                        this.a.p(nodeAdapter, str2);
                    }
                });
                break;
            case "解除禁用节点":
            case "禁用节点":
                node.invalid = !node.invalid;
                Objects.requireNonNull(nodeAdapter);
                M(new p9(nodeAdapter));
                break;
            case "编辑":
                i.b.v8.m().d(nodeTask, node, new lt() { // from class: com.v.wg
                    @Override // com.v.lt
                    public final void a(Node node2) {
                        this.a.z(nodeAdapter, node2);
                    }
                });
                break;
            case "复制
（插入到最后）":
                this.d.b1();
                final Node node2 = (Node) com.frame.q1.a(node);
                node2.id = System.currentTimeMillis();
                node2.nextId = 0L;
                M(new Runnable() { // from class: com.v.mg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.D(nodeAdapter, nodeTask, node2);
                    }
                });
                break;
            case "删除节点":
                this.d.n1(nodeAdapter.getItem(i2), i2);
                break;
            case "从剪切板插入":
                if (i.b.v8.m().n().size() != 1) {
                    ((NodeClipBoardDialogView) com.frame.s0.g().x(NodeClipBoardDialogView.class)).setOnTextChoose(new NodeClipBoardDialogView.c() { // from class: com.v.ug
                        @Override // com.v.NodeClipBoardDialogView.c
                        public final void a(List list) {
                            this.a.n(node, nodeTask, nodeAdapter, i2, list);
                        }
                    });
                    break;
                } else {
                    final Node node3 = i.b.n8.a(i.b.v8.m().n(), nodeTask.getNodeMap().values()).get(0);
                    M(new Runnable() { // from class: com.v.qg
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.F(nodeAdapter, i2, node3, nodeTask, node);
                        }
                    });
                    break;
                }
            case "从此节点执行脚本":
                this.d.e1();
                com.frame.s0.g().d(NodeListDialogView.class);
                i.b.da.B().b2(nodeTask, node, i.b.j7.a().f(), null, true);
                break;
            case "执行节点":
                final i.b.t9 t9Var = new i.b.t9(nodeTask);
                i.b.da.B().V1(t9Var);
                FloatHandlerRun floatHandlerRun = (FloatHandlerRun) com.frame.s0.g().f(FloatHandlerRun.class);
                if (floatHandlerRun != null && (view = this.g) != null && view.getParent() != null && this.g.getLayoutParams() != null) {
                    floatHandlerRun.Q(node);
                }
                NodeListDialogView.g1(node);
                com.frame.l1.g(new Runnable() { // from class: com.v.yg
                    @Override // java.lang.Runnable
                    public final void run() {
                        NodeMenuDialogView.r(t9Var, node);
                    }
                });
                break;
            case "复制
（插入到下一条）":
                this.d.b1();
                final Node node4 = (Node) com.frame.q1.a(node);
                node4.id = System.currentTimeMillis();
                M(new Runnable() { // from class: com.v.vg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.B(nodeAdapter, i2, node4, nodeTask, node);
                    }
                });
                break;
        }
    }

    private void M(Runnable runnable) {
        NodeListDialogView nodeListDialogView;
        if (runnable == null || (nodeListDialogView = this.d) == null) {
            return;
        }
        RecyclerView nodeRecyclerView = nodeListDialogView.getNodeRecyclerView();
        if (nodeRecyclerView == null || !nodeRecyclerView.w0()) {
            com.frame.l1.e(runnable);
        } else {
            nodeRecyclerView.post(runnable);
        }
    }

    public static NodeMenuDialogView N(NodeListDialogView nodeListDialogView, int i2, View view) {
        com.frame.s0.g().d(NodeMenuDialogView.class);
        NodeMenuDialogView nodeMenuDialogView = (NodeMenuDialogView) com.frame.s0.g().x(NodeMenuDialogView.class);
        nodeMenuDialogView.a(nodeListDialogView, i2, view);
        return nodeMenuDialogView;
    }

    private void O() {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("节点名称");
        inputDialogView.s("请输入节点名称");
        inputDialogView.w(this.e.name);
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.bh
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.K(str);
            }
        });
    }

    private void a(NodeListDialogView nodeListDialogView, int i2, View view) {
        this.d = nodeListDialogView;
        this.f = i2;
        this.g = view;
        this.e = nodeListDialogView.getNodeAdapter().getItem(i2);
        ((TextView) findViewById(j.b.e.w6)).setText("节点菜单");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(j.b.e.w4);
        relativeLayout.removeAllViews();
        relativeLayout.addView(d(this.e));
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.v.rg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.h(view2);
            }
        });
        ArrayList arrayList = new ArrayList();
        for (String str : b(this.e)) {
            arrayList.add(new TaskMenuGridAdapter.a(str, e(str)));
        }
        this.c.setNewData(arrayList);
    }

    private List<String> b(Node node) {
        return Arrays.asList("编辑", "复制\n（插入到下一条）", "复制\n（插入到最后）", "复制至剪切板", "从剪切板插入", "插入新节点", "循环执行次数", "从此节点执行脚本", "执行节点", node.invalid ? "解除禁用节点" : "禁用节点", "移动到第n个节点", "删除节点");
    }

    private void c() {
        com.frame.s0.g().d(NodeMenuDialogView.class);
    }

    private View d(Node node) {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.R0, null);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.n6);
        TextView textView2 = (TextView) viewInflate.findViewById(j.b.e.x6);
        ImageView imageView = (ImageView) viewInflate.findViewById(j.b.e.G3);
        textView.setText(TextUtils.isEmpty(node.name) ? "未命名节点" : node.name);
        this.f1011h = textView;
        i.b.ka.x5 x5VarE = i.b.x7.d().e(node.type);
        textView2.setText(x5VarE != null ? x5VarE.t() : "未知操作");
        if (x5VarE != null) {
            imageView.setImageResource(x5VarE.r());
        } else {
            imageView.setImageResource(j.b.d.S);
        }
        return viewInflate;
    }

    private int e(String str) {
        Integer num = f1010i.get(str);
        return num != null ? num.intValue() : j.b.d.S;
    }

    private void f() {
        View.inflate(com.frame.v0.g(), j.b.f.X, this);
        this.c = new TaskMenuGridAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 3));
        recyclerView.setAdapter(this.c);
        recyclerView.g(new a(this, com.frame.p1.c(4.0f)));
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.sg
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) throws JSONException {
                this.c.j(baseQuickAdapter, view, i2);
            }
        });
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.J).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(View view) {
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(BaseQuickAdapter baseQuickAdapter, View view, int i2) throws JSONException {
        TaskMenuGridAdapter.a item = this.c.getItem(i2);
        if (item != null) {
            L(item.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(List list, Task task, NodeListAdapter nodeListAdapter, int i2, Node[] nodeArr) {
        ArrayList<Node> arrayListA = i.b.n8.a(list, task.getNodeMap().values());
        for (int i3 = 0; i3 < arrayListA.size(); i3++) {
            Node node = arrayListA.get(i3);
            nodeListAdapter.addData(i2 + 1 + i3, (int) node);
            i.b.v8.m().q(task, nodeArr[0], node);
            nodeArr[0] = node;
        }
        this.d.e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Node node, final Task task, final NodeListAdapter nodeListAdapter, final int i2, final List list) {
        if (list.isEmpty()) {
            FloatToast.i("未选中需要复制的节点");
        } else {
            final Node[] nodeArr = {node};
            M(new Runnable() { // from class: com.v.zg
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l(list, task, nodeListAdapter, i2, nodeArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(NodeListAdapter nodeListAdapter, String str) {
        Objects.requireNonNull(nodeListAdapter);
        M(new p9(nodeListAdapter));
    }

    static /* synthetic */ void r(i.b.t9 t9Var, Node node) {
        if (!com.frame.s0.g().m(GesturePlayFloatView.class)) {
            com.frame.l1.e(new Runnable() { // from class: com.v.tg
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().E(GesturePlayFloatView.class);
                }
            });
        }
        i.b.x7.d().b(500L);
        t9Var.t(node, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(NodeListAdapter nodeListAdapter, int i2, int i3, Node node, Task task) {
        nodeListAdapter.remove(i2);
        nodeListAdapter.addData(i3, (int) node);
        i.b.v8.m().h0(task, node);
        i.b.v8.m().q(task, i3 == 0 ? null : nodeListAdapter.getItem(i3 - 1), node);
        if (this.d.getNodeRecyclerView() != null) {
            this.d.getNodeRecyclerView().j1(i3);
        }
        nodeListAdapter.m(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean v(final NodeListAdapter nodeListAdapter, final int i2, final Node node, final Task task, String str) {
        try {
            final int iIntValue = Integer.valueOf(str).intValue() - 1;
            if (iIntValue > nodeListAdapter.getData().size() - 1) {
                FloatToast.i("输入的数字已经超出节点个数");
                return false;
            }
            if (iIntValue < 0) {
                FloatToast.i("请输入1及以上的数字");
                return false;
            }
            M(new Runnable() { // from class: com.v.ah
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.t(nodeListAdapter, i2, iIntValue, node, task);
                }
            });
            return true;
        } catch (Exception unused) {
            FloatToast.i("请输入正确的整数");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(NodeListAdapter nodeListAdapter) {
        nodeListAdapter.notifyDataSetChanged();
        this.d.b1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(final NodeListAdapter nodeListAdapter, Node node) {
        M(new Runnable() { // from class: com.v.pg
            @Override // java.lang.Runnable
            public final void run() {
                this.c.x(nodeListAdapter);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        int id = view.getId();
        if (id == j.b.e.P) {
            c();
        } else if (id == j.b.e.J) {
            L("执行节点");
        }
    }

    public NodeMenuDialogView(Context context) {
        this(context, null);
    }

    public NodeMenuDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }
}

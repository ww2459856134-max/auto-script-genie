package com.v;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.NodeListAdapter;
import com.adapter.NodeSearchAdapter;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.google.gson.Gson;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.v.DelaySetDialogView;
import com.v.DurationSetDialogView;
import com.v.ItemChooseDialogView;
import com.v.NodeClipBoardDialogView;
import com.v.NodeRepeatCountDialogView;
import com.yl.float_ui.CanDragFloatView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NodeListDialogView extends CanDragFloatView implements OnItemDragListener, BaseQuickAdapter.OnItemClickListener, View.OnClickListener, BaseQuickAdapter.OnItemLongClickListener, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemChildLongClickListener {
    public static final Class<? extends NodeListDialogView>[] I = {NodeListDialogView.class, NodeListDialogView1.class, NodeListDialogView2.class, NodeListDialogView3.class};
    private View A;
    private View C;
    private View D;
    private Runnable G;
    private Node H;
    private NodeListAdapter c;
    private Task d;
    private RecyclerView e;
    private TextView f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f1006h;

    /* renamed from: i, reason: collision with root package name */
    private View f1007i;

    /* renamed from: j, reason: collision with root package name */
    private View f1008j;

    /* renamed from: k, reason: collision with root package name */
    private View f1009k;
    private View t;

    class a implements ItemChooseDialogView.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(List list, Node[] nodeArr) {
            for (Node node : i.b.n8.a(list, NodeListDialogView.this.d.getNodeMap().values())) {
                NodeListDialogView.this.c.addData((NodeListAdapter) node);
                i.b.v8.m().q(NodeListDialogView.this.d, nodeArr[0], node);
                nodeArr[0] = node;
            }
            NodeListDialogView.this.e1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(final List list) {
            if (list.isEmpty()) {
                FloatToast.i("未选中需要复制的节点");
            } else {
                final Node[] nodeArr = {NodeListDialogView.this.c.getData().isEmpty() ? null : NodeListDialogView.this.c.getData().get(NodeListDialogView.this.c.getData().size() - 1)};
                NodeListDialogView.this.d1(new Runnable() { // from class: com.v.oe
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.c(list, nodeArr);
                    }
                });
            }
        }

        @Override // com.v.ItemChooseDialogView.b
        public void a(int i2, List<String> list) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            if (i2 == 0) {
                NodeListDialogView.this.m();
            } else if (1 == i2) {
                ((NodeClipBoardDialogView) com.frame.s0.g().x(NodeClipBoardDialogView.class)).setOnTextChoose(new NodeClipBoardDialogView.c() { // from class: com.v.pe
                    @Override // com.v.NodeClipBoardDialogView.c
                    public final void a(List list2) {
                        this.a.e(list2);
                    }
                });
            } else if (2 == i2) {
                NodeListDialogView.this.i1();
            }
        }
    }

    public NodeListDialogView() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.x, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(View view) {
        j1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean E(View view) {
        if (this.c.getData().isEmpty()) {
            FloatToast.i("节点空");
            return true;
        }
        e1();
        i.b.ea eaVar = new i.b.ea();
        if (!eaVar.d()) {
            return false;
        }
        if (this.d.isNeedScan() && !eaVar.c()) {
            return false;
        }
        i.b.da.B().e2(this.d, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0() {
        this.c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(List list) {
        this.c.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G0(Node node) {
        d1(new Runnable() { // from class: com.v.ye
            @Override // java.lang.Runnable
            public final void run() {
                this.c.E0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I() {
        final List<Node> listG = i.b.x7.d().g(this.d);
        com.frame.l1.e(new Runnable() { // from class: com.v.af
            @Override // java.lang.Runnable
            public final void run() {
                this.c.G(listG);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K() {
        NodeListAdapter nodeListAdapter = this.c;
        if (nodeListAdapter != null) {
            nodeListAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(Node node) {
        int iIndexOf;
        NodeListAdapter nodeListAdapter = this.c;
        if (nodeListAdapter == null || this.e == null || (iIndexOf = nodeListAdapter.getData().indexOf(node)) < 0) {
            return;
        }
        this.c.m(iIndexOf);
        RecyclerView.o layoutManager = this.e.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).A2(iIndexOf, 0);
        } else {
            this.e.j1(iIndexOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(List list, TreeMap treeMap) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Node node = (Node) it.next();
            if (node != null) {
                i.b.v8.m().h0(this.d, node);
                this.c.getData().remove(node);
            }
        }
        treeMap.clear();
        this.c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().i(FloatHandler.class);
        com.frame.s0.g().o(this);
        try {
            if (this.c.getData().isEmpty()) {
                FloatHandlerContinue.m().l(this.d, null);
            } else {
                FloatHandlerContinue.m().l(this.d, this.c.getData().get(this.c.getData().size() - 1));
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            FloatToast.i("无法添加，请新建新的任务脚本");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(List list, Node[] nodeArr) {
        for (Node node : i.b.n8.a(list, this.d.getNodeMap().values())) {
            this.c.addData((NodeListAdapter) node);
            i.b.v8.m().q(this.d, nodeArr[0], node);
            nodeArr[0] = node;
        }
        e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P0(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 != 0) {
            return;
        }
        o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(final List list) {
        if (list.isEmpty()) {
            FloatToast.i("未选中需要复制的节点");
        } else {
            final Node[] nodeArr = {this.c.getData().isEmpty() ? null : this.c.getData().get(this.c.getData().size() - 1)};
            d1(new Runnable() { // from class: com.v.bf
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.O(list, nodeArr);
                }
            });
        }
    }

    static /* synthetic */ void R() {
        TaskChooseDialogView taskChooseDialogView = (TaskChooseDialogView) com.frame.s0.g().f(TaskChooseDialogView.class);
        if (taskChooseDialogView != null) {
            taskChooseDialogView.update();
        }
    }

    static /* synthetic */ void S() {
    }

    static /* synthetic */ void S0(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("chenai://www.skyingidea.com/pay"));
            intent.putExtra(SocialConstants.PARAM_TYPE, "login");
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.i("no_webapp");
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void T(TreeMap treeMap) {
        Iterator<Node> it = i.b.n8.a(new ArrayList(treeMap.values()), i.b.v8.m().n()).iterator();
        while (it.hasNext()) {
            i.b.v8.m().c(it.next());
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.gf
            @Override // java.lang.Runnable
            public final void run() {
                NodeListDialogView.S();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U0(final int i2, final Node node, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        d1(new Runnable() { // from class: com.v.pf
            @Override // java.lang.Runnable
            public final void run() {
                this.c.X0(node, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(String str) {
        NodeListAdapter nodeListAdapter = this.c;
        Objects.requireNonNull(nodeListAdapter);
        d1(new p9(nodeListAdapter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(String str) {
        NodeListAdapter nodeListAdapter = this.c;
        Objects.requireNonNull(nodeListAdapter);
        d1(new p9(nodeListAdapter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0(Node node, int i2) {
        NodeListAdapter nodeListAdapter;
        if (node == null || (nodeListAdapter = this.c) == null) {
            return;
        }
        if (i2 < 0 || i2 >= nodeListAdapter.getData().size()) {
            i2 = this.c.getData().indexOf(node);
        }
        if (i2 >= 0 && i2 < this.c.getData().size()) {
            this.c.remove(i2);
        }
        i.b.v8.m().h0(this.d, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean a0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!i.b.da.B().R(str)) {
            Task taskL = i.b.da.B().L(this.d.getId());
            taskL.setName(str);
            i.b.da.B().R1(taskL);
            this.f.setText(str);
            return true;
        }
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.g(j.b.d.q0);
            dingMsgView.h("任务名请不要重复~~~");
            dingMsgView.l("温馨提示");
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.kg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.l("温馨提示");
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a1(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        c1();
        com.yl.ui.i0.l(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(NodeSearchAdapter nodeSearchAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Node item = nodeSearchAdapter.getItem(i2);
        com.frame.s0.g().d(InputDialogView.class);
        t(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean e0(NodeSearchAdapter nodeSearchAdapter, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < this.c.getData().size()) {
            Node item = this.c.getItem(i2);
            i2++;
            item.step = String.valueOf(i2);
            String str2 = item.name;
            if (str2 != null && str2.contains(str)) {
                arrayList.add(item);
            } else if (item.step.contains(str)) {
                arrayList.add(item);
            }
        }
        nodeSearchAdapter.setNewData(arrayList);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        RecyclerView recyclerView = this.e;
        if (recyclerView != null && recyclerView.w0()) {
            this.e.post(runnable);
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 != null) {
            recyclerView2.post(runnable);
        } else {
            com.frame.l1.e(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0() {
        for (int i2 = 0; i2 < this.c.getData().size(); i2++) {
            try {
                this.c.f().put(Integer.valueOf(i2), this.c.getItem(i2));
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        this.c.notifyDataSetChanged();
    }

    public static void g1(Node node) {
        NodeListDialogView nodeListDialogView = (NodeListDialogView) com.frame.s0.g().f(NodeListDialogView.class);
        if (nodeListDialogView == null) {
            return;
        }
        nodeListDialogView.t(node);
    }

    public static int getH() {
        return com.frame.n0.c("nld_h", com.frame.p1.c(400.0f));
    }

    public static int getW() {
        return com.frame.n0.c("nld_w", com.frame.p1.c(240.0f));
    }

    public static NodeListDialogView h1(long j2) {
        int w = getW();
        int h2 = getH();
        int iE = (com.frame.q1.e() - w) / 2;
        int iD = (com.frame.q1.d() - h2) / 2;
        NodeListDialogView nodeListDialogView = (NodeListDialogView) com.frame.s0.g().y(NodeListDialogView.class, com.frame.n0.c("nld_x", iE), com.frame.n0.c("nld_y", iD), w, h2);
        nodeListDialogView.r(j2);
        return nodeListDialogView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0(List list, Node[] nodeArr, Task task, LinkedHashMap linkedHashMap, String str, int i2, Node node) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Node node2 = (Node) it.next();
            this.c.getData().remove(node2);
            i.b.v8.m().h0(this.d, node2);
            Node node3 = nodeArr[0];
            if (node3 == null) {
                task.setFirstNodeId(node2.id);
            } else if (!node3.isJumOtherType()) {
                node3.nextId = node2.id;
                node2.frontId = node3.id;
            }
            linkedHashMap.put(Long.valueOf(node2.id), node2);
            nodeArr[0] = node2;
        }
        Node node4 = nodeArr[0];
        if (node4 != null && !node4.isJumOtherType()) {
            node4.nextId = 0L;
        }
        Node nodeQ = i.b.v8.m().Q();
        if (nodeQ != null) {
            nodeQ.errorType = 4;
            nodeQ.errorId = task.getId();
            nodeQ.type = 15;
            nodeQ.nextType = 2;
            nodeQ.name = "跳转任务:" + str;
        }
        this.c.f().clear();
        this.c.notifyDataSetChanged();
        if (nodeQ != null) {
            this.c.addData(i2, (int) nodeQ);
        }
        try {
            TaskSimple taskSimpleW = i.b.da.B().w(this.d.getId());
            if (TextUtils.isEmpty(taskSimpleW.getGroup())) {
                taskSimpleW.setGroup(this.d.getName());
                Task task2 = this.d;
                task2.setGroup(task2.getName());
                task.setGroup(this.d.getName());
            } else {
                task.setGroup(taskSimpleW.getGroup());
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        if (nodeQ != null) {
            nodeQ.duration = 1L;
            nodeQ.delay = "100";
            i.b.v8.m().q(this.d, node, nodeQ);
        }
        task.setScreenHeight(this.d.getScreenHeight());
        task.setScreenWith(this.d.getScreenWith());
        task.setLimitTime(this.d.getLimitTime());
        task.setPwd(this.d.getPwd());
        task.setCreateUserId(this.d.getCreateUserId());
        task.setNodeMap(linkedHashMap);
        i.b.v8.m().j0(node);
        i.b.da.B().R1(task);
        e1();
        com.yl.ui.i0.l(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否确定要继续录制操作？点击悬浮窗的录制按钮将可继续录制操作。");
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.qf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.if
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.N0(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean l0(TreeMap treeMap, final int i2, final Node node, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.d.getName() + "-分支";
        }
        final String str2 = str;
        if (!i.b.da.B().R(str2)) {
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            final Task task = new Task();
            task.setName(str2);
            task.setId(System.currentTimeMillis());
            final Node[] nodeArr = new Node[1];
            final ArrayList arrayList = new ArrayList(treeMap.values());
            d1(new Runnable() { // from class: com.v.se
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.j0(arrayList, nodeArr, task, linkedHashMap, str2, i2, node);
                }
            });
            return true;
        }
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.g(j.b.d.q0);
            dingMsgView.h("任务名请不要重复~~~");
            dingMsgView.l("温馨提示");
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.tf
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

    public static NodeListDialogView m1(long j2) {
        int w = getW();
        int h2 = getH();
        int iE = (com.frame.q1.e() - w) / 2;
        int iD = (com.frame.q1.d() - h2) / 2;
        int iC = com.frame.n0.c("nld_x", iE);
        int iC2 = com.frame.n0.c("nld_y", iD);
        com.frame.s0 s0VarG = com.frame.s0.g();
        for (Class<? extends NodeListDialogView> cls : I) {
            if (s0VarG.f(cls) == null) {
                NodeListDialogView nodeListDialogView = (NodeListDialogView) s0VarG.y(cls, iC, iC2, w, h2);
                nodeListDialogView.r(j2);
                return nodeListDialogView;
            }
        }
        NodeListDialogView nodeListDialogView2 = (NodeListDialogView) s0VarG.y(NodeListDialogView.class, iC, iC2, w, h2);
        nodeListDialogView2.r(j2);
        return nodeListDialogView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(int i2) {
        this.c.notifyItemChanged(i2);
    }

    private View p() {
        TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(Color.parseColor("#88999999"));
        textView.setText("顺序/调整错误处理");
        int iC = com.frame.p1.c(10.0f);
        textView.setPadding(0, iC, 0, iC);
        textView.setTextSize(10.0f);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.yf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.C(view);
            }
        });
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        textView.setGravity(17);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean q0(Node node, final int i2, String str) {
        if (node.type != 15 || !i.b.da.B().R(str)) {
            node.name = str;
            d1(new Runnable() { // from class: com.v.zf
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.o0(i2);
                }
            });
            return true;
        }
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.g(j.b.d.q0);
            dingMsgView.h("任务名请不要重复~~~");
            dingMsgView.l("温馨提示");
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.gg
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void I0(Node node, int i2) {
        NodeListAdapter nodeListAdapter;
        if (node == null || (nodeListAdapter = this.c) == null || this.d == null || i2 < 0 || i2 >= nodeListAdapter.getData().size() || this.d.getNodeMap() == null || !this.d.getNodeMap().containsKey(Long.valueOf(node.id))) {
            return;
        }
        Node item = i2 == 0 ? null : this.c.getItem(i2 - 1);
        if (item == null || item != node) {
            i.b.v8.m().h0(this.d, node);
            i.b.v8.m().q(this.d, item, node);
        }
    }

    private Node q(int i2) {
        NodeListAdapter nodeListAdapter;
        if (i2 < 0 || (nodeListAdapter = this.c) == null || i2 >= nodeListAdapter.getData().size()) {
            return null;
        }
        return this.c.getItem(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(String str) {
        NodeListAdapter nodeListAdapter = this.c;
        Objects.requireNonNull(nodeListAdapter);
        d1(new p9(nodeListAdapter));
    }

    private boolean s(Long l2) {
        if (l2 != null && AccountTool.d().j()) {
            if (l2.equals(AccountTool.d().c().getPid())) {
                return true;
            }
            String strF = com.frame.n0.f("subUserIds", "");
            if (TextUtils.isEmpty(strF)) {
                return false;
            }
            for (String str : strF.split(",")) {
                if (String.valueOf(l2).equals(str.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(String str) {
        NodeListAdapter nodeListAdapter = this.c;
        Objects.requireNonNull(nodeListAdapter);
        d1(new p9(nodeListAdapter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(final Node node) {
        NodeListDialogView nodeListDialogView = (NodeListDialogView) com.frame.s0.g().t(this);
        if (nodeListDialogView != null) {
            nodeListDialogView.post(new Runnable() { // from class: com.v.dg
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.u(node);
                }
            });
        }
        com.frame.s0.g().u(FlowView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(String str) {
        NodeListAdapter nodeListAdapter = this.c;
        Objects.requireNonNull(nodeListAdapter);
        d1(new p9(nodeListAdapter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(int i2, final Node node) {
        this.c.addData(i2 + 1, (int) node);
        e1();
        com.frame.l1.f(new Runnable() { // from class: com.v.hg
            @Override // java.lang.Runnable
            public final void run() {
                this.c.w(node);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0() {
        this.c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(final int i2, final Node node) {
        if (node != null) {
            d1(new Runnable() { // from class: com.v.ze
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.y(i2, node);
                }
            });
        } else {
            com.frame.s0.g().t(this);
            com.frame.s0.g().u(FlowView.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(Node node) {
        d1(new Runnable() { // from class: com.v.ue
            @Override // java.lang.Runnable
            public final void run() {
                this.c.y0();
            }
        });
    }

    public void b1() {
    }

    public void c1() {
        LinkedHashMap<Long, Node> nodeMap = this.d.getNodeMap();
        LinkedHashMap<Long, Node> linkedHashMap = new LinkedHashMap<>();
        Node node = null;
        for (Node node2 : this.c.getData()) {
            if (node != null) {
                node.nextId = node2.id;
                node2.frontId = node.id;
            } else {
                this.d.setFirstNodeId(node2.id);
            }
            node2.step = String.valueOf(linkedHashMap.size() + 1);
            linkedHashMap.put(Long.valueOf(node2.id), node2);
            node = node2;
        }
        if (node != null && node.nextType == 2) {
            node.nextId = 0L;
            this.d.setLastNodeId(node.id);
        }
        for (Node node3 : nodeMap.values()) {
            if (!linkedHashMap.containsKey(Long.valueOf(node3.id))) {
                linkedHashMap.put(Long.valueOf(node3.id), node3);
            }
        }
        this.d.setNodeMap(linkedHashMap);
        i.b.da.B().z1(this.d);
    }

    public void e1() {
        LinkedHashMap<Long, Node> linkedHashMap = new LinkedHashMap<>();
        Iterator<Node> it = this.c.getData().iterator();
        Node next = null;
        while (it.hasNext()) {
            next = it.next();
            next.step = String.valueOf(linkedHashMap.size() + 1);
            linkedHashMap.put(Long.valueOf(next.id), next);
        }
        if (linkedHashMap.isEmpty()) {
            com.frame.y0.j("脚本节点是空的，不做保存，避免脚本节点被清空问题");
            return;
        }
        int i2 = next.nextType;
        if ((i2 == 2 || i2 == -1) && next.nextId != 0) {
            next.nextId = 0L;
        }
        this.d.setNodeMap(linkedHashMap);
        i.b.da.B().R1(this.d);
        com.frame.y0.n("保存脚本");
    }

    public void endResize() {
        endMove(true);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        com.frame.n0.i("nld_x", layoutParams.x);
        com.frame.n0.i("nld_y", layoutParams.y);
        com.frame.n0.i("nld_w", layoutParams.width);
        com.frame.n0.i("nld_h", layoutParams.height);
    }

    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void u(final Node node) {
        RecyclerView recyclerView;
        if (node == null || this.c == null || (recyclerView = this.e) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.v.ve
            @Override // java.lang.Runnable
            public final void run() {
                this.c.K0(node);
            }
        });
    }

    public NodeListAdapter getNodeAdapter() {
        return this.c;
    }

    public RecyclerView getNodeRecyclerView() {
        return this.e;
    }

    public Task getNodeTask() {
        return this.d;
    }

    public Task getTask() {
        return this.d;
    }

    public void j1() {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择错误类型");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("节点执行顺序错乱".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.of
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.P0(i2, list);
            }
        });
    }

    public void k1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("此脚本限制特定用户使用，您不可用，请切换账号！或联系脚本创建者（非官方开发者）！");
        dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.v.rf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.l("温馨提示");
    }

    public void l1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("此任务已用到「图片识别」等功能，请登录后使用？");
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.ff
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.k("去登录", new View.OnClickListener() { // from class: com.v.hf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NodeListDialogView.S0(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        int w = getW();
        int h2 = getH();
        return new Point(com.frame.n0.c("nld_x", (com.frame.q1.e() - w) / 2), com.frame.n0.c("nld_y", (com.frame.q1.d() - h2) / 2));
    }

    public void m() {
        int size = this.c.getData().size() - 1;
        n(size, !this.c.getData().isEmpty() ? this.c.getData().get(size) : null);
    }

    public void n(final int i2, Node node) {
        i.b.v8.m().k0(this.d);
        i.b.v8.m().j0(node);
        com.frame.s0.g().j(this);
        ((OptionListDialogView) com.frame.s0.g().x(OptionListDialogView.class)).setCallback(new lt() { // from class: com.v.we
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.A(i2, node2);
            }
        });
    }

    public void n1(final Node node, final int i2) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(String.format("是否确定要删除「<font color='#F45075'>%s</font>」操作节点？", node.getStepAndName()));
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.jg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.le
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.U0(i2, node, view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void o() {
        this.f1006h.setVisibility(0);
        findViewById(j.b.e.c4).setVisibility(0);
        this.c.o(true);
        this.f1008j.setVisibility(0);
        this.f1007i.setVisibility(8);
        this.c.n(true);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
    }

    public void o1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("当查看流程图时发现节点错乱，可能是脚本在编辑时出现错误，可以由app重新连线调整执行顺序修复，修复后部分的跳转节点需要重新设置一下，具体可以看流程图的连线。");
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.re
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.k("重新连线", new View.OnClickListener() { // from class: com.v.cg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.a1(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    @Override // com.yl.float_ui.CanDragFloatView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d1(new Runnable() { // from class: com.v.ag
            @Override // java.lang.Runnable
            public final void run() {
                this.c.K();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.G0) {
            final TreeMap<Integer, Node> treeMapF = this.c.f();
            if (treeMapF == null || treeMapF.isEmpty()) {
                FloatToast.i("请先选择节点");
                return;
            } else {
                final ArrayList arrayList = new ArrayList(treeMapF.values());
                d1(new Runnable() { // from class: com.v.kf
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.M(arrayList, treeMapF);
                    }
                });
                return;
            }
        }
        if (id == j.b.e.f1755n) {
            ((NodeClipBoardDialogView) com.frame.s0.g().x(NodeClipBoardDialogView.class)).setOnTextChoose(new NodeClipBoardDialogView.c() { // from class: com.v.uf
                @Override // com.v.NodeClipBoardDialogView.c
                public final void a(List list) {
                    this.a.Q(list);
                }
            });
            return;
        }
        if (id == j.b.e.f1) {
            e1();
            TaskMenuDialogView.t(i.b.da.B().w(this.d.getId()), new Runnable() { // from class: com.v.df
                @Override // java.lang.Runnable
                public final void run() {
                    NodeListDialogView.R();
                }
            });
            return;
        }
        if (id == j.b.e.D0) {
            final TreeMap<Integer, Node> treeMapF2 = this.c.f();
            if (treeMapF2 == null || treeMapF2.isEmpty()) {
                FloatToast.i("请先选择节点");
                return;
            } else {
                com.frame.l1.g(new Runnable() { // from class: com.v.sf
                    @Override // java.lang.Runnable
                    public final void run() {
                        NodeListDialogView.T(treeMapF2);
                    }
                });
                return;
            }
        }
        if (id == j.b.e.E0) {
            TreeMap<Integer, Node> treeMapF3 = this.c.f();
            if (treeMapF3 == null || treeMapF3.isEmpty()) {
                FloatToast.i("请先选择节点");
                return;
            }
            DelaySetDialogView delaySetDialogView = (DelaySetDialogView) com.frame.s0.g().B(DelaySetDialogView.class);
            delaySetDialogView.setNodeList(treeMapF3.values());
            delaySetDialogView.v(new DelaySetDialogView.a() { // from class: com.v.xe
                @Override // com.v.DelaySetDialogView.a
                public final void a(String str) {
                    this.a.V(str);
                }
            });
            return;
        }
        if (id == j.b.e.F0) {
            TreeMap<Integer, Node> treeMapF4 = this.c.f();
            if (treeMapF4 == null || treeMapF4.isEmpty()) {
                FloatToast.i("请先选择节点");
                return;
            }
            DurationSetDialogView durationSetDialogView = (DurationSetDialogView) com.frame.s0.g().B(DurationSetDialogView.class);
            durationSetDialogView.setNodeList(treeMapF4.values());
            durationSetDialogView.v(new DurationSetDialogView.b() { // from class: com.v.ig
                @Override // com.v.DurationSetDialogView.b
                public final void a(String str) {
                    this.a.X(str);
                }
            });
            return;
        }
        if (id == j.b.e.o0) {
            if (this.c.getData().isEmpty()) {
                FloatToast.i("节点空");
                return;
            }
            e1();
            int iK = (com.frame.q1.k() * 5) / 6;
            int i2 = (com.frame.q1.i() * 4) / 5;
            ((FlowView) com.frame.s0.g().y(FlowView.class, (com.frame.q1.k() - iK) / 2, (com.frame.q1.i() - i2) / 2, iK, i2)).setTask(this.d);
            return;
        }
        if (id == j.b.e.P) {
            com.frame.s0.g().d(TaskChooseDialogView.class);
            com.frame.s0.g().o(this);
            if (this.c.getData().isEmpty()) {
                FloatToast.i("节点空");
                return;
            }
            e1();
            i.b.ea eaVar = new i.b.ea();
            if (eaVar.d()) {
                if (!this.d.isNeedScan() || eaVar.c()) {
                    i.b.da.B().e2(this.d, true);
                    return;
                }
                return;
            }
            return;
        }
        if (id == j.b.e.g) {
            ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.setTitle("选择菜单");
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("添加单个节点,从剪切板插入,继续录制".split(","))));
            itemChooseDialogView.setOnTextChoose(new a());
            return;
        }
        if (id == j.b.e.X) {
            i1();
            return;
        }
        if (id == j.b.e.l0) {
            j1();
            return;
        }
        int i3 = j.b.e.w6;
        if (id == i3) {
            InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.v(1);
            inputDialogView.l("任务名称");
            inputDialogView.s("请输入任务名称");
            inputDialogView.w(this.d.getName());
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.wf
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.a0(str);
                }
            });
            return;
        }
        if (id == j.b.e.M) {
            RecyclerView recyclerView = new RecyclerView(com.frame.v0.g());
            recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
            final NodeSearchAdapter nodeSearchAdapter = new NodeSearchAdapter(null);
            nodeSearchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.eg
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i4) {
                    this.c.c0(nodeSearchAdapter, baseQuickAdapter, view2, i4);
                }
            });
            recyclerView.setAdapter(nodeSearchAdapter);
            InputDialogView inputDialogView2 = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            ((TextView) inputDialogView2.findViewById(com.yl.float_ui.j0.b)).setText("搜索");
            inputDialogView2.v(1);
            inputDialogView2.l("搜索节点");
            inputDialogView2.a(recyclerView);
            inputDialogView2.s("请输入关键词或序号");
            inputDialogView2.t(new InputDialogView.a() { // from class: com.v.ef
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.e0(nodeSearchAdapter, str);
                }
            });
            return;
        }
        if (id == j.b.e.h0) {
            if (this.c.getData().isEmpty()) {
                FloatToast.i("节点空");
            } else {
                e1();
            }
            Runnable runnable = this.G;
            this.G = null;
            com.frame.s0.g().o(this);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (id == j.b.e.a0) {
            d1(new Runnable() { // from class: com.v.te
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.g0();
                }
            });
            return;
        }
        if (id == j.b.e.k0) {
            o();
            return;
        }
        if (id == j.b.e.x1) {
            final TreeMap<Integer, Node> treeMapF5 = this.c.f();
            if (treeMapF5 == null || treeMapF5.isEmpty()) {
                FloatToast.i("请先选择分支节点");
                return;
            }
            ArrayList arrayList2 = new ArrayList(this.c.f().keySet());
            com.frame.y0.g(arrayList2.toString());
            final int iIntValue = ((Integer) arrayList2.get(0)).intValue();
            final Node node = iIntValue > 0 ? this.c.getData().get(iIntValue - 1) : null;
            InputDialogView inputDialogView3 = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView3.v(1);
            inputDialogView3.s("请输入分支任务名称");
            inputDialogView3.findViewById(i3).setVisibility(8);
            inputDialogView3.t(new InputDialogView.a() { // from class: com.v.jf
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.l0(treeMapF5, iIntValue, node, str);
                }
            });
            return;
        }
        if (id == j.b.e.Y) {
            m();
            return;
        }
        if (id == j.b.e.M0) {
            i1();
            return;
        }
        if (id == j.b.e.i0) {
            this.c.n(false);
            this.c.o(false);
            if (this.c.f() != null) {
                this.c.f().clear();
            }
            this.f1008j.setVisibility(8);
            findViewById(j.b.e.c4).setVisibility(8);
            this.f1007i.setVisibility(0);
            this.f1006h.setVisibility(8);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, final int i2) throws Resources.NotFoundException {
        int id = view.getId();
        final Node nodeQ = q(i2);
        if (nodeQ != null || id == j.b.e.k1) {
            if (id == j.b.e.m6) {
                InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
                inputDialogView.v(1);
                inputDialogView.w(nodeQ.name);
                inputDialogView.s("请输入任务名称");
                inputDialogView.t(new InputDialogView.a() { // from class: com.v.vf
                    @Override // com.yl.float_ui.InputDialogView.a
                    public final boolean a(String str) {
                        return this.a.q0(nodeQ, i2, str);
                    }
                });
                return;
            }
            if (id == j.b.e.q6) {
                NodeRepeatCountDialogView nodeRepeatCountDialogView = (NodeRepeatCountDialogView) com.frame.s0.g().B(NodeRepeatCountDialogView.class);
                nodeRepeatCountDialogView.setNode(nodeQ);
                nodeRepeatCountDialogView.u(new NodeRepeatCountDialogView.a() { // from class: com.v.xf
                    @Override // com.v.NodeRepeatCountDialogView.a
                    public final void a(String str) {
                        this.a.s0(str);
                    }
                });
                return;
            }
            if (id == j.b.e.j1) {
                if (nodeQ.type == 15 && nodeQ.errorType == 4) {
                    m1(nodeQ.errorId);
                    return;
                }
                GesturePlayFloatView gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().E(GesturePlayFloatView.class);
                gesturePlayFloatView.removeAllViews();
                gesturePlayFloatView.A(i2, nodeQ);
                return;
            }
            if (id == j.b.e.O0) {
                n1(nodeQ, i2);
                return;
            }
            if (id == j.b.e.y0) {
                NodeMenuDialogView.N(this, i2, view);
                return;
            }
            if (id == j.b.e.f6) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(nodeQ);
                DelaySetDialogView delaySetDialogView = (DelaySetDialogView) com.frame.s0.g().B(DelaySetDialogView.class);
                delaySetDialogView.setNodeList(arrayList);
                delaySetDialogView.v(new DelaySetDialogView.a() { // from class: com.v.cf
                    @Override // com.v.DelaySetDialogView.a
                    public final void a(String str) {
                        this.a.u0(str);
                    }
                });
                return;
            }
            if (id == j.b.e.h6) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(nodeQ);
                DurationSetDialogView durationSetDialogView = (DurationSetDialogView) com.frame.s0.g().B(DurationSetDialogView.class);
                durationSetDialogView.setNodeList(arrayList2);
                durationSetDialogView.v(new DurationSetDialogView.b() { // from class: com.v.qe
                    @Override // com.v.DurationSetDialogView.b
                    public final void a(String str) {
                        this.a.w0(str);
                    }
                });
                return;
            }
            if (id == j.b.e.k1) {
                if (this.c.g(i2)) {
                    this.c.j(i2);
                } else {
                    this.c.c(i2);
                }
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildLongClickListener
    public boolean onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Node nodeQ = q(i2);
        if (nodeQ == null) {
            return true;
        }
        int id = view.getId();
        if (id == j.b.e.m6) {
            i.b.v8.m().d(this.d, nodeQ, new lt() { // from class: com.v.lf
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.A0(node);
                }
            });
        } else if (id == j.b.e.j1) {
            try {
                JSONObject jSONObject = new JSONObject(new Gson().s(nodeQ));
                StringBuffer stringBuffer = new StringBuffer();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObject.optString(next);
                    stringBuffer.append(next);
                    stringBuffer.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                    stringBuffer.append(strOptString);
                    stringBuffer.append("，");
                }
                DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                dingMsgView.h(stringBuffer.toString());
                dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.ne
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
                dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.nf
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
                dingMsgView.l("节点代码");
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Node nodeQ = q(i2);
        if (nodeQ == null) {
            return;
        }
        i.b.v8.m().d(this.d, nodeQ, new lt() { // from class: com.v.bg
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.G0(node);
            }
        });
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragEnd(RecyclerView.d0 d0Var, final int i2) {
        final Node node = this.H;
        if (node == null || i2 == -1) {
            return;
        }
        this.H = null;
        RecyclerView recyclerView = this.e;
        if (recyclerView == null || !recyclerView.w0()) {
            H0(node, i2);
        } else {
            com.frame.l1.e(new Runnable() { // from class: com.v.fg
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.I0(node, i2);
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragMoving(RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3) {
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragStart(RecyclerView.d0 d0Var, int i2) {
        this.H = q(i2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
    public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.c.n(true);
        this.f1007i.setVisibility(8);
        this.f1008j.setVisibility(0);
        o();
        return true;
    }

    public void r(long j2) {
        Task taskL = i.b.da.B().L(j2);
        this.d = taskL;
        if (taskL == null) {
            FloatToast.i("未找到此脚本，请联系技术小哥排查问题");
            com.frame.s0.g().o(this);
            return;
        }
        if (taskL.getCreateUserId() != null && !AccountTool.d().j()) {
            new i.b.ea().E("为了脚本的安全确权，避免脚本盗取行为，请先登录后再使用脚本。");
            com.frame.s0.g().o(this);
            return;
        }
        if (!new i.b.l9().g(this.d)) {
            com.frame.s0.g().o(this);
            return;
        }
        if (this.d.getCreateUserId() != null && this.d.getLimitUserId() != null) {
            if (!AccountTool.d().j()) {
                com.frame.l1.e(new Runnable() { // from class: com.v.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.l1();
                    }
                });
                com.frame.s0.g().o(this);
                return;
            }
            if (!AccountTool.d().k(this.d.getCreateUserId())) {
                if (this.d.getLimitUserId().longValue() == -1) {
                    if (!s(this.d.getCreateUserId())) {
                        com.frame.l1.e(new Runnable() { // from class: com.v.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.k1();
                            }
                        });
                        com.frame.s0.g().o(this);
                        return;
                    }
                } else if (!AccountTool.d().k(this.d.getLimitUserId()) && !AccountTool.d().k(this.d.getCreateUserId()) && !s(this.d.getCreateUserId())) {
                    com.frame.l1.e(new Runnable() { // from class: com.v.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.k1();
                        }
                    });
                    com.frame.s0.g().o(this);
                    return;
                }
            }
        }
        if (this.d.getCreateUserId() != null) {
            if (!AccountTool.d().j()) {
                try {
                    FloatToast.i("未登录，请先登录！");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse("chenai://www.auto/login"));
                    com.frame.v0.g().startActivity(intent);
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
                com.frame.s0.g().o(this);
                return;
            }
            if (!AccountTool.d().k(this.d.getCreateUserId())) {
                if (this.d.getLimitUserId() != null) {
                    this.d.getLimitUserId().longValue();
                }
                if (this.d.isCanNotShare() || i.b.da.q) {
                    FloatToast.i("此脚本不可分享/脚本，请联系脚本制作者（非软件开发者）");
                    com.frame.s0.g().o(this);
                    return;
                }
            }
        }
        i.b.v8.m().k0(this.d);
        TextView textView = (TextView) findViewById(j.b.e.w6);
        this.f = textView;
        textView.setText(this.d.getName());
        this.f.setOnClickListener(this);
        this.f.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById = findViewById(j.b.e.M);
        this.C = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.C.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById2 = findViewById(j.b.e.h0);
        this.C = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.C.setOnTouchListener(this.mSubTouchListener);
        setBackAction(null);
        View viewFindViewById3 = findViewById(j.b.e.f1);
        this.D = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this);
        this.D.setOnTouchListener(this.mSubTouchListener);
        this.f1006h = (TextView) findViewById(j.b.e.a0);
        this.f1007i = findViewById(j.b.e.k0);
        this.f1008j = findViewById(j.b.e.i0);
        this.g = (TextView) findViewById(j.b.e.l0);
        this.t = findViewById(j.b.e.E0);
        this.f1009k = findViewById(j.b.e.F0);
        this.A = findViewById(j.b.e.G0);
        this.f1006h.setOnTouchListener(this.mSubTouchListener);
        this.f1008j.setOnTouchListener(this.mSubTouchListener);
        this.A.setOnTouchListener(this.mSubTouchListener);
        this.t.setOnTouchListener(this.mSubTouchListener);
        this.f1009k.setOnTouchListener(this.mSubTouchListener);
        this.f1008j.setOnTouchListener(this.mSubTouchListener);
        this.f1007i.setOnTouchListener(this.mSubTouchListener);
        this.f1006h.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.f1009k.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.f1008j.setOnClickListener(this);
        this.f1007i.setOnClickListener(this);
        View viewFindViewById4 = findViewById(j.b.e.g);
        viewFindViewById4.setOnTouchListener(this.mSubTouchListener);
        viewFindViewById4.setOnClickListener(this);
        View viewFindViewById5 = findViewById(j.b.e.P);
        viewFindViewById5.setOnTouchListener(this.mSubTouchListener);
        viewFindViewById5.setOnClickListener(this);
        viewFindViewById5.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.v.me
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.c.E(view);
            }
        });
        findViewById(j.b.e.D0).setOnClickListener(this);
        findViewById(j.b.e.o0).setOnClickListener(this);
        findViewById(j.b.e.x1).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        this.e = recyclerView;
        if (recyclerView.getItemAnimator() instanceof androidx.recyclerview.widget.g1) {
            ((androidx.recyclerview.widget.g1) this.e.getItemAnimator()).R(false);
        }
        this.c = new NodeListAdapter(null, this.d);
        this.e.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        this.e.setAdapter(this.c);
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.c));
        k0Var.j(this.e);
        this.c.enableDragItem(k0Var, j.b.e.h1, false);
        this.c.setOnItemDragListener(this);
        this.c.setOnItemLongClickListener(this);
        this.c.setOnItemChildClickListener(this);
        this.c.setOnItemClickListener(this);
        this.c.setOnItemChildLongClickListener(this);
        this.c.addFooterView(p());
        com.frame.l1.g(new Runnable() { // from class: com.v.mf
            @Override // java.lang.Runnable
            public final void run() {
                this.c.I();
            }
        });
        View viewFindViewById6 = findViewById(j.b.e.Q0);
        View viewFindViewById7 = findViewById(j.b.e.R0);
        i.b.y8 y8Var = new i.b.y8();
        y8Var.b(this, viewFindViewById6, new Runnable() { // from class: com.v.gt
            @Override // java.lang.Runnable
            public final void run() {
                this.c.endResize();
            }
        });
        y8Var.a(this, viewFindViewById7, new Runnable() { // from class: com.v.gt
            @Override // java.lang.Runnable
            public final void run() {
                this.c.endResize();
            }
        });
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("nld_x", point.x);
        com.frame.n0.i("nld_y", point.y);
    }

    void setBackAction(Runnable runnable) {
        this.G = runnable;
        View view = this.C;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            imageView.setImageResource(runnable == null ? j.b.d.A0 : j.b.d.r0);
            imageView.setContentDescription(runnable == null ? "关闭" : "返回");
        }
    }
}

package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.v.item.CheckItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class NodeJumpChooseDialogView extends RelativeLayout implements View.OnClickListener {
    private SelectAndDelayItem c;
    private SelectItem d;
    private Node e;
    private lt f;
    protected TextView g;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f1002h;

    /* renamed from: i, reason: collision with root package name */
    private Task f1003i;

    /* renamed from: j, reason: collision with root package name */
    private CheckItem f1004j;

    /* renamed from: k, reason: collision with root package name */
    private RunConditionItem f1005k;

    class a implements SelectAndDelayItem.c {
        final /* synthetic */ Node a;

        a(Node node) {
            this.a = node;
        }

        @Override // com.v.item.SelectAndDelayItem.c
        public void a(boolean z, int i2, Object obj, String str) {
            if (!"跳转任务".equals(NodeJumpChooseDialogView.this.c.getSelectLabel())) {
                if ("跳转节点".equals(NodeJumpChooseDialogView.this.c.getSelectLabel())) {
                    NodeJumpChooseDialogView.this.d.setVisibility(8);
                    NodeJumpChooseDialogView.this.f1004j.setVisibility(8);
                    return;
                } else {
                    NodeJumpChooseDialogView.this.d.setVisibility(8);
                    NodeJumpChooseDialogView.this.f1004j.setVisibility(8);
                    return;
                }
            }
            NodeJumpChooseDialogView.this.f1004j.setVisibility(0);
            NodeJumpChooseDialogView.this.d.setVisibility(0);
            NodeJumpChooseDialogView.this.d.setHint("从首个节点开始执行");
            try {
                Node node = i.b.da.B().L(this.a.errorId).getNodeMap().get(Long.valueOf(this.a.nextTaskNodeId));
                TextView textView = (TextView) NodeJumpChooseDialogView.this.d.findViewById(j.b.e.Z5);
                textView.setTag(Long.valueOf(this.a.nextTaskNodeId));
                textView.setText(node.getStepAndName());
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    class b implements lt {
        final /* synthetic */ TextView a;

        b(NodeJumpChooseDialogView nodeJumpChooseDialogView, TextView textView) {
            this.a = textView;
        }

        @Override // com.v.lt
        public void a(Node node) {
            this.a.setTag(Long.valueOf(node.id));
            this.a.setText(node.getStepAndName());
        }
    }

    public NodeJumpChooseDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.G, (ViewGroup) this, true);
        this.f1004j = (CheckItem) findViewById(j.b.e.l3);
        this.f1002h = (TextView) findViewById(j.b.e.g);
        this.g = (TextView) findViewById(j.b.e.P);
        this.c = (SelectAndDelayItem) findViewById(j.b.e.H2);
        this.d = (SelectItem) findViewById(j.b.e.g3);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.f1005k = runConditionItem;
        runConditionItem.setAttachView(this);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.v.ke
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(NodeJumpChooseDialogView.class);
            }
        });
        this.f1002h.setOnClickListener(new View.OnClickListener() { // from class: com.v.je
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        if (this.c.c()) {
            this.e.errorType = ((Integer) this.c.getValue()).intValue();
            if (this.c.getSubValue() != null) {
                this.e.errorId = ((Long) this.c.getSubValue()).longValue();
                if (TextUtils.isEmpty(this.e.name)) {
                    this.e.name = this.c.getSelectLabel() + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.c.getSelectSubLabel();
                }
            } else if (TextUtils.isEmpty(this.e.name)) {
                this.e.name = this.c.getSelectLabel();
            }
            try {
                this.e.nextTaskNodeId = ((Long) this.d.findViewById(j.b.e.Z5).getTag()).longValue();
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            this.e.jumpBack = this.f1004j.getValue().booleanValue();
            com.frame.s0.g().o(this);
            lt ltVar = this.f;
            if (ltVar != null) {
                ltVar.a(this.e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Node node, TextView textView, View view) {
        if (this.c.getSubValue() == null) {
            this.c.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        Task taskL = i.b.da.B().L(((Long) this.c.getSubValue()).longValue());
        if (taskL == null) {
            this.c.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        try {
            ArrayList arrayList = new ArrayList(taskL.getNodeMap().values());
            new com.v.item.j2(this.f1003i, this.e, this.c).k(arrayList, arrayList.indexOf(taskL.getNodeMap().get(Long.valueOf(node.nextTaskNodeId))), new b(this, textView));
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public NodeJumpChooseDialogView i(lt ltVar) {
        this.f = ltVar;
        return this;
    }

    public NodeJumpChooseDialogView j(Task task, final Node node) {
        this.f1003i = task;
        this.e = node;
        this.f1005k.setTaskNode(task, node);
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("跳转节点", null);
        linkedHashMap.put("跳转任务", null);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.f1004j.setValue(node.jumpBack);
        this.c.setItems(linkedHashMap2, linkedHashMap);
        this.c.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.c;
        selectAndDelayItem.setOnItemClick(new com.v.item.j2(this.f1003i, this.e, selectAndDelayItem));
        this.c.setOnSubTextChoose(new a(node));
        final TextView textView = (TextView) this.d.findViewById(j.b.e.Z5);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.ie
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.h(node, textView, view);
            }
        });
        this.c.setSelectValue(Integer.valueOf(this.e.errorType));
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

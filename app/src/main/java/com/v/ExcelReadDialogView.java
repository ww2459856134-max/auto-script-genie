package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.auto.exceldeps.log4j.message.StructuredDataId;
import com.v.item.CheckItem;
import com.v.item.FileItem;
import com.v.item.InputItem;
import com.v.item.ParamNameTextView;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.v.item.SelectItem;
import com.v.item.ValueListItem;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class ExcelReadDialogView extends RelativeLayout implements View.OnClickListener {
    private lt c;
    private Task d;
    private Node e;
    private ValueListItem f;
    private CheckItem g;

    /* renamed from: h, reason: collision with root package name */
    private SelectAndDelayItem f941h;

    /* renamed from: i, reason: collision with root package name */
    private RunConditionItem f942i;

    /* renamed from: j, reason: collision with root package name */
    private SelectItem f943j;

    /* renamed from: k, reason: collision with root package name */
    private FileItem f944k;
    private InputItem t;

    public ExcelReadDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.t, (ViewGroup) this, true);
        this.f944k = (FileItem) findViewById(j.b.e.W3);
        this.f943j = (SelectItem) findViewById(j.b.e.c4);
        this.g = (CheckItem) findViewById(j.b.e.c2);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.f942i = runConditionItem;
        runConditionItem.setAttachView(this);
        findViewById(j.b.e.f1754m).setOnClickListener(this);
        findViewById(j.b.e.B).setOnClickListener(this);
        this.f941h = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.t = (InputItem) findViewById(j.b.e.y2);
        this.f941h.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.e4
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.b();
            }
        });
        this.f941h.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.k4
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.d();
            }
        });
        this.f941h.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.d4
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.f(str, str2);
            }
        });
        ValueListItem valueListItem = (ValueListItem) findViewById(j.b.e.w2);
        this.f = valueListItem;
        valueListItem.setBtnAddName("添加变量名（按Excel列从左到右）");
        this.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.v.i4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.h(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String b() {
        return this.e.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String d() {
        return this.e.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(String str, String str2) {
        Node node = this.e;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(CompoundButton compoundButton, boolean z) {
        this.f.setVisibility(z ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j() {
        this.c.a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(Node node, boolean z, int i2, Object obj, String str) {
        if ("第n行".equals(str)) {
            this.f943j.setSelectSubLabel(node.arg4);
            this.t.setVisibility(8);
            this.f941h.setVisibility(8);
        } else if ("每次递进".equals(str)) {
            this.t.setVisibility(0);
            this.f941h.setVisibility(0);
        } else {
            this.t.setVisibility(8);
            this.f941h.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean n(InputDialogView inputDialogView, String str) {
        inputDialogView.w(str);
        this.f943j.setSelectSubLabel(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(final InputDialogView inputDialogView, View view) {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setInputHint("请输入序号变量");
        paramNameTextView.setInputLabel("请输入序号变量");
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.f4
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.n(inputDialogView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean r(String str) {
        if (str.contains("${") && str.contains("}")) {
            try {
                this.f943j.setSelectSubLabel(str);
                return true;
            } catch (Exception unused) {
                FloatToast.i("请输入数字");
                return false;
            }
        }
        try {
            this.f943j.setSelectSubLabel(Integer.valueOf(str) + "");
            return true;
        } catch (Exception unused2) {
            FloatToast.i("请输入数字");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(Node node, View view) {
        final InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("序号");
        inputDialogView.w(node.arg4);
        inputDialogView.s("请输入序号");
        inputDialogView.y("使用变量", new View.OnClickListener() { // from class: com.v.h4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.p(inputDialogView, view2);
            }
        });
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.g4
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.r(str);
            }
        });
    }

    public LinkedHashMap<String, Object> getNodeListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Long l2 : this.d.getNodeMap().keySet()) {
            Node node = this.d.getNodeMap().get(l2);
            if (node != null) {
                linkedHashMap.put(node.getStepAndName(), l2);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getParamListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        Set<String> set = this.d.params;
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
        if (view.getId() != j.b.e.B) {
            if (view.getId() == j.b.e.f1754m) {
                com.frame.s0.g().o(this);
                return;
            }
            return;
        }
        this.e.url = this.f944k.getValue();
        if (TextUtils.isEmpty(this.e.url)) {
            this.f944k.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        this.e.arg2 = this.t.getValue();
        if (this.g.getValue().booleanValue()) {
            this.e.arg1 = StructuredDataId.RESERVED;
        } else if (this.f.getValue().isEmpty()) {
            this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        } else {
            this.e.arg1 = defpackage.g.a(",", this.f.getValue());
        }
        if (TextUtils.isEmpty(this.e.arg2)) {
            this.f944k.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        if ("第一行".equals(this.f943j.getSelectLabel())) {
            this.e.whatIndex = 1;
        } else if ("最后一行".equals(this.f943j.getSelectLabel())) {
            this.e.whatIndex = -1;
        } else if ("每次递进".equals(this.f943j.getSelectLabel())) {
            this.e.whatIndex = Integer.MIN_VALUE;
        } else if ("第n行".equals(this.f943j.getSelectLabel())) {
            Node node = this.e;
            node.whatIndex = -2;
            node.arg4 = this.f943j.getSelectSubLabel();
        }
        if (this.f941h.getVisibility() == 0) {
            if (!this.f941h.c()) {
                return;
            }
            this.e.errorType = ((Integer) this.f941h.getValue()).intValue();
            if (this.f941h.getSubValue() != null) {
                this.e.errorId = ((Long) this.f941h.getSubValue()).longValue();
            }
        }
        com.frame.s0.g().d(ExcelReadDialogView.class);
        post(new Runnable() { // from class: com.v.j4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.j();
            }
        });
    }

    public void setTaskNode(Task task, final Node node) {
        this.d = task;
        this.e = node;
        this.f942i.setTaskNode(task, node);
        this.f944k.setValue(node.url);
        this.t.setValue(node.arg2);
        if (StructuredDataId.RESERVED.equals(node.arg1)) {
            this.g.setValue(true);
            this.f.setVisibility(8);
        } else {
            this.g.setValue(false);
            this.f.setVisibility(0);
            this.f.setValue(new ArrayList(Arrays.asList(node.arg1.split(","))));
        }
        int i2 = node.whatIndex;
        if (i2 == 1) {
            this.f943j.setSelectLabel("第一行");
            this.f941h.setVisibility(8);
            this.t.setVisibility(8);
        } else if (i2 == -1) {
            this.f943j.setSelectLabel("最后一行");
            this.f941h.setVisibility(8);
            this.t.setVisibility(8);
        } else if (i2 == Integer.MIN_VALUE) {
            this.f943j.setSelectLabel("每次递进");
            this.t.setVisibility(0);
            this.f941h.setVisibility(0);
        } else {
            this.f943j.setSelectLabel("第n行");
            this.t.setVisibility(8);
            this.f941h.setVisibility(8);
            this.f943j.setSelectSubLabel(node.arg4);
        }
        this.f943j.setOnItemClick(new SelectItem.a() { // from class: com.v.l4
            @Override // com.v.item.SelectItem.a
            public final void a(boolean z, int i3, Object obj, String str) {
                this.a.l(node, z, i3, obj, str);
            }
        });
        this.f943j.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.m4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.t(node, view);
            }
        });
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
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("弹窗报错", -2);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.f941h.setItems(linkedHashMap2, linkedHashMap);
        this.f941h.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.f941h;
        selectAndDelayItem.setOnItemClick(new com.v.item.j2(this.d, this.e, selectAndDelayItem));
        this.f941h.setSelectValue(Integer.valueOf(node.errorType));
    }

    public ExcelReadDialogView u(lt ltVar) {
        this.c = ltVar;
        return this;
    }
}

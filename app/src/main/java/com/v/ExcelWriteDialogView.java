package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.v.item.FileItem;
import com.v.item.ParamNameTextView;
import com.v.item.RunConditionItem;
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
public class ExcelWriteDialogView extends RelativeLayout implements View.OnClickListener {
    private lt c;
    private Task d;
    private Node e;
    private ValueListItem f;
    private RunConditionItem g;

    /* renamed from: h, reason: collision with root package name */
    private SelectItem f945h;

    /* renamed from: i, reason: collision with root package name */
    private FileItem f946i;

    public ExcelWriteDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.u, (ViewGroup) this, true);
        this.f946i = (FileItem) findViewById(j.b.e.W3);
        this.f945h = (SelectItem) findViewById(j.b.e.c4);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.g = runConditionItem;
        runConditionItem.setAttachView(this);
        findViewById(j.b.e.f1754m).setOnClickListener(this);
        findViewById(j.b.e.B).setOnClickListener(this);
        ValueListItem valueListItem = (ValueListItem) findViewById(j.b.e.w2);
        this.f = valueListItem;
        valueListItem.setBtnAddName("数据内容（可用变量）");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.c.a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Node node, boolean z, int i2, Object obj, String str) {
        if ("第n行".equals(str)) {
            this.f945h.setSelectSubLabel(node.arg4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean f(InputDialogView inputDialogView, String str) {
        inputDialogView.w(str);
        this.f945h.setSelectSubLabel(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(final InputDialogView inputDialogView, View view) {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setInputHint("请输入序号变量");
        paramNameTextView.setInputLabel("请输入序号变量");
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.q4
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.f(inputDialogView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean j(String str) {
        if (str.contains("${") && str.contains("}")) {
            try {
                this.f945h.setSelectSubLabel(str);
                return true;
            } catch (Exception unused) {
                FloatToast.i("请输入数字");
                return false;
            }
        }
        try {
            this.f945h.setSelectSubLabel(Integer.valueOf(str) + "");
            return true;
        } catch (Exception unused2) {
            FloatToast.i("请输入数字");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(Node node, View view) {
        final InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("序号");
        inputDialogView.w(node.arg4);
        inputDialogView.s("请输入序号");
        inputDialogView.y("使用变量", new View.OnClickListener() { // from class: com.v.s4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.h(inputDialogView, view2);
            }
        });
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.r4
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.j(str);
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

    public ExcelWriteDialogView m(lt ltVar) {
        this.c = ltVar;
        return this;
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
        this.e.url = this.f946i.getValue();
        if (TextUtils.isEmpty(this.e.url)) {
            this.f946i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        if (this.f.getValue().isEmpty()) {
            this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        this.e.arg1 = defpackage.g.a(",", this.f.getValue());
        if ("第一行".equals(this.f945h.getSelectLabel())) {
            this.e.whatIndex = 1;
        } else if ("最后一行".equals(this.f945h.getSelectLabel())) {
            this.e.whatIndex = -1;
        } else if ("第n行".equals(this.f945h.getSelectLabel())) {
            Node node = this.e;
            node.whatIndex = -2;
            node.arg4 = this.f945h.getSelectSubLabel();
            if (TextUtils.isEmpty(this.e.arg4)) {
                this.f945h.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            }
        }
        com.frame.s0.g().d(ExcelWriteDialogView.class);
        post(new Runnable() { // from class: com.v.n4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.b();
            }
        });
    }

    public void setTaskNode(Task task, final Node node) {
        this.d = task;
        this.e = node;
        this.g.setTaskNode(task, node);
        this.f946i.setValue(node.url);
        this.f.setVisibility(0);
        this.f.setValue(new ArrayList(Arrays.asList(node.arg1.split(","))));
        int i2 = node.whatIndex;
        if (i2 == 1) {
            this.f945h.setSelectLabel("第一行");
        } else if (i2 == -1) {
            this.f945h.setSelectLabel("最后一行");
        } else {
            this.f945h.setSelectLabel("第n行");
            this.f945h.setSelectSubLabel(node.arg4);
        }
        this.f945h.setOnItemClick(new SelectItem.a() { // from class: com.v.o4
            @Override // com.v.item.SelectItem.a
            public final void a(boolean z, int i3, Object obj, String str) {
                this.a.d(node, z, i3, obj, str);
            }
        });
        this.f945h.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.p4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.l(node, view);
            }
        });
    }
}

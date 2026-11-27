package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.v.item.FileItem;
import com.v.item.InputItem;
import com.v.item.KeyValueItem;
import com.v.item.ParamLabelItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class TextCaptureDialogView extends RelativeLayout implements View.OnClickListener {
    private lt c;
    private Task d;
    private Node e;
    private KeyValueItem f;
    private ParamLabelItem g;

    /* renamed from: h, reason: collision with root package name */
    private SelectAndDelayItem f1062h;

    /* renamed from: i, reason: collision with root package name */
    private InputItem f1063i;

    /* renamed from: j, reason: collision with root package name */
    private RunConditionItem f1064j;

    /* renamed from: k, reason: collision with root package name */
    private FileItem f1065k;

    public TextCaptureDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.Y, (ViewGroup) this, true);
        this.f1064j = (RunConditionItem) findViewById(j.b.e.h4);
        this.f1065k = (FileItem) findViewById(j.b.e.o2);
        this.f1064j.setAttachView(this);
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        this.f1062h = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.f1063i = (InputItem) findViewById(j.b.e.p4);
        this.f1062h.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.vo
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.b();
            }
        });
        this.f1062h.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.uo
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.d();
            }
        });
        this.f1062h.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.wo
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.f(str, str2);
            }
        });
        this.g = (ParamLabelItem) findViewById(j.b.e.O2);
        KeyValueItem keyValueItem = (KeyValueItem) findViewById(j.b.e.w2);
        this.f = keyValueItem;
        keyValueItem.setBtnAddName("添加表列");
        this.f.post(new Runnable() { // from class: com.v.qo
            @Override // java.lang.Runnable
            public final void run() {
                this.c.l();
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
    public /* synthetic */ void h(Node node) {
        this.f.j(node.arg1);
        com.frame.s0.g().t(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        com.frame.s0.g().j(this);
        PageCaptureTextFloatView pageCaptureTextFloatView = (PageCaptureTextFloatView) com.frame.s0.g().x(PageCaptureTextFloatView.class);
        pageCaptureTextFloatView.d(null);
        pageCaptureTextFloatView.setNodeCallback(new lt() { // from class: com.v.po
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.h(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        this.f.findViewById(j.b.e.T1).setOnClickListener(new View.OnClickListener() { // from class: com.v.ro
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.j(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        this.f1063i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        FloatToast.i("请输入正确的超时时间");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        this.c.a(this.e);
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
    public void onClick(View view) throws NumberFormatException {
        if (view.getId() != j.b.e.g) {
            if (view.getId() == j.b.e.P) {
                com.frame.s0.g().o(this);
                return;
            }
            return;
        }
        this.e.arg3 = this.g.getValue().toString();
        this.e.arg1 = TextUtils.join("&&&", this.f.getValue());
        this.e.arg4 = this.f1065k.getValue();
        try {
            long j2 = Long.parseLong(this.f1063i.getValue());
            if (this.f1062h.getVisibility() == 0) {
                if (!this.f1062h.c()) {
                    return;
                }
                this.e.errorType = ((Integer) this.f1062h.getValue()).intValue();
                if (this.f1062h.getSubValue() != null) {
                    this.e.errorId = ((Long) this.f1062h.getSubValue()).longValue();
                }
            }
            this.e.timeOut = j2;
            com.frame.s0.g().d(TextCaptureDialogView.class);
            post(new Runnable() { // from class: com.v.to
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.p();
                }
            });
        } catch (Exception unused) {
            com.frame.l1.e(new Runnable() { // from class: com.v.so
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.n();
                }
            });
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.d = task;
        this.e = node;
        this.g.setParamKeys(task.params);
        this.f1064j.setTaskNode(task, node);
        this.g.setValue(this.e.arg3);
        this.f1063i.setValue(this.e.timeOut + "");
        this.f.setValue(new ArrayList(Arrays.asList(this.e.arg1.split("&&&"))));
        this.f1065k.setValue(this.e.arg4);
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
        this.f1062h.setItems(linkedHashMap2, linkedHashMap);
        this.f1062h.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.f1062h;
        selectAndDelayItem.setOnItemClick(new com.v.item.j2(this.d, this.e, selectAndDelayItem));
        this.f1062h.setSelectValue(Integer.valueOf(node.errorType));
    }
}

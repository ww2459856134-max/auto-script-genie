package com.v;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.JudgeDialogView;
import com.v.item.AreaChooseItem;
import com.v.item.CalculateItem;
import com.v.item.CheckItem;
import com.v.item.FileItem;
import com.v.item.InputItem;
import com.v.item.InputSelectItem;
import com.v.item.JudgeItem;
import com.v.item.ParamLabelItem;
import com.v.item.ParamNameTextView;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.v.item.SelectItem;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class ParamsInitDialogView extends RelativeLayout implements View.OnClickListener {
    private SelectAndDelayItem A;
    private SelectAndDelayItem C;
    private JudgeItem D;
    private CheckItem G;
    private CalculateItem H;
    private TextView I;
    private SelectItem J;
    private InputSelectItem K;
    private AreaChooseItem M;
    private lt O;
    private DialogInterface.OnCancelListener P;
    private RunConditionItem Q;
    private Task U;
    private Node V;
    private boolean W;
    private SelectItem c;
    private InputItem d;
    private SelectItem e;
    private SelectItem f;
    private InputItem g;

    /* renamed from: h, reason: collision with root package name */
    private InputItem f1031h;

    /* renamed from: i, reason: collision with root package name */
    private FileItem f1032i;

    /* renamed from: j, reason: collision with root package name */
    private SelectItem f1033j;

    /* renamed from: k, reason: collision with root package name */
    private ParamLabelItem f1034k;
    private ParamLabelItem t;

    public ParamsInitDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.S, (ViewGroup) this, true);
        this.t = (ParamLabelItem) findViewById(j.b.e.b3);
        this.M = (AreaChooseItem) findViewById(j.b.e.X1);
        this.G = (CheckItem) findViewById(j.b.e.q1);
        this.I = (TextView) findViewById(j.b.e.l1);
        this.J = (SelectItem) findViewById(j.b.e.u2);
        this.K = (InputSelectItem) findViewById(j.b.e.t2);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.Q = runConditionItem;
        runConditionItem.setAttachView(this);
        this.f = (SelectItem) findViewById(j.b.e.k2);
        this.f1034k = (ParamLabelItem) findViewById(j.b.e.a3);
        SelectItem selectItem = (SelectItem) findViewById(j.b.e.Z2);
        this.f1033j = selectItem;
        selectItem.setOnItemClick(new SelectItem.a() { // from class: com.v.hj
            @Override // com.v.item.SelectItem.a
            public final void a(boolean z, int i2, Object obj, String str) {
                this.a.b(z, i2, obj, str);
            }
        });
        this.f1032i = (FileItem) findViewById(j.b.e.s2);
        this.H = (CalculateItem) findViewById(j.b.e.b2);
        this.D = (JudgeItem) findViewById(j.b.e.G2);
        this.C = (SelectAndDelayItem) findViewById(j.b.e.Y2);
        this.A = (SelectAndDelayItem) findViewById(j.b.e.c3);
        this.c = (SelectItem) findViewById(j.b.e.d3);
        this.d = (InputItem) findViewById(j.b.e.C2);
        this.e = (SelectItem) findViewById(j.b.e.p2);
        this.g = (InputItem) findViewById(j.b.e.q2);
        this.f1031h = (InputItem) findViewById(j.b.e.z2);
        this.c.setOnItemClick(new SelectItem.a() { // from class: com.v.gj
            @Override // com.v.item.SelectItem.a
            public final void a(boolean z, int i2, Object obj, String str) {
                this.a.d(z, i2, obj, str);
            }
        });
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("新建/赋值变量", 1);
        linkedHashMap.put("变量赋值到剪切板", 2);
        linkedHashMap.put("将变量写入文件", 3);
        linkedHashMap.put("变量处理/逻辑运算", 5);
        linkedHashMap.put("变量逻辑判断", 6);
        linkedHashMap.put("变量公式计算器", 7);
        linkedHashMap.put("清空所有变量值", 8);
        linkedHashMap.put("重置某个变量", 9);
        this.f1033j.setItems(linkedHashMap);
        this.D.setOnJudgeChooseListener(new JudgeDialogView.b() { // from class: com.v.ij
            @Override // com.v.JudgeDialogView.b
            public final void a(String str, String str2) {
                this.a.f(str, str2);
            }
        });
        this.H.setOnJudgeChooseListener(new JudgeDialogView.b() { // from class: com.v.cj
            @Override // com.v.JudgeDialogView.b
            public final void a(String str, String str2) {
                ParamsInitDialogView.g(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(boolean z, int i2, Object obj, String str) {
        s(((Integer) obj).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(boolean z, int i2, Object obj, String str) {
        t(((Integer) obj).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(String str, String str2) {
        if (this.W) {
            return;
        }
        this.A.setVisibility(0);
        this.A.setSelectValue(Integer.valueOf(this.V.nextType));
        this.C.setVisibility(0);
        this.C.setSelectValue(Integer.valueOf(this.V.errorType));
    }

    static /* synthetic */ void g(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i() {
        this.O.a(this.V);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(boolean z, int i2, Object obj, String str) {
        this.g.setVisibility(i2 == 0 ? 8 : 0);
        if (this.g.getVisibility() == 0) {
            this.g.setValue(this.V.arg4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view) {
        r(!this.I.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean o(String str) {
        this.c.setSelectSubLabel(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setText(this.V.arg2);
        paramNameTextView.setChooseParamNameType();
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.fj
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.o(str);
            }
        });
    }

    public LinkedHashMap<String, Object> getNodeListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Long l2 : this.U.getNodeMap().keySet()) {
            Node node = this.U.getNodeMap().get(l2);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != j.b.e.g) {
            if (view.getId() == j.b.e.P) {
                com.frame.s0.g().o(this);
                DialogInterface.OnCancelListener onCancelListener = this.P;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(null);
                    return;
                }
                return;
            }
            return;
        }
        Node node = this.V;
        node.type = 24;
        node.what = ((Integer) this.f1033j.getValue()).intValue();
        this.V.text = this.f1034k.getValue().toString();
        int i2 = this.V.what;
        if (i2 != 8 && i2 != 7 && TextUtils.isEmpty(this.f1034k.getValue().toString())) {
            this.f1034k.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        Node node2 = this.V;
        int i3 = node2.what;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 == 5) {
                    node2.arg1 = this.H.getValue().toString();
                    this.V.arg2 = this.H.getSubValue().toString();
                    this.V.arg4 = this.t.getValue();
                    if (TextUtils.isEmpty(this.V.arg4)) {
                        this.t.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    }
                } else if (i3 == 6) {
                    node2.arg1 = this.D.getValue().toString();
                    this.V.arg2 = this.D.getSubValue().toString();
                    if (!this.W && this.A.c() && this.C.c()) {
                        this.V.nextType = ((Integer) this.A.getValue()).intValue();
                        this.V.errorType = ((Integer) this.C.getValue()).intValue();
                        if (this.V.isJumOtherType()) {
                            this.V.nextTaskId = ((Long) this.A.getSubValue()).longValue();
                        } else if (this.V.isHashJumpNodeType()) {
                            this.V.nextTaskId = ((Long) this.A.getSubValue()).longValue();
                        } else {
                            Node node3 = this.V;
                            int i4 = node3.nextType;
                            if (i4 == 16) {
                                node3.arg3 = this.A.getSelectSubLabel();
                            } else if (i4 == 9 || i4 == 11 || i4 == 15) {
                                node3.arg3 = this.A.getSelectSubLabel();
                                this.V.lineNextNodeAtIndex(this.U);
                            } else {
                                node3.lineNextNodeAtIndex(this.U);
                                this.V.arg3 = null;
                            }
                        }
                        if (this.C.getSubValue() != null) {
                            this.V.errorId = ((Long) this.C.getSubValue()).longValue();
                        }
                    }
                } else if (i3 == 7) {
                    node2.arg4 = this.t.getValue();
                    this.V.arg3 = this.f1031h.getValue();
                    if (TextUtils.isEmpty(this.V.arg4)) {
                        this.t.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    } else if (TextUtils.isEmpty(this.V.arg3)) {
                        this.t.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    }
                }
            } else if (TextUtils.isEmpty(this.f1032i.getValue())) {
                FloatToast.i("请输入路文件路径");
                this.f1032i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            } else {
                this.V.arg2 = this.f1032i.getValue();
                this.V.arg3 = this.e.getSelectLabel();
                this.V.arg4 = this.g.getValue();
            }
        } else {
            if (this.c.getValue() == null) {
                this.c.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            int iIntValue = ((Integer) this.c.getValue()).intValue();
            this.V.arg1 = String.valueOf(iIntValue);
            if (iIntValue == 0) {
                this.V.arg2 = this.d.getValue().toString();
            } else if (iIntValue == 1) {
                this.V.arg2 = null;
            } else if (iIntValue == 2) {
                this.V.arg2 = this.f1032i.getValue();
                this.V.arg5 = this.K.getValue();
                this.V.arg6 = this.G.getValue().booleanValue() ? "1" : null;
                this.V.arg4 = this.J.getSelectLabel();
                if (!TextUtils.isEmpty(this.V.arg4) && TextUtils.isEmpty(this.V.arg5)) {
                    this.K.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    return;
                }
            } else if (iIntValue == 3) {
                this.V.arg2 = this.c.getSelectSubLabel();
            } else if (iIntValue == 4) {
                this.V.arg2 = this.f1032i.getValue();
            } else if (iIntValue == 5) {
                this.M.u(this.V);
            } else if (iIntValue == 6) {
                this.V.arg2 = this.f.getSelectLabel();
            } else if (iIntValue == 7) {
                this.V.arg2 = this.f1032i.getValue();
            }
        }
        Node node4 = this.V;
        int i5 = node4.what;
        if (i5 != 8 && i5 != 7 && TextUtils.isEmpty(node4.text)) {
            FloatToast.g(j.b.d.c0, "请输入/选择变量名称");
            this.f1034k.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        Node node5 = this.V;
        if (node5.what != 6) {
            node5.nextType = 2;
            node5.errorType = 2;
            node5.nextTaskId = 0L;
            node5.nextTaskNodeId = 0L;
            node5.errorId = 0L;
            node5.successJumpBack = true;
            node5.jumpBack = true;
            node5.nextDelay = null;
            node5.nextMaxDelay = null;
            node5.errorDelay = null;
            node5.errorMaxDelay = null;
        }
        com.frame.s0.g().d(ParamsInitDialogView.class);
        post(new Runnable() { // from class: com.v.jj
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i();
            }
        });
    }

    public void r(boolean z) {
        this.I.setSelected(z);
        if (z) {
            this.J.setVisibility(0);
            this.K.setVisibility(0);
            this.K.f(this.V.arg5);
            this.J.setSelectLabel(this.V.arg4);
            return;
        }
        Node node = this.V;
        node.arg3 = null;
        node.arg4 = null;
        node.arg5 = null;
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.J.setSelectValue(null);
        this.K.f(null);
    }

    public void s(int i2) {
        this.D.setVisibility(8);
        this.A.setVisibility(8);
        this.C.setVisibility(8);
        this.f1031h.setVisibility(8);
        this.f1032i.setVisibility(8);
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        this.D.setVisibility(8);
        this.H.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.t.setVisibility(8);
        this.f1034k.setVisibility(0);
        this.f1034k.setValue(this.V.text);
        if (i2 == 1) {
            this.c.setVisibility(0);
            if (TextUtils.isEmpty(this.V.arg1)) {
                return;
            }
            try {
                this.c.setSelectValue(Integer.valueOf(Integer.parseInt(this.V.arg1)));
                return;
            } catch (Exception unused) {
                this.c.setSelectValue(null);
            }
        }
        if (i2 == 3) {
            this.f1032i.setVisibility(0);
            this.f1032i.setValue(this.V.arg2);
            this.e.setVisibility(0);
            this.e.setOnItemClick(new SelectItem.a() { // from class: com.v.dj
                @Override // com.v.item.SelectItem.a
                public final void a(boolean z, int i3, Object obj, String str) {
                    this.a.k(z, i3, obj, str);
                }
            });
            this.e.setSelectLabel(this.V.arg3);
            return;
        }
        switch (i2) {
            case 5:
                this.H.setVisibility(0);
                this.t.setVisibility(0);
                CalculateItem calculateItem = this.H;
                Node node = this.V;
                calculateItem.setValue(node.arg1, node.arg2);
                this.t.setValue(this.V.arg4);
                break;
            case 6:
                this.D.setVisibility(0);
                JudgeItem judgeItem = this.D;
                Node node2 = this.V;
                judgeItem.setValue(node2.arg1, node2.arg2);
                break;
            case 7:
                this.f1034k.setVisibility(8);
                this.t.setValue(this.V.arg4);
                this.f1031h.setValue(this.V.arg3);
                this.f1031h.setVisibility(0);
                this.t.setVisibility(0);
                break;
            case 8:
                this.f1034k.setVisibility(8);
                break;
            case 9:
                this.f1034k.setVisibility(0);
                break;
        }
    }

    public void setMiniModel() {
        this.W = true;
        this.f1033j.setSelectLabel("变量逻辑判断");
        this.A.setVisibility(8);
        this.C.setVisibility(8);
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.P = onCancelListener;
    }

    public void setTaskNode(Task task, Node node) {
        this.U = task;
        this.V = node;
        this.Q.setTaskNode(task, node);
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("跳转节点", null);
        linkedHashMap.put("跳转任务", null);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.A.setItems(linkedHashMap2, linkedHashMap);
        this.A.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.A;
        selectAndDelayItem.setOnItemClick(new com.v.item.k2(this.U, this.V, selectAndDelayItem, null));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("跳转节点", 3);
        linkedHashMap3.put("跳转任务", 4);
        linkedHashMap3.put("结束任务", -3);
        linkedHashMap3.put("结束子任务/循环", -4);
        linkedHashMap3.put("跳转下一个节点", 2);
        this.C.setItems(linkedHashMap3, linkedHashMap);
        this.C.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem2 = this.C;
        selectAndDelayItem2.setOnItemClick(new com.v.item.j2(this.U, this.V, selectAndDelayItem2));
        this.f1034k.setParamKeys(this.U.params);
        this.t.setParamKeys(this.U.params);
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        Set<String> set = task.params;
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                linkedHashMap4.put(it.next(), 0);
            }
        }
        LinkedHashMap<String, LinkedHashMap> linkedHashMap5 = new LinkedHashMap<>();
        linkedHashMap5.put("从变量取值", linkedHashMap4);
        this.c.setSubItems(linkedHashMap5);
        this.c.setSubHint("选择变量");
        this.f1033j.setSelectValue(Integer.valueOf(node.what));
    }

    public void t(int i2) {
        this.f1032i.setVisibility(8);
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.M.setVisibility(8);
        this.G.setVisibility(8);
        if (i2 == 0) {
            this.d.setVisibility(0);
            this.d.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            this.d.setValue(this.V.arg2);
            return;
        }
        this.d.setVisibility(8);
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.v.kj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m(view);
            }
        });
        if (i2 == 2) {
            this.f1032i.setVisibility(0);
            this.I.setVisibility(0);
            this.G.setVisibility(0);
            this.f1032i.setValue(this.V.arg2);
            r(!TextUtils.isEmpty(this.V.arg5));
            this.G.setValue("1".equals(this.V.arg6));
            return;
        }
        if (i2 == 3) {
            this.c.setSelectSubLabel(this.V.arg2);
            this.c.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.ej
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.q(view);
                }
            });
            return;
        }
        if (i2 == 4) {
            this.f1032i.setVisibility(0);
            this.f1032i.setValue(this.V.arg2);
            return;
        }
        if (i2 == 5) {
            this.M.setVisibility(0);
            this.M.setValue(this.V.getArea(), this.V.areaParam);
        } else if (i2 == 6) {
            this.f.setVisibility(0);
            this.f.setSelectLabel(this.V.arg2);
        } else if (i2 == 7) {
            this.f1032i.setVisibility(0);
            this.f1032i.setValue(this.V.arg2);
        }
    }

    public ParamsInitDialogView u(lt ltVar) {
        this.O = ltVar;
        return this;
    }
}

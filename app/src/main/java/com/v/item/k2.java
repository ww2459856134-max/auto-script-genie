package com.v.item;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.v.FloatToast;
import com.v.SearchNodeView;
import com.v.TaskChooseDialogView1;
import com.v.item.SelectAndDelayItem;
import com.v.lt;
import com.v.ot;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import i.b.da;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class k2 implements SelectAndDelayItem.c {
    private SelectAndDelayItem a;
    private Task b;
    private Node c;
    private OffersetChooseItem d;

    public k2(Task task, Node node, SelectAndDelayItem selectAndDelayItem, OffersetChooseItem offersetChooseItem) {
        this.a = selectAndDelayItem;
        this.b = task;
        this.c = node;
        this.d = offersetChooseItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Node node) {
        this.a.setSelectSubValue(Long.valueOf(node.id));
        this.a.setSelectSubLabel(node.getStepAndName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        w(new ArrayList(this.b.getNodeMap().values()), -1, new lt() { // from class: com.v.item.l0
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.c(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean g(String str) {
        this.a.setSelectSubLabel(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(View view) {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setText(this.a.getSelectSubLabel());
        paramNameTextView.setChooseParamNameType();
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.item.p0
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.g(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(boolean z, TaskSimple taskSimple) {
        this.c.successJumpBack = z;
        this.a.setSelectSubValue(Long.valueOf(taskSimple.getId()));
        this.a.setSelectSubLabel(taskSimple.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view) {
        x(this.a.getSubValue() != null ? da.B().w(((Long) this.a.getSubValue()).longValue()) : null, this.c.successJumpBack, new ot() { // from class: com.v.item.i0
            @Override // com.v.ot
            public final void a(boolean z, TaskSimple taskSimple) {
                this.a.k(z, taskSimple);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean o(String str) {
        try {
            this.a.setSelectSubLabel(Integer.valueOf(str) + "");
            return true;
        } catch (Exception unused) {
            FloatToast.i("请输入整数");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.u(2);
        inputDialogView.l("连续点击次数");
        inputDialogView.s("请输入连续点击次数");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.item.m0
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.o(str);
            }
        });
    }

    static /* synthetic */ void s(View view) {
        com.frame.n0.g("tscpr", false);
        com.frame.s0.g().d(DingMsgView.class);
    }

    static /* synthetic */ void u(View view) {
        com.frame.n0.g("tsapr", false);
        com.frame.s0.g().d(DingMsgView.class);
    }

    @Override // com.v.item.SelectAndDelayItem.c
    public void a(boolean z, int i2, Object obj, String str) {
        if (this.d != null) {
            if (obj.equals(13) || obj.equals(12) || obj.equals(7) || obj.equals(0) || obj.equals(5) || obj.equals(16)) {
                this.d.setVisibility(0);
            } else {
                this.d.setValue(this.c.getSrcRect(), null);
                this.d.setVisibility(8);
            }
        }
        this.a.setOnSubClickListener(null);
        Integer num = (Integer) obj;
        if (this.c.isJumOtherType(num.intValue())) {
            this.a.setSelectSubValue(Long.valueOf(this.c.nextTaskId));
            if (this.c.isHashJumpNodeType(num.intValue())) {
                try {
                    this.a.setSelectSubLabel(this.b.getNodeMap().get(Long.valueOf(this.c.nextTaskId)).getStepAndName());
                } catch (Exception unused) {
                    this.a.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                }
                this.a.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.item.o0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.e(view);
                    }
                });
                return;
            }
            if (this.c.isHashJumpTaskType(num.intValue())) {
                try {
                    this.a.setSelectSubLabel(da.B().L(this.c.nextTaskId).getName());
                } catch (Exception unused2) {
                    this.a.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                }
                this.a.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.item.n0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.m(view);
                    }
                });
                return;
            }
            return;
        }
        if (obj.equals(16)) {
            this.a.setSelectSubLabel(this.c.arg3);
            this.a.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.item.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.q(view);
                }
            });
            return;
        }
        if (obj.equals(9) || obj.equals(11) || obj.equals(17) || obj.equals(15)) {
            if (z) {
                if (obj.equals(11) && com.frame.n0.a("tscpr", true)) {
                    DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                    dingMsgView.h("将识别匹配到的中心点坐标写入到变量中，坐标的格式是：<font color='#55CA9B'>x,y</font>  例如<font color='#F45075'><strong>100,153</strong></font> ，如果是识别到多个坐标是用|符号隔开<font color='#55CA9B'>x,y|x1,y1|x2,y2</font>例如<font color='#F45075'><strong>100,153|123,324|123,452</strong></font> ，当要使用多个坐标时可以先用变量操作分割提取使用。");
                    dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.item.s0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            com.frame.s0.g().d(DingMsgView.class);
                        }
                    });
                    dingMsgView.i("不再提醒", new View.OnClickListener() { // from class: com.v.item.j0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            k2.s(view);
                        }
                    });
                    dingMsgView.l("温馨提示");
                } else if (obj.equals(17) && com.frame.n0.a("tsapr", true)) {
                    DingMsgView dingMsgView2 = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                    dingMsgView2.h("将识别匹配到的区域坐标写入到变量中，坐标的格式是：<font color='#55CA9B'>x1,y1-x2,y2</font>   例如 <font color='#F45075'><strong>100,153-144,299</strong></font> ，如果是识别到多个区域是用|符号隔开<font color='#55CA9B'>x1,y1-x2,y2|x3,y3-x4,y4|x5,y5-x6,y6</font>  例如 <font color='#F45075'><strong>100,153-144,299|100,133-144,299|120,143-144,299</strong></font> ，当要使用多个区域坐标时可以先用变量操作分割提取使用。");
                    dingMsgView2.k("知道了", new View.OnClickListener() { // from class: com.v.item.t0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            com.frame.s0.g().d(DingMsgView.class);
                        }
                    });
                    dingMsgView2.i("不再提醒", new View.OnClickListener() { // from class: com.v.item.r0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            k2.u(view);
                        }
                    });
                    dingMsgView2.l("温馨提示");
                }
            }
            this.a.setSelectSubLabel(this.c.arg3);
            this.a.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.item.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.i(view);
                }
            });
        }
    }

    public void w(List<Node> list, int i2, lt ltVar) {
        ((SearchNodeView) com.frame.s0.g().B(SearchNodeView.class)).set(list, i2, ltVar);
    }

    public void x(TaskSimple taskSimple, boolean z, final ot otVar) {
        TaskChooseDialogView1.v(new TaskChooseDialogView1.b() { // from class: com.v.item.q0
            @Override // com.v.TaskChooseDialogView1.b
            public final void a(boolean z2, TaskSimple taskSimple2) {
                otVar.a(z2, taskSimple2);
            }
        }).setDefaultValue(z, taskSimple);
    }
}

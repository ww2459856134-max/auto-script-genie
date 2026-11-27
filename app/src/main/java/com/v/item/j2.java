package com.v.item;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.v.SearchNodeView;
import com.v.TaskChooseDialogView1;
import com.v.item.SelectAndDelayItem;
import com.v.lt;
import com.v.ot;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import i.b.da;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class j2 implements SelectAndDelayItem.c {
    private SelectAndDelayItem a;
    private Task b;
    private Node c;

    public j2(Task task, Node node, SelectAndDelayItem selectAndDelayItem) {
        this.a = selectAndDelayItem;
        this.b = task;
        this.c = node;
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
        k(new ArrayList(this.b.getNodeMap().values()), -1, new lt() { // from class: com.v.item.d0
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.c(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(boolean z, TaskSimple taskSimple) {
        this.c.jumpBack = z;
        this.a.setSelectSubValue(Long.valueOf(taskSimple.getId()));
        this.a.setSelectSubLabel(taskSimple.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(View view) {
        l(this.a.getSubValue() != null ? da.B().w(((Long) this.a.getSubValue()).longValue()) : null, this.c.jumpBack, new ot() { // from class: com.v.item.e0
            @Override // com.v.ot
            public final void a(boolean z, TaskSimple taskSimple) {
                this.a.g(z, taskSimple);
            }
        });
    }

    @Override // com.v.item.SelectAndDelayItem.c
    public void a(boolean z, int i2, Object obj, String str) {
        this.a.setOnSubClickListener(null);
        SelectAndDelayItem.c cVar = this.a.f1098i;
        if (cVar != null) {
            cVar.a(true, i2, obj, str);
        }
        Integer num = (Integer) obj;
        if (this.c.isJumOtherType(num.intValue())) {
            this.a.setSelectSubValue(Long.valueOf(this.c.errorId));
            if (this.c.isHashJumpNodeType(num.intValue())) {
                try {
                    this.a.setSelectSubLabel(this.b.getNodeMap().get(Long.valueOf(this.c.errorId)).getStepAndName());
                } catch (Exception unused) {
                    this.a.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                }
                this.a.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.item.h0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.e(view);
                    }
                });
            } else if (this.c.isHashJumpTaskType(num.intValue())) {
                try {
                    this.a.setSelectSubLabel(da.B().L(this.c.errorId).getName());
                } catch (Exception unused2) {
                    this.a.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                }
                this.a.setOnSubClickListener(new View.OnClickListener() { // from class: com.v.item.f0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.i(view);
                    }
                });
            }
        }
    }

    public void k(List<Node> list, int i2, lt ltVar) {
        ((SearchNodeView) com.frame.s0.g().B(SearchNodeView.class)).set(list, i2, ltVar);
    }

    public void l(TaskSimple taskSimple, boolean z, final ot otVar) {
        TaskChooseDialogView1.v(new TaskChooseDialogView1.b() { // from class: com.v.item.g0
            @Override // com.v.TaskChooseDialogView1.b
            public final void a(boolean z2, TaskSimple taskSimple2) {
                otVar.a(z2, taskSimple2);
            }
        }).setDefaultValue(z, taskSimple);
    }
}

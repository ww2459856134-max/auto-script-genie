package com.v;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.v.item.InputItem;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;

/* loaded from: classes.dex */
public class RunCountSetDialogView extends DingMsgView {

    /* renamed from: h, reason: collision with root package name */
    private InputItem f1049h;

    /* renamed from: i, reason: collision with root package name */
    private InputItem f1050i;

    /* renamed from: j, reason: collision with root package name */
    private Node f1051j;

    /* renamed from: k, reason: collision with root package name */
    private lt f1052k;

    public RunCountSetDialogView() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.U, null);
        this.f1049h = (InputItem) viewInflate.findViewById(j.b.e.C1);
        this.f1050i = (InputItem) viewInflate.findViewById(j.b.e.D1);
        m(viewInflate);
        l("设置延迟时间");
        this.f1049h.setInputType(2);
        this.f1049h.setHint("次数");
        this.f1050i.setInputType(2);
        this.f1050i.setHint("延迟");
        k("确定", new View.OnClickListener() { // from class: com.v.el
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.p(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.v.fl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(View view) throws NumberFormatException {
        try {
            long j2 = Long.parseLong(this.f1049h.getValue());
            try {
                this.f1051j.setCheckDelay(Long.valueOf(Long.parseLong(this.f1050i.getValue())));
                this.f1051j.setCheckCount(Long.valueOf(j2));
                this.f1052k.a(this.f1051j);
                com.frame.s0.g().o(this);
            } catch (Exception e) {
                this.f1050i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入整数（毫秒）");
                com.frame.k0.r(e);
            }
        } catch (Exception e2) {
            this.f1049h.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入整数（次数）");
            com.frame.k0.r(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        com.frame.s0.g().o(this);
    }

    public void setNode(Node node) {
        this.f1051j = node;
        this.f1049h.setValue("" + node.getCheckCount());
        this.f1050i.setValue("" + node.getCheckDelay());
    }

    public void setNodeCallback(lt ltVar) {
        this.f1052k = ltVar;
    }
}

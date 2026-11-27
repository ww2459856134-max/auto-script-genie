package com.v;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class DelaySetNodeDialogView extends DingMsgView {
    private SelectAndDelayItem.b A;
    private RunConditionItem C;
    private Node D;
    private lt G;

    /* renamed from: h, reason: collision with root package name */
    private EditText f933h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f934i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f935j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f936k;
    private View t;

    public DelaySetNodeDialogView() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.r, null);
        this.f933h = (EditText) viewInflate.findViewById(j.b.e.D1);
        this.f934i = (EditText) viewInflate.findViewById(j.b.e.E1);
        this.t = viewInflate.findViewById(j.b.e.A4);
        this.f935j = (TextView) viewInflate.findViewById(j.b.e.F);
        this.f936k = (TextView) viewInflate.findViewById(j.b.e.s6);
        this.f935j.setOnClickListener(new View.OnClickListener() { // from class: com.v.t3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q(view);
            }
        });
        m(viewInflate);
        l("设置延迟时间");
        this.f933h.setInputType(1);
        this.f933h.setHint("毫秒或${变量}");
        this.f934i.setInputType(1);
        this.f934i.setHint("随机最大值");
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.C = runConditionItem;
        runConditionItem.setAttachView(this);
        k("确定", new View.OnClickListener() { // from class: com.v.s3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.s(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.v.u3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) {
        this.f935j.setSelected(!r2.isSelected());
        o(this.f935j.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) throws NumberFormatException {
        String strTrim;
        com.frame.s0.g().o(this);
        String strTrim2 = this.f933h.getText().toString().trim();
        if (strTrim2.isEmpty()) {
            this.f933h.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入延迟时间或变量");
            return;
        }
        if (this.f935j.isSelected()) {
            strTrim = this.f934i.getText().toString().trim();
            if (strTrim.isEmpty()) {
                this.f934i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入随机最大值或变量");
                return;
            } else if (i.b.o8.a(strTrim2, strTrim)) {
                if (Long.parseLong(strTrim) < Long.parseLong(strTrim2)) {
                    this.f934i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    FloatToast.i("最大值必须大于最小值");
                    return;
                }
            }
        } else {
            strTrim = "0";
        }
        SelectAndDelayItem.b bVar = this.A;
        if (bVar != null) {
            bVar.a(strTrim2, strTrim);
        }
        Node node = this.D;
        node.delay = strTrim2;
        node.maxDelay = strTrim;
        lt ltVar = this.G;
        if (ltVar != null) {
            ltVar.a(node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(View view) {
        com.frame.s0.g().o(this);
    }

    public void o(boolean z) {
        this.t.setVisibility(z ? 0 : 8);
        this.f933h.setHint(z ? "随机最小值/变量" : "毫秒或${变量}");
        this.f936k.setVisibility(z ? 0 : 8);
    }

    public void setDefaultValue(String str, String str2) {
        if (!i.b.o8.d(str, str2)) {
            o(false);
            this.f935j.setSelected(false);
            this.f933h.setText(i.b.o8.g(str));
        } else {
            o(true);
            this.f933h.setText(i.b.o8.g(str));
            this.f934i.setText(i.b.o8.g(str2));
            this.f935j.setSelected(true);
        }
    }

    public void setISetDelay(SelectAndDelayItem.b bVar) {
        this.A = bVar;
    }

    public DelaySetNodeDialogView v(lt ltVar) {
        this.G = ltVar;
        return this;
    }

    public DelaySetNodeDialogView w(Task task, Node node) {
        this.D = node;
        this.C.setTaskNode(task, node);
        setDefaultValue(node.delay, node.maxDelay);
        return this;
    }
}

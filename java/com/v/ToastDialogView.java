package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.v.item.InputItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class ToastDialogView extends RelativeLayout implements View.OnClickListener {
    private lt c;
    private Node d;
    private InputItem e;
    private SelectItem f;
    private RunConditionItem g;

    public ToastDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.c0, (ViewGroup) this, true);
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        this.e = (InputItem) findViewById(j.b.e.A2);
        this.f = (SelectItem) findViewById(j.b.e.k3);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.g = runConditionItem;
        runConditionItem.setAttachView(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.c.a(this.d);
    }

    public ToastDialogView c(lt ltVar) {
        this.c = ltVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != j.b.e.g) {
            if (view.getId() == j.b.e.P) {
                com.frame.s0.g().o(this);
            }
        } else {
            if (TextUtils.isEmpty(this.e.getValue())) {
                this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            this.d.text = this.e.getValue();
            Object value = this.f.getValue();
            this.d.argInt1 = value instanceof Number ? ((Number) value).intValue() : 0;
            com.frame.s0.g().d(ToastDialogView.class);
            post(new Runnable() { // from class: com.v.kq
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.b();
                }
            });
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.d = node;
        this.e.setValue(node.text);
        this.f.setSelectValue(Integer.valueOf(node.argInt1));
        this.g.setTaskNode(task, node);
    }
}

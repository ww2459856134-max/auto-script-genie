package com.v;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;

/* loaded from: classes.dex */
public class NodeRepeatCountDialogView extends DingMsgView {

    /* renamed from: h, reason: collision with root package name */
    private EditText f1012h;

    /* renamed from: i, reason: collision with root package name */
    private a f1013i;

    /* renamed from: j, reason: collision with root package name */
    private Node f1014j;

    /* renamed from: k, reason: collision with root package name */
    private View f1015k;

    public interface a {
        void a(String str);
    }

    public NodeRepeatCountDialogView() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.J, null);
        this.f1012h = (EditText) viewInflate.findViewById(j.b.e.C1);
        viewInflate.findViewById(j.b.e.D4).setVisibility(8);
        viewInflate.findViewById(j.b.e.F4).setVisibility(8);
        View viewFindViewById = viewInflate.findViewById(j.b.e.s3);
        this.f1015k = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.v.dh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.p(view);
            }
        });
        a(viewInflate);
        l("节点循环设置");
        this.f1012h.setInputType(2);
        this.f1012h.setHint("循环次数");
        k("确定", new View.OnClickListener() { // from class: com.v.ch
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.v.eh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.t(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(View view) {
        view.setSelected(!view.isSelected());
        findViewById(j.b.e.J4).setVisibility(!view.isSelected() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        com.frame.s0.g().o(this);
        if (this.f1015k.isSelected()) {
            this.f1014j.repeatCount = -1;
        } else {
            try {
                this.f1014j.repeatCount = Integer.parseInt(this.f1012h.getText().toString());
            } catch (Exception e) {
                this.f1012h.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入整数（次数）");
                com.frame.k0.r(e);
                return;
            }
        }
        a aVar = this.f1013i;
        if (aVar != null) {
            aVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(View view) {
        com.frame.s0.g().o(this);
    }

    public void setNode(Node node) {
        this.f1014j = node;
        int i2 = node.repeatCount;
        if (i2 == -1) {
            this.f1015k.setSelected(true);
            findViewById(j.b.e.J4).setVisibility(!this.f1015k.isSelected() ? 0 : 8);
        } else if (i2 != 0) {
            this.f1012h.setText(String.valueOf(i2));
        }
    }

    public NodeRepeatCountDialogView u(a aVar) {
        this.f1013i = aVar;
        return this;
    }
}

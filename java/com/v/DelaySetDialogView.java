package com.v;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.v.item.SelectAndDelayItem;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import java.util.Collection;

/* loaded from: classes.dex */
public class DelaySetDialogView extends DingMsgView {
    private View A;
    private Collection<Node> C;
    private SelectAndDelayItem.b D;

    /* renamed from: h, reason: collision with root package name */
    private EditText f929h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f930i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f931j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f932k;
    private a t;

    public interface a {
        void a(String str);
    }

    public DelaySetDialogView() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.q, null);
        this.f929h = (EditText) viewInflate.findViewById(j.b.e.D1);
        this.f930i = (EditText) viewInflate.findViewById(j.b.e.E1);
        this.A = viewInflate.findViewById(j.b.e.A4);
        this.f931j = (TextView) viewInflate.findViewById(j.b.e.F);
        this.f932k = (TextView) viewInflate.findViewById(j.b.e.s6);
        this.f931j.setOnClickListener(new View.OnClickListener() { // from class: com.v.p3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q(view);
            }
        });
        m(viewInflate);
        l("设置延迟时间");
        this.f929h.setInputType(1);
        this.f929h.setHint("毫秒或${变量}");
        this.f930i.setInputType(1);
        this.f930i.setHint("随机最大值");
        k("确定", new View.OnClickListener() { // from class: com.v.q3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.s(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.v.r3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) {
        this.f931j.setSelected(!r2.isSelected());
        o(this.f931j.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) throws NumberFormatException {
        String strTrim;
        com.frame.s0.g().o(this);
        String strTrim2 = this.f929h.getText().toString().trim();
        if (strTrim2.isEmpty()) {
            this.f929h.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入延迟时间或变量");
            return;
        }
        if (this.f931j.isSelected()) {
            strTrim = this.f930i.getText().toString().trim();
            if (strTrim.isEmpty()) {
                this.f930i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入随机最大值或变量");
                return;
            } else if (i.b.o8.a(strTrim2, strTrim)) {
                if (Long.parseLong(strTrim) < Long.parseLong(strTrim2)) {
                    this.f930i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    FloatToast.i("最大值必须大于最小值");
                    return;
                }
            }
        } else {
            strTrim = "0";
        }
        SelectAndDelayItem.b bVar = this.D;
        if (bVar != null) {
            bVar.a(strTrim2, strTrim);
        }
        Collection<Node> collection = this.C;
        if (collection != null) {
            for (Node node : collection) {
                node.delay = strTrim2;
                node.maxDelay = strTrim;
            }
        }
        a aVar = this.t;
        if (aVar != null) {
            aVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(View view) {
        com.frame.s0.g().o(this);
    }

    public void o(boolean z) {
        this.A.setVisibility(z ? 0 : 8);
        this.f929h.setHint(z ? "随机最小值/变量" : "毫秒或${变量}");
        this.f932k.setVisibility(z ? 0 : 8);
    }

    public void setDefaultValue(String str, String str2) {
        if (!i.b.o8.d(str, str2)) {
            o(false);
            this.f931j.setSelected(false);
            this.f929h.setText(i.b.o8.g(str));
        } else {
            o(true);
            this.f929h.setText(i.b.o8.g(str));
            this.f930i.setText(i.b.o8.g(str2));
            this.f931j.setSelected(true);
        }
    }

    public void setISetDelay(SelectAndDelayItem.b bVar) {
        this.D = bVar;
    }

    public void setNodeList(Collection<Node> collection) {
        this.C = collection;
        if (collection.size() == 1) {
            Node next = collection.iterator().next();
            setDefaultValue(next.delay, next.maxDelay);
        }
    }

    public DelaySetDialogView v(a aVar) {
        this.t = aVar;
        return this;
    }
}

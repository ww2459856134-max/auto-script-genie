package com.v;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import java.util.Collection;

/* loaded from: classes.dex */
public class DurationSetDialogView extends DingMsgView {
    private View A;
    private Collection<Node> C;
    private a D;

    /* renamed from: h, reason: collision with root package name */
    private EditText f937h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f938i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f939j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f940k;
    private b t;

    public interface a {
        void a(long j2, long j3);
    }

    public interface b {
        void a(String str);
    }

    public DurationSetDialogView() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.q, null);
        this.f937h = (EditText) viewInflate.findViewById(j.b.e.D1);
        this.f938i = (EditText) viewInflate.findViewById(j.b.e.E1);
        this.A = viewInflate.findViewById(j.b.e.A4);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.F);
        this.f939j = textView;
        textView.setText("使用随机时长时间");
        this.f940k = (TextView) viewInflate.findViewById(j.b.e.s6);
        this.f939j.setOnClickListener(new View.OnClickListener() { // from class: com.v.v3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q(view);
            }
        });
        m(viewInflate);
        l("设置点击耗时");
        this.f937h.setInputType(2);
        this.f937h.setHint("随机最小值");
        this.f938i.setInputType(2);
        this.f938i.setHint("随机最大值");
        k("确定", new View.OnClickListener() { // from class: com.v.x3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.s(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.v.w3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) {
        this.f939j.setSelected(!r2.isSelected());
        o(this.f939j.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) throws NumberFormatException {
        com.frame.s0.g().o(this);
        try {
            int i2 = Integer.parseInt(this.f937h.getText().toString());
            if (this.f939j.isSelected()) {
                try {
                    int i3 = Integer.parseInt(this.f938i.getText().toString());
                    if (i3 < i2) {
                        this.f938i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        FloatToast.i("最大值必须大于最小值");
                        return;
                    }
                    a aVar = this.D;
                    if (aVar != null) {
                        aVar.a(i2, i3);
                    }
                    Collection<Node> collection = this.C;
                    if (collection != null) {
                        for (Node node : collection) {
                            node.duration = i2;
                            node.maxDuration = i3;
                        }
                    }
                } catch (Exception e) {
                    this.f938i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    FloatToast.i("请输入整数（毫秒）");
                    com.frame.k0.r(e);
                    return;
                }
            } else {
                a aVar2 = this.D;
                if (aVar2 != null) {
                    aVar2.a(i2, 0);
                }
                Collection<Node> collection2 = this.C;
                if (collection2 != null) {
                    for (Node node2 : collection2) {
                        node2.duration = i2;
                        node2.maxDuration = 0L;
                    }
                }
            }
            b bVar = this.t;
            if (bVar != null) {
                bVar.a(null);
            }
        } catch (Exception e2) {
            this.f937h.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入整数（次数）");
            com.frame.k0.r(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(View view) {
        com.frame.s0.g().o(this);
    }

    public a getSetDuration() {
        return this.D;
    }

    public void o(boolean z) {
        this.A.setVisibility(z ? 0 : 8);
        this.f937h.setHint(z ? "随机最小值" : "请输入延迟时间");
        this.f940k.setVisibility(z ? 0 : 8);
    }

    public void setDefaultValue(long j2, long j3) {
        if (j3 == 0) {
            o(false);
            this.f939j.setSelected(false);
            this.f937h.setText("" + j2);
            return;
        }
        o(true);
        this.f937h.setText("" + j2);
        this.f938i.setText("" + j3);
        this.f939j.setSelected(true);
    }

    public void setNodeList(Collection<Node> collection) {
        this.C = collection;
        if (collection.size() == 1) {
            Node next = collection.iterator().next();
            if (next.maxDuration == 0) {
                o(false);
                this.f939j.setSelected(false);
                this.f937h.setText("" + next.duration);
                return;
            }
            o(true);
            this.f937h.setText("" + next.duration);
            this.f938i.setText("" + next.maxDuration);
            this.f939j.setSelected(true);
        }
    }

    public void setSetDuration(a aVar) {
        this.D = aVar;
    }

    public DurationSetDialogView v(b bVar) {
        this.t = bVar;
        return this;
    }
}

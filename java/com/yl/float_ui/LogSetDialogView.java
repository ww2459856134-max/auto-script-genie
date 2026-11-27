package com.yl.float_ui;

import android.view.View;
import android.widget.EditText;
import com.frame.n0;
import com.frame.s0;
import com.frame.v0;
import com.frame.y0;

/* loaded from: classes.dex */
public class LogSetDialogView extends DingMsgView {

    /* renamed from: h, reason: collision with root package name */
    private EditText f1114h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f1115i;

    /* renamed from: j, reason: collision with root package name */
    private EditText f1116j;

    /* renamed from: k, reason: collision with root package name */
    private a f1117k;

    public interface a {
        void a(String str);
    }

    public LogSetDialogView() {
        View viewInflate = View.inflate(v0.g(), k0.b, null);
        this.f1114h = (EditText) viewInflate.findViewById(j0.f1125k);
        this.f1115i = (EditText) viewInflate.findViewById(j0.f1127m);
        this.f1116j = (EditText) viewInflate.findViewById(j0.f1126l);
        this.f1115i.setText(n0.c("lgoTs", 7) + "");
        this.f1114h.setText(n0.c("lgoCount", 50) + "");
        this.f1116j.setText(n0.c("lgoSize", 300) + "");
        m(viewInflate);
        l("日志设置");
        this.f1114h.setInputType(2);
        this.f1115i.setInputType(2);
        this.f1116j.setInputType(2);
        k("确定", new View.OnClickListener() { // from class: com.yl.float_ui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.q(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.yl.float_ui.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.s(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) throws NumberFormatException {
        s0.g().o(this);
        try {
            int i2 = Integer.parseInt(this.f1115i.getText().toString());
            int i3 = Integer.parseInt(this.f1116j.getText().toString());
            int i4 = Integer.parseInt(this.f1114h.getText().toString());
            n0.i("lgoTs", i2);
            n0.i("lgoCount", i4);
            n0.i("lgoSize", i3);
            y0.b().q();
            a aVar = this.f1117k;
            if (aVar != null) {
                aVar.a(null);
            }
        } catch (Exception unused) {
            DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
            dingMsgView.h("请输入正确的数字。");
            dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.yl.float_ui.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.l("温馨提示");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) {
        s0.g().o(this);
    }

    public LogSetDialogView t(a aVar) {
        this.f1117k = aVar;
        return this;
    }
}

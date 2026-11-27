package com.v;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.yl.float_ui.DingMsgView;

/* loaded from: classes.dex */
public class KeyValueDialog extends DingMsgView {

    /* renamed from: h, reason: collision with root package name */
    private EditText f973h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f974i;

    /* renamed from: j, reason: collision with root package name */
    private a f975j;

    public interface a {
        void a(String str, String str2);
    }

    public KeyValueDialog() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.H, null);
        this.f973h = (EditText) viewInflate.findViewById(j.b.e.z1);
        this.f974i = (EditText) viewInflate.findViewById(j.b.e.A1);
        a(viewInflate);
        i("取消", new View.OnClickListener() { // from class: com.v.ob
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(KeyValueDialog.class);
            }
        });
        k("确定", new View.OnClickListener() { // from class: com.v.pb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) {
        if (this.f975j != null) {
            if (TextUtils.isEmpty(this.f974i.getText().toString())) {
                this.f974i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            } else if (TextUtils.isEmpty(this.f973h.getText().toString())) {
                this.f974i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            } else {
                com.frame.s0.g().d(KeyValueDialog.class);
                this.f975j.a(this.f974i.getText().toString(), this.f973h.getText().toString());
            }
        }
    }

    public KeyValueDialog r(a aVar) {
        this.f975j = aVar;
        return this;
    }

    public void setKeyValue(String str, String str2) {
        this.f974i.setText(str);
        this.f973h.setText(str2);
    }
}

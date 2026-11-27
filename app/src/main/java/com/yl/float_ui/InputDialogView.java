package com.yl.float_ui;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.frame.s0;
import com.frame.v0;

/* loaded from: classes.dex */
public class InputDialogView extends DingMsgView {

    /* renamed from: h, reason: collision with root package name */
    private EditText f1111h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f1112i;

    /* renamed from: j, reason: collision with root package name */
    private a f1113j;

    public interface a {
        boolean a(String str);
    }

    public InputDialogView() {
        View viewInflate = View.inflate(v0.g(), k0.a, null);
        this.f1111h = (EditText) viewInflate.findViewById(j0.f1124j);
        this.f1112i = (TextView) viewInflate.findViewById(j0.x);
        a(viewInflate);
        i("取消", new View.OnClickListener() { // from class: com.yl.float_ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.g().d(InputDialogView.class);
            }
        });
        TextView textView = (TextView) findViewById(j0.b);
        textView.setText("确定");
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        a aVar = this.f1113j;
        if (aVar == null || !aVar.a(this.f1111h.getText().toString())) {
            return;
        }
        s0.g().d(InputDialogView.class);
    }

    public InputDialogView o(String str) {
        this.f1111h.append(str);
        return this;
    }

    public InputDialogView s(String str) {
        this.f1111h.setHint(str);
        return this;
    }

    public InputDialogView t(a aVar) {
        this.f1113j = aVar;
        return this;
    }

    public InputDialogView u(int i2) {
        this.f1111h.setInputType(i2);
        return this;
    }

    public InputDialogView v(int i2) {
        this.f1111h.setMinLines(i2);
        return this;
    }

    public InputDialogView w(String str) {
        this.f1111h.setText(str);
        return this;
    }

    public InputDialogView x(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1112i.setVisibility(0);
            this.f1112i.setText(str);
        }
        return this;
    }

    public InputDialogView y(String str, View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            this.f1112i.setVisibility(0);
            this.f1112i.setText(str);
            this.f1112i.setOnClickListener(onClickListener);
        }
        return this;
    }

    public void z(String str) {
        this.f1111h.startAnimation(AnimationUtils.loadAnimation(v0.g(), h0.a));
    }
}

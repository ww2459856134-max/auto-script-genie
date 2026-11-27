package com.v.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.v.FloatToast;
import com.yl.model.Delay;
import i.b.o8;

/* loaded from: classes.dex */
public class DelayItem extends BaseItemView implements View.OnClickListener {
    private EditText c;
    private EditText d;
    private TextView e;
    private TextView f;
    private View g;

    public DelayItem(Context context) {
        super(context);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        this.e.setSelected(!r2.isSelected());
        c(this.e.isSelected());
    }

    public void c(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
        this.c.setHint(z ? "随机最小值/变量" : "毫秒或${变量}");
        this.f.setVisibility(z ? 0 : 8);
    }

    public void d() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.q, this);
        this.c = (EditText) viewInflate.findViewById(j.b.e.D1);
        this.d = (EditText) viewInflate.findViewById(j.b.e.E1);
        this.g = viewInflate.findViewById(j.b.e.A4);
        this.e = (TextView) viewInflate.findViewById(j.b.e.F);
        this.f = (TextView) viewInflate.findViewById(j.b.e.s6);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
        this.c.setInputType(1);
        this.c.setHint("毫秒或${变量}");
        this.d.setInputType(1);
        this.d.setHint("随机最大值");
    }

    public Delay getDelay() throws NumberFormatException {
        String strTrim = this.c.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            this.c.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入延迟时间或变量");
            com.frame.k0.r(new IllegalArgumentException("delay empty"));
            return null;
        }
        if (!this.e.isSelected()) {
            return new Delay(strTrim, "0");
        }
        String strTrim2 = this.d.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim2)) {
            this.d.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入随机最大值或变量");
            return null;
        }
        if (o8.a(strTrim, strTrim2)) {
            if (Long.parseLong(strTrim2) < Long.parseLong(strTrim)) {
                this.d.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("最大值必须大于最小值");
                return null;
            }
        }
        return new Delay(strTrim, strTrim2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setEditDelay(String str, String str2) {
        if (o8.d(str, str2)) {
            this.c.setText(o8.g(str));
            this.d.setText(o8.g(str2));
            this.e.setSelected(true);
        } else {
            this.c.setText(o8.g(str));
            this.d.setText("0");
            this.e.setSelected(false);
        }
        c(this.e.isSelected());
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public DelayItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DelayItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

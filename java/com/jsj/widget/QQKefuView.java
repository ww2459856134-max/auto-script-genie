package com.jsj.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.frame.v0;
import com.frame.y0;
import com.jsj.autojs.h;
import com.jsj.autojs.l.c0;

/* loaded from: classes.dex */
public class QQKefuView extends LinearLayout implements View.OnClickListener {
    private String c;

    public QQKefuView(Context context) {
        super(context);
    }

    public void a() {
        View.inflate(v0.g(), 2131493136, this);
        setOnClickListener(this);
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        ((TextView) findViewById(2131296366)).setText(this.c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c0.e().g();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public QQKefuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            this.c = context.getTheme().obtainStyledAttributes(attributeSet, h.b, 0, 0).getString(0);
        } catch (Exception e) {
            y0.l(e);
        }
    }

    public QQKefuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

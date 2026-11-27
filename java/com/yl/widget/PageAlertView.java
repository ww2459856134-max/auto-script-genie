package com.yl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.frame.k0;
import com.frame.v0;
import com.yl.ui.a0;
import com.yl.ui.b0;
import i.a.k;

/* loaded from: classes.dex */
public class PageAlertView extends LinearLayout implements View.OnClickListener {
    private k c;
    private String d;

    public PageAlertView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(View view) {
        findViewById(a0.K).setVisibility(8);
    }

    public void a(String str) {
        this.d = str;
        try {
            this.c.d(str, findViewById(a0.K), (ImageView) findViewById(a0.f1133k), null, v0.g().d(), null, false, 500L, new View.OnClickListener() { // from class: com.yl.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.c(view);
                }
            }, 0);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a0.d) {
            try {
                findViewById(a0.K).setVisibility(8);
                this.c.l(this.d);
                k0.i(this.d + "_close_click");
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), b0.f1138h, this);
        this.c = new k();
        findViewById(a0.d).setOnClickListener(this);
    }

    public PageAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PageAlertView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

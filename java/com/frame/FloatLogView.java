package com.frame;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;
import com.frame.y0;

/* loaded from: classes.dex */
public class FloatLogView extends ScrollView {
    TextView c;

    public FloatLogView() {
        super(v0.g());
        TextView textView = new TextView(v0.g());
        this.c = textView;
        addView(textView, -1, -1);
        this.c.setTextSize(9.0f);
        this.c.setTextColor(-1);
        int iC = p1.c(20.0f);
        setPadding(iC, iC, iC, 0);
        setBackgroundColor(Color.parseColor("#77000000"));
        if (Build.VERSION.SDK_INT >= 11) {
            setAlpha(0.7f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(String str) {
        try {
            if (this.c.getLineCount() > 55) {
                this.c.setText("");
            }
            this.c.append(Html.fromHtml(str));
        } catch (Exception e) {
            k0.r(e);
        }
        l1.c(342546, new Runnable() { // from class: com.frame.r
            @Override // java.lang.Runnable
            public final void run() {
                s0.g().s(FloatLogView.class);
            }
        }, 300L);
    }

    public void d(final String str) {
        l1.e(new Runnable() { // from class: com.frame.q
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c(str);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        y0.b().s(new y0.a() { // from class: com.frame.y
            @Override // com.frame.y0.a
            public final void a(String str) {
                this.a.d(str);
            }
        });
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y0.b().s(null);
    }

    public FloatLogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatLogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

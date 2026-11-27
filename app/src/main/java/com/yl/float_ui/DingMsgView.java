package com.yl.float_ui;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.frame.s0;
import com.frame.t0;
import com.frame.v0;

/* loaded from: classes.dex */
public class DingMsgView extends LinearLayout implements View.OnClickListener {
    private WindowManager c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;

    public DingMsgView() {
        this(v0.g(), null);
        d(v0.g());
    }

    private void d(Context context) {
        setGravity(17);
        LayoutInflater.from(context).inflate(k0.c, (ViewGroup) this, true);
        this.d = (TextView) findViewById(j0.w);
        this.e = (TextView) findViewById(j0.s);
        this.f = (TextView) findViewById(j0.c);
        this.g = (TextView) findViewById(j0.b);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        setVisibility(8);
        s0.g().n(this);
    }

    public DingMsgView a(View view) {
        ((LinearLayout) findViewById(j0.y)).addView(view, -1, -2);
        return this;
    }

    public DingMsgView b(View view, LinearLayout.LayoutParams layoutParams) {
        ((LinearLayout) findViewById(j0.y)).addView(view, layoutParams);
        return this;
    }

    public void c() {
        WindowManager windowManager;
        s0.g().n(this);
        try {
            if (getParent() == null || (windowManager = this.c) == null) {
                return;
            }
            windowManager.removeView(this);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public DingMsgView g(int i2) {
        ImageView imageView = (ImageView) findViewById(j0.f1129o);
        imageView.setVisibility(0);
        imageView.setImageResource(i2);
        return this;
    }

    public DingMsgView h(String str) {
        this.e.setVisibility(0);
        this.e.setText(Html.fromHtml(str));
        return this;
    }

    public DingMsgView i(String str, View.OnClickListener onClickListener) {
        if (str == null) {
            this.f.setVisibility(8);
            return this;
        }
        this.f.setText(str);
        this.f.setVisibility(0);
        this.f.setTag(onClickListener);
        this.f.setOnClickListener(this);
        return this;
    }

    public DingMsgView j(String str) {
        this.g.setText(str);
        return this;
    }

    public DingMsgView k(String str, View.OnClickListener onClickListener) {
        if (str == null) {
            this.g.setVisibility(8);
            return this;
        }
        this.g.setText(str);
        this.g.setVisibility(0);
        this.g.setTag(onClickListener);
        this.g.setOnClickListener(this);
        return this;
    }

    public DingMsgView l(String str) {
        this.d.setText(str);
        return this;
    }

    public DingMsgView m(View view) {
        LinearLayout linearLayout = (LinearLayout) findViewById(j0.y);
        linearLayout.removeAllViews();
        linearLayout.addView(view, -1, -2);
        return this;
    }

    public DingMsgView n() {
        if (getParent() != null) {
            return this;
        }
        try {
            this.c = (WindowManager) t0.a().getSystemService("window");
            WindowManager.LayoutParams layoutParamsB = t0.b(true);
            layoutParamsB.flags = 8;
            layoutParamsB.width = -1;
            layoutParamsB.height = -1;
            this.c.addView(this, layoutParamsB);
        } catch (Exception e) {
            com.frame.k0.r(e);
            try {
                this.c.removeView(this);
            } catch (Exception unused) {
                com.frame.k0.r(e);
            }
        }
        return this;
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            View.OnClickListener onClickListener = (View.OnClickListener) view.getTag();
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else {
            s0.g().n(this);
        }
        c();
    }

    public void setBackground(int i2) {
        findViewById(j0.p).setBackgroundResource(i2);
    }

    public DingMsgView(Context context) {
        this(v0.g(), null);
        d(v0.g());
    }

    public DingMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }
}

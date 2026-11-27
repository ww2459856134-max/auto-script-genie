package com.jsj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class BottomView extends LinearLayout {
    private View c;
    private View d;
    private View e;
    private View.OnClickListener f;
    private View g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomView.this.g.setSelected(false);
            view.setSelected(true);
            BottomView.this.g = view;
            BottomView.this.f.onClick(view);
        }
    }

    public BottomView(Context context) {
        this(context, null);
    }

    private void d(Context context) {
        setOrientation(0);
        setGravity(17);
        LayoutInflater.from(context).inflate(2131493116, (ViewGroup) this, true);
        this.c = findViewById(2131297094);
        this.d = findViewById(2131297092);
        this.e = findViewById(2131297107);
        a aVar = new a();
        this.c.setOnClickListener(aVar);
        this.c.setSelected(true);
        this.g = this.c;
        this.d.setOnClickListener(aVar);
        this.e.setOnClickListener(aVar);
    }

    public void setBottomOnClick(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public BottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }
}

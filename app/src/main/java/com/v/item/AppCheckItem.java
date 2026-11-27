package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.AppChooseView;

/* loaded from: classes.dex */
public class AppCheckItem extends BaseItemView implements View.OnClickListener {
    protected TextView c;
    protected View d;
    private TextView e;

    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AppCheckItem.this.setValue(null);
            return true;
        }
    }

    public AppCheckItem(Context context) {
        super(context);
    }

    public void c() {
        View.inflate(getContext(), j.b.f.A0, this);
        this.d = findViewById(j.b.e.k1);
        this.e = (TextView) findViewById(j.b.e.K5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AppChooseView appChooseView = (AppChooseView) com.frame.s0.g().B(AppChooseView.class);
        appChooseView.u((String) this.c.getTag());
        appChooseView.v(false);
        appChooseView.setCallback(new AppChooseView.a() { // from class: com.v.item.z1
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                this.a.setValue(str);
            }
        });
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.e.setText(str);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
        } else {
            this.c.setTag(null);
            this.c.setText((CharSequence) null);
            this.c.setVisibility(8);
            this.d.setVisibility(0);
        }
    }

    public void setValue(String str) {
        if (str != null) {
            this.c.setTag(str);
            this.c.setText(com.frame.p1.e(str));
        }
        setSelected(str != null);
    }

    public AppCheckItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
        setOnClickListener(this);
        this.c.setOnLongClickListener(new a());
    }

    @Override // com.v.item.BaseItemView
    public String getValue() {
        return (String) this.c.getTag();
    }

    public AppCheckItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

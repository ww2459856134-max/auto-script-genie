package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.AppChooseView;

/* loaded from: classes.dex */
public class AppItem extends BaseItemView implements View.OnClickListener {
    protected TextView c;
    private TextView d;

    public AppItem(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str) {
        this.c.setTag(str);
        this.c.setText(com.frame.p1.e(str));
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.d = (TextView) findViewById(j.b.e.K5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AppChooseView appChooseView = (AppChooseView) com.frame.s0.g().B(AppChooseView.class);
        appChooseView.u((String) this.c.getTag());
        appChooseView.setCallback(new AppChooseView.a() { // from class: com.v.item.a
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                this.a.e(str);
            }
        });
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setValue(String str) {
        this.c.setTag(str);
        this.c.setText(com.frame.p1.e(str));
    }

    public AppItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
        this.c.setOnClickListener(this);
    }

    @Override // com.v.item.BaseItemView
    public String getValue() {
        return (String) this.c.getTag();
    }

    public AppItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

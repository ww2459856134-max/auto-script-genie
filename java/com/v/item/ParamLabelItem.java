package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.Set;

/* loaded from: classes.dex */
public class ParamLabelItem extends BaseItemView implements View.OnClickListener {
    private ParamNameTextView c;
    private TextView d;

    public interface a {
    }

    public ParamLabelItem(Context context) {
        super(context);
        c();
    }

    public void c() {
        View.inflate(getContext(), j.b.f.W0, this);
        this.c = (ParamNameTextView) findViewById(j.b.e.Z5);
        this.d = (TextView) findViewById(j.b.e.K5);
        this.c.setInputLabel("变量名称");
        this.c.setInputHint("请输入变量名称");
        this.c.setChooseParamNameType();
    }

    public void d() {
        this.c.j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d();
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setOnTextFilter(a aVar) {
    }

    public void setParamKeys(Set<String> set) {
        if (set != null) {
        }
    }

    public void setValue(String str) {
        this.c.setText(str);
    }

    @Override // com.v.item.BaseItemView
    public String getValue() {
        return this.c.getText().toString();
    }

    public ParamLabelItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
    }

    public ParamLabelItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

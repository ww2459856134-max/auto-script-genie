package com.v.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CheckItem extends BaseItemView implements View.OnClickListener {
    TextView c;
    private CompoundButton.OnCheckedChangeListener d;

    public CheckItem(Context context) {
        super(context);
        c();
    }

    public void c() {
        View.inflate(getContext(), j.b.f.C0, this);
        TextView textView = (TextView) findViewById(j.b.e.K5);
        this.c = textView;
        textView.setOnClickListener(this);
    }

    public CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.c.setSelected(!r3.isSelected());
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.d;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(null, this.c.isSelected());
        }
    }

    public void setLabel(String str) {
        this.c.setText(str);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.d = onCheckedChangeListener;
    }

    @Override // com.v.item.BaseItemView
    public void setRule(JSONObject jSONObject) {
        super.setRule(jSONObject);
        String strOptString = jSONObject.optString("label");
        jSONObject.optString(SocialConstants.PARAM_TYPE);
        boolean zOptBoolean = jSONObject.optBoolean("defaultValue");
        this.c.setText(strOptString);
        this.c.setSelected(zOptBoolean);
        this.c.setOnClickListener(this);
    }

    public void setValue(boolean z) {
        this.c.setSelected(z);
    }

    @Override // com.v.item.BaseItemView
    public Boolean getValue() {
        return Boolean.valueOf(this.c.isSelected());
    }

    public CheckItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        setLabel(context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0).getString(j.b.h.b));
    }

    public CheckItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

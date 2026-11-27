package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InputItem extends BaseItemView {
    private EditText c;
    private TextView d;
    private TextView e;

    public InputItem(Context context) {
        super(context);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str, View view) {
        b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str, View view) {
        b(str);
    }

    public void c() {
        View.inflate(getContext(), j.b.f.I0, this);
        this.c = (EditText) findViewById(j.b.e.K1);
        this.d = (TextView) findViewById(j.b.e.K5);
        this.e = (TextView) findViewById(j.b.e.Y5);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setHelp(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, j.b.d.L0, 0);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(str, view);
            }
        });
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setInputType(int i2) {
        this.c.setInputType(i2);
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setMaxLength(int i2) {
        this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    @Override // com.v.item.BaseItemView
    public void setRule(JSONObject jSONObject) {
        super.setRule(jSONObject);
        String strOptString = jSONObject.optString("label");
        jSONObject.optString(SocialConstants.PARAM_TYPE);
        String strOptString2 = jSONObject.optString("defaultValue");
        String strOptString3 = jSONObject.optString("hint");
        String strOptString4 = jSONObject.optString("unit");
        jSONObject.optString("inputType");
        this.d.setText(strOptString);
        this.c.setText(strOptString2);
        this.c.setHint(strOptString3);
        TextView textView = (TextView) findViewById(j.b.e.Y5);
        if (TextUtils.isEmpty(strOptString4)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(strOptString4);
        }
    }

    public void setUnit(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            this.e.setText(str);
        }
    }

    public void setUnitOnClickListener(View.OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public void setValue(String str) {
        this.c.setText(str);
    }

    @Override // com.v.item.BaseItemView
    public String getValue() {
        return this.c.getText().toString();
    }

    public InputItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        String string3 = typedArrayObtainStyledAttributes.getString(j.b.h.g);
        String string4 = typedArrayObtainStyledAttributes.getString(j.b.h.e);
        final String string5 = typedArrayObtainStyledAttributes.getString(j.b.h.f1768h);
        int i2 = typedArrayObtainStyledAttributes.getInt(j.b.h.d, Integer.MAX_VALUE);
        setHelp(string4);
        setUnit(string3);
        setLabel(string);
        setHint(string2);
        if (i2 != Integer.MAX_VALUE && i2 != 0) {
            setMaxLength(i2);
        }
        if (TextUtils.isEmpty(string5)) {
            return;
        }
        setUnitOnClickListener(new View.OnClickListener() { // from class: com.v.item.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.e(string5, view);
            }
        });
    }

    public InputItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

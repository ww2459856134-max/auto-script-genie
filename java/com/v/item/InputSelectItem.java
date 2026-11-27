package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.v.FlowLayout;
import com.yl.float_ui.InputDialogView;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InputSelectItem extends BaseItemView implements View.OnClickListener {
    private TextView c;
    private TextView d;
    private String e;
    private HashMap<String, String> f;

    public InputSelectItem(Context context) {
        super(context);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(FlowLayout flowLayout, InputDialogView inputDialogView, String str, View view) {
        if (flowLayout.getTag() != null) {
            ((View) flowLayout.getTag()).setSelected(false);
        }
        flowLayout.setTag(view);
        view.setSelected(true);
        inputDialogView.w(this.f.get(str));
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.c = (TextView) findViewById(j.b.e.Z5);
        this.d = (TextView) findViewById(j.b.e.K5);
        this.c.setOnClickListener(this);
    }

    public boolean f(String str) {
        this.c.setText(str);
        return true;
    }

    public void g(InputDialogView.a aVar) {
        final InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l(this.d.getText().toString());
        inputDialogView.s(this.e);
        inputDialogView.w(this.c.getText().toString());
        final FlowLayout flowLayout = new FlowLayout(com.frame.v0.g());
        flowLayout.setPadding(com.frame.p1.c(20.0f), 0, com.frame.p1.c(20.0f), 0);
        flowLayout.setHorizontalSpacing(com.frame.p1.c(5.0f));
        flowLayout.setVerticalSpacing(com.frame.p1.c(10.0f));
        int iC = com.frame.p1.c(6.0f);
        com.frame.v0 v0VarG = com.frame.v0.g();
        int i2 = j.b.c.f;
        int color = v0VarG.getColor(i2);
        TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(com.frame.v0.g().getResources().getColor(i2));
        textView.setText("选择字符：");
        int i3 = iC / 2;
        textView.setPadding(iC, i3, iC, i3);
        textView.setTextSize(10.0f);
        flowLayout.addView(textView);
        HashMap<String, String> map = this.f;
        if (map != null && !map.isEmpty()) {
            for (final String str : this.f.keySet()) {
                TextView textView2 = new TextView(com.frame.v0.g());
                textView2.setText(str);
                textView2.setPadding(iC, i3, iC, i3);
                textView2.setTextSize(10.0f);
                textView2.setBackgroundResource(j.b.d.D0);
                textView2.setTextColor(color);
                flowLayout.addView(textView2);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.c0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.e(flowLayout, inputDialogView, str, view);
                    }
                });
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.frame.p1.c(5.0f);
        inputDialogView.b(flowLayout, layoutParams);
        inputDialogView.t(aVar);
    }

    public HashMap<String, String> getMap() {
        return this.f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g(new InputDialogView.a() { // from class: com.v.item.h2
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.f(str);
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setInputHint(String str) {
        this.e = str;
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setMap(HashMap<String, String> map) {
        this.f = map;
    }

    @Override // com.v.item.BaseItemView
    public void setRule(JSONObject jSONObject) {
        super.setRule(jSONObject);
        String strOptString = jSONObject.optString("label");
        jSONObject.optString(SocialConstants.PARAM_TYPE);
        String strOptString2 = jSONObject.optString("defaultValue");
        String strOptString3 = jSONObject.optString("hint");
        jSONObject.optString("unit");
        jSONObject.optString("inputType");
        this.d.setText(strOptString);
        this.c.setText(strOptString2);
        this.c.setHint(strOptString3);
    }

    @Override // com.v.item.BaseItemView
    public String getValue() {
        return this.c.getText().toString();
    }

    public InputSelectItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        typedArrayObtainStyledAttributes.getString(j.b.h.g);
        setLabel(string);
        setHint(string2);
    }

    public InputSelectItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

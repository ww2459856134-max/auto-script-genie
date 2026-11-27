package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.CalculateDialogView;
import com.v.JudgeDialogView;

/* loaded from: classes.dex */
public class CalculateItem extends BaseItemView implements View.OnClickListener {
    private TextView c;
    private TextView d;
    private TextView e;
    private JudgeDialogView.b f;

    public CalculateItem(Context context) {
        super(context);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str, String str2) {
        this.c.setText(str);
        this.d.setVisibility(0);
        this.d.setText(str2);
        JudgeDialogView.b bVar = this.f;
        if (bVar != null) {
            bVar.a(str, str2);
        }
    }

    public void c() {
        View.inflate(getContext(), j.b.f.K0, this);
        setOnClickListener(this);
        this.d = (TextView) findViewById(j.b.e.U5);
        this.c = (TextView) findViewById(j.b.e.Z5);
        this.e = (TextView) findViewById(j.b.e.K5);
    }

    public Object getSubValue() {
        return this.d.getText().toString();
    }

    @Override // com.v.item.BaseItemView
    public Object getValue() {
        return this.c.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CalculateDialogView calculateDialogView = (CalculateDialogView) com.frame.s0.g().B(CalculateDialogView.class);
        calculateDialogView.setSelectValue(this.c.getText().toString(), this.d.getText().toString());
        calculateDialogView.setOnJudgeChooseListener(new CalculateDialogView.c() { // from class: com.v.item.j
            @Override // com.v.CalculateDialogView.c
            public final void a(String str, String str2) {
                this.a.e(str, str2);
            }
        });
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.e.setText(str);
    }

    public void setOnJudgeChooseListener(JudgeDialogView.b bVar) {
        this.f = bVar;
    }

    public void setValue(String str, String str2) {
        this.c.setText(str);
        if (this.f == null || TextUtils.isEmpty(str2)) {
            return;
        }
        this.d.setVisibility(0);
        this.d.setText(str2);
        this.f.a(str, str2);
    }

    public CalculateItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
    }

    public CalculateItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

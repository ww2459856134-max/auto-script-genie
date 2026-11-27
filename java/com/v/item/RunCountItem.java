package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.RunCountSetDialogView;
import com.v.lt;
import com.yl.model.Node;

/* loaded from: classes.dex */
public class RunCountItem extends BaseItemView implements View.OnClickListener {
    protected TextView c;
    private TextView d;
    private TextView e;
    private Node f;

    public RunCountItem(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Node node) {
        this.c.setText(node.getCheckCount() + "次");
        this.d.setText(node.getCheckDelay() + "毫秒");
        if (node.getCheckCount().longValue() < 2) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.e = (TextView) findViewById(j.b.e.K5);
        this.d = (TextView) findViewById(j.b.e.U5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RunCountSetDialogView runCountSetDialogView = (RunCountSetDialogView) com.frame.s0.g().B(RunCountSetDialogView.class);
        runCountSetDialogView.setNode(this.f);
        runCountSetDialogView.setNodeCallback(new lt() { // from class: com.v.item.p1
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.e(node);
            }
        });
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.e.setText(str);
    }

    public void setNode(Node node) {
        this.f = node;
        if (node.getCheckCount() == null) {
            node.setCheckCount(1L);
            node.setCheckDelay(500L);
            this.d.setVisibility(8);
        } else if (node.getCheckCount().longValue() < 2) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        this.c.setText(node.getCheckCount() + "次");
        this.d.setText(node.getCheckDelay() + "毫秒");
    }

    public void setValue(String str) {
        this.c.setText(str);
    }

    public RunCountItem(Context context, AttributeSet attributeSet) {
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
        return this.c.getText().toString();
    }

    public RunCountItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

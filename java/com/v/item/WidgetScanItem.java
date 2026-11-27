package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.WidgetScanTypeDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.WidgetFeature;
import i.b.ka.s7;

/* loaded from: classes.dex */
public class WidgetScanItem extends BaseItemView implements View.OnClickListener {
    private TextView c;
    Task d;
    Node e;

    public WidgetScanItem(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Node node) {
        setValue(this.d, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(final Node node) {
        com.frame.l1.e(new Runnable() { // from class: com.v.item.g2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.e(node);
            }
        });
    }

    public void c() {
        View.inflate(getContext(), j.b.f.g1, this);
        this.c = (TextView) findViewById(j.b.e.K5);
    }

    public int getWhat() {
        return 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WidgetScanTypeDialogView widgetScanTypeDialogView = (WidgetScanTypeDialogView) com.frame.s0.g().B(WidgetScanTypeDialogView.class);
        widgetScanTypeDialogView.o(this.d, this.e);
        widgetScanTypeDialogView.n(new lt() { // from class: com.v.item.f2
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.g(node);
            }
        });
    }

    public void setHint(String str) {
    }

    public void setLabel(String str) {
        this.c.setText(str);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
    }

    public void setValue(Task task, Node node) {
        this.d = task;
        this.e = node;
        WidgetFeature widgetFeatureV = s7.V(node.arg1);
        TextView textView = (TextView) findViewById(j.b.e.F5);
        TextView textView2 = (TextView) findViewById(j.b.e.x5);
        TextView textView3 = (TextView) findViewById(j.b.e.W5);
        TextView textView4 = (TextView) findViewById(j.b.e.A5);
        TextView textView5 = (TextView) findViewById(j.b.e.L5);
        TextView textView6 = (TextView) findViewById(j.b.e.D5);
        TextView textView7 = (TextView) findViewById(j.b.e.a6);
        textView.setVisibility(widgetFeatureV.idToggle ? 0 : 8);
        textView2.setVisibility(widgetFeatureV.classToggle ? 0 : 8);
        textView3.setVisibility(widgetFeatureV.textToggle ? 0 : 8);
        textView4.setVisibility(widgetFeatureV.descToggle ? 0 : 8);
        textView5.setVisibility(widgetFeatureV.pathToggle ? 0 : 8);
        textView6.setVisibility(widgetFeatureV.heightToggle ? 0 : 8);
        textView7.setVisibility(widgetFeatureV.widthToggle ? 0 : 8);
    }

    public WidgetScanItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
        setOnClickListener(this);
    }

    @Override // com.v.item.BaseItemView
    public String getValue() {
        return this.e.arg1;
    }

    public WidgetScanItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

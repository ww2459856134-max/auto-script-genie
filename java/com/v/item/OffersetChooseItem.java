package com.v.item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.ColorScanDialogView;
import com.v.FlowView;
import com.v.ImageScanDialogView;
import com.v.NodeListDialogView;
import com.v.RectOfferSetChooseView;
import com.v.TextScanDialogView;
import com.v.WidgetScanDialogView;
import com.v.lt;

/* loaded from: classes.dex */
public class OffersetChooseItem extends BaseItemView implements View.OnClickListener {
    protected TextView c;
    private TextView d;
    private Rect e;
    private Point f;
    private lt g;

    public OffersetChooseItem(Context context) {
        super(context);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean e(View view) {
        setValue(this.e, null);
        return true;
    }

    static /* synthetic */ void f(DialogInterface dialogInterface) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(TextScanDialogView.class);
        com.frame.s0.g().u(ColorScanDialogView.class);
        com.frame.s0.g().d(RectOfferSetChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(RectOfferSetChooseView rectOfferSetChooseView, View view) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(TextScanDialogView.class);
        com.frame.s0.g().u(ColorScanDialogView.class);
        com.frame.s0.g().d(RectOfferSetChooseView.class);
        setValue(this.e, rectOfferSetChooseView.getOfferSet());
        lt ltVar = this.g;
        if (ltVar != null) {
            ltVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        com.frame.s0.g().i(TextScanDialogView.class);
        com.frame.s0.g().i(ImageScanDialogView.class);
        com.frame.s0.g().i(WidgetScanDialogView.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(ColorScanDialogView.class);
        com.frame.s0.g().i(FlowView.class);
        final RectOfferSetChooseView rectOfferSetChooseView = (RectOfferSetChooseView) com.frame.s0.g().x(RectOfferSetChooseView.class);
        Rect rect = this.e;
        if (rect == null || (rect.top == 0 && rect.bottom == 0 && rect.left == 0 && rect.right == 0)) {
            int iE = com.frame.k0.c().e() / 2;
            int iD = com.frame.k0.c().d() / 2;
            int iC = com.frame.p1.c(20.0f);
            this.e = new Rect(iE - iC, iD - iC, iE + iC, iD + iC);
        }
        rectOfferSetChooseView.setRect(this.e, this.f);
        rectOfferSetChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.v.item.g1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                OffersetChooseItem.f(dialogInterface);
            }
        });
        rectOfferSetChooseView.h("确定", new View.OnClickListener() { // from class: com.v.item.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.h(rectOfferSetChooseView, view2);
            }
        });
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.d = (TextView) findViewById(j.b.e.K5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.v.item.h1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.c.e(view);
            }
        });
        this.c.setOnClickListener(this);
        setOnClickListener(new View.OnClickListener() { // from class: com.v.item.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.j(view);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        callOnClick();
    }

    public void setCallback(lt ltVar) {
        this.g = ltVar;
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setValue(Rect rect, Point point) {
        this.f = point;
        this.e = rect;
        if (point == null) {
            this.c.setText((CharSequence) null);
            return;
        }
        this.c.setText(point.x + "," + point.y);
    }

    @Override // com.v.item.BaseItemView
    public Point getValue() {
        return this.f;
    }

    public OffersetChooseItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
    }

    public OffersetChooseItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

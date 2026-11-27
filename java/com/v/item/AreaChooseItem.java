package com.v.item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.ArgumentSetDialogView;
import com.v.FlowView;
import com.v.ImageScanDialogView;
import com.v.ItemChooseDialogView;
import com.v.MultiClickDialogView;
import com.v.NodeListDialogView;
import com.v.ParamsInitDialogView;
import com.v.RectChooseView;
import com.v.TextScanDialogView;
import com.v.WidgetScanDialogView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AreaChooseItem extends BaseItemView implements View.OnClickListener {
    protected TextView c;
    private TextView d;
    private Rect e;
    private String f;

    public AreaChooseItem(Context context) {
        super(context);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(DialogInterface dialogInterface) {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(View view) {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(RectChooseView rectChooseView, View view) {
        t();
        setValue(rectChooseView.getRect(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean m(View view) {
        setValue(null, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean o(String str) {
        setValue(null, str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            c();
            return;
        }
        if (i2 == 1) {
            setValue(null, null);
            return;
        }
        if (i2 == 2) {
            ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
            paramNameTextView.setInputHint("请输入值~");
            paramNameTextView.setInputLabel("请输入值");
            paramNameTextView.setText(this.f);
            paramNameTextView.k(new InputDialogView.a() { // from class: com.v.item.h
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.o(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) {
        int i2 = this.f != null ? 2 : this.e == null ? 1 : 0;
        ArrayList arrayList = new ArrayList(Arrays.asList("指定区域匹配", "全屏匹配", "使用变量"));
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择操作");
        itemChooseDialogView.setDefaultData(i2, arrayList);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.f
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i3, List list) {
                this.a.q(i3, list);
            }
        });
    }

    private void t() {
        com.frame.s0.g().u(ParamsInitDialogView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(MultiClickDialogView.class);
        com.frame.s0.g().u(TextScanDialogView.class);
        com.frame.s0.g().u(ArgumentSetDialogView.class);
        com.frame.s0.g().d(RectChooseView.class);
    }

    public void c() {
        com.frame.s0.g().i(ParamsInitDialogView.class);
        com.frame.s0.g().i(MultiClickDialogView.class);
        com.frame.s0.g().i(TextScanDialogView.class);
        com.frame.s0.g().i(ImageScanDialogView.class);
        com.frame.s0.g().i(WidgetScanDialogView.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(ArgumentSetDialogView.class);
        com.frame.s0.g().i(FlowView.class);
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setRect(this.e);
        rectChooseView.setHit("滑动选取识别区域");
        rectChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.v.item.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.c.g(dialogInterface);
            }
        });
        rectChooseView.q("取消", new View.OnClickListener() { // from class: com.v.item.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.i(view);
            }
        });
        rectChooseView.r("确定", new View.OnClickListener() { // from class: com.v.item.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.k(rectChooseView, view);
            }
        });
    }

    public void d() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.d = (TextView) findViewById(j.b.e.K5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.v.item.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.c.m(view);
            }
        });
        this.c.setOnClickListener(this);
        setOnClickListener(new View.OnClickListener() { // from class: com.v.item.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.s(view);
            }
        });
    }

    public boolean e() {
        return (this.e == null && this.f == null) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        callOnClick();
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setValue(Rect rect, String str) {
        this.e = rect;
        this.f = str;
        if (str == null) {
            if (rect == null) {
                this.c.setText((CharSequence) null);
                return;
            } else {
                this.c.setText(Node.getStringByRect(rect));
                return;
            }
        }
        this.c.setText("变量：" + str);
    }

    public void u(Node node) {
        if (this.f != null) {
            node.setAreaNew(null);
            node.areaParam = this.f;
        } else {
            node.setAreaNew(this.e);
            node.areaParam = null;
        }
    }

    @Override // com.v.item.BaseItemView
    public Rect getValue() {
        return this.e;
    }

    public AreaChooseItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
    }

    public AreaChooseItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

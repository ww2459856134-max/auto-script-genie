package com.v.item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.v.ColorScanDialogView;
import com.v.FlowView;
import com.v.ImageScanDialogView;
import com.v.ItemChooseDialogView;
import com.v.NodeListDialogView;
import com.v.OcrDialogView;
import com.v.RectChooseView;
import com.v.TextScanDialogView;
import com.v.WidgetScanDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ImageAreaChooseItem extends BaseItemView implements View.OnClickListener {
    protected TextView c;
    private TextView d;
    private Rect e;
    private Rect f;
    private String g;

    public ImageAreaChooseItem(Context context) {
        super(context);
        d();
    }

    private void c() {
        com.frame.s0.g().i(OcrDialogView.class);
        com.frame.s0.g().i(TextScanDialogView.class);
        com.frame.s0.g().i(ImageScanDialogView.class);
        com.frame.s0.g().i(WidgetScanDialogView.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(ColorScanDialogView.class);
        com.frame.s0.g().i(FlowView.class);
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setRect(this.e);
        rectChooseView.setFrontRect(this.f, Color.parseColor("#55FF0000"));
        rectChooseView.setHit("滑动选取识别区域");
        rectChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.v.item.t
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ImageAreaChooseItem.e(dialogInterface);
            }
        });
        rectChooseView.q("取消", new View.OnClickListener() { // from class: com.v.item.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageAreaChooseItem.f(view);
            }
        });
        rectChooseView.r("确定", new View.OnClickListener() { // from class: com.v.item.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.h(rectChooseView, view);
            }
        });
    }

    static /* synthetic */ void e(DialogInterface dialogInterface) {
        com.frame.s0.g().u(OcrDialogView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(ColorScanDialogView.class);
        com.frame.s0.g().u(TextScanDialogView.class);
        com.frame.s0.g().d(RectChooseView.class);
    }

    static /* synthetic */ void f(View view) {
        com.frame.s0.g().u(OcrDialogView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(ColorScanDialogView.class);
        com.frame.s0.g().u(TextScanDialogView.class);
        com.frame.s0.g().d(RectChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(RectChooseView rectChooseView, View view) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(ColorScanDialogView.class);
        com.frame.s0.g().u(OcrDialogView.class);
        com.frame.s0.g().u(TextScanDialogView.class);
        com.frame.s0.g().d(RectChooseView.class);
        setValue(this.f, rectChooseView.getRect(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean j(View view) {
        setValue(this.f, null, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean m(String str) {
        setValue(this.f, null, str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            Rect rect = this.f;
            if (rect != null) {
                Rect rect2 = this.f;
                setValue(rect, new Rect(rect2.left, rect2.top, rect2.right, rect2.bottom), null);
                return;
            } else {
                DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                dingMsgView.l("温馨提示");
                dingMsgView.h("您可能是多图识别，由于是多图无法定位是哪个录制坐标，请选择区域识别或全局识别~");
                dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.item.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
                return;
            }
        }
        if (i2 == 1) {
            c();
            return;
        }
        if (i2 == 2) {
            setValue(this.f, null, null);
            return;
        }
        if (i2 == 3) {
            ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
            paramNameTextView.setInputHint("请输入值~");
            paramNameTextView.setInputLabel("请输入值");
            paramNameTextView.setText(this.g);
            paramNameTextView.k(new InputDialogView.a() { // from class: com.v.item.x
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.m(str);
                }
            });
        }
    }

    public void d() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.d = (TextView) findViewById(j.b.e.K5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.v.item.v
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.c.j(view);
            }
        });
        this.c.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (this.g != null) {
            i2 = 3;
        } else {
            Rect rect = this.e;
            i2 = rect == null ? 2 : rect.equals(this.f) ? 0 : 1;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList("录制时的坐标区域", "指定区域匹配", "全屏匹配(慢)", "使用变量"));
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择操作");
        itemChooseDialogView.setDefaultData(i2, arrayList);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.u
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i3, List list) {
                this.a.o(i3, list);
            }
        });
    }

    public void p(Node node) {
        String str = this.g;
        if (str != null) {
            node.areaParam = str;
        } else {
            node.setAreaNew(this.e);
            node.areaParam = null;
        }
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setOriginalRect(Rect rect) {
        Rect rect2 = this.e;
        setValue(rect, rect2 != null && rect2.equals(this.f) ? new Rect(rect) : this.e, this.g);
    }

    public void setValue(Rect rect, Rect rect2, String str) {
        this.g = str;
        this.f = rect;
        this.e = rect2;
        if (str != null) {
            this.c.setText("变量：" + str);
            return;
        }
        if (rect2 == null) {
            this.c.setText((CharSequence) null);
            return;
        }
        if (rect2.equals(rect)) {
            this.c.setText("录制时的坐标区域");
            return;
        }
        this.c.setText(rect2.left + "," + rect2.top + ProcessIdUtil.DEFAULT_PROCESSID + rect2.right + "," + rect2.bottom);
    }

    @Override // com.v.item.BaseItemView
    public Rect getValue() {
        return this.e;
    }

    public ImageAreaChooseItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
    }

    public ImageAreaChooseItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

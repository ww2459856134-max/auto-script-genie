package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.v.ItemChooseDialogView;
import com.v.RunConditionDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RunConditionItem extends BaseItemView implements View.OnClickListener {
    private TextView c;
    private TextView d;
    private Point e;
    private String f;
    private Task g;

    /* renamed from: h, reason: collision with root package name */
    private Node f1095h;

    /* renamed from: i, reason: collision with root package name */
    private View f1096i;

    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            RunConditionItem.this.c.setText((CharSequence) null);
            RunConditionItem.this.f1095h.setCondition(null);
            return true;
        }
    }

    class b implements lt {
        b() {
        }

        @Override // com.v.lt
        public void a(Node node) {
            if (node == null) {
                RunConditionItem.this.c.setText((CharSequence) null);
            } else {
                RunConditionItem.this.c.setText("前置条件");
            }
        }
    }

    class c implements lt {
        c() {
        }

        @Override // com.v.lt
        public void a(Node node) {
            if (node == null) {
                RunConditionItem.this.c.setText((CharSequence) null);
            } else {
                RunConditionItem.this.c.setText("前置条件");
            }
        }
    }

    public RunConditionItem(Context context) {
        super(context);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            this.f1095h.setCondition(null);
            this.c.setText((CharSequence) null);
        } else {
            if (i2 != 1) {
                return;
            }
            RunConditionDialogView runConditionDialogView = (RunConditionDialogView) com.frame.s0.g().B(RunConditionDialogView.class);
            runConditionDialogView.setAttachView(this.f1096i);
            runConditionDialogView.setTaskNode(this.g, this.f1095h);
            runConditionDialogView.c0(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            this.f1095h.setCondition(null);
            this.c.setText((CharSequence) null);
        } else {
            if (i2 != 1) {
                return;
            }
            RunConditionDialogView runConditionDialogView = (RunConditionDialogView) com.frame.s0.g().B(RunConditionDialogView.class);
            runConditionDialogView.setAttachView(this.f1096i);
            runConditionDialogView.setTaskNode(this.g, this.f1095h);
            runConditionDialogView.c0(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(String str, View view) {
        b(str);
    }

    public void e() {
        View.inflate(getContext(), j.b.f.Y0, this);
        TextView textView = (TextView) findViewById(j.b.e.K5);
        this.d = textView;
        textView.setText("执行条件");
        TextView textView2 = (TextView) findViewById(j.b.e.Z5);
        this.c = textView2;
        textView2.setOnClickListener(this);
        this.c.setHint("默认直接执行");
    }

    public String getParamName() {
        return this.f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.Z5) {
            if (this.c.getText().toString().isEmpty()) {
                ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
                itemChooseDialogView.setTitle("选择坐标");
                itemChooseDialogView.setDefaultData(0, new ArrayList(Arrays.asList("默认直接执行,添加执行条件".split(","))));
                itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.m1
                    @Override // com.v.ItemChooseDialogView.b
                    public final void a(int i2, List list) {
                        this.a.i(i2, list);
                    }
                });
                return;
            }
            ItemChooseDialogView itemChooseDialogView2 = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView2.setTitle("选择坐标");
            itemChooseDialogView2.setDefaultData(1, new ArrayList(Arrays.asList("默认直接执行,修改执行条件".split(","))));
            itemChooseDialogView2.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.o1
                @Override // com.v.ItemChooseDialogView.b
                public final void a(int i2, List list) {
                    this.a.g(i2, list);
                }
            });
        }
    }

    public void setAttachView(View view) {
        this.f1096i = view;
    }

    public void setHelp(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, j.b.d.L0, 0);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.k(str, view);
            }
        });
    }

    @Override // com.v.item.BaseItemView
    public void setRule(JSONObject jSONObject) {
        super.setRule(jSONObject);
        String strOptString = jSONObject.optString("label");
        jSONObject.optString(SocialConstants.PARAM_TYPE);
        jSONObject.optString("defaultValue");
        jSONObject.optString("hint");
        jSONObject.optString("unit");
        jSONObject.optString("inputType");
        jSONObject.optJSONArray("item");
        ((TextView) findViewById(j.b.e.K5)).setText(strOptString);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnClickListener(this);
        this.c.setOnLongClickListener(new a());
    }

    public void setTaskNode(Task task, Node node) {
        this.g = task;
        this.f1095h = node;
        if (node.getCondition() == null) {
            this.c.setText((CharSequence) null);
        } else {
            this.c.setText("前置条件");
        }
    }

    @Override // com.v.item.BaseItemView
    public Point getValue() {
        return this.e;
    }

    public RunConditionItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        typedArrayObtainStyledAttributes.getString(j.b.h.b);
        setHelp(typedArrayObtainStyledAttributes.getString(j.b.h.e));
    }

    public RunConditionItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}

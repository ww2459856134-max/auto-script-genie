package com.v.item;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.v.ArgumentDialogView;
import com.v.ArgumentSetDialogView;
import com.v.ClickConfigDialogView;
import com.v.FloatToast;
import com.v.ItemChooseDialogView;
import com.v.MultiClickChooseView;
import com.v.MultiClickDialogView;
import com.v.NodeListDialogView;
import com.yl.float_ui.InputDialogView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CoordItem extends BaseItemView implements View.OnClickListener {
    private TextView c;
    private TextView d;
    private Point e;
    private String f;

    public CoordItem(Context context) {
        super(context);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(MultiClickChooseView multiClickChooseView, View view) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(ClickConfigDialogView.class);
        com.frame.s0.g().u(MultiClickDialogView.class);
        com.frame.s0.g().u(ArgumentDialogView.class);
        com.frame.s0.g().u(ArgumentSetDialogView.class);
        setValue(multiClickChooseView.getPoint());
        com.frame.s0.g().d(MultiClickChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setInputHint("请输入变量名称");
        paramNameTextView.setInputLabel("坐标变量");
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.item.i2
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.l(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean i(String str) throws NumberFormatException {
        if (str.contains(",")) {
            try {
                int i2 = Integer.parseInt(str.split(",")[0]);
                int i3 = Integer.parseInt(str.split(",")[1]);
                this.f = null;
                if (this.e == null) {
                    this.e = new Point();
                }
                this.e.set(i2, i3);
                setValue(this.e);
                com.frame.s0.g().d(InputDialogView.class);
            } catch (Exception e) {
                com.frame.k0.r(e);
                FloatToast.i("请输入正确的坐标格式");
            }
        } else if (str.contains("${") && str.contains("}")) {
            l(str);
        } else {
            FloatToast.i("请输入正确的坐标格式");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            com.frame.s0.g().i(NodeListDialogView.class);
            com.frame.s0.g().i(ClickConfigDialogView.class);
            com.frame.s0.g().i(MultiClickDialogView.class);
            com.frame.s0.g().i(ArgumentDialogView.class);
            com.frame.s0.g().i(ArgumentSetDialogView.class);
            final MultiClickChooseView multiClickChooseView = (MultiClickChooseView) com.frame.s0.g().x(MultiClickChooseView.class);
            Point point = this.e;
            if (point != null) {
                multiClickChooseView.setDefaultPoint(point.x, point.y);
            }
            multiClickChooseView.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.e(multiClickChooseView, view);
                }
            });
            multiClickChooseView.setHit("请选择点击坐标");
            return;
        }
        if (i2 != 1) {
            return;
        }
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("坐标");
        if (this.e != null) {
            inputDialogView.w(this.e.x + "," + this.e.y);
        } else {
            inputDialogView.w(this.f);
        }
        inputDialogView.s("请输入点击坐标");
        inputDialogView.y("使用变量", new View.OnClickListener() { // from class: com.v.item.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(view);
            }
        });
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.item.m
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.i(str);
            }
        });
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
        TextView textView = (TextView) findViewById(j.b.e.K5);
        this.d = textView;
        textView.setText("点击坐标");
        TextView textView2 = (TextView) findViewById(j.b.e.Z5);
        this.c = textView2;
        textView2.setOnClickListener(this);
    }

    public String getParamName() {
        return this.f;
    }

    public boolean l(String str) {
        this.f = str;
        this.e = null;
        this.c.setText("坐标变量：" + str);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.Z5) {
            ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.setTitle("选择坐标");
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("屏幕上选取,输入坐标".split(","))));
            itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.k
                @Override // com.v.ItemChooseDialogView.b
                public final void a(int i2, List list) {
                    this.a.k(i2, list);
                }
            });
        }
    }

    public void setLabel(String str) {
        this.d.setText(str);
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
    }

    public void setValue(Point point) {
        this.e = point;
        this.f = null;
        this.c.setText("坐标：" + point.x + "," + point.y);
    }

    @Override // com.v.item.BaseItemView
    public Point getValue() {
        return this.e;
    }

    public CoordItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public CoordItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }
}

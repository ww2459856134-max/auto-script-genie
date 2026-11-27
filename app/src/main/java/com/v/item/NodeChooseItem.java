package com.v.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.v.ItemChooseDialogView;
import com.yl.model.Node;
import i.b.v8;
import i.b.x7;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NodeChooseItem extends BaseItemView implements View.OnClickListener {
    private TextView c;

    public NodeChooseItem(Context context) {
        super(context);
        c();
    }

    static /* synthetic */ String d(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.step);
        sb.append(".");
        sb.append(!TextUtils.isEmpty(node.name) ? node.name : x7.d().e(node.type).t());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(List list, List list2, int i2, List list3) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        this.c.setText((CharSequence) list2.get(i2));
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
    }

    @Override // com.v.item.BaseItemView
    public Object getValue() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.Z5) {
            final ArrayList arrayList = new ArrayList(v8.m().p().getNodeMap().values());
            final List<String> list = (List) arrayList.stream().map(new Function() { // from class: com.v.item.c1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return NodeChooseItem.d((Node) obj);
                }
            }).collect(Collectors.toList());
            ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.setDefaultData(-1, list);
            itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.d1
                @Override // com.v.ItemChooseDialogView.b
                public final void a(int i2, List list2) {
                    this.a.f(arrayList, list, i2, list2);
                }
            });
        }
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

    public NodeChooseItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NodeChooseItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.v.FloatToast;
import com.v.ItemChooseDialogView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MultiSelectItem extends BaseItemView implements View.OnClickListener {
    private LinkedHashMap c;
    protected TextView d;
    private TextView e;
    private a f;

    public interface a {
        void a(boolean z, int i2, Object obj, String str);
    }

    public MultiSelectItem(Context context) {
        super(context);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        this.d.setText(defpackage.g.a("@@", list));
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(true, i2, this.d.getText(), this.d.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str, View view) {
        b(str);
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.e = (TextView) findViewById(j.b.e.K5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.d = textView;
        textView.setOnClickListener(this);
    }

    @Override // com.v.item.BaseItemView
    public Object getValue() {
        return this.d.getText().toString();
    }

    public TextView getValueTextView() {
        return this.d;
    }

    public void h(LinkedHashMap<String, Object> linkedHashMap, List<String> list, ItemChooseDialogView.b bVar) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择" + this.e.getText().toString());
        itemChooseDialogView.setOnTextChoose(bVar);
        itemChooseDialogView.setCheckable();
        itemChooseDialogView.setMultiDefaultData(new ArrayList(linkedHashMap.keySet()), list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.Z5) {
            LinkedHashMap<String, Object> linkedHashMap = this.c;
            if (linkedHashMap == null) {
                FloatToast.i("列表为空");
            } else {
                h(linkedHashMap, Arrays.asList(this.d.getText().toString().toString().split("@@")), new ItemChooseDialogView.b() { // from class: com.v.item.b1
                    @Override // com.v.ItemChooseDialogView.b
                    public final void a(int i2, List list) {
                        this.a.e(i2, list);
                    }
                });
            }
        }
    }

    public void setHelp(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, j.b.d.L0, 0);
        this.e.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(str, view);
            }
        });
    }

    public void setHint(String str) {
        this.d.setHint(str);
    }

    public void setItems(String[] strArr) {
        this.c = new LinkedHashMap();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            this.c.put(strArr[i2], Integer.valueOf(i2));
        }
    }

    public void setLabel(String str) {
        this.e.setText(str);
    }

    public void setOnItemClick(a aVar) {
        this.f = aVar;
    }

    @Override // com.v.item.BaseItemView
    public void setRule(JSONObject jSONObject) {
        super.setRule(jSONObject);
        this.c = new LinkedHashMap();
        String strOptString = jSONObject.optString("label");
        jSONObject.optString(SocialConstants.PARAM_TYPE);
        jSONObject.optString("defaultValue");
        jSONObject.optString("hint");
        jSONObject.optString("unit");
        jSONObject.optString("inputType");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("item");
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            this.c.put(jSONObjectOptJSONObject.optString("name"), Integer.valueOf(jSONObjectOptJSONObject.optInt("value")));
        }
        ((TextView) findViewById(j.b.e.K5)).setText(strOptString);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.d = textView;
        textView.setOnClickListener(this);
    }

    public void setValue(String str) {
        this.d.setText(str);
    }

    public MultiSelectItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        String string3 = typedArrayObtainStyledAttributes.getString(j.b.h.e);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(j.b.h.f, 0);
        if (resourceId != 0) {
            setItems(typedArrayObtainStyledAttributes.getResources().getStringArray(resourceId));
        }
        setHelp(string3);
        setLabel(string);
        setHint(string2);
    }

    public void setItems(LinkedHashMap linkedHashMap) {
        this.c = linkedHashMap;
    }

    public MultiSelectItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

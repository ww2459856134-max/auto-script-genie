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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SelectItem extends BaseItemView implements View.OnClickListener {
    private View.OnClickListener A;
    private LinkedHashMap c;
    private LinkedHashMap<String, LinkedHashMap> d;
    protected TextView e;
    private TextView f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private a f1101h;

    /* renamed from: i, reason: collision with root package name */
    private a f1102i;

    /* renamed from: j, reason: collision with root package name */
    private Object f1103j;

    /* renamed from: k, reason: collision with root package name */
    private Object f1104k;
    private String t;

    public interface a {
        void a(boolean z, int i2, Object obj, String str);
    }

    public SelectItem(Context context) {
        super(context);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = (String) list.get(i2);
        this.t = str;
        this.f1103j = this.c.get(str);
        this.f1104k = null;
        this.e.setText(str);
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = this.d;
        if (linkedHashMap == null || !linkedHashMap.containsKey(str)) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            LinkedHashMap linkedHashMap2 = this.d.get(str);
            if (linkedHashMap2 != null && !linkedHashMap2.isEmpty()) {
                m(linkedHashMap2);
            }
        }
        a aVar = this.f1101h;
        if (aVar != null) {
            aVar.a(true, i2, this.f1103j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(String str, View view) {
        b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(LinkedHashMap linkedHashMap, int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = (String) list.get(i2);
        this.f1104k = linkedHashMap.get(str);
        this.f.setVisibility(0);
        this.f.setText(str);
        a aVar = this.f1102i;
        if (aVar != null) {
            aVar.a(true, i2, this.f1104k, str);
        }
    }

    private String k(TextView textView, LinkedHashMap linkedHashMap, Object obj, a aVar) {
        int iC = c(linkedHashMap, obj);
        if (iC <= -1) {
            textView.setText((CharSequence) null);
            return null;
        }
        String str = (String) new ArrayList(linkedHashMap.keySet()).get(iC);
        if (this.e.equals(textView)) {
            this.t = str;
        } else {
            this.f.equals(textView);
        }
        textView.setText(str);
        if (aVar != null) {
            aVar.a(false, iC, obj, str);
        }
        return str;
    }

    public int c(LinkedHashMap linkedHashMap, Object obj) {
        if (obj != null && linkedHashMap != null) {
            Iterator it = linkedHashMap.values().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public void d() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.g = (TextView) findViewById(j.b.e.K5);
        this.f = (TextView) findViewById(j.b.e.U5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.e = textView;
        textView.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public String getSelectLabel() {
        return this.e.getText().toString();
    }

    public String getSelectSubLabel() {
        return this.f.getText().toString();
    }

    public Object getSubValue() {
        return this.f1104k;
    }

    @Override // com.v.item.BaseItemView
    public Object getValue() {
        return this.f1103j;
    }

    public TextView getValueTextView() {
        return this.e;
    }

    public void l(LinkedHashMap<String, Object> linkedHashMap, Object obj, ItemChooseDialogView.b bVar) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择" + this.g.getText().toString());
        itemChooseDialogView.setDefaultData(c(linkedHashMap, obj), new ArrayList(linkedHashMap.keySet()));
        itemChooseDialogView.setOnTextChoose(bVar);
    }

    public void m(final LinkedHashMap linkedHashMap) {
        l(linkedHashMap, this.f1104k, new ItemChooseDialogView.b() { // from class: com.v.item.x1
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.j(linkedHashMap, i2, list);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != j.b.e.U5) {
            if (view.getId() == j.b.e.Z5) {
                LinkedHashMap<String, Object> linkedHashMap = this.c;
                if (linkedHashMap == null) {
                    FloatToast.i("列表为空");
                    return;
                } else {
                    l(linkedHashMap, this.f1103j, new ItemChooseDialogView.b() { // from class: com.v.item.v1
                        @Override // com.v.ItemChooseDialogView.b
                        public final void a(int i2, List list) {
                            this.a.f(i2, list);
                        }
                    });
                    return;
                }
            }
            return;
        }
        View.OnClickListener onClickListener = this.A;
        if (onClickListener != null) {
            onClickListener.onClick(view);
            return;
        }
        LinkedHashMap<String, LinkedHashMap> linkedHashMap2 = this.d;
        if (linkedHashMap2 == null) {
            FloatToast.i("列表为空");
        } else {
            if (linkedHashMap2 == null || !linkedHashMap2.containsKey(this.e.getText().toString())) {
                return;
            }
            m(this.d.get(this.e.getText().toString()));
        }
    }

    public void setHelp(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, j.b.d.L0, 0);
        this.g.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.h(str, view);
            }
        });
    }

    public void setHint(String str) {
        this.e.setHint(str);
    }

    public void setItems(String[] strArr) {
        this.c = new LinkedHashMap();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            this.c.put(strArr[i2], Integer.valueOf(i2));
        }
    }

    public void setLabel(String str) {
        this.g.setText(str);
    }

    public void setOnItemClick(a aVar) {
        this.f1101h = aVar;
    }

    public void setOnSubClickListener(View.OnClickListener onClickListener) {
        this.A = onClickListener;
    }

    public void setOnSubTextChoose(a aVar) {
        this.f1102i = aVar;
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
        this.e = textView;
        textView.setOnClickListener(this);
    }

    public void setSelectLabel(String str) {
        Integer num;
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap == null || (num = (Integer) linkedHashMap.get(str)) == null) {
            return;
        }
        this.f1103j = num;
        if (num.intValue() > -1) {
            this.e.setText(str);
            a aVar = this.f1101h;
            if (aVar != null) {
                aVar.a(false, num.intValue(), this.f1103j, str);
            }
        }
    }

    public void setSelectSubLabel(String str) {
        this.f.setVisibility(0);
        this.f.setText(str);
    }

    public void setSelectSubValue(Object obj) {
        this.f.setVisibility(0);
        this.f1104k = obj;
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = this.d;
        if (linkedHashMap == null || obj == null) {
            return;
        }
        k(this.f, linkedHashMap.get(this.t), obj, this.f1102i);
    }

    public void setSelectValue(Object obj) {
        this.f1103j = obj;
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap != null) {
            k(this.e, linkedHashMap, obj, this.f1101h);
        }
    }

    public void setSubHint(String str) {
        this.f.setHint(str);
    }

    public void setSubItems(LinkedHashMap<String, LinkedHashMap> linkedHashMap) {
        this.d = linkedHashMap;
    }

    public SelectItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
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

    public void setSelectValue(Object obj, Object obj2) {
        this.f1103j = obj;
        this.f1104k = obj2;
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap != null) {
            String strK = k(this.e, linkedHashMap, obj, this.f1101h);
            LinkedHashMap<String, LinkedHashMap> linkedHashMap2 = this.d;
            if (linkedHashMap2 == null || !linkedHashMap2.containsKey(strK)) {
                return;
            }
            this.f.setVisibility(0);
            k(this.f, this.d.get(strK), obj2, this.f1102i);
        }
    }

    public void setItems(LinkedHashMap linkedHashMap, LinkedHashMap<String, LinkedHashMap> linkedHashMap2) {
        this.c = linkedHashMap;
        this.d = linkedHashMap2;
    }

    public void setSelectValue(boolean z, Object obj, Object obj2) {
        this.f1103j = obj;
        this.f1104k = obj2;
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap != null) {
            String strK = k(this.e, linkedHashMap, obj, z ? this.f1101h : null);
            LinkedHashMap<String, LinkedHashMap> linkedHashMap2 = this.d;
            if (linkedHashMap2 == null || !linkedHashMap2.containsKey(strK)) {
                return;
            }
            this.f.setVisibility(0);
            k(this.f, this.d.get(strK), obj2, this.f1102i);
        }
    }

    public SelectItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

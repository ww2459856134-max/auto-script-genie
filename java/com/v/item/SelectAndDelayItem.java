package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.v.DelaySetDialogView;
import com.v.FloatToast;
import com.v.ItemChooseDialogView;
import com.yl.model.Delay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SelectAndDelayItem extends BaseItemView implements View.OnClickListener {
    private View.OnClickListener A;
    private TextView C;
    private DelayItem D;
    private a G;
    private a H;
    private b I;
    private LinkedHashMap c;
    private LinkedHashMap<String, LinkedHashMap> d;
    protected TextView e;
    private TextView f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private c f1097h;

    /* renamed from: i, reason: collision with root package name */
    protected c f1098i;

    /* renamed from: j, reason: collision with root package name */
    private Object f1099j;

    /* renamed from: k, reason: collision with root package name */
    private Object f1100k;
    private String t;

    public interface a {
        String a();
    }

    public interface b {
        void a(String str, String str2);
    }

    public interface c {
        void a(boolean z, int i2, Object obj, String str);
    }

    public SelectAndDelayItem(Context context) {
        super(context);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g() {
        startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i() {
        startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(String str, String str2) {
        this.D.setEditDelay(str, str2);
        new Delay(str, str2).bindTextView(this.C);
        b bVar = this.I;
        if (bVar != null) {
            bVar.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = (String) list.get(i2);
        this.t = str;
        this.f1099j = this.c.get(str);
        this.f1100k = null;
        this.e.setText(str);
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = this.d;
        if (linkedHashMap == null || !linkedHashMap.containsKey(str)) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            LinkedHashMap linkedHashMap2 = this.d.get(str);
            if (linkedHashMap2 != null && !linkedHashMap2.isEmpty()) {
                r(linkedHashMap2);
            }
        }
        c cVar = this.f1097h;
        if (cVar != null) {
            cVar.a(true, i2, this.f1099j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(LinkedHashMap linkedHashMap, int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = (String) list.get(i2);
        this.f1100k = linkedHashMap.get(str);
        this.f.setVisibility(0);
        this.f.setText(str);
        c cVar = this.f1098i;
        if (cVar != null) {
            cVar.a(true, i2, this.f1100k, str);
        }
    }

    private String p(TextView textView, LinkedHashMap linkedHashMap, Object obj, c cVar) {
        int iD = d(linkedHashMap, obj);
        if (iD <= -1) {
            textView.setText((CharSequence) null);
            return null;
        }
        String str = (String) new ArrayList(linkedHashMap.keySet()).get(iD);
        if (this.e.equals(textView)) {
            this.t = str;
        } else {
            this.f.equals(textView);
        }
        textView.setText(str);
        if (cVar != null) {
            cVar.a(false, iD, obj, str);
        }
        return str;
    }

    public boolean c() {
        if (getVisibility() != 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.e.getText())) {
            com.frame.l1.e(new Runnable() { // from class: com.v.item.u1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.g();
                }
            });
            return false;
        }
        if (this.f.getVisibility() != 0 || !TextUtils.isEmpty(this.f.getText())) {
            return true;
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.item.q1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i();
            }
        });
        return false;
    }

    public int d(LinkedHashMap linkedHashMap, Object obj) {
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

    public void e() {
        View.inflate(getContext(), j.b.f.Z0, this);
        this.C = (TextView) findViewById(j.b.e.p);
        this.g = (TextView) findViewById(j.b.e.K5);
        this.f = (TextView) findViewById(j.b.e.U5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.e = textView;
        textView.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.D = new DelayItem(com.frame.v0.g());
        this.C.setOnClickListener(this);
    }

    public String getSelectLabel() {
        return this.e.getText().toString();
    }

    public String getSelectSubLabel() {
        return this.f.getText().toString();
    }

    public Object getSubValue() {
        return this.f1100k;
    }

    @Override // com.v.item.BaseItemView
    public Object getValue() {
        return this.f1099j;
    }

    public TextView getValueTextView() {
        return this.e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.U5) {
            View.OnClickListener onClickListener = this.A;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            }
            LinkedHashMap<String, LinkedHashMap> linkedHashMap = this.d;
            if (linkedHashMap == null) {
                FloatToast.i("列表为空");
                return;
            } else {
                if (linkedHashMap == null || !linkedHashMap.containsKey(this.e.getText().toString())) {
                    return;
                }
                r(this.d.get(this.e.getText().toString()));
                return;
            }
        }
        if (view.getId() == j.b.e.p) {
            DelaySetDialogView delaySetDialogView = (DelaySetDialogView) com.frame.s0.g().B(DelaySetDialogView.class);
            a aVar = this.G;
            String strA = aVar != null ? aVar.a() : "";
            a aVar2 = this.H;
            delaySetDialogView.setDefaultValue(strA, aVar2 != null ? aVar2.a() : "0");
            delaySetDialogView.setISetDelay(new b() { // from class: com.v.item.r1
                @Override // com.v.item.SelectAndDelayItem.b
                public final void a(String str, String str2) {
                    this.a.k(str, str2);
                }
            });
            return;
        }
        if (view.getId() == j.b.e.Z5) {
            LinkedHashMap<String, Object> linkedHashMap2 = this.c;
            if (linkedHashMap2 == null) {
                FloatToast.i("列表为空");
            } else {
                q(linkedHashMap2, this.f1099j, new ItemChooseDialogView.b() { // from class: com.v.item.s1
                    @Override // com.v.ItemChooseDialogView.b
                    public final void a(int i2, List list) {
                        this.a.m(i2, list);
                    }
                });
            }
        }
    }

    public ItemChooseDialogView q(LinkedHashMap<String, Object> linkedHashMap, Object obj, ItemChooseDialogView.b bVar) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().B(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择" + this.g.getText().toString());
        itemChooseDialogView.setDefaultData(d(linkedHashMap, obj), new ArrayList(linkedHashMap.keySet()));
        itemChooseDialogView.setOnTextChoose(bVar);
        return itemChooseDialogView;
    }

    public void r(final LinkedHashMap linkedHashMap) {
        q(linkedHashMap, this.f1100k, new ItemChooseDialogView.b() { // from class: com.v.item.t1
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.o(linkedHashMap, i2, list);
            }
        });
    }

    public void setHint(String str) {
        this.e.setHint(str);
    }

    public void setISetDelay(b bVar) {
        this.I = bVar;
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

    public void setLowDelay(a aVar) {
        this.G = aVar;
    }

    public void setMaxDelay(a aVar) {
        this.H = aVar;
    }

    public void setOnItemClick(c cVar) {
        this.f1097h = cVar;
    }

    public void setOnSubClickListener(View.OnClickListener onClickListener) {
        this.A = onClickListener;
    }

    public void setOnSubTextChoose(c cVar) {
        this.f1098i = cVar;
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
        this.f1099j = num;
        if (num.intValue() > -1) {
            this.e.setText(str);
            c cVar = this.f1097h;
            if (cVar != null) {
                cVar.a(false, num.intValue(), this.f1099j, str);
            }
        }
    }

    public void setSelectSubLabel(String str) {
        this.f.setVisibility(0);
        this.f.setText(str);
    }

    public void setSelectSubValue(Object obj) {
        this.f.setVisibility(0);
        this.f1100k = obj;
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = this.d;
        if (linkedHashMap == null || obj == null) {
            return;
        }
        p(this.f, linkedHashMap.get(this.t), obj, this.f1098i);
    }

    public void setSelectValue(Object obj) {
        this.f1099j = obj;
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap != null) {
            p(this.e, linkedHashMap, obj, this.f1097h);
        }
        a aVar = this.G;
        if (aVar != null) {
            String strA = aVar.a();
            a aVar2 = this.H;
            String strA2 = aVar2 != null ? aVar2.a() : "0";
            this.D.setEditDelay(strA, strA2);
            new Delay(strA, strA2).bindTextView((TextView) findViewById(j.b.e.p));
        }
    }

    public void setSubHint(String str) {
        this.f.setHint(str);
    }

    public void setSubItems(LinkedHashMap<String, LinkedHashMap> linkedHashMap) {
        this.d = linkedHashMap;
    }

    public SelectAndDelayItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(j.b.h.f, 0);
        if (resourceId != 0) {
            setItems(typedArrayObtainStyledAttributes.getResources().getStringArray(resourceId));
        }
        setLabel(string);
        setHint(string2);
    }

    public void setItems(LinkedHashMap linkedHashMap) {
        this.c = linkedHashMap;
    }

    public void setItems(LinkedHashMap linkedHashMap, LinkedHashMap<String, LinkedHashMap> linkedHashMap2) {
        this.c = linkedHashMap;
        this.d = linkedHashMap2;
    }

    public void setSelectValue(Object obj, Object obj2) {
        this.f1099j = obj;
        this.f1100k = obj2;
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap != null) {
            String strP = p(this.e, linkedHashMap, obj, this.f1097h);
            LinkedHashMap<String, LinkedHashMap> linkedHashMap2 = this.d;
            if (linkedHashMap2 != null && linkedHashMap2.containsKey(strP)) {
                this.f.setVisibility(0);
                p(this.f, this.d.get(strP), obj2, this.f1098i);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public SelectAndDelayItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setSelectValue(boolean z, Object obj, Object obj2) {
        this.f1099j = obj;
        this.f1100k = obj2;
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap != null) {
            String strP = p(this.e, linkedHashMap, obj, z ? this.f1097h : null);
            LinkedHashMap<String, LinkedHashMap> linkedHashMap2 = this.d;
            if (linkedHashMap2 != null && linkedHashMap2.containsKey(strP)) {
                this.f.setVisibility(0);
                p(this.f, this.d.get(strP), obj2, this.f1098i);
            } else {
                this.f.setVisibility(8);
            }
        }
    }
}

package com.v.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.yl.widget.TabLinearLayout;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TabItem extends BaseItemView {
    private TabLinearLayout c;

    public TabItem(Context context) {
        super(context);
    }

    @Override // com.v.item.BaseItemView
    public Object getValue() {
        return Integer.valueOf(this.c.getSelectedTabViewId());
    }

    @Override // com.v.item.BaseItemView
    public void setRule(JSONObject jSONObject) {
        super.setRule(jSONObject);
        String strOptString = jSONObject.optString("label");
        jSONObject.optString(SocialConstants.PARAM_TYPE);
        String strOptString2 = jSONObject.optString("defaultValue");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("item");
        ((TextView) findViewById(j.b.e.b5)).setText(strOptString);
        TabLinearLayout tabLinearLayout = (TabLinearLayout) findViewById(j.b.e.m4);
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            String strOptString3 = jSONObjectOptJSONObject.optString("name");
            int iOptInt = jSONObjectOptJSONObject.optInt("value");
            TextView textView = new TextView(getContext());
            textView.setId(iOptInt);
            textView.setText(strOptString3);
            tabLinearLayout.addView(textView);
        }
        if (TextUtils.isEmpty(strOptString2)) {
            return;
        }
        tabLinearLayout.b(Integer.parseInt(strOptString2));
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TabItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

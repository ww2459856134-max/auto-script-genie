package com.jsj.autojs.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CouponListAdapter extends BaseQuickAdapter<JSONObject, BaseViewHolder> {
    public CouponListAdapter(List<JSONObject> list) {
        super(2131493057, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, JSONObject jSONObject) {
        String str;
        String strOptString = jSONObject.optString("code");
        int iOptInt = jSONObject.optInt("state");
        String strOptString2 = jSONObject.optString("label");
        baseViewHolder.setText(2131297169, strOptString);
        baseViewHolder.setText(2131297172, strOptString2 + "(￥" + (jSONObject.optInt("money") / 100.0f) + ")");
        baseViewHolder.setText(2131297175, jSONObject.optString("insertTime"));
        int i2 = -65536;
        if (iOptInt != 0) {
            if (iOptInt == 1) {
                str = jSONObject.optString("useTime") + " 已使用";
            } else if (iOptInt == 2) {
                str = "无效";
            } else if (iOptInt != 3) {
                str = "未知";
            } else {
                str = "使用中";
            }
            baseViewHolder.setText(2131297189, str);
            baseViewHolder.setTextColor(2131297189, i2);
        }
        str = "未使用";
        i2 = -7829368;
        baseViewHolder.setText(2131297189, str);
        baseViewHolder.setTextColor(2131297189, i2);
    }
}

package com.jsj.autojs.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tencent.cursor.R;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class StabilityAdapter extends BaseQuickAdapter<JSONObject, BaseViewHolder> {
    public StabilityAdapter(List<JSONObject> list) {
        super(2131493087, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("title");
        String strOptString2 = jSONObject.optString("content");
        baseViewHolder.setText(R.id.tv_title, strOptString);
        baseViewHolder.setText(R.id.tv_content, strOptString2);
    }
}

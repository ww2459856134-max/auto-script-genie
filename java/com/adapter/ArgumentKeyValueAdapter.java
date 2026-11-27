package com.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ArgumentKeyValueAdapter extends BaseItemDraggableAdapter<JSONObject, BaseViewHolder> {
    public ArgumentKeyValueAdapter(List<JSONObject> list) {
        super(j.b.f.M0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, JSONObject jSONObject) {
        baseViewHolder.setText(j.b.e.H5, jSONObject.optString("key"));
        baseViewHolder.setText(j.b.e.Z5, jSONObject.optString("option"));
        baseViewHolder.addOnClickListener(j.b.e.O0);
        baseViewHolder.setGone(j.b.e.h1, true);
    }
}

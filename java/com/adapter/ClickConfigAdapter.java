package com.adapter;

import android.graphics.Point;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v.item.CoordItem;
import java.util.List;

/* loaded from: classes.dex */
public class ClickConfigAdapter extends BaseQuickAdapter<Point, BaseViewHolder> {
    public ClickConfigAdapter(List<Point> list) {
        super(j.b.f.D0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Point point) {
        ((CoordItem) baseViewHolder.getView(j.b.e.i2)).setValue(point);
    }
}
